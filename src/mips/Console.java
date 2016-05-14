package mips;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Console {

    private int FAddress;
    public static int address = 0;
    private LinkedList<String> ins = new LinkedList<String>();
    private int numofins = 0;
    private String read = "";
    Scanner sc = new Scanner(System.in);
    private int selectionCode = 1;

    public Console() {

        // Scanner s = new Scanner (System.in);
        System.out.println("Initializing Mips Simolator ");
        System.out.println("Enter the frist address ");
        FAddress = sc.nextInt();
        Constants.FristAddress = FAddress;
        address=FAddress;
        FileOrConsole();
       
            InstructionMemory m = new InstructionMemory(FAddress);
            while(address<ins.size()*4+FAddress){
                System.out.println(FAddress+" "+address+" "+(address-FAddress)/4);
            m.getInstruction((address-FAddress)/4);
            int[] x1 ={0,0,0,0,0,0};
            String x2="000000";
            ControlUnit cu = new ControlUnit(x2);
            Registers g = new Registers(m.getRS(), m.getRT(), cu.RegWrite);
            ALU alu  = new ALU(g.ReturnData1(), g.ReturnData2(), "0110");
            if(m.getOperation().equals("beq")||m.getOperation().equals("bne"))
                alu.BranchJump(m.getLabel());
            g.setWrtData(alu.getALUResult(), Constants.Mux(m.getRT(), m.getRD(),cu.RegDest));
            System.out.println(Registers.$s2);
           //System.out.println(Constants.Instructions[i].opration);
           //System.out.println(Constants.Instructions[i].label);
           //System.out.println(Constants.Instructions[i].opration.length());
           // System.out.println(Constants.Instructions[i].label.length());
            
           
        }//
    }

    // check the user use file or console to run the programe 
    public void FileOrConsole() {
        // if selectionCode = 1 then the user use file system 
        if (selectionCode == 1) {
            try {
                FileReader fr = new FileReader("test.txt");
                BufferedReader br = new BufferedReader(fr);
                System.out.println("Enter the instructions and when you're done type end");
                //while the user dont type end the system take the line and pt it on LinkedList 
                while (true) {
                    read = br.readLine();
                    if (read.equals("end")) {
                        break;
                    }
                    ins.add(read + " ");
                    Constants.Instructions[numofins] = new Instruction(FAddress, ins.get(numofins), numofins);

                    numofins++;
                }
                br.close();
                fr.close();

            } catch (FileNotFoundException e) {
                System.out.println("error");
            } catch (IOException e) {
                System.out.println("error");
            }

        } // if the selectionCode = 0 then the user use console system 
        else if (selectionCode == 0) {
            System.out.println("Enter the instructions and you're done type end");
            //while the user dont type end the system take the line and pt it on LinkedList 
            while (true) {
                read = sc.nextLine();
                if (read.equals("end")) {
                    break;
                }
                ins.add(read + " ");
                InstructionMemory.Instruction[address] = ins.getLast();
                numofins++;
            }

        }
    }
}
