package qiang.finance.portfolio.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the INSTRUMENT database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT")
@NamedQuery(name="Instrument.findAll", query="SELECT i FROM Instrument i")
public class Instrument implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="Instrument_ID_Generator", table="ID_TABLE", 
                    pkColumnName="ID_NAME", valueColumnName="ID_HI",
                    pkColumnValue="INSTRUMENT_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="Instrument_ID_Generator")
	@Column(name="ID")
	private int id;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="SYMBOL")
	private String symbol;

	//uni-directional many-to-one association to InstrumentType
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_TYPE_ID")
	private InstrumentType instrumentType;

	//bi-directional many-to-one association to Market
	@ManyToOne
	@JoinColumn(name="MARKET_ID")
	private Market market;

	public Instrument() {
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

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public InstrumentType getInstrumentType() {
		return this.instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	public Market getMarket() {
		return this.market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

}