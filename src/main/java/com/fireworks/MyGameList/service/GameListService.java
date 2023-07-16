package com.fireworks.MyGameList.service;

import com.fireworks.MyGameList.data.GameListDTO;
import com.fireworks.MyGameList.entities.GameList;
import com.fireworks.MyGameList.projection.GameMinProjection;
import com.fireworks.MyGameList.repository.GameListRepository;
import com.fireworks.MyGameList.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> list = gameListRepository.findAll();
        List<GameListDTO> dtoList = list.stream().map(x -> new GameListDTO(x)).toList();
        return dtoList;
    }

    @Transactional()
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        // se o valor da posição de origem for menor que o da posição de destino, o valor minimo/menor é o da origem
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min ; i <= max ; i++){  //max = 8, min = 5
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
