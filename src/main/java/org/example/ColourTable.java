package org.example;
import java.util.Arrays;

public class ColourTable {
    private final int PalSize;
    private final int[] palette;
    private int Index;

    public ColourTable(int PalSize){
        // if the size of teh palette is not valid then print a message
        if (!ValidPaletteSize(PalSize)){
            throw new IllegalArgumentException("Invalid palette size!");
        }
        this.PalSize = PalSize;
        this.palette = new int[PalSize];
        this.Index = 0;
    }

    public void add(int rgbValue){
        // if the index is bigger than the size of the palette then we exceeded the capacity of the palette
        if (Index >= PalSize){
            throw new IllegalStateException("Exceeded the capacity of the ColourTable");
        }
        // if the value inserted is not a valid RGB value, then we print a message
        if (!Validrgb(rgbValue)){
            throw new IllegalArgumentException("Invalid RGB value");
        }
        palette[Index++] = rgbValue;
    }

    private boolean ValidPaletteSize(int size){
        return size>1 && size<= 1024 && (size & (size-1)) == 0;
    }

    private boolean Validrgb(int rgbVal){
        return rgbVal >= 0 && rgbVal <= 0xFFFFFF;
    }

    @Override
    public String toString(){
        return "ColourTable{" + "PalSize=" + PalSize + ", palette=" + Arrays.toString(palette) + "}";
    }
}
