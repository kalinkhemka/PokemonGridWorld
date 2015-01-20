/*    */ //package pokebattleinterface;
/*    */ 
/*    */ import Pokemon.Pokemon;
/*    */ import java.awt.Window;
/*    */ import java.util.ArrayList;
/*    */ import org.jdesktop.application.Application;
/*    */ import org.jdesktop.application.SingleFrameApplication;
/*    */ 
/*    */ public class PokeBattleInterfaceApp extends SingleFrameApplication
/*    */ {
/*    */   private static Pokemon attacker;
/*    */   private static ArrayList<Pokemon> bag;
/*    */ 
/*    */   protected void startup()
/*    */   {
/* 22 */     show(new PokeBattleInterfaceView(this, bag, attacker));
/*    */   }
/*    */ 
/*    */   protected void configureWindow(Window root)
/*    */   {
/*    */   }
/*    */ 
/*    */   public static PokeBattleInterfaceApp getApplication()
/*    */   {
/* 38 */     return (PokeBattleInterfaceApp)Application.getInstance(PokeBattleInterfaceApp.class);
/*    */   }
/*    */ 
/*    */   public static void battle(ArrayList<Pokemon> b, Pokemon wildAgressor)
/*    */   {
/* 45 */     String[] args = null;
/* 46 */     launch(PokeBattleInterfaceApp.class, args);
/* 47 */     bag = b;
/* 48 */     attacker = wildAgressor;
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     pokebattleinterface.PokeBattleInterfaceApp
 * JD-Core Version:    0.6.0
 */