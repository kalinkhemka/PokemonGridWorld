public class Attack{
  
  private String name, type;
  private int strength;
  private double accuracy;
  private boolean sp;
  
  public Attack (String n, String t, double a, int s, boolean special){
    name = n;
    accuracy = a;
    strength = s;
    type = t;
    sp = special;
  }
  
  public String getName (){
    return name;
  }
  
  public double getAccuray (){
    return accuracy;
  }
  
  public int getStrength (){
    return strength;
  }
  
  public String getType (){
    return type;
  }
  
  public boolean getSpecial (){
    return sp;
  }
  
  public boolean HitMiss (double acc){
    double prob = acc * accuracy;
    if (Math.random () <= prob)
      return true;
    else
      return false;
  }
}