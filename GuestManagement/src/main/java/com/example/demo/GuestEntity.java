package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class GuestEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int GuestId;
    private String name;
    private String adresss;
    
    
	public GuestEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GuestEntity(int guestId, String name, String adresss) {
		super();
		GuestId = guestId;
		this.name = name;
		this.adresss = adresss;
	}
	public int getGuestId() {
		return GuestId;
	}
	public void setGuestId(int guestId) {
		GuestId = guestId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdresss() {
		return adresss;
	}
	public void setAdresss(String adresss) {
		this.adresss = adresss;
	}
	@Override
	public String toString() {
		return "GuestEntity [GuestId=" + GuestId + ", name=" + name + ", adresss=" + adresss + "]";
	}
   

}
