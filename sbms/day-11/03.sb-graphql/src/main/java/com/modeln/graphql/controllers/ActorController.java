package com.modeln.graphql.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.modeln.graphql.models.Actor;
import com.modeln.graphql.repositories.ActorRepository;

@Controller
public class ActorController {

    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @QueryMapping
    public Actor actorById(@Argument Integer id) {
        return actorRepository.getById(id);
    }
}