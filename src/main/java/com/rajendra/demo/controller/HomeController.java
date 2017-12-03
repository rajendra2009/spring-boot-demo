package com.rajendra.demo.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rajendra.demo.constant.PageConstant;
import com.rajendra.demo.constant.UrlConstant;
import com.rajendra.demo.service.ArticleService;

/**
 * Controller that handle request for home page
 * 
 * @author rajendra
 *
 */
@Controller
@RequestMapping(UrlConstant.URL_ROOT)
public class HomeController {

	private static final Logger LOG = LogManager.getLogger(HomeController.class);

	@Autowired
	private ArticleService articleServiceImpl;

	/**
	 * This method is used to render home page.
	 * 
	 * @return String :- home page
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		LOG.info("Inside HomeController#index() method.");
		model.addAttribute("totalArticle", articleServiceImpl.findTotalNo());
		return PageConstant.PAGE_HOME;
	}

}
