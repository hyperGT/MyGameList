package com.fireworks.MyGameList.controller;

import com.fireworks.MyGameList.data.GameListDTO;
import com.fireworks.MyGameList.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> response = gameListService.findAll();
        return response;
    }

}
