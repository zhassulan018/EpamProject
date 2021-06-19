package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utility.Const.LANG;
import static utility.Const.MAIN;

public class LanguageService implements Service {


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute(LANG, req.getParameter(LANG));
        resp.sendRedirect(MAIN);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
