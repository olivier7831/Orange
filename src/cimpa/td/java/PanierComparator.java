package cimpa.td.java;

import java.util.Comparator;

public class PanierComparator implements Comparator<Orange> {

	@Override
	public int compare(Orange o1, Orange o2) {
		if (o1.getOrigine().compareTo(o2.getOrigine()) != 0) {
			return o1.getOrigine().compareTo(o2.getOrigine());
		} else if ( o1.getPrix() != o2.getPrix() ) {
			if (o1.getPrix() > o2.getPrix()) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 0;
		}
	}

}
