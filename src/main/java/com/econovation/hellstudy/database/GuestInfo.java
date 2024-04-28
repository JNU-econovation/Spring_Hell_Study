package com.econovation.hellstudy.database;


public class GuestInfo {
    private String userId;
    private long firstAccessTime; //방 입장 시간
    private long lastAccessTime;

    public GuestInfo(String userId, long firstAccessTime, long lastAccessTime) {
        this.userId = userId;
        this.firstAccessTime = firstAccessTime;
        this.lastAccessTime = lastAccessTime;
    }

    private void setFirstAccessTime(long firstAccessTime) {
        this.firstAccessTime = firstAccessTime;
    }

    private void setLastAccessTime(long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public void updateFirstAccessTime(long firstAccessTime){
        setFirstAccessTime(firstAccessTime);
    }
    public void updateLastAccessTime(long lastAccessTime){
        setLastAccessTime(lastAccessTime);
    }

    public String getUserId() {
        return userId;
    }

    public long getFirstAccessTime() {
        return firstAccessTime;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }
}
