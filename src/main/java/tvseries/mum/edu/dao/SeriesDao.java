package tvseries.mum.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tvseries.mum.edu.domain.Season;
import tvseries.mum.edu.domain.Series;

@Repository
public interface SeriesDao extends JpaRepository<Series,Long>{

	public List<Series> findByName(String name);
	public List<Series> findByRating(double rating);	

}
