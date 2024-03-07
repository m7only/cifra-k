package com.m7.cifrak.mapper;

import com.m7.cifrak.dto.news.CreateNewsDto;
import com.m7.cifrak.dto.news.UpdateNewsDto;
import com.m7.cifrak.dto.newsType.UpdateNewsTypeDto;
import com.m7.cifrak.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NewsDtoMapper {
    @Mapping(target = "newsType.id", source = "newsTypeId")
    News toEntity(CreateNewsDto dto);

    @Mapping(target = "newsType.id", source = "newsTypeId")
    News toEntity(UpdateNewsDto dto);
}
