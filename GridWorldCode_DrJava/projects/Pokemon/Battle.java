import java.util.*;
public class Battle
{
  int choice;
  Pokemon[] you;
  Move[] ymoves;
  Pokemon[] opp;
  Move[] omoves;
  int numOuty=0, numOuto=0;
  boolean win = false;
  
  public Battle(Pokemon[] atker, Pokemon[] oppon)
  {
    
    numOuty=0;
    numOuto=0;
    win = false;
    you = atker;
    opp = oppon;
    ymoves = atker[0].getmoves();
    omoves = oppon[0].getmoves();
  }
  public void Start()
  {
    System.out.println("You were Attacked by a "+opp[numOuto]);
    Scanner sc = new Scanner(System.in);
    while(win==false)
    {
      System.out.println("Choose your move: "+ymoves[0]+" "+ymoves[1]+" "+ymoves[2]);
      
      choice = sc.nextInt();
      
      while(choice>2||choice<0)
      {
        choice = sc.nextInt();
      }
      opp[numOuto].damage(you[numOuty].attack(opp[numOuto].getDef(),choice));
      
      if(opp[numOuto].dead())
      {
        you[numOuty].addExp(756);
        if(opp.length==numOuto+1)
        {
          win = true;
          System.out.println("You Win!");
        }
        else
        {
          numOuto++;
          System.out.println("Opponent sends out next pokemon, "+opp[numOuto]);
        }
      }
      if(!win==true)
      {
        //System.out.println(opp[numOuto].attack(you[numOuty].getDef(),choice));
        you[numOuty].damage(opp[numOuto].attack(you[numOuty].getDef(),choice));
        if(you[numOuty].dead())
        {
          if(you.length==numOuty+1)
          {
            win=true;
            System.out.println("You Lost!");
          }
          else
          {
            numOuto++;
            System.out.println("You send out next pokemon, "+opp[numOuto]);
          }
        }
      }
    }
    
  }
}