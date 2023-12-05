package test;
import org.example.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColourTableTesting {
    @Test
    void TestValidPaletteSize(){assertDoesNotThrow(() -> new ColourTable(PalSize: 4));}

    @Test
    void TestInvalidPaletteSize(){
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(PalSize: 3));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(PalSize: 1025));
    }

    @Test
    void TestAddValidColour(){
        ColourTable colourTable = new ColourTable(PalSize: 4);
        assertDoesNotThrow(() -> colourTable.add(0xFF0000)); //red
        assertDoesNotThrow(() -> colourTable.add(0x00FF00)); //green
        assertDoesNotThrow(() -> colourTable.add(0x0000FF)); //blue
    }

    @Test
    void TestAddInvalidColour(){
        ColourTable colourTable = new ColourTable(PalSize: 4);
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(0x1234567)); //invalid rgb value
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(-1)); //negative rgb value
    }

    @Test
    void TestAddExceedCapacity(){
        ColourTable colourTable = new ColourTable(PalSize: 2);
        assertDoesNotThrow(() -> colourTable.add(0xFF0000));
        assertDoesNotThrow(() -> colourTable.add(0x00FF00));
        assertThrows(IllegalStateException.class, () -> colourTable.add(0x0000FF));
    }

    @Test
    void TestAddMultipleColour(){
        ColourTable colourTable = new ColourTable(PalSize: 3);
        assertDoesNotThrow(() -> colourTable.add(0xFF0000));
        assertDoesNotThrow(() -> colourTable.add(0x00FF00));
        assertDoesNotThrow(() -> colourTable.add(0x0000FF));
        assertThrows(IllegalStateException.class, () -> colourTable.add(0xFFFF00));
    }

    @Test
    void AddDuplicateColour(){
        ColourTable colourTable = new ColourTable(PalSize: 4);
        assertDoesNotThrow(() -> colourTable.add(0xFF0000));
        assertThrows(IllegalStateException.class, () -> colourTable.add(0xFF0000));
    }

}
