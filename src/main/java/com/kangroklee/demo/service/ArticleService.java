package com.kangroklee.demo.service;

import com.kangroklee.demo.domain.*;
import com.kangroklee.demo.dto.request.ArticleCreateRequestDto;
import com.kangroklee.demo.dto.request.ArticleUpdateRequestDto;
import com.kangroklee.demo.dto.response.ArticleResponseDto;
import com.kangroklee.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private MemberJpaRepository memberRepository;
    @Autowired
    private ArticleJpaRepository articleRepository;
    @Autowired
    private CategoryArticleJpaRepository categoryArticleRepository;
    @Autowired
    private ArticleLogJpaRepository articleLogRepository;
    @Autowired
    private CategoryJpaRepository categoryRepository;

    @Transactional
    public long createArticle(ArticleCreateRequestDto requestDto) {
        Member member = memberRepository.findById(requestDto.getMemberId()).orElseThrow(() -> new RuntimeException("해당 아이디를 가진 회원이 존재하지 않습니다."));
        Article article = Article.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .member(member)
                .comments(new ArrayList<>())
                .build();
        articleRepository.save(article);

        ArticleLog articleLog = ArticleLog.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .article(article)
                .build();
        articleLogRepository.save(articleLog);

        List<Long> categoryIds = requestDto.getCategoryIds();
        if (categoryIds != null && !categoryIds.isEmpty()) {
            for (Long categoryId : categoryIds) {
                Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("해당 ID를 가진 카테고리가 존재하지 않습니다."));

                // Category랑 Article이랑 매핑
                CategoryArticle categoryArticle = CategoryArticle.builder()
                        .category(category)
                        .article(article)
                        .build();

                categoryArticleRepository.save(categoryArticle);
            }
        }
        return article.getId();
    }

    @Transactional
    public ArticleResponseDto updateArticle(ArticleUpdateRequestDto requestDto) {
        Article article = articleRepository.findById(requestDto.getArticleId()).orElseThrow(() -> new RuntimeException("해당 id를 가진 게시글이 존재하지 않습니다"));
        List<CategoryArticle> oldCategoryArticles = categoryArticleRepository.findByArticle(article);
        // 제목 내용 카테
        article.setTitle(requestDto.getTitle());
        article.setContent(requestDto.getContent());
        List<Long> categoryIds = requestDto.getCategoryIds();

        Article newArticle = articleRepository.save(article);
        categoryArticleRepository.deleteAll(oldCategoryArticles);

        ArticleLog articleLog = ArticleLog.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .article(newArticle)
                .build();
        articleLogRepository.save(articleLog);

        if (categoryIds != null && !categoryIds.isEmpty()) {
            for (Long categoryId : categoryIds) {
                Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("해당 ID를 가진 카테고리가 존재하지 않습니다."));

                // Category랑 Article이랑 매핑
                CategoryArticle categoryArticle = CategoryArticle.builder()
                        .category(category)
                        .article(newArticle)
                        .build();

                categoryArticleRepository.save(categoryArticle);
            }
        }
        return new ArticleResponseDto(newArticle.getId(), newArticle.getTitle(), newArticle.getContent());
    }


    public List<ArticleResponseDto> findArticlesByMemberId(Long memberId) {
        List<Article> articles = articleRepository.findByMemberId(memberId);
        return articles.stream()
                .map(article -> new ArticleResponseDto(article.getId(), article.getTitle(), article.getContent()))
                .collect(Collectors.toList());
    }

}