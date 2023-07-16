package com.fireworks.MyGameList.controller;

import com.fireworks.MyGameList.data.GameListDTO;
import com.fireworks.MyGameList.data.GameMinDTO;
import com.fireworks.MyGameList.data.ReplacementDTO;
import com.fireworks.MyGameList.service.GameListService;
import com.fireworks.MyGameList.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    // retorna todas as listas e os seus objetos
    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> response = gameListService.findAll();
        return response;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> response = gameService.findByList(listId);
        return response;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId,@RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
