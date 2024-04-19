package com.econovation.springstudy.interceptor;

import com.econovation.springstudy.entity.Session;
import com.econovation.springstudy.service.SessionService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;


@Component
public class CheckingLoginInterceptor implements HandlerInterceptor {
    private final SessionService sessionService;

    public CheckingLoginInterceptor(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();

        if (cookies == null) throw new IllegalArgumentException("로그인이 필요해요");

        Cookie sessionCookie = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("session"))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("로그인이 필요해요"));

        String sessionId = sessionCookie.getValue();

        Session session = sessionService.getSession(sessionId)
                .orElseThrow(()->new IllegalArgumentException("로그인이 필요해요"));

        request.setAttribute("session", session);

        return true;
    }
}
