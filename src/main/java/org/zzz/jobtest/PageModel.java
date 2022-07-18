package org.zzz.jobtest;

import java.util.ArrayList;
import java.util.List;

public class PageModel {
	
	List<Integer> selectedSectors = new ArrayList<Integer>();
	
	String name;

	boolean agreed;
	
	int id;
	
	public List<Integer> getSelectedSectors() {
		
		//selectedSectors.contains(name)
		
		return selectedSectors;
	}

	public void setSelectedSectors(List<Integer> selectedSectors) {
		this.selectedSectors = selectedSectors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
