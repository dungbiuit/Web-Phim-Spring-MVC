package do_an.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIES")
public class Category {
	@Id
	@Column(name="CATEGORY_ID")
	private String category_id;
	@Column(name="CATEGORY_NAME")
	private String category_name;
	@OneToMany(mappedBy="category")
	private Collection<Movie> danh_sach_movie;
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	private Collection<Request> danh_sach_request;
	
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Collection<Movie> getDanh_sach_movie() {
		return danh_sach_movie;
	}
	public void setDanh_sach_movie(Collection<Movie> danh_sach_movie) {
		this.danh_sach_movie = danh_sach_movie;
	}
	public Category(String category_id, String category_name, Collection<Movie> danh_sach_movie) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.danh_sach_movie = danh_sach_movie;
	}
	
	public Collection<Request> getDanh_sach_request() {
		return danh_sach_request;
	}
	public void setDanh_sach_request(Collection<Request> danh_sach_request) {
		this.danh_sach_request = danh_sach_request;
	}
	public Category(){};
}
