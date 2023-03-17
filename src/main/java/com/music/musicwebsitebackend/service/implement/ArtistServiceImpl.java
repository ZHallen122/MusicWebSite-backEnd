package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.ArtistMapper;
import com.music.musicwebsitebackend.dao.MusicMapper;
import com.music.musicwebsitebackend.entity.Artist;
import com.music.musicwebsitebackend.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private MusicMapper musicMapper;

    @Override
    public Boolean insertArtist(Artist artist) {

        return artistMapper.insertArtist(artist)>0 ? true : false;
    }

    @Override
    public Boolean  updateArtist(Artist artist) {
        return artistMapper.updateArtist(artist)>0 ? true : false;
    }

    @Override
    public Boolean deleteArtist(Integer artist_id) {
        musicMapper.deleteMusicByArtistId(artist_id);
        return artistMapper.deleteArtist(artist_id)>0 ? true : false;
    }

    @Override
    public Artist findArtist(Integer artist_id) {
        return artistMapper.findArtist(artist_id);
    }

    @Override
    public List<Artist> findAllArtist() {
        return artistMapper.findAllArtist();
    }

    @Override
    public Artist findArtistByName(String artist_name) {
        return artistMapper.findArtistByName(artist_name);
    }
}
