/*     */ package pokebattleinterface;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import javax.swing.ActionMap;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import org.jdesktop.application.Action;
/*     */ import org.jdesktop.application.Application;
/*     */ import org.jdesktop.application.ApplicationContext;
/*     */ import org.jdesktop.application.ResourceMap;
/*     */ 
/*     */ public class PokeBattleInterfaceAboutBox extends JDialog
/*     */ {
/*     */   private JButton closeButton;
/*     */ 
/*     */   public PokeBattleInterfaceAboutBox(Frame parent)
/*     */   {
/*  12 */     super(parent);
/*  13 */     initComponents();
/*  14 */     getRootPane().setDefaultButton(this.closeButton);
/*     */   }
/*  18 */   @Action
/*     */   public void closeAboutBox() { dispose();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  29 */     this.closeButton = new JButton();
/*  30 */     JLabel appTitleLabel = new JLabel();
/*  31 */     JLabel vendorLabel = new JLabel();
/*  32 */     JLabel appVendorLabel = new JLabel();
/*  33 */     JLabel appHomepageLabel = new JLabel();
/*  34 */     JLabel appDescLabel = new JLabel();
/*  35 */     JLabel imageLabel = new JLabel();
/*  36 */     JLabel appHomepageLabel1 = new JLabel();
/*  37 */     JLabel appHomepageLabel2 = new JLabel();
/*  38 */     JLabel appHomepageLabel3 = new JLabel();
/*     */ 
/*  40 */     setDefaultCloseOperation(2);
/*  41 */     ResourceMap resourceMap = ((PokeBattleInterfaceApp)Application.getInstance(PokeBattleInterfaceApp.class)).getContext().getResourceMap(PokeBattleInterfaceAboutBox.class);
/*  42 */     setTitle(resourceMap.getString("title", new Object[0]));
/*  43 */     setModal(true);
/*  44 */     setName("aboutBox");
/*  45 */     setResizable(false);
/*     */ 
/*  47 */     ActionMap actionMap = ((PokeBattleInterfaceApp)Application.getInstance(PokeBattleInterfaceApp.class)).getContext().getActionMap(PokeBattleInterfaceAboutBox.class, this);
/*  48 */     this.closeButton.setAction(actionMap.get("closeAboutBox"));
/*  49 */     this.closeButton.setName("closeButton");
/*     */ 
/*  51 */     appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | 0x1, appTitleLabel.getFont().getSize() + 4));
/*  52 */     appTitleLabel.setText(resourceMap.getString("Application.title", new Object[0]));
/*  53 */     appTitleLabel.setName("appTitleLabel");
/*     */ 
/*  55 */     vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | 0x1));
/*  56 */     vendorLabel.setText(resourceMap.getString("vendorLabel.text", new Object[0]));
/*  57 */     vendorLabel.setName("vendorLabel");
/*     */ 
/*  59 */     appVendorLabel.setText(resourceMap.getString("Application.vendor", new Object[0]));
/*  60 */     appVendorLabel.setName("appVendorLabel");
/*     */ 
/*  62 */     appHomepageLabel.setText(resourceMap.getString("Application.homepage", new Object[0]));
/*  63 */     appHomepageLabel.setName("appHomepageLabel");
/*     */ 
/*  65 */     appDescLabel.setText(resourceMap.getString("appDescLabel.text", new Object[0]));
/*  66 */     appDescLabel.setName("appDescLabel");
/*     */ 
/*  68 */     imageLabel.setIcon(resourceMap.getIcon("imageLabel.icon"));
/*  69 */     imageLabel.setName("imageLabel");
/*     */ 
/*  71 */     appHomepageLabel1.setText(resourceMap.getString("appHomepageLabel1.text", new Object[0]));
/*  72 */     appHomepageLabel1.setName("appHomepageLabel1");
/*     */ 
/*  74 */     appHomepageLabel2.setText(resourceMap.getString("appHomepageLabel2.text", new Object[0]));
/*  75 */     appHomepageLabel2.setName("appHomepageLabel2");
/*     */ 
/*  77 */     appHomepageLabel3.setText(resourceMap.getString("appHomepageLabel3.text", new Object[0]));
/*  78 */     appHomepageLabel3.setName("appHomepageLabel3");
/*     */ 
/*  80 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  81 */     getContentPane().setLayout(layout);
/*  82 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(imageLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.closeButton).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(appTitleLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(vendorLabel).addGap(14, 14, 14))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(appVendorLabel).addComponent(appHomepageLabel1).addComponent(appHomepageLabel2).addComponent(appHomepageLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(appHomepageLabel).addGap(59, 59, 59)).addComponent(appDescLabel, -1, 278, 32767)))).addContainerGap()));
/*     */ 
/* 110 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(imageLabel, -2, 277, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(appTitleLabel).addComponent(appDescLabel, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(71, 71, 71).addComponent(appHomepageLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 129, 32767).addComponent(this.closeButton)).addGroup(layout.createSequentialGroup().addGap(38, 38, 38).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(appVendorLabel).addComponent(vendorLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(appHomepageLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(appHomepageLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(appHomepageLabel3))).addContainerGap()));
/*     */ 
/* 138 */     pack();
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     pokebattleinterface.PokeBattleInterfaceAboutBox
 * JD-Core Version:    0.6.0
 */