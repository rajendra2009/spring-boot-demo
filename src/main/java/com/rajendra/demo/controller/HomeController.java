package com.rajendra.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rajendra.demo.constant.PageConstant;
import com.rajendra.demo.constant.UrlConstant;

/**
 * Controller that handle request for home page
 * 
 * @author rajendra
 *
 */
@Controller
@RequestMapping(UrlConstant.URL_ROOT)
public class HomeController {

	/**
	 * This method is used to render home page.
	 * 
	 * @return String :- home page
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		return PageConstant.PAGE_HOME;
	}

}
