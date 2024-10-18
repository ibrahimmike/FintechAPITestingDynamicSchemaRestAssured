package responseMapping;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prices {


        private String openPrice;

        private String highPrice;
        private String low;

        private String closePrice;
        private String volume;
        @JsonProperty("1. open")
        public void setOpenPrice(String open){
            this.openPrice = open;

        }
        @JsonProperty("2. high")
        public void setHigh(String high){
            this.highPrice = high;
        }
        @JsonProperty("3. low")
        public void setLowPrice(String low){
            this.low = low;
        }
        @JsonProperty("4. close")
        public void setClosePrice(String closePrice){
            this.closePrice = closePrice;
        }
        @JsonProperty("5. volume")
        public void setVolume(String setVolume){
            this.volume = setVolume;
        }

    public String getOpenPrice() {
        return openPrice;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public String getLow() {
        return low;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public String getVolume() {
        return volume;
    }
}
