package com.elliottbrunet.blockchain;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * @author Elliott Brunet.
 */
public class Tchachain {

    public static int difficulty = 5;

    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {

        Block block1 = new Block("block 1", "0");
        Miner.mineBlock(block1, difficulty, blockchain);

        Block block2 = new Block("block 2", blockchain.get(blockchain.size() - 1).hash);
        Miner.mineBlock(block2, difficulty, blockchain);

        Block block3 = new Block("block3", blockchain.get(blockchain.size() - 1).hash);
        Miner.mineBlock(block3, difficulty, blockchain);

        System.out.println("\nBlockchain is valid: " + Validator.isChainValid(blockchain, difficulty));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nBlockchain: ");
        System.out.println("the blockchain : " + blockchainJson);
    }

}
