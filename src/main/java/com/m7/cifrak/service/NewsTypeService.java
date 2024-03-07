package com.m7.cifrak.service;

import com.m7.cifrak.dto.newsType.CreateNewsTypeDto;
import com.m7.cifrak.dto.newsType.UpdateNewsTypeDto;
import com.m7.cifrak.entity.NewsType;
import org.springframework.lang.Nullable;

import java.util.List;

public interface NewsTypeService {
    @Nullable
    NewsType add(CreateNewsTypeDto createNewsTypeDto);

    @Nullable
    NewsType deleteById(Long id);

    @Nullable
    NewsType updateById(UpdateNewsTypeDto updateNewsTypeDto);

    @Nullable
    NewsType getById(Long id);

    List<NewsType> getAll();

    @Nullable
    NewsType getByTitle(String title);
}
