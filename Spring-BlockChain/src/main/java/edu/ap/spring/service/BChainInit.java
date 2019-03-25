package edu.ap.spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.ap.spring.transaction.Transaction;
@Component
@Scope("prototype")
public class BChainInit {
    @Autowired
    public BlockChain bChain;
    @Autowired
    public Wallet coinbase, walletB;
    @Autowired
    public Wallet walletA;
    @Autowired
    public Block genesis, block1;
    @Autowired
    public Transaction genesisTransaction;
    Transaction transaction = new Transaction();

    private Map<String, Wallet> map = new HashMap<String, Wallet>();

    public void setUp() {
        bChain.setSecurity();
        coinbase.generateKeyPair();
        walletA.generateKeyPair();
        walletB.generateKeyPair();

        // create genesis transaction, which sends 100 coins to walletA:
        transaction.setSender(coinbase.getPublicKey());
        transaction.setRecipient(walletA.getPublicKey());
        transaction.setValue(100f);
        transaction.transactionId = "0"; // manually set the transaction id
                                                                                                       // list.
        // creating and Mining Genesis block
        genesis.setPreviousHash("0");
        genesis.setTimeStamp();
        genesis.calculateHash();
        genesis.addTransaction(genesisTransaction, bChain);
        bChain.addBlock(genesis);

        // IS GOOD?
        block1.setPreviousHash(genesis.hash);
        block1.setTimeStamp();
        block1.calculateHash();

        map.put("walletA", walletA);
        map.put("walletB", walletB);
    }

    public Wallet getWalletFromKey(String wallet) {
        return this.map.get(wallet);
    }

}