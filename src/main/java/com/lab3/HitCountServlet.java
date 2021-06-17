package com.lab3;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet", value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context=getServletContext();
        Integer counter=(Integer) context.getAttribute("counter");
        if(counter==null){
            counter=1;
            context.setAttribute("counter",counter);
        }else{
            context.setAttribute("counter",counter+1);
        }

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><head><title></title></head><body>");
        out.println("<center><h1>Total Number of Hits</h1></center><br />");
        out.println("<center><h2>"+counter+"</h2></center>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
