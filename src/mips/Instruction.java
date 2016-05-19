package mips;

import java.util.ArrayList;

public class Instruction {

    String instruction;
    int[] InstructionBinary = new int[32];
    int[] BinaryCode = new int[32];
    private static int FAddress;
    int Constant;
    int rsAddress = 0;
    int rtAddress = 0;
    int rdAddress = 0;
    int LineToJump = 0;//line that branch jump to
    int AddressToJump;
    public int line = 0;
    int[] ControlSignal = new int[6];
    private static int address = 0;
    String of;
    //binary for all ins
    int[] OperationBinary = new int[6];
    int[] rsAddressBinary = new int[5];
    int[] rtAddressBinary = new int[5];
    int[] rdAddressBinary = new int[5];
    int[] constantBinary = new int[16];
    int[] FunctionBinary = new int[6];
    int[] shiftBinary = {0, 0, 0, 0, 0};

    // constant in iFormat
    int IFormatConstant = 0;
    ArrayList<Character> fristChar = new ArrayList<Character>();
    ArrayList<Character> oprationChar = new ArrayList<Character>();
    ArrayList<Character> labelChar = new ArrayList<Character>();
    ArrayList<Character> rsChar = new ArrayList<Character>();
    ArrayList<Character> rtChar = new ArrayList<Character>();
    ArrayList<Character> rdChar = new ArrayList<Character>();
    ArrayList<Character> addressChar = new ArrayList<Character>();
    ArrayList<Character> LineChar = new ArrayList<Character>();

    //to know which label we jump to
    String JumpTo = null;

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
    String label = null;

    public Instruction(int FAddress, String ins, int Line) {
        //for the first instruction
        if (this.FAddress == 0) {
            this.FAddress = FAddress;
            address = FAddress;

        } else//for other instruction
        {
            address += 4;

        }
        instruction = ins;
        this.line = Line;
//        Constants.Instruction[0] = "firstInstruction";
        ReadIns(instruction.toCharArray());
        operationToBinary();
        RegToBinary();
        InsToBinary();
        SaveLabel();
        System.out.println(address);
//        System.out.println(this.line);
        System.out.println("this Line :"+this.line);
        System.out.println("rd = "+Constants.BinToInt(rdAddressBinary));
        System.out.println("rs ="+Constants.BinToInt(rsAddressBinary));
        System.out.println("rt ="+Constants.BinToInt(rtAddressBinary));
        System.out.println("Label  : " + this.label);
        System.out.println(Constants.BinToInt(FunctionBinary));
        System.out.println(Registers.$s0);
//        for(int i=0;i<6;i++){
//            System.out.print(OperationBinary[i]);
//        }
//        for(int i=0;i<5;i++){
//            System.out.print(rsAddressBinary[i]);
//        }
//        for(int i=0;i<5;i++){
//            System.out.print(rtAddressBinary[i]);
//        }
//        for(int i=0;i<16;i++){
//            System.out.print(constantBinary[i]);
//        }
        System.out.println();
        for (int i = 0; i < 32; i++) {
            System.out.print(InstructionBinary[i]);
        }
        System.out.println();
    }

    private void InsToBinary() {
        int j = 0;
        // set frist 6 bit in instruction as opration
        for (int i = 0; i < 6; i++, j++) {
            InstructionBinary[j] = OperationBinary[i];
        }
        // if instruction is Jformat set next 5 bit for rs and next 5 bit for rt
        //set 5 bit for the rs
        if (!of.equals("JFormat")) {
            for (int i = 0; i < 5; i++, j++) {
                InstructionBinary[j] = rsAddressBinary[i];
            }
            //set 5 bit for the rt
            for (int i = 0; i < 5; i++, j++) {
                InstructionBinary[j] = rtAddressBinary[i];
            }

            if (of.equals("RFormat")) {
                // if instruction is Rformat set next 5 bit for rt address and next 5 for rd and next 6 for function
                for (int i = 0; i < 5; i++, j++) {
                    InstructionBinary[j] = rdAddressBinary[i];
                }
                //set 5 bit for the shift
                for (int i = 0; i < 5; i++, j++) {
                    InstructionBinary[j] = shiftBinary[i];
                }
                //set next 6 bit for the function
                for (int i = 0; i < 6; i++, j++) {
                    InstructionBinary[j] = FunctionBinary[i];
                }
            } else {
                // if instruction is Iformat set next 16 bit for the constant 
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
        System.out.println(Constants.ANSI_BLUE + this.instruction + Constants.ANSI_RESET);

        while (true) {
            if (instruction[i] == ' ' && fristChar.isEmpty()) {
                i++;
            } else {
                if (instruction[i] == ':') {
                    labelChar = fristChar;
                    i++;
                    while (true) {
                        if (instruction[i] == ' ' && oprationChar.isEmpty()) {
                            i++;
                        } else if (instruction[i] != ' ') {
                            oprationChar.add(instruction[i]);
                            i++;
                        } else if (instruction[i] == ' ') {
                            break;
                        }

                    }
                    break;
                } else if (instruction[i] == ' ') {
                    oprationChar = fristChar;
                    break;
                }
                fristChar.add(instruction[i]);
                i++;

            }
        }
        i++;

        label = getString(labelChar);
        opration = getString(oprationChar);
        Lo:
        for (int j = 0; j < Constants.oprations.length; j++) {
            if(opration.equals("end")){
                System.out.println(Constants.ANSI_CYAN+"End of Instructions"+Constants.ANSI_RESET);
                break;
            }
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
        if (!opration.equals("end")){
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
        }// end of check end
    }

    // set RForamte values
    private void RFormatSet(char[] instruction, int i) {
        // rs check 
        while (instruction[i] != ',') {
            if (instruction[i] != ' ') {
                rdChar.add(instruction[i]);
            }

            i++;

        }
        i++;

        rd = getString(rdChar);
        for (int j = 0; j < Constants.reg.length; j++) {
            if (rd.equals(Constants.reg[j])) {
                rdFound = true;
                rdAddress = j;
                System.out.println("Reg rd is found in line " + (line + 1));
                break;
            }

        } // end for 
        if (rdFound == false) {
            System.out.println(Constants.ANSI_RED + "Reg rd is not found in line " + (line + 1) + Constants.ANSI_RED);
            System.out.println(Constants.ANSI_RED + rs + Constants.ANSI_RED);
            return;
        } // end if 

        // rt Check 
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
            System.out.println(rs);
            return;
        } // end if

        //rt check
        while (true) {
            //   if (instruction[i] != ' ') {
            if (instruction[i] == ' ' && rtChar.isEmpty()) {
                i++;
            } else if (instruction[i] != ' ') {
                rtChar.add(instruction[i]);
                i++;
            } else {
                if (rtChar.size() < 3) {
                    System.out.println(Constants.ANSI_RED + "Error in Line " + (line + 1) + Constants.ANSI_RESET);
                }
                break;
            }

            //   }
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
            System.out.println(Constants.ANSI_RED + "Reg rt is not found in line " + (line + 1) + Constants.ANSI_RESET);

        }

    }

    private void SaveLabel() {
        if (!this.label.equals("")) {
            Constants.l.addLabel(label, address, line);
        }
    }

    private void IFormatSet(char[] instruction, int i) {

        // rt check 
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
        // if the reg not found 
        if (rtFound = false) {
            System.out.println(Constants.ANSI_RED + "Reg rt is not found in line " + (line + 1) + Constants.ANSI_RESET);
            System.out.println(Constants.ANSI_RED + rs + Constants.ANSI_RESET);
            return;
        } // end if 

        if (opration.equals("lw") || opration.equals("sw")) {
            // address of lw or sw Check 
            try {
                while (instruction[i] != '(') {

                    if (instruction[i] != ' ') {
                        addressChar.add(instruction[i]);
                    }
                    i++;
                }
                i++;
                if (addressChar.get(0).equals('-')) {
                    IFormatConstant = (Integer.parseInt(getString(addressChar)));
                } else {
                    IFormatConstant = Integer.parseInt(getString(addressChar));
                }
                System.out.println("The Constant " + IFormatConstant);

                while (instruction[i] != ')') {

                    if (instruction[i] != ' ') {
                        rsChar.add(instruction[i]);
                    }

                    i++;

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(Constants.ANSI_RED + "Error in sentence may be forget () in line " + (line + 1) + "\n" + Constants.ANSI_RESET);
                return;
            }
            rs = getString(rsChar);
            for (int j = 0; j < Constants.reg.length; j++) {
                if (rs.equals(Constants.reg[j])) {
                    rsFound = true;
                    rsAddress = j;
                    System.out.println("Reg is found rs in line " + (line + 1) + '\n');
                    break;
                }

            } // end for 
            if (rsFound == false) {
                System.out.println(Constants.ANSI_RED + "Reg rs is not found in line " + (line + 1) + Constants.ANSI_RESET);
                System.out.println(Constants.ANSI_RED + rt + Constants.ANSI_RESET);
                return;
            } // end if

        } // end of if of check lw and sw
        // if not lw or sw
        else {
            // find rt
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
            if (rsFound == false) {
                System.out.println(Constants.ANSI_RED + "Reg rs is not found in line " + (line + 1) + Constants.ANSI_RESET);
                System.out.println(Constants.ANSI_RED + rt + Constants.ANSI_RESET);
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
            try {
                if (this.opration.equals("beq") || this.opration.equals("bne")) {
                    JumpTo = getString(addressChar);
                    System.out.println("The Instruction is  jump for " + JumpTo + "\n");
                } else {
                    if (addressChar.get(0).equals('-')) {
                        addressChar.remove(0);
                    IFormatConstant = -1*(Integer.parseInt(getString(addressChar)));
                } else {
                    IFormatConstant = Integer.parseInt(getString(addressChar));
                }
                    System.out.println("The Constant is " + IFormatConstant + " in line " + (line + 1) + '\n');
                }
            } catch (NumberFormatException e) {
                System.out.println(Constants.ANSI_RED + "Constant must be number in line " + (line + 1) + '\n' + Constants.ANSI_RESET);
            }

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
        try {
            JumpTo = getString(LineChar);
            System.out.println("Jump to line " + JumpTo + 1 + '\n');
        } catch (NumberFormatException e) {
            System.out.println(Constants.ANSI_RED + "Jump address must be number in line" + (line + 1) + Constants.ANSI_RESET);
        }

    }

    //Operation to binary
    private void operationToBinary() {
        switch (opration) {
            case "add":
                OperationBinary = Constants.getBin(0, 6);
                FunctionBinary = Constants.getBin(32, 6);
                break;
            case "addi":
                OperationBinary = Constants.getBin(8, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
            case "sub":
                OperationBinary = Constants.getBin(0, 6);
                FunctionBinary = Constants.getBin(34, 6);
                break;
            case "lw":
                OperationBinary = Constants.getBin(35, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
            case "sw":
                OperationBinary = Constants.getBin(43, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
            case "sll":
                OperationBinary = Constants.getBin(0, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
            case "and":
                OperationBinary = Constants.getBin(0, 6);
                FunctionBinary = Constants.getBin(36, 6);
                break;
            case "or":
                OperationBinary = Constants.getBin(0, 6);
                FunctionBinary = Constants.getBin(37, 6);
                break;
            case "nor":
                OperationBinary = Constants.getBin(0, 6);
                FunctionBinary = Constants.getBin(39, 6);
                break;
            case "bne":
                OperationBinary = Constants.getBin(5, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
            case "beq":
                OperationBinary = Constants.getBin(4, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
            case "j":
                OperationBinary = Constants.getBin(2, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
            case "jal":
                OperationBinary = Constants.getBin(3, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
            case "jr":
                OperationBinary = Constants.getBin(8, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
            case "slt":
                OperationBinary = Constants.getBin(0, 6);
                FunctionBinary = Constants.getBin(42, 6);
                break;
            case "slti":
                OperationBinary = Constants.getBin(10, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
            case "sltu":
                OperationBinary = Constants.getBin(0, 6);
                FunctionBinary = Constants.getBin(41, 6);
                break;
            case "sltui":
                OperationBinary = Constants.getBin(9, 6);
                FunctionBinary = Constants.getBin(0, 6);
                break;
             case "mul":
                OperationBinary = Constants.getBin(0, 6);
                FunctionBinary = Constants.getBin(24, 6);
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

    public void setInstruction(String instruction) {
        this.instruction = instruction;
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
