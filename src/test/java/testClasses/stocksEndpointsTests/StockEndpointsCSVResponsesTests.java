package testClasses.stocksEndpointsTests;

import endpoints.coreStocksEndpoints.StocksEndpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utilities.Constants;

public class StockEndpointsCSVResponsesTests {

    @Test
    public void intraDayTimeSeriesInterval30MinIntervalCSVMonthlyParameterResponseOutPutSizeFull(){
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_30MIN)
                .addParam("month","2009-01" )
                .addParam("outputsize", "full")
                .addParam("datatype","csv")
                .build();
       Response response = StocksEndpoints.getCsvResponses(specs);
       response.then().statusCode(200);
    }
    @Test
    public void intraDayTimeSeriesInterval60MinIntervalCSVMonthlyParameterResponseOutPutSizeFull() {
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol", "IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_60MIN)
                .addParam("month", "2009-01")
                .addParam("outputsize", "full")
                .addParam("datatype", "csv")
                .build();
        Response response = StocksEndpoints.getCsvResponses(specs);
        response.then().statusCode(200);
    }
    @Test
    public void intraDayTimeSeriesInterval15MinIntervalCSVMonthlyParameterResponseOutPutSizeFull() {
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol", "IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_15MIN)
                .addParam("month", "2009-01")
                .addParam("outputsize", "full")
                .addParam("datatype", "csv")
                .build();
        Response response = StocksEndpoints.getCsvResponses(specs);
        response.then().statusCode(200);
    }
    @Test
    public void intraDayTimeSeriesInterval5MinIntervalCSVMonthlyParameterResponseOutPutSizeFull() {
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol", "IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_60MIN)
                .addParam("month", "2009-01")
                .addParam("outputsize", "full")
                .addParam("datatype", "csv")
                .build();
        Response response = StocksEndpoints.getCsvResponses(specs);
        response.then().statusCode(200);
    }
    @Test
    public void intraDayTimeSeriesInterval1MinIntervalCSVMonthlyParameterResponseOutPutSizeFull() {
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol", "IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_60MIN)
                .addParam("month", "2009-01")
                .addParam("outputsize", "full")
                .addParam("datatype", "csv")
                .build();
        Response response = StocksEndpoints.getCsvResponses(specs);
        response.then().statusCode(200);
    }
    @Test
    public void intraDayTimeSeriesInterval60MinIntervalCSVMonthlyParameterResponseOutPutSizeDefault() {
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol", "IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_60MIN)
                .addParam("month", "2009-01")
                .addParam("datatype", "csv")
                .build();
        Response response = StocksEndpoints.getCsvResponses(specs);
        response.then().statusCode(200);
    }
    @Test
    public void intraDayTimeSeriesInterval1MinIntervalCSVMonthlyParameterResponseOutPutSizeDefault() {
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol", "IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_60MIN)
                .addParam("month", "2009-01")
                .addParam("datatype", "csv")
                .build();
        Response response = StocksEndpoints.getCsvResponses(specs);
        response.then().statusCode(200);
    }




}
