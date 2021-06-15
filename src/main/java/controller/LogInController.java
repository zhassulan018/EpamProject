package controller;

import entity.User;
import model.UserModel;
import utility.MessageUtil;
import utility.PasswordUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utility.Const.*;

@WebServlet("/login")
public class LogInController extends HttpServlet {

    protected User populate(HttpServletRequest request){
        User user = new User();

        user.setEmail(request.getParameter(EMAIL));
        user.setPassword(request.getParameter(PASSWORD));

        return user;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        User user = populate(request);
        User dbUser = UserModel.findByEmail(user.getEmail());

        if(dbUser != null && user.getEmail().equals(dbUser.getEmail()) && PasswordUtils.generateSecurePassword(user.getPassword()).equals(dbUser.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute(USER, dbUser);
            response.sendRedirect(MAIN);
        }else {
            MessageUtil.setErrorMessage(LOGIN_ERROR, request);
            getServletContext().getRequestDispatcher(LOGIN_PAGE).forward(request,response);
        }

    }
}
