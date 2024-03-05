package com.m7.cifrak.service.impl;

import com.m7.cifrak.entity.News;
import com.m7.cifrak.repository.NewsRepository;
import com.m7.cifrak.service.NewsService;
import com.m7.cifrak.service.NewsTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final NewsTypeService newsTypeService;

    @Override
    @Nullable
    public News add(News news) {
        return getByName(news.getBrief()) == null
                ? newsRepository.save(news)
                : null;
    }

    @Override
    @Nullable
    public News deleteById(Long id) {
        News news = getById(id);
        if (news != null) {
            newsRepository.deleteById(id);
            return news;
        }
        return null;
    }

    @Override
    @Nullable
    public News updateById(Long id, News updatedNews) {
        News news = getById(id);
        return news != null && news.getId().equals(updatedNews.getId())
                ? newsRepository.save(news)
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
    public News getByName(String brief) {
        return newsRepository.findByBriefIgnoreCase(brief).orElse(null);
    }

    @Override
    public List<News> getByNewsType(String newsTypeTitle) {
        return newsRepository.findByNewsType(newsTypeService.getByTitle(newsTypeTitle));
    }
}
