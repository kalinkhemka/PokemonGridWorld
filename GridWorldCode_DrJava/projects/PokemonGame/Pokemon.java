import java.util.ArrayList;

public class Pokemon{
  
  protected String name, type;
  protected ArrayList <Attack> attacks;
  protected int level, maxHP, remainHP, attack, defense, speed, sattack, sdefense, exp, expNext; 
  protected int baseHP, baseAtk, baseDef, baseSAtk, baseSDef, baseSpd, baseEXP;
  protected double accuracy;
  protected boolean fainted;
  protected double [][] typeMult = 
   {{1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
    {2.0, 1.0, 0.5, 0.5, 1.0, 2.0, 0.5, 0.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2,0, 1.0},
    {1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0},
    {1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 2.0, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0},
    {1.0, 1.0, 0.0, 2.0, 1.0, 2.0, 0.5, 1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0},
    {1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0},
    {1.0, 0.5, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0},
    {0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0},
    {1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 0.5, 2.0, 1.0, 1.0, 2.0, 0.5},
    {1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5},
    {1.0, 1.0, 0.5, 0.5, 2.0, 2.0, 0.5, 1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5},
    {1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 0.5},
    {1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0},
    {1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 2.0},
    {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0}};
  
  public Pokemon (int baseHP, int baseAtk, int baseDef, int baseSAtk, int baseSDef, int baseSpd, int baseEXP, int l, String t){
    this.baseHP = baseHP;
    this.baseAtk = baseAtk;
    this.baseDef = baseDef;
    this.baseSAtk = baseSAtk;
    this.baseSDef = baseSDef;
    this.baseSpd = baseSpd;
    type = t;
    maxHP = (int)(((((2 * baseHP) + 121.25) * l) / 100) + 10);
    remainHP = maxHP;
    attack = (int)(((((2 * baseAtk) + 121.25) * l) / 100) + 5);
    defense = (int)(((((2 * baseDef) + 121.25) * l) / 100) + 5);
    sattack = (int)(((((2 * baseSAtk) + 121.25) * l) / 100) + 5);
    sdefense = (int)(((((2 * baseDef) + 121.25) * l) / 100) + 5);
    speed = (int)(((((2 * baseSpd) + 121.25) * l) / 100) + 5);
    exp = (int)((4*Math.pow(l, 2))/5);
    this.baseEXP = baseEXP;
    expNext = (int)((4*Math.pow(l+1, 2))/5);
    level = l;
    fainted = false;
  }
  
  public String getName (){
    return name;
  }
  public void setName(String nickname)
  {
    name = nickname;
  }
  
  public String getType (){
    return type;
  }
  
  public ArrayList <Attack> getAttacks (){
    return attacks;
  }
  
  public void setAttacks (ArrayList <Attack> atk){
    attacks = atk;
  }
  
  public double getAccuracy (){
    return accuracy;
  }
  
  public int getLevel (){
    return level;
  }
  
  public int getHPMax (){
    return maxHP;
  }
  
  public int getHPRemain (){
    return remainHP;
  }
  
  public int getAttack (){
    return attack;
  }
  
  public int getDefense (){
    return defense;
  }
  
  public int getSpeed (){
    return speed;
  }
  
  public int getSAttack (){
    return sattack;
  }
  
  public int getSDefense (){
    return sdefense;
  }
  
  public int getEXP (){
    return exp;
  }
  
  public int getBaseEXP (){//Returns the BaseEXP
    return baseEXP;
  }
  
  public int getEXPNext (){
    return expNext;
  }
  
  public void setEXPNext (){//Returns the amount of EXP total that is needed to level up.
    expNext = (int)((4*Math.pow(level + 1, 2))/5);
  }
  
  public int getNextEXPAmount (){//Returns just the amount needed to level fromm current to the next.
    return expNext - exp;
  }
  
  public int getEXPReceived (){//Returns the amount of exp that this pokemon gives when killed.
    return (int)((baseEXP * level)/7);
  }
  
  public void levelUp(){
    level++;
    maxHP = (int)(((((2 * baseHP) + 121.25) * level) / 100) + 10);
    remainHP = maxHP;
    attack = (int)(((((2 * baseAtk) + 121.25) * level) / 100) + 5);
    defense = (int)(((((2 * baseDef) + 121.25) * level) / 100) + 5);
    sattack = (int)(((((2 * baseSAtk) + 121.25) * level) / 100) + 5);
    sdefense = (int)(((((2 * baseDef) + 121.25) * level) / 100) + 5);
    speed = (int)(((((2 * baseSpd) + 121.25) * level) / 100) + 5);
    setEXPNext();
  }
  
  public void addEXP(Pokemon p){
    if (p.getEXPReceived() > getNextEXPAmount()){
      exp += p.getEXPReceived();
      while (expNext < exp){
        levelUp();
      }
    }
    else
      exp+= p.getEXPReceived();
  }
  
  public void decrementHP (int amount){
    remainHP -= amount;
    if (remainHP <= 0)
      fainted = true;
  }
  
  private int convertType (String type){
    if (type.equals ("normal"))
      return 0;
    if (type.equals ("fight"))
      return 1;
    if (type.equals ("flying"))
      return 2;
    if (type.equals ("poison"))
      return 3;
    if (type.equals ("ground"))
      return 4;
    if (type.equals ("rock"))
      return 5;
    if (type.equals ("bug"))
      return 6;
    if (type.equals ("ghost"))
      return 7;
    if (type.equals ("fire"))
      return 8;
    if (type.equals ("water"))
      return 9;
    if (type.equals ("grass"))
      return 10;
    if (type.equals ("electric"))
      return 11;
    if (type.equals ("psychic"))
      return 12;
    if (type.equals ("ice"))
      return 13;
    if (type.equals ("dragon"))
      return 14;
    else
      return 0;
  }
  
  private double getWeakness (Attack a, Pokemon p){
    String atype = a.getType ().toLowerCase ();    
    String ptype = p.getType ().toLowerCase ();
    int row = convertType (atype);
    int col = convertType (ptype);
    return typeMult [row][col];
  }
  
  public boolean HitMiss (Attack a){
    boolean hit = a.HitMiss (accuracy);
    if (hit)
      return true;
    else
      return false;
  }
  
  public int fight (Attack a, Pokemon p){
    double stab = 1;
    double weakness = getWeakness (a, p);
    int damage = 0;
    if (getType ().equals (a.getType ()))
      stab = 1.5;
    if (a.getSpecial())
       damage = (int)(((((2 * (double)level / 5 + 2) * (double)sattack * (double)a.getStrength () / (double)p.getSDefense ()) / 50) + 2) * (double)stab * (double)weakness * Math.random() / 100);
    else
      damage = (int)(((((2 * (double)level / 5 + 2) * (double)attack * (double)a.getStrength () / (double)p.getDefense ()) / 50) + 2) * (double)stab * (double)weakness * (double)Math.random() / 100);
    return damage;
  }
}