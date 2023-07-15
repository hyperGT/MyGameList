package com.fireworks.MyGameList.repository;

import com.fireworks.MyGameList.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
