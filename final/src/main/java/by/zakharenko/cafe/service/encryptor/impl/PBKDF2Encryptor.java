package by.zakharenko.cafe.service.encryptor.impl;

import by.zakharenko.cafe.service.encryptor.Encryptor;
import by.zakharenko.cafe.service.exception.ServiceException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class PBKDF2Encryptor implements Encryptor {
    @Override
    public String encrypt(String plaintext) throws ServiceException {
        SecureRandom random = new SecureRandom();
//        byte[] salt = new byte[16];
//        random.nextBytes(salt);
        byte[] salt = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        KeySpec spec = new PBEKeySpec(plaintext.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            String encryptText = new String(hash);
            return encryptText;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new ServiceException(e);
        }
    }
}
