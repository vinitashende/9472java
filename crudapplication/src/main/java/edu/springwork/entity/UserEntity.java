package edu.springwork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "mytable")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "myid")
	private int id;
	@Column(name = "myname")
	private String ename;
	@Column(name = "myemail")
	private String email;

	public UserEntity(String ename, String email) {
		super();
		this.ename = ename;
		this.email = email;
	}

}
