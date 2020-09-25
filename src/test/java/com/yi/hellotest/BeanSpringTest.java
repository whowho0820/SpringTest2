package com.yi.hellotest;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/springbeans.xml")
public class BeanSpringTest {
    
    
    @Autowired
    @Qualifier("helloPrinter")
    Hello hello;
 
/*    @Autowired
    @Qualifier("helloC")
    Hello hello2;*/
    
    @Autowired
    @Qualifier("stringPrinter")
    Printer printer;
 
    @Test
    public void helloBean() {
        //°ª ºñ±³ (Junit)
        Assert.assertEquals("Hello Á¶¼ºÈÆ", hello.sayHello());
 
        hello.print();
        Assert.assertEquals("Hello Á¶¼ºÈÆ", printer.toString());
    }
    
 
}