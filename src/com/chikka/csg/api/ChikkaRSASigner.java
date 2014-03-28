package com.chikka.csg;

import java.security.Signature;
import java.security.SignatureException;
import java.security.NoSuchAlgorithmException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.InvalidKeyException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import util.Base64;


/**
 *  Tentative library for Chikka RSA Signer compatible with Chikka Service Gateways' Web Frontend
 */
public class ChikkaRSASigner {
    /**
     *  Signs the provided message with the specified Private Key in DER format.
     *  Please refer to OpenSSL manual on how to convert to and from DER and PEM formats.
     *  See http://lmgtfy.com/?q=how+to+convert+pem+to+der+using+openssl
     *  
     *  @param message String to sign
     *  @param derPrivateKey File object containing the Private Key in DER format
     */
    public static String sign(String message, File derPrivateKey)
            throws FileNotFoundException, IOException,
                   NoSuchAlgorithmException, InvalidKeyException,
                   InvalidKeySpecException, SignatureException{

        FileInputStream fis = new FileInputStream(derPrivateKey);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int) derPrivateKey.length()];
        dis.readFully(keyBytes);
        dis.close();

        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privkey;
        privkey = kf.generatePrivate(spec);

        Signature instance = Signature.getInstance("SHA512withRSA");
        instance.initSign(privkey);
        instance.update((message).getBytes());
        byte[] signature = instance.sign();
        String encSig = Base64.encodeToString(signature, false);
        return (encSig.replaceAll("\\s", ""));
    }
}

