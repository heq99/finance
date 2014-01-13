package qiang.finance.portfolio.springmvc.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import qiang.finance.portfolio.domain.InstrumentType;
import qiang.finance.portfolio.service.InstrumentTypeService;

@Controller
public class InstrumentTypeController {
	
	private static final Log logger = LogFactory.getLog(MarketController.class);
	
	@Autowired
	private InstrumentTypeService instrumentTypeService;
	
	@RequestMapping(value="/instrumentTypes", method=RequestMethod.GET)
	public String listInstrumentType(Model model) {
		logger.info("listInstrumentType called");
		
		List<InstrumentType> instrumentTypeList = instrumentTypeService.getAllInstrumentTypes();
		model.addAttribute("instrumentType_list", instrumentTypeList);
		
		return "InstrumentTypeList";
	}

	@RequestMapping(value="/instrumentTypes/new", method=RequestMethod.GET)
	public String initCreationInstrumentTypeForm(Model model) {
		logger.info("initCreationInstrumentTypeForm called");
		
		InstrumentType instrumentType = new InstrumentType();
		model.addAttribute("instrumentType", instrumentType);
		
		return "InstrumentTypeForm";
	}
	
	@RequestMapping(value="/instrumentTypes/new", method=RequestMethod.POST)
	public String saveInstrumentType(InstrumentType instrumentType, BindingResult result, RedirectAttributes redirectAttributes) {
		logger.info("saveInstrumentType called");
		
		if (result.hasErrors()) {
			return "InstrumentTypeForm";
		} else {
			InstrumentType savedInstrumentType = instrumentTypeService.saveInstrumentType(instrumentType);
			
			redirectAttributes.addFlashAttribute("message", "The instrument type "
					+ savedInstrumentType.getName() + " was successfully added.");
			
			return "redirect:/instrumentTypes";
		}
	}
		
	@RequestMapping(value="/instrumentTypes/{id}/edit", method=RequestMethod.GET)
	public String initEditInstrumentTypeForm(@PathVariable Integer id, Model model) {
		logger.info("initEditInstrumentTypeForm called");
		
		InstrumentType instrumentType = instrumentTypeService.getInstrumentTypeById(id);
		model.addAttribute("instrumentType", instrumentType);
		
		return "InstrumentTypeForm";
	}
	
	@RequestMapping(value="/instrumentTypes/{id}/edit", method=RequestMethod.POST) 
	public String updateInstrumentType(InstrumentType instrumentType, BindingResult result, RedirectAttributes redirectAttributes) {
		logger.info("updateInstrumentType called");
		
		if (result.hasErrors()) {
			return "InstrumentTypeForm";
		} else {
			InstrumentType savedInstrumentType = instrumentTypeService.updateInstrumentType(instrumentType);
			redirectAttributes.addFlashAttribute("message", "The instrument type "
					+ savedInstrumentType.getName() + " was successfully added.");
			return "redirect:/instrumentTypes";
		}
	}
	
	@RequestMapping(value="/instrumentTypes/{id}/delete")
	public String deleteInstrumentType(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		logger.info("deleteInstrumentType called");
		
		InstrumentType deletedInstrumentType = instrumentTypeService.deleteInstrumentType(id);
		
		redirectAttributes.addAttribute("message", "The instrument type "
				+ deletedInstrumentType.getName() + " was successfully deleted.");
		
		return "redirect:/instrumentTypes";
	}
}
