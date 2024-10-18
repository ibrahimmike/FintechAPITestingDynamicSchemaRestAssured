package responseMapping;

import com.opencsv.bean.CsvBindByName;

public class CsvDataBeanClass {

    @CsvBindByName(column="timestamp", required = true)
    private String timeStamp;
    @CsvBindByName(column = "open", required = true )
    private String openPrice;
    @CsvBindByName(column = "high", required = true)
    private String highPrice;
    @CsvBindByName(column ="low", required = true)
    private String lowPrice;
    @CsvBindByName(column = "close", required = true)
    private String closePrice;
    @CsvBindByName(column ="volume", required = true)
    private String volume;

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
