package com.elliottbrunet.blockchain;

import com.elliottbrunet.HashUtil;

import java.util.ArrayList;

/**
 * @author Elliott Brunet.
 */
public class Validator {

    public static Boolean isChainValid(ArrayList<Block> blockchain, int difficulty) {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            //compare registered hash with calculated hash
            if (!currentBlock.hash.equals(HashUtil.calculateHash(currentBlock))) {
                System.out.println("current hashes not equal");
                return false;
            }

            //compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("previous hashes not equal");
                return false;
            }

            //check if hash is sloved
            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("block hasn't been minded");
                return false;
            }
        }
        return true;
    }
}
