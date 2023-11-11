package com.zhonghuasheng.spring4.springdiwithxmlexample.constructorinject;

import com.zhonghuasheng.spring4.springdiwithxmlexample.constructorinject.service.Encryption;

public class Communication {

    private Encryption encryption;

    /*
     * DI via Constructor injection
     * */
    public Communication(Encryption encryption) {
        this.encryption = encryption;
    }

    public void communicated() {
        encryption.encryptData();
    }
}
