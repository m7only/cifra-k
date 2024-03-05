package com.m7.cifrak.service;

import com.m7.cifrak.entity.News;
import org.springframework.lang.Nullable;

import java.util.List;

public interface NewsService {
    @Nullable
    News add(News news);

    @Nullable
    News deleteById(Long id);

    @Nullable
    News updateById(Long id, News updatedNews);

    @Nullable
    News getById(Long id);

    List<News> getAll();

    @Nullable
    News getByName(String brief);

    List<News> getByNewsType(String newsTypeTitle);
}
