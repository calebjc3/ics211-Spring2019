/**
 * 
 */

package edu.ics211.h02;

/**
 * Represents a ManoaBrewing.
 * @author caleb
 *      partnered with Justin Chen and Tristan Yousuf-Leo
 *
 */
public class ManoaBrewing implements IBrewery {
  private static ManoaBrewing instance;

  /** declare private constructor ManoaBrewing.
   * 
   */
  private ManoaBrewing() {}
  // TODO Auto-generated constructor stub

  /** declare public static constructor ManoaBrewing getInstance.
   * 
   * @return instance
   */
  public static ManoaBrewing getInstance() {
    if (instance == null) {
      instance = new ManoaBrewing();
    }
    return instance;
  }

  @Override
  public Beer brewBeer(String name, BeerType type) {
    Beer beer;
    switch (type) {
      case PILSNER:
        beer = new Pilsner(name);
        break;
      case BOHEMIAN_PILSNER:
        beer = new BohemianPilsner(name);
        break;
      case INDIA_PALE_ALE:
        beer = new IndiaPaleAle(name);
        break;
      default:
        throw new IllegalArgumentException("Invalid type");
    }
    return beer;
  }

  @Override
  public Beer brewPilsner(String name, Integer ibu, Double abv) {
    Pilsner brewPilsner = new Pilsner(name, ibu, abv);
    return brewPilsner;
  }

  @Override
  public Beer brewBohemianPilsner(String name, Integer ibu, Double abv) {
    BohemianPilsner brewBohemianPilsner = new BohemianPilsner(name, ibu, abv);
    return brewBohemianPilsner;
  }

  @Override
  public Beer brewIndiaPaleAle(String name, Integer ibu, Double abv) {
    IndiaPaleAle brewIndiaPaleAle = new IndiaPaleAle(name, ibu, abv);
    return brewIndiaPaleAle;
  }

}
