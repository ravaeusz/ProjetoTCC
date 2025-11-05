package com.tcc.TccProject.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public record LanguagesResponse(@JsonProperty("label") String label,
                                @JsonProperty( "value") String value) {
}
