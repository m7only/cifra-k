package com.m7.cifrak.repository;

import com.m7.cifrak.entity.News;
import com.m7.cifrak.entity.NewsType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, Long> {
    Optional<News> findByBriefIgnoreCase(String brief);
    List<News> findByNewsType(NewsType newsType);
}
