import info.gridworld.actor.*; 
import info.gridworld.grid.*; 
import java.awt.Color;
import java.util.*;


public class PokemonGame
{ 
  
  public static ActorWorld world = new ActorWorld(new BoundedGrid(9, 9)); 
  public static int xstart=32, ystart=21; //xstart and ystart are switched...lol
  public static boolean boy = false;
  public static int xstart2=0, ystart2=0;
  public static int mapNum = 1;
  public static Pokemon[] yours = {new Pokemon("Pikachuuuu!",7800,1), new Pokemon("Pidgey!", 6700,2)};
    public static Pokemon[] his = {new Pokemon("ONIX",6900,3),new Pokemon("Geodude",6000,4)};
    public static Pokemon[] wild1 = {new Pokemon("Caterpie",5600,5)};
    public static Pokemon[] wild2 = {new Pokemon("Ratata",5600,6)};
  public static void main(String[] args) 
   
  { 
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to Francisco's Pokemon  Adventure Game, which emulates some of the Pokemon Games. I assume you know how to play Pokemon, if you don't then please read introductory stuff on Pokemon online.\n\nAre you A Boy[1] or a Girl[2]?");
    if (sc.nextInt()==1)
    {
      boy = true;
    }

//Actor[] map= { new Accessory_Jagged_Boulder_Sprite(), new Dp_turnback_cave(), new Gsc_grass_k()
    //  , new Hgss_headbutt_k1(), new Hgss_headbutt_k2(), new Hgss_headbutt_k3(), new Hgss_headbutt_k4(), new HGSS_water_o(), new Pokémon_Center_FRLG1(), new Pokémon_Center_FRLG2()
    //  , new Pokémon_Center_FRLG3(), new Pokémon_Center_FRLG4(), new Pokémon_Center_FRLG5(), new Pokémon_Center_FRLG6(), new Pokémon_Center_FRLG7(), new Pokémon_Center_FRLG8(), new Pokémon_Center_FRLG9()
    //  , new Pokémon_Center_FRLG10(), new Pokémon_Center_FRLG11(), new Pokémon_Center_FRLG12(), new Pokémon_Center_FRLG13(), new Pokémon_Center_FRLG14(), new Pokémon_Center_FRLG15(), new Pokémon_Center_FRLG16()
    //  , new Pokémon_Center_FRLG17(), new Pokémon_Center_FRLG18(), new Pokémon_Center_FRLG19(), new Pokémon_Center_FRLG20(), new Rse_cavet(), new Rse_grass(), new Warp_tile_gen1()};
    int xpos=0,ypos=0;
    
    final Actor[][] map= new map1().getMap();
    for(int i = xstart;i<xstart+9;i++)
    {
      for(int f = ystart;f<ystart+9;f++)
      {
        world.add(new Location(xpos,ypos),map[i][f]);
        ypos++;
      }
      ypos=0;
      xpos++;
    }
    if(boy)
    {
      world.add(new Location(4,4), new boy3());
    }
    else
    {
      world.add(new Location(4,4), new girl3());
    }
    world.show();
//    try 
//    {
//      Thread.sleep(5000);//pauses to make periods come out in style...
//    } 
//    catch (InterruptedException ex) 
//    {
//      System.out.println("Error! :(");
//    }
    java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher()
                                                                                           { 
      public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) 
      {
        int xpos=0,ypos=0;
        
        String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString(); 
        if (key.equals("pressed UP")||key.equals("pressed W")) 
        {
          if (mapNum==1)
          {
            
            //System.out.println(xstart+""+ystart);
            if((xstart!=11||ystart!=14)&&(xstart!=21||ystart!=26)&&(xstart!=29||ystart!=18)&&(xstart!=10||(ystart!=32&&ystart!=6&&ystart!=7&&ystart!=9&&ystart!=10))&&(xstart!=5||(xstart==5&&ystart==16))&&(xstart!=11||ystart!=33)&&(xstart!=12||(ystart!=34&&ystart!=35&&ystart!=36))&&(xstart!=11||(ystart!=27&&ystart!=26&&ystart!=24))&&(xstart!=29||(ystart!=27&&ystart!=29&&ystart!=30))&&(xstart!=27||(ystart!=18&&ystart!=17&&ystart!=15&&ystart!=14&&ystart!=13)))
            {
              xstart--;
            }
            
            
            
            for(int i = xstart;i<xstart+9;i++)
            {
              for(int f = ystart;f<ystart+9;f++)
              {
                Grid<Actor> gr = map[i][f].getGrid();
                if(gr!=null)
                {
                  map[i][f].removeSelfFromGrid();
                }
                world.add(new Location(xpos,ypos),map[i][f]);
                ypos++;
              }
              ypos=0;
              xpos++;
            }
            if(boy)
            {
              world.add(new Location(4,4), new boy3());
            }
            else
            {
              world.add(new Location(4,4), new girl3());
            }
            world.show();
            
            if(xstart==29&&ystart==18)
            {
              Battle bat = new Battle(yours,his);
              bat.Start();
            }
          }
          else
          {
          }
        }
        if (key.equals("pressed RIGHT")||key.equals("pressed D")) 
        {
          if(mapNum==1)
          {
            if((xstart!=10||ystart!=13)&&(xstart!=20||ystart!=25)&&(xstart!=28||ystart!=17)&&(ystart!=36)&&(ystart!=5||(xstart!=6&&xstart!=7&&xstart!=8&&xstart!=9))&&(ystart!=31||(xstart!=9&&xstart!=8&&xstart!=7&&xstart!=6&&xstart!=5))&&(ystart!=32||xstart!=10)&&(ystart!=33||xstart!=11)&&(ystart!=12||(xstart!=22&&xstart!=23&&xstart!=24&&xstart!=25&&xstart!=26))&&(ystart!=26||(xstart!=25&&xstart!=26&&xstart!=27&&xstart!=28))&&(ystart!=23||(xstart!=10&&xstart!=9&&xstart!=8&&xstart!=7)))
            {
              ystart++;
            }
            for(int i = xstart;i<xstart+9;i++)
            {
              for(int f = ystart;f<ystart+9;f++)
              {
                Grid<Actor> gr = map[i][f].getGrid();
                if(gr!=null)
                {
                  map[i][f].removeSelfFromGrid();
                }
                world.add(new Location(xpos,ypos),map[i][f]);
                ypos++;
              }
              ypos=0;
              xpos++;
            }
            if(boy)
            {
              world.add(new Location(4,4), new boy4());
            }
            else
            {
              world.add(new Location(4,4), new girl4());
            } 
            world.show();
            if(xstart==29&&ystart==18)
            {
              Battle bat = new Battle(yours,his);
              bat.Start();
            }
          }
          else
          {
          }
        }
        if (key.equals("pressed DOWN")||key.equals("pressed S")) 
        {
          if(mapNum==1)
          {
            if((xstart!=9||ystart!=14)&&(xstart!=19||ystart!=26)&&(xstart!=27||ystart!=18)&&(xstart!=36)&&(xstart!=5||(ystart!=6&&ystart!=7&&ystart!=8&&ystart!=9&&ystart!=10))&&(xstart!=6||(ystart!=27&&ystart!=26&&ystart!=25&&ystart!=24))&&(xstart!=24||(ystart!=27&&ystart!=28&&ystart!=29&&ystart!=30))&&(xstart!=21||(ystart!=18&&ystart!=17&&ystart!=16&&ystart!=15&&ystart!=14&&ystart!=13)))
            {
              xstart++;
            }
            for(int i = xstart;i<xstart+9;i++)
            {
              for(int f = ystart;f<ystart+9;f++)
              {
                Grid<Actor> gr = map[i][f].getGrid();
                if(gr!=null)
                {
                  map[i][f].removeSelfFromGrid();
                }
                world.add(new Location(xpos,ypos),map[i][f]);
                ypos++;
              }
              ypos=0;
              xpos++;
            }
            if(boy)
            {
              world.add(new Location(4,4), new boy1());
            }
            else
            {
              world.add(new Location(4,4), new girl1());
            }
            world.show();
            if(xstart==29&&ystart==18)
            {
              Battle bat = new Battle(yours,his);
              bat.Start();
            }
          }
          else
          {
            
          }
        }
        if (key.equals("pressed LEFT")||key.equals("pressed A")) 
        {
          if(mapNum==1)
          {
            if((xstart!=10||ystart!=15)&&(xstart!=20||ystart!=27)&&(xstart!=28||ystart!=19)&&(ystart!=5)&&(ystart!=11||(xstart!=6&&xstart!=7&&xstart!=8&&xstart!=9))&&(ystart!=19||(xstart!=22&&xstart!=23&&xstart!=24&&xstart!=25&&xstart!=26))&&(ystart!=31||(xstart!=25&&xstart!=26&&xstart!=27&&xstart!=28))&&(ystart!=28||(xstart!=10&&xstart!=9&&xstart!=8&&xstart!=7)))
            {
              ystart--;
            }
            for(int i = xstart;i<xstart+9;i++)
            {
              for(int f = ystart;f<ystart+9;f++)
              {
                Grid<Actor> gr = map[i][f].getGrid();
                if(gr!=null)
                {
                  map[i][f].removeSelfFromGrid();
                }
                world.add(new Location(xpos,ypos),map[i][f]);
                ypos++;
              }
              ypos=0;
              xpos++;
            }
            if(boy)
            {
              world.add(new Location(4,4), new boy2());
            }
            else
            {
              world.add(new Location(4,4), new girl2());
            }
            world.show();
            if(xstart==29&&ystart==18)
            {
              Battle bat = new Battle(yours,his);
              bat.Start();
            }
          }
          else
          {
          }
        }
        if (key.equals("pressed B")) 
        {
          Battle bat = new Battle(yours,wild1);
              bat.Start();
        }
        if (key.equals("pressed C")) 
        {
          Battle bat = new Battle(yours,wild2);
              bat.Start();
        }
        return true; 
      }         
    });
  } 
}
