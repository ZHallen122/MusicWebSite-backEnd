package com.music.musicwebsitebackend.dao;


import com.music.musicwebsitebackend.entity.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistMapper {

    public int insertArtist(Artist singer);

    public int  updateArtist(Artist singer);

    public int deleteArtist(int artist_id);

    public Artist findArtist(Integer id);

    public List<Artist> findAllArtist();

    public Artist findArtistByName(String name);
}
