package com.liuyuhang.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletConTextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext config=sce.getServletContext();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

        try {
            Class.forName(driver);
          Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("i am in contextInitialized()"+con);
            config.setAttribute("con",con);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }



    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("i am in contextDestroyed()");
        sce.getServletContext().removeAttribute("con");

    }
}
