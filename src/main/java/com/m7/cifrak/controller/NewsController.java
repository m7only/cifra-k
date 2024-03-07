package com.m7.cifrak.controller;

import com.m7.cifrak.dto.news.CreateNewsDto;
import com.m7.cifrak.dto.news.UpdateNewsDto;
import com.m7.cifrak.entity.News;
import com.m7.cifrak.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@Validated
@Tag(name = "Новости", description = "CRUD новостей")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @PostMapping
    @Operation(summary = "Добавить новость")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Новость добавлена"),
            @ApiResponse(responseCode = "404", description = "Ошибка при добавлении новости")
    })
    public ResponseEntity<News> addNews(@RequestBody @Valid CreateNewsDto createNewsDto) {
        return ResponseEntity.ofNullable(newsService.add(createNewsDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить новость по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Данные получены"),
            @ApiResponse(responseCode = "404", description = "Новость не найдена")
    })
    public ResponseEntity<News> getNewsById(@PathVariable @NotNull Long id) {
        return ResponseEntity.ofNullable(newsService.getById(id));
    }

    @PutMapping
    @Operation(summary = "Обновить новость")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Новость обновлена"),
            @ApiResponse(responseCode = "404", description = "Новость не найдена")
    })
    public ResponseEntity<News> updateNewsById(@RequestBody @Valid UpdateNewsDto updateNewsDto) {
        return ResponseEntity.ofNullable(newsService.updateById(updateNewsDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить новость по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Новость удалена"),
            @ApiResponse(responseCode = "404", description = "Новость не найдена")
    })
    public ResponseEntity<News> deleteNewsById(@PathVariable @NotNull Long id) {
        return newsService.deleteById(id) != null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "Получить список всех новостей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Данные получены"),
            @ApiResponse(responseCode = "404", description = "Новости не найдены")
    })
    public ResponseEntity<List<News>> getAllNews() {
        return ResponseEntity.ofNullable(newsService.getAll());
    }

    @GetMapping("/type/{newsTypeTitle}")
    @Operation(summary = "Получить список всех новостей по названию типа новости")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Данные получены"),
            @ApiResponse(responseCode = "404", description = "Новости не найдены")
    })
    public ResponseEntity<List<News>> getNewsByIdNewsType(@PathVariable @NotEmpty String newsTypeTitle) {
        return ResponseEntity.ofNullable(newsService.getByNewsType(newsTypeTitle));
    }
}
