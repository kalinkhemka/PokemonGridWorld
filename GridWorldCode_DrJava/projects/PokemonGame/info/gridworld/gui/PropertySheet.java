/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import java.beans.PropertyEditor;
/*     */ import java.beans.PropertyEditorManager;
/*     */ import java.beans.PropertyEditorSupport;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
/*     */ import javax.swing.text.Document;
/*     */ 
/*     */ class PropertySheet extends JPanel
/*     */ {
/*     */   private PropertyEditor[] editors;
/*     */   private Object[] values;
/* 571 */   private static Map<Class, PropertyEditor> defaultEditors = new HashMap();
/*     */ 
/*     */   public PropertySheet(Class[] types, Object[] values)
/*     */   {
/* 434 */     this.values = values;
/* 435 */     this.editors = new PropertyEditor[types.length];
/* 436 */     setLayout(new FormLayout());
/* 437 */     for (int i = 0; i < values.length; i++)
/*     */     {
/* 439 */       JLabel label = new JLabel(types[i].getName());
/* 440 */       add(label);
/* 441 */       if (Grid.class.isAssignableFrom(types[i]))
/*     */       {
/* 443 */         label.setEnabled(false);
/* 444 */         add(new JPanel());
/*     */       }
/*     */       else
/*     */       {
/* 448 */         this.editors[i] = getEditor(types[i]);
/* 449 */         if (this.editors[i] != null)
/*     */         {
/* 451 */           this.editors[i].setValue(values[i]);
/* 452 */           add(getEditorComponent(this.editors[i]));
/*     */         }
/*     */         else {
/* 455 */           add(new JLabel("?"));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public PropertyEditor getEditor(Class type)
/*     */   {
/* 471 */     PropertyEditor editor = (PropertyEditor)defaultEditors.get(type);
/* 472 */     if (editor != null)
/* 473 */       return editor;
/* 474 */     editor = PropertyEditorManager.findEditor(type);
/* 475 */     return editor;
/*     */   }
/*     */ 
/*     */   public Component getEditorComponent(PropertyEditor editor)
/*     */   {
/* 486 */     String[] tags = editor.getTags();
/* 487 */     String text = editor.getAsText();
/* 488 */     if (editor.supportsCustomEditor())
/*     */     {
/* 490 */       return editor.getCustomEditor();
/*     */     }
/* 492 */     if (tags != null)
/*     */     {
/* 495 */       JComboBox comboBox = new JComboBox(tags);
/* 496 */       comboBox.setSelectedItem(text);
/* 497 */       comboBox.addItemListener(new ItemListener(editor, comboBox)
/*     */       {
/*     */         public void itemStateChanged(ItemEvent event)
/*     */         {
/* 501 */           if (event.getStateChange() == 1)
/* 502 */             this.val$editor.setAsText((String)this.val$comboBox.getSelectedItem());
/*     */         }
/*     */       });
/* 505 */       return comboBox;
/*     */     }
/*     */ 
/* 509 */     JTextField textField = new JTextField(text, 10);
/* 510 */     textField.getDocument().addDocumentListener(new DocumentListener(editor, textField)
/*     */     {
/*     */       public void insertUpdate(DocumentEvent e)
/*     */       {
/*     */         try
/*     */         {
/* 516 */           this.val$editor.setAsText(this.val$textField.getText());
/*     */         }
/*     */         catch (IllegalArgumentException exception)
/*     */         {
/*     */         }
/*     */       }
/*     */ 
/*     */       public void removeUpdate(DocumentEvent e)
/*     */       {
/*     */         try
/*     */         {
/* 527 */           this.val$editor.setAsText(this.val$textField.getText());
/*     */         }
/*     */         catch (IllegalArgumentException exception)
/*     */         {
/*     */         }
/*     */       }
/*     */ 
/*     */       public void changedUpdate(DocumentEvent e)
/*     */       {
/*     */       }
/*     */     });
/* 538 */     return textField;
/*     */   }
/*     */ 
/*     */   public Object[] getValues()
/*     */   {
/* 544 */     for (int i = 0; i < this.editors.length; i++)
/* 545 */       if (this.editors[i] != null)
/* 546 */         this.values[i] = this.editors[i].getValue();
/* 547 */     return this.values;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/* 572 */     defaultEditors.put(String.class, new StringEditor());
/* 573 */     defaultEditors.put(Location.class, new LocationEditor());
/* 574 */     defaultEditors.put(Color.class, new ColorEditor());
/*     */   }
/*     */ 
/*     */   public static class StringEditor extends PropertyEditorSupport
/*     */   {
/*     */     public String getAsText()
/*     */     {
/* 560 */       return (String)getValue();
/*     */     }
/*     */ 
/*     */     public void setAsText(String s)
/*     */     {
/* 565 */       setValue(s);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.PropertySheet
 * JD-Core Version:    0.6.0
 */