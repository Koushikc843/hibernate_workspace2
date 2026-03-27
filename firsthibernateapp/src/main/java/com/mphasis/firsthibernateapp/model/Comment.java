package com.mphasis.firsthibernateapp.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="comments")
public class Comment {
	@Id
	@Column(name="id",length=10)
	private String id;
	@Column(name="comment",length=20)
	private String comment;
	@Column(name="author",length=20)
	private String author;
	
	@ManyToOne
	@JoinColumn(name="blogid")
	private BlogPost blogpost;
	public Comment() {
	
		// TODO Auto-generated constructor stub
	}
	public Comment(String id, String comment, String author) {
		super();
		this.id = id;
		this.comment = comment;
		this.author = author;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, comment, id);
	}
	
	public BlogPost getBlogpost() {
		return blogpost;
	}
	public void setBlogpost(BlogPost blogpost) {
		this.blogpost = blogpost;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(author, other.author) && Objects.equals(comment, other.comment)
				&& Objects.equals(id, other.id);
	}
	
	
}
