package do_an.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="USERTYPES")
public class UserType {
	@Id
	@Column(name="TYPE_ID")
	private String type_id;
	@Column(name="TYPE_NAME")
	private String type_name;
	@OneToMany(mappedBy="user_type",fetch=FetchType.EAGER)
	private Collection<User> danh_sach_user;
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public Collection<User> getDanh_sach_user() {
		return danh_sach_user;
	}
	public void setDanh_sach_user(Collection<User> danh_sach_user) {
		this.danh_sach_user = danh_sach_user;
	}
	public UserType(String type_id, String type_name, Collection<User> danh_sach_user) {
		super();
		this.type_id = type_id;
		this.type_name = type_name;
		this.danh_sach_user = danh_sach_user;
	}
	public UserType(){};
	
	
}
