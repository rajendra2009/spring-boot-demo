package com.rajendra.demo.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rajendra.demo.constant.PageConstant;
import com.rajendra.demo.constant.UrlConstant;
import com.rajendra.demo.entity.Article;
import com.rajendra.demo.service.ArticleService;

/**
 * Controller that handles create, list, update and delete of {@link Article}
 * 
 * @author rajendra
 *
 */
@Controller
@RequestMapping(UrlConstant.URL_ARTICLE)
public class ArticleController {

	private static final Logger LOG = LogManager.getLogger(ArticleController.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ArticleService articleServiceImpl;

	/**
	 * This method is used to render article list page.
	 * 
	 * @return String :- article list page
	 */
	@RequestMapping(value = UrlConstant.URL_LIST, method = RequestMethod.GET)
	public String list(Model model) {
		LOG.info("Inside ArticleController#list() method.");
		List<Article> articles = articleServiceImpl.findAll();
		model.addAttribute("articles", articles);
		return PageConstant.PAGE_ARTICLE_LIST;
	}

	/**
	 * This method is used to render form for creating article.
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = UrlConstant.URL_CREATE, method = RequestMethod.GET)
	public String createForm(Model model) {
		LOG.info("Inside ArticleController#createForm() method");
		if (!model.containsAttribute("article")) {
			model.addAttribute("article", new Article());
		}
		return PageConstant.PAGE_ARTICLE_CREATE;
	}

	/**
	 * This method is used to save article form data
	 * 
	 * @param article
	 * @param result
	 * @param redirectAttributes
	 * @return String :- create page
	 */
	@RequestMapping(value = UrlConstant.URL_CREATE, method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("article") Article article, BindingResult result,
			RedirectAttributes redirectAttributes) {
		LOG.info("Inside ArticleController#save() method");
		if (result.hasErrors()) {
			LOG.debug("AccountLedger validation errors : " + result);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.article", result);
			redirectAttributes.addFlashAttribute("article", article);
			redirectAttributes.addFlashAttribute("error",
					messageSource.getMessage("error.article.create", null, Locale.getDefault()));
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_CREATE;
		}
		try {
			articleServiceImpl.save(article);
			redirectAttributes.addFlashAttribute("success",
					messageSource.getMessage("success.article.create", null, Locale.getDefault()));
			LOG.info("Article save successfully");
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_VIEW + "/" + article.getId();
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("article", article);
			redirectAttributes.addFlashAttribute("error",
					messageSource.getMessage("exception.article.create", null, Locale.getDefault()));
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_CREATE;
		}

	}

	/**
	 * This method render view of specific article
	 * 
	 * @param id
	 * @param redirectAttributes
	 * @return String :- View of article by id
	 */
	@RequestMapping(value = UrlConstant.URL_VIEW_ID, method = RequestMethod.GET)
	public String view(@PathVariable("id") long id, Model model, RedirectAttributes redirectAttributes) {
		LOG.info("Inside ArticleController#view() method");
		Article article = articleServiceImpl.findById(id);
		if (article == null) {
			LOG.debug("Article doesnot exist with id " + id);
			redirectAttributes.addFlashAttribute("info",
					messageSource.getMessage("exist.not.article", null, Locale.getDefault()));
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_LIST;
		}
		model.addAttribute("article", article);
		return PageConstant.PAGE_ARTICLE_VIEW;
	}

	/**
	 * This method render edit of specific article
	 * 
	 * @param id
	 * @param redirectAttributes
	 * @return String :- Edit of article by id
	 */
	@RequestMapping(value = UrlConstant.URL_EDIT_ID, method = RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model, RedirectAttributes redirectAttributes) {
		LOG.info("Inside ArticleController#edit() method");
		Article article = articleServiceImpl.findById(id);
		if (article == null) {
			LOG.debug("Article doesnot exist with id " + id);
			redirectAttributes.addFlashAttribute("info",
					messageSource.getMessage("exist.not.article", null, Locale.getDefault()));
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_LIST;
		}
		model.addAttribute("article", article);
		return PageConstant.PAGE_ARTICLE_EDIT;
	}

	/**
	 * This method is used to update article form data
	 * 
	 * @param article
	 * @param result
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = UrlConstant.URL_UPDATE, method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("article") Article article, BindingResult result,
			RedirectAttributes redirectAttributes) {
		LOG.info("Inside ArticleController#update() method");
		Article dbArticle = articleServiceImpl.findById(article.getId());
		if (dbArticle == null) {
			LOG.debug("Article doesnot exist with id " + article.getId());
			redirectAttributes.addFlashAttribute("info",
					messageSource.getMessage("exist.not.article", null, Locale.getDefault()));
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_LIST;
		}
		if (result.hasErrors()) {
			LOG.debug("AccountLedger validation errors : " + result);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.article", result);
			redirectAttributes.addFlashAttribute("article", article);
			redirectAttributes.addFlashAttribute("error",
					messageSource.getMessage("error.article.update", null, Locale.getDefault()));
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_EDIT + "/" + article.getId();
		}
		dbArticle.setTitle(article.getTitle());
		dbArticle.setCategory(article.getCategory());
		try {
			articleServiceImpl.update(article);
			redirectAttributes.addFlashAttribute("success",
					messageSource.getMessage("success.article.update", null, Locale.getDefault()));
			LOG.info("Article updated successfully");
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_VIEW + "/" + dbArticle.getId();
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("article", article);
			redirectAttributes.addFlashAttribute("error",
					messageSource.getMessage("exception.article.update", null, Locale.getDefault()));
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_EDIT + "/" + article.getId();
		}
	}

	/**
	 * This method is used to delete article
	 * 
	 * @param id
	 * @param redirectAttributes
	 * @return String
	 */
	@RequestMapping(value = UrlConstant.URL_DELETE, method = RequestMethod.POST)
	public String delete(@RequestParam("id") long id, RedirectAttributes redirectAttributes) {
		LOG.info("Inside ArticleController#delete() method ");
		Article article = articleServiceImpl.findById(id);
		if (article == null) {
			LOG.debug("Article doesnot exist with id " + id);
			redirectAttributes.addFlashAttribute("info",
					messageSource.getMessage("exist.not.article", null, Locale.getDefault()));
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_LIST;
		}
		try {
			articleServiceImpl.delete(article);
			redirectAttributes.addFlashAttribute("success",
					messageSource.getMessage("success.article.delete", null, Locale.getDefault()));
			LOG.info("Article deleted successfully with id " + id);
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_LIST;
		} catch (Exception e) {
			LOG.error("Article cannot deleted due to {}", e);
			redirectAttributes.addFlashAttribute("error",
					messageSource.getMessage("exception.article.delete", null, Locale.getDefault()));
			return "redirect:" + UrlConstant.URL_ARTICLE + UrlConstant.URL_VIEW + "/" + article.getId();
		}
	}

}
