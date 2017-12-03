package com.rajendra.demo.service;

import java.util.List;

import com.rajendra.demo.entity.Article;

/**
 * Service for {@link Article}
 * 
 * @author rajendra
 *
 */
public interface ArticleService {

	/**
	 * Find Total No Of {@link Article}
	 * 
	 * @return long :- total no of article
	 */
	long findTotalNo();

	/**
	 * Find {@link List} of {@link Article}
	 * 
	 * @return {@link List} of {@link Article}
	 */
	List<Article> findAll();

	/**
	 * Save {@link Article}
	 * 
	 * @param article
	 *            :- Article Entity
	 * @return {@link Article}
	 */
	Article save(Article article);

	/**
	 * Find {@link Article} by id
	 * 
	 * @param id
	 * @return {@link Article}
	 */
	Article findById(long id);

	/**
	 * Update {@link Article}
	 * 
	 * @param article
	 * @return {@link Article}
	 */
	Article update(Article article);

	/**
	 * Delete {@link Article}
	 * 
	 * @param article
	 */
	void delete(Article article);

}
