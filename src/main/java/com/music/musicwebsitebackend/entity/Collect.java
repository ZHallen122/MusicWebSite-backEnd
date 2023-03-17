package com.music.musicwebsitebackend.entity;

;

import java.io.Serializable;

import java.util.Date;


/**
* 
* @TableName collection
*/
public class Collect implements Serializable {

    private Integer collect_id;

    private Integer user_id;

    private Integer type;

    private Integer music_id;

    private Integer music_list_id;

    private Date create_time;


    public Integer getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(Integer collect_id) {
        this.collect_id = collect_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMusic_id() {
        return music_id;
    }

    public void setMusic_id(Integer music_id) {
        this.music_id = music_id;
    }

    public Integer getMusic_list_id() {
        return music_list_id;
    }

    public void setMusic_list_id(Integer music_list_id) {
        this.music_list_id = music_list_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
