package qiang.finance.portfolio.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the PORTFOLIO_TRANSACTION database table.
 * 
 */
@Entity
@Table(name="PORTFOLIO_TRANSACTION")
@NamedQuery(name="PortfolioTransaction.findAll", query="SELECT p FROM PortfolioTransaction p")
public class PortfolioTransaction implements Serializable, DomainObject {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="Portforlio_TXN_ID_Generator", table="ID_TABLE", 
                    pkColumnName="ID_NAME", valueColumnName="ID_HI",
                    pkColumnValue="PORTFOLIO_TRANSACTION_ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="Portforlio_TXN_ID_Generator")
	@Column(name="ID")
	private int id;

	@Column(name="COMMISSION_DEAL_FEE")
	private int commissionDealFee;

	@Column(name="COMMISSION_STAMP_DUTY")
	private int commissionStampDuty;

	@Column(name="CURRENCY")
	private String currency;

	@Column(name="PRICE")
	private int price;

	@Column(name="PRICE_UNIT")
	private String priceUnit;

	@Column(name="QUANTITY")
	private int quantity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;

	//uni-directional many-to-one association to Instrument
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_ID")
	private Instrument instrument;

	//bi-directional many-to-one association to Portfolio
	@ManyToOne
	@JoinColumn(name="PORTFOLIO_ID")
	private Portfolio portfolio;

	public PortfolioTransaction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommissionDealFee() {
		return this.commissionDealFee;
	}

	public void setCommissionDealFee(int commissionDealFee) {
		this.commissionDealFee = commissionDealFee;
	}

	public int getCommissionStampDuty() {
		return this.commissionStampDuty;
	}

	public void setCommissionStampDuty(int commissionStampDuty) {
		this.commissionStampDuty = commissionStampDuty;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPriceUnit() {
		return this.priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public Portfolio getPortfolio() {
		return this.portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

}