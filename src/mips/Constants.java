/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips;

public class Constants {

    public static final String[] oprations = {"add", "addi", "sub", "lw", "sw", "sll", "and", "or", "nor", "beq", "bne", "j", "jal", "jr", "stl", "slti", "sltu", "sltui"};
    public static final String[] reg = {"$0","$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3", "$t0","$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$t8", "$t9","$k0","$k1", "$gp", "$sp" ,"$fp","$ra"};
    public static final String[] IFormate = {"addi", "lw", "sw", "beq", "bne", "stli", "stlui", "sll"};
    public static final String[] RFormate = {"add", "sub", "and", "or", "nor", "slt", "sltu"};
    public static final String[] JFormate = {"j", "jal", "jr"};
    public static String [] Instruction  = new String [1000];
    public static int [] Memory = new int [1000] ;

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
    public static int[] IntToBin(int x,String Type){
     int size=0;
     int [] y= new int[size];
     switch (Type){
         case"5bits":
            size=5;
         break;
         case"6bits":  
            size=6;
          break;
         case"16bits":
            size=16;
          break;
         case"32bits":
            size=32;
          break;
     }
     y=getBin(x,size);
    return y;
    }
    public static int[] getBin(int n,int size){
        int [] a =new int [size];
        while(n>0){
              a[size-1]=n%2;
              n=n/2;
              size--;   
        }
        return a;
    }
    
    public static int BinToInt (int [] x){
        int y = 0 ;
        for (int i = 0; i < x.length; i++) {
            y =(int) (y + (x[i]*Math.pow(2, i)));
        }
    return y ;
    }
}

        


