package com.llucascr.dslist.services;

import com.llucascr.dslist.dto.GameDTO;
import com.llucascr.dslist.dto.GameMinDTO;
import com.llucascr.dslist.entities.Game;
import com.llucascr.dslist.projections.GameMinProjection;
import com.llucascr.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// @Componet
@Service // Injetar a dependecia de componete
public class GameService {

    @Autowired // Injeção de Instancia
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList(); // Transforma a list<Game> em uma List<GameMinDTO>
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
