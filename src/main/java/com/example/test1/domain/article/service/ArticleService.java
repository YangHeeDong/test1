package com.example.test1.domain.article.service;

import com.example.test1.domain.article.entity.Article;
import com.example.test1.domain.article.repository.ArticleRepository;
import com.example.test1.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public RsData<Article> createArticle(String title, String content) {
        Article article = Article.builder()
                .title(title)
                .content(content)
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .build();
        articleRepository.save(article);

        return RsData.of("200","생성되었습니다",article);
    }

    public List<Article> getArticles() {
        return articleRepository.findAllByOrderByIdDesc();
    }

    public RsData<Article> getArticleById(Long id) {
        Optional<Article> article = articleRepository.findById(id);

        if(article.isEmpty()) return RsData.of("200","없는 게시글이에용",null);

        return RsData.of("200","게시글 드가자~",article.get());

    }
}
