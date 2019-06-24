package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class ClientUtility {

    static Scanner myObj;


    private static void sendCode(ObjectOutputStream toServer, int code) throws IOException {
        toServer.writeObject(code);
        toServer.flush();
    }

    static void newRequest(ObjectOutputStream toServer, ObjectInputStream fromServer, Date date) throws IOException, ClassNotFoundException {
        sendCode(toServer, 0);

        toServer.writeObject(date);
        toServer.flush();

        System.out.println("Server to Client | "+  fromServer.readObject());
    }

    static Date newDate(Scanner scanner) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
    }

    static void dialogInClient(){
        System.out.print("Client | Enter Date: ");
    }




}
