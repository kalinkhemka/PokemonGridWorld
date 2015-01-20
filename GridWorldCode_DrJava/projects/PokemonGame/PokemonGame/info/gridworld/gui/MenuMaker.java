/*     */ package info.gridworld.gui;
/*     */ 
/*     */ import info.gridworld.grid.Grid;
/*     */ import info.gridworld.grid.Location;
/*     */ import info.gridworld.world.World;
/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.ResourceBundle;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class MenuMaker<T>
/*     */ {
/*     */   private T occupant;
/*     */   private Grid currentGrid;
/*     */   private Location currentLocation;
/*     */   private WorldFrame<T> parent;
/*     */   private DisplayMap displayMap;
/*     */   private ResourceBundle resources;
/*     */ 
/*     */   public MenuMaker(WorldFrame<T> parent, ResourceBundle resources, DisplayMap displayMap)
/*     */   {
/*  72 */     this.parent = parent;
/*  73 */     this.resources = resources;
/*  74 */     this.displayMap = displayMap;
/*     */   }
/*     */ 
/*     */   public JPopupMenu makeMethodMenu(T occupant, Location loc)
/*     */   {
/*  85 */     this.occupant = occupant;
/*  86 */     this.currentLocation = loc;
/*  87 */     JPopupMenu menu = new JPopupMenu();
/*  88 */     Method[] methods = getMethods();
/*  89 */     Class oldDcl = null;
/*  90 */     for (int i = 0; i < methods.length; i++)
/*     */     {
/*  92 */       Class dcl = methods[i].getDeclaringClass();
/*  93 */       if (dcl != Object.class)
/*     */       {
/*  95 */         if ((i > 0) && (dcl != oldDcl))
/*  96 */           menu.addSeparator();
/*  97 */         menu.add(new MethodItem(methods[i]));
/*     */       }
/*  99 */       oldDcl = dcl;
/*     */     }
/* 101 */     return menu;
/*     */   }
/*     */ 
/*     */   public JPopupMenu makeConstructorMenu(Collection<Class> classes, Location loc)
/*     */   {
/* 114 */     this.currentLocation = loc;
/* 115 */     JPopupMenu menu = new JPopupMenu();
/* 116 */     boolean first = true;
/* 117 */     Iterator iter = classes.iterator();
/* 118 */     while (iter.hasNext())
/*     */     {
/* 120 */       if (first)
/* 121 */         first = false;
/*     */       else
/* 123 */         menu.addSeparator();
/* 124 */       Class cl = (Class)iter.next();
/* 125 */       Constructor[] cons = (Constructor[])cl.getConstructors();
/* 126 */       for (int i = 0; i < cons.length; i++)
/*     */       {
/* 128 */         menu.add(new OccupantConstructorItem(cons[i]));
/*     */       }
/*     */     }
/* 131 */     return menu;
/*     */   }
/*     */ 
/*     */   public void addConstructors(JMenu menu, Collection<Class> classes)
/*     */   {
/* 142 */     boolean first = true;
/* 143 */     Iterator iter = classes.iterator();
/* 144 */     while (iter.hasNext())
/*     */     {
/* 146 */       if (first)
/* 147 */         first = false;
/*     */       else
/* 149 */         menu.addSeparator();
/* 150 */       Class cl = (Class)iter.next();
/* 151 */       Constructor[] cons = cl.getConstructors();
/* 152 */       for (int i = 0; i < cons.length; i++)
/*     */       {
/* 154 */         menu.add(new GridConstructorItem(cons[i]));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method[] getMethods()
/*     */   {
/* 161 */     Class cl = this.occupant.getClass();
/* 162 */     Method[] methods = cl.getMethods();
/*     */ 
/* 164 */     Arrays.sort(methods, new Comparator()
/*     */     {
/*     */       public int compare(Method m1, Method m2)
/*     */       {
/* 168 */         int d1 = depth(m1.getDeclaringClass());
/* 169 */         int d2 = depth(m2.getDeclaringClass());
/* 170 */         if (d1 != d2)
/* 171 */           return d2 - d1;
/* 172 */         int d = m1.getName().compareTo(m2.getName());
/* 173 */         if (d != 0)
/* 174 */           return d;
/* 175 */         d1 = m1.getParameterTypes().length;
/* 176 */         d2 = m2.getParameterTypes().length;
/* 177 */         return d1 - d2;
/*     */       }
/*     */ 
/*     */       private int depth(Class cl)
/*     */       {
/* 182 */         if (cl == null) {
/* 183 */           return 0;
/*     */         }
/* 185 */         return 1 + depth(cl.getSuperclass());
/*     */       }
/*     */     });
/* 188 */     return methods;
/*     */   }
/*     */ 
/*     */   private class MethodItem extends MenuMaker.MCItem
/*     */     implements ActionListener
/*     */   {
/*     */     private Method m;
/*     */ 
/*     */     public MethodItem(Method m)
/*     */     {
/* 351 */       super(null);
/* 352 */       setText(getDisplayString(m.getReturnType(), m.getName(), m.getParameterTypes()));
/*     */ 
/* 354 */       this.m = m;
/* 355 */       addActionListener(this);
/* 356 */       setIcon(MenuMaker.this.displayMap.getIcon(m.getDeclaringClass(), 16, 16));
/*     */     }
/*     */ 
/*     */     public void actionPerformed(ActionEvent event)
/*     */     {
/* 361 */       Class[] types = this.m.getParameterTypes();
/* 362 */       Object[] values = new Object[types.length];
/*     */ 
/* 364 */       for (int i = 0; i < types.length; i++)
/*     */       {
/* 366 */         values[i] = makeDefaultValue(types[i]);
/*     */       }
/*     */ 
/* 369 */       if (types.length > 0)
/*     */       {
/* 371 */         PropertySheet sheet = new PropertySheet(types, values);
/* 372 */         JOptionPane.showMessageDialog(this, sheet, MenuMaker.this.resources.getString("dialog.method.params"), 3);
/*     */ 
/* 375 */         values = sheet.getValues();
/*     */       }
/*     */ 
/*     */       try
/*     */       {
/* 380 */         Object result = this.m.invoke(MenuMaker.this.occupant, values);
/* 381 */         MenuMaker.this.parent.repaint();
/* 382 */         if (this.m.getReturnType() != Void.TYPE)
/*     */         {
/* 384 */           String resultString = result.toString();
/*     */ 
/* 386 */           int MAX_LENGTH = 50;
/* 387 */           int MAX_HEIGHT = 10;
/*     */           Object resultObject;
/*     */           Object resultObject;
/* 388 */           if (resultString.length() < 50) {
/* 389 */             resultObject = resultString;
/*     */           }
/*     */           else {
/* 392 */             int rows = Math.min(10, 1 + resultString.length() / 50);
/*     */ 
/* 394 */             JTextArea pane = new JTextArea(rows, 50);
/* 395 */             pane.setText(resultString);
/* 396 */             pane.setLineWrap(true);
/* 397 */             resultObject = new JScrollPane(pane);
/*     */           }
/* 399 */           JOptionPane.showMessageDialog(MenuMaker.this.parent, resultObject, MenuMaker.this.resources.getString("dialog.method.return"), 1);
/*     */         }
/*     */       }
/*     */       catch (InvocationTargetException ex)
/*     */       {
/*     */         WorldFrame tmp250_247 = MenuMaker.this.parent; tmp250_247.getClass(); new WorldFrame.GUIExceptionHandler(tmp250_247).handle(ex.getCause());
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/*     */         WorldFrame tmp282_279 = MenuMaker.this.parent; tmp282_279.getClass(); new WorldFrame.GUIExceptionHandler(tmp282_279).handle(ex);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private class GridConstructorItem extends MenuMaker.ConstructorItem
/*     */     implements ActionListener
/*     */   {
/*     */     public GridConstructorItem(Constructor c)
/*     */     {
/* 335 */       super(c);
/* 336 */       addActionListener(this);
/* 337 */       setIcon(MenuMaker.this.displayMap.getIcon(c.getDeclaringClass(), 16, 16));
/*     */     }
/*     */ 
/*     */     public void actionPerformed(ActionEvent event)
/*     */     {
/* 343 */       Grid newGrid = (Grid)invokeConstructor();
/* 344 */       MenuMaker.this.parent.setGrid(newGrid);
/*     */     }
/*     */   }
/*     */ 
/*     */   private class OccupantConstructorItem extends MenuMaker.ConstructorItem
/*     */     implements ActionListener
/*     */   {
/*     */     public OccupantConstructorItem(Constructor c)
/*     */     {
/* 316 */       super(c);
/* 317 */       addActionListener(this);
/* 318 */       setIcon(MenuMaker.this.displayMap.getIcon(c.getDeclaringClass(), 16, 16));
/*     */     }
/*     */ 
/*     */     public void actionPerformed(ActionEvent event)
/*     */     {
/* 324 */       Object result = invokeConstructor();
/* 325 */       MenuMaker.this.parent.getWorld().add(MenuMaker.this.currentLocation, result);
/* 326 */       MenuMaker.this.parent.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   private abstract class ConstructorItem extends MenuMaker.MCItem
/*     */   {
/*     */     private Constructor c;
/*     */ 
/*     */     public ConstructorItem(Constructor c)
/*     */     {
/* 267 */       super(null);
/* 268 */       setText(getDisplayString(null, c.getDeclaringClass().getName(), c.getParameterTypes()));
/*     */ 
/* 270 */       this.c = c;
/*     */     }
/*     */ 
/*     */     public Object invokeConstructor()
/*     */     {
/* 275 */       Class[] types = this.c.getParameterTypes();
/* 276 */       Object[] values = new Object[types.length];
/*     */ 
/* 278 */       for (int i = 0; i < types.length; i++)
/*     */       {
/* 280 */         values[i] = makeDefaultValue(types[i]);
/*     */       }
/*     */ 
/* 283 */       if (types.length > 0)
/*     */       {
/* 285 */         PropertySheet sheet = new PropertySheet(types, values);
/* 286 */         JOptionPane.showMessageDialog(this, sheet, MenuMaker.this.resources.getString("dialog.method.params"), 3);
/*     */ 
/* 289 */         values = sheet.getValues();
/*     */       }
/*     */ 
/*     */       try
/*     */       {
/* 294 */         return this.c.newInstance(values);
/*     */       }
/*     */       catch (InvocationTargetException ex)
/*     */       {
/*     */         WorldFrame tmp97_94 = MenuMaker.this.parent; tmp97_94.getClass(); new WorldFrame.GUIExceptionHandler(tmp97_94).handle(ex.getCause());
/* 299 */         return null;
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/*     */         WorldFrame tmp126_123 = MenuMaker.this.parent; tmp126_123.getClass(); new WorldFrame.GUIExceptionHandler(tmp126_123).handle(ex);
/* 304 */       }return null;
/*     */     }
/*     */   }
/*     */ 
/*     */   private class MCItem extends JMenuItem
/*     */   {
/*     */     private MCItem()
/*     */     {
/*     */     }
/*     */ 
/*     */     public String getDisplayString(Class retType, String name, Class[] paramTypes)
/*     */     {
/* 199 */       StringBuffer b = new StringBuffer();
/* 200 */       b.append("<html>");
/* 201 */       if (retType != null)
/* 202 */         appendTypeName(b, retType.getName());
/* 203 */       b.append(" <font color='blue'>");
/* 204 */       appendTypeName(b, name);
/* 205 */       b.append("</font>( ");
/* 206 */       for (int i = 0; i < paramTypes.length; i++)
/*     */       {
/* 208 */         if (i > 0)
/* 209 */           b.append(", ");
/* 210 */         appendTypeName(b, paramTypes[i].getName());
/*     */       }
/* 212 */       b.append(" )</html>");
/* 213 */       return b.toString();
/*     */     }
/*     */ 
/*     */     public void appendTypeName(StringBuffer b, String name)
/*     */     {
/* 218 */       int i = name.lastIndexOf('.');
/* 219 */       if (i >= 0)
/*     */       {
/* 221 */         String prefix = name.substring(0, i + 1);
/* 222 */         if (!prefix.equals("java.lang"))
/*     */         {
/* 224 */           b.append("<font color='gray'>");
/* 225 */           b.append(prefix);
/* 226 */           b.append("</font>");
/*     */         }
/* 228 */         b.append(name.substring(i + 1));
/*     */       }
/*     */       else {
/* 231 */         b.append(name);
/*     */       }
/*     */     }
/*     */ 
/*     */     public Object makeDefaultValue(Class type) {
/* 236 */       if (type == Integer.TYPE)
/* 237 */         return new Integer(0);
/* 238 */       if (type == Boolean.TYPE)
/* 239 */         return Boolean.FALSE;
/* 240 */       if (type == Double.TYPE)
/* 241 */         return new Double(0.0D);
/* 242 */       if (type == String.class)
/* 243 */         return "";
/* 244 */       if (type == Color.class)
/* 245 */         return Color.BLACK;
/* 246 */       if (type == Location.class)
/* 247 */         return MenuMaker.this.currentLocation;
/* 248 */       if (Grid.class.isAssignableFrom(type)) {
/* 249 */         return MenuMaker.this.currentGrid;
/*     */       }
/*     */ 
/*     */       try
/*     */       {
/* 254 */         return type.newInstance();
/*     */       }
/*     */       catch (Exception ex) {
/*     */       }
/* 258 */       return null;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     info.gridworld.gui.MenuMaker
 * JD-Core Version:    0.6.0
 */