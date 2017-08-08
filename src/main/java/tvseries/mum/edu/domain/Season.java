package tvseries.mum.edu.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Season {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="seasonnumber")
	private int seasonNumber;
	
	@ElementCollection
	@OneToMany(mappedBy="season")
	private List<Episode> episodeList;

	@Column(columnDefinition = "mediumblob")
	private Byte[] poster;
	
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	
	@ManyToOne
	@JoinColumn(name="seriesId")
	private Series series;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getSeasonNumber() {
		return seasonNumber;
	}

	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	public List<Episode> getEpisodeList() {
		return episodeList;
	}

	public Byte[] getPoster() {
		return poster;
	}
	public void setPoster(Byte[] poster) {
		this.poster = poster;
	}
	public void setEpisodeList(List<Episode> episodeList) {
		this.episodeList = episodeList;
	}
	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
