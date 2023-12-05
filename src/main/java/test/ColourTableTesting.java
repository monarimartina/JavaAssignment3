package test;
import org.example.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColourTableTesting {
    @Test
    void TestValidPaletteSize(){assertDoesNotThrow(() -> new ColourTable(Size: 4));}

    @Test
    void TestInvalidPaletteSize(){
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(Size: 3));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(Size: 1025));
    }
}
