package com.m7.cifrak.mapper;

import com.m7.cifrak.dto.newsType.CreateNewsTypeDto;
import com.m7.cifrak.dto.newsType.UpdateNewsTypeDto;
import com.m7.cifrak.entity.NewsType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface NewsTypeDtoMapper {
    NewsType toEntity(CreateNewsTypeDto dto);

    NewsType toEntity(UpdateNewsTypeDto dto);

    void updateEntityFromDto(CreateNewsTypeDto dto, @MappingTarget NewsType newsType);

    void updateEntityFromDto(UpdateNewsTypeDto dto, @MappingTarget NewsType newsType);
}
