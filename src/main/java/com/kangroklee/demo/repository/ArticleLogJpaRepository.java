package com.kangroklee.demo.repository;

import com.kangroklee.demo.domain.Article;
import com.kangroklee.demo.domain.ArticleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleLogJpaRepository extends JpaRepository<ArticleLog, Long> {
    Optional<ArticleLog> findByArticle(Article article);
}
