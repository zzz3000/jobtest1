package org.zzz.jobtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zzz.jobtest.data.Sector;
import org.zzz.jobtest.data.SectorRepository;
import org.zzz.jobtest.service.SectorService;
import org.zzz.jobtest.service.SectorService.SectorComparator;

@SpringBootTest
public class ComparatorTest {
	
	@Autowired
	SectorService sectorService;
	
	
	//@Autowired
	//SectorRepository sectorRepository;
	
	@Test
	public void diffLevel() {
		
		SectorComparator comparator = new SectorComparator();
		
		Sector foodAndBeverageSector = sectorService.getById(6);
		
		Sector beveragesSector =  sectorService.getById(43);
		
		Sector meatAndProdSector = sectorService.getById(40);
		
		Sector kitchenSector = sectorService.getById(98);
		
		Sector otherSector = sectorService.getById(3);
		Sector serviceSector = sectorService.getById(2);
		
		assertThat(beveragesSector.getName()).isEqualTo("Beverages");
		
		assertThat(comparator.compare(beveragesSector, meatAndProdSector)).isLessThan(0);
		
		assertThat(comparator.compare( foodAndBeverageSector,beveragesSector)).isLessThan(0);
		
		assertThat(comparator.compare( beveragesSector,kitchenSector)).isLessThan(0);
		
		assertThat(comparator.compare( otherSector,serviceSector)).isLessThan(0);
		
	}

}
