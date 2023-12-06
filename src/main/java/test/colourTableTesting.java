package test;
import org.example.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Class to test the ColourClass
public class colourTableTesting {

    // test if the size of the palette is valid
    @Test
    void TestValidPaletteSize(){assertDoesNotThrow(() -> new ColourTable(4));}


    // test if the size of the palette is not valid
    @Test
    void TestInvalidPaletteSize(){
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(13));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1035));
    }


    // test if you can add a valid colour (red, green, blue)
    @Test
    void TestAddValidColour(){
        ColourTable colourTable = new ColourTable(4);
        assertDoesNotThrow(() -> colourTable.add(0xFF0000)); //red
        assertDoesNotThrow(() -> colourTable.add(0x00FF00)); //green
        assertDoesNotThrow(() -> colourTable.add(0x0000FF)); //blue
    }


    // test if you can add an invalid colour
    @Test
    void TestAddInvalidColour(){
        ColourTable colourTable = new ColourTable(4);
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(0x1234567)); //invalid rgb value
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(-1)); //negative rgb value
    }


    // test if the capacity is exceeded
    @Test
    void TestAddExceedCapacity(){
        ColourTable colourTable = new ColourTable(2);
        assertDoesNotThrow(() -> colourTable.add(0xFF0000));
        assertDoesNotThrow(() -> colourTable.add(0x00FF00));
        assertThrows(IllegalStateException.class, () -> colourTable.add(0x0000FF));
    }


    // test if you can add multiple colours
    @Test
    void TestAddMultipleColour(){
        ColourTable colourTable = new ColourTable(2);
        assertDoesNotThrow(() -> colourTable.add(0xFF0000));
        assertDoesNotThrow(() -> colourTable.add(0x00FF00));
        //assertDoesNotThrow(() -> colourTable.add(0x0000FF));
        assertThrows(IllegalStateException.class, () -> colourTable.add(0x0000FF));
    }


    // test if you can add a duplicate of a colour already in the palette
    @Test
    void AddDuplicateColour(){
        ColourTable colourTable = new ColourTable(4);
        assertDoesNotThrow(() -> colourTable.add(0xFF0000));
        assertThrows(IllegalStateException.class, () -> colourTable.add(0xFF0000));
    }


    @Test
    void TestPaletteString(){
        ColourTable colourTable = new ColourTable(4);
        assertDoesNotThrow(() -> colourTable.add(0xFF0000)); //red
        assertDoesNotThrow(() -> colourTable.add(0x00FF00)); //green
        assertDoesNotThrow(() -> colourTable.add(0x0000FF)); //blue
        assertEquals("ColourTable{PalSize=4, palette=[16711680, 65280, 255, 0]}", colourTable.toString());
    }


    // test when the palette is empty
    @Test
    void TestEmptyPaletteString(){
        ColourTable colourTable = new ColourTable(2);
        assertEquals("ColourTable{PalSize=2, palette=[0, 0]}", colourTable.toString());
    }
}