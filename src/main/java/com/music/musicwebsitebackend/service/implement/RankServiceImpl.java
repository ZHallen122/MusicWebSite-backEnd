package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.RankMapper;
import com.music.musicwebsitebackend.entity.Rank;
import com.music.musicwebsitebackend.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankMapper rankMapper;

    @Override
    public Boolean insertRank(Rank rank) {
        return rankMapper.insertRank(rank) > 0 ? true : false;
    }

    @Override
    public Boolean updateRank(Rank rank) {
        return rankMapper.updateRank(rank) > 0 ? true : false;
    }

    @Override
    public Boolean deleteRank(int id) {
        return rankMapper.deleteRank(id) > 0 ? true : false;
    }

    @Override
    public Rank findRank(Integer id) {
        return rankMapper.findRank(id);
    }

    @Override
    public List<Rank> findAllRank() {
        return rankMapper.findAllRank();
    }
}
