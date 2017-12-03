package com.rajendra.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajendra.demo.entity.Article;
import com.rajendra.demo.repository.ArticleRepository;

/**
 * Test class for {@link ArticleRepository}
 * 
 * @author rajendra
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ArticleRepository articleRepository;

	@Test
	public void whenFindById_thenReturnArticle() {
		// Given article
		Article article = new Article();
		article.setTitle("New Movie Ice Age 5 Release On 2017 December");
		article.setCategory("Movie");
		entityManager.persist(article);
		entityManager.flush();

		// when
		Article result = articleRepository.findById(article.getId());

		// then
		System.out.println("=========== Article Id When Persist =========");
		System.out.println(article.getId());
		System.out.println("=========== Article Id After FindById Method =========");
		System.out.println(article.getId());
		assertEquals(article.getId(), result.getId());
	}

}
