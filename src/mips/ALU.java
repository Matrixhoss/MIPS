/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips;

// input 
public class ALU {

    private String ALUControl;
    private int Data1;
    private int Data2;
    private final int ZreoFlag = 0;
    private int ALUResult;

    private int Data1InBinary[];
    private int Data2InBinary[];

    final String ALUand = "0000";
    final String ALUor  = "0001";
    final String ALUadd = "0010";
    final String ALUsub = "0110";
    final String ALUslt = "0111";
    final String ALUnor = "1100";

    public ALU(int Data1, int Data2, String ALUControl) {
        this.Data1 = Data1;
        this.Data2 = Data2;
        this.ALUControl = ALUControl;
        this.Data1InBinary = Constants.getBin(Data1, 5);
        this.Data2InBinary = Constants.getBin(Data2, 5);

        switch (ALUControl) {

            case ALUand:
                ALUResult = Constants.BinToInt(Constants.add(Data1InBinary, Data2InBinary));
                break;
            case ALUor:
                ALUResult = Constants.BinToInt(Constants.or(Data1InBinary, Data2InBinary));
                break;
            case ALUadd:
                ALUResult = Data1 + Data2;
                break;
            case ALUsub:
                ALUResult = Data1 - Data2;
                break;
            case ALUslt:
                if (Data1 > Data2) {
                    ALUResult = 1;
                } else {
                    ALUResult = 0;
                }
                break;
            case ALUnor:
                ALUResult = Constants.BinToInt(Constants.nor(Data1InBinary, Data2InBinary));
                break;
            default:
                ALUResult = ZreoFlag;
                break;
        }

    }
    
    public int getALUResult (){
    return this.ALUResult;
    }
    
    public int[] getALUResultInBinary(){
    return Constants.getBin(this.ALUResult, 5);
    }
    public int getZeroFlag (){
    return this.ZreoFlag;
    }

}
