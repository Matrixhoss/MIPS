package mips;

import java.util.ArrayList;

public class Instruction {

    String instruction;
    int[] InstructionBinary = new int[32];
    int[] BinaryCode = new int[32];
    int FAddress ;
    int Constant;
    int rsAddress = 0;
    int rtAddress = 0;
    int rdAddress = 0;
    int line = 0;
    int[] ControlSignal = new int[6];
    static int address=0;
    String of;
    //binary for all ins
    int[] OperationBinary=new int[6];
    int[] rsAddressBinary = new int[5];
    int[] rtAddressBinary = new int[5];
    int[] rdAddressBinary = new int[5];
    int[] constantBinary = new int[16];
    int[] FunctionBinary=new int[6];
    int[] shiftBinary = {0, 0, 0, 0, 0};

    // constant in iFormat
    int IFormatConstant = 0;

    ArrayList<Character> oprationChar = new ArrayList<Character>();
    ArrayList<Character> rsChar = new ArrayList<Character>();
    ArrayList<Character> rtChar = new ArrayList<Character>();
    ArrayList<Character> rdChar = new ArrayList<Character>();
    ArrayList<Character> addressChar = new ArrayList<Character>();
    ArrayList<Character> LineChar = new ArrayList<Character>();

    // Check found boolean
    boolean opFound = false;
    boolean rsFound = false;
    boolean rtFound = false;
    boolean rdFound = false;
    // the opration and the regs in string 
    String opration;
    String rs;
    String rt;
    String rd;


    public Instruction(int FAddress, String ins) {
        //for the first instruction
        if(this.FAddress==0){
            FAddress = FAddress;
            address = FAddress;
        }
        else//for other instruction
            address+=4;
        instruction = ins;
//        Constants.Instruction[0] = "firstInstruction";
        ReadIns(instruction.toCharArray());
        operationToBinary();
        RegToBinary();
        InsToBinary();
    }

    private void InsToBinary() {
        int j =0;
        // set frist 6 bit in instruction as opration
        for (int i = 0; i < 6; i++, j++) {
            InstructionBinary[j] = OperationBinary[i];
        }
        if (!of.equals("JFormat")) {
            // if instruction is Jformat set next 5 bit for rs and next 5 bit for rt
  
            for (int i = 0; i < 5; i++, j++) {
                InstructionBinary[j] = rsAddressBinary[i];
            }
          
            for (int i = 0; i < 5; i++, j++) {
                InstructionBinary[j] = rtAddressBinary[i];
            }
            if (of.equals("Rformat")) {
                // if instruction is Rformat set next 5 bit for rt address and next 5 for rd and next 6 for function
               
                for (int i = 0; i < 5; i++, j++) {
                    InstructionBinary[j] = rdAddressBinary[i];    
                }
               
                for (int i = 0; i < 5; i++, j++) {
                    InstructionBinary[j] = shiftBinary[i];
                }
               
                for (int i = 0; i < 6; i++, j++) {
                    InstructionBinary[j] = FunctionBinary[i];
                }
            } // if instruction is Iformat set next 16 bit for the constant 
            else if (of.equals("IFormat")) {
                for (int i = 0; i < 16; i++, j++) {
                    InstructionBinary[j] = constantBinary[i];
                }
            }
        }

    }

    //for all operations in instruction 
   private void ReadIns(char[] instruction) {
        // create array of char to contan the opration

        of = "";
        int i = 0;
        System.out.println(Constants.ANSI_BLUE+this.instruction+Constants.ANSI_RESET);
        // while the char != " " (in the opration)
        while (instruction[i] != ' ') {

            oprationChar.add(instruction[i]);

            i++;

        }
        i++;

        // convart the opration to string 
        opration = getString(oprationChar);

        Lo:
        for (int j = 0; j < Constants.oprations.length; j++) {
            if (opration.equals(Constants.oprations[j])) {
                opFound = true;
                System.out.println(Constants.ANSI_GREEN + "opration is found" + Constants.ANSI_RESET);
                // the opration is right 
                // 1 - check if the opration is IFormat
                for (int k = 0; k < Constants.IFormat.length; k++) {
                    if (opration.equals(Constants.IFormat[k])) {
                        // set opration format
                        of = "IFormat";
                        System.out.println("opration is IFormat");
                        // brack from the big loop 
                        break Lo;
                    }
                } // 2 - check if the opration is RFormat 
                for (int k = 0; k < Constants.RFormat.length; k++) {
                    if (opration.equals(Constants.RFormat[k])) {
                        // set opration format  
                        of = "RFormat";
                        System.out.println("opration is RFormat");
                        // brack from the big loop 
                        break Lo;
                    }
                }// 3 - check if the opration is JFormat
                for (int k = 0; k < Constants.JFormat.length; k++) {
                    if (opration.equals(Constants.JFormat[k])) {
                        // set opration format  
                        of = "JFormat";
                        System.out.println("opration is JFormat");
                        // brack from the big loop 
                        break Lo;
                    }
                }

            }// opration is not found in opration list 

        } // end of for 

        // if opration not found in Constant oprations 
        if (opFound == false) {

            System.out.println(Constants.ANSI_RED + "The optation is Not found in line " + (line + 1) + Constants.ANSI_RESET);
            System.out.println(Constants.ANSI_RED + "Error in " + opration + Constants.ANSI_RESET);
            return;
        }

        if (of.equals("RFormat")) {
            RFormatSet(instruction, i);
        }// end if of Rformat

        if (of.equals("IFormat")) {
            IFormatSet(instruction, i);
        }// end if of Iformat
        if (of.equals("JFormat")) {
            JFormatSet(instruction, i);
        }// end if of Jformat

    }

    // set RForamte values
    private void RFormatSet(char[] instruction, int i) {
        // rs check 
        while (instruction[i] != ',') {
            if (instruction[i] != ' ') {
                rsChar.add(instruction[i]);
            }

            i++;

        }
        i++;

        rs = getString(rsChar);
        for (int j = 0; j < Constants.reg.length; j++) {
            if (rs.equals(Constants.reg[j])) {
                rsFound = true;
                rsAddress = j;
                System.out.println("Reg rs is found in line " + (line + 1));
                break;
            }

        } // end for 
        if (rsFound == false) {
            System.out.println(Constants.ANSI_RED + "Reg rs is not found in line " + (line + 1) + Constants.ANSI_RED);
            System.out.println(Constants.ANSI_RED +rs+ Constants.ANSI_RED);
            return;
        } // end if 

        // rt Check 
        while (instruction[i] != ',') {

            if (instruction[i] != ' ') {
                rtChar.add(instruction[i]);
            }

            i++;

        }
        i++;

        rt = getString(rtChar);
        for (int j = 0; j < Constants.reg.length; j++) {
            if (rt.equals(Constants.reg[j])) {
                rtFound = true;
                rtAddress = j;
                System.out.println("Reg rt is found in line " + (line + 1));
                break;
            }

        } // end for 
        if (rtFound == false) {
            System.out.println(Constants.ANSI_RED + "Reg rs is not found in line " + (line + 1) + Constants.ANSI_RED);
            System.out.println(rs);
            System.out.println(rs.length());
            return;
        } // end if

        //rd check
        while (true) {
            //   if (instruction[i] != ' ') {
            if (instruction[i] == ' ' && rdChar.isEmpty()) {
                i++;
            } else if (instruction[i] != ' ') {
                rdChar.add(instruction[i]);
                i++;
            } else {
                if (rdChar.size() < 3) {
                    System.out.println(Constants.ANSI_RED + "Error in Line " + (line + 1) + Constants.ANSI_RESET);
                }
                break;
            }

            //   }
        }
        rd = getString(rdChar);

        for (int j = 0; j < Constants.reg.length; j++) {
            if (rd.equals(Constants.reg[j])) {
                rdFound = true;
                rdAddress = j;
                System.out.println("Reg is found rd in line " + (line + 1) + '\n');
                break;
            }

        } // end for 
        if (rdFound == false) {
            System.out.println(Constants.ANSI_RED + "Reg rd is not found in line " + (line + 1) + Constants.ANSI_RESET);

        }

    }

    private void IFormatSet(char[] instruction, int i) {

        // rs check 
        while (instruction[i] != ',') {
            if (instruction[i] != ' ') {
                rsChar.add(instruction[i]);
            }

            i++;

        }
        i++;

        rs = getString(rsChar);
        for (int j = 0; j < Constants.reg.length; j++) {
            if (rs.equals(Constants.reg[j])) {
                rsFound = true;
                rsAddress = j;
                System.out.println("Reg is found rs in line " + (line + 1));
                break;
            }

        } // end for 
        // if the reg not found 
        if (rsFound = false) {
            System.out.println(Constants.ANSI_RED + "Reg rd is not found in line " + (line + 1) + Constants.ANSI_RESET);
            System.out.println(Constants.ANSI_RED + rs + Constants.ANSI_RESET);
            return;
        } // end if 

        if (opration.equals("lw") || opration.equals("sw")) {
            // address of lw or sw Check 
            while (instruction[i] != '(') {

                if (instruction[i] != ' ') {
                    addressChar.add(instruction[i]);
                }
                i++;
            }
            i++;
            IFormatConstant = Integer.parseInt(getString(addressChar));
            System.out.println("The Constant " + IFormatConstant);

            while (instruction[i] != ')') {

                if (instruction[i] != ' ') {
                    rtChar.add(instruction[i]);
                }

                i++;

            }

            rt = getString(rtChar);
            for (int j = 0; j < Constants.reg.length; j++) {
                if (rt.equals(Constants.reg[j])) {
                    rtFound = true;
                    rtAddress = j;
                    System.out.println("Reg is found rt in line " + (line + 1) + '\n');
                    break;
                }

            } // end for 
            if (rtFound == false) {
                System.out.println(Constants.ANSI_RED + "Reg rd is not found in line " + (line + 1) + Constants.ANSI_RESET);
                System.out.println(Constants.ANSI_RED+rt+Constants.ANSI_RESET);
                return;
            } // end if

        } // end of if of check lw and sw
        // if not lw or sw
        else {
            // find rt
            while (instruction[i] != ',') {

                if (instruction[i] != ' ') {
                    rtChar.add(instruction[i]);
                }

                i++;

            }
            i++;

            rt = getString(rtChar);
            for (int j = 0; j < Constants.reg.length; j++) {
                if (rt.equals(Constants.reg[j])) {
                    rtFound = true;
                    rtAddress = j;
                    System.out.println("Reg is found rt in line " + (line + 1));
                    break;
                }

            } // end for 
            if (rtFound == false) {
            System.out.println(Constants.ANSI_RED + "Reg rd is not found in line " + (line + 1) + Constants.ANSI_RESET);
            System.out.println(Constants.ANSI_RED+rt+Constants.ANSI_RESET);
                return;
            } // end if

            // find constant of iformat
            while (true) {

                if (instruction[i] == ' ' && addressChar.isEmpty()) {
                    i++;
                } else if (instruction[i] != ' ') {
                    addressChar.add(instruction[i]);
                    i++;
                } else if (instruction[i] == ' ') {
                    break;
                }

            }
            // set the IFormat Constant 
            try{
            IFormatConstant = Integer.parseInt(getString(addressChar));
            System.out.println("The Constant is " + IFormatConstant + " in line " + (line + 1) + '\n');
            }catch(NumberFormatException e){System.out.println(Constants.ANSI_RED+"Constant must be number in line "+(line+1)+Constants.ANSI_RESET);}
            
        }

    }

    private void JFormatSet(char[] instruction, int i) {
        while (true) {

            if (instruction[i] == ' ' && LineChar.isEmpty()) {
                i++;
            } else if (instruction[i] != ' ') {
                LineChar.add(instruction[i]);
                i++;
            } else if (instruction[i] == ' ') {
                break;
            }

        }
        try{
            line = Integer.parseInt(getString(LineChar));
            System.out.println("Jump to line " + line +1+ '\n');
            }catch(NumberFormatException e){System.out.println(Constants.ANSI_RED+"Jump address must be number in line"+(line+1)+Constants.ANSI_RESET);}
        
    }

    //Operation to binary
    private void operationToBinary() {
        switch (opration) {
            case "add":
               OperationBinary=Constants.getBin(0, 6);
               FunctionBinary=Constants.getBin(32, 6);
                break;
            case "addi":
                OperationBinary=Constants.getBin(8, 6);
               FunctionBinary=Constants.getBin(0, 6);
                break;
            case "sub":
                OperationBinary=Constants.getBin(0, 6);
               FunctionBinary=Constants.getBin(34, 6);
                break;
            case "lw":
                OperationBinary=Constants.getBin(35, 6);
               FunctionBinary=Constants.getBin(0, 6);
                break;
            case "sw":
                OperationBinary=Constants.getBin(43, 6);
               FunctionBinary=Constants.getBin(0, 6);
                break;
            case "sll":
                OperationBinary=Constants.getBin(0, 6);
               FunctionBinary=Constants.getBin(0, 6);
                break;
            case "and":
                OperationBinary=Constants.getBin(0, 6);
               FunctionBinary=Constants.getBin(36, 6);
                break;
            case "or":
                OperationBinary=Constants.getBin(0, 6);
               FunctionBinary=Constants.getBin(37, 6);
                break;
            case "nor":
                
                break;
            case "bne":
                OperationBinary=Constants.getBin(5, 6);
               FunctionBinary=Constants.getBin(0, 6);
                break;
            case "j":
                OperationBinary=Constants.getBin(2, 6);
               FunctionBinary=Constants.getBin(0, 6);
                break;
            case "jal":
                OperationBinary=Constants.getBin(3, 6);
               FunctionBinary=Constants.getBin(0, 6);
                break;
            case "jr":
                OperationBinary=Constants.getBin(8, 6);
               FunctionBinary=Constants.getBin(0, 6);
                break;
            case "slt":
                OperationBinary=Constants.getBin(0, 6);
               FunctionBinary=Constants.getBin(42, 6);
                break;
            case "slti":
                OperationBinary=Constants.getBin(10, 6);
               FunctionBinary=Constants.getBin(0, 6);
                break;
            case "sltu":
                OperationBinary=Constants.getBin(0, 6);
               FunctionBinary=Constants.getBin(41, 6);
                break;
            case "sltui":
                OperationBinary=Constants.getBin(9, 6);
               FunctionBinary=Constants.getBin(0, 6);
                break;
        }

    }

    //transfer Reg to binary
    private void RegToBinary() {
        if (!of.equals("JFormat")) {
            if (of.equals("RFormat")) {
                rdAddressBinary = Constants.getBin(rdAddress, 5);
            }
            rsAddressBinary = Constants.getBin(rsAddress, 5);
            rtAddressBinary = Constants.getBin(rtAddress, 5);
            constantBinary = Constants.getBin(IFormatConstant, 16);
        }

    }

    // return the instruction in binary 
    public int[] getInstructionBinary() {
        return InstructionBinary;
    }
    
    public void setInstruction(String instruction){
    this.instruction = instruction ;
    }

    // function to convert ArrayList of char to string 
    String getString(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
