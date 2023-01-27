package com.music.musicwebsitebackend.entity;

import java.io.Serializable;

/**
* 
* @TableName Rank
*/
public class Rank implements Serializable {


    private Integer id;

    private Integer musicList_Id;

    private Integer music_Id;

    private Integer score;


    private void setId(Integer id){
    this.id = id;
    }


    private void setMusicList_Id(Integer musicList_Id){
    this.musicList_Id = musicList_Id;
    }


    private void setMusic_Id(Integer music_Id){
    this.music_Id = music_Id;
    }


    private void setScore(Integer score){
    this.score = score;
    }


    private Integer getId(){
    return this.id;
    }


    private Integer getMusicList_Id(){
    return this.musicList_Id;
    }


    private Integer getMusic_Id(){
    return this.music_Id;
    }


    private Integer getScore(){
    return this.score;
    }

}
