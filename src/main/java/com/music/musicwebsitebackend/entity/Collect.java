package com.music.musicwebsitebackend.entity;

;

import java.io.Serializable;

import java.util.Date;


/**
* 
* @TableName collection
*/
public class Collect implements Serializable {

    private Integer id;

    private String user_id;

    private Integer type;

    private Integer music_id;

    private Integer music_list_id;

    private Date create_time;


    private void setId(Integer id){
    this.id = id;
    }


    private void setUser_id(String user_id){
    this.user_id = user_id;
    }


    private void setType(Integer type){
    this.type = type;
    }


    private void setMusic_id(Integer music_id){
    this.music_id = music_id;
    }


    private void setMusic_list_id(Integer music_list_id){
    this.music_list_id = music_list_id;
    }


    private void setCreate_time(Date create_time){
    this.create_time = create_time;
    }


    private Integer getId(){
    return this.id;
    }


    private String getUser_id(){
    return this.user_id;
    }


    private Integer getType(){
    return this.type;
    }


    private Integer getMusic_id(){
    return this.music_id;
    }


    private Integer getMusic_list_id(){
    return this.music_list_id;
    }


    private Date getCreate_time(){
    return this.create_time;
    }

}
