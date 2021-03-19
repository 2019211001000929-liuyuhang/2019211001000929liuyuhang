package com.liuyuhang.week2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class helloservlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter writer=response.getWriter();
        writer.println("Name:liuyuhang");
        writer.println("ID:2019211001000929");
        Date date=new Date();
        writer.println("date and time "+date);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }

}
