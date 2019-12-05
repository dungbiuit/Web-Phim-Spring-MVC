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
@Table(name="REQUESTS")
public class Request {
	@Id @GeneratedValue
	@Column(name="REQUEST_ID")
	private Integer request_id;
	@NotBlank(message="Tell us what's your request movie's name!")
	@Column(name="MOVIE_NAME")
	private String movie_name;
	@ManyToOne
	@JoinColumn(name="CATEGORY")
	private Category category;
	@Column(name="INTRODUCTION")
	private String introduction;
	@Column(name="MOVIE_AVATAR")
	private String movie_avatar;
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private User user;
	
	public Integer getRequest_id() {
		return request_id;
	}
	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getMovie_avatar() {
		return movie_avatar;
	}
	public void setMovie_avatar(String movie_avatar) {
		this.movie_avatar = movie_avatar;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
