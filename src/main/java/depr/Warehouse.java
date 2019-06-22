package depr;

import java.util.ArrayList;
import java.util.HashSet;

public class Warehouse {
    private ArrayList<Cargo> cargoList = new ArrayList<>();

    private boolean check2HazardsMax(){

        HashSet<Hazard> hazardSet = new HashSet<>();

        cargoList.forEach(c -> c.getHazard().addAll(hazardSet));
        if(hazardSet.size() >= 2){
            return false;
        }else return true;
    }

    public boolean addSingleCargo(Cargo cargo){
        if(cargo != null){
            cargoList.add(cargo);
            return check2HazardsMax();
        }else{
            System.out.println("Cargo Null");
            return false;
        }
    }

    public boolean removeSingle(Cargo cargo){
        if(cargo != null){
            cargoList.remove(cargo);
            return true;
        }else{
            System.out.println("Cargo Null");
            return false;
        }
    }

    public ArrayList<Cargo> getCargoList() {
        return cargoList;
    }
}
