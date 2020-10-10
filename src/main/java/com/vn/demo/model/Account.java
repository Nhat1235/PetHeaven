package com.vn.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity // Đánh dấu đây là table trong db
@Table(name = "ACCOUNT")
@Data
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "USERNAME")
	@NotBlank(message = "*Name is mandatory")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{9,15}$",message = "*Must contain 9 to 15 character and at least 1 letter and 1 \r\n" + 
			"capitalize letter and 1 number Ex: longnhat12345")
	private String username;

	@Column(name = "PASSWORD")
	@NotBlank(message = "*Password is mandatory")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{9,15}$",message = "*Must contain 9 to 15 character and at least 1 letter and 1 \r\n" + 
			"capitalize letter and 1 number Ex: Longnhat12345")
	private String password;
    
	@Pattern(regexp = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$",message="*Email must be correct Ex: longnhat.pham112@gmail.com")
	@NotBlank(message = "*Email is mandatory")
	private String email;

	private String role;




	public Account() {
		this.role = "USER";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
	   
		return role;
	}

	public void setRole(String role) {
		role="user";
		this.role = role;
	}

}
