package mips;

public class ALU {

    private String ALUControl;
    private int Data1;
    private int Data2;
    private int ZreoFlag = 0;
    private int ALUResult;
    private int UnSign;

    private int Data1InBinary[];
    private int Data2InBinary[];

    final String ALUand = "0000";
    final String ALUor = "0001";
    final String ALUadd = "0010";
    final String ALUsub = "0110";
    final String ALUslt = "0111";
    final String ALUnor = "1100";
    final String ALUmul = "1111";
    final String ALUsll = "1000";

    public void setALU(int Data1, int Data2, String ALUControl, int UnSign) {
        this.ZreoFlag = 0;
        this.Data1 = Data1;
        this.Data2 = Data2;
        this.ALUControl = ALUControl;
        this.UnSign = UnSign;
        this.Data1InBinary = Constants.getBin(Data1, 5);
        this.Data2InBinary = Constants.getBin(Data2, 5);

        if (Data1 - Data2 == 0) {
            this.ZreoFlag = 1;
        }

        switch (ALUControl) {

            case ALUand:
                ALUResult = Constants.BinToInt(Constants.and(Data1InBinary, Data2InBinary));
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
                 slt();
                break;
            case ALUnor:
                ALUResult = Constants.BinToInt(Constants.nor(Data1InBinary, Data2InBinary));
                break;
            case ALUmul:
                ALUResult = Data1 * Data2;
                break;
            case ALUsll:
                ALUResult = Data1 * Data2*2;
                break;
            default:
                System.out.println("Error in inputs in ALU ");
                break;
        }

    }

    public void setALU(int d1[], int d2[], String ALUControl, int UnSign) {
        this.ZreoFlag = 0;
        this.Data1 = Constants.BinToInt(d1);
        this.Data2 = Constants.BinToInt(d2);
        this.ALUControl = ALUControl;
        this.Data1InBinary = d1;
        this.Data2InBinary = d2;

        if (Data1 - Data2 == 0) {
            this.ZreoFlag = 1;
        }

        switch (ALUControl) {

            case ALUand:
                ALUResult = Constants.BinToInt(Constants.and(Data1InBinary, Data2InBinary));
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
                if (UnSign == 0) {
                    if (Data1 > Data2) {
                        ALUResult = 1;
                    } else {
                        ALUResult = 0;
                    }
                }

                break;
            case ALUnor:
                ALUResult = Constants.BinToInt(Constants.nor(Data1InBinary, Data2InBinary));
                break;
            default:
                System.out.println("Error in inputs in ALU ");
                break;
        }

    }

    public int getALUResult() {
        return this.ALUResult;
    }

    public int[] getALUResultInBinary() {
        if (Data2InBinary.length == 16) {
            return Constants.getBin(this.ALUResult, 16);
        } else {
            return Constants.getBin(this.ALUResult, 5);
        }
    }

    public int getZeroFlag() {
        return this.ZreoFlag;
    }

    private void slt() {

        if (UnSign == 0) {
            if (Data1 < Data2) {
                ALUResult = 1;
            } else {
                ALUResult = 0;
            }

        }
        if (UnSign == 1) {
            if (Constants.BinToInt(Data1InBinary, true) < Constants.BinToInt(Data2InBinary,true)) {
                ALUResult = 1;
            } else {
                ALUResult = 0;
            }
        }
    }
        private void sll(){
            if(Data2>0)
                ALUResult=Data1*Data2*2;
            else if(Data2==0)
                ALUResult=Data1;
    } 
//    public void BranchJump(String ToJump){
//        if(this.ZreoFlag==1){
//            
//            Console.address=Constants.l.SearchAddress(ToJump);
//        }
//    }
    
}
