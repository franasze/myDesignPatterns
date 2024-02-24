package com.apkaSklepu.hashowanie;

import com.apkaSklepu.core.implementation.Authenticator;
import org.apache.commons.codec.digest.DigestUtils;

public class PassHash {

    public static void main(String[] args) {
        Authenticator authenticator = Authenticator.getInstance();
        System.out.println(DigestUtils.md5Hex("admin" + authenticator.seed));
    }

}
