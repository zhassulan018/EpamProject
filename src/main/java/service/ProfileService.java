package service;

import entity.User;
import model.UserModel;
import utility.PasswordUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utility.Const.*;

public class ProfileService implements Service {

    protected User populateUserInfo(HttpServletRequest request,User user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPhone(request.getParameter(PHONE));
        newUser.setFirstName(request.getParameter(FIRST_NAME));
        newUser.setLastName(request.getParameter(LAST_NAME));

        return newUser;
    }

    protected User populateUserPassword(HttpServletRequest request,User user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(PasswordUtils.generateSecurePassword(request.getParameter(NEW_PASSWORD)));

        return newUser;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute(USER) != null){
           req.getServletContext().getRequestDispatcher(PROFILE_PAGE).forward(req,resp);
        }
        req.getServletContext().getRequestDispatcher(MAIN).forward(req,resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(req.getParameter(OPERATION).equals(OPERATION_UPDATE)){
            User user = (User) session.getAttribute(USER);
            User newUser = populateUserInfo(req,user);
            UserModel.updateUserInfo(newUser);

            User dbUser = UserModel.findByEmail(user.getEmail());
            session.setAttribute(USER,dbUser);
        }

        if(req.getParameter(OPERATION).equals(OPERATION_CHANGE_PASSWORD)){
            User user = (User) session.getAttribute(USER);
            User newUser = populateUserPassword(req,user);
            UserModel.updateUserPassword(newUser);

        }
        resp.sendRedirect(PROFILE);

    }
}
