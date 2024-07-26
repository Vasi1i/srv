package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Random;

@Component
public class HeaderFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("test", String.valueOf(new Random().nextInt(Integer.MAX_VALUE)));
        chain.doFilter(request, httpServletResponse);
    }
}
