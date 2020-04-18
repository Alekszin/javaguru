package helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(6);
    }
    public String randomInt() {
        return RandomStringUtils.randomNumeric(3);
    }

}
