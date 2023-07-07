package com.juhao666.elsticsearch.repository;

import com.juhao666.elsticsearch.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

    Page<Article> findByTitleLike(String title, Pageable page);
}
