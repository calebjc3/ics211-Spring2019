package edu.ics211.h03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Creates a File Reader that reads some data into different encoding.
 * @author Caleb Cheshire
 *        with  help from Tristan Yousuf-Leo
 *
 */
public class ReadFile implements IReadFile {

  @Override
  public String readFile(String fileName) throws IOException {
    InputStream input = new FileInputStream(fileName);
    @SuppressWarnings("resource")
    DataInputStream fileToRead = new DataInputStream(input);
    Integer size = fileToRead.readInt();
    Charset charset;

    byte bytes = fileToRead.readByte();
    switch (bytes) {
      case 1:
        charset = StandardCharsets.US_ASCII;
        break;
      case 2:
        charset = StandardCharsets.UTF_16LE;
        break;
      case 3:
        charset = StandardCharsets.UTF_8;
        break;
      case 4:
        charset = StandardCharsets.UTF_16;
        break;
      default:
        throw new IllegalArgumentException("Invalid type");
    }
    byte[] byteArray = new byte[size];
    input.read(byteArray);

    return new String(byteArray, charset);
  }
}
