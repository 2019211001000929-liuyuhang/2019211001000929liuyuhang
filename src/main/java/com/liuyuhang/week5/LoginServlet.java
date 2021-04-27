package com.liuyuhang.week5;

import com.liuyuhang.dao.UserDao;
import com.liuyuhang.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet (name="LoginServlet" , value="/Login")

public class LoginServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con, Username,Password);

            if (user != null) {
//                Cookie c=new Cookie("sessionid",""+user.getId());
//                c.setMaxAge(10*60);
//               response.addCookie(c);
                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernamecookie=new Cookie("cusername",user.getUsername());
                    Cookie passwordcookie=new Cookie("cpassword",user.getPassword());
                    Cookie rememberMecookie=new Cookie("cRememberMe",rememberMe);
                    usernamecookie.setMaxAge(20);
                    passwordcookie.setMaxAge(20);
                    rememberMecookie.setMaxAge(20);

                    response.addCookie(usernamecookie);
                    response.addCookie(passwordcookie);
                    response.addCookie(rememberMecookie);



                }
                HttpSession session=request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);


                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username or password Error");
                request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request, response);
            }


        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}


//        PrintWriter writer = response.getWriter();
//        try {
//            ResultSet rs =con.createStatement().executeQuery("select * from usertable where username='"+Username+"' and password='"+Password+"'");
//            if(rs.next()) {
//                String username1= rs.getString("username");
//                String password1= rs.getString("password");
//                if (Username.equals(username1) && Password.equals(password1)) {
//                    writer.println("Login Success!!!");
//                    writer.println("Welcome  " + username1);
//                } else {
//                    writer.println("Username or Password Error!!!");
//                }
//                request.setAttribute("id",rs.getInt("id"));
//                request.setAttribute("username",rs.getString("username"));
//                request.setAttribute("password",rs.getString("password"));
//                request.setAttribute("email",rs.getString("email"));
//                request.setAttribute("gender",rs.getString("gender"));
//                request.setAttribute("birthdate",rs.getString("birthdate"));
//
//                request.getRequestDispatcher("userinfo.jsp").forward(request,response);
//
//            }else{
//                request.setAttribute("message","User or Password ERROR!!");
//                request.getRequestDispatcher("Login.jsp").forward(request,response);
//            }
//        } catch (SQLException | ServletException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//}
