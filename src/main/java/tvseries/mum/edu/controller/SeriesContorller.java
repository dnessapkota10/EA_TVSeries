package tvseries.mum.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tvseries.mum.edu.domain.Episode;
import tvseries.mum.edu.domain.Season;
import tvseries.mum.edu.domain.Series;
import tvseries.mum.edu.service.ITVSeriesService;

enum Search {

	ByName, ByGenre, ByRating, ByArtist, ByChracter, ByDirector
}

@Controller
public class SeriesContorller {

	@Autowired
	ITVSeriesService tvSeriesService;

	/*@RequestMapping("/")
	public String Login(){
		return "/login";
	}*/
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("tvseries", tvSeriesService.getAllSeries());
		return "admin/index";
	}

	@RequestMapping(value = "/addSeries", method = RequestMethod.GET)
	public String openAddSeries() {
		return "redirect:/static/html/addSeries.html";
	}

	@RequestMapping(value = "/addNewSeries", method = RequestMethod.POST)
	public String addSeries(@ModelAttribute("series") Series series) {
		tvSeriesService.addSeries(series);
		return "redirect:/home";
	}

	// Open Update form
	@RequestMapping(value = "/Series/editSeries/{id}", method = RequestMethod.GET)
	public String updateSeries(Model model, @PathVariable int id) {
		model.addAttribute("series", tvSeriesService.getSeriesById(id));
		return "admin/updateSeries";
	}

	// Save updated info
	@RequestMapping(value = "/Series/updateSeries/{id}", method = RequestMethod.POST)
	public String saveUpdatedSeries(Series series, @PathVariable int id) {
		series.setId(id);
		tvSeriesService.updateSeries(series);

		return "redirect:/";
	}

	// Show seasons
	@RequestMapping(value = "/showSeason/{id}", method = RequestMethod.GET)
	public String showSeason(HttpServletRequest request, Model model, @PathVariable int id) {

		model.addAttribute("seasons", tvSeriesService.getAllSeasonBySeriesId(id));
		model.addAttribute("series", tvSeriesService.getSeriesById(id));
		request.getSession().setAttribute("series", tvSeriesService.getSeriesById(id));

		return "admin/season";
	}

	// AddSeason
	@RequestMapping(value = "/Season/addSeason/{id}", method = RequestMethod.GET)
	public String addSeason(Model model, @PathVariable int id) {
		model.addAttribute("series", tvSeriesService.getSeriesById(id));
		return "admin/addSeason";
	}

	// Save Season
	@RequestMapping(value = "/Season/addNewSeason/{id}", method = RequestMethod.POST)
	public String saveUpdatedSeason(Season season, @PathVariable int id, Model model) {

		tvSeriesService.addSeason(season, id);

		model.addAttribute("seasons", tvSeriesService.getAllSeasonBySeriesId(id));
		model.addAttribute("series", tvSeriesService.getSeriesById(id));

		return "admin/season";
	}

	// Open Update form
	@RequestMapping(value = "/Season/editSeason/{id}", method = RequestMethod.GET)
	public String updateSeason(Model model, @PathVariable int id) {
		model.addAttribute("season", tvSeriesService.getSeasonById(id));

		return "admin/updateSeason";
	}

	// Save updated info
	@RequestMapping(value = "/Season/updateSeason/{id}", method = RequestMethod.POST)
	public String saveUpdatedSeason(Season season, @PathVariable int id) {
		season.setId((long) id);

		tvSeriesService.updateSeason(season);
		return "redirect:/showSeason/" + id;
	}

	// EPISODES
	@RequestMapping(value = "/showEpisode/{id}")
	public String showEpisode(HttpServletRequest request, Model model, @PathVariable int id) {

		model.addAttribute("episodes", tvSeriesService.getAllEpisodeBySeason(id));
		model.addAttribute("series", request.getSession().getAttribute("series"));
		model.addAttribute("season", tvSeriesService.getSeasonById(id));

		request.getSession().setAttribute("season", tvSeriesService.getSeasonById(id));
		System.out.println("HEHRE" + request.getSession().getAttribute("series"));
		return "admin/episode";
	}

	// AddSeason
	@RequestMapping(value = "/Episode/addEpisode/{id}", method = RequestMethod.GET)
	public String addEpisode(Model model, @PathVariable int id) {
		model.addAttribute("series", tvSeriesService.getSeriesById(id));
		return "admin/addEpisode";
	}

	// Save Season
	@RequestMapping(value = "/Episode/addNewEpisode/{id}", method = RequestMethod.POST)
	public String addNewEpisode(Episode episode, @PathVariable int id, Model model) {

		tvSeriesService.addEpisode(episode, id);

		model.addAttribute("Episodes", tvSeriesService.getAllEpisodeBySeason(id));

		return "admin/episode";
	}

	// Search
	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public String Search(Model model, @RequestParam String searchBy, @RequestParam String searchValue) {
		
		String view = "";
		
		switch (searchBy) {
		case "ByName":
			model.addAttribute("tvseries", tvSeriesService.getAllSeriesByName(searchValue));
			view = "admin/index";
			break;
		case "ByRating":
			model.addAttribute("tvseries", tvSeriesService.getAllSeriesByRating(Double.parseDouble(searchValue)));
			view = "admin/index";
			break;

		default:
			break;
		}
		
		//System.out.println("Search::" + view);
		return view;
	}
}
