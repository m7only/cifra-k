package com.m7.cifrak.dto.newsType;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateNewsTypeDto {
    @NotEmpty
    private String title;
    private String color;
}
