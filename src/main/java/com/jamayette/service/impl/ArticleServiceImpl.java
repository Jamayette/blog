package com.jamayette.service.impl;

import com.jamayette.mapper.ArticleMapper;
import com.jamayette.model.Article;
import com.jamayette.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

	@Autowired
	ArticleMapper articleMapper;

	@Override
	public List<Article> findAllArticles() {
		Example example = new Example(Article.class);
		example.setOrderByClause("create_time desc");
		List<Article> articleList = articleMapper.selectByExample(example);
		List<Article> showList = new ArrayList<>();
		for (Article article : articleList) {
			if (article.getStatus() != 0) {
				article.setContent(null);
				showList.add(article);
			}
		}
		return showList;
	}

	@Override
	public Article findArticleByName(String name) {
		Article record = new Article();
		record.setName(name);
		return articleMapper.selectOne(record);
	}

	@Override
	public boolean saveArticle(Article article) {
		try {
			article.setStatus(1);
			articleMapper.insert(article);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteArticle(Integer id) {
		try {
			Article article = articleMapper.selectByPrimaryKey(id);
			article.setStatus(0);
			articleMapper.updateByPrimaryKey(article);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Article findArticleById(Integer id) {
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean editArticle(Article article) {
		try {
			articleMapper.updateByPrimaryKeySelective(article);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
