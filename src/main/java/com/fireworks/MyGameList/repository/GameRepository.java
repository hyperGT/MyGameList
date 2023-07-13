package com.fireworks.MyGameList.repository;

import com.fireworks.MyGameList.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
