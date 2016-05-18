
package mips;

import java.util.Arrays;

public class ControlUnit {
    
    public String input;
    public int RegDest;
    public int Branch;
    public int MemRead;
    public int MemtoReg;
    public String ALUOp;
    public int ALUSrc;
    public int MemWrite;
    public int RegWrite;
    public int Jump;
    public int JumpReturn;
    public int InvetBranch=0;
    public int Mult=0;
    public String Format;
//        this.RegDest;
//        this.Branch;
//        this.MemRead;
//        this.MemtoReg;
//        this.ALUOp;
//        this.ALUSrc;
//        this.MemWrite;
//        this.RegWrite;

public void setControlUnit(String input,String Format){
    this.Jump=0;
    this.JumpReturn=0;
    this.Format=Format;
    generateSignals(input,Format);
}
public void setControlUnit(int[] input,String Format){
    this.JumpReturn=0;
    this.Jump=0;
    this.Format=Format;
    generateSignals(IntArrayToString(input),Format);
}
        public String IntArrayToString(int[] x){
            String output="";
            for(int i=0;i<x.length;i++){
                output+=x[i];
            }
            return output;
        }
        public void generateSignals(String input,String Format){
        this.input= input;
        System.out.println("Current string value:"+this.input);
        if(Format.equals("RFormat")){
        switch(this.input){
            case "000000":
                //RFormat
                GenerateRFormatSignals();
                break;
            case "100111":
                //nor operation
                break;
            }
            
        }
        if(Format.equals("IFormat")){
            switch(this.input){    
            case "001000":
                //addi
                GenerateAddISignals();
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
            case "000101":
                //branch if not equal
                GenerateBneSignals();
                break;
            case "000000":
                //Shift Left
                GenerateSllSignals();
                break;
            case "001010":
                //branch if not equal
                GenerateSllSignals();
                break;  
            }
            
        }     
        if(Format.equals("JFormat")){
            switch(this.input){
            case "000010":
                //jump
                GenerateJumpSignals();
                break;
            case "000011":
                //jumpAtLink
                GenerateJaLSignals();
                break;
            case "001000":
                //jumpReturn
                GenerateJumpRSignals();
                break;    
            }
        }
        System.out.println("Signals: RegtDest="+this.RegDest+ " RegWrite="+this.RegWrite);
    }
    void GenerateRFormatSignals(){
        this.RegDest=1;
        this.Branch=0;
        this.MemRead=0;
        this.MemtoReg=0;
        this.ALUOp="10";
        this.ALUSrc=0;
        this.MemWrite=0;
        this.RegWrite=1;
    }
    void GenerateAddISignals(){
        this.RegDest=0;
        this.Branch=0;
        this.MemRead=0;
        this.MemtoReg=0;
        this.ALUOp="00";
        this.ALUSrc=1;
        this.MemWrite=0;
        this.RegWrite=1;
        this.Jump =0;
        this.JumpReturn = 0;
    }
    void GenerateJaLSignals(){
        this.RegDest=0;
        this.Branch=0;
        this.MemRead=0;
        this.MemtoReg=0;
        this.ALUOp="00";
        this.ALUSrc=0;
        this.MemWrite=0;
        this.RegWrite=0;
        this.Jump=1;
    }
    void GenerateLoadSingals(){
        this.RegDest=0;
        this.Branch=0;
        this.MemRead=1;
        this.MemtoReg=1;
        this.ALUOp="00";
        this.ALUSrc=1;
        this.MemWrite=0;
        this.RegWrite=1;
    }
    void GenerateSaveSignals(){
        this.RegDest=0;
        this.Branch=0;
        this.MemRead=0;
        this.MemtoReg=1;
        this.ALUOp="00";
        this.ALUSrc=1;
        this.MemWrite=1;
        this.RegWrite=0;
    }
    void GenerateBeqSignals(){
        this.RegDest=0;
        this.Branch=1;
        this.MemRead=0;
        this.MemtoReg=1;
        this.ALUOp="01";
        this.ALUSrc=0;
        this.MemWrite=0;
        this.RegWrite=0;
        this.InvetBranch=0;
    }
    void GenerateJumpSignals(){
        this.RegDest=0;
        this.Branch=0;
        this.MemRead=0;
        this.MemtoReg=0;
        this.ALUOp="00";
        this.ALUSrc=0;
        this.MemWrite=0;
        this.RegWrite=0;
        this.Jump=1;
    }
    void GenerateBneSignals(){
        this.RegDest=0;
        this.Branch=1;
        this.MemRead=0;
        this.MemtoReg=1;
        this.ALUOp="01";
        this.ALUSrc=0;
        this.MemWrite=0;
        this.RegWrite=0;
        this.InvetBranch=1;
    }
    void GenerateJumpRSignals(){
        this.RegDest=0;
        this.Branch=0;
        this.MemRead=0;
        this.MemtoReg=0;
        this.ALUOp="00";
        this.ALUSrc=0;
        this.MemWrite=0;
        this.RegWrite=0;
        this.Jump=1;
        this.JumpReturn=1;
    }
    void GenerateSllSignals(){
       this.RegDest=0;
        this.Branch=0;
        this.MemRead=0;
        this.MemtoReg=0;
        this.ALUOp="10";
        this.ALUSrc=1;
        this.MemWrite=0;
        this.RegWrite=1;
        this.Mult=1;
    }
    void GenerateSltISignals(){
       this.RegDest=0;
        this.Branch=0;
        this.MemRead=0;
        this.MemtoReg=0;
        this.ALUOp="00";
        this.ALUSrc=1;
        this.MemWrite=0;
        this.RegWrite=1;
    }
    
    
    // "nor"
}
