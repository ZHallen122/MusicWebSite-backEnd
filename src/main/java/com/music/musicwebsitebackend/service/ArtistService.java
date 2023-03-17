package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.Artist;
import com.music.musicwebsitebackend.utils.Result;

import java.util.List;

public interface ArtistService {

    public Boolean insertArtist(Artist artist);

    public Boolean  updateArtist(Artist artist);

    public Boolean deleteArtist(Integer artist_id);

    public Artist findArtist(Integer artist_id);

    public List<Artist> findAllArtist();

    public Artist findArtistByName(String artist_name);
}
