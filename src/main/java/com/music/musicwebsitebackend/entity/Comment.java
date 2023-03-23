package com.music.musicwebsitebackend.entity;



import java.io.Serializable;

import java.util.Date;


/**
* 
* table: comment
*/
public class Comment implements Serializable {

    private Integer comment_id;

    private String user_id;

    private Integer music_id;

    private Integer music_list_id;

    private Integer type;

    private Date creatTime;

    private String context;

    private void setComment_id(Integer comment_id){
    this.comment_id = comment_id;
    }

    private void setUser_id(String user_id){
    this.user_id = user_id;
    }

    private void setMusic_id(Integer music_id){
    this.music_id = music_id;
    }

    private void setMusic_list_id(Integer music_list_id){
    this.music_list_id = music_list_id;
    }

    private void setType(Integer type){
    this.type = type;
    }

    private void setCreatTime(Date creatTime){
    this.creatTime = creatTime;
    }

    private void setContext(String context){
    this.context = context;
    }

    private Integer getComment_id(){
    return this.comment_id;
    }

    private String getUser_id(){
    return this.user_id;
    }

    private Integer getMusic_id(){
    return this.music_id;
    }

    private Integer getMusic_list_id(){
    return this.music_list_id;
    }

    private Integer getType(){
    return this.type;
    }

    private Date getCreatTime(){
    return this.creatTime;
    }

    private String getContext(){
    return this.context;
    }
}
