package service;

import entity.User;
import model.UserModel;
import utility.MessageUtil;
import utility.PasswordUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utility.Const.*;

public class LogInService implements Service {

    protected User populate(HttpServletRequest request){
        User user = new User();

        user.setEmail(request.getParameter(EMAIL));
        user.setPassword(request.getParameter(PASSWORD));

        return user;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = populate(request);
        User dbUser = UserModel.findByEmail(user.getEmail());

        if(dbUser != null && user.getEmail().equals(dbUser.getEmail()) && PasswordUtils.generateSecurePassword(user.getPassword()).equals(dbUser.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute(USER, dbUser);
            response.sendRedirect(MAIN);
        }else {
            MessageUtil.setErrorMessage(LOGIN_ERROR, request);
            request.getServletContext().getRequestDispatcher(LOGIN_PAGE).forward(request,response);
        }

    }
}
