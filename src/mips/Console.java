package mips;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Console {

    public static int FAddress;
    public static int address = 0;
    private LinkedList<String> ins = new LinkedList<String>();
    private int numofins = 0;
    private String read = "";
    Scanner sc = new Scanner(System.in);
    private int selectionCode = 1;
    
    private InstructionMemory IM = new InstructionMemory();
    private Registers Reg = new Registers();
    private ALU ALU = new ALU ();
    private ControlUnit cu= new ControlUnit();
    private ALUControl ALUcontrol = new ALUControl();
    private DataMemory DM = new DataMemory();

    public Console() {
        
        // Scanner s = new Scanner (System.in);
        System.out.println("Initializing Mips Simolator ");
        System.out.println("Enter the frist address ");
        FAddress = sc.nextInt();
        Constants.FristAddress = FAddress;
        address=FAddress;
        FileOrConsole();
        Constants.Memory[15] = 77 ;
            
            while(address<ins.size()*4+FAddress){
            IM.setInstructionMemory(address);
            cu.setControlUnit(IM.getControlUnit());
            Reg.setRegisters(IM.getRS(), IM.getRT(), cu.RegWrite);
            System.out.println(IM.getOperation());
            ALUcontrol.setSALUControl(cu.ALUOp, Constants.BinaryToString(IM.getALUControl()));
            ALU.setALU(Reg.ReturnData1(), Constants.Mux(Reg.ReturnData2(),Constants.BinToInt(Constants.signExtend(IM.getSignExtend())),cu.ALUSrc), ALUcontrol.getALUOutput());
            Constants.JumpOfBranch(ALU.getZeroFlag(), IM.getOperation(), address-4, IM.LineToJump);
            DM.setDataMemory(ALU.getALUResult(), Reg.ReturnData2(), cu.MemRead, cu.MemWrite);
            Reg.setWrtData(Constants.Mux(ALU.getALUResult(),DM.getReadData(),cu.MemtoReg), Constants.Mux(IM.getRT(),IM.getRD(),cu.RegDest));
                
            System.out.println(Constants.Memory[3]);
            System.out.println();
        }//
            Constants.l.printAll();
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
                    Constants.Instructions[numofins] = new Instruction(FAddress, ins.get(numofins),numofins);
                    
                    numofins++;
                }
                br.close();
                fr.close();

            } 
            catch (FileNotFoundException e) {
                System.out.println("error");
            }
            catch (IOException e) {
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
