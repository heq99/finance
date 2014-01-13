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
	@TableGenerator(name="Instrument_Type_ID_Generator", table="ID_TABLE", 
                    pkColumnName="ID_NAME", valueColumnName="ID_HI",
                    pkColumnValue="INSTRUMENT_TYPE_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="Instrument_Type_ID_Generator")
	@Column(name="ID")
	private Integer id;

	@Column(name="NAME")
	private String name;

	public InstrumentType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isNew() {
		return this.id==null;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}