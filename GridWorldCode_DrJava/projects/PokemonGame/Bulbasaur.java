import java.util.ArrayList;

public class Bulbasaur extends Pokemon{
 
  public Bulbasaur(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(45, 49, 49, 65, 65, 45, 64, level, "grass");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Tackle());
    atks.add(new VineWhip());
    atks.add(new RazorLeaf());
    atks.add(new Sludge());
    setAttacks(atks);
    setName("Bulbasaur");
  }
}