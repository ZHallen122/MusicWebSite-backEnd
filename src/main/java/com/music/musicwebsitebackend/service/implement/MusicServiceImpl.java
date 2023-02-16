package com.music.musicwebsitebackend.service.implement;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.music.musicwebsitebackend.dao.MusicMapper;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Singer;
import com.music.musicwebsitebackend.exception.inserS3Exception;
import com.music.musicwebsitebackend.service.MusicService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;

    @Autowired
    private AmazonS3 amazonS3;

    @Override
    public boolean insertMusic(Music music, MultipartFile musicFile, MultipartFile picFile) throws SdkClientException, AmazonServiceException{

            boolean checkInsert = false;

            String musicFileName = musicFile.getOriginalFilename();
            String picFileName = picFile.getOriginalFilename();
            String musicPath = "music/" + musicFileName;
            String picPath = "pic/" + picFileName;
            music.setPic(picPath);
            music.setUrl(musicPath);
            try {

                ObjectMetadata musicMetadata = new ObjectMetadata();
                musicMetadata.setContentLength(musicFile.getSize());
                ObjectMetadata picMetadata = new ObjectMetadata();
                picMetadata.setContentLength(picFile.getSize());
                amazonS3.putObject("music-web-music", musicPath, musicFile.getInputStream(), musicMetadata);
                amazonS3.putObject("music-web-music", picPath, picFile.getInputStream(), picMetadata);

                checkInsert = musicMapper.insertMusic(music) > 0 ? true : false;

            } catch (SdkClientException e) {
                throw new SdkClientException("erro SdkClientException");
                
            } catch (IOException a){
                throw new inserS3Exception("erro AmazonServiceException");
            }

        return checkInsert;
    }

    @Override
    public Boolean updateMusic(Music music) {
        return musicMapper.updateMusic(music) > 0 ? true : false;
    }

    @Override
    public Boolean deleteMusic(int id) {
        return musicMapper.deleteMusic(id) > 0 ? true : false;
    }

    @Override
    public Music findMusic(Integer id) {
        return musicMapper.findMusic(id);
    }

    @Override
    public List<Music> findAllMusic() {
        return musicMapper.findAllMusic();
    }

    @Override
    public Music findMusicByName(String name) {
        return musicMapper.findMusicByName(name);
    }
}
