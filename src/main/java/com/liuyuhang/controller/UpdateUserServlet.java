package com.liuyuhang.controller;

import com.liuyuhang.dao.UserDao;
import com.liuyuhang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
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
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id = Integer.parseInt(request.getParameter("id"));
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        String Email = request.getParameter("email");
        String Gender = request.getParameter("gender");
        Date Birthdate= Date.valueOf(request.getParameter("birthdate"));

        UserDao userDao=new UserDao();
        User user=new User();
        user.setId(Id);
        user.setUsername(Username);
        user.setPassword(Password);
        user.setEmail(Email);
        user.setGender(Gender);
        user.setBirthdate(Birthdate);
        try {
            User user1=userDao.updateUser(con,user);
            if(user1!=null){
                HttpSession session=request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setAttribute("user", user1);

                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
            }


        }
         catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
