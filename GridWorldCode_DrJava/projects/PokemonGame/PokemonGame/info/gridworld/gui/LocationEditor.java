/*    */ package info.gridworld.gui;
/*    */ 
/*    */ import info.gridworld.grid.Location;
/*    */ import java.awt.Component;
/*    */ import java.beans.PropertyEditorSupport;
/*    */ import java.text.NumberFormat;
/*    */ import javax.swing.JFormattedTextField;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class LocationEditor extends PropertyEditorSupport
/*    */ {
/* 35 */   private JFormattedTextField rowField = new JFormattedTextField(NumberFormat.getIntegerInstance());
/*    */ 
/* 37 */   private JFormattedTextField colField = new JFormattedTextField(NumberFormat.getIntegerInstance());
/*    */ 
/* 39 */   private JPanel panel = new JPanel();
/*    */ 
/*    */   public LocationEditor()
/*    */   {
/* 43 */     this.rowField.setColumns(5);
/* 44 */     this.colField.setColumns(5);
/*    */ 
/* 46 */     this.panel.add(this.rowField);
/* 47 */     this.panel.add(this.colField);
/*    */   }
/*    */ 
/*    */   public Object getValue()
/*    */   {
/* 52 */     int row = ((Number)this.rowField.getValue()).intValue();
/* 53 */     int col = ((Number)this.colField.getValue()).intValue();
/* 54 */     return new Location(row, col);
/*    */   }
/*    */ 
/*    */   public void setValue(Object newValue)
/*    */   {
/* 59 */     Location loc = (Location)newValue;
/* 60 */     this.rowField.setValue(new Integer(loc.getRow()));
/* 61 */     this.colField.setValue(new Integer(loc.getCol()));
/*    */   }
/*    */ 
/*    */   public boolean supportsCustomEditor()
/*    */   {
/* 66 */     return true;
/*    */   }
/*    */ 
/*    */   public Component getCustomEditor()
/*    */   {
/* 71 */     return this.panel;
/*    */   }
/*    */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.LocationEditor
 * JD-Core Version:    0.6.0
 */