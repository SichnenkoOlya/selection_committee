package by.sichnenko.committee.util;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Generator {
    private static final Logger LOGGER = LogManager.getLogger(MD5Generator.class);

    public static String generateHash(String value) throws TechnicalException {
        MessageDigest messageDigest;
        byte[] digest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(value.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            //LOGGER.catching(e);
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
