package com.music.musicwebsitebackend.service.implement;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.music.musicwebsitebackend.dao.MusicMapper;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Music_List;
import com.music.musicwebsitebackend.exception.inserS3Exception;
import com.music.musicwebsitebackend.service.MusicService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;

    @Autowired
    private AmazonS3 amazonS3;

//    private static final List<String> NAMES = Arrays.asList("Name1", "Name2", "Name3", "Name4", "Name5");
//    private static final List<Integer> ARTISTS = Arrays.asList(1, 2, 3, 4, 5);
//    private static final List<String> GENRES = Arrays.asList("Rock", "Pop", "Hip-Hop", "Jazz", "Classical");

//    private static final Random RANDOM = new Random();

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

            /** test                        */
//            for(int i=0; i < 5; i++) {
//                String name = NAMES.get(RANDOM.nextInt(NAMES.size()));
//                Integer artist = ARTISTS.get(RANDOM.nextInt(ARTISTS.size()));
//                String genre = GENRES.get(RANDOM.nextInt(GENRES.size()));
//
//                Music testMusic = new Music();
//                testMusic.setName(name);
//                testMusic.setSinger_id(artist);
//                testMusic.setTypes(genre);
//                musicMapper.insertMusic(testMusic);
//            }
//            return true;
    }

    @Override
    public Boolean updateMusic(Music music) {
        return musicMapper.updateMusic(music) > 0 ? true : false;
    }

    @Override
    public Boolean deleteMusic(int id) {
        //delete object in bucket
        Music music = musicMapper.findMusic(id);
        String musicName = music.getName();
        String picAddress = music.getPic();
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
    public List<Music> topFiftyMusic() {
        return musicMapper.topFiftyMusic();
    }

    @Override
    public Music findMusicByName(String name) {
        return musicMapper.findMusicByName(name);
    }
}
