package com.sparkforchange.model;

/**
 * Created by Nancy on 01/27/2018.
 */

public class Block {
    private int sparkNum;
    private BlockType blockType;
    private Loginable source;
    private Loginable dest;

    public Block(int sparkNum, BlockType blockType, Loginable source, Loginable dest) {
        this.sparkNum = sparkNum;
        this.blockType = blockType;
        this.source = source;
        this.dest = dest;
    }

    public Loginable getSource() {
        return source;
    }

    public Loginable getDest() {
        return dest;
    }
}
