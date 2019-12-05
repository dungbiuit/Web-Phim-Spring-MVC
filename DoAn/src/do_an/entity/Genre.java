package do_an.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GENRES")
public class Genre {
	@Id
	@Column(name="GENRE_ID")
	private String genre_id;
	@Column(name="GENRE_NAME")
	private String genre_name;
	@OneToMany(mappedBy="genre")
	private Collection<Movie>danh_sach_phim;
	public String getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public Collection<Movie> getDanh_sach_phim() {
		return danh_sach_phim;
	}
	public void setDanh_sach_phim(Collection<Movie> danh_sach_phim) {
		this.danh_sach_phim = danh_sach_phim;
	}
	
	
}
