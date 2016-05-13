package mips;

import java.util.*;

public class InstructionMemory {

    public static String[] Instruction = new String[1000];
    int line = 0;

    // address of reg in the memory
    private int[] rsAddress = new int[5];
    private int[] rtAddress = new int[5];
    private int[] rdAddress = new int[5];
    private int[] SignExtend = new int[16];
    private int[] ControlUnit = new int[6];
    private int[] ALUControl = new int[6];
    private int address ;

    int[] ins = new int[32];

    public InstructionMemory(int address) {
       this.address = address;
        if (address==0) 
              this.ins = Constants.Instructions[address].getInstructionBinary();
        else
              this.ins = Constants.Instructions[(address-Constants.FristAddress)/4].getInstructionBinary();
        
         // Set frist 16 bit to sigeExtend
        for (int i = 0; i < 16; i++) {
            SignExtend[i] = ins[i];
        }
        // set frist  5 bit for ALU control [0 - 5]
        for (int i = 0; i < 6; i++) {
            ALUControl[i] = ins[i];
        }
        // set [11 - 15 ] for rd
        for (int i = 11; i < 16; i++) {
            int j = 0;
            rsAddress[j] = ins[i];
            j++;
        }
        // set [16 - 20] for  rt 
        for (int i = 16; i < 21; i++) {
            int j = 0;
            rtAddress[j] = ins[i];
            j++;
        } // set [16 - 20] for  rt 
        for (int i = 21; i < 26; i++) {
            int j = 0;
            rsAddress[j] = ins[i];
            j++;
        } // set [26 - 31] for ControlUnit
        for (int i = 26; i < 32; i++) {
            int j = 0;
            ControlUnit[j] = ins[i];
            j++;
        }

    }

    public int[] getRT() {
        return this.rtAddress;
    }

    public int[] getRD() {
        return this.rdAddress;
    }

    public int[] getRS() {
        return this.rsAddress;
    }

    public int[] getALUControl() {
        return this.ALUControl;
    }

    public int[] getSignExtend() {
        return this.SignExtend;
    }

    public int[] getControlUnit() {
        return this.ControlUnit;
    }
    public int getAddress (){
    return this.address ;
    }
}
