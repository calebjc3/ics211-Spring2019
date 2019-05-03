/**
 * 
 */

package edu.ics211.h01;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Declares Translator.
 * @author calebjc3
 *     with guidance from Selim Karaoglu
 *
 */
public class Translator implements Translate {

  /**
   * Translator.
   * 
   */
  public Translator() {
    // TODO Auto-generated constructor stub
  }

  /* (non-Javadoc)
   * @see edu.ics211.h01.Translate#asBinaryString(java.io.InputStream)
   */
  @Override
  public String asBinaryString(InputStream in) {
    //create a StringBuilder
    StringBuilder string = new StringBuilder();
    //create a BitReader instance
    BitReader br = null;

    //use a try catch for the IOException
    try {
      br = new BitReader(in);
    } catch (IOException e) {
      e.printStackTrace();
    }

    //received clarification on this portion from Justin Chen
    //use a while loop to append bits to the StringBuilder
    while (!br.isDone()) {
      string.append(br.readAsInt());
    }
    String resultString = string.toString();
    return resultString;

  }

  /* (non-Javadoc)
   * @see edu.ics211.h01.Translate#asHexadecimalString(java.io.InputStream)
   */
  @Override
  public String asHexadecimalString(InputStream in) {
    //create a StringBuilder
    StringBuilder string1 = new StringBuilder();
    //initialize variable x
    int x;

    //received guidance on this portion from Gabriel Elacion
    //use a try catch for the IOException
    try {
      while ((x = in.read()) != -1) {
        String hexidecimal = Integer.toHexString(x);
        hexidecimal = String.format("%2s",hexidecimal).replace(" ", "0");
        string1.append(hexidecimal);
      }
      return string1.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /* (non-Javadoc)
   * @see edu.ics211.h01.Translate#asUtf8String(java.io.InputStream)
   */
  @Override
  public String asUtf8String(InputStream in) {
    //received guidance on this portion from Gabriel Elacion
    //create an array of bytes
    byte [] bytes1 = new byte [1024];
    //create an integer byteReader
    int byteReader = 0;
    //use a try catch for IOException
    try {
      //create a loop for the byte reader
      while (byteReader != -1) {
        byteReader = in.read(bytes1);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    //create a new stringBuilder
    StringBuilder string2 = new StringBuilder();
    int index;

    //use try catch for unsupported encoding exception
    try {
      string2.append(new String(bytes1, "UTF-8"));
      index = string2.lastIndexOf(".");
      string2.setLength(index + 1);
      return string2.toString();
    } catch (UnsupportedEncodingException e) {

      return null;
    }
  }

  /**
   * Declares main.
   * @param args
   * this is a string
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}