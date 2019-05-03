/**
 * 
 */

package edu.ics211.h02;

import java.util.concurrent.ThreadLocalRandom;

/** declare class Bohemian Pilsner.
 * @author caleb
 *
 */
public class BohemianPilsner extends Pilsner {

  /** declare constructor BohemianPilsner.
   * @param name name
   * @param ibu ibu 
   * @param abv abv
   */
  public BohemianPilsner(String name, Integer ibu, Double abv) {
    super(name, BeerType.BOHEMIAN_PILSNER, ibu, abv);
    if (this.getIbu() < 35 || this.getIbu() > 45) {
      throw new IllegalArgumentException();
    }
    if (this.getAbv() < 4.2 || this.getAbv() > 5.4) {
      throw new IllegalArgumentException();
    }
  }    

  /** declare constructor Bohemian Pilsner.
   * 
   * @param name name
   */
  public BohemianPilsner(String name) {
    super(name, BeerType.BOHEMIAN_PILSNER);
    this.ibu = ThreadLocalRandom.current().nextInt(35, 45);
    this.abv = ThreadLocalRandom.current().nextDouble(4.2, 5.4);

  }

}

