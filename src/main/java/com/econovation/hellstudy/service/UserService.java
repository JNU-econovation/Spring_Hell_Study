package com.econovation.hellstudy.service;

import com.econovation.hellstudy.database.Database;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Database database;

    public UserService(Database database) {
        this.database = database;
    }

}
