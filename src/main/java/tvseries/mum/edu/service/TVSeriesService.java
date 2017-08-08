package tvseries.mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public int getRecentSessonIdBySeries(int seriesId) {
		// TODO Auto-generated method stub
		List<Season> seasons = seasonDao.findBySeasonNumberOrderBySeasonNumberDesc(0);
		return 0;
	}

	@Override
	public List<Episode> getAllEpisodeBySeasonId(int seasonId) {
		// TODO Auto-generated method stub
		return null;
	}

}
