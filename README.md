# cj.serialize
Java XMLEncoder Tools

The XMLEncoder class provides a default denotation for JavaBeans in which they are represented as XML documents complying with version 1.0 of the XML specification and the UTF-8 character encoding of the Unicode/ISO 10646 character set. 

# Attention

 - JavaBeans class must have either a public zero-argument constructor.

 - Property must have getter,setter method.

 - If Property have default value or value is null if not modify it will be ignore.

```java
// Example 1:
class Demo {
  private String name = "default"; // or private String name = null;

  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
}

// Example 2:
class Demo {

  // Constructor
  public Demo(){
    /*
     * if name's value have not change or change value is same as default value,
     * it will be ignore.
     */
    name = "default"; // 
  }

  private String name;

  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
}
```

 - If Property is static it will be ignore.
 
 - Not support BigDecimal, it will be ignore.

# Useage

## Encode
```java
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
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<java version="1.8.0_152" class="java.beans.XMLDecoder">
 <object class="cj.serialize.entity.Address">
  <void property="address">
   <string>China</string>
  </void>
  <void property="date">
   <object class="java.util.Date">
    <long>1593594000000</long>
   </object>
  </void>
  <void property="email">
   <string>mrcuijt@gmail.com</string>
  </void>
  <void property="id">
   <long>1</long>
  </void>
  <void property="name">
   <string>K 先生</string>
  </void>
  <void property="phoneNumber">
   <string>01234567890</string>
  </void>
 </object>
</java>
```

## Decode

```java
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
```