package Orion.Model;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


/**
 * klasa GameWindow której obiektem jest okno gry wraz ze wszystkimi panelami
 * @author karolinaandruszkiewicz
 */
public class GameWindow extends JFrame implements MouseListener {
    /**panel menu */
    public JPanel menuPanel = new JPanel();
    /**panel tytułowy */
    public JPanel welcomePanel = new StarPanel(); 
    /**panel wstępu do nowej gry */
    public JPanel newGamePanel = new StarPanel();
    /**panel wprowadzenia */
    public JPanel introductionPanel = new StarPanel(); 
    /**panel quizu nazw */
    public JPanel nameQuizPanel = new StarPanel(); 
    /**panel łączenia gwiazd */
    public JPanel connectDotsPanel = new MarblePanel(); 
    /**panel informacyjny do quizu wiedzy */
    public JPanel astrologyInfoPanel = new StarPanel(); 
    /**panel quizu wiedzy */
    public JPanel astrologyQuizPanel = new StarPanel(); 
    /**panel zakończenia gry */
    public JPanel endGamePanel= new StarPanel(); 
    /**panel wyboru poziomu zaawansowania*/
    public JPanel chooseLevelPanel = new StarPanel();
    /**panel instrukcji */
    public JPanel instructionPanel = new StarPanel(); 
    /**panel wyjścia z gry */
    public JPanel quitPanel = new StarPanel(); 
    /**panel wygranej */
    public JPanel winPanel= new StarPanel(); 
    /**panel przegranej */
    public JPanel defeatPanel= new StarPanel(); 
    /**panel powtórzenia cyklu */
    public JPanel repeatCyclePanel= new StarPanel(); 
    /**JLabel zmieniany wieloktronie w czasie gry, używany w różnych klasach, wskaźnik poziomu*/
    static public JLabel level= new JLabel(); 
    /**JLabel zmieniany wieloktronie w czasie gry, używany w różnych klasach, wskaźnik "życia"*/
    static public JLabel life = new JLabel();
    /**cardPanel znajdujący się po prawej stronie Menu, o układzie CardLayout c1*/
    static public JPanel cardPanel= new JPanel(); 
    /**układ CardLayout zmieniający panele po prawej stronie od Menu*/
    static public CardLayout c1 = new CardLayout(); 
    /**kontener okna*/
    public Container pane = this.getContentPane();
    private BufferedImage image; 
    /**współrzędna x kliknięcia*/
    public int myX; 
    /**współrzędna y kliknięcia*/
    public int myY; 
    /**definicja nowego obiektu Game, konieczna aby uruchomić GUI Paneli po starcie programu*/
    public Game game = new Game(0); 
    /**definicja zmiennej typu integer przechowującej informację o ilości wykonanych, poprawnych połączeń w konstelacji pierwszej*/
    public int connect1=0; 
    /**definicja zmiennej typu integer przechowującej informację o ilości wykonanych, poprawnych połączeń w konstelacji drugiej*/
    public int connect2=0; 
    /**zmienna logiczna mówiąca o tym, czy wszystkie wykonane połączenia należą do prawidowych połączeń konstelacji pierwszej*/
    public boolean connected1=false; 
    /**zmienna logiczna mówiąca o tym, czy wszystkie wykonane połączenia należą do prawidowych połączeń konstelacji drugiej*/
    public boolean connected2=false; 
    /**lista klikniętych przycisków z konstelacji pierwszej*/
    public ArrayList<JButton> buttons1 = new ArrayList<JButton>();
    /**lista klikniętych przycisków z konstelacji drugiej*/
    public ArrayList<JButton> buttons2 = new ArrayList<JButton>();
    /**lista skopiowanych połączeń pierwszej konstelacji*/
    public ArrayList<Connection> clonedList1 = new ArrayList<Connection>();
    /**lista połączeń do wykonania dla pierwszej konstelacji*/
    public ArrayList<Connection> toConnect1=new ArrayList<Connection>(); 
    /**lista skopiowanych połączeń drugiej konstelacji*/
    public ArrayList<Connection> clonedList2 = new ArrayList<Connection>();
    /**lista połączeń do wykonania dla drugiej konstelacji*/
    public ArrayList<Connection> toConnect2=new ArrayList<Connection>();
    /**liczba wykonanych, poprawnych połączeń dla konstelacji pierwszej*/
    public int connectedNumber1=0; 
    /**liczba wykonanych, poprawnych połączeń dla konstelacji drugiej*/
    public int connectedNumber2=0;
    /**zmienna logiczna informująca o tym, czy nastąpni zmiana konstelacji*/
    static public boolean changed=false; 
  
    /**
     * konstruktor bezargumentowy okna gry
     */
     public GameWindow (){
        super(); 
        int gameWidth=1024; //ustawienie szerokości okna gry
        int gameHeight=768;//ustawienie wysokości okna gry
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        int xCenter=(screenWidth-gameWidth)/2; //obliczenia konieczne aby ustawić okno w centrum ekranu
        int yCenter=(screenHeight-gameHeight)/2;  //obliczenia konieczne aby ustawić okno w centrum ekranu     
        this.setPreferredSize(new Dimension(1024, 768));
        this.setLocation(xCenter,yCenter); //ustawienie okna w centrum ekranu
        this.setResizable(false); //brak możliwości zmiany wielkości
        
        JSplitPane dividing = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPanel, cardPanel); //podział szyby na 2 części
        dividing.setDividerSize(0); //ustawienie wielkości linii podziału na 0
        dividing.setBackground(Color.BLACK); // kolor tła szybki : czarny
        this.pane.add(dividing); //dodanie szybki do kontenera
        cardPanel.setLayout(new GridLayout(1,1)); //Grid Layout (1,1) dla panelu po prawej stronie od menu, a więc każdy element dodawany będzie domyślnie na całość panelu
        cardPanel.setLayout(c1);
        cardPanel.add(welcomePanel,"WELCOME"); 
        cardPanel.add(newGamePanel,"NEW"); 
        cardPanel.add(introductionPanel,"INTRO"); 
        cardPanel.add(nameQuizPanel,"QUIZ_NAME"); 
        cardPanel.add(connectDotsPanel,"DOTS"); 
        cardPanel.add(astrologyInfoPanel,"ASTRO_INFO"); 
        cardPanel.add(astrologyQuizPanel,"ASTRO_QUIZ"); 
        cardPanel.add(endGamePanel,"END_GAME"); 
        cardPanel.add(chooseLevelPanel,"CHOOSE"); 
        cardPanel.add(instructionPanel,"INSTRUCTION"); 
        cardPanel.add(quitPanel,"QUIT"); 
        cardPanel.add(winPanel, "WIN"); 
        cardPanel.add(defeatPanel,"DEFEAT");
        cardPanel.add(repeatCyclePanel, "REPEAT");
        
        this.setDefaultCloseOperation(3); //zamknięcie okna 
        //wywołanie funkcji tworzących wygląd każdego z paneli (oprócz repeatCyclePanel, który wywoływany jest w razie potrzeby w toku gry)
        menuGUI(); 
        startGUI(); 
        newGameGUI(); 
        introductionGUI(game); 
        nameQuizGUI(game); 
        connectDotsGUI(game); 
        astroInfoGUI(game); 
        astroQuizGUI(game); 
        chooseLevelGUI(); 
        instructionGUI(); 
        quitGUI();
        endGameGUI(game); 
    }
     /**
      * funkcja tworząca przycisk JButton o określonym wyglądzie zgodnym ze stylistyką gry
      * @param text
      * @return 
      */
     private static JButton createButton(String text) { 
        JButton button = new JButton(text);
        button.setFont(new java.awt.Font("Courier", 0, 16));
        button.setOpaque(true);
        button.setBorder(null);
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        button.setMaximumSize(new Dimension(170,70));
        return button;
      }
     /**
      * GUI dla menu (pasek po lewej stronie)
      */
    public void menuGUI(){ 
         
         
        JButton newGame = createButton("ROZPOCZNIJ GRĘ");
        JButton chooseLevel = createButton("WYBIERZ POZIOM");
        JButton instruction = createButton("INSTRUKCJA");
        JButton quit = createButton("WYJDŹ Z GRY");
        
        menuPanel.setPreferredSize(new java.awt.Dimension(200,100)); 
        
        newGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameActionPerformed(e); //funkcja umieszczająca na wierzchu panel nowej gry z układu CardLayout
            }
        });
        
        chooseLevel.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseLevelActionPerformed(e);//funkcja umieszczająca na wierzchu panel wyboru poziomu z układu CardLayout
            }
        });
        
        
        instruction.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructionActionPerformed(e);//funkcja umieszczająca na wierzchu panel instrukcji z układu CardLayout
            }
        });
        
        
        quit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitActionPerformed(e);//funkcja umieszczająca na wierzchu panel wyjścia z gry z układu CardLayout
            }
        });
        menuPanel.setBackground(Color.BLACK);
        menuPanel.setLayout(new BoxLayout(menuPanel,BoxLayout.Y_AXIS)); //układ BoxLayout umieszczający elementy w kolumnie wertykalnej, jeden pod drugim
        menuPanel.add(Box.createRigidArea(new Dimension(10, 15)));
        level.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(level); //JLabel z grafiką reprezentującą obecny poziom gry
        life.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(Box.createRigidArea(new Dimension(30, 70)));
        menuPanel.add(life); //JLabel z sercami reprezentującymi obecny poziom "życia"
        menuPanel.add(Box.createRigidArea(new Dimension(30, 70)));
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(newGame);
        menuPanel.add(Box.createRigidArea(new Dimension(20, 30)));
        chooseLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(chooseLevel);
        menuPanel.add(Box.createRigidArea(new Dimension(20, 30)));
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(instruction);
        menuPanel.add(Box.createRigidArea(new Dimension(20, 30)));
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(quit);     
        menuPanel.add(Box.createRigidArea(new Dimension(20, 50)));
        pack(); 
    }
    /**
     * GUI panelu prawego po uruchomieniu programu
     * jest to panel wyjściowy w grze, zawierający tytuł gry i kosmiczną grafikę
     */
    public void startGUI(){
        ImageIcon iconLogo= new ImageIcon("telescope.png");//ustaw teleskop w miejscu w którym następnie pojawi się symbol poziomu gry 
        level.setIcon(iconLogo); 
        JLabel label=new JLabel();
        welcomePanel.setLayout(new GridLayout(1,1));
        welcomePanel.add(label);
        welcomePanel.getPreferredSize(); 
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("nebula-kopia.jpg").getImage().getScaledInstance(welcomePanel.getWidth(), welcomePanel.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(imageIcon);
    }
    /**
     * GUI panelu wprowadzenia do nowej gry
     */
     
    public void newGameGUI(){
    
       
        JTextArea intro = new JTextArea(10, 45); //TextArea zawierający wstępne słowa do użytkownika przed rozpoczęciem nowej gry
        intro.append("Użytkowniku!\n\nTradycja łączenia gwiazd w kształty zwane\nasteryzmami sięga czasów starożytnych.\nPrzed Tobą gra która nauczy Cię rozpoznawaniasześciu z nich.\n\nBądź uważny.\n\nPowodzenia!");
        Font font = new Font("Courier", Font.ITALIC+ Font.BOLD, 20); 
        intro.setFont(font);
        intro.setForeground(Color.BLACK);
        intro.setLineWrap(true);
        intro.setOpaque(false);
        intro.setBackground(new Color(0,0,0,0));
        JScrollPane scrollPane = new JScrollPane(intro); 
        scrollPane.getViewport().setOpaque(false); 
        scrollPane.setOpaque(false);
        intro.setEditable(false);
        JLabel newgame= new JLabel(); 
        newgame.setText("Czy jesteś gotowy?"); 
        newgame.setFont(font); 
        JButton yes = createButton("TAK");
        yes.setMaximumSize(new Dimension(80,80));
        JButton no = createButton("NIE");
        yes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                ImageIcon baby= new ImageIcon("baby.png");//ustawienie ikony poziomu gry na początkującą
                level.setIcon(baby); 
                ImageIcon heart3= new ImageIcon("3hearts.png");//ustawienie żyć na 3
                life.setIcon(heart3); 
                game.currentLevel=0; //Level początkujący
                game.getCurrentLevel().currentCycle=0; //cykl zerowy
                //zerowanie wszystkich parametrów globalnych związanych z etapem łączenia gwiazd
                boolean changed=false; 
                connectedNumber1=0;
                connectedNumber2=0;
                connect1=0; 
                connect2=0; 
                connected1=false; 
                connected2=false; 
                buttons1.clear();
                buttons2.clear();
                clonedList1.clear();
                toConnect1.clear();
                clonedList2.clear();
                toConnect2.clear();
                clearLines();
                connectDotsPanel.removeAll();
                connectDotsGUI(game);
                game.changeIcon();
                //wyczyszczenie paneli i załadowanie ich wyglądu na nowo z parametrami zerowymi gry
                introductionPanel.removeAll();
                nameQuizPanel.removeAll();
                astrologyInfoPanel.removeAll();
                astrologyQuizPanel.removeAll();
                introductionGUI(game); 
                nameQuizGUI(game); 
                astroInfoGUI(game); 
                astroQuizGUI(game); 
                introActionPerformed(e); //przejście do panelu wprowadzenia gry
                
            }
        });
        
        no.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeActionPerformed(e);//powrót do panelu tytułowego (wyjśiowego)
            }
        });
        
        no.setMaximumSize(new Dimension(80,80));
        newGamePanel.setLayout(new GridBagLayout()); //układ GridBag pozwalający na dowolne ustawienie elementów na Panelu 
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=2; 
        c.ipady=40; 
        c.insets = new Insets(0,0,30,0);
        newGamePanel.add(intro, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.ipadx=40; 
        c.gridy = 1;
        c.gridwidth=1; 
        newGamePanel.add(newgame, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth=1; 
        c.insets = new Insets(0,0,0,5);
        newGamePanel.add(yes, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth=1; 
        c.insets = new Insets(0,5,0,0);
        newGamePanel.add(no, c);    
    }
    
  
    /**
     * funkcja tworząca JRadioButton używany następnie w etapie QuizName i AstroQuiz
     * @param text
     * @return 
     */
    private static JRadioButton createJRadioButton(String text) { 
        JRadioButton button = new JRadioButton(text);
        button.setFont(new java.awt.Font("Courier", Font.BOLD, 22));
        return button;
      }
    /**
     * GUI panelu wyboru poziomu zaawansowania
     */
    public void chooseLevelGUI(){

        JLabel chooseLevel= new JLabel(); 
        chooseLevel.setText("WYBIERZ POZIOM GRY"); 
        chooseLevel.setFont(new Font("Courier", Font.BOLD, 25)) ; 
        JRadioButton beginner = createJRadioButton("POCZĄTKUJĄCY"); 
        JRadioButton intermediate = createJRadioButton("<html>ŚREDNIOZAAWANSOWANY</html>");
        JRadioButton advanced = createJRadioButton("ZAAWANSOWANY");
        JButton start= createButton("START");
        ButtonGroup group= new ButtonGroup(); //stworzenie grupy przycisków do wyboru poziomu gry
        group.add(beginner); 
        group.add(intermediate); 
        group.add(advanced);
        beginner.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //ustawienie poziomu początkującego, poziom życia = 3, cyckl zerowy, wynik z cyklu=0, ikona poziomu początkującego
                game.currentLevel=0; 
                game.life=3;
                game.getCurrentLevel().currentCycle=0;
                game.getCurrentCycle().score=0;
                ImageIcon baby= new ImageIcon("baby.png");
                level.setIcon(baby); 
                
            }
        });
        intermediate.addActionListener(new java.awt.event.ActionListener() {//ustawienie poziomu średniozaawansowanego, poziom życia = 3, cyckl zerowy, wynik z cyklu=0, ikona poziomu średniozaawansowanego
            @Override
            public void actionPerformed(ActionEvent e) {
                game.currentLevel=1; 
                game.life=3;
                game.getCurrentLevel().currentCycle=0;
                game.getCurrentCycle().score=0;
                ImageIcon flower= new ImageIcon("flower.png");
                level.setIcon(flower);
               
            }
        });
        advanced.addActionListener(new java.awt.event.ActionListener() {//ustawienie poziomu zaawansowanego, poziom życia = 3, cyckl zerowy, wynik z cyklu=0, ikona poziomu zaawansowanego
            @Override
            public void actionPerformed(ActionEvent e) {
                game.currentLevel=2; 
                game.life=3;
                game.getCurrentLevel().currentCycle=0;
                game.getCurrentCycle().score=0;
                ImageIcon einstein= new ImageIcon("einstein.png");
                level.setIcon(einstein);   
            }
        });
        start.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //start gry na wybranym poziomie
                connectedNumber1=0;
                connectedNumber2=0;
                connect1=0; 
                connect2=0; 
                connected1=false; 
                connected2=false; 
                buttons1.clear();
                buttons2.clear();
                clonedList1.clear();
                toConnect1.clear();
                clonedList2.clear();
                clearLines();
                game.changeheart();
                connectDotsPanel.removeAll();//wyczyszczenie panelu łączenia gwiazd
                connectDotsGUI(game);//powtórne zbudowanie panelu łącznia gwiazd
                introductionPanel.removeAll();//wyczyszczenie panelu wprowadzenia
                nameQuizPanel.removeAll();//wyczyszczenie panelu quizu nazw
                astrologyInfoPanel.removeAll();//wyczyszczenie panelu informacyjnego do quizu wiedzy
                astrologyQuizPanel.removeAll();//wyczyszczenie panelu quizu wiedzy
                introductionGUI(game); //powtórne zbudowanie panelu wprowadzenia
                nameQuizGUI(game); //powtórne zbudowanie panelu quizu nazw
                astroInfoGUI(game); //powtórne zbudowanie panelu informacyjnego do quizu wiedzy
                astroQuizGUI(game); //powtórne zbudowanie panelu quizu wiedzy
                introActionPerformed(e);
            }
        });
        chooseLevelPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth=3; 
        c.ipady=40; 
        c.insets = new Insets(0,0,30,0);
        chooseLevelPanel.add(chooseLevel, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.ipadx=40; 
        c.gridy = 1;
        c.gridwidth=1; 
        chooseLevelPanel.add(beginner, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth=1; 
        chooseLevelPanel.add(intermediate, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth=1; 
        chooseLevelPanel.add(advanced, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  
        c.gridx = 2;
        c.gridy = 2;
        c.ipadx=0; 
        c.ipady=30; 
        c.gridwidth=1; 
        chooseLevelPanel.add(start, c);
    }
    
   /**
    * GUI wprowadzenia (pierwszy etap każdego cyklu)
    * @param game 
    */
    public void introductionGUI(Game game) {
        //panel zawierający schematy dwóch konsteacji dla danego poziomu oraz ich nazwy
        Font font = new Font("Courier",Font.BOLD, 27);  
        JLabel explanation = new JLabel(); 
        explanation.setText(" WPROWADZENIE : UKŁAD GWIAZD ");
        explanation.setFont(font); 
        explanation.setBackground(Color.black);
        explanation.setForeground(Color.white);
        explanation.setOpaque(true);
        JLabel constelation1 = new JLabel(); 
        ImageIcon pic1= new ImageIcon(game.getCurrentCycle().constelation1.pictureName); //pobranie obrazu dla danej konstelacji
        constelation1.setIcon(pic1); 
        JLabel name1 = new JLabel(); 
        name1.setText(" "+game.getCurrentCycle().constelation1.name+" "); //wprowadzenie nazwy konstelacji do JLabel
        name1.setFont(new Font("Courier", Font.BOLD, 25)); 
        name1.setForeground(Color.WHITE);
        name1.setBackground(Color.RED);
        name1.setHorizontalAlignment(SwingConstants.CENTER);
        name1.setVerticalAlignment(SwingConstants.CENTER);
        name1.setOpaque(true);
        
        JLabel constelation2 = new JLabel(); 
        ImageIcon pic2= new ImageIcon(game.getCurrentCycle().constelation2.pictureName);//pobranie obrazu dla drugiej konstelacji
        constelation2.setIcon(pic2); 
        JLabel name2 = new JLabel(); 
        name2.setText(" "+game.getCurrentCycle().constelation2.name+" ");//wprowadzenie nazwy drugiej konstelacji do JLabel
        name2.setFont(new Font("Courier", Font.BOLD, 25)); 
        name2.setForeground(Color.WHITE);
        name2.setBackground(Color.RED);
        name2.setHorizontalAlignment(SwingConstants.CENTER);
        name2.setVerticalAlignment(SwingConstants.CENTER);
        name2.setOpaque(true);
        JButton endGame= createButton("ZAKOŃCZ GRĘ"); 
         
        endGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGamePanel.removeAll(); //wyczyszczenie i ponowne załadowanie panelu endGamePanel z parametrem Game game, przechowującym info o punktach, obecnym poziomie i cyklu
                endGameGUI(game);
                endGameActionPerformed(e);
            }
        });
        JButton next= createButton("DALEJ"); 
         
        next.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizNameActionPerformed(e); //wywołanie na wierzch panelu z quize, nazw 
            }
        });
        introductionPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=2; 
        c.insets = new Insets(30,0,0,10); 
        introductionPanel.add(explanation, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=1; 
        introductionPanel.add(constelation1, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth=1; 
        c.insets = new Insets(0,20,0,0); 
        introductionPanel.add(name1, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth=1; 
        c.insets = new Insets(10,0,0,0);  
        introductionPanel.add(constelation2, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth=1; 
        c.insets = new Insets(0,20,0,0); 
        introductionPanel.add(name2, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,20,0,0);  
        c.gridx = 1;
        c.gridy = 3;
        c.ipadx=30; 
        c.ipady=30; 
        c.gridwidth=1; 
        introductionPanel.add(next, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,5,0,0);  
        c.gridx = 2;
        c.gridy = 3;
        c.ipadx=30; 
        c.ipady=30; 
        c.gridwidth=1; 
        introductionPanel.add(endGame, c);
        
        
    }
    /**
     * GUI panelu z quizem nazw
     * @param game 
     */
    public void nameQuizGUI(Game game){
        Font font = new Font("Courier",Font.BOLD, 27);  
        JLabel explanation = new JLabel(); 
        explanation.setText(" PRZYPORZĄDKUJ ODPOWIEDNIE NAZWY ");
        explanation.setFont(font); 
        explanation.setBackground(Color.black);
        explanation.setForeground(Color.white);
        explanation.setOpaque(true);
        JLabel constelation1 = new JLabel(); 
        ImageIcon pic1= new ImageIcon(game.getCurrentCycle().constelation1.pictureName);
        constelation1.setIcon(pic1); 
        String [] constelationStrings = {"orion", "cassiopeia", "cepheus", "leo", "cancer","libra", "taurus"}; 
        JComboBox constelation1Names = new JComboBox(constelationStrings); //ComboBox zawierający możliwe do wyboru nazwy
        constelation1Names.setFont(new Font("Courier", Font.BOLD, 20)); 
        
        constelation1Names.setSelectedIndex(0);
        constelation1Names.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource(); //pobierz źródło kliknięcia w ComboBoxie
                String constelation1Name = (String)cb.getSelectedItem(); //rzutowanie na klasę String
                if (constelation1Name==game.getCurrentCycle().constelation1.name) { //jeżeli odpowiedź jest zgodna z nazwą pierwszej konstelacji - przyznaj 2 punkty w tym cyklu
                    game.getCurrentCycle().score +=2; 
                } 
        
            }
        });
        JLabel constelation2 = new JLabel(); 
        ImageIcon pic2= new ImageIcon(game.getCurrentCycle().constelation2.pictureName);
        constelation2.setIcon(pic2); 
        JComboBox constelation2Names = new JComboBox(constelationStrings);
        constelation2Names.setFont(new Font("Courier",Font.BOLD, 20)); 
        constelation2Names.setSelectedIndex(0);
        constelation2Names.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String constelation2Name = (String)cb.getSelectedItem();
                if (constelation2Name==game.getCurrentCycle().constelation2.name) {//jeżeli odpowiedź jest zgodna z nazwą drugiej konstelacji - przyznaj 2 punkty w tym cyklu
                    game.getCurrentCycle().score+=2; 
                } 
        
            }
        });
        
        
        JButton endGame= createButton("ZAKOŃCZ GRĘ"); 
         
        endGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGamePanel.removeAll();
                endGameGUI(game);
                endGameActionPerformed(e);
            }
        });
        JButton next= createButton("DALEJ"); 
         
        next.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dotsActionPerformed(e); //umieść na wierzchu panel łączenia gwiazd w konstelacje
            }
        });
        nameQuizPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=2; 
        c.insets = new Insets(30,0,0,10); 
        nameQuizPanel.add(explanation, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=1; 
        nameQuizPanel.add(constelation1, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth=1; 
        c.insets = new Insets(0,30,0,0);
        nameQuizPanel.add(constelation1Names, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth=1; 
        c.insets = new Insets(10,0,0,0);
        nameQuizPanel.add(constelation2, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth=1; 
        c.insets = new Insets(0,30,0,0);
        nameQuizPanel.add(constelation2Names, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END; 
        c.insets = new Insets(10,30,0,0);  
        c.gridx = 1;
        c.gridy = 3;
        c.ipadx=30; 
        c.ipady=30; 
        c.gridwidth=1; 
        nameQuizPanel.add(next, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END; 
        c.insets = new Insets(10,5,0,0);  
        c.gridx = 2;
        c.gridy = 3;
        c.ipadx=30; 
        c.ipady=30; 
        c.gridwidth=1; 
        nameQuizPanel.add(endGame, c);
    }
    /**
     * klasa zawierająca obiekty typu Linia : 
     * a więc współrzędne x, y punktu początkowego i x,y 
     * końcowego linii oraz jej kolor
     */
    public static class Line{ 
    final int x1; 
    final int y1;
    final int x2;
    final int y2;   
    final Color color;

        public Line(int x1, int y1, int x2, int y2, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
        }               
    }
    /**lista linii (aby poprzednio narysowana linia nie znikała po wyrysuwaniu linii następnej)*/
    public static LinkedList<Line> lines = new LinkedList<Line>();
    /**
     * funkcja pierwsza addLine wywołująca drugą funkcję addLine dodającą linię koloru niebieskiego 
     * @param x1
     * @param x2
     * @param x3
     * @param x4 
     */
    public void addLine(int x1, int x2, int x3, int x4) { 
        addLine(x1, x2, x3, x4, Color.blue);
    }
    /**
     * funkcja druga dodająca funkcję o dowolnym kolorze wprowadzanym jako parametr
     * @param x1
     * @param x2
     * @param x3
     * @param x4
     * @param color 
     */
    public void addLine(int x1, int x2, int x3, int x4, Color color) { 
        lines.add(new Line(x1,x2,x3,x4, color));        
        connectDotsPanel.repaint(); //wyrysuj ponownie panel, po dodaniu linii do listy lines
    }
    /**
     * funkcja zwracająca losową liczbę całkowitą w zakresie od 0 do parametru int upperRange z którym wywoływana jest ta funkcja
     * @param upperRange
     * @return 
     */
    public static int generateRandomInt(int upperRange){ 
        Random random= new Random(); 
        return random.nextInt(upperRange);
    }
    /**
     * funkcja usuwająca linie z listy lines i ponownie rysująca panel connectDotsPanel
     */
    public void clearLines() { 
        lines.clear();
        connectDotsPanel.repaint();
    }
    /**
     * funkcja rysująca połączenia między gwiazdami wykonywane przez komputer 
     * @param game 
     */
    public void drawConstelations(Game game){ 
        int erased=0; 
        switch (game.currentLevel) { //w zależności od poziomu gry zmienna errased ma inną wartość a więc użytkownik na poziomie początkującym zastanie 2 brakujące połączenia, na poziomie średniozaawansowanym 3 itd. ; brakujące połączenia należy wykonać
            case 0:
                erased=2;
                break;
            case 1:
                erased=3;
                break;
            case 2: 
                erased=4;
                break;
            default:
                break;
        }
       

        clonedList1.addAll(game.getCurrentCycle().constelation1.connections); //skopiowanie listy połączeń dla pierwszej konstelacji w celu jej dalszej edycji bez zmian w oryginalnych danych

        for(int i =0 ; i<erased; i++){ //powtarzaj tyle razy ile połączeń ma zostać usuniętych (niewyrysowanych)
            if (clonedList1.size()!=1){ //jeżeli rozmiar skopiowanej listy połączeń nie wynosi 1 (po którymś z powtórzeń pętli może się tak zdarzyć)
                int r=generateRandomInt(clonedList1.size()-1); //wygeneruj indeks od 0 do size-1 dla skopiowanej listy połaczeń
                toConnect1.add(clonedList1.get(r)); //dodaj połączenie o indeksie wygenerowanym przez funkcję generateRandomInt do listy połączeń toConnect1, które muszą zostać wykonane przez gracza
                clonedList1.remove(r);  //usuń połączenie o indeksie wygenerowanym przez funkcję generateRandomInt
            }
            else if(clonedList1.size()==1){ //jeżeli skopiowana lista połączeń przechowuje już tylko jedno połączenie - nie generuj randomowego indeksu
                int r=0; //indeks będzie równy 0 
                toConnect1.add(clonedList1.get(r)); //dodaj połączenie o indeksie 0 do listy połączeń do wykonania
                clonedList1.remove(r);//usuń połączenia ze skopiowanej listy połączeń   
                }
        }
        if (clonedList1 !=null && !clonedList1.isEmpty()){ //jeżeli lista połączeń skopiowanych nie jest pusta i istnieje
            for(Connection connection: clonedList1){ //iteruj po połączeniach które pozostały w skopiwanej liście (już po dokonanych manipulacjach)
                addLine(connection.point1.x+20,connection.point1.y+20,connection.point2.x+20,connection.point2.y+20); //wyrysuj wygenerowane połączenia pomiędzy gwiazdami (punktami)
            }
        }
        clonedList2.addAll(game.getCurrentCycle().constelation2.connections);//skopiowanie listy połączeń dla drugiej konstelacji w celu jej dalszej edycji bez zmian w oryginalnych danych

        for(int i =0 ; i<erased; i++){//powtarzaj tyle razy ile połączeń ma zostać usuniętych (niewyrysowanych)
            if (clonedList2.size()!=1){//jeżeli rozmiar skopiowanej listy połączeń nie wynosi 1 (po którymś z powtórzeń pętli może się tak zdarzyć)
                int r=generateRandomInt(clonedList2.size()-1);//wygeneruj indeks od 0 do size-1 dla skopiowanej listy połaczeń
                toConnect2.add(clonedList2.get(r));//dodaj połączenie o indeksie wygenerowanym przez funkcję generateRandomInt do listy połączeń toConnect2, które muszą zostać wykonane przez gracza
                clonedList2.remove(r); //usuń połączenie o indeksie wygenerowanym przez funkcję generateRandomInt
                }
            else if(clonedList2.size()==1){//jeżeli skopiowana lista połączeń przechowuje już tylko jedno połączenie - nie generuj randomowego indeksu
                int r=0;//indeks będzie równy 0 
                toConnect2.add(clonedList2.get(r));//dodaj połączenie o indeksie 0 do listy połączeń do wykonania
                clonedList2.remove(r);  //usuń połączenia ze skopiowanej listy połączeń      
                }
        }
        if (clonedList1 !=null && !clonedList1.isEmpty()){//jeżeli lista połączeń skopiowanych nie jest pusta i istnieje
            for(Connection connection: clonedList2){//iteruj po połączeniach które pozostały w skopiwanej liście (już po dokonanych manipulacjach)
                addLine(connection.point1.x+20,connection.point1.y+20,connection.point2.x+20,connection.point2.y+20); //wyrysuj wygenerowane połączenia pomiędzy gwiazdami (punktami)
            }
        }
        
    }
    public void checkConnectPoints1(ArrayList<JButton> list){ //funkcja sprawdzająca czy wykonane połączenia dla pierwszej konstelacji są poprawne co do układu i ich ilości

        for (int i=0; i<(list.size()-1);i++){ //iteruj po JButtons z listy wprowadzanej jako parametr przy wywołaniu funkcji checkConnectPoints1
            for (Connection connection : game.getCurrentCycle().constelation1.connections){ //iteruj po połączeniach dla pierwszej konstelacji
                if(list.get(i).equals(connection.point1.star)){ //jeżeli JButton listy buttons1 (list)  o indeksie (i) jest równy puntowi pierwszemu któregoś połączenia z oryginalnej listy połaczeń dla tej konstelacji
                    if(list.get(i+1).equals(connection.point2.star)){ //jeżeli JButton listy buttons1 (list) o indeksie (i+1) jest równy punktowi drugiemu tego samego połączenia z oryginalnej listy połączeń dla tej konstelacji
                        connected1=true; //połączenie jest prawidłowe, występuje w oryginalnej liście połączeń
                        connectedNumber1++;} //zwiększ liczbę poprawnie wykonanego połączenia dla tej konstelacji
                }
                else if(list.get(i).equals(connection.point2.star)){//jeżeli JButton listy buttons1 (list)  o indeksie (i) jest równy puntowi drugiemu któregoś połączenia z oryginalnej listy połaczeń dla tej konstelacji
                    if(list.get(i+1).equals(connection.point1.star)){ //jeżeli JButton listy buttons1 (list) o indeksie (i+1) jest równy punktowi pierwszemu tego samego połączenia z oryginalnej listy połączeń dla tej konstelacji
                        connected1=true;//połączenie jest prawidłowe, występuje w oryginalnej liście połączeń
                        connectedNumber1++;//zwiększ liczbę poprawnie wykonanego połączenia dla tej konstelacji
                    }
                }
            }//w przeciwnym wypadku parametr connected1 pozostaje false
        }
    }
    public void checkConnectPoints2(ArrayList<JButton> list){//funkcja sprawdzająca czy wykonane połączenia dla drugiej konstelacji są poprawne co do układu i ich ilości
        for (int i=0; i<(list.size()-1);i++){//iteruj po JButtons z listy wprowadzanej jako parametr przy wywołaniu funkcji checkConnectPoints2
            for (Connection connection : game.getCurrentCycle().constelation2.connections){//iteruj po JButtons z listy wprowadzanej jako parametr przy wywołaniu funkcji checkConnectPoints2
                if(list.get(i).equals(connection.point1.star)){//jeżeli JButton listy buttons2 (list)  o indeksie (i) jest równy puntowi pierwszemu któregoś połączenia z oryginalnej listy połaczeń dla tej konstelacji
                    if(list.get(i+1).equals(connection.point2.star)){ //jeżeli JButton listy buttons1 (list) o indeksie (i+1) jest równy punktowi drugiemu tego samego połączenia z oryginalnej listy połączeń dla tej konstelacji
                        connected2=true;//połączenie jest prawidłowe, występuje w oryginalnej liście połączeń
                        connectedNumber2++;}//zwiększ liczbę poprawnie wykonanego połączenia dla tej konstelacji
                }
                else if(list.get(i).equals(connection.point2.star)){//jeżeli JButton listy buttons2 (list)  o indeksie (i) jest równy puntowi drugiemu któregoś połączenia z oryginalnej listy połaczeń dla tej konstelacji
                    if(list.get(i+1).equals(connection.point1.star)){//jeżeli JButton listy buttons2 (list) o indeksie (i+1) jest równy punktowi pierwszemu tego samego połączenia z oryginalnej listy połączeń dla tej konstelacji
                        connected2=true;//połączenie jest prawidłowe, występuje w oryginalnej liście połączeń
                        connectedNumber2++;//zwiększ liczbę poprawnie wykonanego połączenia dla tej konstelacji
                    }
                }
            }
        }//w przeciwnym wypadku parametr connected2 pozostaje false
    }
  
   /**
    * GUI uzupełniające Panel connectDotsPanel
    * @param game 
    */
    public void connectDotsGUI(Game game){ 
        connectDotsPanel.setLayout(null);
        
       
        for (int i =0 ; i<game.getCurrentCycle().constelation1.points.size(); i++){ //funkcja wyrysowująca przyciski na Panelu 
            Point p = game.getCurrentCycle().constelation1.points.get(i);
            JButton star_button = new JButton(); 
            ImageIcon starIconBlue= new ImageIcon("star_blue.png"); //ustawienie ikony wyjściowej (niebieska)
            star_button.setIcon(starIconBlue);
            star_button.setMargin(new Insets(0, 0, 0, 0));
            star_button.setBorderPainted(false);
            star_button.setBorder(null);
            star_button.setContentAreaFilled(false);//brak wypełnienia granic buttonu (poza ikoną gwiazdy)
            p.star=star_button;//przypisz JButton star_blue do buttonu star który jest buttonem punktu p 
            p.star.setBounds(p.x, p.y,40,40); //ustaw button na panelu zgodnie ze współrzędnymi x i y oraz ustaw jego wymiary na 40x40
            connectDotsPanel.add(p.star); //dodaj button do panelu 
           
            
            p.star.addMouseListener(new java.awt.event.MouseListener() { //
                @Override
                public void mouseClicked(MouseEvent e) {
                    ImageIcon starIcon= new ImageIcon("star.png"); //po kliknięciu zmień ikonę gwiazdy z niebieskiej na złotą 
                    p.star.setIcon(starIcon); 
                    p.clicked++; //zwiększ zmienną całkowitą, potrzebną do rozróżniania czy przycisk został kliknięty czy odkliknięty 
                    JButton button= new JButton(); //stwórz nowy button
                    button = (JButton)e.getSource(); //przypisz button będący źródłem kliknięcia do nowego buttona "button"
                    buttons1.add(button);//dodaj button do listy klikniętych buttonów buttons1
                    connect1++; //zwiększ zmienną connect1 wskazującą na ilość klikniętych buttonów
                    if((connect1%2)==0)   { //jeśli ilość klikniętych buttonów jest parzysta, wykonaj połączenie 
                        addLine(buttons1.get(connect1-2).getX()+20,buttons1.get(connect1-2).getY()+20, buttons1.get(connect1-1).getX()+20,buttons1.get(connect1-1).getY()+20); //wykonaj połączenie pomiędzy parą buttonów o indeksach (connect1-2) oraz (connect1-1) czyli między dodaną parą
                        buttons1.get(connect1-2).setIcon(starIconBlue); //ustaw ikonę gwiazdy pierwszej z powrotem na niebieską
                        buttons1.get(connect1-1).setIcon(starIconBlue);//ustaw ikonę gwiazdy drugiej z powrotem na niebieską
                        for(Point point :game.getCurrentCycle().constelation1.points){
                            if (point.x==buttons1.get(connect1-2).getX()&&point.y==buttons1.get(connect1-2).getY()){
                                point.clicked=0; //ustaw parametr clicked dla pierwszego punktu na 0 (odkliknięcie)
                            }
                            if (point.x==buttons1.get(connect1-1).getX()&&point.y==buttons1.get(connect1-1).getY()){
                                point.clicked=0; //ustaw parametr clicked dla drugiego punktu na 0 (odkliknięcie)
                            }
                        }
                          
                    } 
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                   ImageIcon starIcon= new ImageIcon("star.png");//ustaw ikonę gwiazdy na złotą po wjechaniu myszką w jej obszar
                   p.star.setIcon(starIcon);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                   if((p.clicked%2)==0){
                        ImageIcon starIcon= new ImageIcon("star_blue.png");//ustaw ikonę gwiazdy z powrotem na niebieską przy wyjechaniu myszką poza jej obszar
                        p.star.setIcon(starIcon);
                   }
                }
            });
        
        
        }   //analogiczne funkcje dla drugiej konstelacji
            for (int i =0 ; i<game.getCurrentCycle().constelation2.points.size(); i++){
            Point p = game.getCurrentCycle().constelation2.points.get(i);
            JButton star_button = new JButton(); 
            ImageIcon starIconBlue= new ImageIcon("star_blue.png");
            star_button.setIcon(starIconBlue);
            star_button.setMargin(new Insets(0, 0, 0, 0));
            star_button.setBorderPainted(false);
            star_button.setBorder(null);
            star_button.setContentAreaFilled(false);
            p.star=star_button;
            p.star.setBounds(p.x, p.y,40,40);
            connectDotsPanel.add(p.star);
            p.star.addMouseListener(new java.awt.event.MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ImageIcon starIcon= new ImageIcon("star.png");
                    ImageIcon starIconBlue= new ImageIcon("star_blue.png");
                    p.star.setIcon(starIcon);
                    p.clicked++; 
                    JButton button= new JButton(); 
                    button = (JButton)e.getSource(); 
                    buttons2.add(button);
                    connect2++; 
                    if((connect2%2)==0)   {
                        addLine(buttons2.get(connect2-2).getX()+20,buttons2.get(connect2-2).getY()+20, buttons2.get(connect2-1).getX()+20,buttons2.get(connect2-1).getY()+20); 
                        buttons2.get(connect2-2).setIcon(starIconBlue); 
                        buttons2.get(connect2-1).setIcon(starIconBlue);
                        for(Point point :game.getCurrentCycle().constelation2.points){
                            if (point.x==buttons2.get(connect2-2).getX()&&point.y==buttons2.get(connect2-2).getY()){
                                point.clicked=0; 
                            }
                            if (point.x==buttons2.get(connect2-1).getX()&&point.y==buttons2.get(connect2-1).getY()){
                                point.clicked=0; 
                            }
                        }
                          
                    } 
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                   ImageIcon starIcon= new ImageIcon("star.png");
                   p.star.setIcon(starIcon);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if((p.clicked%2)==0){
                       ImageIcon starIcon= new ImageIcon("star_blue.png");
                       p.star.setIcon(starIcon);
                    }
                }
            });
        }
             
        
        Font font = new Font("Courier",Font.BOLD, 27);  
        JLabel explanation = new JLabel(); 
        explanation.setText("<html>UZUPEŁNIJ BRAKUJĄCE POŁĄCZENIA KLIKAJĄC NA ODPOWIEDNIE PARY GWIAZD</html>");
        explanation.setFont(font); 
        explanation.setBounds(20,20, 800, 70);
        JLabel name1 = new JLabel(); 
        name1.setText(game.getCurrentCycle().constelation1.name);
        name1.setFont(font); 
        name1.setBounds(580,230, 200, 40);
        JLabel arrow1 = new JLabel(); 
        ImageIcon pic1= new ImageIcon("arrow_left.png");
        arrow1.setIcon(pic1); 
        arrow1.setBounds(510,230,260,100);
        JLabel name2 = new JLabel(); 
        name2.setText(game.getCurrentCycle().constelation2.name);
        name2.setFont(font); 
        name2.setBounds(75,560, 200, 40);
        JLabel arrow2 = new JLabel(); 
        ImageIcon pic2= new ImageIcon("arrow_right.png");
        arrow2.setIcon(pic2); 
        arrow2.setBounds(40,565,260,100);
        
        JButton next= createButton("DALEJ"); 
         
        next.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                astroInfoActionPerformed(e);
                checkConnectPoints1(buttons1);//sprawdzenie poprawnego wykonania połączeń dla pierwszej konstelacji
                checkConnectPoints2(buttons2);//sprawdzenie poprawnego wykonania połączeń dla drugiej konstelacji
                if(connected1==true && connectedNumber1==(game.currentLevel+2)){
                    game.getCurrentCycle().score+=2; //jeżeli wykonane połączenia zgadzają się z połączeniami dla pierwszej konstelacji oraz ich ilość jest zgodna z wymogami dla konkretnego etapu - dodaj 2 punkty do wyniku z tego cyklu
                }
                if(connected2==true && connectedNumber2==(game.currentLevel+2)){
                    game.getCurrentCycle().score+=2;//jeżeli wykonane połączenia zgadzają się z połączeniami dla drugiej konstelacji oraz ich ilość jest zgodna z wymogami dla konkretnego etapu - dodaj 2 punkty do wyniku z tego cyklu
                } 
                
            }
        });
        next.setBounds(630,700,140,35);
        
    
        connectDotsPanel.add(explanation);
        connectDotsPanel.add(arrow1); 
        connectDotsPanel.add(name1); 
        connectDotsPanel.add(arrow2);
        connectDotsPanel.add(name2); 
        connectDotsPanel.add(next); 
        drawConstelations(game);
        
    
    }
    /**
     * funkcja GUI panelu informacyjnego do quizu wiedzy
     * @param game 
     */
    public void astroInfoGUI(Game game){
        JLabel title = new JLabel(); 
        title.setText("<html> PRZECZYTAJ UWAŻNIE INFORMACJE DOTYCZĄCE KONSTELACJI : " + game.getCurrentLevel().getCurrentCycle().constelation1.name +" ORAZ "+game.getCurrentLevel().getCurrentCycle().constelation2.name+". NASTĘPNIE ROZWIĄŻ QUIZ. POWODZENIA! </html>");
        title.setFont(new Font("Courier", Font.BOLD, 20)); 
        title.setForeground(Color.WHITE);
        title.setBackground(Color.BLACK);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setOpaque(true);
        JTextArea constelation1 = new JTextArea();
        constelation1.setSize(300, 300);
        Font font = new Font("Courier", Font.ITALIC+ Font.BOLD, 20); 
        constelation1.setFont(font);
        constelation1.setForeground(Color.BLACK);
        constelation1.setLineWrap(true); //zawijaj tekst w oknie tekstowym
        constelation1.setWrapStyleWord(true);
        constelation1.setOpaque(false);
        constelation1.setBackground(Color.WHITE);
        JScrollPane scrollPane1 = new JScrollPane(constelation1); 
        scrollPane1.getViewport().setOpaque(false); 
        scrollPane1.setOpaque(false);
        constelation1.setEditable(false);
        Reading constelationInfo1 = new Reading(game.getCurrentLevel().getCurrentCycle().constelation1.description, constelation1); //wczytaj tekst z odpowiedniego pliku dla pierwszej konstelacji
        try {
            constelationInfo1.read(constelation1);
        } catch (IOException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        constelation1.setSelectionStart(0);
        constelation1.setSelectionEnd(0);
        JTextArea constelation2 = new JTextArea(); 
        constelation2.setSize(300, 300);
        constelation2.setFont(font);
        constelation2.setForeground(Color.BLACK);
        constelation2.setLineWrap(true);
        constelation2.setWrapStyleWord(true);
        constelation2.setOpaque(true);
        constelation2.setBackground(Color.WHITE);
        JScrollPane scrollPane2 = new JScrollPane(constelation2); 
        scrollPane2.getViewport().setOpaque(false); 
        scrollPane2.setOpaque(false);
        constelation2.setEditable(false);
        Reading constelationInfo2 = new Reading(game.getCurrentLevel().getCurrentCycle().constelation2.description, constelation2);//wczytaj tekst z odpowiedniego pliku dla drugiej konstelacji 
        try {
            constelationInfo2.read(constelation2);
        } catch (IOException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        constelation2.setSelectionStart(0);
        constelation2.setSelectionEnd(0);
        JButton endGame= createButton("ZAKOŃCZ GRĘ"); 
        endGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGamePanel.removeAll();
                endGameGUI(game);
                endGameActionPerformed(e);
            }
        });
        JButton next= createButton("DALEJ"); 
         
        next.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                astroQuizPerformed(e); 
            }
        });
        astrologyInfoPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=2; 
        c.weightx = 1;
        c.weighty = 1;
        c.ipadx=200;
        c.insets = new Insets(10,20,0,30);  
        astrologyInfoPanel.add(title, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=2; 
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(10,20,0,20);  
        c.ipady=200; 
        astrologyInfoPanel.add(scrollPane1, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.ipady=200; 
        c.gridy = 2;
        c.gridwidth=2; 
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(10,20,0,20);  
        astrologyInfoPanel.add(scrollPane2, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(20,20,30,10);  
        c.ipady=20;
        c.ipadx=100; 
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth=1; 
        astrologyInfoPanel.add(endGame, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END; 
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 1;
        c.gridy = 3;
        c.ipadx=100; 
        c.ipady=20; 
        c.gridwidth=1; 
        c.insets = new Insets(20,0,30,20); 
        astrologyInfoPanel.add(next, c);
        
    }
    /**
     * funkcja tworząca GUI dla quizu wiedzy
     * @param game 
     */
    public void astroQuizGUI(Game game){
        Font font = new Font("Courier", Font.BOLD, 20);
        Font font2 = new Font("Courier", Font.BOLD, 16);
        JLabel question1 = new JLabel(); 
        question1.setText(" " +game.getCurrentCycle().constelation1.questions.get(game.currentLevel).question+" ");//wypisanie pytania danej konstelacji dla tego poziomu
        question1.setFont(font); 
        question1.setBackground(Color.BLACK);
        question1.setForeground(Color.WHITE);
        question1.setOpaque(true); 
        JRadioButton answer1= new JRadioButton(game.getCurrentCycle().constelation1.questions.get(game.currentLevel).answers[0]); //stwórz JRadioButton zawierający pierwszą możliwą odpowiedź na pytanie z listy questions o indeksie równym poziomowi gry 
        JRadioButton answer2= new JRadioButton(game.getCurrentCycle().constelation1.questions.get(game.currentLevel).answers[1]); //stwórz JRadioButton zawierający drugą możliwą odpowiedź na pytanie z listy questions o indeksie równym poziomowi gry 
        JRadioButton answer3= new JRadioButton(game.getCurrentCycle().constelation1.questions.get(game.currentLevel).answers[2]); //stwórz JRadioButton zawierający trzecią możliwą odpowiedź na pytanie z listy questions o indeksie równym poziomowi gry 
        answer1.setFont(font2);
        answer1.setBackground(Color.WHITE);
        answer1.setForeground(Color.BLACK);
        answer1.setOpaque(true); 
        answer2.setFont(font2);
        answer2.setBackground(Color.WHITE);
        answer2.setForeground(Color.BLACK);
        answer2.setOpaque(true); 
        answer3.setFont(font2);
        answer3.setBackground(Color.WHITE);
        answer3.setForeground(Color.BLACK);
        answer3.setOpaque(true); 
        
        ButtonGroup group1 = new ButtonGroup(); 
        group1.add(answer1); //dodanie odpowiedzi do grupy przycisków
        group1.add(answer2);
        group1.add(answer3);
        
        answer1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource(); //rzutowanie źródła ActionEvent na klasę JRadioButton
                if (button.getText().equals(game.getCurrentCycle().constelation1.questions.get(game.currentLevel).answers[game.getCurrentCycle().constelation1.questions.get(game.currentLevel).correctAnswer])){
                    game.getCurrentCycle().score+=2; //jeżeli źródło przyciśnięcia w quizie posiada tekst równy prawidłowej odpowiedzi dla tego pytania danej konstelacji, to dodaj 2 punkty
                }
        
            }
        });
        answer2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();//rzutowanie źródła ActionEvent na klasę JRadioButton
                if (button.getText().equals(game.getCurrentCycle().constelation1.questions.get(game.currentLevel).answers[game.getCurrentCycle().constelation1.questions.get(game.currentLevel).correctAnswer])){
                    game.getCurrentCycle().score+=2; //jeżeli źródło przyciśnięcia w quizie posiada tekst równy prawidłowej odpowiedzi dla tego pytania danej konstelacji, to dodaj 2 punkty
                }
        
            }
        });
        answer3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();//rzutowanie źródła ActionEvent na klasę JRadioButton
                if (button.getText().equals(game.getCurrentCycle().constelation1.questions.get(game.currentLevel).answers[game.getCurrentCycle().constelation1.questions.get(game.currentLevel).correctAnswer])){
                    game.getCurrentCycle().score+=2; //jeżeli źródło przyciśnięcia w quizie posiada tekst równy prawidłowej odpowiedzi dla tego pytania danej konstelacji, to dodaj 2 punkty
                }
        
            }
        });
        
        JLabel question2 = new JLabel(); 
        question2.setText(" "+game.getCurrentCycle().constelation2.questions.get(game.currentLevel).question+" "); //wypisanie pytania danej konstelacji dla tego poziomu
        question2.setFont(font); 
        question2.setBackground(Color.BLACK);
        question2.setForeground(Color.WHITE);
        question2.setOpaque(true); 
        JRadioButton answer1_2= new JRadioButton(game.getCurrentCycle().constelation2.questions.get(game.currentLevel).answers[0]); 
        JRadioButton answer2_2= new JRadioButton(game.getCurrentCycle().constelation2.questions.get(game.currentLevel).answers[1]); 
        JRadioButton answer3_2= new JRadioButton(game.getCurrentCycle().constelation2.questions.get(game.currentLevel).answers[2]);
        answer1_2.setFont(font2);
        answer1_2.setBackground(Color.WHITE);
        answer1_2.setForeground(Color.BLACK);
        answer1_2.setOpaque(true); 
        answer2_2.setFont(font2);
        answer2_2.setBackground(Color.WHITE);
        answer2_2.setForeground(Color.BLACK);
        answer2_2.setOpaque(true); 
        answer3_2.setFont(font2);
        answer3_2.setBackground(Color.WHITE);
        answer3_2.setForeground(Color.BLACK);
        answer3_2.setOpaque(true); 
        ButtonGroup group2 = new ButtonGroup(); 
        group2.add(answer1_2); 
        group2.add(answer2_2);
        group2.add(answer3_2);
        answer1_2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();//rzutowanie źródła ActionEvent na klasę JRadioButton
                if (button.getText().equals(game.getCurrentCycle().constelation2.questions.get(game.currentLevel).answers[game.getCurrentCycle().constelation2.questions.get(game.currentLevel).correctAnswer])){
                    game.getCurrentCycle().score+=2; //jeżeli źródło przyciśnięcia w quizie posiada tekst równy prawidłowej odpowiedzi dla tego pytania danej konstelacji, to dodaj 2 punkty
                }
        
            }
        });
        answer2_2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();//rzutowanie źródła ActionEvent na klasę JRadioButton
                if (button.getText().equals(game.getCurrentCycle().constelation2.questions.get(game.currentLevel).answers[game.getCurrentCycle().constelation2.questions.get(game.currentLevel).correctAnswer])){
                    game.getCurrentCycle().score+=2; //jeżeli źródło przyciśnięcia w quizie posiada tekst równy prawidłowej odpowiedzi dla tego pytania danej konstelacji, to dodaj 2 punkty
                }
        
            }
        });
        answer3_2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();//rzutowanie źródła ActionEvent na klasę JRadioButton
                if (button.getText().equals(game.getCurrentCycle().constelation2.questions.get(game.currentLevel).answers[game.getCurrentCycle().constelation2.questions.get(game.currentLevel).correctAnswer])){
                    game.getCurrentCycle().score+=2; //jeżeli źródło przyciśnięcia w quizie posiada tekst równy prawidłowej odpowiedzi dla tego pytania danej konstelacji, to dodaj 2 punkty
                }
        
            }
        });
        
        JButton endGame= createButton("ZAKOŃCZ GRĘ"); 
         
        endGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGamePanel.removeAll();
                endGameGUI(game);
                endGameActionPerformed(e);
            }
        });
        astrologyQuizPanel.add(endGame); 
        JButton next= createButton("DALEJ"); 
         
        next.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //kliknięcie przycisku dalej z panelu AstroQuiz będącym ostatnim panelem w cyklu gry spowoduje wywołanie funkcji sprawdzającej punktację i następnie przejście na poziom wyżej, cykl wyżej lub powtórzenie cyklu
                game.checkCyclePoints();//wywołanie funkcji sprawdzającej punktację dla tego cyklu
                //wyzerowanie wartości, z wysokim prawdopodobieństwem zmienionych w trakcie trwania  cyklu
                connectedNumber1=0;
                connectedNumber2=0;
                connect1=0; 
                connect2=0; 
                connected1=false; 
                connected2=false; 
                buttons1.clear();
                buttons2.clear();
                clonedList1.clear();
                toConnect1.clear();
                clonedList2.clear();
                toConnect2.clear();
                clearLines();
                connectDotsPanel.removeAll();//wyczyszczenie panelu łączenia gwiazd
                connectDotsGUI(game);//ponowne wywołanie panelu (ze zmienionymi parametrami game)
                game.changeIcon();//zamiana ikony poziomu zaawansowania
                introductionPanel.removeAll();//wyczyszczenie panelu wprowadzenia
                nameQuizPanel.removeAll();//wyczyszczenie panelu z quizem nazw konstelacji
                astrologyInfoPanel.removeAll();//wyczyszczenie panelu z informacjami do quizu wiedzy
                astrologyQuizPanel.removeAll();//wyczyszczenie panelu z quizem wiedzy
                introductionGUI(game); //ponowne wywołanie funkcji tworzącej wygląd panelu wprowadzenia
                nameQuizGUI(game); //ponowne wywołanie funkcji tworzącej wygląd panelu wprowadzenia
                astroInfoGUI(game); //ponowne wywołanie funkcji tworzącej wygląd panelu informacji do quizu wiedzy
                astroQuizGUI(game); //ponowne wywołanie funkcji tworzącej wygląd panelu quizu wiedzy
                if(game.getCurrentCycle().score>=9 && game.getCurrentLevel().currentCycle==2 && game.currentLevel==2){ //sprawdzenie, czy użytkownik wygrał całą grę
                    winPanel.removeAll();//jeżeli użytkownik wygrał - wyczyść panel winPanel i wczytaj go z aktualnymi parametrami
                    winGUI(game);
                    winActionPerformed(e);//wyświetl panel winPanel
                }else if (game.life==0){//jeżeli użytkownik stracił już wszystkie życia - wyczyść panel defeatPanel i wywołaj go na nowo z nowymi parametrami
                    game.changeheart();//zmień ikony serc (na ikonę braku życia)
                    defeatPanel.removeAll();
                    defeatGUI(game);
                    defeatActionPerformed(e); //pokaż panel przegranej
                }else if (changed==false) {//jeżeli nie nastąpiła zmiana na poziom wyżej lub cykl wyżej
                    game.changeheart();//zmień ikonę serc na aktualną (o jedno serce mniej)
                    repeatCyclePanel.removeAll();//wyczyść panel powtórzenia gry
                    repeatCycleGUI(game);//wywołaj GUI panelu z powtórką gry
                    repeatCycleActionPerformed(e);
                }else introActionPerformed(e); //w przeciwnym wypadku (czyli jeśli użytkownik ani nie wygrał gry, ani jej nie przegrał, ani nie powtarza cyklu) - wczytaj normalnie pierwszy panel gry (wprowadzenie) zawierający kolejne konstelacje
                
            }
        });
        astrologyQuizPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=3; 
        c.insets = new Insets(30,0,0,30);
        astrologyQuizPanel.add(question1, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=1; 
        astrologyQuizPanel.add(answer1, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth=1; 
        astrologyQuizPanel.add(answer2, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space 
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth=1; 
        astrologyQuizPanel.add(answer3, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth=3; 
        astrologyQuizPanel.add(question2, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth=1; 
        astrologyQuizPanel.add(answer1_2, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth=1; 
        astrologyQuizPanel.add(answer2_2, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth=1; 
        astrologyQuizPanel.add(answer3_2, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth=1; 
        c.ipady=20; 
        astrologyQuizPanel.add(next, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space  
        c.gridx = 2;
        c.gridy = 4; 
        c.gridwidth=1; 
        c.ipady=20; 
        astrologyQuizPanel.add(endGame, c);  
    }
    /**
     * funkcja tworząca GUI dla panelu kończącego grę
     * @param game 
     */
    public void endGameGUI(Game game){
        JLabel question= new JLabel("CZY NAPEWNO CHCESZ ZAKOŃCZYĆ GRĘ? "); 
        question.setFont(new Font("Courier", Font.BOLD, 20));
        JLabel info1= new JLabel("OBECNIE WYKONUJESZ CYKL : " + (game.getCurrentLevel().currentCycle+1) + " Z 3 DOSTĘPNYCH NA TYM POZIOMIE "); 
        info1.setFont(new Font("Courier", Font.BOLD, 20));
        JLabel info2= new JLabel("UZYSKAŁEŚ W NIM : " + game.getCurrentCycle().score + " PKT. Z 12 MOŻLIWYCH DO ZDOBYCIA "); 
        info2.setFont(new Font("Courier", Font.BOLD, 20));
        JButton yes= createButton("WYCHODZĘ"); 
         
        yes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeActionPerformed(e); //jeśli użytkownik chce zakończyć grę - powrót do panelu tytułowego gry
            }
        });
        JButton no= createButton("GRAM DALEJ"); 
         
        no.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                introActionPerformed(e);//jeśli użytkownik nie chce zakończyć gry - powrót do panelu pierwszego dla tego cyklu
            }
        });
        endGamePanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=2; 
        c.insets = new Insets(30,0,0,30);
        endGamePanel.add(question, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=2; 
        c.insets = new Insets(30,0,0,30);
        endGamePanel.add(info1, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth=2; 
        c.insets = new Insets(30,0,0,30);
        endGamePanel.add(info2, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth=1; 
        c.ipady=30; 
        c.ipadx=100;
        endGamePanel.add(yes, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth=1; 
        c.ipady=30; 
        c.ipadx=100;
        endGamePanel.add(no, c);    
        
    }
    /**
     * funkcja tworząca GUI dla panelu instrukcji
     */
    public void instructionGUI()  {
        
       
        JTextArea textArea = new JTextArea(20, 55);
        Font font = new Font("Courier", Font.ITALIC+ Font.BOLD, 20); 
        textArea.setFont(font);
        textArea.setForeground(Color.BLACK);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setBackground(new Color(0,0,0,0));
        JScrollPane scrollPane = new JScrollPane(textArea); 
        scrollPane.getViewport().setOpaque(false); 
        scrollPane.setOpaque(false);
        textArea.setEditable(false);
        instructionPanel.add(textArea);
        Reading instruction = new Reading("instrukcja", textArea); //czytanie instrukcji do JTextArea z pliku instrukcja.txt
        try {
            instruction.read(textArea);
        } catch (IOException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        instructionPanel.add(textArea);
    }
    /**
     * funkcja tworząca GUI dla panelu wyjścia z gry
     */

    public void quitGUI(){
        JLabel quitGame= new JLabel(); 
        quitGame.setText("CZY NAPEWNO CHCESZ WYJŚĆ Z GRY ? "); 
        quitGame.setFont(new Font("Courier", Font.ITALIC+ Font.BOLD, 20)) ; 
        JButton yes = createButton("TAK");
        JButton no = createButton("NIE");
        yes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindowPerformed(e);//decyzja o wyjściu z gry powoduje uruchomienie funkcji closeWindowPerformed
            }

            private void closeWindowPerformed(ActionEvent e) {
                System.exit(0); //wyjście z całego programu
            }
        });
        
        no.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                introActionPerformed(e); //przejście do panelu tytułowego
            }
        });
        quitPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=2; 
        c.ipady=20; 
        quitPanel.add(quitGame, c); 
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=2; 
        quitPanel.add(yes, c);
        c.fill= GridBagConstraints.HORIZONTAL; 
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth=2; 
        quitPanel.add(no, c);
        
    }
    
    public void winGUI(Game game){ //panel wygranej
    JLabel infoLabel = new JLabel(); 
    infoLabel.setText("GRATULACJE MISTRZU! WYGRAŁEŚ!");
    infoLabel.setFont(new Font("Courier", Font.BOLD, 25) );
    infoLabel.setForeground(Color.white);
    infoLabel.setBackground(Color.black);
    infoLabel.setOpaque(true);
    JLabel winLabel = new JLabel(); 
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("win.png").getImage()); //wczytanie ikony wygranej (świecąca maszyna)
    winLabel.setIcon(imageIcon);
    JButton again= createButton("GRAM JESZCZE RAZ"); 
         
        again.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //następuje przejście na poziom początkujący 
                 ImageIcon baby= new ImageIcon("baby.png");//ikona poziomu początkującego
                level.setIcon(baby); 
                ImageIcon hearts3= new ImageIcon("3hearts.png");//ikona 3 żyć
                life.setIcon(hearts3); 
                game.currentLevel=0;//poziom początkujący
                game.getCurrentLevel().currentCycle=0;//cykl zerowy
                game.life=3;
                game.getCurrentCycle().score=0;//wynik zerowy
                boolean changed=false; //zerowanie parametrów z dużym prawdopodobieństwem uległych zmianie w czasie działania gry
                connectedNumber1=0;
                connectedNumber2=0;
                connect1=0; 
                connect2=0; 
                connected1=false; 
                connected2=false; 
                buttons1.clear();
                buttons2.clear();
                clonedList1.clear();
                toConnect1.clear();
                clonedList2.clear();
                toConnect2.clear();
                clearLines();
                connectDotsPanel.removeAll();//wyczyszczenie panelu łączenia gwiazd
                connectDotsGUI(game);//powtórne zbudowanie panelu łącznia gwiazd
                introductionPanel.removeAll();//wyczyszczenie panelu wprowadzenia
                nameQuizPanel.removeAll();//wyczyszczenie panelu quizu nazw
                astrologyInfoPanel.removeAll();//wyczyszczenie panelu informacyjnego do quizu wiedzy
                astrologyQuizPanel.removeAll();//wyczyszczenie panelu quizu wiedzy
                introductionGUI(game); //powtórne zbudowanie panelu wprowadzenia
                nameQuizGUI(game); //powtórne zbudowanie panelu quizu nazw
                astroInfoGUI(game); //powtórne zbudowanie panelu informacyjnego do quizu wiedzy
                astroQuizGUI(game); //powtórne zbudowanie panelu quizu wiedzy
                introActionPerformed(e);//wyświetlenie panelu wprowadzenia (pierwszy etap cyklu)
            }
        });
        JButton end= createButton("ZAKOŃCZ GRĘ"); 
         
        end.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeActionPerformed(e);//przejście do panelu tytułowego
            }
        });
        winPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=2; 
        c.ipady=20; 
        winPanel.add(infoLabel, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=2; 
        c.ipady=20; 
        winPanel.add(winLabel, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth=1; 
        c.ipady=20; 
        c.ipadx=80;
        winPanel.add(again, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth=1; 
        c.ipady=20;
        c.ipadx=100;
        winPanel.add(end, c);
}
    /**
     * funkcja tworząca GUI dla panelu przegranej
     * @param game 
     */
    public void defeatGUI(Game game){
        JLabel infoLabel = new JLabel(); 
        infoLabel.setText(" STRACIŁEŚ 3 ŻYCIA. PRZEGRYWASZ! ");
        infoLabel.setFont(new Font("Courier", Font.BOLD, 25) );
        infoLabel.setForeground(Color.white);
        infoLabel.setBackground(Color.black);
        infoLabel.setOpaque(true);
        JLabel infoLabel2 = new JLabel(); 
        infoLabel2.setText(" ALE NIE PODDAWAJ SIĘ! ");
        infoLabel2.setFont(new Font("Courier", Font.BOLD, 25) );
        infoLabel2.setForeground(Color.black);
        infoLabel2.setBackground(Color.white);
        infoLabel2.setOpaque(true);
        JLabel defeatLabel = new JLabel(); 
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("defeat.png").getImage());//ikona przegranej (Ninja)
        defeatLabel.setIcon(imageIcon);
        JButton again= createButton("JESZCZE RAZ"); 
         
        again.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//ponowne ustawienie parametrów poziomu początkującego oraz wyczyszczenie i zbudowanie paneli na nowo (z nowymi parametrami gry)
                ImageIcon baby= new ImageIcon("baby.png");
                level.setIcon(baby); 
                ImageIcon hearts3= new ImageIcon("3hearts.png");
                life.setIcon(hearts3); 
                game.currentLevel=0;
                game.getCurrentLevel().currentCycle=0;
                game.life=3;
                game.getCurrentCycle().score=0;
                boolean changed=false; 
                connectedNumber1=0;
                connectedNumber2=0;
                connect1=0; 
                connect2=0; 
                connected1=false; 
                connected2=false; 
                buttons1.clear();
                buttons2.clear();
                clonedList1.clear();
                toConnect1.clear();
                clonedList2.clear();
                toConnect2.clear();
                clearLines();
                connectDotsPanel.removeAll();
                connectDotsGUI(game);
                introductionPanel.removeAll();
                nameQuizPanel.removeAll();
                astrologyInfoPanel.removeAll();
                astrologyQuizPanel.removeAll();
                introductionGUI(game); 
                nameQuizGUI(game); 
                astroInfoGUI(game); 
                astroQuizGUI(game); 
                introActionPerformed(e);
            }
        });
        JButton end= createButton("ZAKOŃCZ GRĘ"); 
         
        end.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeActionPerformed(e);//przejście do panelu tytułowego
            }
        });
        defeatPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=2; 
        c.ipady=20; 
        defeatPanel.add(infoLabel, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=2; 
        c.ipady=20; 
        defeatPanel.add(infoLabel2, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth=2; 
        c.ipady=20; 
        defeatPanel.add(defeatLabel, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth=1; 
        c.ipady=25; 
        c.ipadx=150;
        defeatPanel.add(again, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth=1; 
        c.ipady=25; 
        defeatPanel.add(end, c);
        
    }
    /**
     * funkcja tworząca GUI dla panelu powtórki cyklu
     * @param game 
     */
    public void repeatCycleGUI(Game game){
        JLabel infoLabel = new JLabel(); 
        infoLabel.setText(" NIE UDAŁO CI SIĘ ZDOBYĆ 9 PUNKTÓW W TYM CYKLU! ");
        infoLabel.setFont(new Font("Courier", Font.BOLD, 19) );
        infoLabel.setForeground(Color.white);
        infoLabel.setBackground(Color.black);
        infoLabel.setOpaque(true);
        JLabel infoLabel2 = new JLabel(); 
        infoLabel2.setText(" TWÓJ WYNIK TO : " + game.getCurrentCycle().score +" pkt. ");//wyświetlenie obecnego wyniku
        infoLabel2.setFont(new Font("Courier", Font.BOLD, 19) );
        infoLabel2.setForeground(Color.white);
        infoLabel2.setBackground(Color.black);
        infoLabel2.setOpaque(true);
        JLabel defeatLabel = new JLabel(); 
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("potato.png").getImage());//smutna ikona ziemniaka
        defeatLabel.setIcon(imageIcon);
        JButton again= createButton("POWTÓRZ CYKL"); 
         
        again.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//powtórka cyklu powoduje częściowe wyzerowanie parametrów gry
                game.getCurrentCycle().score=0; //wynik zerowy
                //zerowanie parametrów związanych z etapem łączenia gwiazd
                connect1=0; 
                connect2=0; 
                connected1=false; 
                connected2=false; 
                buttons1.clear();
                buttons2.clear();
                clonedList1.clear();
                toConnect1.clear();
                clonedList2.clear();
                toConnect2.clear();
                clearLines();
                connectDotsPanel.removeAll();//wyczyszczenie panelu łączenia gwiazd
                connectDotsGUI(game);//ponowne załadowanie panelu łączenia gwiazd
                introActionPerformed(e);//przejście do wprowadzenia (pierwszy etap powtarzanego cyklu)
                
            }
        });
        JButton end= createButton("ZAKOŃCZ GRĘ"); 
         
        end.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeActionPerformed(e);//przejście do panelu tytułowego
            }
        });
        repeatCyclePanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=2; 
        c.ipady=20; 
        repeatCyclePanel.add(infoLabel, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth=2; 
        c.ipady=20; 
        repeatCyclePanel.add(infoLabel2, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth=2; 
        c.ipady=20; 
        c.insets = new Insets(0,50,0,0); 
        repeatCyclePanel.add(defeatLabel, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth=1; 
        c.ipady=25; 
        c.ipadx=150;
        repeatCyclePanel.add(again, c);
        c.fill= GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth=1; 
        c.ipady=25; 
        repeatCyclePanel.add(end, c);
        
    }
    /**
     * przesunięcie na wierzch panelu tytułowego
     * @param e 
     */
    public static void welcomeActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"WELCOME"); 
    }
    /**
     * przesunięcie na wierzch panelu potwierdzenia nowej gry
     * @param e 
     */
    public static void newGameActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"NEW");
    }
    /**
     * przesunięcie na wierzch panelu wprowadzenia 
     * @param e 
     */
    public static void introActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"INTRO");
    }
    /**
     * przesunięcie na wierzch panelu quizu nazw
     * @param e 
     */
    public static void quizNameActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"QUIZ_NAME");
    }
    /**
     * przesunięcie na wierzch panelu łączenia gwiazd
     * @param e 
     */
    public static void dotsActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"DOTS");
    }
    /**
     * przesunięcie na wierzch panelu informacyjnego do quizu wiedzy
     * @param e 
     */
    public static void astroInfoActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"ASTRO_INFO");
    }
    /**
     * przesunięcie na wierzch panelu quizu wiedzy
     * @param e 
     */
    public static void astroQuizPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"ASTRO_QUIZ");
    } 
    /**
     * przesunięcie na wierzch panelu zakończenia gry
     * @param e 
     */
    public static void endGameActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"END_GAME");
    }
    /**
     * przesunięcie na wierzch panelu wyboru poziomu zaawansowania
     * @param e 
     */
    public static void chooseLevelActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"CHOOSE");
    }
    /**
     * przesunięcie na wierzch panelu instrukcji
     * @param e 
     */
    public static void instructionActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"INSTRUCTION");
    }
    /**
     * przesunięcie na wierzch panelu instrukcji
     * @param e 
     */
    public static void quitActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"QUIT");
    }
    /**
     * przesunięcie na wierzch panelu wygranej
     * @param e 
     */
    public static void winActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"WIN");
    }
    /**
     * przesunięcie na wierzch panelu przegranej
     * @param e 
     */
     public static void defeatActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"DEFEAT");
    }
     /**
      * przesunięcie na wierzch panelu powtórki cyklu
      * @param e 
      */
    public static void repeatCycleActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"REPEAT");
    }
    /**
     * pobranie współrzędnych źródła kliknięcia
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        myX=e.getX(); 
        myY=e.getY(); 
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
