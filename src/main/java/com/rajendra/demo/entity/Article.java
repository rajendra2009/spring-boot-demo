package com.rajendra.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.rajendra.demo.constant.AppConstant;

/**
 * Entity class for article
 * 
 * @author rajendra
 *
 */
@Entity
@Table(name = "article")
public class Article implements Serializable {

	private static final long serialVersionUID = -3592434962622593588L;

	/**
	 * An auto generated id and unique for each article
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	/**
	 * Field for title
	 */
	@NotBlank
	@Column(name = "title", length = AppConstant.DEFAULT_FIELD_LENGTH)
	@Length(min = AppConstant.MINIMUM_FIELD_LENGTH, max = AppConstant.DEFAULT_FIELD_LENGTH)
	private String title;

	/**
	 * Field for category
	 */
	@NotBlank
	@Column(name = "category", length = AppConstant.DEFAULT_FIELD_LENGTH)
	@Length(min = AppConstant.MINIMUM_FIELD_LENGTH, max = AppConstant.DEFAULT_FIELD_LENGTH)
	private String category;

	public Article() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", category=" + category + "]";
	}

}
