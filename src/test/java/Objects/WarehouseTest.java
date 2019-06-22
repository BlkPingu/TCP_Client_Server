package Objects;

import depr.Cargo;
import depr.Hazard;
import depr.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    Warehouse warehouse;

    private Cargo cargoMax;
    private Cargo cargoMin;
    private Cargo cargoNorm;
    private Cargo cargoTest;

    HashSet<Hazard> hazardHashSet0;
    HashSet<Hazard> hazardHashSet1;
    HashSet<Hazard> hazardHashSet2;
    HashSet<Hazard> hazardHashSet3;


    @BeforeEach
    void setUp() {

        warehouse = new Warehouse();




        hazardHashSet0 = new HashSet<>();
        hazardHashSet1 = new HashSet<>();
        hazardHashSet2 = new HashSet<>();
        hazardHashSet3 = new HashSet<>();


        cargoNorm = new Cargo(hazardHashSet0);
        cargoMin = new Cargo(hazardHashSet1);

        cargoMax = new Cargo(hazardHashSet2);

        cargoTest = new Cargo(hazardHashSet3);


        hazardHashSet1.add(Hazard.toxic);
        hazardHashSet2.add(Hazard.toxic);
        hazardHashSet2.add(Hazard.explosive);

        hazardHashSet3.add(Hazard.explosive);
        hazardHashSet3.add(Hazard.flammable);

    }

    //impossible case, 0 hazards
    @Test
    void addSingleCargo() {
        assertEquals(0, warehouse.getCargoList().size());

        warehouse.addSingleCargo(cargoNorm);
        assertEquals(1, warehouse.getCargoList().size());
    }


    //two hazards
    @Test
    void addSingleCargo2() {
        assertEquals(0, warehouse.getCargoList().size());

        warehouse.addSingleCargo(cargoMax);
        assertEquals(1, warehouse.getCargoList().size());
    }


    //one hazard
    @Test
    void addSingleCargo3() {
        assertEquals(0, warehouse.getCargoList().size());

        warehouse.addSingleCargo(cargoMin);
        assertEquals(1, warehouse.getCargoList().size());
    }


    @Test
    void removeSingle() {
        warehouse.addSingleCargo(cargoNorm);
        assertEquals(1, warehouse.getCargoList().size());

        warehouse.removeSingle(cargoNorm);
        assertEquals(0, warehouse.getCargoList().size());
    }

    @Test
    void removeSingle2() {
        warehouse.addSingleCargo(cargoMax);
        assertEquals(1, warehouse.getCargoList().size());

        warehouse.removeSingle(cargoMax);
        assertEquals(0, warehouse.getCargoList().size());
    }

    @Test
    void removeSingle3() {
        warehouse.addSingleCargo(cargoMin);
        assertEquals(1, warehouse.getCargoList().size());

        warehouse.removeSingle(cargoMin);
        assertEquals(0, warehouse.getCargoList().size());
    }

    @Test
    void getListSize() {
        warehouse.addSingleCargo(cargoNorm);
        assertEquals(1, warehouse.getCargoList().size());
    }

    @Test
    void getListSize2() {
        assertEquals(0, warehouse.getCargoList().size());
    }

    @Test
    void getListSize3() {
        warehouse.addSingleCargo(null);
        assertEquals(0, warehouse.getCargoList().size());
    }

    @Test
    void getCargoList() {
        ArrayList<Cargo> cargo = new ArrayList<>();
        assertEquals(cargo, warehouse.getCargoList());
    }

    @Test
    void getCargoList2() {
        ArrayList<Cargo> cargo = new ArrayList<>();
        cargo.add(cargoNorm);
        warehouse.addSingleCargo(cargoNorm);
        assertEquals(cargo, warehouse.getCargoList());
    }
}