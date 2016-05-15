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
    private int address;
    private String Operation;
    private String Label;
    private String ToJump;

    private Instruction ins;

    public InstructionMemory(int address) {
        this.ins = Constants.Instructions[0];
        this.rsAddress = ins.rsAddressBinary;
        this.rdAddress = ins.rdAddressBinary;
        this.rtAddress = ins.rtAddressBinary;
        this.ALUControl = ins.FunctionBinary;
        this.ControlUnit = ins.OperationBinary;
        this.Operation=ins.opration;
        this.Label=ins.label;
        this.ToJump=ins.JumpTo;
        for (int i = 31,j = 15; i > 16;j--, i--) {
            this.SignExtend[j] = ins.InstructionBinary[i];
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

    public int getAddress() {
        return this.address;
    }
    
    public String getOperation() {
        return this.Operation;
    }
    
    public String getLabel() {
        return this.Label;
    }
    
    public String getToJump() {
        return this.ToJump;
    }
    
    public void getInstruction(int index){
        
        this.ins = Constants.Instructions[index];
        this.rsAddress = ins.rsAddressBinary;
        this.rdAddress = ins.rdAddressBinary;
        this.rtAddress = ins.rtAddressBinary;
        this.ALUControl = ins.FunctionBinary;
        this.ControlUnit = ins.OperationBinary;
        this.Operation=ins.opration;
        this.Label=ins.label;
        for (int i = 31,j = 15; i > 16;j--, i--) {
            this.SignExtend[j] = ins.InstructionBinary[i];
        }
        this.ToJump=ins.JumpTo;
        Console.address+=4;
    }
}
