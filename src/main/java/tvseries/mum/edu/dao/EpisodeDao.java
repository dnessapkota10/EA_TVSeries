
package tvseries.mum.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tvseries.mum.edu.domain.Episode;
import tvseries.mum.edu.domain.Season;

public interface EpisodeDao extends JpaRepository<Episode,Integer>{

	public List<Episode> findBySeasonId(long episodeNumber);
}
