package service;

import entity.Book;
import model.BookModel;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utility.Const.*;

public class AddBookService implements Service {
    final static Logger logger = Logger.getLogger(AddBookService.class);
    protected Book populate(HttpServletRequest request){
        Book book = new Book();
        book.setName(request.getParameter(NAME));
        book.setCost(Double.parseDouble(request.getParameter(COST)));
        if(!request.getParameter(URL).trim().equals("")) book.setUrl(request.getParameter(URL));
        book.setBriefInfo(request.getParameter(BRIEF_INFO));
        book.setAmount(Integer.parseInt(request.getParameter(AMOUNT)));
        return book;
    }


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(ADD_BOOK_PAGE).forward(req,resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
