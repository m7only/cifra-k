package com.m7.cifrak.dto.news;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateNewsDto {
    @NotEmpty
    private String title;

    @NotEmpty
    private String brief;

    @NotEmpty
    private String content;

    @NotNull
    private Long newsTypeId;
}
