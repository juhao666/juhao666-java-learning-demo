package com.juhao666.elsticsearch.entity;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Accessors(chain = true)
@Document(indexName = "article", createIndex = false)
public class Article {

    @Id
    private Long id;

    @Field(store = true, searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    private String author;

    @Field(store = true, searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    private String title;

    @Field(store = true, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String content;
}