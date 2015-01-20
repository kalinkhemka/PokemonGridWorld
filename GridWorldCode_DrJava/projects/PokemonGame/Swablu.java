import java.util.ArrayList;

public class Swablu extends Pokemon{
 
  public Swablu(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(45, 40, 60, 40, 75, 50, 62, level, "flying");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Peck());
    atks.add(new Astonish());
    atks.add(new IceBeam());
    atks.add(new Bounce());
    setAttacks(atks);
    setName("Swablu");
  }
}