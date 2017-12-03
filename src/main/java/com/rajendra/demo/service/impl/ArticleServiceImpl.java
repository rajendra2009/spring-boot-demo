package com.rajendra.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	

}
