package com.tw.web;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chenbojian on 15-6-19.
 */
public class UserLoginCookieTool {

    public static void clearCookie(HttpServletResponse response, String cookieName) {
        Cookie cookieClear = new Cookie(cookieName, "clear cookie");
        cookieClear.setPath("/");
        cookieClear.setMaxAge(0);
        response.addCookie(cookieClear);
    }

    public static void setCookie(HttpServletResponse response,String cookieName, String cookieValue) {
        clearCookie(response,cookieName);
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
