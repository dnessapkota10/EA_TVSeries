package tvseries.mum.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tvseries.mum.edu.domain.Season;

public interface SeasonDao extends JpaRepository<Season,Integer>{
	
}
