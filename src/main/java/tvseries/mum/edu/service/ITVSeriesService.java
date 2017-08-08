package tvseries.mum.edu.service;

import java.util.List;

import tvseries.mum.edu.domain.Episode;
import tvseries.mum.edu.domain.Season;
import tvseries.mum.edu.domain.Series;

public interface ITVSeriesService {

	public Series getSeriesById(int id);
	public List<Series> getAllSeries();
	public void addSeries(Series series);
	public void updateSeries(Series series);
	
	public List<Episode> getEpisodeBySeason();
	public void addSeason(Season season);
}
