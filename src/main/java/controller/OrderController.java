package controller;

import entity.Basket;
import entity.User;
import model.BasketModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static utility.Const.*;

@WebServlet("/orders")
public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Basket> orderItems = BasketModel.getOrderItems((User)session.getAttribute(USER));
        req.setAttribute(ORDER_ITEMS,orderItems);
        getServletContext().getRequestDispatcher(ORDER_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(req.getParameter(OPERATION).equals(OPERATION_REMOVE)){
            BasketModel.deleteBasketItem(Long.parseLong(req.getParameter(BOOK_ID_PARAM)),(User)session.getAttribute(USER));
        }
        resp.sendRedirect(ORDER);
    }
}
