
package mips;

public class Registers {
    
   public static int $0  =0;
   public static int $at =0;
   public static int $v0 =0;
   public static int $v1 =0;
   public static int $a0 =0;
   public static int $a1 =0;
   public static int $a2 =0;
   public static int $a3 =0;
   public static int $t0 =0;
   public static int $t1 =0;
   public static int $t2 =0;
   public static int $t3 =0;
   public static int $t4 =0;
   public static int $t5 =0;
   public static int $t6 =0;
   public static int $t7 =0;
   public static int $s0 =0;
   public static int $s1 =0;
   public static int $s2 =0;
   public static int $s3 =0;
   public static int $s4 =0;
   public static int $s5 =0;
   public static int $s6 =0;
   public static int $s7 =0;
   public static int $t8 =0;   
   public static int $t9 =0;
   public static int $k0 =0;
   public static int $k1 =0;
   public static int $k2 =0;
   public static int $gp =0;
   public static int $sp =0;
   public static int $fp =0;
   public static int $ra =0;
   
   public Registers(int[]Reg1, int[]Reg2,int[]WrtReg, int[]WrtData){
       int LocReg1=Constants.BinToInt(Reg1);
       int LocReg2=Constants.BinToInt(Reg2);

       int ReadData1;
       int ReadData2;
        for (int i=0;i<=Constants.reg.length;i++){
            if (i== LocReg1){
            ReadData1=getValue(i);
            }
                
        }
        for (int i=0;i<=Constants.reg.length;i++){
            if (i== LocReg2){
            ReadData2=getValue(i);
            }
                
        }
   
   }
   public int getValue(int Loc){
       for(int i=0;i<=Constants.reg.length;i++){
       switch(Constants.reg[i]){
           case "$0":
               return $0;             
            case"$at":
               return $at;
            case"$v0":
                return $v0;
            case"$v1":
                return $v1;
            case"$a0":
                return $a0;
            case"$a1":
                return $a1;
            case"$a2":
                return $a2;
            case "$a3":
                return $a3;
            case "$t0":
                return $t0;
            case"$t1":
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
            case"$t9":
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
   

}
