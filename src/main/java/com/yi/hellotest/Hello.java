package com.yi.hellotest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
 
//Component ������̼� ����ϸ� xml���� bean���� ���ش��Ͱ� ���� (EX:<bean id="stringPrinter" class =""> -> @Component)
@Component
public class Hello {
    
    // bean�� �׽�Ʈ �� Value�� �ִ¹��
    // 1. xml�������Ͽ� <property name="name" value ="������"/> �� ���� ������Ƽ ���� (�̶�, name������)
    // 2. @Value("")�� ������̼�Ȱ��
    // 3. @Resource(name = "${sName}")�� properties�������� Ȱ��
    String name;
    
    // value�� ���� �ƴ϶� object�� �־��ִ� ���
    // 1. @Autowired
    //      @Qualifier("stringPrinter") ���ָ� partner�� �������ִ°Ͱ� ����    
    // 2. @Resource(name = "${printer}") Ȱ��
    Printer printer;
 
    public Hello() {
        System.out.println("Hello �⺻ ������ ȣ��");
    }
 
    public Hello(String name, Printer printer) {
            System.out.println("Hello �����ε��� ������");
        this.name = name;
        this.printer = printer;
    }
 
    public void setName(String name) {
        System.out.println("setNames �⺻ ������ ȣ�� : " + name);
        this.name = name;
    }
 
    public void setPrinter(Printer printer) {
        System.out.println("setPrinter �⺻ ������ ȣ�� : " + printer.getClass().getName());
        this.printer = printer;
    }
 
    public String sayHello() {
        return "Hello " + name;
    }
 
    public void print() {
        this.printer.print(sayHello());
    }
 
}