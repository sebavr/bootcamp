package com.codingdojo.auth.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist; 
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pool")
public class Pool {
	//------------ Id ----------------------------------
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	//********** Atributos o Campos ********************
	//@Min(0)
	@Size(min=2,max=200)
	private String address;
	@Column(columnDefinition = "TEXT")
	private String description;
	private Double cost;
	private String size;
	private Double ratingAvg;
	//------------createdAt updatedAt------------------
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	//*************Relaciones**************************
	//Pool
	//========= Relacion 1xN User-Pool =========
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")  //clave foranea
	private User user;
	//Pool
	//========= Relacion 1xN Pool-Review =========
	@OneToMany(mappedBy="pool", fetch = FetchType.LAZY)
	private List<Review> reviewList;
		//Pool
	//========= Relacion 1xN Size-Pool =========
	
		
    //---------------Constructores-------------------
	public Pool(){
		
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Double getRatingAvg() {
		return ratingAvg;
	}
	public void setRatingAvg(Double ratingAvg) {
		this.ratingAvg = ratingAvg;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Review> getReviewList() {
		return reviewList;
	}
	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
	

	
	//**********Getters Setters************************
	
}
