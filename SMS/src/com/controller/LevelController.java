package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.po.Level;
import com.service.LevelService;

@Controller
public class LevelController {
	@Autowired
	private LevelService levelService;
	
	@RequestMapping("/levellist")
	public String levellist(Model model){
		List<Level> list = levelService.findAllLevel();
		model.addAttribute("levelList", list);
		return "level/levellist";
	}

	@RequestMapping(value="/levelpreinsert",method=RequestMethod.GET)
	public String levelPreinsert() {
		return "level/leveladd";
	}
	
	@RequestMapping(value="/levelinsert",method=RequestMethod.POST)
	public String levelInsert(Level level) {
		levelService.addLevel(level);
		return "redirect:levellist";
	}
	
	@RequestMapping(value="/leveldelete",method=RequestMethod.POST)
	public String levelDelete(Integer[] lnoArray) {
		levelService.deleteLevel(lnoArray);
		return "redirect:levellist";
	}
	
	@RequestMapping(value="/levelpreupdate",method=RequestMethod.GET)
	public String levelPreupdate(Level level,Model model) {
		model.addAttribute("level", level);
		return "level/levelupdate";
	}
	
	@RequestMapping(value="/levelupdate",method=RequestMethod.POST)
	public String levelUpdate(Level level) {
		levelService.updateLevel(level);
		return "redirect:levellist";
	}
}
