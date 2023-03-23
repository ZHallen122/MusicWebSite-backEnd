package com.music.musicwebsitebackend.entity;

/**
 *
 * table: list_music
 */
public class List_Music {

    private int list_Music_id;

    private int music_id;

    private int music_List_id;

    public int getList_Music_id() {
        return list_Music_id;
    }

    public void setList_Music_id(int list_Music_id) {
        this.list_Music_id = list_Music_id;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public int getMusic_List_id() {
        return music_List_id;
    }

    public void setMusic_List_id(int music_List_id) {
        this.music_List_id = music_List_id;
    }
}
