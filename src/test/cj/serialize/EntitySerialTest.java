package cj.serialize;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.io.File;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import cj.serialize.entity.Address;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;

public class EntitySerialTest {

  public static void main(String[] args) throws Exception {
    EntitySerialTest test = new EntitySerialTest();
    test.testEncode();
    test.testDecode();
    test.testAddress();
  }

  public void testEncode() throws Exception {
    String date = "2020-07-01 17:00:00";
    Address address = new Address();
    address.setId(1L);
    address.setName("K 先生");
    address.setAddress("China");
    address.setPhoneNumber("01234567890");
    address.setEmail("mrcuijt@gmail.com");
    address.setDate(getDate(date));
    address.setDec(new BigDecimal("1"));
    EntitySerial<Address> serial = new EntitySerial<Address>();
    File file = serial.encode(address, "address.xml");
    assertEquals(true, file.exists());
    System.out.println(address);
  }

  public void testDecode() throws Exception {
    String date = "2020-07-01 17:00:00";
    EntitySerial<Address> serial = new EntitySerial<Address>();
    Address address = serial.decode("address.xml");
    System.out.println(address);
    assertEquals(1L, address.getId().longValue());
    assertEquals("K 先生", address.getName());
    assertEquals("China", address.getAddress());
    assertEquals("01234567890", address.getPhoneNumber());
    assertEquals("mrcuijt@gmail.com", address.getEmail());
    assertEquals(getDate(date), address.getDate());
    assertEquals(null, address.getDec());
    //assertEquals(new BigDecimal("1"), address.getDec());
  }

  public void testAddress(){
    Address address = new Address();
    System.out.println(address);
  }

  public Date getDate(String date) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.parse(date);
  }

}