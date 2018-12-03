package com.isa.usersengine.servlets;

import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UsersRepositoryDao userDao = new UsersRepositoryDaoBean();
        User user = new User();
        PrintWriter writer = resp.getWriter();

        writer.println("Users count before adding " + userDao.getUsersList().size());

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String age = req.getParameter("age");



        user.setId(Integer.parseInt(id));
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setAge(Integer.parseInt(age));


        userDao.addUser(user);

        writer.println("Users count after adding " + userDao.getUsersList().size());

    }
}
