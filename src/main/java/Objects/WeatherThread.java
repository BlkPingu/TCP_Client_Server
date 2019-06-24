package Objects;

import Server.ServerUtility;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WeatherThread extends Thread {

    private ObjectOutputStream toClient;
    private ObjectInputStream fromClient;

    public WeatherThread(ObjectOutputStream toClient, ObjectInputStream fromClient){
        this.toClient = toClient;
        this.fromClient = fromClient;
    }

    @Override
    public void run() {
        try {
            ServerUtility.computeDate(toClient, fromClient);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
