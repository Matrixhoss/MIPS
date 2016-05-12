
package mips;

import java.util.ArrayList;


public class Instruction {
    int FAddress;
    int Constant;
    int rsAddress = 0;
    int rtAddress = 0;
    int rdAddress = 0;
    int line = 0;
    String opration;
    int[] ControlSignal=new int[6];
    static  int address;
    
    //for put first address
    public Instruction(int FAddress){
        FAddress=FAddress;
        address=FAddress;
        Constants.Instruction[0]="firstInstruction";
        operations();
    }
    //for other instructions
    public Instruction(){
        
        address+=4;
        Constants.Instruction[(address-FAddress)/4]="Instruction";
        operations();
    }
    //for all operations in instruction 
    private void operations(){}
    
}
