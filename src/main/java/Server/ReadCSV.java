package Server;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReadCSV {
    //tutorial source: https://www.baeldung.com/opencsv

    static String csvFile = "/Users/mkyong/csv/country3.csv";

    static CSVReader reader = null;



    //add exception for missing date, date format may be not compatible with csv

    public static List<Integer> readTempsByDate(SimpleDateFormat date){
        List<Integer> result = null;

        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null && !line[0].equals(date.toString())) {

                for(int i=1; i <= line.length;i++){
                    result.add(Integer.parseInt(line[i]));
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
