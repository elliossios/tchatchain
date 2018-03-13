package com.elliottbrunet.blockchain;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Tchachain {

    public static int difficulty = 5;

    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {
        blockchain.add(new Block("first block", "0"));
        System.out.println("mining block 1");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("second block", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("mining block 2");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("third block", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("mining block 3");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nBlockchain: ");
        System.out.println("the blockchain : " + blockchainJson);
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash with calculated hash
            if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("current hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("previous hashes not equal");
                return false;
            }
            //check if hash is sloved
            if(!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("block hasn't been minded");
                return false;
            }
        }
        return true;
    }
}
