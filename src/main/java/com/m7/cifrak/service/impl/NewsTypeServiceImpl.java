package com.m7.cifrak.service.impl;

import com.m7.cifrak.entity.NewsType;
import com.m7.cifrak.repository.NewsTypeRepository;
import com.m7.cifrak.service.NewsTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsTypeServiceImpl implements NewsTypeService {

    private final NewsTypeRepository newsTypeRepository;

    @Override
    @Nullable
    public NewsType add(NewsType newsType) {
        return getByTitle(newsType.getTitle()) == null
                ? newsTypeRepository.save(newsType)
                : null;
    }

    @Override
    @Nullable
    public NewsType deleteById(Long id) {
        NewsType newsType = getById(id);
        if (newsType != null) {
            newsTypeRepository.deleteById(id);
            return newsType;
        }
        return null;
    }

    @Override
    @Nullable
    public NewsType updateById(Long id, NewsType updatedNewsType) {
        NewsType newsType = getById(id);
        return newsType != null && newsType.getId().equals(updatedNewsType.getId())
                ? newsTypeRepository.save(newsType)
                : null;
    }

    @Override
    @Nullable
    public NewsType getById(Long id) {
        return newsTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<NewsType> getAll() {
        return newsTypeRepository.findAll();
    }

    @Override
    @Nullable
    public NewsType getByTitle(String title) {
        return newsTypeRepository.findByTitle(title).orElse(null);
    }
}
