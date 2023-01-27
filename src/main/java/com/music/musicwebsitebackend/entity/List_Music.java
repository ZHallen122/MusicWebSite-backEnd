package com.music.musicwebsitebackend.entity;

public class List_Music {

    private int id;

    private int song_id;

    private int song_List_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public int getSong_List_id() {
        return song_List_id;
    }

    public void setSong_List_id(int song_List_id) {
        this.song_List_id = song_List_id;
    }
}
