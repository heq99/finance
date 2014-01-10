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

import qiang.finance.portfolio.domain.Market;
import qiang.finance.portfolio.service.MarketService;

@Controller
public class MarketController {
	
	private static final Log logger = LogFactory.getLog(MarketController.class);
	
	@Autowired
	private MarketService marketService;
	
	@RequestMapping(value="/markets", method=RequestMethod.GET)
	public String listMarket(Model model) {
		logger.info("listMarket called");
		
		List<Market> marketList = marketService.getAllMarkets();
		model.addAttribute("market_list", marketList);
		
		return "MarketList";
	}
	
	@RequestMapping(value="/markets/new", method=RequestMethod.GET)
	public String initCreationMarketForm(Model model) {
		logger.info("initCreationMarketForm called");
		
		Market market = new Market();
		model.addAttribute("market", market);
		
		return "MarketForm";
	}

	@RequestMapping(value="/markets/new", method=RequestMethod.POST)
	public String saveMarket(Market market, BindingResult result, RedirectAttributes redirectAttributes) {
		logger.info("saveMarket called");
		
		if (result.hasErrors()) {
			return "MarketForm";
		} else {
			Market savedMarket = marketService.saveMarket(market);
		
			redirectAttributes.addFlashAttribute("message", "The market "
					+ savedMarket.getShortCode() + " was successfully added.");
		
			return "redirect:/markets";
		}
	}

	@RequestMapping(value="/markets/{id}/edit", method=RequestMethod.GET)
	public String initEditMarketForm(@PathVariable Integer id, Model model) {
		logger.info("initEditMarketForm called");
		
		Market market = marketService.getMarketById(id);
		model.addAttribute("market", market);
		
		return "MarketForm";
	}
	
	@RequestMapping(value="/markets/{id}/edit", method=RequestMethod.POST) 
	public String updateMarket(Market market, BindingResult result, RedirectAttributes redirectAttributes) {
		logger.info("updateMarket called");
		
		if (result.hasErrors()) {
			return "MarketForm";
		} else {
			Market savedMarket = marketService.updateMarket(market);
			redirectAttributes.addFlashAttribute("message", "The market "
					+ savedMarket.getShortCode() + " was successfully added.");
			return "redirect:/markets";
		}
	}
	
	@RequestMapping(value="/markets/{id}/delete")
	public String deleteMarket(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		logger.info("deleteMarket called");
		
		Market deletedMarket = marketService.deleteMarket(id);
		
		redirectAttributes.addAttribute("message", "The market "
				+ deletedMarket.getShortCode() + " was successfully deleted.");
		
		return "redirect:/markets";
	}
}
