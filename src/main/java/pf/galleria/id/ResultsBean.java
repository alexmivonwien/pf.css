package pf.galleria.id;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import at.home.digest.web.Home;
import at.home.digest.web.LazyDataHomeModel;

@Named
@javax.faces.view.ViewScoped
public class ResultsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Integer screenWidth = 900;
	protected Integer screenHeight = 0;

	private LazyDataHomeModel lazyDataHomeModel;

	@PostConstruct
	public void init() {
		lazyDataHomeModel = new LazyDataHomeModel();
	}

	public LazyDataHomeModel getLazyDataHomeModel() {
		return lazyDataHomeModel;
	}

	public void setLazyDataHomeModel(LazyDataHomeModel lazyDataHomeModel) {
		this.lazyDataHomeModel = lazyDataHomeModel;
	}

	public String getDescriptionFirstSymbols(Home home) {
		return home.getDescription();
	}

	public String getHomeDescr(Home home) {
		return home.getDescription();
	}
	
	public String getAddsRowImage() {
		return "striche.png";
	}
	
	public Integer getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(Integer screenWidth) {
		this.screenWidth = screenWidth;
	}

	public Integer getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(Integer screenHeight) {
		this.screenHeight = screenHeight;
	}

	public void addAsAFavourite(ActionEvent event) {

	}

}
