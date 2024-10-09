package com.kangroklee.demo.repository;


import com.kangroklee.demo.domain.Article;
import com.kangroklee.demo.domain.ArticleLog;
import com.kangroklee.demo.domain.CategoryArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface CategoryArticleJpaRepository extends JpaRepository<CategoryArticle, Long> {
    List<CategoryArticle> findByArticle(Article article);
}
