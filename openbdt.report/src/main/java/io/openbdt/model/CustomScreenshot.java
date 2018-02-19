package io.openbdt.model;

import java.util.List;

public class CustomScreenshot {

	
	private String description;
	private String pathImage;
	private int id;
	private List<CustomScreenshot> listScreenShot;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<CustomScreenshot> getListScreenShot() {
		return listScreenShot;
	}
	public void setListScreenShot(List<CustomScreenshot> listScreenShot) {
		this.listScreenShot = listScreenShot;
	}
	
}
