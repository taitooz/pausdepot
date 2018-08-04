package com.pausa.stockservice;

import com.pausa.stockservice.config.StockServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockServiceApplication.class)
@WebAppConfiguration
public class StockServiceApplicationTests {

  @Test
  public void contextLoads() {
  }

}
