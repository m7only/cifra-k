package com.m7.cifrak.service.impl;

import com.m7.cifrak.dto.newsType.CreateNewsTypeDto;
import com.m7.cifrak.dto.newsType.UpdateNewsTypeDto;
import com.m7.cifrak.entity.NewsType;
import com.m7.cifrak.mapper.NewsTypeDtoMapper;
import com.m7.cifrak.repository.NewsTypeRepository;
import com.m7.cifrak.service.NewsTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsTypeServiceImpl implements NewsTypeService {

    private final NewsTypeRepository newsTypeRepository;
    private final NewsTypeDtoMapper dtoMapper;

    @Override
    @Nullable
    public NewsType add(CreateNewsTypeDto createNewsTypeDto) {
        NewsType newsType = dtoMapper.toEntity(createNewsTypeDto);
        return getByTitle(newsType.getTitle()) == null
                ? newsTypeRepository.save(newsType)
                : null;
    }

    @Override
    @Nullable
    @Transactional
    public NewsType deleteById(Long id) {
        Optional<NewsType> typeOptional = newsTypeRepository.findById(id);
        typeOptional.ifPresent(newsTypeRepository::delete);
        return typeOptional.orElse(null);
    }

    @Override
    @Nullable
    @Transactional
    public NewsType updateById(UpdateNewsTypeDto updateNewsTypeDto) {
        NewsType updatedNewsType = dtoMapper.toEntity(updateNewsTypeDto);
        return newsTypeRepository.findById(updatedNewsType.getId()).isPresent()
                ? newsTypeRepository.save(updatedNewsType)
                : null;
    }

    @Override
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
