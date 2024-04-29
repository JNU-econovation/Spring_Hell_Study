package com.econovation.hellstudy.user;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {

    String id;
    List<String> blackListUser = new ArrayList<>();

}
