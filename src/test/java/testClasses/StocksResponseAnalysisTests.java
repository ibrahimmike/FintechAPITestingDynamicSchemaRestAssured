package testClasses;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import responseMapping.DateCheck;
import responseMapping.Responses;
import responseMapping.StockTimeSeries;
import utilities.Constants;

public class StocksResponseAnalysisTests {

    Responses daily ;


    @Test(priority = 1)
    public void dailyPricesRequestHasDailyTimeInterval(){
        RequestSpecification specs = new RequestSpecBuilder().addParam("function", Constants.TIME_SERIES_DAILY).addParam("symbol","IBM")
                .build();
        daily = StockTimeSeries.getStocksDaily(specs);
        boolean dataPointsHaveNoVacation = DateCheck.allDataDoesntContainVacation(daily.getSeries().keySet().stream().toList());
        System.out.println(dataPointsHaveNoVacation);
        Assert.assertTrue(dataPointsHaveNoVacation, "The data contains vacation days");
    }

    @Test
    public void dailyAdjustedParamEqualsToFalse(){
        RequestSpecification specs = new RequestSpecBuilder().
                addParam("function", "TIME_SERIES_DAILY")
                .addParam("symbol","IBM")
                .addParam("adjusted", false)
                .build();
        Responses adjustedTrue = StockTimeSeries.getStocksDaily(specs);
        System.out.println(adjustedTrue.getSeries().keySet());
    }
    //When adjusted is equal to true which is the default value the prices are returned adjusted to the stock splits.
    // when false the prices are returned in raw format no updates
    @Test
    public void intraDayAdjusted60MParamEqualsToFalse(){
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_60MIN)
                .addParam("adjusted", false)
                .build();
        Responses adjusted = StockTimeSeries.getStockWith60MTimeInterval(specs);
        System.out.println(adjusted.getSeries().keySet());

    }
    @Test
    public void intraDayACsvResponse(){

    }
    //Extended hours param when false removes the values extended trading hours both pre-market and post market trading hours
    // true is the default value for this param















}
