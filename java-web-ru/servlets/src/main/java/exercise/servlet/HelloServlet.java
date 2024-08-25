package io.hexlet.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");

        String name = req.getParameter("name");

        if (name != null && !name.isEmpty()) {
            res.getWriter().write("Hello, " + name + "!");
        } else {
            res.getWriter().write("Hello, Guest!");
        }
    }
    // END
}
