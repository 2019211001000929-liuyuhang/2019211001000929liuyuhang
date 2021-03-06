package com.liuyuhang.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Text = request.getParameter("text");
        String Select = request.getParameter("search");
        response.setContentType("text/html");
        if(Text == null){
            response.sendRedirect("index.jsp");
        }else if(Select.equals("baidu") ){
            response.sendRedirect("https://www.baidu.com/s?wd="+Text);
        }else if(Select.equals("bing")){
            response.sendRedirect("https://cn.bing.com/search?q="+Text);
        }else if(Select.equals("google")){
            response.sendRedirect("https://www.google.com/search?q="+Text);
        }

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
