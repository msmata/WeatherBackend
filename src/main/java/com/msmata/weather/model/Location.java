package com.msmata.weather.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locaciones")
public class Location {

//	@Id
//	@Column(name="locacionid")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer id;
	@Id
	@Column(name="woeid", nullable = false)
	private Long woeid;
	@Column(name="nombre", length=45, nullable = false)
	private String name;

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public Long getWoeid() {
		return woeid;
	}

	public void setWoeid(Long woeid) {
		this.woeid = woeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((woeid == null) ? 0 : woeid.hashCode());
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
		Location other = (Location) obj;
		if (woeid == null) {
			if (other.woeid != null)
				return false;
		} else if (!woeid.equals(other.woeid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [woeid=" + woeid + ", name=" + name + "]";
	}
	
}
