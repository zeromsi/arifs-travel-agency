package com.travelagency.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.travelagency.business.PostDto;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String body;

	private Date createdAt;

	private String owner;
	
	private Date lastUpdatedAt;
	
	@Length(max=15)
	private String visibility;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "location")
	private Location location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", body=" + body + ", createdAt=" + createdAt + ", owner=" + owner
				+ ", lastUpdatedAt=" + lastUpdatedAt + ", visibility=" + visibility + ", location=" + location + "]";
	}

	public Post(Long id, String body, Date createdAt, String owner, Date lastUpdatedAt, String visibility,
			Location location) {
		super();
		this.id = id;
		this.body = body;
		this.createdAt = createdAt;
		this.owner = owner;
		this.lastUpdatedAt = lastUpdatedAt;
		this.visibility = visibility;
		this.location = location;
	}

	public Post() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdatedAt == null) ? 0 : lastUpdatedAt.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((visibility == null) ? 0 : visibility.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdatedAt == null) {
			if (other.lastUpdatedAt != null)
				return false;
		} else if (!lastUpdatedAt.equals(other.lastUpdatedAt))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (visibility == null) {
			if (other.visibility != null)
				return false;
		} else if (!visibility.equals(other.visibility))
			return false;
		return true;
	}
 
	public List<PostDto> convertIntoDtos(List<Post> posts) {
		List<PostDto> dtos=new ArrayList<>();
		posts.stream().forEach(post->{
			dtos.add(post.convertIntoDto());
		});
		
		return dtos;
	}

	public  PostDto convertIntoDto() {
		PostDto dto=new PostDto();
		dto.setId(this.getId());
		dto.setBody(this.getBody());
		dto.setCreatedAt(this.getCreatedAt());
		dto.setLastUpdatedAt(this.getLastUpdatedAt());
		dto.setLocation(this.getLocation().convertIntoDto());
		dto.setOwner(this.getOwner());
		dto.setVisibility(this.getVisibility());
		return dto;
	}

}
