package com.rajendra.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rajendra.demo.entity.Article;

/**
 * Repository for {@link Article} that extends {@link CrudRepository}
 * 
 * @author rajendra
 *
 */
@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

	/**
	 * Find {@link Article} by id
	 * 
	 * @param id
	 * @return {@link Article}
	 */
	Article findById(long id);

}
