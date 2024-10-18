package responseMapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import endpoints.coreStocksEndpoints.StocksEndpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import utilities.Constants;

import java.util.Map;
import java.util.Objects;

public  class StockTimeSeries {
   static Response response;
    public static Responses createObjet() {
        response = StocksEndpoints.getDailyStock("IBM", "TIME_SERIES_DAILY");
        return response.as(Responses.DailyResponse.class);
    }

    public static Responses getStockPricesDaily(){

//        RequestSpecification specs = new RequestSpecBuilder()
//                .addParam("function", function )
//                .addParam("symbol", ticker.toUpperCase())
//                .addParam()
//                .build();
        response = StocksEndpoints.getDailyStock("IBM", Constants.TIME_SERIES_DAILY);
        Responses objects = response.as(Responses.DailyResponse.class);
        return objects;
    }
    public static Responses getStocksWith1MTimeInterval(RequestSpecification specs){

        response = StocksEndpoints.getStockPrices(specs);
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coreStocksEndpointsSchema/intradaySchemas/intraDay1minSchema.json"));
        return response.as(Responses.DailyInterval1M.class);
    }
    public static Responses getStockWith5MTimeInterval(RequestSpecification specs){
        response = StocksEndpoints.getStockPrices(specs);
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coreStocksEndpointsSchema/intradaySchemas/intraDay5minSchema.json"));
        return response.as(Responses.DailyInterval5M.class);
    }
    public static Responses getStockWith15MTimeInterval(RequestSpecification specs){
        response = StocksEndpoints.getStockPrices(specs);
        return response.as(Responses.DailyInterval15M.class);
    }
    public static Responses getStockWith30MTimeInterval(RequestSpecification specs){
        response = StocksEndpoints.getStockPrices(specs);
        return response.as(Responses.DailyInterval30M.class);
    }
    public static Responses getStockWith60MTimeInterval(RequestSpecification specs){
        response = StocksEndpoints.getStockPrices(specs);
        return response.as(Responses.DailyInterval60M.class);
    }
    public static Responses getStocksDaily(RequestSpecification specs){

        response = StocksEndpoints.getDailyStockSpecs(specs);
        return response.as(Responses.DailyResponse.class);
    }
    public static boolean compareData(RequestSpecification specs){
        boolean match = false;


        return match;

    }









}
