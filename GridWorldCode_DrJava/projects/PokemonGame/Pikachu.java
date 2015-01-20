import java.util.ArrayList;

public class Pikachu extends Pokemon{
 
  public Pikachu(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(35, 55, 30, 50, 40, 90, 105, level, "electric");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new ChargeBeam());
    atks.add(new Thunder());
    atks.add(new FocusBlast());
    atks.add(new QuickAttack());
    setAttacks(atks);
    setName("Pikachu");
  }
}