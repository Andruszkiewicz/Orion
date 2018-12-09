/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.Model;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


/**
 *
 * @author karolinaandruszkiewicz
 */
public class GameWindow extends JFrame{
 
    public JPanel menuPanel = new JPanel();
    public JPanel welcomePanel = new JPanel(); 
    public JPanel newGamePanel = new JPanel(); 
    public JPanel gamePanel = new JPanel(); 
    public JPanel introductionPanel = new JPanel(); 
    public JPanel nameQuizPanel = new JPanel(); 
    public JPanel connectDotsPanel = new JPanel(); 
    public JPanel astrologyQuizPanel = new JPanel(); 
    public JPanel chooseLevelPanel = new JPanel();
    public JPanel instructionPanel = new JPanel(); 
    public JPanel quitPanel = new JPanel(); 
    static public JPanel cardPanel= new JPanel(); 
    static public CardLayout c1 = new CardLayout(); 
    public CardLayout c2 = new CardLayout(); 
    public Container pane = this.getContentPane();
    private BufferedImage image; 
  
    
    
     public GameWindow (){
        super(); 
        int gameWidth=1024;
        int gameHeight=768;
        //pobierz rozmiar ekranu
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        //oblicz współrzędne narożnika tak, aby pole gry było wyśrodkowane
        int xCenter=(screenWidth-gameWidth)/2;
        int yCenter=(screenHeight-gameHeight)/2;       
        this.setSize(gameWidth, gameHeight); //ustaw wymiary okna
        setLocation(xCenter,yCenter); //ustaw pozycję okna
        //setResizable(false); //zablokuj możliwość zmian rozmiaru okna
        //setUndecorated(true); //ukryj ramkę okna i przyciski kontrolne
        
        menuGUI(); 
        startGUI(); 
        newGameGUI(); 
        chooseLevelGUI(); 
        instructionGUI(); 
        quitGUI(); 
        Orion.Model.Constelation.createConstelations(); //stworzenie 6 konstelacji 
        JSplitPane dividing = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menuPanel, cardPanel); 
        this.pane.add(dividing);
        cardPanel.setLayout(new GridLayout(1,1));
        cardPanel.setLayout(c1);
        cardPanel.add(welcomePanel,"WELCOME"); 
        cardPanel.add(newGamePanel,"NEW"); 
        cardPanel.add(introductionPanel,"INTRO"); 
        cardPanel.add(nameQuizPanel,"GUESSNAME"); 
        cardPanel.add(connectDotsPanel,"DOTS"); 
        cardPanel.add(astrologyQuizPanel,"ASTRO"); 
        cardPanel.add(chooseLevelPanel,"CHOOSE"); 
        cardPanel.add(instructionPanel,"INSTRUCTION"); 
        cardPanel.add(quitPanel,"QUIT"); 
        //pane.add(cardPanel,BorderLayout.CENTER); 
        
        this.pack(); 
        this.setDefaultCloseOperation(3);
    }
    public void menuGUI(){
        JLabel level= new JLabel(); 
        JLabel score= new JLabel(); 
        JButton newGame = new JButton("Rozpocznij grę od nowa");
        JButton chooseLevel = new JButton("Wybierz poziom");
        JButton instruction = new JButton("Instrukcja");
        JButton quit = new JButton("Wyjdź z gry");
        menuPanel.setPreferredSize(new java.awt.Dimension(200,100)); 
        newGame.setFont(new java.awt.Font("Courier", 0, 16));
        newGame.setOpaque(true);
        newGame.setBackground(Color.RED);
        newGame.setForeground(Color.BLUE);
        newGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameActionPerformed(e);
            }
        });
        chooseLevel.setFont(new java.awt.Font("Courier", 0, 16));
        chooseLevel.setOpaque(true);
        chooseLevel.setBackground(Color.RED);
        chooseLevel.setForeground(Color.BLUE);
        chooseLevel.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseLevelActionPerformed(e);
            }
        });
        
        instruction.setFont(new java.awt.Font("Courier", 0, 16));
        instruction.setOpaque(true);
        instruction.setBackground(Color.RED);
        instruction.setForeground(Color.BLUE);
        instruction.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructionActionPerformed(e);
            }
        });
        
        quit.setFont(new java.awt.Font("Courier", 0, 16));
        quit.setOpaque(true);
        quit.setBackground(Color.RED);
        quit.setForeground(Color.BLUE);
        quit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitActionPerformed(e);
            }
        });
        
        menuPanel.setLayout(new GridLayout(6,1,10,10));
        menuPanel.add(level);
        menuPanel.add(score);
        menuPanel.add(newGame);
        menuPanel.add(chooseLevel);
        menuPanel.add(instruction);
        menuPanel.add(quit);      
    }

    public void startGUI(){
        /*try{
            image=ImageIO.read(new File("logo2"));
        } catch(IOException ex){
            //handle exception
        }
        JLabel picLabel= new JLabel(new ImageIcon(image)); 
        welcomePanel.add(picLabel);*/
        ImageIcon icon=new ImageIcon("logo2");
        JLabel label=new JLabel(icon);
        welcomePanel.add(label);
      
    // tutaj jakieś logo gry i kto swtorzył i cel, taki wstęp        
            
           

    }
     
    public void newGameGUI(){
    
        //HALO UŻYTKOWNIKU, CZY CHCESZ ZACZĄĆ GRĘ OD NOWA? 
        JButton yes = new JButton("TAK");
        JButton no = new JButton("NIE");
        yes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                playActionPerformed(e);
            }
        });
        
        no.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeActionPerformed(e);
            }
        });
       
        
       
    }
    
    public void chooseLevelGUI(){

        //JAKI POZIOM GRY WYBIERASZ? 
        
        JButton beginner = new JButton("Początkujący"); 
        JButton intermediate = new JButton("Średniozaawansowany");
        JButton advanced = new JButton("Zaawansowany");
        beginner.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                playActionPerformed(e);
            }
        });
        intermediate.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                playActionPerformed(e);
            }
        });
        advanced.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                playActionPerformed(e);
            }
        });
        
        chooseLevelPanel.add(beginner);
        chooseLevelPanel.add(intermediate);
        chooseLevelPanel.add(advanced);

    }
    
    public void gameGUI(){
        
        
        
        
    
    }

    public void instructionGUI(){
        // CELEM GRY JEST COŚ TAM 

           

    }

    public void quitGUI(){
        //PODSUMOWANIE GRY: TWÓJ POZIOM TO : TWÓJ LEVEL, TO : ; CZY NAPEWNO CHCESZ WYJŚĆ? 
        JButton yes = new JButton("TAK");
        JButton no = new JButton("NIE");
        yes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitActionPerformed(e);
            }
        });
        
        no.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playActionPerformed(e);
            }
        });


        
    }
    
    public static void welcomeActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"WELCOME");
    }
    public static void playActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"PLAY");
    }
    public static void newGameActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"NEW");
    }
    public static void chooseLevelActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"CHOOSE");
    }
    public static void instructionActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"INSTRUCTION");
    }
    public static void quitActionPerformed (java.awt.event.ActionEvent e){
        c1.show(cardPanel,"QUIT");
    }
    
}
