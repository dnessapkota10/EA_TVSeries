package tvseries.mum.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvseries.mum.edu.domain.Series;

@Repository
public interface SeriesDao extends JpaRepository<Series,Long>{

	/*public Series getSeriesById(int id);
	public List<Series> getAllSeries();
	
	public void addSeries(Series series);
	public void updateSeries(Series series);	
	public void removeSeries(int id);
	*/

}
