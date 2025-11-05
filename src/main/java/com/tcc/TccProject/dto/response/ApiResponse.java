package com.tcc.TccProject.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ApiResponse(@JsonProperty("title") String titulo,
                          @JsonProperty("disciplines")List<DisciplinesResponse> disciplines,
                          @JsonProperty("languages") List<LanguagesResponse> languages) {
}
