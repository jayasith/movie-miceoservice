package com.example.movie.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class MovieRequest {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private CategoryRequest category;

}
