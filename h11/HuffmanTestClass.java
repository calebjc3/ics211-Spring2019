package edu.ics211.h11;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.Test;

/** Declares HuffmanTestClass.
 * 
 * @author Caleb Cheshire
 *        found clarification on how to do a JUnit test class from https://stackoverflow.com/questions/22944526/how-to-create-a-junit-test-class-and-run-in-executable-jar
 *        worked with Justin Chen on some of the methods.
 */
public class HuffmanTestClass {

  /*Discussion of Testing strategy:
   * To test this program, I simply created a JUnit to make sure that the program runs.
   * It does this by providing sample files for the program to run and see if they work.
   * If the sample files are properly compressed or decompressed, then the test passes.
   * The sample file which I created for the test is titled mytestfile.huff.txt
  */
  /** Declares testDecode method.
   * 
   * @throws IOException io
   */
  @Test
  public void testDecode() throws IOException {
    @SuppressWarnings("resource")
    InputStream ogFile = new FileInputStream("jabberwocky.txt");
    InputStream trgtFile = new FileInputStream("jabberwocky.txt.huff");
    BitReader trgtReader = new BitReader(trgtFile);
    OutputStream trgtOutput = new ByteArrayOutputStream();

    int counter = trgtReader.readInt();
    Huffman tree = new Huffman(trgtReader);
    tree.decode(counter, trgtReader, trgtOutput);

    String decoded = new String(((ByteArrayOutputStream) 
        trgtOutput).toByteArray()).replaceAll("\\r\\n", "\n");
    String orig = new String(ogFile.readAllBytes());

    assertEquals("wrong decoding", orig, decoded);
  }

  /** Declares a method to test the Data.
   * 
   * @throws IOException io
   */
  @Test
  public void testData() throws IOException {
    System.out.println("@Test:testData()");
    InputStream trgtFile = new FileInputStream("image.bmp.huff");
    BitReader trgtReader = new BitReader(trgtFile);
    int count = trgtReader.readInt();
    System.out.println("count: " + count);
    Huffman sampleTree = new Huffman(trgtReader);
    System.out.println(sampleTree);
  }
}