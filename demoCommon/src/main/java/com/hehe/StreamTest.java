package com.hehe;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StreamTest {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    public static void main(String[] args) {

        /*// 1. 不需要参数,返回值为 5
             () -> 5

          // 2. 接收一个参数(数字类型),返回其2倍的值
             x -> 2 * x

          // 3. 接受2个参数(数字),并返回他们的差值
             (x, y) -> x – y

         // 4. 接收2个int型整数,返回他们的和
             (int x, int y) -> x + y

        // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
             (String s) -> System.out.print(s)*/

       /* List list = new ArrayList<>();
        list.add("xxxx");
        list.add("ssss");
        list.add("gggg");

        //lamaba表达式
        list.forEach(name-> System.out.println(name));
        list.forEach(System.out::println);
        //Stream
        list.stream().forEach(string -> System.out.println(string));*/
        String str = "thisisfregfd_gfdg-gfdg_fhdgh";
        // begin 去掉前两个字符 从1开始
        String substring = str.substring(2);
        System.out.println(substring);
        // 去头不去尾
        String begend = str.substring(2, 5);
        System.out.println(begend);
        // 返回的是从后边找_ 然后从前边开始数从0开始数
        int i = str.lastIndexOf("_");
        System.out.println(i);
        int lastIndexOfint = str.lastIndexOf("g");
        System.out.println(lastIndexOfint);
        //从头数前十九个，前面的字符最后出现的位置，返回的是从头数的位置
        int index = str.lastIndexOf("f", 19);
        System.out.println(index);
        String[] split = str.split("-");
        for (String s : split) {
            System.out.println(s);
        }
        //limit 默认为0 会排除空字符串 -1代表尽可能多的次数，大于0的数返回的不会超过这个数最大等于这个数
        String[] strings = str.split("-",-1);
        System.out.println(strings);





    }

    // 批量执行sql
//    public int batchData(String sql,List<Object> list){
//
//        int[] len = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//
//
//            }
//
//            @Override
//            public int getBatchSize() {
//                return 0;
//            }
//        });
//
//        return len.length;
//
//    }
//
//
//    String batchSql = "insert into ..." ;










}
