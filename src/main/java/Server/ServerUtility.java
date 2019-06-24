package Server;

import Objects.WeatherDay;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;

public class ServerUtility {

    static void computeDate(ObjectOutputStream toClient, ObjectInputStream fromClient) throws IOException, ClassNotFoundException {
        System.out.println("Server | command: computeDate");
        Date date = (Date) fromClient.readObject();
        WeatherDay result = readCSV(date);

        if(result.getTemps() != null){
            toClient.writeObject("Server to Client | " + result.toString());
            toClient.flush();
        }else {
            toClient.writeObject("Server to Client | No data for" + date);
            toClient.flush();
        }
    }

    private static WeatherDay readCSV(Date date){
        List<Integer> csvData = ReadCSV.readTempsByDate(date);
        return new WeatherDay(date, csvData);
    }



}
