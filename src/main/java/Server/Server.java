package Server;
// File Name GreetingServer.java
import depr.Warehouse;

import java.net.*;
import java.io.*;

public class Server extends Thread {
    public void run() {
        int serverPort = 4020;
        ServerSocket serverSocket;
        ObjectOutputStream toClient;
        ObjectInputStream fromClient;
        Warehouse warehouse;


        try {
            warehouse = new Warehouse();
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Waiting for Client");

            Socket socket = serverSocket.accept();
            System.out.println("Server | Just connected to " + socket.getRemoteSocketAddress());
            toClient = new ObjectOutputStream(socket.getOutputStream());
            fromClient = new ObjectInputStream(socket.getInputStream());
            while(true) {

                int code = (Integer) fromClient.readObject();
                switch (code) {
                    case 0:
                        //add
                        ServerUtility.add(toClient, fromClient, warehouse);
                        break;
                    case 1:
                        //remove
                        ServerUtility.remove(toClient, fromClient, warehouse);
                        break;
                    default:
                        System.out.println("Server | command: " + code);
                        System.out.println("Server | ERROR! Something weird happened!");
                        System.exit(1);
                        break;

                }
            }
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Thread t = new Server();
        t.start();
    }
}