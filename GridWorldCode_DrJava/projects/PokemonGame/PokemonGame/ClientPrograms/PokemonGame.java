/*    */ package ClientPrograms;
/*    */ 
/*    */ import PokemonGrid.PokemonGrid;
/*    */ import Trainer.Trainer;
/*    */ import info.gridworld.actor.ActorWorld;
/*    */ import info.gridworld.grid.Location;
/*    */ import java.awt.KeyEventDispatcher;
/*    */ import java.awt.KeyboardFocusManager;
/*    */ import java.awt.event.KeyEvent;
/*    */ import javax.swing.KeyStroke;
/*    */ 
/*    */ public class PokemonGame
/*    */ {
/* 15 */   public static Trainer trainer = new Trainer("name");
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 20 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
/*    */       public boolean dispatchKeyEvent(KeyEvent event) {
/* 22 */         String key = KeyStroke.getKeyStrokeForEvent(event).toString();
/* 23 */         if (key.equals("pressed UP")) {
/* 24 */           PokemonGame.trainer.setDirection(0);
/* 25 */           if (PokemonGame.trainer.canMove())
/* 26 */             PokemonGame.trainer.move();
/* 27 */           PokemonGame.trainer.ChangeDirectionSuffix("up");
/* 28 */           PokemonGame.trainer.setDirection(0);
/* 29 */         }if (key.equals("pressed RIGHT")) {
/* 30 */           PokemonGame.trainer.setDirection(90);
/* 31 */           if (PokemonGame.trainer.canMove())
/* 32 */             PokemonGame.trainer.move();
/* 33 */           PokemonGame.trainer.ChangeDirectionSuffix("right");
/* 34 */           PokemonGame.trainer.setDirection(0);
/* 35 */         }if (key.equals("pressed DOWN")) {
/* 36 */           PokemonGame.trainer.setDirection(180);
/* 37 */           if (PokemonGame.trainer.canMove())
/* 38 */             PokemonGame.trainer.move();
/* 39 */           PokemonGame.trainer.ChangeDirectionSuffix("down");
/* 40 */           PokemonGame.trainer.setDirection(0);
/* 41 */         }if (key.equals("pressed LEFT")) {
/* 42 */           PokemonGame.trainer.setDirection(270);
/* 43 */           if (PokemonGame.trainer.canMove())
/* 44 */             PokemonGame.trainer.move();
/* 45 */           PokemonGame.trainer.ChangeDirectionSuffix("left");
/* 46 */           PokemonGame.trainer.setDirection(0);
/* 47 */         }return true;
/*    */       }
/*    */     });
/* 51 */     Location startLoc = new Location(6, 10);
/* 52 */     PokemonGrid gr = new PokemonGrid();
/* 53 */     gr.fillWorld1();
/* 54 */     ActorWorld world = new ActorWorld(gr);
/* 55 */     trainer.getOldActor(gr, startLoc);
/* 56 */     trainer.putSelfInGrid(gr, startLoc);
/* 57 */     world.show();
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     ClientPrograms.PokemonGame
 * JD-Core Version:    0.6.0
 */