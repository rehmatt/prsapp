package com.christensen.prsapp.repositories;

import com.christensen.prsapp.repositories.entities.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByName(String name);
}


