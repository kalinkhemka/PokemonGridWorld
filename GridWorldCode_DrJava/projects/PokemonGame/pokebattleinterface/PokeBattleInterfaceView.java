/*     */ //package pokebattleinterface;
/*     */ 
/*     */ import Pokemon.Attack;
/*     */ import Pokemon.Pokemon;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ActionMap;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JLayeredPane;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.Timer;
/*     */ import org.jdesktop.application.Action;
/*     */ import org.jdesktop.application.Application;
/*     */ import org.jdesktop.application.ApplicationContext;
/*     */ import org.jdesktop.application.FrameView;
/*     */ import org.jdesktop.application.ResourceMap;
/*     */ import org.jdesktop.application.SingleFrameApplication;
/*     */ import org.jdesktop.application.TaskMonitor;
/*     */ 
/*     */ public class PokeBattleInterfaceView extends FrameView
/*     */ {
/*     */   private ArrayList<Pokemon> bag;
/*     */   private Pokemon attacker;
/*     */   private Pokemon userSelectedPokemon;
/*     */   private Pokemon returnValue;
/*  35 */   ResourceMap resourceMap = getResourceMap();
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JButton jButton5;
/*     */   private JButton jButton6;
/*     */   private JButton jButton7;
/*     */   private JComboBox jComboBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private JLayeredPane jLayeredPane1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTextArea jTextArea1;
/*     */   private JPanel mainPanel;
/*     */   private JMenuBar menuBar;
/*     */   private JProgressBar progressBar;
/*     */   private JLabel statusAnimationLabel;
/*     */   private JLabel statusMessageLabel;
/*     */   private JPanel statusPanel;
/*     */   private final Timer messageTimer;
/*     */   private final Timer busyIconTimer;
/*     */   private final Icon idleIcon;
/* 585 */   private final Icon[] busyIcons = new Icon[15];
/* 586 */   private int busyIconIndex = 0;
/*     */   private JDialog aboutBox;
/*     */ 
/*     */   public PokeBattleInterfaceView(SingleFrameApplication app, ArrayList<Pokemon> b, Pokemon wildAgressor)
/*     */   {
/*  37 */     super(app);
/*  38 */     this.bag = b;
/*  39 */     this.attacker = wildAgressor;
/*  40 */     this.userSelectedPokemon = ((Pokemon)this.bag.get(0));
/*  41 */     initComponents();
/*     */ 
/*  45 */     int messageTimeout = this.resourceMap.getInteger("StatusBar.messageTimeout").intValue();
/*  46 */     this.messageTimer = new Timer(messageTimeout, new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  48 */         PokeBattleInterfaceView.this.statusMessageLabel.setText("");
/*     */       }
/*     */     });
/*  51 */     this.messageTimer.setRepeats(false);
/*  52 */     int busyAnimationRate = this.resourceMap.getInteger("StatusBar.busyAnimationRate").intValue();
/*  53 */     for (int i = 0; i < this.busyIcons.length; i++) {
/*  54 */       this.busyIcons[i] = this.resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
/*     */     }
/*  56 */     this.busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  58 */         PokeBattleInterfaceView.access$102(PokeBattleInterfaceView.this, (PokeBattleInterfaceView.this.busyIconIndex + 1) % PokeBattleInterfaceView.this.busyIcons.length);
/*  59 */         PokeBattleInterfaceView.this.statusAnimationLabel.setIcon(PokeBattleInterfaceView.this.busyIcons[PokeBattleInterfaceView.this.busyIconIndex]);
/*     */       }
/*     */     });
/*  62 */     this.idleIcon = this.resourceMap.getIcon("StatusBar.idleIcon");
/*  63 */     this.statusAnimationLabel.setIcon(this.idleIcon);
/*  64 */     this.progressBar.setVisible(false);
/*     */ 
/*  67 */     TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
/*  68 */     taskMonitor.addPropertyChangeListener(new PropertyChangeListener() {
/*     */       public void propertyChange(PropertyChangeEvent evt) {
/*  70 */         String propertyName = evt.getPropertyName();
/*  71 */         if ("started".equals(propertyName)) {
/*  72 */           if (!PokeBattleInterfaceView.this.busyIconTimer.isRunning()) {
/*  73 */             PokeBattleInterfaceView.this.statusAnimationLabel.setIcon(PokeBattleInterfaceView.this.busyIcons[0]);
/*  74 */             PokeBattleInterfaceView.access$102(PokeBattleInterfaceView.this, 0);
/*  75 */             PokeBattleInterfaceView.this.busyIconTimer.start();
/*     */           }
/*  77 */           PokeBattleInterfaceView.this.progressBar.setVisible(true);
/*  78 */           PokeBattleInterfaceView.this.progressBar.setIndeterminate(true);
/*  79 */         } else if ("done".equals(propertyName)) {
/*  80 */           PokeBattleInterfaceView.this.busyIconTimer.stop();
/*  81 */           PokeBattleInterfaceView.this.statusAnimationLabel.setIcon(PokeBattleInterfaceView.this.idleIcon);
/*  82 */           PokeBattleInterfaceView.this.progressBar.setVisible(false);
/*  83 */           PokeBattleInterfaceView.this.progressBar.setValue(0);
/*  84 */         } else if ("message".equals(propertyName)) {
/*  85 */           String text = (String)(String)evt.getNewValue();
/*  86 */           PokeBattleInterfaceView.this.statusMessageLabel.setText(text == null ? "" : text);
/*  87 */           PokeBattleInterfaceView.this.messageTimer.restart();
/*  88 */         } else if ("progress".equals(propertyName)) {
/*  89 */           int value = ((Integer)(Integer)evt.getNewValue()).intValue();
/*  90 */           PokeBattleInterfaceView.this.progressBar.setVisible(true);
/*  91 */           PokeBattleInterfaceView.this.progressBar.setIndeterminate(false);
/*  92 */           PokeBattleInterfaceView.this.progressBar.setValue(value);
/*     */         }
/*     */       } } );
/*     */   }
/*     */ 
/*     */   @Action
/*     */   public void showAboutBox() {
/* 100 */     if (this.aboutBox == null) {
/* 101 */       JFrame mainFrame = PokeBattleInterfaceApp.getApplication().getMainFrame();
/* 102 */       this.aboutBox = new PokeBattleInterfaceAboutBox(mainFrame);
/* 103 */       this.aboutBox.setLocationRelativeTo(mainFrame);
/*     */     }
/* 105 */     PokeBattleInterfaceApp.getApplication().show(this.aboutBox);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 117 */     this.mainPanel = new JPanel();
/* 118 */     this.jButton1 = new JButton();
/* 119 */     this.jButton2 = new JButton();
/* 120 */     this.jButton3 = new JButton();
/* 121 */     this.jButton4 = new JButton();
/* 122 */     this.jComboBox1 = new JComboBox();
/* 123 */     this.jButton5 = new JButton();
/* 124 */     this.jButton6 = new JButton();
/* 125 */     this.jLabel1 = new JLabel();
/* 126 */     this.jLayeredPane1 = new JLayeredPane();
/* 127 */     this.jLabel2 = new JLabel();
/* 128 */     this.jScrollPane1 = new JScrollPane();
/* 129 */     this.jTextArea1 = new JTextArea();
/* 130 */     this.jLabel4 = new JLabel();
/* 131 */     this.jLabel5 = new JLabel();
/* 132 */     this.jLabel6 = new JLabel();
/* 133 */     this.jLabel7 = new JLabel();
/* 134 */     this.jLabel8 = new JLabel();
/* 135 */     this.jLabel9 = new JLabel();
/* 136 */     this.jLabel10 = new JLabel();
/* 137 */     this.jLabel3 = new JLabel();
/* 138 */     this.jButton7 = new JButton();
/* 139 */     this.menuBar = new JMenuBar();
/* 140 */     JMenu fileMenu = new JMenu();
/* 141 */     JMenuItem exitMenuItem = new JMenuItem();
/* 142 */     JMenu helpMenu = new JMenu();
/* 143 */     JMenuItem aboutMenuItem = new JMenuItem();
/* 144 */     this.statusPanel = new JPanel();
/* 145 */     JSeparator statusPanelSeparator = new JSeparator();
/* 146 */     this.statusMessageLabel = new JLabel();
/* 147 */     this.statusAnimationLabel = new JLabel();
/* 148 */     this.progressBar = new JProgressBar();
/*     */ 
/* 150 */     this.mainPanel.setName("mainPanel");
/*     */ 
/* 152 */     this.jButton1.setText(((Attack)this.userSelectedPokemon.getAttacks().get(0)).getName());
/* 153 */     this.jButton1.setName("jButton1");
/* 154 */     this.jButton1.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 156 */         PokeBattleInterfaceView.this.jButton1MouseClicked(evt);
/*     */       }
/*     */     });
/* 160 */     this.jButton2.setText(((Attack)this.userSelectedPokemon.getAttacks().get(1)).getName());
/* 161 */     this.jButton2.setName("jButton2");
/* 162 */     this.jButton2.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 164 */         PokeBattleInterfaceView.this.jButton2MouseClicked(evt);
/*     */       }
/*     */     });
/* 168 */     this.jButton3.setText(((Attack)this.userSelectedPokemon.getAttacks().get(2)).getName());
/* 169 */     this.jButton3.setName("jButton3");
/* 170 */     this.jButton3.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 172 */         PokeBattleInterfaceView.this.jButton3MouseClicked(evt);
/*     */       }
/*     */     });
/* 176 */     this.jButton4.setText(((Attack)this.userSelectedPokemon.getAttacks().get(3)).getName());
/* 177 */     this.jButton4.setName("jButton4");
/* 178 */     this.jButton4.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 180 */         PokeBattleInterfaceView.this.jButton4MouseClicked(evt);
/*     */       }
/*     */     });
/* 184 */     String[] pokemonList = new String[this.bag.size()];
/* 185 */     int count = 0;
/* 186 */     for (Pokemon p : this.bag) {
/* 187 */       pokemonList[count] = (p.getName() + " (" + p.getLevel() + ")");
/* 188 */       count++;
/*     */     }
/* 190 */     this.jComboBox1.setModel(new DefaultComboBoxModel(pokemonList));
/* 191 */     this.jComboBox1.setName("jComboBox1");
/*     */ 
/* 193 */     ResourceMap resourceMap = ((PokeBattleInterfaceApp)Application.getInstance(PokeBattleInterfaceApp.class)).getContext().getResourceMap(PokeBattleInterfaceView.class);
/* 194 */     this.jButton5.setText(resourceMap.getString("jButton5.text", new Object[0]));
/* 195 */     this.jButton5.setName("jButton5");
/* 196 */     this.jButton5.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 198 */         PokeBattleInterfaceView.this.jButton5MouseClicked(evt);
/*     */       }
/*     */     });
/* 202 */     this.jButton6.setAction(null);
/* 203 */     this.jButton6.setText(resourceMap.getString("jButton6.text", new Object[0]));
/* 204 */     this.jButton6.setName("jButton6");
/* 205 */     this.jButton6.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 207 */         PokeBattleInterfaceView.this.jButton6MouseClicked(evt);
/*     */       }
/*     */     });
/* 211 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 212 */     this.jLabel1.setName("jLabel1");
/*     */ 
/* 214 */     this.jLayeredPane1.setName("jLayeredPane1");
/*     */ 
/* 216 */     this.jLabel2.setText("" + this.attacker.getLevel());
/* 217 */     this.jLabel2.setName("jLabel2");
/* 218 */     this.jLabel2.setBounds(120, 20, 90, 14);
/* 219 */     this.jLayeredPane1.add(this.jLabel2, JLayeredPane.DEFAULT_LAYER);
/*     */ 
/* 221 */     this.jScrollPane1.setName("jScrollPane1");
/*     */ 
/* 223 */     this.jTextArea1.setColumns(20);
/* 224 */     this.jTextArea1.setRows(5);
/* 225 */     this.jTextArea1.setName("jTextArea1");
/* 226 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*     */ 
/* 228 */     this.jScrollPane1.setBounds(20, 260, 440, 80);
/* 229 */     this.jLayeredPane1.add(this.jScrollPane1, JLayeredPane.DEFAULT_LAYER);
/*     */ 
/* 231 */     this.jLabel4.setText("" + this.userSelectedPokemon.getLevel());
/* 232 */     this.jLabel4.setName("jLabel4");
/* 233 */     this.jLabel4.setBounds(360, 160, 80, 14);
/* 234 */     this.jLayeredPane1.add(this.jLabel4, JLayeredPane.DEFAULT_LAYER);
/*     */ 
/* 236 */     this.jLabel5.setIcon(resourceMap.getIcon(this.userSelectedPokemon.getName() + "-back"));
/* 237 */     this.jLabel5.setText(resourceMap.getString("jLabel5.text", new Object[0]));
/* 238 */     this.jLabel5.setName("jLabel5");
/* 239 */     this.jLabel5.setBounds(30, 90, 150, 0);
/* 240 */     this.jLayeredPane1.add(this.jLabel5, JLayeredPane.DEFAULT_LAYER);
/*     */ 
/* 242 */     this.jLabel6.setIcon(resourceMap.getIcon(this.attacker.getName() + "-front"));
/* 243 */     this.jLabel6.setText(resourceMap.getString("jLabel6.text", new Object[0]));
/* 244 */     this.jLabel6.setName("jLabel6");
/* 245 */     this.jLabel6.setBounds(320, 20, 150, 140);
/* 246 */     this.jLayeredPane1.add(this.jLabel6, JLayeredPane.DEFAULT_LAYER);
/*     */ 
/* 248 */     this.jLabel7.setIcon(resourceMap.getIcon("jLabel7.icon"));
/* 249 */     this.jLabel7.setText(resourceMap.getString("jLabel7.text", new Object[0]));
/* 250 */     this.jLabel7.setName("jLabel7");
/* 251 */     this.jLabel7.setBounds(190, 90, 100, 90);
/* 252 */     this.jLayeredPane1.add(this.jLabel7, JLayeredPane.DEFAULT_LAYER);
/* 253 */     this.jLabel7.setVisible(false);
/*     */ 
/* 255 */     this.jLabel8.setText(resourceMap.getString("jLabel8.text", new Object[0]));
/* 256 */     this.jLabel8.setName("jLabel8");
/* 257 */     this.jLabel8.setIcon(resourceMap.getIcon(this.userSelectedPokemon.getName() + "-back"));
/* 258 */     this.jLabel8.setBounds(10, 80, 190, 160);
/* 259 */     this.jLayeredPane1.add(this.jLabel8, JLayeredPane.DEFAULT_LAYER);
/*     */ 
/* 261 */     this.jLabel9.setText("Health: " + this.userSelectedPokemon.getHPRemain());
/* 262 */     this.jLabel9.setName("jLabel9");
/* 263 */     this.jLabel9.setBounds(280, 160, 66, 14);
/* 264 */     this.jLayeredPane1.add(this.jLabel9, JLayeredPane.DEFAULT_LAYER);
/*     */ 
/* 266 */     this.jLabel10.setText("Health: " + this.attacker.getHPRemain());
/* 267 */     this.jLabel10.setName("jLabel10");
/* 268 */     this.jLabel10.setBounds(50, 20, 66, 14);
/* 269 */     this.jLayeredPane1.add(this.jLabel10, JLayeredPane.DEFAULT_LAYER);
/*     */ 
/* 271 */     this.jLabel3.setIcon(resourceMap.getIcon("jLabel3.icon"));
/* 272 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/* 273 */     this.jLabel3.setName("jLabel3");
/* 274 */     this.jLabel3.setBounds(0, 0, 480, 360);
/* 275 */     this.jLayeredPane1.add(this.jLabel3, JLayeredPane.DEFAULT_LAYER);
/*     */ 
/* 277 */     this.jButton7.setText(resourceMap.getString("jButton7.text", new Object[0]));
/* 278 */     this.jButton7.setName("jButton7");
/* 279 */     this.jButton7.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 281 */         PokeBattleInterfaceView.this.jButton7MouseClicked(evt);
/*     */       }
/*     */     });
/* 285 */     GroupLayout mainPanelLayout = new GroupLayout(this.mainPanel);
/* 286 */     this.mainPanel.setLayout(mainPanelLayout);
/* 287 */     mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton3, -1, 130, 32767).addComponent(this.jComboBox1, GroupLayout.Alignment.TRAILING, 0, 130, 32767).addComponent(this.jButton4, GroupLayout.Alignment.TRAILING, -1, 130, 32767).addComponent(this.jButton5, GroupLayout.Alignment.TRAILING).addComponent(this.jButton2, -1, 130, 32767).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING, -1, 130, 32767).addComponent(this.jButton6, GroupLayout.Alignment.TRAILING, -1, 130, 32767).addComponent(this.jLabel1).addComponent(this.jButton7, -1, 130, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLayeredPane1, -2, 490, -2).addGap(100, 100, 100)));
/*     */ 
/* 305 */     mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addGap(32, 32, 32).addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addComponent(this.jLayeredPane1, -2, 371, -2).addGap(78, 78, 78)).addGroup(mainPanelLayout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jComboBox1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton5).addGap(18, 18, 18).addComponent(this.jButton6, -1, 41, 32767).addGap(18, 18, 18).addComponent(this.jButton7).addGap(137, 137, 137))).addGap(217, 217, 217)));
/*     */ 
/* 335 */     this.menuBar.setName("menuBar");
/*     */ 
/* 337 */     fileMenu.setText(resourceMap.getString("fileMenu.text", new Object[0]));
/* 338 */     fileMenu.setName("fileMenu");
/*     */ 
/* 340 */     ActionMap actionMap = ((PokeBattleInterfaceApp)Application.getInstance(PokeBattleInterfaceApp.class)).getContext().getActionMap(PokeBattleInterfaceView.class, this);
/* 341 */     exitMenuItem.setAction(actionMap.get("quit"));
/* 342 */     exitMenuItem.setName("exitMenuItem");
/* 343 */     fileMenu.add(exitMenuItem);
/*     */ 
/* 345 */     this.menuBar.add(fileMenu);
/*     */ 
/* 347 */     helpMenu.setText(resourceMap.getString("helpMenu.text", new Object[0]));
/* 348 */     helpMenu.setName("helpMenu");
/*     */ 
/* 350 */     aboutMenuItem.setAction(actionMap.get("showAboutBox"));
/* 351 */     aboutMenuItem.setName("aboutMenuItem");
/* 352 */     helpMenu.add(aboutMenuItem);
/*     */ 
/* 354 */     this.menuBar.add(helpMenu);
/*     */ 
/* 356 */     this.statusPanel.setName("statusPanel");
/*     */ 
/* 358 */     statusPanelSeparator.setName("statusPanelSeparator");
/*     */ 
/* 360 */     this.statusMessageLabel.setName("statusMessageLabel");
/*     */ 
/* 362 */     this.statusAnimationLabel.setHorizontalAlignment(2);
/* 363 */     this.statusAnimationLabel.setName("statusAnimationLabel");
/*     */ 
/* 365 */     this.progressBar.setName("progressBar");
/*     */ 
/* 367 */     GroupLayout statusPanelLayout = new GroupLayout(this.statusPanel);
/* 368 */     this.statusPanel.setLayout(statusPanelLayout);
/* 369 */     statusPanelLayout.setHorizontalGroup(statusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(statusPanelSeparator, -1, 736, 32767).addGroup(statusPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.statusMessageLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 566, 32767).addComponent(this.progressBar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.statusAnimationLabel).addContainerGap()));
/*     */ 
/* 381 */     statusPanelLayout.setVerticalGroup(statusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(statusPanelLayout.createSequentialGroup().addComponent(statusPanelSeparator, -2, 2, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(statusPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.statusMessageLabel).addComponent(this.statusAnimationLabel).addComponent(this.progressBar, -2, -1, -2)).addGap(3, 3, 3)));
/*     */ 
/* 393 */     setComponent(this.mainPanel);
/* 394 */     setMenuBar(this.menuBar);
/* 395 */     setStatusBar(this.statusPanel);
/*     */   }
/*     */ 
/*     */   private void jButton5MouseClicked(MouseEvent evt)
/*     */   {
/* 402 */     if (this.jComboBox1.getSelectedItem() != this.userSelectedPokemon.getName()) {
/* 403 */       this.userSelectedPokemon = ((Pokemon)this.bag.get(this.jComboBox1.getSelectedIndex()));
/*     */     }
/* 405 */     this.jLabel9.setText("Health: " + this.userSelectedPokemon.getHPRemain());
/* 406 */     this.jLabel10.setText("Health: " + this.attacker.getHPRemain());
/* 407 */     this.jLabel8.setIcon(this.resourceMap.getIcon(this.userSelectedPokemon.getName() + "-back"));
/* 408 */     this.jButton1.setText(((Attack)this.userSelectedPokemon.getAttacks().get(0)).getName());
/* 409 */     this.jButton2.setText(((Attack)this.userSelectedPokemon.getAttacks().get(1)).getName());
/* 410 */     this.jButton3.setText(((Attack)this.userSelectedPokemon.getAttacks().get(2)).getName());
/* 411 */     this.jButton4.setText(((Attack)this.userSelectedPokemon.getAttacks().get(3)).getName());
/* 412 */     this.jLabel4.setText("" + this.userSelectedPokemon.getLevel());
/*     */   }
/*     */ 
/*     */   private void jButton1MouseClicked(MouseEvent evt) {
/* 416 */     this.jLabel9.setText("Health: " + this.userSelectedPokemon.getHPRemain());
/* 417 */     this.jLabel10.setText("Health: " + this.attacker.getHPRemain());
/* 418 */     if (this.attacker.getHPRemain() <= 0) {
/* 419 */       this.jTextArea1.setText("YOU DEFEATED " + this.attacker.getName() + " !!!");
/* 420 */       this.attacker.decrementHP(this.attacker.getHPRemain());
/* 421 */       this.jLabel10.setText("Health: " + this.attacker.getHPRemain());
/* 422 */       for (Pokemon p : this.bag) {
/* 423 */         p.addEXP(this.attacker);
/* 424 */         if (p.getEXP() > p.getEXPNext()) p.levelUp();
/*     */       }
/*     */     }
/* 427 */     else if (this.userSelectedPokemon.getHPRemain() > 0) {
/* 428 */       int attackPower = 0;
/* 429 */       for (; attackPower <= 0; attackPower = (int)(attackPower + Math.random() * 5.0D)) attackPower = this.userSelectedPokemon.fight((Attack)this.userSelectedPokemon.getAttacks().get(0), this.attacker);
/* 430 */       this.attacker.decrementHP(attackPower);
/* 431 */       this.jTextArea1.append(" You attacked " + this.attacker.getName() + " with the " + ((Attack)this.userSelectedPokemon.getAttacks().get(0)).getName() + " \nAttack and caused " + attackPower + " Damage. ");
/* 432 */       attackPower = this.attacker.fight((Attack)this.attacker.getAttacks().get((int)Math.random() * 4), this.userSelectedPokemon) + (int)(Math.random() * 5.0D);
/* 433 */       this.userSelectedPokemon.decrementHP(attackPower);
/* 434 */       this.jTextArea1.append(" " + this.attacker.getName() + " attacked you with the " + ((Attack)this.attacker.getAttacks().get(0)).getName() + " \nattack and caused " + attackPower + " Damage.\n ");
/* 435 */     } else if (this.userSelectedPokemon.getHPRemain() <= 0) {
/* 436 */       this.jComboBox1.remove(this.bag.indexOf(this.userSelectedPokemon));
/* 437 */       this.bag.remove(this.userSelectedPokemon);
/* 438 */       this.userSelectedPokemon = ((Pokemon)this.bag.get(0));
/* 439 */       this.jLabel8.setIcon(this.resourceMap.getIcon(this.userSelectedPokemon.getName() + "-back"));
/* 440 */       this.jTextArea1.append(" Your pokemon died....\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton2MouseClicked(MouseEvent evt) {
/* 445 */     this.jLabel9.setText("Health: " + this.userSelectedPokemon.getHPRemain());
/* 446 */     this.jLabel10.setText("Health: " + this.attacker.getHPRemain());
/* 447 */     if (this.attacker.getHPRemain() <= 0) {
/* 448 */       this.jTextArea1.setText("YOU DEFEATED " + this.attacker.getName() + " !!!");
/* 449 */       this.attacker.decrementHP(this.attacker.getHPRemain());
/* 450 */       this.jLabel10.setText("Health: " + this.attacker.getHPRemain());
/* 451 */       for (Pokemon p : this.bag) {
/* 452 */         p.addEXP(this.attacker);
/* 453 */         if (p.getEXP() > p.getEXPNext()) p.levelUp();
/*     */       }
/*     */     }
/* 456 */     else if (this.userSelectedPokemon.getHPRemain() > 0) {
/* 457 */       int attackPower = 0;
/* 458 */       for (; attackPower <= 0; attackPower = (int)(attackPower + Math.random() * 5.0D)) attackPower = this.userSelectedPokemon.fight((Attack)this.userSelectedPokemon.getAttacks().get(1), this.attacker);
/* 459 */       this.attacker.decrementHP(attackPower);
/* 460 */       this.jTextArea1.append(" You attacked " + this.attacker.getName() + " with the " + ((Attack)this.userSelectedPokemon.getAttacks().get(1)).getName() + " \nAttack and caused " + attackPower + " Damage. ");
/* 461 */       attackPower = this.attacker.fight((Attack)this.attacker.getAttacks().get((int)Math.random() * 4), this.userSelectedPokemon) + (int)(Math.random() * 5.0D);
/* 462 */       this.userSelectedPokemon.decrementHP(attackPower);
/* 463 */       this.jTextArea1.append(" " + this.attacker.getName() + " attacked you with the " + ((Attack)this.attacker.getAttacks().get(1)).getName() + " \nattack and caused " + attackPower + " Damage. \n ");
/* 464 */     } else if (this.userSelectedPokemon.getHPRemain() <= 0) {
/* 465 */       this.jComboBox1.remove(this.bag.indexOf(this.userSelectedPokemon));
/* 466 */       this.bag.remove(this.userSelectedPokemon);
/* 467 */       this.userSelectedPokemon = ((Pokemon)this.bag.get(0));
/* 468 */       this.jLabel8.setIcon(this.resourceMap.getIcon(this.userSelectedPokemon.getName() + "-back"));
/* 469 */       this.jTextArea1.append(" Your pokemon died....\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton3MouseClicked(MouseEvent evt)
/*     */   {
/* 476 */     this.jLabel9.setText("Health: " + this.userSelectedPokemon.getHPRemain());
/* 477 */     this.jLabel10.setText("Health: " + this.attacker.getHPRemain());
/* 478 */     if (this.attacker.getHPRemain() <= 0) {
/* 479 */       this.jTextArea1.setText("YOU DEFEATED " + this.attacker.getName() + " !!!");
/* 480 */       this.attacker.decrementHP(this.attacker.getHPRemain());
/* 481 */       this.jLabel10.setText("Health: " + this.attacker.getHPRemain());
/* 482 */       for (Pokemon p : this.bag) {
/* 483 */         p.addEXP(this.attacker);
/* 484 */         if (p.getEXP() > p.getEXPNext()) p.levelUp();
/*     */       }
/*     */     }
/* 487 */     else if (this.userSelectedPokemon.getHPRemain() > 0) {
/* 488 */       int attackPower = 0;
/* 489 */       for (; attackPower <= 0; attackPower = (int)(attackPower + Math.random() * 5.0D)) attackPower = this.userSelectedPokemon.fight((Attack)this.userSelectedPokemon.getAttacks().get(2), this.attacker);
/* 490 */       this.attacker.decrementHP(attackPower);
/* 491 */       this.jTextArea1.append(" You attacked " + this.attacker.getName() + " with the " + ((Attack)this.userSelectedPokemon.getAttacks().get(2)).getName() + " \nAttack and caused " + attackPower + " Damage. ");
/* 492 */       attackPower = this.attacker.fight((Attack)this.attacker.getAttacks().get((int)Math.random() * 4), this.userSelectedPokemon) + (int)(Math.random() * 5.0D);
/* 493 */       this.userSelectedPokemon.decrementHP(attackPower);
/* 494 */       this.jTextArea1.append(" " + this.attacker.getName() + " attacked you with the " + ((Attack)this.attacker.getAttacks().get(2)).getName() + " \nattack and caused " + attackPower + " Damage. \n ");
/* 495 */     } else if (this.userSelectedPokemon.getHPRemain() <= 0) {
/* 496 */       this.jComboBox1.remove(this.bag.indexOf(this.userSelectedPokemon));
/* 497 */       this.bag.remove(this.userSelectedPokemon);
/* 498 */       this.userSelectedPokemon = ((Pokemon)this.bag.get(0));
/* 499 */       this.jLabel8.setIcon(this.resourceMap.getIcon(this.userSelectedPokemon.getName() + "-back"));
/* 500 */       this.jTextArea1.append(" Your pokemon died....\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton4MouseClicked(MouseEvent evt)
/*     */   {
/* 506 */     this.jLabel9.setText("Health: " + this.userSelectedPokemon.getHPRemain());
/* 507 */     this.jLabel10.setText("Health: " + this.attacker.getHPRemain());
/* 508 */     if (this.attacker.getHPRemain() <= 0) {
/* 509 */       this.jTextArea1.setText("YOU DEFEATED " + this.attacker.getName() + " !!!");
/* 510 */       this.attacker.decrementHP(this.attacker.getHPRemain());
/* 511 */       this.jLabel10.setText("Health: " + this.attacker.getHPRemain());
/* 512 */       for (Pokemon p : this.bag) {
/* 513 */         p.addEXP(this.attacker);
/* 514 */         if (p.getEXP() > p.getEXPNext()) p.levelUp();
/*     */       }
/*     */     }
/* 517 */     else if (this.userSelectedPokemon.getHPRemain() > 0) {
/* 518 */       int attackPower = 0;
/* 519 */       for (; attackPower <= 0; attackPower = (int)(attackPower + Math.random() * 5.0D)) attackPower = this.userSelectedPokemon.fight((Attack)this.userSelectedPokemon.getAttacks().get(3), this.attacker);
/* 520 */       this.attacker.decrementHP(attackPower);
/* 521 */       this.jTextArea1.append(" You attacked " + this.attacker.getName() + " with the " + ((Attack)this.userSelectedPokemon.getAttacks().get(3)).getName() + " \nAttack and caused " + attackPower + " Damage. ");
/* 522 */       attackPower = this.attacker.fight((Attack)this.attacker.getAttacks().get((int)Math.random() * 4), this.userSelectedPokemon) + (int)(Math.random() * 5.0D);
/* 523 */       this.userSelectedPokemon.decrementHP(attackPower);
/* 524 */       this.jTextArea1.append(" " + this.attacker.getName() + " attacked you with the " + ((Attack)this.attacker.getAttacks().get(3)).getName() + " \nattack and caused " + attackPower + " Damage. \n ");
/* 525 */     } else if (this.userSelectedPokemon.getHPRemain() <= 0) {
/* 526 */       this.jComboBox1.remove(this.bag.indexOf(this.userSelectedPokemon));
/* 527 */       this.bag.remove(this.userSelectedPokemon);
/* 528 */       this.userSelectedPokemon = ((Pokemon)this.bag.get(0));
/* 529 */       this.jLabel8.setIcon(this.resourceMap.getIcon(this.userSelectedPokemon.getName() + "-back"));
/* 530 */       this.jTextArea1.append(" Your pokemon died....\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton6MouseClicked(MouseEvent evt) {
/* 535 */     String[] args = new String[1];
/* 536 */     super.getFrame().setVisible(false);
/*     */   }
/*     */ 
/*     */   private void jButton7MouseClicked(MouseEvent evt)
/*     */   {
/* 543 */     if (this.attacker.getHPRemain() / this.attacker.getHPMax() < 0.5D) {
/* 544 */       this.jTextArea1.setText("YOU CAPTURED " + this.attacker.getName() + " !!!");
/* 545 */       this.returnValue = this.attacker;
/*     */     }
/*     */     else {
/* 548 */       this.jTextArea1.setText("YOU FAILED TO CAPTURE " + this.attacker.getName() + "...");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Owner\Documents\BellarmineDocs\2010-2011\Java\GridWorldCode_DrJava\projects\PokemonGame\PokeBattleInterface.jar
 * Qualified Name:     pokebattleinterface.PokeBattleInterfaceView
 * JD-Core Version:    0.6.0
 */