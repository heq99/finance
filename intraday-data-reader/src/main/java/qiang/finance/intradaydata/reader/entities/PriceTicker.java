package qiang.finance.intradaydata.reader.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Qiang He on 07/02/2016.
 */
@Entity
@Table(name = "PRICE_TICKER")
public class PriceTicker implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIME_STAMP")
    private Date timestamp;

    @Column(name = "CLOSE")
    private BigDecimal close;

    @Column(name = "HIGH")
    private BigDecimal high;

    @Column(name = "LOW")
    private BigDecimal low;

    @Column(name = "OPEN")
    private BigDecimal open;

    @Column(name = "VOLUME")
    private Long volume;

    public PriceTicker() {

    }

    public PriceTicker(Date timestamp, BigDecimal close, BigDecimal high, BigDecimal low, BigDecimal open, Long volume) {
        this.timestamp = timestamp;
        this.close = close;
        this.high = high;
        this.low = low;
        this.open = open;
        this.volume = volume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }
}
