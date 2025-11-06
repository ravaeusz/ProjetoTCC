package com.tcc.TccProject.dto.response.ApiResponse.ApiResponseQuestions;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AlternativesResponse(@JsonProperty("letter") String letter,
                                   @JsonProperty("text") String text,
                                   @JsonProperty("file") String file,
                                   @JsonProperty("IsCorrect") boolean IsCorrect) {
}
