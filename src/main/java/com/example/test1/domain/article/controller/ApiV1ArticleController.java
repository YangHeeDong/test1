package com.example.test1.domain.article.controller;

import com.example.test1.domain.article.entity.Article;
import com.example.test1.domain.article.service.ArticleService;
import com.example.test1.global.rsData.RsData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ApiV1ArticleController {

    private final ArticleService articleService;


    // 단건 조회
    @Getter
    @Setter
    public static class getArticleResponseBody{
        private Article article;
        public getArticleResponseBody(Article article){
            this.article = article;
        }
    }

    @GetMapping("{id}")
    @ResponseBody
    public RsData<getArticleResponseBody> getArticleId(@PathVariable Long id){
        RsData<Article> article = articleService.getArticleById(id);

        return RsData.of(article.getResultCode(), article.getMsg(), new getArticleResponseBody(article.getData()));
    }

    // 다건 조회
    @Getter
    @Setter
    public static class getArticlesResponseBody{
        private List<Article> articles;
        public getArticlesResponseBody(List<Article> articles){
            this.articles = articles;
        }
    }

    @GetMapping("")
    @ResponseBody
    public RsData<getArticlesResponseBody> getArticles(){
        List<Article> articles = articleService.getArticles();

        return RsData.of("200", "다건조회", new getArticlesResponseBody(articles));
    }

    // 등록
    @Getter
    @Setter
    public static class ArticleResponseBody{
        private Article article;
        public ArticleResponseBody(Article article){
           this.article = article;
        }
    }

    @Getter
    private static class ArticleRequestBody{
        private String title;
        private String content;
    }

    @PostMapping("")
    @ResponseBody
    public RsData<ArticleResponseBody> createArticle(@RequestBody ArticleRequestBody body){
        RsData<Article> article = articleService.createArticle(body.getTitle(),body.getContent());

        return RsData.of(article.getResultCode(), article.getMsg(), new ArticleResponseBody(article.getData()));
    }

}
