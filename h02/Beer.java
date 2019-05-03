/**
 * 
 */

package edu.ics211.h02;

/**
 * Beer class.
 * @author Caleb Cheshire
 *     partnered with Justin Chen and Tristan Yousuf-Leo
 */
public abstract class Beer implements Comparable<Beer> {
  private String name;
  private BeerType type;
  protected Integer ibu;
  protected Double abv;

  /**
   * Creates a new beer.
   * @param name the name of the new beer
   * @param type the type of the new beer
   */
  public Beer(String name, BeerType type) {
    this.name = name;
    this.type = type;
  }

  /**
   * Creates a new beer.
   * @param name the name of the new beer
   * @param type the type of the new beer
   * @param ibu the IBU of the new beer
   * @param abv the ABV of the new beer
   */
  public Beer(String name, BeerType type, Integer ibu, Double abv) {
    this.name = name;
    this.type = type;
    this.ibu = ibu;
    this.abv = abv;
  }

  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(Beer beer) {
    this.name.compareTo(beer.getName());
    return 0;
  }

  /**
   * declare getName method.
   * @return name
   */
  public String getName() {
    return name;
  }

  /** declare setName method.
   * @param name name
   * @return this.name
   */
  public String setName(String name) {
    return this.name = name;
  }

  /** declare BeerType getType method.
   * @return type
   */
  public BeerType getType() {
    return type;
  }

  /** declare Integer getIbu.
   * @return ibu
   */
  public Integer getIbu() {
    return ibu;
  }

  /** declare Double getAbv.
   * @return abv
   */
  public Double getAbv() {
    return abv;
  }
}


