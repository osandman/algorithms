package help;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Generator {
    public static void main(String[] args) {
        String randStr = getRandomStringFromBigInteger(100);
        System.out.println(randStr + " " + randStr.length());
        System.out.println(getRandomString(10, false, true));

    }

    public static String getRandomStringFromBigInteger(int numBits) {
        SecureRandom secureRandom = new SecureRandom();
        BigInteger bigInteger = new BigInteger(numBits, secureRandom);
        return bigInteger.toString(36);
    }

    public static String getRandomString(int count, boolean letters, boolean numbers) {
        return RandomStringUtils.random(count, letters, numbers);
    }
    public static String getRandomString(int count) {
        return getRandomString(count, true, true);
    }
}
