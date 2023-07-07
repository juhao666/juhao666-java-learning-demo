package com.juhao666.elsticsearch.controller;

import com.juhao666.elsticsearch.common.Result;
import com.juhao666.elsticsearch.entity.Article;
import com.juhao666.elsticsearch.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/es")
public class ElasticsearchController {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping
    //add
    public Result<Iterable<Article>> create(@RequestBody List<Article> articleList) {
       //return Result.success(elasticsearchRestTemplate.save(articleList));
        return Result.success(articleRepository.saveAll(articleList));
    }

    @PutMapping("/update-repo")
    //updated by repository
    public Result<Article> update(@RequestBody Article article) {
        return Result.success(articleRepository.save(article));
    }

    @PutMapping("/update-temp")
    //updated by template
    public Result<UpdateResponse> update(@RequestParam String id,
                                         @RequestParam String title,
                                         @RequestParam String content) {

        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("content", content);

        Document document = Document.from(params);

        UpdateQuery updateQuery = UpdateQuery.builder(id)
                .withDocument(document)
                .build();

        articleRepository.save(new Article());
        return Result.success(elasticsearchRestTemplate.update(updateQuery,IndexCoordinates.of("article")));
    }


    @DeleteMapping("del-repo")
    public Result<Boolean> delete(@RequestParam Long id) {
        articleRepository.deleteById(id);
        return Result.success(Boolean.TRUE);
    }

    @DeleteMapping("del-temp")
    public Result<String> delete(@RequestParam String id) {
        return Result.success(elasticsearchRestTemplate.delete(id, Article.class));
    }

    @GetMapping("/search-title")
    public Result<Page<Article>> searchByTitle(@RequestParam String title) {

        Pageable pageable = PageRequest.of(0,10);  // page 从第 0 页开始

        return Result.success(articleRepository.findByTitleLike(title, pageable));
    }

    @GetMapping("/search-temp")
    public Result<SearchHits<Article>> search(String keyWord) {

        // page 从第 0 页开始
        Pageable pageable = PageRequest.of(0,10);

        HighlightBuilder.Field highlightField = new HighlightBuilder.Field("title")
                .preTags("<span>")
                .postTags("</span>");

        Query query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(keyWord, "author","title","content"))
                .withHighlightFields(highlightField)
                .withPageable(pageable)
                .build();
        SearchHits<Article> search = elasticsearchRestTemplate.search(query, Article.class);
        return Result.success(search);
    }

    @GetMapping("/count")
    public Result<Long> count(String keyWord) {// page 从第 0 页开始

        Query query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(keyWord, "author","title","content"))
                .build();

        return Result.success(elasticsearchRestTemplate.count(query, Article.class));
    }
}
