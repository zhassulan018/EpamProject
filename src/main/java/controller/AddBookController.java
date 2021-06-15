package controller;

import entity.Book;
import model.BookModel;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utility.Const.*;

@WebServlet("/addbook")
public class AddBookController extends HttpServlet {
    final static Logger logger = Logger.getLogger(AddBookController.class);
    protected Book populate(HttpServletRequest request){
        Book book = new Book();
        book.setName(request.getParameter(NAME));
        book.setCost(Double.parseDouble(request.getParameter(COST)));
        if(!request.getParameter(URL).trim().equals("")) book.setUrl(request.getParameter(URL));
        book.setBriefInfo(request.getParameter(BRIEF_INFO));
        book.setAmount(Integer.parseInt(request.getParameter(AMOUNT)));
        return book;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(ADD_BOOK_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = populate(req);
        try {
            BookModel.addBook(book);
            resp.sendRedirect(MAIN);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    }
}
