
package mips;


public class DataMemory {
    private int DataAdderss ;
    private int WriteData;
    private int ReadData ;

    public DataMemory() {
        
        
    }
    
    public void setDataMemory(int DataAdderss, int WriteData,int MemRead , int MemWrite){
         
        this.DataAdderss = DataAdderss/4;
        this.WriteData = WriteData;
        
        if (MemRead == 1 && MemWrite == 1) {
            System.out.println(Constants.ANSI_RED+ "Error in DataMemory "+Constants.ANSI_RESET);
        }
        else{ 
        if (MemRead == 1) {
            this.ReadData = Constants.Memory[this.DataAdderss];
        }
        if (MemWrite == 1) {
             Constants.Memory[this.DataAdderss] = WriteData ;
        }
        }
    }
    
    public int getReadData (){
    return this.ReadData;
    }
}
