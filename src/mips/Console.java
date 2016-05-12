package mips;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Console {

    private int address = 0;
    private LinkedList<String> ins = new LinkedList<String>();
    private int numofins = 0;
    private String read = "";
    Scanner sc = new Scanner(System.in);
    private int selectionCode =0;

    public Console() {

        // Scanner s = new Scanner (System.in);
        System.out.println("Hallo in Mips Simolator ");
        System.out.println("Enter the frist address ");
        address = sc.nextInt();
        FileOrConsole();
        System.out.println(InstructionMemory.Instruction[address]);
        InstructionMemory m = new InstructionMemory(InstructionMemory.Instruction[address]);
    }

    // check the user use file or console to run the programe 
    public void FileOrConsole() {
        // if selectionCode = 1 then the user use file system 
        if (selectionCode == 1) {
            try {
                FileReader fr = new FileReader("test.txt");
                BufferedReader br = new BufferedReader(fr);
                System.out.println("Enter the instructions and when you end tybe end");
                //while the user dont type end the system take the line and pt it on LinkedList 
                while (true) {
                    read = br.readLine();
                    if (read.equals("end")) {
                        break;
                    }
                    ins.add(read + " ");
                    InstructionMemory.Instruction[address] = ins.getLast();
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
            System.out.println("Enter the instructions and when you end tybe end");
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
