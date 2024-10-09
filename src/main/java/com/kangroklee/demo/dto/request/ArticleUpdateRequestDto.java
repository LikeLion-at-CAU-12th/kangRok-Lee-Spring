package com.kangroklee.demo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//게시글의 id, 제목, 내용, 카테고리를 받아 게시글을 수정할 것
@Getter
@Setter
@NoArgsConstructor
public class ArticleUpdateRequestDto {
    private Long articleId;
    private String title;
    private String content;
    private List<Long> categoryIds;
}
