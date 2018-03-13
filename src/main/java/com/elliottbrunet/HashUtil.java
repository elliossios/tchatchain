package com.elliottbrunet;

import com.elliottbrunet.blockchain.Block;

import java.security.MessageDigest;

/**
 * @author Elliott Brunet.
 */
public class HashUtil {

    private static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte aHash : hash) {
                String hex = Integer.toHexString(0xff & aHash);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String calculateHash(Block block) {
        return HashUtil.applySha256(block.previousHash + Long.toString(block.timeStamp) + Integer.toString(block.nonce) + block.data);
    }
}
