package com.rajendra.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajendra.demo.entity.Article;
import com.rajendra.demo.repository.ArticleRepository;
import com.rajendra.demo.service.ArticleService;
import com.rajendra.demo.service.impl.ArticleServiceImpl;

/**
 * Test class for {@link ArticleServiceImpl}
 * 
 * @author rajendra
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleServiceImplTest {

	@TestConfiguration
	static class ArticleServiceImplTestContextConfiguration {

		@Bean
		public ArticleService articleService() {
			return new ArticleServiceImpl();
		}
	}

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ArticleService articleService;

	@MockBean
	private ArticleRepository articleRepository;

	@Before
	public void setUp() {
		Article article = new Article();
		article.setTitle("New Movie Ice Age 5 Release On 2017 December");
		article.setCategory("Movie");
		entityManager.persist(article);
		entityManager.flush();

		Mockito.when(articleRepository.findById(article.getId())).thenReturn(article);
		Mockito.when(articleRepository.count()).thenReturn(new Long(1));
	}

	@Test
	public void whenValidId_thenArticleShouldBeFound() {
		long id = 1;
		Article article = articleService.findById(id);
		System.out.println("=========== Article Test Id =========");
		System.out.println(id);
		System.out.println("=========== Article Id After FindById Method =========");
		System.out.println(article.getId());
		assertEquals(id, article.getId());
	}
	
	@Test
	public void whenPersist_thenFindTotalNoShouleBeOne() {
		long totalNo = articleService.findTotalNo();
		System.out.println("=========== Article Total No Test =========");
		System.out.println(1);
		System.out.println("=========== Article Id After FindTotalNo Method =========");
		System.out.println(totalNo);
		assertEquals(1, totalNo);
	}

}
