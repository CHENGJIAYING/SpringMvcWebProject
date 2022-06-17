package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.MAX;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "picture")
@Component("picture")
public class Picture {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "FILENAME")
	private String filename;
	
	@Column(name = "PICTURE" ,length = 1000 )
	private byte[] picture;

	public Picture() {
		super();
	}

	public Picture(String filename, byte[] picture) {
		this.filename = filename;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

}