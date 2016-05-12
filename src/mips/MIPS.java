
package mips;

import java.io.IOException;


public class MIPS {


    public static void main(String[] args) {
    //  TheFrame f = new TheFrame() ;
    
//    Console c = new Console();
    int []x=new int [3];
    x=Constants.IntToBin(8,"5bits");
        for (int i = 0; i < 6; i++) {
           System.out.print(x[i]);
        }
    
    }
}
