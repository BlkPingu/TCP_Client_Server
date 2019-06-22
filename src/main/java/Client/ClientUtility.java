package Client;

import depr.Cargo;
import depr.Hazard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;

class ClientUtility {

    private static void sendCode(ObjectOutputStream toServer, int code) throws IOException {
        toServer.writeObject(code);
        toServer.flush();
    }

    static void add(ObjectOutputStream toServer, ObjectInputStream fromServer, Cargo cargo ) throws IOException, ClassNotFoundException {
        sendCode(toServer, 0);
        System.out.println("Client | command: add");

        toServer.writeObject(cargo);
        toServer.flush();

        System.out.println("Server to Client | "+  fromServer.readObject());
    }

    static void remove(ObjectOutputStream toServer, ObjectInputStream fromServer, Cargo cargo) throws IOException, ClassNotFoundException {
        sendCode(toServer, 1);
        System.out.println("Client | command: remove");

        toServer.writeObject(cargo);
        toServer.flush();

        System.out.println("Server to Client | " + fromServer.readObject());
    }

    static void dialogInClient(){
        System.out.println("Client | [0] Add");
        System.out.println("Client | [1] Remove");
    }

    static void dialogHazard(){
        System.out.println("Client | [1] explosive");
        System.out.println("Client | [2] flammable");
        System.out.println("Client | [3] toxic");
        System.out.println("Client | [4] exit");
    }



    static Cargo newCargoInClient(Scanner scanner){

        HashSet<Hazard> hazardHashSet = new HashSet<>();



        boolean done = false;
        while(!done){



            if(hazardHashSet.size() >= 2) {
                System.out.println("Client | 2 Hazards Max, 1 Hazard Min");
                done = true;
                System.out.println("Client | done");
            }
            switch(scanner.nextInt()){
                case 1: {
                    hazardHashSet.add(Hazard.explosive);
                    System.out.println(hazardHashSet);
                }
                break;
                case 2: {
                    hazardHashSet.add(Hazard.flammable);
                    System.out.println(hazardHashSet);
                }
                break;
                case 3: {
                    hazardHashSet.add(Hazard.toxic);
                    System.out.println(hazardHashSet);
                }
                break;
                case 4: {
                    if(hazardHashSet.size() < 1){
                        System.out.println("Client | enter min one hazard before exiting");
                    }else done = true;
                    System.out.println("Client | done");
                }
                break;
                default:
                    System.out.println("Client | enter min one hazard before exiting");

            }
        }
        return new Cargo (hazardHashSet);
    }



    static int enterOption(Scanner scanner){
        System.out.println("Client | Enter Option [int]: ");
        return scanner.nextInt();
    }



}
