/**
 * 
 */

package edu.ics211.h02;

import java.lang.IllegalArgumentException;
import java.util.concurrent.ThreadLocalRandom;


/** declare class Pilsner.
 * @author caleb
 *     partnered with Justin Chen and Tristan Yousuf-Leo
 *
 */
public class Pilsner extends Beer {

  //private static final Exception IOException = null;

  /** declare constructor Pilsner.
   * 
   * @param name name
   * @param ibu ibu
   * @param abv abv
   */
  public Pilsner(String name, Integer ibu, Double abv) {
    super(name, BeerType.PILSNER, ibu, abv);
    if (this.getIbu() < 25 || this.getIbu() > 45) {
      throw new IllegalArgumentException();
    }
    if (this.getAbv() < 4.2 || this.getAbv() > 6.0) {
      throw new IllegalArgumentException();
    }
  }    

  /** declare constructor Pilsner.
   * 
   * @param name name
   */
  public Pilsner(String name) {
    super(name, BeerType.PILSNER);
    this.ibu = ThreadLocalRandom.current().nextInt(25, 45);
    this.abv = ThreadLocalRandom.current().nextDouble(4.2, 6.0);

  }

  protected Pilsner(String name, BeerType type, Integer ibu, Double abv) {
    super(name, type, ibu, abv);

  }

  protected Pilsner(String name, BeerType type) {
    super(name, type);

  }
}
