package com.modeln.graphql.models;

import java.util.List;

public record Movie(Integer id, String title, int year, List<String> genres, String director) {

}
