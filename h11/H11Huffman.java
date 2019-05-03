package edu.ics211.h11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Compresses or decompresses files in Huffman encoding.
 *
 * @author Caleb Cheshire
 *        got help from Prof. Moore's screencasts and lectures (Huffman Trees and Codes screencast) 
 *         the textbook, section 6.7.
 *        Worked with Justin Chen on some of the methods. 
 *        Found clarification for decompression/compression at:
 *        https://stackoverflow.com/questions/21621396/how-to-decompress-a-file-or-folder-in-java && https://github.com/soeux
 *        
 */
public class H11Huffman {

  /** Creates main class.
   * 
   * @param args args
   * @throws IOException io
   */
  public static void main(String[] args) throws IOException {
    String fileName = "";

    if (args.length == 1) {
      fileName = args[0];
    } else if (args.length == 0) {
      System.out.println("error: missing file parameter");
      System.out.println("usage:\n\tdecompress: H11Huffman [file]"
          + ".huff\n\tcompress: H11Huffman [file]");
      System.exit(-1);
    } else if (args.length > 2) {
      System.out.println("error: too many file parameters");
      System.out.println("usage:\n\tdecompress: H11Huffman [file]"
          + ".huff\n\tcompress: H11Huffman [file]");
      System.exit(-1);
    }

    File testFile = new File(fileName);
    ArrayList<String> extension = new ArrayList<String>();

    if (extension.contains("huff")) {
      String newName = testFile.toString().substring(0, testFile.toString().lastIndexOf("."));
      File newFile = new File(System.getProperty("user.dir") 
          + System.getProperty("file.separator") + newName);

      if (newFile.createNewFile()) {
        InputStream fileStream = new FileInputStream(testFile);
        OutputStream targetOutput = new FileOutputStream(newFile);

        Huffman.decompress(fileStream, targetOutput);
        targetOutput.close();
        System.out.println("success: " + testFile.toString() + " -> " + newFile.toString());
      } else {
        System.out.println("error: file already uncompressed.");
        System.exit(1);
      }

    } else {
      File newFile = new File(System.getProperty("user.dir") 
          + System.getProperty("file.separator") + testFile.toString() + ".huff");
      if (testFile.exists() && testFile.isFile()) {
        extension.addAll(Arrays.asList(testFile.toString().split("\\.")));
      } else {
        System.out.println("error: file \"" + fileName 
            + "\" does not exist @ " + testFile.getAbsolutePath());
        System.exit(-2);
      }

      if (newFile.createNewFile()) {
        InputStream fileStream = new FileInputStream(testFile);
        OutputStream targetOutput = new FileOutputStream(newFile);

        Huffman.compress(fileStream, targetOutput);
        targetOutput.close();
        System.out.println("success: " + testFile.getAbsolutePath() 
            + " -> " + newFile.getAbsolutePath());
      } else {
        System.out.println("error: file aready compressed");
        System.exit(1);
      }
    }
  }
}