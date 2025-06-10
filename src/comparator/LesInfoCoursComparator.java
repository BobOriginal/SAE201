package comparator;

import java.util.Comparator;

import modele.InfoTabView;

public class LesInfoCoursComparator implements Comparator<InfoTabView> {
	public int compare(InfoTabView obj1, InfoTabView obj2) {

	    // Make sure that the objects are Car objects
	    InfoTabView a = (InfoTabView) obj1;
	    InfoTabView b = (InfoTabView) obj2;
	    
	    // Compare the objects
	  
	    return a.getCours().compareTo(b.getCours());
	  }
}
