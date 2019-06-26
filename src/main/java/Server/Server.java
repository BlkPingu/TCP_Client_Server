package Server;
import Objects.WeatherThread;

import java.net.*;
import java.io.*;

public class Server extends Thread {
    public void run() {
        int serverPort = 4020;
        ServerSocket serverSocket;
        ObjectOutputStream toClient;
        ObjectInputStream fromClient;


        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Waiting for Client");

            Socket socket = serverSocket.accept();
            System.out.println("Server | Just connected to " + socket.getRemoteSocketAddress());
            toClient = new ObjectOutputStream(socket.getOutputStream());
            fromClient = new ObjectInputStream(socket.getInputStream());
            while(true) {


                // 2018-01-07

                int code = (Integer) fromClient.readObject();

                switch (code) {
                    case 0:


                        //ServerUtility.computeDate(toClient, fromClient);
                        Thread weatherThread = new WeatherThread(toClient, fromClient);

                        weatherThread.start();

                        //gigantische Kruecke
                        sleep(10);

                        break;
                    default:
                        System.out.println("Server | command: " + code);
                        System.out.println("Server | ERROR! Something weird happened!");
                        System.exit(1);
                        break;

                }
            }
        }
        catch(IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Thread t = new Server();
        t.start();
    }
}