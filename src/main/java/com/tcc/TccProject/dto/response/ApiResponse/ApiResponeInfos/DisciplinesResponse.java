package com.tcc.TccProject.dto.response.ApiResponse.ApiResponeInfos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DisciplinesResponse(@JsonProperty("label") String label,
                                  @JsonProperty("value") String value ) {
}
