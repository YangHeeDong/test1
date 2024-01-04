package com.example.test1.domain.article.repository;

import com.example.test1.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findAllByOrderByIdDesc();
}
