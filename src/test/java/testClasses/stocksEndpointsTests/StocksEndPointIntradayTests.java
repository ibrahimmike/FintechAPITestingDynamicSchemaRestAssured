package testClasses.stocksEndpointsTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import responseMapping.DateCheck;
import responseMapping.Responses;
import responseMapping.StockTimeSeries;
import utilities.Constants;

public class StocksEndPointIntradayTests {
    @Test
    public void intraDay1MHasCorrectDataIntervals(){
        RequestSpecification specs = new RequestSpecBuilder().addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_1MIN)
                .build();
        Responses intraDay1m = StockTimeSeries.getStocksWith1MTimeInterval(specs);
        boolean dataPoints = DateCheck.timePointDifference(intraDay1m.getSeries().keySet().stream().toList(),1);
        Assert.assertTrue(dataPoints,"Not all data are having one minute interval");

    }
    @Test
    public void intraDay5MHas5mTimeIntervalBetweenDataPoints(){
        RequestSpecification specs = new RequestSpecBuilder().addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_5MIN)
                .build();
        Responses intraDay5m = StockTimeSeries.getStockWith5MTimeInterval(specs);
        boolean dataPoints = DateCheck.timePointDifference(intraDay5m.getSeries().keySet().stream().toList(),5);
        Assert.assertTrue(dataPoints,"Not all data are having 5 minute interval");
    }
    @Test
    public void intraDay15MHas15MinutesTimeIntervalBetweenDataPoints(){
        RequestSpecification specs = new RequestSpecBuilder().addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_15MIN)
                .build();
        Responses intraDay15m = StockTimeSeries.getStockWith15MTimeInterval(specs);
        boolean dataPoints = DateCheck.timePointDifference(intraDay15m.getSeries().keySet().stream().toList(),15);
        Assert.assertTrue(dataPoints,"Not all data are having 15 minute interval");

    }
    @Test
    public void intraDay30MHas30MinutesTimeIntervalBetweenDataPoints(){
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_30MIN)
                .build();
        Responses intraDay30m = StockTimeSeries.getStockWith30MTimeInterval(specs);
        boolean dataPoints = DateCheck.timePointDifference(intraDay30m.getSeries().keySet().stream().toList(),30);
        Assert.assertTrue(dataPoints,"Not all data are having 30 minute interval");
    }
    @Test
    public void intraDay60MHas60MinutesTimeIntervalBetweenDataPoints(){
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_60MIN)
                .build();
        Responses intraDay60m = StockTimeSeries.getStockWith60MTimeInterval(specs);
        boolean dataPoints = DateCheck.timePointDifference(intraDay60m.getSeries().keySet().stream().toList(),60);
        Assert.assertTrue(dataPoints,"Not all data are having 60 minute interval");
    }


   // dailyAdjusted
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

    //extended hours
    @Test
    public void extendedHoursIntraday1m(){
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_1MIN)

                .addParam("extended", false)
                .build();
        Responses extendedFalse = StockTimeSeries.getStocksWith1MTimeInterval(specs);
        //   extendedFalse.getSeries().keySet().forEach(s-> );
        boolean extendedTradingIsNotShowing  = DateCheck.extendedHoursParamTest(extendedFalse.getSeries().keySet().stream().toList());

        Assert.assertTrue(extendedTradingIsNotShowing, "The data contains extended trading hours value despite the param was set to false");
    }
    @Test
    public void extendedHoursIntraday5m(){
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_5MIN)

                .addParam("extended", false)
                .build();
        Responses extendedFalse = StockTimeSeries.getStockWith5MTimeInterval(specs);
        boolean extendedTradingHoursAreNotShowing = DateCheck.extendedHoursParamTest(extendedFalse.getSeries().keySet().stream().toList());
        Assert.assertTrue(extendedTradingHoursAreNotShowing, "The data contains extended trading hours value despite the param was set to false");
    }
    @Test
    public void extendedHoursIntraday15m(){
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_15MIN)
                .addParam("extended", true)
                .build();
        Responses extendedFalse = StockTimeSeries.getStockWith15MTimeInterval(specs);
        boolean extendedTradingHoursAreNotShowing = DateCheck.extendedHoursParamTest(extendedFalse.getSeries().keySet().stream().toList());
        Assert.assertTrue(extendedTradingHoursAreNotShowing, "The data contains extended trading hours value despite the param was set to false");
    }
    @Test
    public void extendedHoursIntraday30m(){
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_30MIN)
                .addParam("extended", false)
                .build();
        Responses extendedFalse = StockTimeSeries.getStockWith30MTimeInterval(specs);
        boolean extendedTradingHoursAreNotShowing = DateCheck.extendedHoursParamTest(extendedFalse.getSeries().keySet().stream().toList());
        Assert.assertTrue(extendedTradingHoursAreNotShowing, "The data contains extended trading hours value despite the param was set to false");
    }
    @Test
    public void extendedHoursIntradayMonth30m(){
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_30MIN)
                .addParam("month","2009-01" )
                .build();
        Responses extendedFalse = StockTimeSeries.getStockWith30MTimeInterval(specs);
        boolean monthlyParamResults = DateCheck.monthlyIntervalIsReturned(extendedFalse.getSeries().keySet().stream().toList(),"2009-01-01");
        Assert.assertTrue(monthlyParamResults, "The monthly is not showing one month consistent interval");

    }

    //OutPutSize
    @Test
    public void outPutSizeParameterWithMonthly(){
        RequestSpecification specs = new RequestSpecBuilder()
                .addParam("function", Constants.TIME_SERIES_INTRADAY)
                .addParam("symbol","IBM")
                .addParam("interval", Constants.STOCKS_INTERVAL_30MIN)
                .addParam("month","2009-01")
                .addParam("outputsize", "full")
                .build();
        Responses extendedFalse = StockTimeSeries.getStockWith30MTimeInterval(specs);

        boolean count = extendedFalse.getSeries().keySet().stream().toList().size()> 100;
        boolean monthlyParamResults = DateCheck.monthlyIntervalIsReturned(extendedFalse.getSeries().keySet().stream().toList(),"2009-01-01");
        //    Assert.assertTrue(monthlyParamResults, "The monthly is not showing one month consistent interval");
        boolean monthlyParamInterval = DateCheck.timePointDifference(extendedFalse.getSeries().keySet().stream().toList(), 30);
        SoftAssert asrt = new SoftAssert();
        asrt.assertTrue(count);
        asrt.assertTrue(monthlyParamResults, "The monthly is not showing one month consistent interval");
        asrt.assertTrue(monthlyParamInterval, "Interval is not applied for the monthly 30 minutes interval when extended");
        asrt.assertAll();
    }
    //Data type




}
