package com.liuyuhang.week4;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public  void init() {
        ServletContext config=getServletContext();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->"+con);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate= request.getParameter("birthdate");

        String sql="insert into usertable(id,username,password,email,gender,birthdate) values("+id+",'"+username+"','"+password+"','"+email+"','"+gender+"','"+birthdate+"')";
        try {
            con.createStatement().executeUpdate(sql);
            ResultSet rs=con.createStatement().executeQuery("select * from usertable");
            response.setContentType("textml");
            PrintWriter out= response.getWriter();
            out.println("<html><body><table border='1'>");
            out.println("<tr><th>id</th><th>username</th><th>password</th><th>email</th><th>gender</th><th>birthdate</th></tr>");
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                String email1 = rs.getString("email");
                String gender1 = rs.getString("gender");
                Date birthdate1 = rs.getDate("birthdate");
                out.println("<tr><td>"+id1+"</td>");
                out.println("<td>"+username1+"</td>");
                out.println("<td>"+password1+"</td>");
                out.println("<td>"+email1+"</td>");
                out.println("<td>"+gender1+"</td>");
                out.println("<td>"+birthdate1+"</td>");
            }
            out.println("</tr></table></body><ml>");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
