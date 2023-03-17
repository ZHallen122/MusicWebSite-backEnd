package com.music.musicwebsitebackend.entity;

import java.io.Serializable;

/**
* 
* @TableName Favorites
*/
public class Favorites implements Serializable {


    private Integer favorites_id;

    private Integer musicList_Id;

    private Integer music_Id;

    private Integer favorites_numbers;


    private void setFavorites_id(Integer favorites_id){
    this.favorites_id = favorites_id;
    }


    private void setMusicList_Id(Integer musicList_Id){
    this.musicList_Id = musicList_Id;
    }


    private void setMusic_Id(Integer music_Id){
    this.music_Id = music_Id;
    }


    private void setFavorites_numbers(Integer favorites_numbers){
    this.favorites_numbers = favorites_numbers;
    }


    private Integer getFavorites_id(){
    return this.favorites_id;
    }


    private Integer getMusicList_Id(){
    return this.musicList_Id;
    }


    private Integer getMusic_Id(){
    return this.music_Id;
    }


    private Integer getFavorites_numbers(){
    return this.favorites_numbers;
    }

}
