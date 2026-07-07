package com.busbooking.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "passwordHash")
@Entity
@Table(name="users")
@AttributeOverride(name="id",column = @Column(name ="user_id"))
public class User extends BaseClass{
	@Column(name="first_name", nullable = false, length=50)
	private String firstName;
	@Column(name = "middle_name", length = 50)
	private String middleName;
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	@Column(nullable = false, unique = true, length = 15)
	private String phone;
	@Column(name = "password_hash", nullable = false,length = 255)
	private String passwordHash;
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private UserRole role;
	@Column(name = "profile_photo")
	private String profilePhoto;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "date_of_birth")
	private LocalDate dob;
	@Column(name = "is_verified")
	private Boolean isVerified = false;
	@Column(name = "is_active")
	private Boolean isActive = true;
	@Column(name = "last_login")
	private LocalDateTime lastLogin;
	

}
