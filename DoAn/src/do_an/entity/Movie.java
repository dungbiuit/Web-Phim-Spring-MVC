package do_an.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="MOVIES")

public class Movie {
	@Id
	@GeneratedValue
	@Column(name="MOVIE_ID")
	private Integer movie_id;
	@NotBlank(message="You must include Movie Name")
	@Column(name="MOVIE_NAME")
	private String movie_name;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY")
	private Category category;
	
	@Column(name="MOVIE_AVATAR_IMAGE")
	private String movie_avatar_image;
	
	@Range(min=1888,message="The first movie was made in 1888, How can you find a movie that was released before that time :))")
	@Column(name="PUBLISH_YEAR")
	private Integer publish_year;
	@NotBlank(message="You must include Introduction")
	@Column(name="INTRODUCTION")
	private String introduction;
	@ManyToOne
	@JoinColumn(name="GENRE_ID")
	private Genre genre;
	@OneToMany(mappedBy="movie")
	private Collection<Comment> danh_sach_comment;
	@Column(name="SLIDER_IMAGE_1")
	private String slider_image_1;
	
	@NotBlank(message="This movie is not apply trailer yet !")
	@Column(name="TRAILER_LINK")
	private String trailer_link;
	
	
	public Integer getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return this.movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getMovie_avatar_image() {
		return movie_avatar_image;
	}
	public void setMovie_avatar_image(String movie_avatar_image) {
		this.movie_avatar_image = movie_avatar_image;
	}
	public Integer getPublish_year() {
		return publish_year;
	}
	public void setPublish_year(Integer publish_year) {
		this.publish_year = publish_year;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public Collection<Comment> getDanh_sach_comment() {
		return danh_sach_comment;
	}
	public void setDanh_sach_comment(Collection<Comment> danh_sach_comment) {
		this.danh_sach_comment = danh_sach_comment;
	}
	public String getSlider_image_1() {
		return slider_image_1;
	}
	public void setSlider_image_1(String slider_image_1) {
		this.slider_image_1 = slider_image_1;
	}
	
	
	public String getTrailer_link() {
		return trailer_link;
	}
	public void setTrailer_link(String trailer_link) {
		this.trailer_link = trailer_link;
	}
	public Movie(){};
}
