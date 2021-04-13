package com.liuyuhang.week5;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet (name="LoginServlet" , value="/Login")

public class LoginServlet extends HttpServlet {

    Connection con = null;
    String driver;
    String url;
    String username;
    String password;

    @Override
    public void init() throws ServletException {
        super.init();
//        ServletContext context = getServletContext();
//        driver = context.getInitParameter("driver");
//        url = context.getInitParameter("url");
//        username = context.getInitParameter("username");
//        password = context.getInitParameter("password");
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con= (Connection) getServletContext().getAttribute("con");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        PrintWriter writer = response.getWriter();
        try {
            ResultSet rs =con.createStatement().executeQuery("select * from usertable where username='"+Username+"' and password='"+Password+"'");
            if(rs.next()) {
//                String username1= rs.getString("username");
//                String password1= rs.getString("password");
//                if (Username.equals(username1) && Password.equals(password1)) {
//                    writer.println("Login Success!!!");
//                    writer.println("Welcome  " + username1);
//                } else {
//                    writer.println("Username or Password Error!!!");
//                }
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));

                request.getRequestDispatcher("userinfo.jsp").forward(request,response);

            }else{
                request.setAttribute("message","User or Password ERROR!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }
        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
