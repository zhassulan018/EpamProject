package utility;

import org.apache.log4j.Logger;

import static utility.Const.EMAIL_REGEX;

public class DataValidator {
    final static Logger logger = Logger.getLogger(DataValidator.class);
    private static final int passwordLength = 8;

    public static boolean isNull(String str){
        if(str == null || str.trim().length() == 0){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isEmail(String val) {

        if (!isNull(val)) {
            try {
                return val.matches(EMAIL_REGEX);
            } catch (NumberFormatException e) {
                logger.error(e);
                return false;
            }

        } else {
            return false;
        }
    }

    public static boolean isPasswordLength(String str){
        if(str.length() >= passwordLength){
            return true;
        }else {
            return false;
        }
    }

}
