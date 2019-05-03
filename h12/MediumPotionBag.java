package edu.ics211.h12;

import java.util.TreeMap;

/** Creates a MediumPotionBag class that implements the PotionBag interface. 
 * Uses TreeMap to store potion items.
 * @author caleb cheshire
 *        got help on TreeMaps from https://stackoverflow.com/questions/32610558/tree-map-retrieves-value-of-hashmap-instead-of-the-tree-map-values-java
 *        got help from Prof. Moore's screencasts & lectures
 *        found help for the interface method from https://github.com/sjavella/ICS211/tree/master/ics211
 */
public class MediumPotionBag implements PotionBag {
  private static MediumPotionBag instance;
  private TreeMap<Potion, Potion> myPotions = new TreeMap<Potion, Potion>(new PotionComparator());

  @Override
  public void store(Potion p) {
    myPotions.put(p, p);
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
    return myPotions.remove(p);
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
    return myPotions.size();
  }

  /** Declares a getInstance method.
   * 
   * @return instance
   */
  public static MediumPotionBag getInstance() {
    if (instance == null) {
      instance = new MediumPotionBag();
    }
    return instance;
  }
}
