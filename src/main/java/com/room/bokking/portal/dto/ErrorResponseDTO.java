package com.room.bokking.portal.dto;

import lombok.Builder;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // lets do this
public class ErrorResponseDTO {
    private Integer status; // gib status
    @JsonProperty("Error")
    private String error; //gib error
    private Object data; // gib object
}
