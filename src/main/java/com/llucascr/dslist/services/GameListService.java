package com.llucascr.dslist.services;

import com.llucascr.dslist.dto.GameListDTO;
import com.llucascr.dslist.dto.GameMinDTO;
import com.llucascr.dslist.entities.GameList;
import com.llucascr.dslist.projections.GameMinProjection;
import com.llucascr.dslist.repositories.GameListRepository;
import com.llucascr.dslist.repositories.GameRepository;
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
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list =  gameRepository.searchByList(listId);

        GameMinProjection obg = list.remove(destinationIndex);
        list.add(sourceIndex, obg);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
