import java.util.ArrayList;

public class Hitmontop extends Pokemon{
 
  public Hitmontop(int level){
    //super(BASEHP, BASEATK, BASEDEF, BASESATK, BASESDEF, BASESPD, BASEEXP, level);
    super(50, 95, 95, 35, 110, 70, 159, level, "fighting");
    ArrayList<Attack> atks = new ArrayList<Attack>();
    atks.add(new Revenge());
    atks.add(new CloseCombat());
    atks.add(new HiJumpKick());
    atks.add(new MachPunch());
    setAttacks(atks);
    setName("Hitmontio");
  }
}