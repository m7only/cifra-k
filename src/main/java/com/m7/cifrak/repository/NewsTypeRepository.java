package com.m7.cifrak.repository;

import com.m7.cifrak.entity.NewsType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsTypeRepository extends JpaRepository<NewsType, Long> {
    Optional<NewsType> findByTitle(String title);
}
