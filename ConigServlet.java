package com.liuyuhang.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/conig"},
        initParams = {
                @WebInitParam(name="name",value = "liuyuhang"),
                @WebInitParam(name="studentid",value = "2019211001000929"),
        },loadOnStartup = 1
)
public class ConigServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        String studentid=config.getInitParameter("studentid");

        PrintWriter writer=response.getWriter();
        writer.println("name:"+name);
        writer.println("studentid:"+studentid);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
