package do_an.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotBlank;

import com.sun.istack.internal.NotNull;



@Entity

@Table(name="USERS")
public class User {
	@Id
	@NotNull
	@NotBlank(message="Username required !")
	@Column(name = "USERNAME" )
	 private String username;
	@NotNull	
	@Size(min=3,max=30,message="Password can't contains less than 3 and more than 30 characters !")
	@Pattern(regexp = "^[a-zA-Z0-9.\\-\\/+=@_ ]*$",message="Password can't contains special character !")
	@Column(name="PASSWORD")
	private String password;
	@NotBlank(message="Leave your name so we can welcome you !")
	@Column(name="NAME_OF_USER")
	private String name_of_user;
	@Column(name="ADMINISTRATOR")
	private Boolean administrator;
	@ManyToOne
	@JoinColumn(name="USER_TYPE")
	private UserType user_type;
	@Column(name="IMAGE_AVATAR")
	private String image_avatar;
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private Collection<Comment> danh_sach_comments;
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private Collection<Request>danh_sach_requests;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName_of_user() {
		return name_of_user;
	}
	public void setName_of_user(String name_of_user) {
		this.name_of_user = name_of_user;
	}
	public Boolean getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}
	public UserType getUser_type() {
		return user_type;
	}
	public void setUser_type(UserType user_type) {
		this.user_type = user_type;
	}
	public String getImage_avatar() {
		return image_avatar;
	}
	public void setImage_avatar(String image_avatar) {
		this.image_avatar = image_avatar;
	}
	public Collection<Comment> getDanh_sach_comments() {
		return danh_sach_comments;
	}
	public void setDanh_sach_comments(Collection<Comment> danh_sach_comments) {
		this.danh_sach_comments = danh_sach_comments;
	}
	public Collection<Request> getDanh_sach_requests() {
		return danh_sach_requests;
	}
	public void setDanh_sach_requests(Collection<Request> danh_sach_requests) {
		this.danh_sach_requests = danh_sach_requests;
	}
	public User(){}
	
}
