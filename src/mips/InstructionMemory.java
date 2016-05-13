package mips;

import java.util.*;

public class InstructionMemory {

    public static String[] Instruction = new String[1000];
    int line = 0;

    // address of reg in the memory
    int[] rsAddress = new int[5];
    int[] rtAddress = new int[5];
    int[] rdAddress = new int[5];
    int[] SignExtend = new int[16];
    int[] ControlUnit = new int[6];
    int[] ALUControl = new int[6];
    
    int [] ins = new int [32] ;

    public InstructionMemory(int[] Instruction) {
        this.ins = Instruction;
        for (int i = 0; i < 16; i++) {
            SignExtend[i] = ins[i];
        }
        for (int i = 0; i < 6; i++) {
            ALUControl[i] = ins[i];
        }
        for (int i = 11; i < 16; i++) {
            int j = 0;
            rsAddress[j] = ins[i];
            j++;
        }
        for (int i = 16; i < 21; i++) {
            int j = 0;
            rdAddress[j] = ins[i];
            j++;
        }
        for (int i = 21; i < 26; i++) {
            int j = 0;
            rtAddress[j] = ins[i];
            j++;
        }
        for (int i = 26; i < 32; i++) {
            int j = 0;
            ControlUnit[j] = ins[i];
            j++;
        }

    }

    public int [] getRT() {
        return this.rtAddress;
    }

    public int[] getRD() {
        return this.rdAddress ;
    }

    public int [] getRS() {
        return this.rsAddress;
    }

    public int[] getALUControl() {
        return this.ALUControl;
    }
    public int [] getSignExtend (){
    return this.SignExtend;
    }
    public int [] getControlUnit (){
    return this.ControlUnit;
    }

}
