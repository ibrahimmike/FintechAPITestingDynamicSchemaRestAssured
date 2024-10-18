package endpoints.coreStocksEndpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class StocksEndpoints {

    static String apiKey = "E9R4DA7YAR7KEA87";

    public static Response getDailyStock(String symbol, String timeSeries){
        String capitalized = symbol.toUpperCase();
        return given()
                .accept("application/json")
                .queryParam("function",timeSeries)
                .queryParam("symbol",capitalized)
                .queryParam("apikey",apiKey)

                .when().get(Routes.base_url);

    }
    public static Response getIntraDayStock(String symbol, String timeSeries, String interval){
        String capitalized = symbol.toUpperCase();

        return given()
                .accept("application/json")
                .queryParam("function", timeSeries)
                .queryParam("symbol",capitalized )
                .queryParam("interval",interval)
                .queryParam("apikey", apiKey )

                .log().uri()
                .when().get(Routes.base_url);
    }
    public static Response getDailyStockSpecs(RequestSpecification specs){
        //String capitalized = symbol.toUpperCase();
        return given()
                .accept("application/json")
                .spec(specs)
                .queryParam("apikey",apiKey)
                .log().uri()

                .when().get(Routes.base_url);

    }
    public static Response getStockPrices(RequestSpecification specs){
        //String capitalized = symbol.toUpperCase();
        return given()
                .accept("application/json")
                .spec(specs)
                .queryParam("apikey",apiKey)
                .log().uri()

                .when().get(Routes.base_url);
    }
    public static void createCsvFileFromCSV(Response response)  {
        //"resources/csvFiles"
        Path path = Path.of("src/test/resources/csvFiles");

        String fileName = response.getHeaders().get("Content-Disposition").getValue().split(";")[1].split("=")[1].trim();
        response.then().statusCode(200);
        byte[] bytes = response.getBody().asByteArray();
        //"src/test/resources/csvFiles/"


        File outPut = new File( path +"/" +fileName);


        try(FileOutputStream outputStream = new FileOutputStream(outPut)) {
           outputStream.write(bytes);
        } catch (IOException d) {
            throw new RuntimeException(d);
        }

   }
   public static Response getCsvResponses(RequestSpecification specs){
       Response response = given()
               .accept("application/json")
               .spec(specs)
               .queryParam("apikey", apiKey)
               .when().get(Routes.base_url);

         createCsvFileFromCSV(response);
       return response;
   }








}
