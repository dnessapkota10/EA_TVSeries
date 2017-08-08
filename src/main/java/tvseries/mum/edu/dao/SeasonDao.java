package tvseries.mum.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tvseries.mum.edu.domain.Season;

public interface SeasonDao extends JpaRepository<Season,Long>{

	public List<Season> findBySeriesId(Long sreiesId);
	public List<Season> findBySeasonNumberOrderBySeasonNumberDesc(int seasonNumber);
}
