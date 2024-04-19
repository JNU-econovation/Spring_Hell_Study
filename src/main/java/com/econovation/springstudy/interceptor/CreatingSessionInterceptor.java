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
public class CreatingSessionInterceptor implements HandlerInterceptor {
    private final SessionService sessionService;

    public CreatingSessionInterceptor(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();

        if (cookies != null)
            //세션 고정 방지
            Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("session"))
                .findAny()
                .ifPresent(cookie -> sessionService.deleteSession(cookie.getValue()));

        Session session = sessionService.createSession();
        request.setAttribute("session", session);

        Cookie sessionCookie = new Cookie("session", session.getId().toString());
        sessionCookie.setMaxAge(10000);
        sessionCookie.setPath("/");
        sessionCookie.setHttpOnly(true);
        response.addCookie(sessionCookie);

        return true;
    }
}
