package testClasses;

import endpoints.coreStocksEndpoints.StocksEndpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import responseMapping.Responses;
import responseMapping.StockTimeSeries;
import utilities.Constants;


public class FirstTest {
    @Test
    public void checkNewStructure(){
       Responses responses = StockTimeSeries.createObjet();
       responses.getSeries().keySet().forEach(s-> System.out.println(s));
    }
    @Test
    public void check(){
        Response response = StocksEndpoints.getDailyStock("ibm","TIME_SERIES_DAILY");
        System.out.println(response.body().print());
    }


    @Test
    public void responseSchemaValidator(){
        Response response = StocksEndpoints.getDailyStock("ibm", "TIME_SERIES_DAILY");
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coreStocksEndpointsSchema/coreStocksDailySchemas/coreStocksEndpointsDaily.json"));
    }
    @Test
    public void responseSchemaValidatorIntraDay(){
        Response response = StocksEndpoints.getIntraDayStock("ibm", "TIME_SERIES_INTRADAY", Constants.STOCKS_INTERVAL_5MIN);
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coreStocksEndpointsSchema/coreStockEndpointsIntraday.json")).log().all();
    }
    @Test
    public void responseSchemaValidatorIntraDayPlayGround(){
        Response response = StocksEndpoints.getIntraDayStock("ibm", "TIME_SERIES_INTRADAY", Constants.STOCKS_INTERVAL_5MIN);
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coreStocksEndpointsSchema/intradaySchemas/intraDay5minSchema.json")
        ).log().all();
    }
    @Test
    public void specsOptions(){

        //function symbol interval
        RequestSpecification specs = new RequestSpecBuilder().addParam("function", "TIME_SERIES_DAILY").addParam("symbol","IBM")
                .build();
        Response response = StocksEndpoints.getDailyStockSpecs(specs);
        Responses objects = response.as(Responses.DailyResponse.class);
        System.out.println(objects.getSeries().keySet());

    }

}
