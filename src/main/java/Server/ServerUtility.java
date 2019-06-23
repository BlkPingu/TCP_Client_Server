package Server;

import Objects.WeatherDay;
import com.opencsv.CSVReader;
import depr.Cargo;
import depr.Warehouse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ServerUtility {




    static void add(ObjectOutputStream toClient, ObjectInputStream fromClient, Warehouse warehouse) throws IOException, ClassNotFoundException {
        System.out.println("Server | command: add");
        Cargo newCargo = (Cargo) fromClient.readObject();

        if(warehouse.addSingleCargo(newCargo)){
            toClient.writeObject("Server to Client | New List after add: " + warehouse.getCargoList().toString());
        }else toClient.writeObject("Server to Client | Too many hazards. Remove Objects");
    }

    static void remove(ObjectOutputStream toClient, ObjectInputStream fromClient, Warehouse warehouse) throws IOException, ClassNotFoundException {
        System.out.println("Server | command: remove");
        Cargo deleted = (Cargo) fromClient.readObject();
        Cargo deleteThis = warehouse.getCargoList()
                .stream()
                .filter(e -> e.getHazard().equals(deleted.getHazard()))
                .findFirst()
                .orElse(null);

        if(deleteThis != null){
            warehouse.removeSingle(deleteThis);
            toClient.writeObject("Server to Client | New List after remove: "+warehouse.getCargoList().toString());
            toClient.flush();
        }else {
            toClient.writeObject("Server to Client | No such Object found");
            toClient.flush();
        }
    }

    public static WeatherDay readCSV(SimpleDateFormat date){
        List<Integer> csvData = ReadCSV.readTempsByDate(date);
        return new WeatherDay(date, csvData);
    }



}
