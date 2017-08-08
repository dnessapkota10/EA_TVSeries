package tvseries.mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tvseries.mum.edu.domain.Season;
import tvseries.mum.edu.domain.Series;
import tvseries.mum.edu.service.ITVSeriesService;

@Controller
public class SeriesContorller {

	@Autowired
	ITVSeriesService tvSeriesService;

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
		return "redirect:/";
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
	public String showSeason(Model model, @PathVariable int id) {
		//System.out.println("FIRST");
		model.addAttribute("seasons", tvSeriesService.getAllSeasonBySeriesId(id));
		model.addAttribute("series", tvSeriesService.getSeriesById(id));
		// int seasonId = tvSeriesService.getRecentSessonIdBySeries(id);
		//
		// model.addAttribute("episodes",
		// tvSeriesService.getAllEpisodeBySeasonId(seasonId));

		return "admin/season";
	}

	// AddSeason
	@RequestMapping(value = "/Season/addSeason/{id}", method = RequestMethod.GET)
	public String addSeason(Model model, @PathVariable int id) {
		model.addAttribute("series", tvSeriesService.getSeriesById(id));
		// tvSeriesService.addSeason(season);
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
		//model.addAttribute("series", tvSeriesService.getSeriesById(id));
		model.addAttribute("season", tvSeriesService.getSeasonById(id));
		//System.out.println("Final" + id);
		return "admin/updateSeason";
	}

	// Save updated info
	@RequestMapping(value = "/Season/updateSeason/{id}", method = RequestMethod.POST)
	public String saveUpdatedSeason(Season season, @PathVariable int id) {
		season.setId((long)id);
		
		tvSeriesService.updateSeason(season);
		return "redirect:/showSeason/" + id;
	}
}
