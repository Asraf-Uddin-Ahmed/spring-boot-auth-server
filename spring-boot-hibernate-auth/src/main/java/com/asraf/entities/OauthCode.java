package com.asraf.entities;
// Generated Aug 29, 2018 6:56:08 PM by Hibernate Tools 5.2.10.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OauthCode generated by hbm2java
 */
@Entity
@Table(name = "oauth_code", catalog = "myauthdb")
public class OauthCode extends BaseEntity implements java.io.Serializable {

	private OauthCodeId id;

	public OauthCode() {
	}

	public OauthCode(OauthCodeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "code", column = @Column(name = "code")),
			@AttributeOverride(name = "authentication", column = @Column(name = "authentication")) })
	public OauthCodeId getId() {
		return this.id;
	}

	public void setId(OauthCodeId id) {
		this.id = id;
	}

}
