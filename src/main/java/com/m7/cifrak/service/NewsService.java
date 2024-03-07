package com.m7.cifrak.service;

import com.m7.cifrak.dto.news.CreateNewsDto;
import com.m7.cifrak.dto.news.UpdateNewsDto;
import com.m7.cifrak.entity.News;
import org.springframework.lang.Nullable;

import java.util.List;

public interface NewsService {
    @Nullable
    News add(CreateNewsDto createNewsDto);

    @Nullable
    News deleteById(Long id);

    @Nullable
    News updateById(UpdateNewsDto updateNewsDto);

    @Nullable
    News getById(Long id);

    List<News> getAll();

    @Nullable
    News getByTitle(String brief);

    List<News> getByNewsType(String newsTypeTitle);
}
