package qiang.finance.portfolio.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PORTFOLIO database table.
 * 
 */
@Entity
@Table(name="PORTFOLIO")
@NamedQuery(name="Portfolio.findAll", query="SELECT p FROM Portfolio p")
public class Portfolio implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="DESCRIPTION")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_MODIFY_DATE")
	private Date lastModifyDate;

	@Column(name="NAME")
	private String name;

	//bi-directional many-to-one association to PortfolioTransaction
	@OneToMany(mappedBy="portfolio")
	private List<PortfolioTransaction> portfolioTransactions;

	public Portfolio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastModifyDate() {
		return this.lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PortfolioTransaction> getPortfolioTransactions() {
		return this.portfolioTransactions;
	}

	public void setPortfolioTransactions(List<PortfolioTransaction> portfolioTransactions) {
		this.portfolioTransactions = portfolioTransactions;
	}

	public PortfolioTransaction addPortfolioTransaction(PortfolioTransaction portfolioTransaction) {
		getPortfolioTransactions().add(portfolioTransaction);
		portfolioTransaction.setPortfolio(this);

		return portfolioTransaction;
	}

	public PortfolioTransaction removePortfolioTransaction(PortfolioTransaction portfolioTransaction) {
		getPortfolioTransactions().remove(portfolioTransaction);
		portfolioTransaction.setPortfolio(null);

		return portfolioTransaction;
	}

}