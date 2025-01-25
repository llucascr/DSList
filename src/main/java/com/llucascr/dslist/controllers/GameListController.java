package com.llucascr.dslist.controllers;

import com.llucascr.dslist.dto.GameListDTO;
import com.llucascr.dslist.dto.GameMinDTO;
import com.llucascr.dslist.dto.ReplacementDTO;
import com.llucascr.dslist.services.GameListService;
import com.llucascr.dslist.services.GameService;
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

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId,body.getSourceIndex(), body.getDestinationIndex());
    }
}
