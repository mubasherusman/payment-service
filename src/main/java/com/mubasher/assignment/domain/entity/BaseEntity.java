package com.mubasher.assignment.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Mubasher Usman
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 8337844169808297017L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	protected Long id;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", columnDefinition = "DATETIME")
	@CreationTimestamp
	private Date createdAt;

	@JsonIgnore
	@Column(name = "created_by", columnDefinition = "BIGINT UNSIGNED")
	private Long createdBy;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "DATETIME")
	@UpdateTimestamp
	private Date updatedAt;

	@Column(name = "updated_by", columnDefinition = "BIGINT UNSIGNED")
	private Long updatedBy;

}
