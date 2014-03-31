package com.chikka.csg.tests;

import com.chikka.csg.api.ChikkaRSASigner;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.security.NoSuchAlgorithmException;

public class RSATests{
    @Test
    public void testRSAGen() throws Exception{
        String message = "the quality of mercy is not strained";
        String privKeyFilename = "../private_key_pkcs8.der";
        String signedFilename = "../signed.b64";
        String signedLoaded = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(signedFilename)));

        try{
            StringBuffer sb = new StringBuffer();
            String line = br.readLine();

            while(line != null){
                sb.append(line);

                line = br.readLine();
            }

            signedLoaded = sb.toString();
        } catch(Exception e){
            System.err.println("Unable to load signed message.");
        } finally{
            br.close();
        }
        
        try{
            File derPrivateKey = new File(privKeyFilename);
            String actualSigned = ChikkaRSASigner.sign(message, derPrivateKey);
            Assert.assertEquals(actualSigned, signedLoaded);
        } catch(Exception e){
            System.err.println("Unable to open private key file.");
        }
        
       
    }
}
