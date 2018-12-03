package com.isa.usersengine.servlets;

import com.isa.usersengine.cdi.RandomUserCDIApplicationDaoBean;
import com.isa.usersengine.cdi.RandomUserCDIRequestDao;
import com.isa.usersengine.cdi.RandomUserCDIRequestDaoBean;
import com.isa.usersengine.cdi.RandomUserCDISessionDaoBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/random-user")
public class RandomUserServlet extends HttpServlet {

    @Inject
    RandomUserCDIApplicationDaoBean randomUserCDIApplicationDaoBean;
    @Inject
    RandomUserCDISessionDaoBean randomUserCDISessionDaoBean;
    @Inject
    RandomUserCDIRequestDaoBean randomUserCDIRequestDaoBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writter = resp.getWriter();

        writter.println(randomUserCDIApplicationDaoBean.getRandomUser().getName());
        writter.println(randomUserCDISessionDaoBean.getRandomUser().getName());
        writter.println(randomUserCDIRequestDaoBean.getRandomUser().getName());

    }
}
