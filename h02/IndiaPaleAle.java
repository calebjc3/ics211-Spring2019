/**
 * 
 */

package edu.ics211.h02;

import java.util.concurrent.ThreadLocalRandom;

/** public class IndiaPaleAle.
 * @author caleb
 *        partnered with Justin Chen and Tristan Yousuf-Leo
 *
 */
public class IndiaPaleAle extends Beer {

  /** declare public construtor IndiaPaleAle.
   * 
   * @param name name
   * @param ibu Ibu
   * @param abv Abv
   */
  public IndiaPaleAle(String name, Integer ibu, Double abv) {
    super(name, BeerType.INDIA_PALE_ALE, ibu, abv);
    if (this.getIbu() < 40 || this.getIbu() > 100) {
      throw new IllegalArgumentException();
    }
    if (this.getAbv() < 5 || this.getAbv() > 10) {
      throw new IllegalArgumentException();
    }
  }    

  /** declare public constructor IndiaPaleAle.
   * 
   * @param name name
   */
  public IndiaPaleAle(String name) {
    super(name, BeerType.INDIA_PALE_ALE);
    this.ibu = ThreadLocalRandom.current().nextInt(40, 100);
    this.abv = ThreadLocalRandom.current().nextDouble(5, 10);

  }

}
