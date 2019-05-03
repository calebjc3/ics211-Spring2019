package edu.ics211.h12;

/** Declares SlowPotionBag class.
 * Uses an array structure to store the potion data and provide a performance of Big-O(n).
 * 
 * @author caleb cheshire
 *      got help from Prof. Moore's lectures & screencasts
 *      partnered with Justin Chen
 *      got help from https://github.com/sjavella/ICS211/tree/master/ics211
 *      found info about Big-O(n) structures at https://stackoverflow.com/questions/8356566/data-structure-that-has-on-iteration-o1-contains-and-o1-get-by-key
 * 
 *
 */
public class SlowPotionBag implements PotionBag {
  private static SlowPotionBag instance;
  private Potion [] mypotions = new Potion[100001];
  
  @Override
  public void store(Potion p) {
    for (int i = 0; i < mypotions.length; i++) {
      if (mypotions[i] == null) {
        mypotions[i] = p;
        break;
      }
    }
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
    for (int i = 0; i < mypotions.length; i++) {
      if (mypotions[i] == null) {
        return null;
      }
      if (mypotions[i].equals(p)) {
        return mypotions[i];
      }
    }
    return null;
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
    for (int i = 0; i < mypotions.length; i++) {
      if (mypotions[i] == null) {
        return i;
      }
    }
    return mypotions.length;
  }

  /** Declares getInstance method.
 * 
 * @return instance.
 */
  public static SlowPotionBag getInstance() {
    if (instance == null) {
      instance = new SlowPotionBag();
    }
    return instance;
  }
}