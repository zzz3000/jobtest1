package org.zzz.jobtest;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.zzz.jobtest.service.SectorService;
import org.zzz.jobtest.service.UserInfoService;

@Controller 
@RequestMapping(path = "/") 
public class JobTestController {
	
	@Autowired
	SectorService sectorService;
	
	@Autowired
	UserInfoService userService;
	
	@PostMapping(path = "/save1.do")
	public RedirectView save1(@ModelAttribute PageModel query, Model model) {	// , HttpSession session	
		
		System.out.println("zz");
					
		model.addAttribute("sectors", sectorService.getAllSectorsSorted());	
		
		int userId = userService.createOrUpdateByModel(query);
		
		//session.setAttribute("userId", userId);
		
		//return "page";
		
		return new RedirectView("get.do?id="+userId);
	}
	
	
	
	
	@PostMapping(path = "/save.do")
	public RedirectView save(@ModelAttribute PageModel query, Model model) {	// , HttpSession session	
					
		model.addAttribute("sectors", sectorService.getAllSectorsSorted());	
		
		int userId = userService.createOrUpdateByModel(query);
		
		//session.setAttribute("userId", userId);
		
		//return "page";
		
		return new RedirectView("get.do?id="+userId);
	}
	
	
	
	
	@GetMapping(path = "/get.do")
	public String get(@ModelAttribute PageModel query, Model model) { //, HttpSession session		
		
		//Integer userId = (Integer)session.getAttribute("userId");
		
		int userId = query.getId();
		
		if(userId!=0) {
			userService.fillModelById(userId, query);		
			//query.setId(userId);
		}
		
		model.addAttribute("sectors", sectorService.getAllSectorsSorted());		
		model.addAttribute("query",query);
		
		return "page";
	}
	
	

}
