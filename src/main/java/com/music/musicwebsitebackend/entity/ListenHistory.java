package com.music.musicwebsitebackend.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * table: ListenHistory
 */
public class ListenHistory implements Serializable {

    private int user_id;

    private int music_id;

    private Date time;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
