package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.po.Position;
import com.service.PositionService;

@Controller
public class PositionController {
	@Autowired
	private PositionService positionService;
	
	@RequestMapping("/positionlist")
	public String positionlist(Model model){
		List<Position> list = positionService.findAllPositions();
		model.addAttribute("positionList", list);
		return "position/positionlist";
	}

	@RequestMapping(value="/positionpreinsert",method=RequestMethod.GET)
	public String positionPreinsert() {
		return "position/positionadd";
	}
	
	@RequestMapping(value="/positioninsert",method=RequestMethod.POST)
	public String positionInsert(Position position) {
		positionService.addPosition(position);
		return "redirect:positionlist";
	}
	
	@RequestMapping(value="/positiondelete",method=RequestMethod.POST)
	public String positionDelete(Integer[] pnoArray) {
		if (pnoArray != null) {
			positionService.deletePosition(pnoArray);
		}
		return "redirect:positionlist";
	}
	
	@RequestMapping(value="/positionpreupdate",method=RequestMethod.GET)
	public String positionPreupdate(Position position,Model model) {
		model.addAttribute("position", position);
		return "position/positionupdate";
	}
	
	@RequestMapping(value="/positionupdate",method=RequestMethod.POST)
	public String positionUpdate(Position position) {
		positionService.updatePosition(position);
		return "redirect:positionlist";
	}
}
