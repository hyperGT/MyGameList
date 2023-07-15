package com.fireworks.MyGameList.service;

import com.fireworks.MyGameList.data.GameListDTO;
import com.fireworks.MyGameList.entities.GameList;
import com.fireworks.MyGameList.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> list = gameListRepository.findAll();
        List<GameListDTO> dtoList = list.stream().map(x -> new GameListDTO(x)).toList();
        return dtoList;
    }
}
