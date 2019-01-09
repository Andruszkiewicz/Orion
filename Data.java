
package Orion.Model;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * klasa Data przechowuje wszystkie informacje o konstelacjach
 * @author karolinaandruszkiewicz
 */

public class Data {
    /**konstelacja cancer*/
    Constelation cancer=new Constelation(); 
    /**konstelacja cassiopeia*/
    Constelation cassiopeia=new Constelation();
    /**konstelacja taurus*/
    Constelation taurus=new Constelation(); 
    /**konstelacja leo*/
    Constelation leo=new Constelation(); 
    /**konstelacja cepheus*/
    Constelation cepheus=new Constelation();
    /**konstelacja libra*/
    Constelation libra=new Constelation(); 
    /**poziom początkujący*/
    public static Level beginner= new Level();  
    /**poziom średniozaawansowany*/
    public static Level intermediate=new Level();
    /**poziom zaawansowany*/
    public static Level advanced=new Level();
    /**cyckl pierwszy*/
    Cycle cycle1=new Cycle(); 
    /**cyckl drugi*/
    Cycle cycle2=new Cycle();
    /**cyckl trzeci*/
    Cycle cycle3=new Cycle();
    /**pytanie nr 1*/
    Question q1=new Question(); 
    /**pytanie nr 2*/
    Question q2=new Question(); 
    /**pytanie nr 3*/
    Question q3=new Question(); 
    /**pytanie nr 4*/
    Question q4=new Question(); 
    /**pytanie nr 5*/
    Question q5=new Question(); 
    /**pytanie nr 6*/
    Question q6=new Question(); 
    /**pytanie nr 7*/
    Question q7=new Question(); 
    /**pytanie nr 8*/
    Question q8=new Question(); 
    /**pytanie nr 9*/
    Question q9=new Question(); 
    /**pytanie nr 10*/
    Question q10=new Question(); 
    /**pytanie nr 11*/
    Question q11=new Question(); 
    /**pytanie nr 12*/
    Question q12=new Question(); 
    /**pytanie nr 13*/
    Question q13=new Question(); 
    /**pytanie nr 14*/
    Question q14=new Question(); 
    /**pytanie nr 15*/
    Question q15=new Question(); 
    /**pytanie nr 16*/
    Question q16=new Question(); 
    /**pytanie nr 17*/
    Question q17=new Question(); 
    /**pytanie nr 18*/
    Question q18=new Question(); 
    /**lista pytań dla konstelacji Cancer*/
    public List<Question> questionsCancer= new ArrayList<Question>();
    /**lista pytań dla konstelacji Cassiopeia*/
    public List<Question> questionsCassiopeia=new ArrayList<Question>(); 
    /**lista pytań dla konstelacji Taurus*/
    public List<Question> questionsTaurus=new ArrayList<Question>();
    /**lista pytań dla konstelacji Leo*/
    public List<Question> questionsLeo=new ArrayList<Question>();
    /**lista pytań dla konstelacji Capheus*/
    public List<Question> questionsCepheus=new ArrayList<Question>();
    /**lista pytań dla konstelacji Libra*/
    public List<Question> questionsLibra=new ArrayList<Question>();
    /**lista punktów (gwiazd) dla konstelacji Cancer*/
    public List<Point>pointsCancer=new ArrayList<Point>(); 
    /**lista połączeń dla konstelacji Cancer*/
    public List<Connection>connectionsCancer=new ArrayList<Connection>(); 
    /**lista punktów (gwiazd) dla konstelacji Cassiopeia*/
    public List<Point>pointsCassiopeia=new ArrayList<Point>(); 
    /**lista połączeń dla konstelacji Cassiopeia*/
    public List<Connection>connectionsCassiopeia=new ArrayList<Connection>(); 
    /**lista punktów (gwiazd) dla konstelacji Taurus*/
    public List<Point>pointsTaurus=new ArrayList<Point>(); 
    /**lista połączeń dla konstelacji Taurus*/
    public List<Connection>connectionsTaurus=new ArrayList<Connection>(); 
    /**lista punktów (gwiazd) dla konstelacji Leo*/
    public List<Point>pointsLeo=new ArrayList<Point>(); 
    /**lista połączeń dla konstelacji Leo*/
    public List<Connection>connectionsLeo=new ArrayList<Connection>(); 
    /**lista punktów (gwiazd) dla konstelacji Cepheus*/
    public List<Point>pointsCepheus=new ArrayList<Point>(); 
    /**lista połączeń dla konstelacji Cepheus*/
    public List<Connection>connectionsCepheus=new ArrayList<Connection>(); 
    /**lista punktów (gwiazd) dla konstelacji Libra*/
    public List<Point>pointsLibra=new ArrayList<Point>(); 
    /**lista połączeń dla konstelacji Libra*/
    public List<Connection>connectionsLibra=new ArrayList<Connection>(); 
    
    /**
     * funkcja tworząca listy pytań dla każdej z konstelacji
     */
    public void createQuestions(){
        q1.question=("Między jakimi konstelacjami leży gwiazdozbiór Raka?");
        q1.answers= new String[]{"Bliźnięta i Lew", "Strzelec i Waga", "Lew i Waga"}; 
        q1.correctAnswer=0; 
        q2.question=("W jakich porach roku widoczna jest konstelacja Raka?");
        q2.answers= new String[]{"cały rok", "od zimy do wiosny", "od wiosny do wczesnej jesieni"}; 
        q2.correctAnswer=1; 
        q3.question=("Jakie imię nosił rak którego Hera umieściła na nieboskłonie?");
        q3.answers= new String[]{"Karkinos", "Koryntos", "Domestos"}; 
        q3.correctAnswer=0; 
        q4.question=("W jakich porach roku widoczna jest konstelacja Kasjopeji?");
        q4.answers= new String[]{"od jesieni do późnej wiosny", "przez całe lato", "cały rok"}; 
        q4.correctAnswer=2; 
        q5.question=("Jakiego kraju królową była Kasjopeja?");
        q5.answers= new String[]{"Grecja", "Etiopia", "Kongo"}; 
        q5.correctAnswer=1; 
        q6.question=("Kto, zgodnie z legendą, wzburzył wody w kraju Kasjopeji?");
        q6.answers= new String[]{"matenary", "nereidy", "esseidy"}; 
        q6.correctAnswer=1; 
        q7.question=("W pobliżu czego leży gwiazdozbiór Byka?");
        q7.answers= new String[]{"bieguna północnego", "równika niebieskiego", "bieguna południowego"}; 
        q7.correctAnswer=1; 
        q8.question=("Jak nazywają się luźno połączone grawitacją gwiazdy?");
        q8.answers= new String[]{"gromady otwarte", "gromady kuliste", "gromady spiralne"}; 
        q8.correctAnswer=0; 
        q9.question=("Byk tworzy wielką scenę polowania z konstelacją:");
        q9.answers= new String[]{"Lwa", "Oriona", "Cefeusza"}; 
        q9.correctAnswer=1; 
        q10.question=("Czego symbolem jest najjaśniejsza gwiazda konstelacji Lwa?");
        q10.answers= new String[]{"Monarchii", "Mądrości", "Siły"}; 
        q10.correctAnswer=0; 
        q11.question=("Jak nazywa się rój meteorów konstelacji Lwa?");
        q11.answers= new String[]{"Matory", "Leonary", "Leonidy"}; 
        q11.correctAnswer=2; 
        q12.question=("Jak nazywa się najjaśniejsza gwiazda Lwa?");
        q12.answers= new String[]{"Regulus", "Normus", "Legislis"}; 
        q12.correctAnswer=0; 
        q13.question=("Gwiazdy w znaczący sposób zmieniające swoją jasność są:");
        q13.answers= new String[]{"pulsacyjne", "zmienne", "oscylujące"}; 
        q13.correctAnswer=1; 
        q14.question=("Gwiazdy zmienne używane jako odległości we Wszechświecie?");
        q14.answers= new String[]{"cefeidy", "akrecje", "bennary"}; 
        q14.correctAnswer=0; 
        q15.question=("Jak nazywa się układ dwóch gwiazd leżących blisko siebie?");
        q15.answers= new String[]{"podwójne", "bliźniacze", "gromadne"}; 
        q15.correctAnswer=0; 
        q16.question=("Jaką postać kobiecą przedstawia gwiazdozbiór Wagi?");
        q16.answers= new String[]{"Penelopa", "Hera", "Astrea"}; 
        q16.correctAnswer=2; 
        q17.question=("Gwiazdozbiór Wagi to najstarszy gwiazdozbiór Zodiaku");
        q17.answers= new String[]{"tak", "nie", "nie można tego stwierdzić"}; 
        q17.correctAnswer=1; 
        q18.question=("Jaka jest widzialnosć Gwiazdozbioru Wagi?");
        q18.answers= new String[]{"bardzo duża", "przeciętna", "mała"}; 
        q18.correctAnswer=2; 
        questionsCancer.add(q1); 
        questionsCancer.add(q2); 
        questionsCancer.add(q3); 
        questionsCassiopeia.add(q4); 
        questionsCassiopeia.add(q5); 
        questionsCassiopeia.add(q6);  
        questionsTaurus.add(q7); 
        questionsTaurus.add(q8); 
        questionsTaurus.add(q9); 
        questionsLeo.add(q10); 
        questionsLeo.add(q11); 
        questionsLeo.add(q12); 
        questionsCepheus.add(q13); 
        questionsCepheus.add(q14); 
        questionsCepheus.add(q15); 
        questionsLibra.add(q16); 
        questionsLibra.add(q17); 
        questionsLibra.add(q18); 
        
        
    }
    /**
     * funkcja zwracająca JButton będący gwiazdą (domyślnie kolor niebieski)
     * @return 
     */
    public JButton createStar(){
        JButton star = new JButton(); 
        ImageIcon starIcon= new ImageIcon("star_blue.png");
        star.setIcon(starIcon); 
        star.setBorderPainted(false);
        star.setBorder(null);
        star.setFocusable(true);
        star.setMargin(new Insets(0, 0, 0, 0));
        star.setContentAreaFilled(false);
        return star; 
        
    }
    /**
     * funkcja tworząca listy połączeń między gwiazdami dla każdej z konstelacji
     */
    public void createConnections(){
        
        Point p1= new Point(createStar(),220,100); 
        Point p2= new Point(createStar(),180,190); 
        Point p3= new Point(createStar(),140,230); 
        Point p4= new Point(createStar(),50,270); 
        Point p5= new Point(createStar(),170,320); 
        Point p6= new Point(createStar(),200,370); 
        pointsCancer.add(p1); 
        pointsCancer.add(p2); 
        pointsCancer.add(p3); 
        pointsCancer.add(p4); 
        pointsCancer.add(p5);
        pointsCancer.add(p6);
        Connection c1=new Connection(p1,p2);
        Connection c2=new Connection(p2,p3);
        Connection c3=new Connection(p3,p4);
        Connection c4=new Connection(p3,p5);
        Connection c5=new Connection(p5,p6);
        connectionsCancer.add(c1); 
        connectionsCancer.add(c2); 
        connectionsCancer.add(c3); 
        connectionsCancer.add(c4); 
        connectionsCancer.add(c5); 
        Point p7= new Point(createStar(),470,410);
        Point p8= new Point(createStar(),500,490);
        Point p9= new Point(createStar(),600,540);
        Point p10= new Point(createStar(),620,620);
        Point p11= new Point(createStar(),690,580);
        pointsCassiopeia.add(p7); 
        pointsCassiopeia.add(p8); 
        pointsCassiopeia.add(p9); 
        pointsCassiopeia.add(p10); 
        pointsCassiopeia.add(p11); 
        Connection c6=new Connection(p7,p8);
        Connection c7=new Connection(p8,p9);
        Connection c8=new Connection(p9,p10);
        Connection c9=new Connection(p10,p11);
        connectionsCassiopeia.add(c6); 
        connectionsCassiopeia.add(c7); 
        connectionsCassiopeia.add(c8); 
        connectionsCassiopeia.add(c9); 
        Point p12= new Point(createStar(),30,130);
        Point p13= new Point(createStar(),140,140);
        Point p14= new Point(createStar(),155,190);
        Point p15= new Point(createStar(),155,235);
        Point p16= new Point(createStar(),112,219);
        Point p17= new Point(createStar(),80,190);
        Point p18= new Point(createStar(),100,90);
        Point p19= new Point(createStar(),190,270);
        Point p20= new Point(createStar(),240,300);
        Point p21= new Point(createStar(),260,350);
        pointsTaurus.add(p12); 
        pointsTaurus.add(p13); 
        pointsTaurus.add(p14); 
        pointsTaurus.add(p15); 
        pointsTaurus.add(p16);
        pointsTaurus.add(p17);
        pointsTaurus.add(p18);
        pointsTaurus.add(p19);
        pointsTaurus.add(p20);
        pointsTaurus.add(p21);
        Connection c10=new Connection(p12,p17);
        Connection c11=new Connection(p13,p14);
        Connection c12=new Connection(p14,p15);
        Connection c13=new Connection(p15,p16);
        Connection c14=new Connection(p16,p17);
        Connection c15=new Connection(p13,p18);
        Connection c16=new Connection(p15,p19);
        Connection c17=new Connection(p19,p20);
        Connection c18=new Connection(p20,p21);
        connectionsTaurus.add(c10); 
        connectionsTaurus.add(c11); 
        connectionsTaurus.add(c12);
        connectionsTaurus.add(c13);
        connectionsTaurus.add(c14);
        connectionsTaurus.add(c15);
        connectionsTaurus.add(c16);
        connectionsTaurus.add(c17);
        connectionsTaurus.add(c18);
        Point p22= new Point(createStar(),650,400);
        Point p23= new Point(createStar(),600,350);
        Point p24= new Point(createStar(),550,400);
        Point p25= new Point(createStar(),545,470);
        Point p26= new Point(createStar(),600,525);
        Point p27= new Point(createStar(),635,600);
        Point p28= new Point(createStar(),500,580);
        Point p29= new Point(createStar(),390,610);
        Point p30= new Point(createStar(),425,530);
        pointsLeo.add(p22); 
        pointsLeo.add(p23); 
        pointsLeo.add(p24); 
        pointsLeo.add(p25); 
        pointsLeo.add(p26); 
        pointsLeo.add(p27); 
        pointsLeo.add(p28); 
        pointsLeo.add(p29); 
        pointsLeo.add(p30); 
        Connection c19=new Connection(p22,p23);
        Connection c20=new Connection(p23,p24);
        Connection c21=new Connection(p24,p25);
        Connection c22=new Connection(p25,p26);
        Connection c23=new Connection(p26,p27);
        Connection c24=new Connection(p27,p28);
        Connection c25=new Connection(p28,p29);
        Connection c26=new Connection(p29,p30);
        Connection c27=new Connection(p30,p25);
        connectionsLeo.add(c19); 
        connectionsLeo.add(c20); 
        connectionsLeo.add(c21); 
        connectionsLeo.add(c22); 
        connectionsLeo.add(c23); 
        connectionsLeo.add(c24); 
        connectionsLeo.add(c25); 
        connectionsLeo.add(c26); 
        connectionsLeo.add(c27); 
        Point p31= new Point(createStar(),100,140);
        Point p32= new Point(createStar(),190,180);
        Point p33= new Point(createStar(),245,255);
        Point p34= new Point(createStar(),160,320);
        Point p35= new Point(createStar(),95,240);
        pointsCepheus.add(p31); 
        pointsCepheus.add(p32); 
        pointsCepheus.add(p33); 
        pointsCepheus.add(p34); 
        pointsCepheus.add(p35); 
        Connection c28=new Connection(p31,p32);
        Connection c29=new Connection(p32,p33);
        Connection c30=new Connection(p33,p34);
        Connection c31=new Connection(p34,p35);
        Connection c32=new Connection(p35,p31);
        connectionsCepheus.add(c28); 
        connectionsCepheus.add(c29); 
        connectionsCepheus.add(c30); 
        connectionsCepheus.add(c31);
        connectionsCepheus.add(c32); 
        Point p36= new Point(createStar(),490,610);
        Point p37= new Point(createStar(),450,530);
        Point p38= new Point(createStar(),420,440);
        Point p39= new Point(createStar(),530,350);
        Point p40= new Point(createStar(),640,435);
        Point p41= new Point(createStar(),530,440);
        Point p42= new Point(createStar(),665,570);
        Point p43= new Point(createStar(),650,620);
        Point p44= new Point(createStar(),695,630);
        pointsLibra.add(p36); 
        pointsLibra.add(p37); 
        pointsLibra.add(p38); 
        pointsLibra.add(p39); 
        pointsLibra.add(p40);
        pointsLibra.add(p41);
        pointsLibra.add(p42);
        pointsLibra.add(p43);
        pointsLibra.add(p44);
        Connection c33=new Connection(p36,p37);
        Connection c34=new Connection(p37,p38);
        Connection c35=new Connection(p38,p39);
        Connection c36=new Connection(p39,p40);
        Connection c37=new Connection(p40,p41);
        Connection c38=new Connection(p41,p38);
        Connection c39=new Connection(p40,p42);
        Connection c40=new Connection(p42,p43);
        Connection c41=new Connection(p43,p44);
        connectionsLibra.add(c33); 
        connectionsLibra.add(c34); 
        connectionsLibra.add(c35); 
        connectionsLibra.add(c36); 
        connectionsLibra.add(c37); 
        connectionsLibra.add(c38); 
        connectionsLibra.add(c39); 
        connectionsLibra.add(c40); 
        connectionsLibra.add(c41);      
    }
    /**
     * funkcja tworząca konstelacje i przypisująca im odpowiednie wartości parametrów
     */
    public void createConstelations(){
        cancer = new Constelation("cancer", "cancer", pointsCancer, connectionsCancer, questionsCancer, "cancer.png"); 
        cassiopeia = new Constelation("cassiopeia", "cassiopeia", pointsCassiopeia, connectionsCassiopeia, questionsCassiopeia, "cassiopeia.png");
        taurus = new Constelation("taurus", "taurus", pointsTaurus, connectionsTaurus, questionsTaurus, "taurus.png"); 
        leo = new Constelation("leo", "leo", pointsLeo, connectionsLeo, questionsLeo, "leo.png"); 
        cepheus = new Constelation("cepheus", "cepheus", pointsCepheus, connectionsCepheus, questionsCepheus, "cepheus.png"); 
        libra = new Constelation("libra", "libra", pointsLibra, connectionsLibra, questionsLibra, "libra.png"); 
    }
    /**
     * funkcja tworząca cykle i przypisująca im po dwie konstelacje
     */
    public void createCycles(){
        cycle1= new Cycle(cancer, cassiopeia); 
        cycle2= new Cycle(taurus, leo); 
        cycle3= new Cycle(cepheus, libra); 
    }
    /**
     * funkcja tworząca poziomy gry i przypisująca im po 3 cykle
     */
    public void createLevels(){
     
        beginner.cycles.add(cycle1); 
        beginner.cycles.add(cycle2); 
        beginner.cycles.add(cycle3); 
        
        intermediate.cycles.add(cycle1);
        intermediate.cycles.add(cycle2);
        intermediate.cycles.add(cycle3);
        
        advanced.cycles.add(cycle1); 
        advanced.cycles.add(cycle2); 
        advanced.cycles.add(cycle3);
        
    }
}
