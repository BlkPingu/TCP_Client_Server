package Objects;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CargoTest {

    Cargo cargo;
    HashSet<Hazard> hazardHashSet1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        hazardHashSet1 = new HashSet<>();

        hazardHashSet1.add(Hazard.toxic);

        cargo = new Cargo(hazardHashSet1);
    }

    @org.junit.jupiter.api.Test
    void getSize() {
        assertEquals(1, cargo.getHazard().size());
    }
}