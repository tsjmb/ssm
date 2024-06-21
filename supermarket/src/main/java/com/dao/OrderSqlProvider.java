package com.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class OrderSqlProvider {
    public String selectTotal(@Param("years") int years,@Param("months") int months){

        SQL sql = new SQL();
        sql.SELECT("sum(total)");
        sql.FROM("`order`");
        sql.WHERE("YEAR(times)=#{years}");
        sql.AND();
        for (int i = 1; i <= months; i++) {

            if(months==1){
                sql.WHERE("MONTH(times)="+i);
                continue;
            }

            if(i==1){
                sql.WHERE("("+"MONTH(times)="+i);
            }else if(i==months){
                sql.WHERE("MONTH(times)="+i+")");
            }else{
                sql.WHERE("MONTH(times)="+i);
            }
            if(i!=months){
                sql.OR();
            }
        }
        sql.GROUP_BY("YEAR(times)");
        sql.GROUP_BY("MONTH(times)");

        sql.ORDER_BY("YEAR(times)");
        sql.ORDER_BY("MONTH(times)");

//        System.out.println(sql.toString());

        return sql.toString();
    }

    public String selectByDay(@Param("years")int years,@Param("months") int months,@Param("days") int days){
        SQL sql = new SQL();
        sql.SELECT("sum(num) as num");
        sql.SELECT("sum(total) as total");
        sql.FROM("`order`");

        sql.WHERE("(YEAR(times)=#{years}");
        sql.WHERE("MONTH(times)=#{months})");

        if(days==1){
            sql.WHERE("DAY(times)=#{days}");
        }else{
            for(int i=days;i >days-7 && i>0;i--){
                if(i==days){
                    sql.WHERE("("+"DAY(times)="+i);
                }else if(i==days-6){
                    sql.WHERE("DAY(times)="+i+")");
                }else{
                    sql.WHERE("DAY(times)="+i);
                }

                if(i!=days-6){
                    sql.OR();
                }
            }
        }

        sql.GROUP_BY("YEAR(times)");
        sql.GROUP_BY("MONTH(times)");
        sql.GROUP_BY("DAY(times)");

        sql.ORDER_BY("YEAR(times)");
        sql.ORDER_BY("MONTH(times)");
        sql.ORDER_BY("DAY(times)");

        System.out.println(sql.toString());

        return sql.toString();
    }
}
