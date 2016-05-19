package mips;

import static mips.Console.address;

public class Pipeline {

    private InstructionMemory IM = new InstructionMemory();
    private Registers Reg = new Registers();
    private ALU ALU = new ALU();
    private ControlUnit cu = new ControlUnit();
    private ALUControl ALUcontrol = new ALUControl();
    private DataMemory DM = new DataMemory();
    private String ins;
    private int[] SignExtend;
    

    public void IF() {
        IM.setInstructionMemory(address);
    }

    public void ID() {
        cu.setControlUnit(IM.getControlUnit(), IM.Format);
        Reg.setRegisters(IM.getRS(), IM.getRT(), cu.RegWrite);
        SignExtend = Constants.signExtend(IM.getSignExtend());

    }

    public void EX() {
        Constants.CheckJump(IM.getAddressToJump(), cu.Jump, address - 4, IM.getOperation());
        ALUcontrol.setSALUControl(cu.ALUOp, Constants.BinaryToString(IM.getALUControl()));
        ALU.setALU(Reg.ReturnData1(), Constants.Mux(Reg.ReturnData2(), Constants.BinToInt(SignExtend), cu.ALUSrc), ALUcontrol.getALUOutput(),cu.UnSigmed);
        Constants.JumpOfBranch(ALU.getZeroFlag(), IM.getOperation(), address - 4, IM.LineToJump, cu.Branch, cu.InvetBranch);

    }

    public void MEM() {
        DM.setDataMemory(ALU.getALUResult(), Reg.ReturnData2(), cu.MemRead, cu.MemWrite);
    }

    public void WB() {
        Reg.setWrtData(Constants.Mux(ALU.getALUResult(), DM.getReadData(), cu.MemtoReg), Constants.Mux(IM.getRT(), IM.getRD(), cu.RegDest));

    }
}
