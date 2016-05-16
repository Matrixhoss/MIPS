
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
//        this.RegDest;
//        this.Branch;
//        this.MemRead;
//        this.MemtoReg;
//        this.ALUOp;
//        this.ALUSrc;
//        this.MemWrite;
//        this.RegWrite;

public void setControlUnit(String input){
    this.Jump=0;
    this.JumpReturn=0;
    generateSignals(input);
}
public void setControlUnit(int[] input){
    this.JumpReturn=0;
    this.Jump=0;
    
    generateSignals(IntArrayToString(input));
}
        public String IntArrayToString(int[] x){
            String output="";
            for(int i=0;i<x.length;i++){
                output+=x[i];
            }
            return output;
        }
        public void generateSignals(String input){
        this.input= input;
        System.out.println("Current string value:"+this.input);
        
        switch(this.input){
            case "000000":
                //RFormat
                GenerateRFormatSignals();
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
                break;
            case "000101":
                //branch if not equal
                break;
            case "000010":
                //jump
                GenerateJumpSignals();
                break;
                
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
    void GenerateIFormatSignals(){
        this.RegDest=0;
        this.Branch=0;
        this.MemRead=0;
        this.MemtoReg=0;
        this.ALUOp="00";
        this.ALUSrc=1;
        this.MemWrite=0;
        this.RegWrite=1;
    }
    void GenerateJaLSignals(){
        this.RegDest=0;
        this.Branch=0;
        this.MemRead=0;
        this.MemtoReg=0;
        this.ALUOp="00";
        this.ALUSrc=1;
        this.MemWrite=0;
        this.RegWrite=1;
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
        this.RegWrite=1;
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
    
    
    
    
    // "nor" , "bne"
}
