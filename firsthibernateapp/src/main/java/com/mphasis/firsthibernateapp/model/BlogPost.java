package com.mphasis.firsthibernateapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="blogposts")
public class BlogPost {
	@Id
	@Column(name="id",length=10)
	private String id;
	@Column(name="title",length=20)
	private String title;
	@Column(name="content",length=100)
	private String content;
	@Column(name="author",length=20)
	private String author;
	@OneToMany(mappedBy="blogpost",cascade=CascadeType.ALL)
	private List<Comment> comments=new ArrayList<Comment>();
	public BlogPost() {
		
		// TODO Auto-generated constructor stub
	}
	public BlogPost(String id, String title, String content, String author) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, content, id, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlogPost other = (BlogPost) obj;
		return Objects.equals(author, other.author) && Objects.equals(content, other.content)
				&& Objects.equals(id, other.id) && Objects.equals(title, other.title);
	}
	


}
