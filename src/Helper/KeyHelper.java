package Helper;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KeyHelper {
    private static String key = "ThisIsASecretKey";
    public static String encrypt(String plaintext) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");

        // Create a Cipher object for AES encryption
        Cipher cipher = Cipher.getInstance("AES");

        // Initialize the Cipher object with the key and set to encrypt mode
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the plaintext
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

        // Convert the encrypted bytes to a hexadecimal string for easy storage/transmission

        return javax.xml.bind.DatatypeConverter.printHexBinary(encryptedBytes);
    }
    public static String hashSHA256(String plaintext) throws NoSuchAlgorithmException {
        // Create a MessageDigest object for SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Perform the hash computation
        byte[] hashBytes = digest.digest(plaintext.getBytes());

        // Convert the byte array to a hexadecimal string for easy storage/transmission
        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static boolean hashCompare(String plaintextPassword, String hashedPassword) throws NoSuchAlgorithmException {
        String hashedPlaintextPassword = hashSHA256(plaintextPassword);
        return hashedPlaintextPassword.equals(hashedPassword);
    }
}
