package lb.spring.dto;


import java.util.Date;

import javax.persistence.Column;

import lb.spring.entities.FileDB;
import lb.spring.entities.Role;

public class UserDto {
	private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String gender;
	private  String password;
	private  String email;
	private Role role;
	private  Date creation_date;
	private  FileDB image;
	public Date getCreation_date() {
			return creation_date;
		}
		public void setCreation_date(Date creation_date) {
			this.creation_date = creation_date;
		}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public UserDto() {
		super();
	}
	public UserDto(long id, String firstName, String lastName, String phone, String gender, String password,
			String email, Role role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public FileDB getImage() {
		return image;
	}
	public void setImage(FileDB image) {
		this.image = image;
	}

}
