package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "videos")
public class Video {

	public Video() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	@Column(unique = true)
	private String url;

	@NotNull
	@Column(name = "TRANSCRIPT_FILENAME")
	private String transcriptFilename;

	@NotNull
	@Column(name = "DURATION_IN_MINUTES")
	private Integer duration;

	@NotNull
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

}
