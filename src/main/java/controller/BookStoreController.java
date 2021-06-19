package controller;

import org.apache.log4j.Logger;
import service.ActionFactory;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class BookStoreController extends HttpServlet {
    private static Logger LOG = Logger.getLogger(BookStoreController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        ActionFactory actionFactory = new ActionFactory();
        Service service = actionFactory.getActionPath(url);
        try{
            service.doGet(req,resp);
        }catch (Exception e){
            LOG.error(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        ActionFactory actionFactory = new ActionFactory();
        Service service = actionFactory.getActionPath(url);

        try{
            service.doPost(req,resp);
        }catch (Exception e){
            LOG.error(e);
        }
    }
}
