package pf.galleria.id;

package at.home.digest.web;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.data.PageEvent;

import at.home.digest.model.Ausstattung;
import at.home.digest.model.Constants;
import at.home.digest.model.Home;
import at.home.digest.model.translation.SuppLang;
import at.home.digest.model.translation.SupportedLanguage;
import at.home.digest.services.HomeToDealDBService;
import at.home.digest.services.TranslationsService;
import at.home.digest.web.model.LazyDataHomeModel;

@Named
@javax.faces.view.ViewScoped
public class ResultsBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Home selectedHomeToDeal;

	private Integer pageRequestedTimes = 0;

	private boolean showCaptcha;

	@Inject
	private HomeToDealDBService homeToDealDBService;

	@Inject
	private TranslationsService translationsService;

	private Map<SupportedLanguage, SuppLang> supportedLanguageMap;

	private LazyDataHomeModel lazyDataHomeModel;

	@PostConstruct
	public void init() {
		supportedLanguageMap = translationsService.getAllSupportedLanguages();
		lazyDataHomeModel = new LazyDataHomeModel(homeToDealDBService);
		lazyDataHomeModel.setSearchCriteria(searchBean.getSearchCriteria());
		lazyDataHomeModel.setSupportedLanguageMap(supportedLanguageMap);

	}

	public LazyDataHomeModel getLazyDataHomeModel() {
		return lazyDataHomeModel;
	}

	public void setLazyDataHomeModel(LazyDataHomeModel lazyDataHomeModel) {
		this.lazyDataHomeModel = lazyDataHomeModel;
	}

	public Home getSelectedHomeToDeal() {
		return selectedHomeToDeal;
	}

	public String getDescriptionFirstSymbols(Home home) {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		Locale locale = facesContext.getViewRoot().getLocale();
		locale = locale == null ? new Locale("de") : locale;
		String description = locale.getLanguage().equals(SupportedLanguage.GERMAN.getValue().toLowerCase())
				? home.getDescription()
				: home.getHomeTRForView() == null ? StringUtils.EMPTY : home.getHomeTRForView() .getDescr();

		//int length = (int) (0.037974683544304 * this.screenWidth + 73.126582278481);
		int length = (int) (0.071030640668524 * this.screenWidth + 27.972144846797);
		
		if (getCountUpperCaseSymbols(description) > description.length() / 3){
			length = length * 2 / 3;
		}

		int substrTo = description.length();
		
		boolean cut = false;
		if (length  + Constants.THREE_POINTS.length() <= description.length()) {
			substrTo = length;
			cut = true;
		}
		description = description.length() == 0 ? description : description.substring(0, substrTo);
		if (cut) {
			description = description + Constants.THREE_POINTS;
		}
		
		return description;
	}
	
	private Integer getCountUpperCaseSymbols (String description) {
		int count = 0;
		
		for (int i= 0; i < description.length(); i++) {
			Character ch = description.charAt(i);
			
			if (Character.isUpperCase(ch))
				count++;
		}
		
		return count;
	}
	
	public void addAsAFavourite(ActionEvent event) {

	}

	public String getHomeDescr(Home home) {
		int firstSymbolsDescr = (int) (0.058631921824104 * this.screenWidth - 18.990228013029);

		firstSymbolsDescr = firstSymbolsDescr > home.getDescription().length() ? home.getDescription().length()
				: firstSymbolsDescr;

		return home.getDescription().substring(0, firstSymbolsDescr);
	}

}
