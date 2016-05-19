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
    Scanner s = new Scanner(System.in);
    private int selectionCode = 0;

    private InstructionMemory IM = new InstructionMemory();
    private Registers Reg = new Registers();
    private ALU ALU = new ALU();
    private ControlUnit cu = new ControlUnit();
    private ALUControl ALUcontrol = new ALUControl();
    private DataMemory DM = new DataMemory();

    public static int LAddress;//Last Address 
    
    public Console(int PCValue) {

        // Scanner s = new Scanner (System.in);
        System.out.println("Initializing Mips Simolator ");
        Constants.FristAddress = PCValue;
        address = FAddress;
        FileOrConsole();
        Registers.$ra = LAddress-4;
        Registers.$a0 = 10;
        Registers.$a1 = 0;
        Registers.$a2 = 0;
        Registers.$a3 = 0;
        Registers.$t9 = 4;

        int i = 1;
        Constants.l.printAll();
        while (address !=LAddress) {
            IM.setInstructionMemory(address);
            System.out.println("Operation : " + IM.getOperation());
            if (!IM.getOperation().equals("end")) {
                cu.setControlUnit(IM.getControlUnit(), IM.Format);
                if (IM.getOperation().equals("slu")) {
                    cu.UnSigned = 1;
                }
                Constants.CheckJump(IM.getAddressToJump(), cu.Jump, address - 4, IM.getOperation());
                Reg.setRegisters(IM.getRS(), IM.getRT(), cu.RegWrite);
                ALUcontrol.setSALUControl(cu.ALUOp, Constants.BinaryToString(IM.getALUControl()));
                ALU.setALU(Reg.ReturnData1(), Constants.Mux(Reg.ReturnData2(), Constants.BinToInt(Constants.signExtend(IM.getSignExtend())), cu.ALUSrc), ALUcontrol.getALUOutput(), cu.UnSigned);
                Constants.JumpOfBranch(ALU.getZeroFlag(), IM.getOperation(), address - 4, IM.LineToJump, cu.Branch, cu.InvetBranch);
                DM.setDataMemory(ALU.getALUResult(), Reg.ReturnData2(), cu.MemRead, cu.MemWrite);
                Reg.setWrtData(Constants.Mux(ALU.getALUResult(), DM.getReadData(), cu.MemtoReg), Constants.Mux(IM.getRT(), IM.getRD(), cu.RegDest));
                System.out.println("Ss0=  " + Registers.$s1 + "   " + address);
                System.out.println("Ss0=  " + Registers.$sp);
                // System.out.println(Constants.Memory[3]);
                System.out.println();
            } else {
                break;
            }
        }//
        Constants.l.printAll();

    }


    public Console(int PCValue,int SelectionCode) {
        this.selectionCode=SelectionCode;
        // Scanner s = new Scanner (System.in);
        System.out.println("Initializing Mips Simolator ");
        Constants.FristAddress = PCValue;
        address = FAddress;
        FileOrConsole();
        Registers.$ra = LAddress-4;
        Registers.$a0 = 10;
        Registers.$a1 = 0;
        Registers.$a2 = 0;
        Registers.$a3 = 0;
        Registers.$t9 = 4;

        
        int i = 1;
        Constants.l.printAll();
        while (address !=LAddress) {
            IM.setInstructionMemory(address);
            if (!IM.getOperation().equals("end")) {
                cu.setControlUnit(IM.getControlUnit(), IM.Format);
                if (IM.getOperation().equals("slu")) {
                    cu.UnSigned = 1;
                }
                Constants.CheckJump(IM.getAddressToJump(), cu.Jump, address - 4, IM.getOperation());
                Reg.setRegisters(IM.getRS(), IM.getRT(), cu.RegWrite);
                ALUcontrol.setSALUControl(cu.ALUOp, Constants.BinaryToString(IM.getALUControl()));
                ALU.setALU(Reg.ReturnData1(), Constants.Mux(Reg.ReturnData2(), Constants.BinToInt(Constants.signExtend(IM.getSignExtend())), cu.ALUSrc), ALUcontrol.getALUOutput(), cu.UnSigned);
                Constants.JumpOfBranch(ALU.getZeroFlag(), IM.getOperation(), address - 4, IM.LineToJump, cu.Branch, cu.InvetBranch);
                DM.setDataMemory(ALU.getALUResult(), Reg.ReturnData2(), cu.MemRead, cu.MemWrite);
                Reg.setWrtData(Constants.Mux(ALU.getALUResult(), DM.getReadData(), cu.MemtoReg), Constants.Mux(IM.getRT(), IM.getRD(), cu.RegDest));
                System.out.println();
            } else {
                break;
            }
        }//
        Constants.l.printAll();

    }


    public Console() {
        // Scanner s = new Scanner (System.in);
        System.out.println("Initializing Mips Simolator ");
        System.out.println("Enter the frist address ");
        FAddress = sc.nextInt();
        Constants.FristAddress = FAddress;
        address = FAddress;
        FileOrConsole();
        Registers.$ra = LAddress-4;
        Registers.$a0 = 10;
        Registers.$s1 = 0;
        Registers.$a2 = 0;
        Registers.$a3 = 0;
        Registers.$v0 = 0;
        Registers.$t0 = 0;
        Registers.$t1 = 0;
        
        
        int i = 1;
        Constants.l.printAll();
        while (address !=LAddress) {
            System.out.println("this Address : "+address);
            IM.setInstructionMemory(address);
            if(!IM.getOperation().equals("end")){
            System.out.println("Operation : " + IM.getOperation());
            System.out.println("Address to next Instruction:" + address);
            cu.setControlUnit(IM.getControlUnit(), IM.Format);
            if(IM.getOperation().equals("slu"))
                cu.UnSigned=1;
            Constants.CheckJump(IM.getAddressToJump(), cu.Jump, address - 4, IM.getOperation());
            Reg.setRegisters(IM.getRS(), IM.getRT(), cu.RegWrite);
            ALUcontrol.setSALUControl(cu.ALUOp, Constants.BinaryToString(IM.getALUControl()));
            ALU.setALU(Reg.ReturnData1(), Constants.Mux(Reg.ReturnData2(), Constants.BinToInt(Constants.signExtend(IM.getSignExtend())), cu.ALUSrc), ALUcontrol.getALUOutput() , cu.UnSigned);
            Constants.JumpOfBranch(ALU.getZeroFlag(), IM.getOperation(), address - 4, IM.LineToJump, cu.Branch, cu.InvetBranch);
            DM.setDataMemory(ALU.getALUResult(), Reg.ReturnData2(), cu.MemRead, cu.MemWrite);
            Reg.setWrtData(Constants.Mux(ALU.getALUResult(), DM.getReadData(), cu.MemtoReg), Constants.Mux(IM.getRT(), IM.getRD(), cu.RegDest));
            System.out.println("Sv0=  " + Registers.$v0 + ",$s1= " + Registers.$s1);
            System.out.println("Ss0=  " + Registers.$sp);
            // System.out.println(Constants.Memory[3]);
            System.out.println();
            }
            else
                break;
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
                        ins.add(read + " ");
                        Constants.Instructions[numofins] = new Instruction(FAddress, ins.get(numofins), numofins);
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
            }///

        }
        if (selectionCode == 2) {
            try {
                FileReader fr = new FileReader("test.txt");
                BufferedReader br = new BufferedReader(fr);
                System.out.println("Enter the instructions and when you're done type end");
                //while the user dont type end the system take the line and pt it on LinkedList 
                while (true) {
                    read = br.readLine();
                    if (read.equals("end")) {
                        ins.add(read + " ");
                        Constants.Instructions[numofins] = new Instruction(FAddress, ins.get(numofins), numofins);
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
                read = s.nextLine();
                if (read.equals("end")) {
                    ins.add(read + " ");
                    break;
                }
                ins.add(read + " ");
            }
            for (int i = 0; i < ins.size(); i++) {
                Constants.Instructions[i] = new Instruction(FAddress, ins.get(i), i);
            }

        }
    }

    public void read() {

    }
}
