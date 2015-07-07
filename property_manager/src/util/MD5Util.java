package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class MD5Util {
	public static String md5(String string) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] value = md.digest(string.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(value);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
