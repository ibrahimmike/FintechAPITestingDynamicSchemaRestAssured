package responseMapping;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import utilities.Constants;

import java.util.Map;

public class Responses {

    @Getter
    Map<String, Object> metaData;

    @Getter
    Map<String, Prices> series;
    //final static String  timeSeries = Constants.getParam("5m");
    @JsonProperty("Meta Data")
    public void setMetaData(Map<String, Object> map) {
        this.metaData = map;
    }
    public static class DailyResponse extends Responses{
        @JsonProperty("Time Series (Daily)")
        public void setSeries(Map<String, Prices> map) {
            this.series = map;
        }

    }
    public static class DailyInterval5M extends Responses{
        @JsonProperty("Time Series (5min)")
        public void setSeries(Map<String, Prices> map) {
            this.series = map;
        }
    }
    public static class DailyInterval15M extends Responses{
        @JsonProperty("Time Series (15min)")
        public void setSeries(Map<String, Prices> map) {
            this.series = map;
        }
    }
    public static class DailyInterval30M extends Responses{
        @JsonProperty("Time Series (30min)")
        public void setSeries(Map<String, Prices> map) {
            this.series = map;
        }
    }
    public static class DailyInterval60M extends Responses{
        @JsonProperty("Time Series (60min)")
        public void setSeries(Map<String, Prices> map) {
            this.series = map;
        }
    }
    public static class DailyInterval1M extends Responses{
        @JsonProperty("Time Series (1min)")
        public void setSeries(Map<String, Prices> map) {
            this.series = map;
        }
    }





}
