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

@WebServlet("/basket")
public class BasketController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute(USER) != null){
            List<Basket> basketItems = BasketModel.getBasketItems((User)request.getSession().getAttribute(USER));
            request.setAttribute(BASKET_ITEMS, basketItems);
            getServletContext().getRequestDispatcher(BASKET_PAGE).forward(request,response);
        }
        getServletContext().getRequestDispatcher(MAIN).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(request.getParameter(OPERATION).equals(AMOUNT_CHANGE)){
            BasketModel.updateBasketItem(Integer.parseInt(request.getParameter(AMOUNT)),Long.parseLong(request.getParameter(BOOK_ID_PARAM)),((User)session.getAttribute(USER)).getId());
            response.sendRedirect(BASKET);
        }else if(request.getParameter(OPERATION).equals(OPERATION_REMOVE)){
            BasketModel.deleteBasketItem(Long.parseLong(request.getParameter(BOOK_ID_PARAM)),(User)session.getAttribute(USER));
            response.sendRedirect(BASKET);
        }else if(request.getParameter(OPERATION).equals(OPERATION_BUY)){
            response.sendRedirect(ADDRESS);

        }

    }
}
