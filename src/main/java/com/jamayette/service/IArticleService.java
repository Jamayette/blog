package com.jamayette.service;

import com.jamayette.model.Article;

import java.util.List;

public interface IArticleService {

	List<Article> findAllArticles();

	Article findArticleByName(String name);

	boolean saveArticle(Article article);

	Boolean deleteArticle(Integer id);

	Article findArticleById(Integer id);

	boolean editArticle(Article article);

}
