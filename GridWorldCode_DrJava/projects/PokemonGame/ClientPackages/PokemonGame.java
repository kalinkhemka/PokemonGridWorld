package ClientPackages;

import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.Scanner;
import PokemonGame.*;
import info.gridworld.actor.ActorWorld;
/*    */ import info.gridworld.grid.Location;
/*    */ import java.awt.KeyEventDispatcher;
/*    */ import java.awt.KeyboardFocusManager;
/*    */ import java.awt.event.KeyEvent;
/*    */ import javax.swing.KeyStroke;

public class PokemonGame{
  /*System.out.println("Hi there! Welcome to the world of Pokemon. My name is Professor Araragi.");
   System.out.println("We live in the world inhabited by creatures known as Pokemon.");
   System.out.println("They have become our friends and we are always there for each other. And this is why I study Pokemon.");
     System.out.println();
     System.out.println("But that's quite enough about me, tell me about yourself.");
     System.out.println("What is your name?");
     name = sc.nextLine();*/
  
  private static Scanner sc = new Scanner(System.in);
  private static String name;
  public static Trainer trainer = new Trainer(name);
  
  public static void main(String[] args)
  {
    
    System.out.println("Hi there! Welcome to the world of Pokemon. My name is Professor Araragi.");
    System.out.println("We live in the world inhabited by creatures known as Pokemon.");
    System.out.println("They have become our friends and we are always there for each other. And this is why I study Pokemon.");
    System.out.println();
    System.out.println("But that's quite enough about me, tell me about yourself.");
    System.out.println("What is your name?");
    String name = sc.nextLine();
    
    //The code to allow user control of the Trainer
    java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new java.awt.KeyEventDispatcher(){
      public boolean dispatchKeyEvent(java.awt.event.KeyEvent event){
        String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
        if (key.equals( "pressed UP")){
          trainer.setDirection(0);
          if (trainer.canMove())
            trainer.move();
          trainer.directionSuffix = "up";
          trainer.setDirection(0);}
        if (key.equals("pressed RIGHT")){
          trainer.setDirection(90);
          if (trainer.canMove())
            trainer.move();
          trainer.directionSuffix = "right";
          trainer.setDirection(0);}
        if (key.equals("pressed DOWN")){
          trainer.setDirection(180);
          if (trainer.canMove())
            trainer.move();
          trainer.directionSuffix = "down";
          trainer.setDirection(0);}
        if (key.equals("pressed LEFT")){
          trainer.setDirection(270);
          if (trainer.canMove())
            trainer.move();
          trainer.directionSuffix = "left";
          trainer.setDirection(0);} 
        return true;        
      }     
    }
    );//End of the User Control Code
    
    Location startLoc = new Location (6,10);
    PokemonGrid gr = new PokemonGrid(); 
    gr.fillWorld1();
    ActorWorld world = new ActorWorld((Grid) gr);
    trainer.getOldActor(gr, startLoc);
    trainer.putSelfInGrid(gr, startLoc);
    world.show();
  }
}