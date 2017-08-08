package tvseries.mum.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tvseries.mum.edu.domain.Episode;

public interface EpisodeDao extends JpaRepository<Episode,Integer>{

}
