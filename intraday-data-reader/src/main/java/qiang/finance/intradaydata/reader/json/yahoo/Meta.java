package qiang.finance.intradaydata.reader.json.yahoo;

/**
 * Created by qhe on 14/02/16.
 */
public class Meta {
    public String currency;
    public String symbol;
    public String exchangeName;
    public String instrumentType;
    public String firstTradeDate;
    public int gmtoffset;
    public String timezone;
    public String previousClose;
    public String scale;
    public CurrentTradingPeriod currentTradingPeriod;
    public TradingPeriods tradingPeriods;
    public String dataGranularity;
    public String[] validRanges;
}
