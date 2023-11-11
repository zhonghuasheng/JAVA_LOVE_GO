package com.zhonghuasheng.spring4.springdiwithxmlexample.constructorinject.service.impl;

import com.zhonghuasheng.spring4.springdiwithxmlexample.constructorinject.service.Encryption;

public class EncryptionImpl implements Encryption {

    @Override
    public void encryptData() {
        System.out.println("Encrypting data using RSA Encryption");
    }
}
