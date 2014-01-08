package qiang.finance.portfolio.springmvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="/market_list")
	public String listMarkets(Model model) {
		return "MarketList";
	}
	
	@RequestMapping(value="/market_input")
	public String inputMarket(Model model) {
		logger.info("inputMarket called");
		
		Market market = new Market();
		
		model.addAttribute("market", market);
		
		return "MarketForm";
	}

	@RequestMapping(value="/market_save", method=RequestMethod.POST)
	public String saveMarket(Market market, RedirectAttributes redirectAttributes) {
		logger.info("saveMarket called");
		
		Market savedMarket = marketService.saveMarket(market);
		
		redirectAttributes.addFlashAttribute("message", 
				"The market was successfully added.");
		
		return "redirect:/market_view/" + savedMarket.getId();
		
	}
	
	@RequestMapping(value="/market_view/{id}")
	public String viewMarket(@PathVariable Integer id, Model model) {
		Market market = marketService.getMarketById(id);
		model.addAttribute("market", market);
		return "MarketView";
	}
}
