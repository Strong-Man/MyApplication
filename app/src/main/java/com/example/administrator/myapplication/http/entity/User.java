package com.example.administrator.myapplication.http.entity;

/**
 * Created by zpw on 2018/5/23.
 */

public class User {
    public String nickname;
    public String tcdesc;
    public Integer worktimes;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTcdesc() {
        return tcdesc;
    }

    public void setTcdesc(String tcdesc) {
        this.tcdesc = tcdesc;
    }

    public Integer getWorktimes() {
        return worktimes;
    }

    public void setWorktimes(Integer worktimes) {
        this.worktimes = worktimes;
    }
}
