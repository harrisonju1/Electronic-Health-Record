package com.ex.controllers;

import com.ex.util.HandlerMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class FrontController extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        String conf = config.getInitParameter("Mappings");
        HandlerMapper.init(conf);
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.length()>=1) {
            path = path.substring(1);
            if (path.charAt(path.length()-1)=='/') {
                path = path.substring(0,path.length()-1);
            }
        }
        // handles all POST, GET, PUT, DELETE as equal
        boolean handled = HandlerMapper.handle(path, req, resp);
        if (handled) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            System.out.println("Path '"+path+"' could not be handled!");
        }
    }
}
