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
    //  , new Hgss_headbutt_k1(), new Hgss_headbutt_k2(), new Hgss_headbutt_k3(), new Hgss_headbutt_k4(), new HGSS_water_o(), new Pokémon_Center_FRLG1(), new Pokémon_Center_FRLG2()
    //  , new Pokémon_Center_FRLG3(), new Pokémon_Center_FRLG4(), new Pokémon_Center_FRLG5(), new Pokémon_Center_FRLG6(), new Pokémon_Center_FRLG7(), new Pokémon_Center_FRLG8(), new Pokémon_Center_FRLG9()
    //  , new Pokémon_Center_FRLG10(), new Pokémon_Center_FRLG11(), new Pokémon_Center_FRLG12(), new Pokémon_Center_FRLG13(), new Pokémon_Center_FRLG14(), new Pokémon_Center_FRLG15(), new Pokémon_Center_FRLG16()
    //  , new Pokémon_Center_FRLG17(), new Pokémon_Center_FRLG18(), new Pokémon_Center_FRLG19(), new Pokémon_Center_FRLG20(), new Rse_cavet(), new Rse_grass(), new Warp_tile_gen1()};
    
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