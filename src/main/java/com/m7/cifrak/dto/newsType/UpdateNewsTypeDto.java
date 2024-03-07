package com.m7.cifrak.dto.newsType;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateNewsTypeDto {

    @NotEmpty
    private String id;

    @NotEmpty
    private String title;
    private String color;
}
