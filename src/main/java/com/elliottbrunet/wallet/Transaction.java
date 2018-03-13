//package com.elliottbrunet.wallet;
//
//import com.elliottbrunet.HashUtil;
//
//import java.security.PublicKey;
//import java.util.ArrayList;
//
//public class Transaction {
//    public String transactionId;
//    public PublicKey sender;
//    public PublicKey reciepient;
//    public float value;
//    public byte[] signature;
//
//    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
//    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();
//
//    private static int sequence = 0;
//
//    public Transaction(PublicKey from, PublicKey to, float value,  ArrayList<TransactionInput> inputs) {
//        this.sender = from;
//        this.reciepient = to;
//        this.value = value;
//        this.inputs = inputs;
//    }
//
//    // This Calculates the transaction hash (which will be used as its Id)
//    private String calculateHash() {
//        sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
//        return HashUtil.applySha256(
//                HashUtil.getStringFromKey(sender) +
//                        HashUtil.getStringFromKey(reciepient) +
//                        Float.toString(value) + sequence
//        );
//    }
//
//
//
//}
