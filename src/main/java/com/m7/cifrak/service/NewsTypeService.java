package com.m7.cifrak.service;

import com.m7.cifrak.entity.News;
import com.m7.cifrak.entity.NewsType;
import org.springframework.lang.Nullable;

import java.util.List;

public interface NewsTypeService {
    @Nullable
    NewsType add(NewsType newsType);

    @Nullable
    NewsType deleteById(Long id);

    @Nullable
    NewsType updateById(Long id, NewsType updatedNewsType);

    @Nullable
    NewsType getById(Long id);

    List<NewsType> getAll();

    @Nullable
    NewsType getByTitle(String title);
}
