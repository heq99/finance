package qiang.finance.portfolio.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INSTRUMENT_TYPE database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT_TYPE")
@NamedQuery(name="InstrumentType.findAll", query="SELECT i FROM InstrumentType i")
public class InstrumentType implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID")
	private int id;

	@Column(name="NAME")
	private String name;

	public InstrumentType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}