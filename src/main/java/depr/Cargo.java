package depr;

import java.io.Serializable;
import java.util.HashSet;

public class Cargo implements Serializable {

    static final long serialVersionUID=1L;
    private HashSet<Hazard> hazard;


    public Cargo(HashSet<Hazard> hazard) {
        this.hazard = hazard;
    }

    public HashSet<Hazard> getHazard() {
        return hazard;
    }

    @Override
    public String toString(){
        return this.hazard.toString();
    }

}