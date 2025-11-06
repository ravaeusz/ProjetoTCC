package com.tcc.TccProject.dto.response.ApiResponse.ApiResponseQuestions;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public record ApiResponseQuestions(@JsonProperty("title") String title,
                                   @JsonProperty("index") String index,
                                   @JsonProperty("discipline") String discipline,
                                   @JsonProperty("files") List<String> files,
                                   @JsonProperty("correctAlternative") String correctAlternative,
                                   @JsonProperty("alternativesIntroduction") String alternativesIntroduction,
                                   @JsonProperty("alternatives") List<AlternativesResponse> alternatives) {
}
