package cj.serialize.entity;

import java.util.Date;
import java.math.BigDecimal;

public class Address {

  private Long id;

  private String name;

  private String address;

  private String phoneNumber;

  private String email;

  private Date date;

  private BigDecimal dec;

  public Long getId(){
    return id;
  }
  public void setId(Long id){
    this.id = id;
  }

  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }

  public String getAddress(){
    return address;
  }
  public void setAddress(String address){
    this.address = address;
  }

  public String getPhoneNumber(){
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  public String getEmail(){
    return email;
  }
  public void setEmail(String email){
    this.email = email;
  }

  public Date getDate(){
    return date;
  }
  public void setDate(Date date){
    this.date = date;
  }

  public BigDecimal getDec(){
    return dec;
  }
  public void setDec(BigDecimal dec){
    this.dec = dec;
  }

  public String toString(){
    String dataFormart = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
    return String.format("Address [id=%s, name=%s, address=%s, phoneNumber=%s, email=%s, date=%s, dec=%s]",
        (id != null) ? id.toString() : "NULL",
        (name != null) ? name.toString() : "NULL",
        (address != null) ? address.toString() : "NULL",
        (phoneNumber != null) ? phoneNumber.toString() : "NULL",
        (email != null) ? email.toString() : "NULL",
        (date != null) ? String.format(dataFormart, date) : "NULL",
        (dec != null) ? dec.toString() : "NULL");
  }
}