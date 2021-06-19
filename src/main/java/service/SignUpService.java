package service;

import entity.User;
import model.UserModel;
import org.apache.log4j.Logger;
import utility.DataValidator;
import utility.MessageUtil;
import utility.PasswordUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utility.Const.*;

public class SignUpService implements Service {
    final static Logger logger = Logger.getLogger(SignUpService.class);
    protected User populate(HttpServletRequest request){
        User user = new User();
        user.setFirstName(request.getParameter(FIRST_NAME).trim());
        user.setLastName(request.getParameter(LAST_NAME).trim());
        user.setEmail(request.getParameter(EMAIL));
        user.setPhone(request.getParameter(PHONE));
        user.setPassword(PasswordUtils.generateSecurePassword(request.getParameter(PASSWORD)));

        return user;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getServletContext().getRequestDispatcher(SIGNUP_PAGE).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        User user = populate(request);

        try {
            if(!DataValidator.isEmail(request.getParameter(EMAIL))){
                MessageUtil.setErrorMessage(EMAIL_ERROR,request);
                request.getServletContext().getRequestDispatcher(SIGNUP_PAGE).forward(request,response);
            }else if(DataValidator.isNull(request.getParameter(FIRST_NAME)) ||DataValidator.isNull(request.getParameter(LAST_NAME))
            || DataValidator.isNull(request.getParameter(EMAIL)) || DataValidator.isNull(request.getParameter(PHONE))
            || DataValidator.isNull(request.getParameter(PASSWORD)) || DataValidator.isNull(request.getParameter(CONFIRM_PASSWORD))){
                MessageUtil.setErrorMessage(EMPTY_ERROR,request);
                request.getServletContext().getRequestDispatcher(SIGNUP_PAGE).forward(request,response);
            } else {
                UserModel.addUser(user);
                User newUser = UserModel.findByEmail(user.getEmail());
                request.getSession().setAttribute(USER, newUser);
                response.sendRedirect(MAIN);
            }
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    }
}
