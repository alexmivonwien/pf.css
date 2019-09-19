package pf.galleria.id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

/**
* @author alex-mi
* 
* We store images on the file system with paths to them stored in the database
* 
* @see https://stackoverflow.com/questions/3748/storing-images-in-db-yea-or-nay
* @see https://habiletechnologies.com/blog/better-saving-files-database-file-system/
* 
* @see http://balusc.omnifaces.org/2011/09/communication-in-jsf-20.html#ProcessingGETRequestParameters
*
*/
@Named
@javax.faces.view.ViewScoped
public class ExposeBean implements Serializable {

	private List<String> images = new ArrayList<>();
	
	
	{
   	 images.add("600_5308AA4BB69142E3AB05DF9BA394A133.jpg");
	 images.add("600_AF3E4D6017BB4C6C8BA953D356FBE000.jpg");
	 images.add("600_BC152BACEF144A75AAE8785422BADEFF.jpg");
	 
	 images.add("600_E26EABA0C9074BF69D12AC83229BEA10.jpg");
	 images.add("600_F4EFBFA4BE9845DBB68ACFA8F2F657ED.jpg");
   }

	public List<String> getImages() {
       return images;
   }
}
