package com.fpoly.object;

public class English {
	

	

	public int getImage() {
		return Image;
	}

	public void setImage(int image) {
		Image = image;
	}

	public String getAudio() {
		return Audio;
	}

	public void setAudio(String audio) {
		Audio = audio;
	}

	public String getDecription() {
		return Decription;
	}

	public void setDecription(String decription) {
		Decription = decription;
	}

	
	private int Image;
	private String Audio;
	private String Decription;

	public English() {

	}

	public English(int Image, String Audio, String Decription) {
		
		this.Image = Image;
		this.Audio = Audio;
		this.Decription = Decription;

	}
	
	
	
	
	

}
