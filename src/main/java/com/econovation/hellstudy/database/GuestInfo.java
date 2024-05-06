package com.econovation.hellstudy.database;


import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
public class GuestInfo {
    private final String userId;
    @Setter
    private Long firstAccessTime; //방 입장 시간
    private final List<Long> unreadMessageNumbers = new ArrayList<>();

    public GuestInfo(String userId, long firstAccessTime) {
        this.userId = userId;
        this.firstAccessTime = firstAccessTime;
    }

}
