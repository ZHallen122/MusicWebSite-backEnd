package com.music.musicwebsitebackend.entity;



import java.io.Serializable;

import java.util.Date;


/**
* 
* @TableName comment
*/
public class Comment implements Serializable {

    private Integer id;

    private String userId;

    private Integer musicId;

    private Integer musicListId;

    private Integer type;

    private Date creattime;

    private String context;

    private Integer up;

    private void setId(Integer id){
    this.id = id;
    }

    private void setUserId(String userId){
    this.userId = userId;
    }

    private void setMusicId(Integer musicId){
    this.musicId = musicId;
    }

    private void setMusicListId(Integer musicListId){
    this.musicListId = musicListId;
    }

    private void setType(Integer type){
    this.type = type;
    }

    private void setCreattime(Date creattime){
    this.creattime = creattime;
    }

    private void setContext(String context){
    this.context = context;
    }

    private void setUp(Integer up){
    this.up = up;
    }

    private Integer getId(){
    return this.id;
    }

    private String getUserId(){
    return this.userId;
    }

    private Integer getMusicId(){
    return this.musicId;
    }

    private Integer getMusicListId(){
    return this.musicListId;
    }

    private Integer getType(){
    return this.type;
    }

    private Date getCreattime(){
    return this.creattime;
    }

    private String getContext(){
    return this.context;
    }

    private Integer getUp(){
    return this.up;
    }

}
