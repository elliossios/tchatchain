package com.elliottbrunet.blockchain;

import com.elliottbrunet.HashUtil;

import java.util.Date;

/**
 * @author Elliott Brunet.
 */
public class Block {

    public String hash;
    public String previousHash;
    public String data;
    public long timeStamp;
    public int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = HashUtil.calculateHash(this);
    }

}
