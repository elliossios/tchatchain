package com.elliottbrunet.blockchain;

import com.elliottbrunet.HashUtil;

import java.util.ArrayList;

/**
 * @author Elliott Brunet.
 */
public class Miner {

    public static void mineBlock(Block block, int difficulty, ArrayList<Block> blockchain) {

        System.out.println("mining block " + blockchain.size());

        String target = new String(new char[difficulty]).replace('\0', '0');

        while (!block.hash.substring(0, difficulty).equals(target)) {
            block.nonce++;
            block.hash = HashUtil.calculateHash(block);
        }

        blockchain.add(block);

        System.out.println("block mined! -> " + block.hash);
    }
}
