package com.liuyuhang.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter")
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    System.out.println("I am in Hellofilter-->init()");
    }

    public void destroy() {
        System.out.println("I am in HelloFilter-->destroy()");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("I am in HelloFilter-->doFilter()-before servlet-(request come here)");

        chain.doFilter(request, response);
        System.out.println("I am in HelloFilter-->doFilter()-AFTER servlet (response come here)");

    }
}
