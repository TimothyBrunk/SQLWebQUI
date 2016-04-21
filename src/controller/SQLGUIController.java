package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.SQLGUIDAOInterface;

@Controller
public class SQLGUIController {
	@Autowired 
	private SQLGUIDAOInterface SQLdao; 
	
	@RequestMapping("GetSQL.do")
	public ModelAndView getSQLText(@RequestParam("taname") String query){
		ArrayList<ArrayList> response = SQLdao.getQuery(query); 
		ModelMap mp = new ModelMap(); 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("response", response);
		System.out.println();
		
		
		return mv;
	}

}
