package ccf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Crontab {
    static class Job{
        String minutes;
        String hours;
        String dayOfMonth;
        String month;
        String dayOfWeek;
        String command;

        public Job(String minutes, String hours,
                   String dayOfMonth, String month,
                   String dayOfWeek, String command) {
            this.minutes = minutes;
            this.hours = hours;
            this.dayOfMonth = dayOfMonth;
            this.month = month;
            this.dayOfWeek = dayOfWeek;
            this.command = command;
        }

    }
    public static boolean isMatched(String target, int now){
        if (target.equals("*")){
            return true;
        }
        //有逗号, 即有多个选项
        if (target.contains(",")){
            String[] splits = target.split(",");
            for (int i = 0; i < splits.length; i ++){
                //逗号项包含范围的情况
                if (splits[i].contains("-")){
                    String[] range = splits[i].split("-");
                    if (Integer.parseInt(range[0]) <= now && now <= Integer.parseInt(range[1])){
                        return true;
                    }
                }
                if (Integer.parseInt(splits[i]) == now){    //多个单独的点
                    return true;
                }
            }
        }else if (target.contains("-")){    //只包含范围的情况
            String[] range = target.split("-");
            if (Integer.parseInt(range[0]) <= now && now <= Integer.parseInt(range[1])){
                return true;
            }
        }else{
            if (Integer.parseInt(target) == now){ //孤零零的一个时间点
                return true;
            }
        }
        return false;
    }
    public static void isSatisfied(Job job, Calendar cal){

//        int year = cal.get(Calendar.YEAR);
        int minutes = cal.get(Calendar.MINUTE);
        int hours = cal.get(Calendar.HOUR);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("________________________________________");
        System.out.println(formatInteger(cal.get(Calendar.YEAR), 4)+ " " +
                formatInteger(cal.get(Calendar.MONTH)+1, 2) + " " +
                formatInteger(cal.get(Calendar.DAY_OF_MONTH),2) + " " +
                formatInteger(cal.get(Calendar.HOUR), 2) + " " +
                formatInteger(cal.get(Calendar.MINUTE), 2) + "\t" );
//                + job.command
//        );
        if(isMatched(job.minutes, minutes) && isMatched(job.hours, hours)
                && isMatched(job.dayOfMonth, dayOfMonth) && isMatched(job.month, month)
                && isMatched(job.dayOfWeek, dayOfWeek)){
            System.out.println(formatInteger(cal.get(Calendar.YEAR), 4)+ "" +
                    formatInteger(cal.get(Calendar.MONTH)+1, 2) + "" +
                    formatInteger(cal.get(Calendar.DAY_OF_MONTH),2) + "" +
                    formatInteger(cal.get(Calendar.HOUR), 2) + "" +
                    formatInteger(cal.get(Calendar.MINUTE), 2) + " " +
                    job.command
            );
        }
    }
    public static Calendar stringToCal(String s){
        Date d;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
        try {
            d = df.parse(s);
        } catch (ParseException e){
            d = null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal;
    }
    public static String formatInteger(int integer, int length){
        String s = "" + integer;
        StringBuilder sb = new StringBuilder();
        if (s.length() < length){
            for (int i = 0; i < length - sb.length(); i ++){
                sb.append("0");
            }
        }
        sb.append(s);
        return sb.toString();

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List jobs = new ArrayList();
        String startString = in.next();
        String endString = in.next();

        String minutes;
        String hours;
        String dayOfMonth;
        String month;
        String dayOfWeek;
        String command;
        for (int i = 0; i < n; i ++){
            minutes = in.next();
            hours = in.next();
            dayOfMonth = in.next();
            month = in.next();
            dayOfWeek = in.next();
            command = in.next();
            jobs.add(new Job(minutes, hours, dayOfMonth, month, dayOfWeek, command));
        }
        Calendar start = Crontab.stringToCal(startString);
        Calendar end = Crontab.stringToCal(endString);
        long endTimeStamp = end.getTimeInMillis();
        while (start.getTimeInMillis() <= endTimeStamp){
            for (int i = 0; i < jobs.size(); i ++){
                isSatisfied((Job) jobs.get(i), start);
            }

            start.add(Calendar.MINUTE, 1);

        }

        /*
        *最简单的测试用例
3 201711170032 201711222352
0 7 * * 1 get_up
30 23 * * 6 go_to_bed
15 12 * * * have_dinner

        *没做字符-数字映射的用例

3 201711170032 201711222352
0 7 * * 1,3-5 get_up
30 23 * * 6,0 go_to_bed
15 12,18 * * * have_dinner

        *做了字符串映射的测试用例
3 201711170032 201711222352
0 7 * * 1,3-5 get_up
30 23 * * Sat,Sun go_to_bed
15 12,18 * * * have_dinner
        */

//        Calendar cal = new Calendar();
    }
}
