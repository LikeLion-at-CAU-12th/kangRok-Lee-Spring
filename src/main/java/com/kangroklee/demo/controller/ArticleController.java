package com.kangroklee.demo.controller;

import com.kangroklee.demo.dto.request.ArticleCreateRequestDto;
import com.kangroklee.demo.dto.request.ArticleUpdateRequestDto;
import com.kangroklee.demo.dto.response.ArticleResponseDto;
import com.kangroklee.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("")
    public ResponseEntity<Long> createArticle(@RequestBody ArticleCreateRequestDto requestDto) {
        Long articleId = articleService.createArticle(requestDto);
        return new ResponseEntity<>(articleId, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ArticleResponseDto> updateArticle(@RequestBody ArticleUpdateRequestDto requestDto) {
        return ResponseEntity.ok(articleService.updateArticle(requestDto));
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<ArticleResponseDto>> getArticlesByMemberId(@PathVariable Long memberId) {
        List<ArticleResponseDto> articles = articleService.findArticlesByMemberId(memberId);
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(articles);
    }

}
