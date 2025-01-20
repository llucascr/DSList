package com.llucascr.dslist.services;

import com.llucascr.dslist.dto.GameMinDTO;
import com.llucascr.dslist.entities.Game;
import com.llucascr.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// @Componet
@Service // Injetar a dependecia de componete
public class GameService {

    @Autowired // Injeção de Instancia
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList(); // Transforma a list<Game> em uma List<GameMinDTO>
    }

//    public List<Game> findAllGames() {
//        return gameRepository.findAll();
//    }
}
