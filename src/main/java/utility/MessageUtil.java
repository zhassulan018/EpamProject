package utility;

import javax.servlet.http.HttpServletRequest;

import static utility.Const.ERROR;

public class MessageUtil {

    public static void setErrorMessage(String msg, HttpServletRequest request) {
        request.setAttribute(ERROR, msg);
    }

    public static String getErrorMessage(HttpServletRequest request) {
        String val = (String) request.getAttribute(ERROR);
        if (val == null) {
            return "";
        } else {
            return val;
        }
    }
}
