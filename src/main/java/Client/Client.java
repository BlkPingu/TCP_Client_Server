package Client;


// File Name GreetingClient.java

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client extends Thread {

    private Client() {
    }

    public void run() {
        int serverPort = 4020;
        Socket socket = null;
        ObjectOutputStream toServer;
        ObjectInputStream fromServer;
        Scanner sc = new Scanner(System.in);


            try {
                InetAddress serverHost = InetAddress.getByName("localhost");
                System.out.println("Client | " + "Connecting to server on port " + serverPort);
                socket = new Socket(serverHost, serverPort);
                System.out.println("Client | " + "Just connected to " + socket.getRemoteSocketAddress());
                toServer = new ObjectOutputStream(socket.getOutputStream());
                fromServer = new ObjectInputStream(socket.getInputStream());
                while (true) {



                    ClientUtility.dialogInClient();

                    switch (ClientUtility.enterOption(sc)) {
                        case 0:
                            ClientUtility.dialogHazard();
                            ClientUtility.add(toServer, fromServer, ClientUtility.newCargoInClient(sc));
                            break;
                        case 1:
                            ClientUtility.dialogHazard();
                            ClientUtility.remove(toServer, fromServer, ClientUtility.newCargoInClient(sc));
                            break;
                    }
                }
            }
            catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            } finally {
                if(socket != null) {
                    try {
                        socket.close();
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

    public static void main(String[] args) {
        Thread t = new Client();
        t.start();
    }
}