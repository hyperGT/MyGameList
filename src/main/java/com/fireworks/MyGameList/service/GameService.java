package com.fireworks.MyGameList.service;

import com.fireworks.MyGameList.dto.GameMinDTO;
import com.fireworks.MyGameList.entities.Game;
import com.fireworks.MyGameList.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Game Service vai retornar os Dados (dto)
 * **/

@Service
public class GameService {

    // injetando os componentes (objs) do repository automaticamente
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}