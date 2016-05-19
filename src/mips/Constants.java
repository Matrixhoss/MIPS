/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips;

import java.util.LinkedList;

public class Constants {

    public static final String[] oprations = {"add", "addi", "sub", "lw", "sw", "sll", "and","mul" ,"or", "nor", "beq", "bne", "j", "jal", "jr", "slt", "slti", "sltu", "sltui"};
    public static final String[] reg = {"$0", "$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3", "$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$t8", "$t9", "$k0", "$k1", "$gp", "$sp", "$fp", "$ra"};
    public static final String[] IFormat = {"addi", "lw", "sw", "beq", "bne", "slti", "sltui", "sll"};
    public static final String[] RFormat = {"add", "sub", "and", "or", "nor", "slt", "sltu","mul"};
    public static final String[] JFormat = {"j", "jal", "jr"};
    public static Instruction[] Instructions = new Instruction[1000];
    public static int[] Memory = new int[4000];
    public static int FristAddress = 0;

    //Console Color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    //to save Labels
    public static TotalLabel l = new TotalLabel();

    public static int[] Mux(int x[], int y[], int selection) {
        if (selection == 0) {
            return x;
        } else if (selection == 1) {
            return y;
        }
        return null;
    }
    
    public static int Mux(int x, int y, int selection) {
        if (selection == 0) {
            return x;
        } else if (selection == 1) {
            return y;
        }
        return -1;
    }

    public static int AndGate(int x, int y) {
        if (x == 1 && y == 1) {
            return 1;
        } else {
            return 0;
        }
    }
    public static int XorGate(int x,int y){
        if((x==0&&y==0)||(x==1&&y==1))
            return 0;
        else
            return 1;
    }
    public static int[] IntToBin(int x, String Type) {
        int size = 0;
        int[] y = new int[size];
        switch (Type) {
            case "5bits":
                size = 5;
                break;
            case "6bits":
                size = 6;
                break;
            case "16bits":
                size = 16;
                break;
            case "32bits":
                size = 32;
                break;
        }
        y = getBin(x, size);
        return y;
    }

//    public static int[] getBin(int n, int size) {
//        
//         int[] a = new int[size];
//        try{
//        while (n > 0) {
//            a[size - 1] = n % 2;
//            n = n / 2;
//            size--;
//        }
//        }
//        catch(ArrayIndexOutOfBoundsException ex){
//            
//        }
//        return a;
//    }
    
    public static int[] getBin(int n, int size) {
        int[] a = new int[size];
        int i=size-1;
            
        try{
        if(n>=0 || size<7)
            while (n >= 0) {
            a[size - 1] = n % 2;
            n = n / 2;
            size--;
        }
        else {
            a[0]=1;
            int j=1;
            int temp=-(int)Math.pow(2, i);
            i--;
            while(temp!=n){
                if((temp+(Math.pow(2, i)))<=n){
                    int x = (int)Math.pow(2,i);
                    temp+=x;
                    a[j]=1;
                }
                else a[j]=0;
                i--;
                j++;}
        }
        }
        catch (ArrayIndexOutOfBoundsException ex){
        }
   
        
        return a;
        }
    
    
//    public static int[] getBin(int n, int size) {
//
//        int[] a = new int[size];
//        boolean neg = false;
//        if (n < 0) {
//            n *= -1;
//            neg = true;
//        }
//        try {
//            while (n > 0) {
//                a[size - 1] = n % 2;
//                n = n / 2;
//                size--;
//            }
//            if (neg) {
//                a[0] = 1;
//            }
////        else a[0]=0;
//
//        } catch (ArrayIndexOutOfBoundsException ex) {
//
//        }
//        return a;
//    }

//   public static int BinToInt(int[] x) {
//        int y = 0;
//        for (int i = x.length - 1; i >= 0; i--) {
//            y += x[i] * Math.pow(2, x.length - i - 1);
//        }
//        return y;
//    }
    
//    public static int BinToInt(int[] x) {
//        int y = 0;
//        int numplus = 0;
//        int nummul = 1;
//        if (x[0] == 1 && x.length > 6) {
//            numplus = 1;
//            nummul = -1;
//        }
//        for (int i = x.length - 1; i >= 0 + numplus; i--) {
//            y += x[i] * Math.pow(2, x.length - i - 1);
//        }
//        y *= nummul;
//        return y;
//    }
    public static int BinToInt(int[] x){
        int y =BinToInt(x,false);
        return y;
    }
       public static int BinToInt(int[] x,boolean isUnsigned) {
        int neg;
        int y = 0;
        
        if(x[0]==1 && x.length>7 && !isUnsigned){
            if(x.length>31)
            y++;
            y-= Math.pow(2, x.length-1);
            neg=1;
        }
        
        else neg=0;
        for (int i = x.length-1; i >= neg; i--) {
            y += x[i] * Math.pow(2, x.length - i - 1);
        }
        return y;
    }

    public static int[] and(int x[], int y[]) {
        int Result[] = new int[x.length];
        if (x.length != y.length) {
            return null;
        }
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 1 && y[i] == 1) {
                Result[i] = 1;
            } else {
                Result[i] = 0;
            }
        }
        return Result;
    }

    public static int[] or(int x[], int y[]) {
        int Result[] = new int[x.length];
        if (x.length != y.length) {
            return null;
        }
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 1 || y[i] == 1) {
                Result[i] = 1;
            } else {
                Result[i] = 0;
            }
        }
        return Result;
    }

    public static int[] nor(int x[], int y[]) {
        int Result[] = new int[x.length];
        if (x.length != y.length) {
            return null;
        }
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 1 && y[i] == 1) {
                Result[i] = 0;
            } else if (x[i] == 1 || y[i] == 1) {
                Result[i] = 1;
            } else {
                Result[i] = 0;
            }
        }
        return Result;
    }
     public static String BinaryToString(int x[]) {
        StringBuilder builder = new StringBuilder();
        for (int i : x) {
            builder.append(i);
        }
        String text = builder.toString();
        return text;
    }
     public static int[] signExtend(int[] a) {
        int x = Constants.BinToInt(a);
        int arr[] = {0};
        if (a.length == 16) {
            arr = Constants.getBin(x, 32);
            /*if (a[0] == 1) {
                for (int i = 0; i < 16; i++) {
                    arr[i] = 1;
                }
            }*/
            return arr;
        } else {
            System.out.println("Binary must be 16 bits");
        }
        return arr;
    }
     
     //shift and signExtend for Instruction[15-0]
    public static int LineToBranch(int[] Instruction15T0){
        int[] SignExtend15T0Binary=signExtend(Instruction15T0);
        int SignExAndShift15T0=BinToInt(SignExtend15T0Binary);
        SignExAndShift15T0*=4;//for Instruction[15-0] when pass sign extend and shift left 2
        return SignExAndShift15T0;
    }
    
    public static int makeAddressToJump(int Address,int[] Instruction15T0){
        int AddressToBranch,SignExAndShift15T0;
        SignExAndShift15T0=Constants.LineToBranch(Instruction15T0);
        AddressToBranch=SignExAndShift15T0+Address;
        return AddressToBranch;
    }
    
    public static int makeAddressToBranch(int Address,int[] Instruction15T0){
        int AddressToBranch,SignExAndShift15T0;
        SignExAndShift15T0=Constants.LineToBranch(Instruction15T0);
        System.out.println("SignExAndShift15T0: "+SignExAndShift15T0);
        AddressToBranch=SignExAndShift15T0+Address;
        return AddressToBranch;
    }
    
    public static void JumpOfBranch(int ZeroFlag,String Operation,int address,int LineToJump,int Branch,int InvertBranch){
        int CheckBranch=Constants.XorGate(InvertBranch, ZeroFlag);
        int BranchAndZero=Constants.AndGate(Branch, CheckBranch);
        int AddressJump=Constants.makeAddressToBranch(address, Constants.getBin(LineToJump, 16));
        Console.address=Constants.Mux(address+4, AddressJump, BranchAndZero);
        System.out.println("BranchAndZero: "+BranchAndZero+"\n AddressJump: "+AddressJump+"\n Address+4:  "+(address+4)+"\n LineToJump: "+LineToJump);
    }
    public static void Jump(int AddressToJump,int Jump,int address){
            Console.address=Constants.Mux(address+4,AddressToJump,Jump); 
//            System.out.print("Address +4= "+(address+4)+"address for Jump: "+AddressToJump);
    }
    public static void JumpAtLink(int AddressToJump,int Jump,int address){
            
            Registers.$ra=Constants.Mux(0,address,Jump);
            System.out.println("$ra: "+Registers.$ra+"  Jump: "+Jump);
            Console.address=Constants.Mux(address+4,AddressToJump,Jump);
            
        }    
    public static void JumpR(int AddressToJump,int Jump,int address){
        
            Console.address=Constants.Mux(address+4,AddressToJump+4,Jump);
    }
    public static void CheckJump(int AddressToJump,int Jump,int address,String operation){
        switch(operation){
            case"j":
                Jump(AddressToJump, Jump, address);
                break;
            case"jal":
                JumpAtLink(AddressToJump, Jump, address);
                break;
            case"jr":
                JumpR(Registers.$ra, Jump, address);
                break;
        }
    }
}


class Label {

    private String Label;
    private int address;
    private int Line;

    public Label(String Label, int address,int Line) {
        this.Label = Label;
        this.address = address;
        this.Line=Line;
    }

    @Override
    public String toString() {
        return "Label is :" + this.Label + " address is :" + this.address+" Line is:"+this.Line; //To change body of generated methods, choose Tools | Templates.
    }

    public String getLabel() {
        return Label;
    }

    public int getAddress() {
        return address;
    }
    
    public int getLine() {
        return Line;
    }
    
    public void setLabel(String label) {
        this.Label = label;
    }

    public void setAddress(int address) {
        this.address = address;
    }
    
    public void setLine(int Line) {
        this.Line = Line;
    }

}

class TotalLabel {

    LinkedList<Label> Total = new LinkedList();

    public TotalLabel() {

    }

    public void addLabel(String Label, int address,int Line) {
        this.Total.add(new Label(Label, address,Line));
    }

    public int SearchAddress(String Label) {
        for (int i = 0; i < Total.size(); i++) {
            if (Label.equals(this.Total.get(i).getLabel())) {
                System.out.println("AddressToJump: "+this.Total.get(i).getAddress());
                return this.Total.get(i).getAddress();
            }
        }

        return Console.address;
    }
    
    public int SearchLine(String Label) {
        for (int i = 0; i < Total.size(); i++) {
            if (Label.equals(this.Total.get(i).getLabel())) {
                
                return this.Total.get(i).getLine();
            }
        }

        return -1;
    }

    public void printAll() {
        for (int i = 0; i < this.Total.size(); i++) {
            System.out.println(Total.get(i));
        }

    }
    
    

   
}
