package com.econovation.springstudy.service;

import com.econovation.springstudy.entity.Session;
import com.econovation.springstudy.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session createSession(){
        return sessionRepository.save(new Session());
    }

    public Optional<Session> getSession(String strSessionId){
        UUID uuidSessionId = UUID.fromString(strSessionId);
        return sessionRepository.findById(uuidSessionId);
    }
    public Optional<Session> getSession(UUID sessionId){
        return sessionRepository.findById(sessionId);
    }
    public Session getSessionOrThrow(String strSessionId){
        UUID uuidSessionId = UUID.fromString(strSessionId);
        return sessionRepository.findById(uuidSessionId)
                .orElseThrow(()->new IllegalArgumentException("세션 없어요"));
    }
    public Session getSessionOrThrow(UUID sessionId){
        return sessionRepository.findById(sessionId)
                .orElseThrow(()->new IllegalArgumentException("세션 없어요"));
    }
    public void deleteSession(String strSessionId){
        UUID uuidSessionId = UUID.fromString(strSessionId);
        sessionRepository.deleteById(uuidSessionId);
    }
    public void deleteSession(UUID sessionId){
        sessionRepository.deleteById(sessionId);
    }

}
