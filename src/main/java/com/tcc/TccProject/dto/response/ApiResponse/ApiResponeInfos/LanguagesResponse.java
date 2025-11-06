package com.tcc.TccProject.dto.response.ApiResponse.ApiResponeInfos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LanguagesResponse(@JsonProperty("label") String label,
                                @JsonProperty( "value") String value) {
}
