package by.sichnenko.committee.util;

import by.sichnenko.committee.exception.TechnicalException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static by.sichnenko.committee.constant.GeneralConstant.MD5_ALGORITHM;

public class MD5Generator {
    /**
     * Generate hash of string
     *
     * @param value The string of which will be found hash
     * @return Hash of string value
     * @throws TechnicalException .
     */
    public static String generateHash(String value) throws TechnicalException {
        MessageDigest messageDigest;
        byte[] digest;
        try {
            messageDigest = MessageDigest.getInstance(MD5_ALGORITHM);
            messageDigest.reset();
            messageDigest.update(value.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new TechnicalException(e);
        }

        BigInteger bigInt = new BigInteger(1, digest);
        StringBuilder md5Hex = new StringBuilder(bigInt.toString(16));
        while (md5Hex.length() < 32) {
            md5Hex.insert(0, "0");
        }
        return md5Hex.toString();
    }
}
