package com.llucascr.dslist.controllers;

import com.llucascr.dslist.dto.GameDTO;
import com.llucascr.dslist.dto.GameMinDTO;
import com.llucascr.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Defini a classe como um controlador
@RequestMapping(value = "games") // Define o caminho da requisição http
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping//(name = "gamemindto")
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return gameService.findById(id);
    }

}
