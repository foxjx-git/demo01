package com.my.mydemo_01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class Mydemo01ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化当前日期和时间
        String formattedDateTime = currentDateTime.format(formatter);

        // 输出格式化后的日期和时间
        System.out.println("格式化后的当前日期和时间: " + formattedDateTime);
        LocalDateTime newDateTime = currentDateTime.plusDays(1).plusHours(2).plusMinutes(10).plusSeconds(6);
        System.out.println("newDateTime: "+newDateTime);
    }
}
