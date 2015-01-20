import java.util.ArrayList;

public class Venusaur extends Pokemon{
 
  public Venusaur(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(80, 82, 83, 100, 100, 80, 236, level, "grass");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Earthquake());
    atks.add(new PetalDance());
    atks.add(new LeafStorm());
    atks.add(new FrenzyPlant());
    setAttacks(atks);
    setName("Venusaur");
  }
}