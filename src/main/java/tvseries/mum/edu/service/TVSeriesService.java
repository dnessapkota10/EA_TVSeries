package tvseries.mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tvseries.mum.edu.dao.EpisodeDao;
import tvseries.mum.edu.dao.SeasonDao;
import tvseries.mum.edu.dao.SeriesDao;
import tvseries.mum.edu.domain.Episode;
import tvseries.mum.edu.domain.Season;
import tvseries.mum.edu.domain.Series;

@Service
@Transactional
public class TVSeriesService implements ITVSeriesService {

	@Autowired
	private SeriesDao seriesDao;

	@Autowired
	private SeasonDao seasonDao;
	
	@Autowired
	private EpisodeDao episodeDao;

	@Override
	public Series getSeriesById(int id) {
		// TODO Auto-generated method stub
		return seriesDao.findOne((long) id);
	}

	@Override
	public List<Series> getAllSeries() {
		// TODO Auto-generated method stub
		return seriesDao.findAll();
	}

	@Override
	public void addSeries(Series series) {
		// TODO Auto-generated method stub
		seriesDao.save(series);
	}

	@Override
	public void updateSeries(Series series) {
		// TODO Auto-generated method stub
		seriesDao.save(series);
	}

	
	@Override
	public void addSeason(Season season, int seriesId) {
		// TODO Auto-generated method stub
		season.setSeries(this.getSeriesById(seriesId));
		seasonDao.save(season);
	}

	@Override
	public List<Season> getAllSeasonBySeriesId(Integer seriesId) {
		// TODO Auto-generated method stub

		return seasonDao.findBySeriesId(seriesId.longValue());
	}

	@Override
	public Season getSeasonById(int id) {
		// TODO Auto-generated method stub
		return seasonDao.findOne((long)id);
	}

	@Override
	public void updateSeason(Season season) {
		// TODO Auto-generated method stub
		seasonDao.save(season);
	}

	@Override
	public List<Episode> getEpisodeBySeason() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Episode> getAllEpisodeBySeason(int seasonId) {
		// TODO Auto-generated method stub
		
		return episodeDao.findBySeasonId((long)seasonId);		
	}

	@Override
	public void addEpisode(Episode episode, int seasonId) {
		// TODO Auto-generated method stub
		episode.setSeason(this.getSeasonById(seasonId));
		episodeDao.save(episode);
	}

	@Override
	public List<Series> getAllSeriesByName(String seriesName) {
		// TODO Auto-generated method stub
		
		return seriesDao.findByName(seriesName);
	}

	@Override
	public List<Series> getAllSeriesByRating(double seriesRating) {
		// TODO Auto-generated method stub
		return seriesDao.findByRating(seriesRating);
	}

}
