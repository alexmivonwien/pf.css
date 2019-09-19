package at.home.digest.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyDataHomeModel extends LazyDataModel<Home> {

	private static final long serialVersionUID = 1L;

	private List<Home> homeList = new ArrayList<>();
	
	
	public static final String [] DESCRIPTIONS_STRINGS = {
							"2 Zimmer Wohnung in 1050 Wien! INKL. Heizung und WW!!!", 
							"Erstbezug, Grünlage, perfekte, helle 2-Zimmer Wohnung mit voll ausgestatteter Küche, klimatisiert, Tiefgaragenplatz",
							"U3 Hütteldorfer Straße - NEUBAU-ERSTBEZUGSWOHNUNG!",
							"Hoch OBEN im 10ten mit Wellnessbereich!! Ideal für Singles oder Pärchen!!!",
							"FAMILIENSTÜTZPUNKT in 1190 Wien"};
	
	public static final String [] ADRESS_STRINGS = {
			"Wien 1100 Wien (10., Favoriten), Laaer-Berg-Straße",
			"Wien 1190 Wien (19., Döbling), Karthäuserstraße",
			"Wien 1210 Wien (21., Floridsdorf), Dr. Albert Gessmann Gasse 39",
			"Wien 1190 Wien (19., Döbling), Döblinger Hauptstraße",
			"Wien 1020 Wien (2., Leopoldstadt)"
	};
	

	public LazyDataHomeModel() {
		for (int i = 0; i < 5; i++) {
			Home home = new Home();
			home.setId((i + 1));
			home.setMainImageTabl("img" + (i + 1) + ".jpg");
			home.setDescription(DESCRIPTIONS_STRINGS[i]);
			home.setAdress(ADRESS_STRINGS[i]);
			home.setPrice( new BigDecimal(Math.random()* 1000));
			home.setWohnflaeche(new BigDecimal(Math.random()* 100));
			home.setNoRooms(new BigDecimal(Math.random()* 5).byteValue());
			home.setPlz((int)(Math.random()*1000 + 999));
			
			homeList.add(home);
		}
	}

	@Override
	public Home getRowData(String rowKey) {
		for (Home home : homeList) {
			if (home.getId() == Integer.valueOf(rowKey))
				return home;
		}
		return null;
	}

	@Override
	public Object getRowKey(Home homeToRent) {
		return homeToRent.getId();
	}

	@Override
	public List<Home> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		// rowCount
		this.setRowCount(homeList.size());
		this.setPageSize(homeList.size());

		return homeList;
	}

}
