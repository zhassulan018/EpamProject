package service;

import entity.Book;
import entity.User;
import model.BasketModel;
import model.BookModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static utility.Const.*;

public class BookService implements Service {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = BookModel.getAllBooks();
        request.setAttribute(BOOKS,books);
        request.getServletContext().getRequestDispatcher(MAIN_PAGE).forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(request.getParameter(OPERATION).equals(OPERATION_ADD_BOOK_BASKET)) {
            if (session.getAttribute(USER) == null) {
                response.sendRedirect(LOGIN);
            } else {
                Long bookId = Long.parseLong(request.getParameter(BOOK_ID_PARAM));
                Long userId = ((User) session.getAttribute(USER)).getId();
                if (BasketModel.getBasket(userId, bookId) != null) {
                    response.sendRedirect(MAIN);
                } else {
                    BasketModel.addBasketItem(userId, bookId);
                    response.sendRedirect(MAIN);
                }
            }
        }else if(request.getParameter(OPERATION).equals(OPERATION_SEARCH)){
            List<Book> list = BookModel.getBooksLike("%"+request.getParameter(SEARCH_BAR_PARAM)+"%");
            request.setAttribute(BOOKS,list);
            request.getServletContext().getRequestDispatcher(MAIN_PAGE).forward(request,response);
        }
    }
}
