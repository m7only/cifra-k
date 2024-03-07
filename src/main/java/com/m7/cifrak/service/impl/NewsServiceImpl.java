package com.m7.cifrak.service.impl;

import com.m7.cifrak.dto.news.CreateNewsDto;
import com.m7.cifrak.dto.news.UpdateNewsDto;
import com.m7.cifrak.entity.News;
import com.m7.cifrak.mapper.NewsDtoMapper;
import com.m7.cifrak.repository.NewsRepository;
import com.m7.cifrak.service.NewsService;
import com.m7.cifrak.service.NewsTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final NewsTypeService newsTypeService;
    private final NewsDtoMapper dtoMapper;

    @Override
    @Nullable
    public News add(CreateNewsDto createNewsDto) {
        News news = dtoMapper.toEntity(createNewsDto);
        return getByTitle(news.getTitle()) == null
                ? newsRepository.save(news)
                : null;
    }

    @Override
    @Nullable
    @Transactional
    public News deleteById(Long id) {
        Optional<News> newsOptional = newsRepository.findById(id);
        newsOptional.ifPresent(newsRepository::delete);
        return newsOptional.orElse(null);
    }

    @Override
    @Nullable
    @Transactional
    public News updateById(UpdateNewsDto updatedNewsDto) {
        News updatedNews = dtoMapper.toEntity(updatedNewsDto);
        return newsRepository.findById(updatedNews.getId()).isPresent()
                ? newsRepository.save(updatedNews)
                : null;
    }

    @Override
    @Nullable
    public News getById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    @Override
    public List<News> getAll() {
        return newsRepository.findAll();
    }

    @Override
    @Nullable
    public News getByTitle(String title) {
        return newsRepository.findByTitleIgnoreCase(title).orElse(null);
    }

    @Override
    public List<News> getByNewsType(String newsTypeTitle) {
        return newsRepository.findByNewsType(newsTypeService.getByTitle(newsTypeTitle));
    }
}
