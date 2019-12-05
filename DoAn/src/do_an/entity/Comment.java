package do_an.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="COMMENTS")
public class Comment {
	@Id @GeneratedValue
	@Column(name="COMMENTS_ID")
	private Integer comment_id;
	
	@Column(name="CONTENT")
	private String content;
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private User user;
	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
	private Movie movie;
	
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Comment(){};
}
