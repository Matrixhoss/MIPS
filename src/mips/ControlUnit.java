
package mips;

import java.util.Arrays;

public class ControlUnit {
    public String input;
    public boolean RegDest;
    public boolean Branch;
    public boolean MemRead;
    public boolean MemtoReg;
    public String ALUOp;
    public boolean ALUSrc;
    public boolean MemWrite;
    public boolean RegWrite;

//        this.RegDest;
//        this.Branch;
//        this.MemRead;
//        this.MemtoReg;
//        this.ALUOp;
//        this.ALUSrc;
//        this.MemWrite;
//        this.RegWrite;
ControlUnit(){
    
}
ControlUnit(int[] input){
    generateSignals(input);
}
    public void generateSignals(int[] input){
        this.input= Arrays.toString(input);
        System.out.println(this.input);
        
        switch(this.input.toString()){
            case "000000":
                //RFormat
                break;
            case "001000":
                //addi
                GenerateIFormatSignals();
                break;
            case "100011":
                //Load instruction
                GenerateLoadSingals();
                break;
            case "101011":
                //save instruction
                GenerateSaveSignals();
                break;
            case "000100":
                //branch if equal
                GenerateBeqSignals();
                break;
            case "100111":
                //nor operation
            case "000101":
                //branch if not equal
        }  
    }
    void GenerateRFormatSignals(){
        this.RegDest=true;
        this.Branch=false;
        this.MemRead=false;
        this.MemtoReg=false;
        this.ALUOp="10";
        this.ALUSrc=false;
        this.MemWrite=false;
        this.RegWrite=true;
    }
    void GenerateIFormatSignals(){
        this.RegDest=false;
        this.Branch=false;
        this.MemRead=false;
        this.MemtoReg=false;
        //this.ALUOp;
        this.ALUSrc=true;
        this.MemWrite=false;
        this.RegWrite=true;
    }
    void GenerateLoadSingals(){
        this.RegDest=false;
        this.Branch=false;
        this.MemRead=true;
        this.MemtoReg=true;
        this.ALUOp="00";
        this.ALUSrc=true;
        this.MemWrite=true;
        this.RegWrite=true;
    }
    void GenerateSaveSignals(){
        this.RegDest=false;
        this.Branch=false;
        this.MemRead=false;
        this.MemtoReg=true;
        this.ALUOp="00";
        this.ALUSrc=true;
        this.MemWrite=false;
        this.RegWrite=true;
    }
    void GenerateBeqSignals(){
        this.RegDest=false;
        this.Branch=true;
        this.MemRead=false;
        this.MemtoReg=true;
        this.ALUOp="01";
        this.ALUSrc=false;
        this.MemWrite=false;
        this.RegWrite=false;
    }
    void GenerateBneSignals(){
//        this.RegDest=false;
//        this.Branch=true;
//        this.MemRead=false;
//        this.MemtoReg=true;
//        this.ALUOp="01";
//        this.ALUSrc=false;
//        this.MemWrite=false;
//        this.RegWrite=false;
    }
}
