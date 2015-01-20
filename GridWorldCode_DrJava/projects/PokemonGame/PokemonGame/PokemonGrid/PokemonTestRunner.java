/*    */ package PokemonGrid;
/*    */ 
/*    */ import info.gridworld.actor.ActorWorld;
/*    */ import java.awt.KeyEventDispatcher;
/*    */ import java.awt.KeyboardFocusManager;
/*    */ import java.awt.event.KeyEvent;
/*    */ import javax.swing.KeyStroke;
/*    */ 
/*    */ public class PokemonTestRunner
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 10 */     PokemonGrid gr = new PokemonGrid();
/* 11 */     gr.fillWorld2();
/* 12 */     ActorWorld world = new ActorWorld(gr);
/* 13 */     world.show();
/*    */ 
/* 15 */     KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher(gr) {
/*    */       public boolean dispatchKeyEvent(KeyEvent event) {
/* 17 */         String key = KeyStroke.getKeyStrokeForEvent(event).toString();
/* 18 */         if (key.equals("pressed RIGHT"))
/* 19 */           this.val$gr.fillWorld2();
/* 20 */         if (key.equals("pressed LEFT"))
/* 21 */           this.val$gr.fillWorld1();
/* 22 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     PokemonGrid.PokemonTestRunner
 * JD-Core Version:    0.6.0
 */