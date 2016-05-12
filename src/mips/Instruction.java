package mips;

import java.util.ArrayList;

public class Instruction {

    String instruction;
    int[] BinaryCode=new int[32];
    int FAddress;
    int Constant;
    int rsAddress = 0;
    int rtAddress = 0;
    int rdAddress = 0;
    int line = 0;
    int[] ControlSignal=new int[6];
    static  int address;
    String of;
    //binary for Reg
    int[] rsAddressBinary=new int[5];
    int[] rtAddressBinary=new int[5];
    int[] rdAddressBinary=new int[5];
    int[] constantBinary=new int[16];
    int[] shiftBinary={0,0,0,0,0};  
    
    // constant in iFormate
    int IFormateConstant = 0;
    
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

    //for put first address
    public Instruction(int FAddress, String ins) {
        instruction = ins;
        FAddress = FAddress;
        address = FAddress;
        Constants.Instruction[0] = "firstInstruction";
        ReadIns(instruction.toCharArray());
        operationToBinary();
        RegToBinary();
    }

    //for other instructions
    public Instruction(String ins) {
        instruction = ins;
        address += 4;
        Constants.Instruction[(address - FAddress) / 4] = "Instruction";
        ReadIns(instruction.toCharArray());
        operationToBinary();
        RegToBinary();
    }

    //for all operations in instruction 
    private void ReadIns(char[] instruction) {
        // create array of char to contan the opration

        of = "";
        int i = 0;
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
                System.out.println("opration is found");
                // the opration is right 
                // 1 - check if the opration is IFormate
                for (int k = 0; k < Constants.IFormate.length; k++) {
                    if (opration.equals(Constants.IFormate[k])) {
                        // set opration formate   
                        of = "IFormate";
                        System.out.println("opration is IFormate");
                        // brack from the big loop 
                        break Lo;
                    }
                } // 2 - check if the opration is RFormate 
                for (int k = 0; k < Constants.RFormate.length; k++) {
                    if (opration.equals(Constants.RFormate[k])) {
                        // set opration formate  
                        of = "RFormate";
                        System.out.println("opration is RFormate");
                        // brack from the big loop 
                        break Lo;
                    }
                }// 3 - check if the opration is JFormate
                for (int k = 0; k < Constants.JFormate.length; k++) {
                    if (opration.equals(Constants.JFormate[k])) {
                        // set opration formate  
                        of = "JFormate";
                        System.out.println("opration is JFormate");
                        // brack from the big loop 
                        break Lo;
                    }
                }

            }// opration is not found in opration list 

        } // end of for 

        // if opration not found in Constant oprations 
        if (opFound == false) {

            System.err.println("The optation is Not found in line " + (line + 1));
            return;
        }

        if (of.equals("RFormate")) {
            RFormateSet(instruction, i);
        }// end if of Rformate

        if (of.equals("IFormate")) {
            IFormateSet(instruction, i);
        }// end if of Iformate
        if (of.equals("JFormate")) {
            JFormateSet(instruction, i);
        }// end if of Jformate

    }

    // set RForamte values
    private void RFormateSet(char[] instruction, int i) {
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
        if (rsFound = false) {
            System.err.println("Reg rs is not found in line " + (line + 1));
            System.out.println(rs);
            System.out.println(rs.length());
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
                System.out.println("Reg is found rt in line " + (line + 1));
                break;
            }

        } // end for 
        if (rtFound = false) {
            System.out.println("Reg rs is not found in line " + (line + 1));
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
                    System.err.println("Error in Line " + line);
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
        if (rdFound = false) {
            System.out.println("Reg rd is not found in line " + (line + 1));
            System.out.println(rs);
            System.out.println(rs.length());

        }

    }

    private void IFormateSet(char[] instruction, int i) {

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
            System.err.println("Reg rs is not found in line " + (line + 1));
            System.out.println(rs);
            System.out.println(rs.length());
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
            IFormateConstant = Integer.parseInt(getString(addressChar));
            System.out.println("The Constant " + IFormateConstant);

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
            if (rtFound = false) {
                System.err.println("Reg rs is not found in line " + (line + 1));
                System.out.println(rs);
                System.out.println(rs.length());
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
            if (rtFound = false) {
                System.out.println("Reg rs is not found in line " + (line + 1));
                System.out.println(rs);
                System.out.println(rs.length());
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
            IFormateConstant = Integer.parseInt(getString(addressChar));
            System.out.println("The Constant is " + IFormateConstant + " in line " + (line + 1) + '\n');
        }

    }

    private void JFormateSet(char[] instruction, int i) {
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
        line = Integer.parseInt(getString(LineChar));
        System.out.println("Jump to line " + line + '\n');
    }
    //Operation to binary
    private void operationToBinary(){
        switch(opration){
            case"add":
                break;
            case"addi":
                break;    
            case"sub":
                break;    
            case"lw":
                break;
            case"sw":
                break;
            case"sll":
                break;
            case"and":
                break;
            case"or":
                break;
            case"nor":
                break;
            case"bne":
                break;
            case"j":
                break;
            case"jal":
                break;
            case"jr":
                break;
            case"slt":
                break;
            case"slti":
                break;
            case"sltu":
                break;
            case"sltui":
                break;    
        }
            
    }
    //transfer Reg to binary
    private void RegToBinary(){
      if(!of.equals("JFormate")){  
        if(of.equals("RFormate")){
            rdAddressBinary=Constants.getBin(rdAddress,5);
        }
        rsAddressBinary=Constants.getBin(rsAddress,5);
        rtAddressBinary=Constants.getBin(rtAddress,5);
        constantBinary=Constants.getBin(Constant,16);
      }
        
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
