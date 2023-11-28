package com.modeln.graphql.models;

import java.util.List;

public record Actor(Integer id, String name, List<Movie> movies) {}
