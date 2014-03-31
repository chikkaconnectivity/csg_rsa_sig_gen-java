package com.chikka.csg.tests;

import com.chikka.csg.api.ChikkaRSASigner;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.security.NoSuchAlgorithmException;

public class RSATests{
    @Test
    public void testRSAGen(){
        String message = "the quality of mercy is not strained";
        String privKeyFilename = "pkcs8.tmp";
        String expectedSignature = "DGoAdSQ8eYNToexm3X37g7WA/pGRHJewtN3sTLW6hdvnyS4fUsPt13qj8rm0MaAzOrLX7Xocly4S\n9wQELhcyFn0cqnYPknt/FsKqT1XiKfYl9Xjclogw+kzpzR+xIPAx4UVrEWBPSapNUY3CNumRpYu5\nGpb5CgYC+cMow4I6WHw=\n";
        //PrintWriter privKeyWriter;
        try{
            PrintWriter privKeyWriter = new PrintWriter(new FileWriter(privKeyFilename));
//            privKeyWriter.print("-----BEGIN RSA PRIVATE KEY-----\nMIICYAIBAAKBgQCFWaIiLN021IfuJz2d+iV4A5EtSy2r4JfPk1/0C+4/Pnflt6+D\nmJsynkE+LwDq4ejTz7mnzmKlF/QajQ40KchXGouQxEMNXYvzrs9y07FOrid7kV2s\n1v6NtEq8ws05C9iuZ/nHdLfmQkKsbEUATrMIZyfGPeTSvLDjFdn7GcVPgwIDAQAB\nAoGAEyOAL6N8xGfQco/TOh8yzXzFk1ic33RGlZYzSVWFBjKzBpdMa3i1nZg1CPW6\nDfwKbIv9u2XVppg/gqgH7omRj0EdeY/8QenBQpsknwjIFKDd/oQmhtPhv/G42Mkd\ntxzUIk9UW45Nse49osT2tguEP0BE6LZRYp2A4IKgOwfZTZECRQCwVtnKe+gVbrQW\nWq3brBv7cygWTLcyALmdSSfiVRj4NyUFMZW4rhxteFx4xZ5ELGGcC0FWVw8YSlfD\nSJuR4G50hWbzFQI9AMGXNUualc0Lj5cr1czXQETUiYXJRSdbb45JOua4A2LMRx1Q\nGDl4/6vJqqRMNDxcbmeHyAiGZ1CzDKg+NwJFAKl7D9+4rxrKR3Oku6yCAnLt/v1P\nxlLct4kgIqE5wMHv3jjbq1bQoKnmIJpC9RX4wefEOYvOKMfjy+34/ux5lC+Rd5zx\nAjwcCRzjxRBasIjr+KIu1yFslmcQI/TK3VgLgBlynkWHQlQuL5JCiH5mT39R6eNK\ntowanDRg364IptV3bAMCRFVP4DbvPf07L2YPE8ewwewB7iLhpqAWmRQ8n/lGRDSj\n123jl5SGcECmpmwmZBIFTUGTOkCHrEdpeIP9O/3GSGjc4pAg\n-----END RSA PRIVATE KEY-----\n");

            privKeyWriter.print("MIICoTAbBgkqhkiG9w0BBQMwDgQINeJAg0XWkh8CAggABIICgPJU7u6j8jB7YFNP\nR0RM+RtPlmIGGELSjmJd24mWY3FzfJ23KksBXY7Mq0xYju812z85DlYTUnhs4z5f\n6oaw9QzFMgsB9qSAvPs5uXuuaJlO9FtmKw2fPa+V8l92wLe+seILjf4LzR3XPbgv\nxzyDyrxxN3RKJAgLsJhuUYj4ZJ/cI4cUgVwVzPaYuK8rzDqfdPV67hUIxmFYveT7\nDRScHJrPJLDb70WzFC5OPnjD6wBO5pjXIh/Y4sDC/Ak5zm76N6YZ2qqYaXuVWxAh\nMqLxBw1zD8exexoe9DIEetG6aPAATw5Nsob+sKx7pog3VJ147s7OQtNRuZyVTnVW\nwrYWRvKfE3nZKkjPEcppuSpYrsxm299ZtgJIBRBrdaVQEe4Mktkx92y2Bu7RtJ9s\nYtlG3BIAxe4fj2FI/kBN79fDqrNUHmcBWKaeQyTTrlhQra8x8TyDVN7TvAAORXWh\n3hMgbIteYo8DV/qLWDY5f0SczqrydoeSyglyJvj/P/20IASNmT8Yl+g+30EnA6If\naF+FJ8A6Awm5vPeQ1T0Et3N3nZKYIAHyWtuMKToMuOsyZWqdEv4fIPTwaUxm5SiP\n4ZnMlU+IcNlsWBdHaF3LZs6DYERoFVU6wOyy73/pqwBfd2RPP/EzB7HdY51uZgwO\nmbeodEMJkM1he3Vhnv7zcdxB11OUmPhBjf98uyobtkQG2neUH2Jphixt6gjd5i6N\nj5CSaRAr8PzT3ifYIKIDwjQmrKG6/p3jdcm9hf/QzfN9UHVGMIhZWTSslc2t3S9M\n23XChI9Uq66JSQM0ZyIcpwWX1C9EVJpfi+9EWV2Rs+o4hI3IgiM22azeYjbfSYy4\nRcbICDQ=");
            privKeyWriter.close();
        } catch(Exception ioe){
            System.err.println("Unable to write temporary private key.");
        } finally{
         //   privKeyWriter.close();
        }

        File privKey = new File(privKeyFilename);

        try{
            String signature = ChikkaRSASigner.sign(message, privKey);
            Assert.assertEquals(signature, expectedSignature);
        } catch(IOException ioe){
            System.err.println("Unable to obtain private key file.");
        } catch(NoSuchAlgorithmException nsae){
            System.err.println("Unkown encryption algorithm.");
        } catch(Exception e){
            System.err.println("Unknown Exception: ");
            e.printStackTrace();
        } finally{
            privKey.delete();
        }
    }
}
