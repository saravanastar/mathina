/**
 * 
 */
package com.ask.actions;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.pojo.MiscellaneousPojo;
import com.ask.service.MiscellaneousService;
import com.ask.util.ApplicationConstants;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 *
 */
@Controller
public class MiscellenousController {

	@Autowired
	MiscellaneousService miscellaneousService;
	
	
	
	public MiscellaneousService getMiscellaneousService() {
		return miscellaneousService;
	}
	public void setMiscellaneousService(MiscellaneousService miscellaneousService) {
		this.miscellaneousService = miscellaneousService;
	}
	@RequestMapping(value="/getmiscellenous.htm",method=RequestMethod.GET)
	public String getMiscellenousPage(HttpSession session){
		String page= "miscellenous";
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
			page = "login";
		}
		return page;
		
	}
	/**
	 * 
	 * @param pojo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/savemiscellenous.htm",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> saveMiscellenousPage(@ModelAttribute MiscellaneousPojo pojo,HttpSession session){
		
		if(session.getAttribute(ApplicationConstants.LOGGED_IN)==null){
			return CommonObjectMethods.buildOutObject(ApplicationConstants.SESSION_TIMED_OUT);
		}
		return miscellaneousService.saveMiscellaneousData(pojo);
		
	}
	
}
