package responseMapping;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.*;


public class DateCheck {
    static String[] vacationDaysInTheWeek = {"SATURDAY", "SUNDAY"};

    private static Map<Integer,Integer> usMarketVacations(){
        Map<Integer, Integer>  vacationDaysAndMonth = new HashMap<>();

        vacationDaysAndMonth.put(1,1);
        vacationDaysAndMonth.put(1,15);
        vacationDaysAndMonth.put(2,19);
        vacationDaysAndMonth.put(3,29);
        vacationDaysAndMonth.put(5, 27);
        vacationDaysAndMonth.put(6,19);
        vacationDaysAndMonth.put(7,3);
        vacationDaysAndMonth.put(7,4);
        vacationDaysAndMonth.put(11,28);
        vacationDaysAndMonth.put(11,29);
        vacationDaysAndMonth.put(12,24);
        vacationDaysAndMonth.put(12,25);

        return vacationDaysAndMonth;



    }
    private static boolean isAWeekend(LocalDate date){
        boolean check =  false;
        if (Arrays.stream(vacationDaysInTheWeek).anyMatch(s->date.getDayOfWeek().toString().equalsIgnoreCase(s))){
            System.out.println(date);
            throw new RuntimeException("The data contains prices for weekends");


        }else{
            check = true;
        }
        return check;
    }

    public static boolean vacationDaysCheck(String date){
        boolean check = false;
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatedDate = LocalDate.parse(date , formatter);
        if (!isAWeekend(formatedDate) || Objects.nonNull(usMarketVacations().get(formatedDate.getMonthValue()))){
            if (usMarketVacations().get(formatedDate.getMonthValue()) == formatedDate.getDayOfMonth()){
                System.out.println(date);
                throw new RuntimeException("The data contains prices on vacation days" + date);

            }else{
                check = true;
            }

        }else {
            check = true;
        }


        return check;
    }

    private static LocalDateTime dataPointsTime(String date){
        //DateTimeFormatter
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime formatedDate = LocalDateTime.parse(date , formatter);
        return formatedDate;
    }
    public static boolean timePointDifference(List<String> times, long interval){
        List<Long> splits = new ArrayList<>();
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < times.size()-1; i++){
         //   System.out.println(dataPointsTime(times.get(i+1)));
            LocalDate formatedDate = LocalDate.parse(times.get(i) , formatter);
            if (LocalDate.parse(times.get(i+1) , formatter).getDayOfYear() == LocalDate.parse(times.get(i) , formatter).getDayOfYear()){
                System.out.println(LocalDate.parse(times.get(i+1) , formatter));
                long split =  dataPointsTime(times.get(i+1)).
                        until(dataPointsTime(times.get(i)), ChronoUnit.MINUTES);
                splits.add(split);
            }




        }
        System.out.println(splits.get(1));
        return splits.stream().allMatch(s->s == interval);



    }
    public static boolean allDataDoesntContainVacation(List<String> dates){
        List<Boolean> checks = new ArrayList<>();
        for (String date : dates){
           boolean check = vacationDaysCheck(date);
           checks.add(check);
        }
        return !checks.contains(false);
    }
    public static boolean adjustedParamIsReturningPricesWithoutHistoricalSplit(){


        return false;
    }
    public static boolean extendedHoursParamTest(List<String> dates){
        List<Boolean> checks  = new ArrayList<>();

        List<Long> splits = new ArrayList<>();
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalTime after = LocalTime.parse("16:00:00");
        LocalTime before = LocalTime.parse("09:30:00");
        for (String date : dates){
            LocalDateTime parsedDate = LocalDateTime.parse(date, formatter);
            if (parsedDate.toLocalTime().isAfter(after)|| parsedDate.toLocalTime().isBefore(before)){
                System.out.println(parsedDate.toLocalTime());
                checks.add(false);
            }
        }
        System.out.println(checks.size());
        return !checks.contains(false);
    }
    public static boolean monthlyIntervalIsReturned(List<String> dates, String date){
        List<Boolean> checkMonthlyIsCorrect = new ArrayList<>();
        List<Boolean> checkMonthlyDataInterval = new ArrayList<>();
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate formatedDate = LocalDate.parse(date , formatter);
        LocalDate formattedReferenceDate = LocalDate.parse(date,formatter);
        DateTimeFormatter formattingTheSuppliedDate =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (String dt: dates){
            LocalDateTime parsedDate = LocalDateTime.parse(dt, formattingTheSuppliedDate);
            if (formattedReferenceDate.getMonthValue() == parsedDate.getMonthValue()&& formattedReferenceDate.getYear()
            == parsedDate.getYear() ){
                checkMonthlyIsCorrect.add(true);

            }else{
                checkMonthlyIsCorrect.add(false);
            }

        }
//        if (timePointDifference(dates, interval)){
//            checkMonthlyDataInterval.add(true);
//        }else{
//            throw new RuntimeException("The monthly interval doesn't show correct data point interval");
//        }
        return !checkMonthlyIsCorrect.contains(false) && !checkMonthlyDataInterval.contains(false);
    }







}
