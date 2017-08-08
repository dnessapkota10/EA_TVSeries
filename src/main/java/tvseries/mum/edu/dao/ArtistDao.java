package tvseries.mum.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tvseries.mum.edu.domain.Artist;

public interface ArtistDao extends JpaRepository<Artist,Integer>{
}
