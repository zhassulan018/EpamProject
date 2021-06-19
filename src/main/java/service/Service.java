package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Service {
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
