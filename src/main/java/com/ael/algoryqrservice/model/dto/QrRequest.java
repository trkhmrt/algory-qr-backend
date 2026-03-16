package com.ael.algoryqrservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class QrRequest {
    private String text;
    private Integer height;
    private Integer width;
}
