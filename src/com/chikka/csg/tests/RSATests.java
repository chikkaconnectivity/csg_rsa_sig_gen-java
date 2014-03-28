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
        String privKeyFilename = ".privKey.tmp";
        String expectedSignature = "DGoAdSQ8eYNToexm3X37g7WA/pGRHJewtN3sTLW6hdvnyS4fUsPt13qj8rm0MaAzOrLX7Xocly4S\n9wQELhcyFn0cqnYPknt/FsKqT1XiKfYl9Xjclogw+kzpzR+xIPAx4UVrEWBPSapNUY3CNumRpYu5\nGpb5CgYC+cMow4I6WHw=\n";
        //PrintWriter privKeyWriter;
        try{
            PrintWriter privKeyWriter = new PrintWriter(new FileWriter(privKeyFilename));
            privKeyWriter.print("-----BEGIN RSA PRIVATE KEY-----\nMIICYAIBAAKBgQCFWaIiLN021IfuJz2d+iV4A5EtSy2r4JfPk1/0C+4/Pnflt6+D\nmJsynkE+LwDq4ejTz7mnzmKlF/QajQ40KchXGouQxEMNXYvzrs9y07FOrid7kV2s\n1v6NtEq8ws05C9iuZ/nHdLfmQkKsbEUATrMIZyfGPeTSvLDjFdn7GcVPgwIDAQAB\nAoGAEyOAL6N8xGfQco/TOh8yzXzFk1ic33RGlZYzSVWFBjKzBpdMa3i1nZg1CPW6\nDfwKbIv9u2XVppg/gqgH7omRj0EdeY/8QenBQpsknwjIFKDd/oQmhtPhv/G42Mkd\ntxzUIk9UW45Nse49osT2tguEP0BE6LZRYp2A4IKgOwfZTZECRQCwVtnKe+gVbrQW\nWq3brBv7cygWTLcyALmdSSfiVRj4NyUFMZW4rhxteFx4xZ5ELGGcC0FWVw8YSlfD\nSJuR4G50hWbzFQI9AMGXNUualc0Lj5cr1czXQETUiYXJRSdbb45JOua4A2LMRx1Q\nGDl4/6vJqqRMNDxcbmeHyAiGZ1CzDKg+NwJFAKl7D9+4rxrKR3Oku6yCAnLt/v1P\nxlLct4kgIqE5wMHv3jjbq1bQoKnmIJpC9RX4wefEOYvOKMfjy+34/ux5lC+Rd5zx\nAjwcCRzjxRBasIjr+KIu1yFslmcQI/TK3VgLgBlynkWHQlQuL5JCiH5mT39R6eNK\ntowanDRg364IptV3bAMCRFVP4DbvPf07L2YPE8ewwewB7iLhpqAWmRQ8n/lGRDSj\n123jl5SGcECmpmwmZBIFTUGTOkCHrEdpeIP9O/3GSGjc4pAg\n-----END RSA PRIVATE KEY-----\n");
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
