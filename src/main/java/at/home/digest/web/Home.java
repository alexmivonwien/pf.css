package at.home.digest.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Home implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;	
	
	
	private String mainImageTabl;
	
	private String imageFolderPath;
	
	private String description;
	private byte noRooms;
	private BigDecimal wohnflaeche;
	private BigDecimal price; // price in
	private String adress;
	private String city;
	private int plz;
	
	public void setId(int id) {
		this.id = id;
	}

	public String getMainImageTabl() {
		return mainImageTabl;
	}

	public void setMainImageTabl(String mainImageTabl) {
		this.mainImageTabl = mainImageTabl;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getImageFolderPath() {
		return imageFolderPath;
	}

	public void setImageFolderPath(String imageFolderPath) {
		this.imageFolderPath = imageFolderPath;
	}

	public BigDecimal getWohnflaeche() {
		return wohnflaeche;
	}

	public void setWohnflaeche(BigDecimal wohnflaeche) {
		this.wohnflaeche = wohnflaeche;
		this.wohnflaeche = this.wohnflaeche.setScale(2, RoundingMode.CEILING);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public byte getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(byte noRooms) {
		this.noRooms = noRooms;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdress() {
		return adress;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
		this.price = this.price.setScale(2, RoundingMode.CEILING);
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getId(){
		return id;
	}

}
