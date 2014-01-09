package qiang.finance.portfolio.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MARKET database table.
 * 
 */
@Entity
@Table(name="MARKET")
@NamedQuery(name="Market.findAll", query="SELECT m FROM Market m")
public class Market implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;

	@Id	
	@TableGenerator(name="Market_ID_Generator", table="ID_TABLE", 
	                pkColumnName="ID_NAME", valueColumnName="ID_HI",
	                pkColumnValue="MARKET_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="Market_ID_Generator")
	@Column(name="ID")
	private int id;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="SHORT_CODE")
	private String shortCode;

	//bi-directional many-to-one association to Instrument
	@OneToMany(mappedBy="market")
	private List<Instrument> instruments;

	public Market() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortCode() {
		return this.shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public List<Instrument> getInstruments() {
		return this.instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Instrument addInstrument(Instrument instrument) {
		getInstruments().add(instrument);
		instrument.setMarket(this);

		return instrument;
	}

	public Instrument removeInstrument(Instrument instrument) {
		getInstruments().remove(instrument);
		instrument.setMarket(null);

		return instrument;
	}

}