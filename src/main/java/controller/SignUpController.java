package controller;

import entity.User;
import model.UserModel;
import org.apache.log4j.Logger;
import utility.DataValidator;
import utility.MessageUtil;
import utility.PasswordUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utility.Const.*;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
    final static Logger logger = Logger.getLogger(SignUpController.class);
    protected User populate(HttpServletRequest request){
        User user = new User();
        user.setFirstName(request.getParameter(FIRST_NAME).trim());
        user.setLastName(request.getParameter(LAST_NAME).trim());
        user.setEmail(request.getParameter(EMAIL));
        user.setPhone(request.getParameter(PHONE));
        user.setPassword(PasswordUtils.generateSecurePassword(request.getParameter(PASSWORD)));

        return user;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher(SIGNUP_PAGE).forward(request, response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        User user = populate(request);

        try {
            if(!DataValidator.isEmail(request.getParameter(EMAIL))){
                MessageUtil.setErrorMessage(EMAIL_ERROR,request);
                getServletContext().getRequestDispatcher(SIGNUP_PAGE).forward(request,response);
            }else if(DataValidator.isNull(request.getParameter(FIRST_NAME)) ||DataValidator.isNull(request.getParameter(LAST_NAME))
            || DataValidator.isNull(request.getParameter(EMAIL)) || DataValidator.isNull(request.getParameter(PHONE))
            || DataValidator.isNull(request.getParameter(PASSWORD)) || DataValidator.isNull(request.getParameter(CONFIRM_PASSWORD))){
                MessageUtil.setErrorMessage(EMPTY_ERROR,request);
                getServletContext().getRequestDispatcher(SIGNUP_PAGE).forward(request,response);
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
