package com.music.musicwebsitebackend.utils;

import com.music.musicwebsitebackend.entity.Music;

public class MusicResponse {

    private Music music;
    private String musicUrl;
    private String picUrl;

    public MusicResponse(Music music, String musicUrl, String picUrl) {
        this.music = music;
        this.musicUrl = musicUrl;
        this.picUrl = picUrl;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
