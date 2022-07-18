package org.zzz.jobtest.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zzz.jobtest.data.Sector;
import org.zzz.jobtest.data.SectorRepository;

@Service
public class SectorService {

	@Autowired
	SectorRepository sectorRepository;

	@Transactional
	public Sector getById(int id) {
		Sector s =  sectorRepository.getById(id);
		
		String name = s.getName();
		return s;
	}
	
	public List<Sector> getAllSectorsSorted() {
		List<Sector> list = sectorRepository.findAll();
		Collections.sort(list, new SectorComparator());
		return list;

	}

	public static final class SectorComparator implements Comparator<Sector> {

		public int compare(Sector first, Sector second) {

			Sector firstCurr = first;
			Sector secondCurr = second;
			
			

			// check if second child of first
			firstCurr = first;
			secondCurr = second;
			while (secondCurr.getParent() != null) {
				if (secondCurr.equals(first)) {
					return -1;
				}
				secondCurr = secondCurr.getParent();
			}

			// check if first child of second
			while (firstCurr.getParent() != null) {
				if (firstCurr.equals(second)) {
					return 1;
				}
				firstCurr = firstCurr.getParent();
			}			

			// try to find common parent
			firstCurr = first;
			secondCurr = second;

			Sector firstParent = first.getParent();
			Sector secondParent = second.getParent();

			boolean commonParentFound = false;

			while (!commonParentFound && firstParent != null && secondParent != null) {

				commonParentFound = firstParent.equals(secondParent);

				while (!commonParentFound && secondParent.getParent() != null) {
					secondCurr = secondParent;
					secondParent = secondCurr.getParent();
					commonParentFound = firstParent.equals(secondParent);
					if (commonParentFound) {
						break;
					}
				}
				if (commonParentFound) {
					break;
				}
				firstCurr = firstParent;
				firstParent = firstCurr.getParent();

				secondCurr = second;
				secondParent = secondCurr.getParent();
				
			}

			if (commonParentFound) {
				return firstCurr.getName().compareTo(secondCurr.getName());
			} else {
				// common parent not found - compare roots
				firstCurr = first;
				secondCurr = second;
				while (firstCurr.getParent() != null) {
					firstCurr = firstCurr.getParent();
				}
				while (secondCurr.getParent() != null) {
					secondCurr = secondCurr.getParent();
				}
				return firstCurr.getName().compareTo(secondCurr.getName());
			}		
		}
	}


}
