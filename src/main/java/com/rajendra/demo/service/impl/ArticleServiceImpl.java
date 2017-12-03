package com.rajendra.demo.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rajendra.demo.entity.Article;
import com.rajendra.demo.repository.ArticleRepository;
import com.rajendra.demo.service.ArticleService;

/**
 * Class that implements {@link ArticleService}
 * 
 * @author rajendra
 *
 */
@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {

	private static final Logger LOG = LogManager.getLogger(ArticleServiceImpl.class);

	@Autowired
	private ArticleRepository articleRepository;

	public long findTotalNo() {
		LOG.info("Inside ArticleServiceImpl#findTotalNo() method.");
		return articleRepository.count();
	}

	public List<Article> findAll() {
		LOG.info("Inside ArticleServiceImpl#findAll() method.");
		return (List<Article>) articleRepository.findAll();
	}

	@Transactional
	public Article save(Article article) {
		LOG.info("Inside ArticleServiceImpl#save() method. Article " + article);
		return articleRepository.save(article);
	}

	public Article findById(long id) {
		LOG.info("Inside ArticleServiceImpl#findById() method. Id " + id);
		return articleRepository.findById(id);
	}

	@Transactional
	public Article update(Article article) {
		LOG.info("Inside ArticleServiceImpl#update() method. Article : " + article);
		return articleRepository.save(article);
	}

	@Transactional
	public void delete(Article article) {
		LOG.info("Inside ArticleServiceImpl#delete() method. Article : " + article);
		articleRepository.delete(article);
	}

}
