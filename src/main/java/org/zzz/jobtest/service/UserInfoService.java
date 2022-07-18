package org.zzz.jobtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzz.jobtest.PageModel;
import org.zzz.jobtest.data.Sector;
import org.zzz.jobtest.data.SectorRepository;
import org.zzz.jobtest.data.UserInfo;
import org.zzz.jobtest.data.UserInfoRepository;

@Service
public class UserInfoService {
	
	@Autowired 
	SectorService sectorService;
	
	@Autowired
	SectorRepository sectorRepository;
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	
	public void fillModelById(int userId,PageModel q) {		
		
		UserInfo uInfo = userInfoRepository.getById(userId);
		
		q.setId(userId);
		
		if(uInfo!=null) {				
			q.setName(uInfo.getName());				
			q.setAgreed(uInfo.getAgreed());	
			q.getSelectedSectors().clear();
			
			for (Sector sector : uInfo.getSectors()) {
				q.getSelectedSectors().add(sector.getId());
			}
		}
		
	}
	
	public int createOrUpdateByModel(PageModel q){
		UserInfo info = null;
		
		if(q.getId()==0) {
			info = new UserInfo();
		}else {
			info = userInfoRepository.getById(q.getId());
		}
		
		
		
		info.setName(q.getName());
		info.setAgreed(q.isAgreed());
		
		info.getSectors().clear();
		
		
		for (Integer sectorId : q.getSelectedSectors()) {
			Sector s = sectorRepository.getById(sectorId);
			info.getSectors().add(s);
		}
		
		userInfoRepository.save(info);
		//q.setId(info.getId());
		return info.getId();
		
	}

}
