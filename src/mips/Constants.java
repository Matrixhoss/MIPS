/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mips;

public class Constants {

    public static final String[] oprations = {"add", "addi", "sub", "lw", "sw", "sll", "and", "or", "nor", "beq", "bne", "j", "jal", "jr", "slt", "slti", "sltu", "sltui"};
    public static final String[] reg = {"$0", "$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3", "$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$t8", "$t9", "$k0", "$k1", "$gp", "$sp", "$fp", "$ra"};
    public static final String[] IFormat = {"addi", "lw", "sw", "beq", "bne", "slti", "sltui", "sll"};
    public static final String[] RFormat = {"add", "sub", "and", "or", "nor", "slt", "sltu"};
    public static final String[] JFormat = {"j", "jal", "jr"};
    public static Instruction[] Instructions = new Instruction[1000];
    public static int[] Memory = new int[1000];
    public static int FristAddress = 0 ;

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

    public static int[] Mux(int x[], int y[], boolean selection) {
        int [] ErrrorArray = {-1}; 
        if (selection == false) {
            return x;
        } else if (selection == true) {
            return y;
        }
        return ErrrorArray ;
    }

    public static int AndGate(int x, int y) {
        if (x == 1 && y == 1) {
            return 1;
        } else {
            return 0;
        }
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

    public static int[] getBin(int n, int size) {
        int[] a = new int[size];
        while (n > 0) {
            a[size - 1] = n % 2;
            n = n / 2;
            size--;
        }
        return a;
    }

    public static int BinToInt(int[] x) {
        int y = 0;
        for (int i = x.length - 1; i >= 0; i--) {
            y += x[i] * Math.pow(2, x.length - i - 1);
        }
        return y;
    }
}
