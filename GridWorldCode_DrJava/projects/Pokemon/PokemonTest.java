import info.gridworld.actor.*; 
import info.gridworld.grid.*; 
import java.awt.Color;
import java.util.*;


public class PokemonTest
{
  public static ActorWorld world = new ActorWorld(new BoundedGrid(50,50)); 
  public static void main(String[] args) 
  { 
    //Actor[] map= { new Accessory_Jagged_Boulder_Sprite(), new Dp_turnback_cave(), new Gsc_grass_k()
    //  , new Hgss_headbutt_k1(), new Hgss_headbutt_k2(), new Hgss_headbutt_k3(), new Hgss_headbutt_k4(), new HGSS_water_o(), new Pok�mon_Center_FRLG1(), new Pok�mon_Center_FRLG2()
    //  , new Pok�mon_Center_FRLG3(), new Pok�mon_Center_FRLG4(), new Pok�mon_Center_FRLG5(), new Pok�mon_Center_FRLG6(), new Pok�mon_Center_FRLG7(), new Pok�mon_Center_FRLG8(), new Pok�mon_Center_FRLG9()
    //  , new Pok�mon_Center_FRLG10(), new Pok�mon_Center_FRLG11(), new Pok�mon_Center_FRLG12(), new Pok�mon_Center_FRLG13(), new Pok�mon_Center_FRLG14(), new Pok�mon_Center_FRLG15(), new Pok�mon_Center_FRLG16()
    //  , new Pok�mon_Center_FRLG17(), new Pok�mon_Center_FRLG18(), new Pok�mon_Center_FRLG19(), new Pok�mon_Center_FRLG20(), new Rse_cavet(), new Rse_grass(), new Warp_tile_gen1()};
    
    final Actor[][] map= new map1().getMap();
    for(int i = 0;i<50;i++)
    {
      for(int f = 0;f<50;f++)
      {
        world.add(new Location(i,f),map[i][f]);
       
      }
      
    }
    
    
    
    world.show();
  }
}