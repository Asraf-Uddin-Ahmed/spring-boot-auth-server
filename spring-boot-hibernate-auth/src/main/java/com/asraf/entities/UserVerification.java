package com.asraf.entities;
// Generated Aug 29, 2018 6:56:08 PM by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserVerification generated by hbm2java
 */
@Entity
@Table(name = "user_verification", catalog = "myauthdb")
public class UserVerification extends BaseEntity implements java.io.Serializable {

	private long id;
	private User user;
	private String verificationCode;
	private Date creationTime;

	public UserVerification() {
	}

	public UserVerification(long id, User user, String verificationCode, Date creationTime) {
		this.id = id;
		this.user = user;
		this.verificationCode = verificationCode;
		this.creationTime = creationTime;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "verification_code", nullable = false, length = 45)
	public String getVerificationCode() {
		return this.verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_time", nullable = false, length = 19)
	public Date getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

}
