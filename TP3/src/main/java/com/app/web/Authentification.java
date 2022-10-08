package com.app.web;

import javax.servlet.http.*;

public class Authentification {

    public static boolean isAuthenticated(HttpServletRequest request) {
        HttpSession s = request.getSession(false);
        return s != null && s.getAttribute("user") != null;
    }
    
}