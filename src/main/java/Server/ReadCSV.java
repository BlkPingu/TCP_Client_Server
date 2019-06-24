package Server;

import com.opencsv.CSVReader;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.apple.eio.FileManager.getResource;

public class ReadCSV {
    //tutorial source: https://www.baeldung.com/opencsv


    static CSVReader reader = null;

    static List<Integer> readTempsByDate(Date date){
        List<Integer> result = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {

            // 2018-01-07

            String resource = "weatherData.csv";
            String fileName = ReadCSV.class.getClassLoader().getResource(resource).getFile();
            reader = new CSVReader(new FileReader(fileName));
            String[] line;

            reader.readNext();
            while ((line = reader.readNext()) != null) {
                if(line[0].equals(formatter.format(date))){
                    for(int i=1; i < line.length;i++){

                        //System.out.println("Cell: " + line[i]);
                        result.add(Integer.parseInt(line[i]));
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


}
