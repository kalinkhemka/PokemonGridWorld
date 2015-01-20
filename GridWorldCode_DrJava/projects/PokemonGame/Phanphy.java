import java.util.ArrayList;

public class Phanphy extends Pokemon{
 
  public Phanphy(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(90, 60, 60, 40, 40, 40, 66, level, "ground");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Rollout());
    atks.add(new TakeDown());
    atks.add(new RockTomb());
    atks.add(new Bulldoze());
    setAttacks(atks);
    setName("Phanphy");
  }
}