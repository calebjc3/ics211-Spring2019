package edu.ics211.h12;

import java.util.Hashtable;

/** Declares QuickPotionBag that implements PotionBag.
 * Uses a Hashtable data structure to provide a Big-O(1) or near constant time performance.
 * @author caleb cheshire
 *        got help from the Textbook, Section 7.4 & Prof. Moore's screencasts & lectures.
 *        Found help for hashtable implementation from: https://stackoverflow.com/questions/50396834/how-to-call-method-object-oin-the-same-class-in-hashtable
 *        Found structure for the interface method from https://github.com/sjavella/ICS211/tree/master/ics211
 *        Partnered with Justin Chen
 */
public class QuickPotionBag implements PotionBag {
  private static QuickPotionBag instance;
  private Hashtable<Potion, Potion> mypotions = new Hashtable<Potion, Potion>();

  @Override
  public void store(Potion p) {
    mypotions.put(p, p);
  }

  @Override
  public long timedStore(Potion p) {
    long startTime = System.nanoTime();
    store(p);
    long finishTime = System.nanoTime();
    return finishTime - startTime;
  }

  @Override
  public Potion retrieve(Potion p) {
    return mypotions.remove(p);
  }

  @Override
  public long timedRetrieve(Potion p) {
    long startTime = System.nanoTime();
    retrieve(p);
    long finishTime = System.nanoTime();
    return finishTime - startTime;
  }

  @Override
  public int size() {
    return mypotions.size();
  }

  /** Declares getInstance method.
   * 
   * @return instance.
   */
  public static QuickPotionBag getInstance() {
    if (instance == null) {
      instance = new QuickPotionBag();
    }
    return instance;
  }
}