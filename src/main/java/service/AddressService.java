package service;

import entity.Address;
import entity.User;
import model.AddressModel;
import model.BasketModel;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static utility.Const.*;

public class    AddressService implements Service {
    final static Logger logger = Logger.getLogger(AddressService.class);
    protected Address populate(HttpServletRequest request){
        Address address = new Address();
        address.setCity(request.getParameter(CITY));
        address.setStreet(request.getParameter(STREET));
        address.setHouseNumber(request.getParameter(NUMBER_HOME));
        return address;
    }


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(ADDRESS_PAGE).forward(req,resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Address address = populate(req);
        HttpSession session = req.getSession();
        try {
            AddressModel.addAddress(address,(User)session.getAttribute(USER));
            BasketModel.changeBasketItemState((User) session.getAttribute(USER));
            resp.sendRedirect(MAIN);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
    }

}
