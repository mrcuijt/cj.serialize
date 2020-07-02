package cj.serialize;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

import java.io.File;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EntitySerial<T> {

  public File encode(Object obj, String fileName) throws IOException{
    try {
      File file = new File(fileName);
      XMLEncoder e = new XMLEncoder(
                            new BufferedOutputStream(
                                new FileOutputStream(file)));
      e.writeObject(obj);
      e.close();
      return file;
    } catch(FileNotFoundException e){
      throw new IOException(e);
    }
  }

  public T decode(String file) throws IOException {
    try {
      XMLDecoder d = new XMLDecoder(
                            new BufferedInputStream(
                                new FileInputStream(file)));
      Object result = d.readObject();
      d.close();
      return (T)result;
    } catch(FileNotFoundException e){
      throw new IOException(e);
    }
  }

}