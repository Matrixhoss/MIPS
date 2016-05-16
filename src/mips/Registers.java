package mips;

public class Registers {

    public static final int $0 = 0;
    public static int $at = 1;
    public static int $v0 = 2;
    public static int $v1 = 3;
    public static int $a0 = 4;
    public static int $a1 = 5;
    public static int $a2 = 6;
    public static int $a3 = 7;
    public static int $t0 = 8;
    public static int $t1 = 8;
    public static int $t2 = 10;
    public static int $t3 = 11;
    public static int $t4 = 12;
    public static int $t5 = 13;
    public static int $t6 = 14;
    public static int $t7 = 15;
    public static int $s0 = 16;
    public static int $s1 = 17;
    public static int $s2 = 18;
    public static int $s3 = 19;
    public static int $s4 = 20;
    public static int $s5 = 21;
    public static int $s6 = 22;
    public static int $s7 = 23;
    public static int $t8 = 24;
    public static int $t9 = 25;
    public static int $k0 = 26;
    public static int $k1 = 27;
    public static int $k2 = 28;
    public static int $gp = 29;
    public static int $sp = 30;
    public static int $fp = 31;
    public static int $ra = 32;
    private int ReadData1;
    private int ReadData2;
    private int WrtData;
    private int[] WrtReg;
    private int RegWrt;

    public void setRegisters(int[] Reg1, int[] Reg2, int RegWrite) {
        RegWrt = RegWrite;
        int LocReg1 = Constants.BinToInt(Reg1);
        int LocReg2 = Constants.BinToInt(Reg2);
        System.out.println(Constants.ANSI_PURPLE+LocReg1+Constants.ANSI_RESET);
        // int LocWrtReg=Constants.BinToInt(WrtReg)
        
        for (int i = 0; i <= Constants.reg.length; i++) {//Obtaining the value of ReadData1
            if (i == LocReg1) {
                this.ReadData1 = getValue(i);
                break;
            }

        }
        for (int i = 0; i <= Constants.reg.length; i++) { //Obatining the value of ReadData2
            if (i == LocReg2) {
                this.ReadData2 = getValue(i);
                break;
            }
        }
        /* if (RegWrite==1){
        for (int i=0;i<=Constants.reg.length;i++){ //Writing the data in the Write register
            if (i== LocWrtReg){
            setValue(LocWrtReg,WrtData);    
            }
                
        }
       }*/

    }

    public int getValue(int Loc) {
        for (int i = 0; i <= Constants.reg.length; i++) {
            switch (Constants.reg[Loc]) {  //To determine which register's value would be set as ReadData1 or ReadData2
                case "$0":
                    return $0;
                case "$at":
                    return $at;
                case "$v0":
                    return $v0;
                case "$v1":
                    return $v1;
                case "$a0":
                    return $a0;
                case "$a1":
                    return $a1;
                case "$a2":
                    return $a2;
                case "$a3":
                    return $a3;
                case "$t0":
                    return $t0;
                case "$t1":
                    return $t1;
                case "$t2":
                    return $t2;
                case "$t3":
                    return $t3;
                case "$t4":
                    return $t3;
                case "$t5":
                    return $t5;
                case "$t6":
                    return $t6;
                case "$t7":
                    return $t7;
                case "$s0":
                    return $s0;
                case "$s1":
                    return $s1;
                case "$s2":
                    return $s2;
                case "$s3":
                    return $s3;
                case "$s4":
                    return $s4;
                case "$s5":
                    return $s5;
                case "$s6":
                    return $s6;
                case "$s7":
                    return $s7;
                case "$t8":
                    return $t8;
                case "$t9":
                    return $t9;
                case "$k0":
                    return $k0;
                case "$k1":
                    return $k1;
                case "$gp":
                    return $gp;
                case "$sp":
                    return $sp;
                case "$fp":
                    return $fp;
                case "$ra":
                    return $ra;

            }

        }
        return -1;
    }

    public void setValue(int Loc, int x) {
        switch (Constants.reg[Loc]) { //To determine which register are we going to write the data into

            case "$at":
                $at = x;
                break;
            case "$v0":
                $v0 = x;
                break;
            case "$v1":
                $v1 = x;
                break;
            case "$a0":
                $a0 = x;
                break;
            case "$a1":
                $a1 = x;
                break;
            case "$a2":
                $a2 = x;
                break;
            case "$a3":
                $a3 = x;
                break;
            case "$t0":
                $t0 = x;
                break;
            case "$t1":
                $t1 = x;
                break;
            case "$t2":
                $t2 = x;
                break;
            case "$t3":
                $t3 = x;
                break;
            case "$t4":
                $t4 = x;
                break;
            case "$t5":
                $t5 = x;
                break;
            case "$t6":
                $t6 = x;
                break;
            case "$t7":
                $t7 = x;
                break;
            case "$s0":
                $s0 = x;
                break;
            case "$s1":
                $s1 = x;
                break;
            case "$s2":
                $s2 = x;
                break;
            case "$s3":
                $s3 = x;
                break;
            case "$s4":
                $s4 = x;
                break;
            case "$s5":
                $s5 = x;
                break;
            case "$s6":
                $s6 = x;
                break;
            case "$s7":
                $s7 = x;
                break;
            case "$t8":
                $t8 = x;
                break;
            case "$t9":
                $t9 = x;
                break;
            case "$gp":
                $gp = x;
                break;
            case "$sp":
                $sp = x;
                break;
            case "$fp":
                $fp = x;
                break;
            case "$ra":
                $ra = x;
                break;

        }

    }

    public int ReturnData1() {
        return this.ReadData1;
    }

    public int ReturnData2() {
        return this.ReadData2;
    }

    public void setWrtData(int data, int[] WrtReg) {
        this.WrtData = data;
        this.WrtReg = WrtReg;
        System.out.println("WriteData1: "+this.WrtData);
        if (this.RegWrt == 1) {
            for (int i = 0; i < Constants.reg.length; i++) {

                if (Constants.reg[i].equals(Constants.reg[Constants.BinToInt(WrtReg)])) {
                    if (Constants.reg[i].equals("$0")) {
                        System.out.println(Constants.ANSI_RED + "Cant Write in reg $0" + Constants.ANSI_RESET);
                        return;
                    }
                    
                    setValue(i, WrtData);
                }
            }

        }
        
    }
}