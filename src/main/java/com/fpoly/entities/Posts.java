
package com.fpoly.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "posts")
public class Posts implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 19)
	private long id;
	@Column(nullable = false, length = 255)
	private String title;
	@Column(nullable = false, length = 255)
	private String content;
	@Column(nullable = false, length = 255)
	private String image;
	@Column(name = "post_date", nullable = false)
	private LocalDate postDate;

}
