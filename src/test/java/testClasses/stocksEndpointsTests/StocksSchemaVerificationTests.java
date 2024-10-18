package testClasses.stocksEndpointsTests;

import endpoints.coreStocksEndpoints.StocksEndpoints;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.Constants;

public class StocksSchemaVerificationTests {

    @Test
    public void intraDay5MinutesIntervalSchemaValidation(){
        Response response = StocksEndpoints.getIntraDayStock("ibm", Constants.TIME_SERIES_INTRADAY, Constants.STOCKS_INTERVAL_5MIN);
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coreStocksEndpointsSchema/intradaySchemas/intraDay5minSchema.json"));

    }
    @Test
    public void intraDay15MinutesIntervalSchemaValidation(){
        Response response = StocksEndpoints.getIntraDayStock("ibm", Constants.TIME_SERIES_INTRADAY, Constants.STOCKS_INTERVAL_15MIN);
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coreStocksEndpointsSchema/intradaySchemas/intraDay15minSchema.json"));
    }
    @Test
    public void intraDay1MinuteIntervalSchemaValidation(){
        Response response = StocksEndpoints.getIntraDayStock("ibm", Constants.TIME_SERIES_INTRADAY, Constants.STOCKS_INTERVAL_1MIN);
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coreStocksEndpointsSchema/intradaySchemas/intraDay1minSchema.json"));
    }
    @Test
    public void intraDay30MinutesIntervalSchemaValidation(){
        Response response = StocksEndpoints.getIntraDayStock("ibm", Constants.TIME_SERIES_INTRADAY, Constants.STOCKS_INTERVAL_30MIN);
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coreStocksEndpointsSchema/intradaySchemas/intraDay30minSchema.json"));
    }
    @Test
    public void intraDay60MinutesIntervalSchemaValidation(){
        Response response = StocksEndpoints.getIntraDayStock("ibm", Constants.TIME_SERIES_INTRADAY, Constants.STOCKS_INTERVAL_60MIN);
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coreStocksEndpointsSchema/intradaySchemas/intraDay60minSchema.json"));
    }




}
