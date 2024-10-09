package com.kangroklee.demo.repository;

import com.kangroklee.demo.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleJpaRepository extends JpaRepository<Article, Long> {
    List<Article> findByMemberId(Long memberId);
}
