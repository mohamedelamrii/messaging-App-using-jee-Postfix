package com.email.metier;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;



import com.email.entities.User;

public interface IUser {
	
	
	
//	public User findOne(int id);
	public boolean findOne(String email);
//	public Collection<User> findAll();
//	public void add(User user);
//	public void update(User user);
//	public void delete(int id);
public void RegisterUser(User user);
public static String getsh(String password) {
	try {
        // getInstance() method is called with algorithm SHA-512
        MessageDigest md = MessageDigest.getInstance("MD5");

        // digest() method is called
        // to calculate message digest of the input string
        // returned as array of byte
        byte[] messageDigest = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16)); 

        // Add preceding 0s to make it 32 bit
        while (hexString.length() < 32) {
        	hexString.insert(0, '0');
        }

        // return the HashText
        return hexString.toString();
    }

    // For specifying wrong message digest algorithms
    catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}
}
