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
    private int AddressToJump;
    public String Format;

    int LineToJump=0; //line that branch jump to

    private Instruction ins;

    public void setInstructionMemory(int address) {
        System.out.println("Address error: "+address);
        this.ins = Constants.Instructions[(address-Console.FAddress)/4];
        if(ins.opration.equals("end")){
        
        }
        else{
        this.rsAddress = ins.rsAddressBinary;
        this.rdAddress = ins.rdAddressBinary;
        this.rtAddress = ins.rtAddressBinary;
        this.ALUControl = ins.FunctionBinary;
        this.ControlUnit = ins.OperationBinary;
        this.Operation=ins.opration;
        this.Label=ins.label;
        this.ToJump=ins.JumpTo;
        this.line=ins.line;
        this.SignExtend = ins.constantBinary;
        if(Operation.equals("beq")||Operation.equals("bne")){
            //calculate the line that branch jump to
            this.calcLine(address);
            ins.LineToJump=this.LineToJump;
        }
        if(Operation.equals("j")||Operation.equals("jal")||Operation.equals("jr")){
            this.getJumpAddress();
        }
        this.Format=ins.of;
        
        
        } 
        Console.address+=4;
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
    
    public int getAddressToJump() {
        return this.AddressToJump;
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
        this.line=ins.line;
        for (int i = 31,j = 15; i > 16;j--, i--) {
            this.SignExtend[j] = ins.InstructionBinary[i];
        }
        this.ToJump=ins.JumpTo;
        
        if(Operation.equals("beq")||Operation.equals("bne")){
            this.calcLine(address);
            ins.LineToJump=this.LineToJump;
        }
        
        if(Operation.equals("j")||Operation.equals("jal")||Operation.equals("jr")){
            this.getJumpAddress();
        }
            this.Format=ins.of;
            Console.address+=4;
    }
    //Function to calculate how many lines we need to jump
    public void calcLine(int address){
        if(this.Operation.equals("beq")||this.Operation.equals("bne")){
            int L2=Constants.l.SearchLine(ToJump);
            this.LineToJump=L2-this.line;
        }
    }
    //Function to get address to jump
    public void getJumpAddress(){
            this.AddressToJump=Constants.l.SearchAddress(ToJump);
            System.out.println("AddressToJump: "+AddressToJump);
            ins.AddressToJump=this.AddressToJump;
    }
}
