package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(FindUserByIdServlet.class.getName());

    @EJB
    private UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String id = req.getParameter("id");

        PrintWriter writer = resp.getWriter();

        if (id == null || id.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int idParse = Integer.parseInt(id);
        User userById = usersRepositoryDao.getUserById(idParse);


        if (userById != null) {
            writer.println("name: " + userById.getName());
            writer.println("login: " + userById.getLogin());
        } else {
            writer.println("User has not been found!");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
    }
}
