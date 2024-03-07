package com.m7.cifrak.controller;

import com.m7.cifrak.dto.newsType.CreateNewsTypeDto;
import com.m7.cifrak.dto.newsType.UpdateNewsTypeDto;
import com.m7.cifrak.entity.NewsType;
import com.m7.cifrak.mapper.NewsTypeDtoMapper;
import com.m7.cifrak.service.NewsTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsType")
@Validated
@Tag(name = "Типы новостей", description = "CRUD типов новостей")
@RequiredArgsConstructor
public class NewsTypeController {

    private final NewsTypeService newsTypeService;
    private final NewsTypeDtoMapper mapper;

    @PostMapping
    @Operation(summary = "Добавить тип новости")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Тип новости добавлен"),
            @ApiResponse(responseCode = "404", description = "Ошибка при добавлении типа новости")
    })
    public ResponseEntity<NewsType> addNewsType(@RequestBody @Valid CreateNewsTypeDto createNewsTypeDto) {
        return ResponseEntity.ofNullable(newsTypeService.add(createNewsTypeDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить тип новости новость по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Данные получены"),
            @ApiResponse(responseCode = "404", description = "Тип новостей не найден")
    })
    public ResponseEntity<NewsType> getNewsTypeById(@PathVariable @NotNull Long id) {
        return ResponseEntity.ofNullable(newsTypeService.getById(id));
    }

    @PutMapping
    @Operation(summary = "Обновить тип новостей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Тип новостей обновлен"),
            @ApiResponse(responseCode = "404", description = "Тип новостей не найден")
    })
    public ResponseEntity<NewsType> updateNewsTypeById(@RequestBody @Valid UpdateNewsTypeDto updateNewsTypeDto) {
        return ResponseEntity.ofNullable(newsTypeService.updateById(updateNewsTypeDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить тип новостей по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Тип новостей удален"),
            @ApiResponse(responseCode = "404", description = "Тип новостей не найден")
    })
    public ResponseEntity<NewsType> deleteNewsTypeById(@PathVariable @NotNull Long id) {
        return newsTypeService.deleteById(id) != null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "Получить список всех типов новостей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Данные получены"),
            @ApiResponse(responseCode = "404", description = "Типы новостей не найдены")
    })
    public ResponseEntity<List<NewsType>> getAllNewsType() {
        return ResponseEntity.ofNullable(newsTypeService.getAll());
    }
}
