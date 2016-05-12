
package mips;

import java.util.Arrays;

public class ControlUnit {
    public char[] input;
    public boolean RegDest;
    public boolean Branch;
    public boolean MemRead;
    public boolean MemtoReg;
    public int ALUOp;
    public boolean ALUSrc;
    public boolean MemWrite;
    public boolean RegWrite;
    
    ControlUnit(int[] input){
        this.input= Arrays.toString(input).toCharArray();
        System.out.println(this.input);
        char[] temp = {1,2,3,4,5,6};
        //if(this.input.equals(1,2,3,4,5,6);
    }
}
