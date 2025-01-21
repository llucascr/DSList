package com.llucascr.dslist.dto;

import com.llucascr.dslist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    // Constructors
    public GameListDTO() {
    }

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
