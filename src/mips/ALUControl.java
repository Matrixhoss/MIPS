package mips;

public class ALUControl {

    private String op;
    private String function;
    private String aluinput;

    public ALUControl() {
        

    }
    
    public void setSALUControl (String op, String function){
    if (op.equals("00")) {
            aluinput = "0010";
        }
        if (op.equals("01")) {
            aluinput = "0110";
        }
        if (op.equals("11")) {
            aluinput = "0111";
        }
        if (op.equals("10")) {
            switch (function) {
                case "100000":
                    aluinput = "0010";
                    break;
                case "100010":
                    aluinput = "0110";
                    break;
                case "100100":
                    aluinput = "0000";
                    break;
                case "100101" :   
                    aluinput = "0001";
                    break;
                case "101010" : 
                    aluinput = "0111";
                    break;
                case "011000" : 
                  aluinput = "1111";
                   break;
                case "000000" : 
                  aluinput = "1000";
                   break;   
            
            }
            

        }
        System.out.println("AluControl Result: "+aluinput);
    }

     public String getALUOutput (){
     return this.aluinput;
     }
}
