import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * In clasa Xsi0 se implementeaza tot jocul.
 * In aceasta clasa este implementata de asemena si interfata
 * cu ajutorul java swing
 */
public class Xsi0 implements ActionListener{
    /**
     *  variabila random o folosim pentru a extrage random randul jucatorilor
     *  frame e folosit pentru a crea un nou frame pentru joc
     *  title_panel este folosit pentru a crea un panou pentru titlu
     *  button_panel este folosit pentru a crea un panou pentru butoane
     *  text_field pentru a scrie randul carui jucator este
     *  buttons sunt cele 9 butoane pentru joc
     *  player1Turn este folosit pentru a stii al cui este randul astfel: daca player1Turn este true inseamna ca este
     *  randul lui X altfel este randul lui 0
     *  xScore si oScore sunt folosite pentru a tine scorul intre cei 2 jucatori pana la iesirea din joc
     */
     Random random=new Random();
     JFrame frame=new JFrame();
     JPanel title_panel=new JPanel();
     JPanel button_panel =new JPanel();
     JLabel textfield= new JLabel();
     JButton[] buttons=new JButton[9];
     boolean player1Turn;
     int xScore=0;
     int oScore=0;

    /**
     * in constructor ne cream interfata folosing java swing
     * cream rama interfetei, apoi caseta de text, apoi panoul de titlu, iar in ultimul rand cream panoul pentru cele 9 butoane impreuna cu butoanele
     * propriu zise care vor tine locul patratelor pentru jocul x si 0
     */
     Xsi0(){
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800,800);
       frame.getContentPane().setBackground(new Color(50,50,50));
       frame.setLayout(new BorderLayout());
       frame.setVisible(true);

       textfield.setBackground(new Color(25,25,25));
       textfield.setForeground(new Color(255,255,255));
       textfield.setFont(new Font("Ink Free",Font.BOLD,75));
       textfield.setHorizontalAlignment(JLabel.CENTER);
       textfield.setText("X-si-0");
       textfield.setOpaque(true);

       title_panel.setLayout(new BorderLayout());
       title_panel.setBounds(0,0,800,100);

       button_panel.setLayout(new GridLayout(3,3));
         button_panel.setBackground(new Color(150,150,150));

         for(int i=0;i<9;i++){
             buttons[i]=new JButton();
             button_panel.add(buttons[i]);
             buttons[i].setBackground(new Color(200,200,200));
             buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
             buttons[i].setFocusable(false);
             buttons[i].addActionListener(this );
         }
       title_panel.add(textfield);
       frame.add(title_panel,BorderLayout.NORTH);
       frame.add(button_panel);
       primulJucator();
      }

    /**
     * in metoda actionPerformed verificam pe ce buton s a efecutat actiunea si apoi verificam al carui player dintre x si 0 a fost randul
     * pentru a efectua modificari in interfata.
     * Dupa fiecare modificare se trece in metoda verifica().
     * @param e este folosit pentru a arata ce actiune se intampla
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      for(int i=0;i<9;i++){
          if(e.getSource()==buttons[i]){
              if(player1Turn){
                  if(buttons[i].getText()==""){
                      buttons[i].setForeground(new Color(255,0,0));
                      buttons[i].setText("X");
                      player1Turn=false;
                      textfield.setText("O turn");
                       verifica();
                  }
              }
              else {
                  if(buttons[i].getText()==""){
                      buttons[i].setForeground(new Color(0,0,255));
                      buttons[i].setText("0");
                      player1Turn=true;
                      textfield.setText("X turn");
                     verifica();
                  }
              }
          }

      }
    }

    /**
     *  Metoda primul jucator este folosita pentru a extrage random
     *  randul primului jucaor.
     *  in functie de outputul de la random aflam ce jucator este primul si ii setam variabila player1Turn pe true
     *  respectiv pe false
     */
    public void primulJucator(){

       try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if(random.nextInt(2)==0){
          player1Turn=true;
          textfield.setText("X turn");
      }
      else{
          player1Turn=false;
          textfield.setText("0 turn");
      }
    }

    /**
     * in metoda verifica verificam daca avem un castigator astfel: luam toate cazurile in care x poate castiga si daca una dintre cazuri este adevarata
     * aelam xCastiga si apoi iesim din metoda
     * In mod echivalent facem acelasi lucru si pentru 0 iar daca unul dintre cazuri este adevarat apelam oCastiga si apoi iesim din metoda
     * De asemena verificam si cazul in care nu avem niciun castigator moment in care apelam metoda niciunCastigator si iesim din metoda
     */
    public void verifica(){
      if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X")){
          xCastiga(0,1,2);
          return;
      }
        if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X")){
            xCastiga(3,4,5);
            return;
        }
        if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X")){
            xCastiga(6,7,8);
            return;
        }
        if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X")){
            xCastiga(0,3,6);
            return;
        }
        if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X")){
            xCastiga(1,4,7);
            return;
        }
        if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X")){
            xCastiga(2,5,8);
            return;
        }
        if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X")){
            xCastiga(0,4,8);
            return;
        }
        if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X")){
            xCastiga(2,4,6);
            return;
        }


        if((buttons[0].getText()=="0")&&(buttons[1].getText()=="0")&&(buttons[2].getText()=="0")){
            oCastiga(0,1,2);
            return;
        }
        if((buttons[3].getText()=="0")&&(buttons[4].getText()=="0")&&(buttons[5].getText()=="0")){
            oCastiga(3,4,5);
             return;
        }
        if((buttons[6].getText()=="0")&&(buttons[7].getText()=="0")&&(buttons[8].getText()=="0")){
            oCastiga(6,7,8);
            return;
        }
        if((buttons[0].getText()=="0")&&(buttons[3].getText()=="0")&&(buttons[6].getText()=="0")){
            oCastiga(0,3,6);
            return;
        }
        if((buttons[1].getText()=="0")&&(buttons[4].getText()=="0")&&(buttons[7].getText()=="0")){
            oCastiga(1,4,7);
            return;
        }
        if((buttons[2].getText()=="0")&&(buttons[5].getText()=="0")&&(buttons[8].getText()=="0")){
            oCastiga(2,5,8);
            return;
        }
        if((buttons[0].getText()=="0")&&(buttons[4].getText()=="0")&&(buttons[8].getText()=="0")){
            oCastiga(0,4,8);
            return;
        }
        if((buttons[2].getText()=="0")&&(buttons[4].getText()=="0")&&(buttons[6].getText()=="0")){
            oCastiga(2,4,6);
            return;
        }
        if((buttons[0].getText()!="")&&(buttons[1].getText()!="")&&(buttons[2].getText()!="")&&(buttons[3].getText()!="")&&(buttons[4].getText()!="")&&(buttons[5].getText()!="")&&(buttons[6].getText()!="")&&(buttons[7].getText()!="")&&(buttons[8].getText()!="")){
              niciuncastigator();
        }
    }

    /**
     * Metoda xCastiga are 3 parametrii
     * @param a ne arata indexul primului buton in care apare x
     * @param b ne arata indexul celui de al 2 lea buton in care apare x
     * @param c ne arata indexul celui de al 3 lea buton in care x
     *  In momentul in care aceasta functie este apelata stim sigur ca x este castigatorul
     *          Nu mai avem de facut decat sa facem butoanele verzi pentru a fi vizibil castigatorul,
     *          sa nu mai dam voie jucatorului sa apase pe butoane, modificam textul cu "x castiga"
     *          de asemena avem un scor pe care il incrementam
     *          Dar si un panou cu mesajul x castiga, scorul dintre x si 0 pana la inchiderea jocului, dar si posibilitatea e a reincerca
     *          in cazul in care jucatorul nu mai vrea sa joace, scorul trece din nou la 0
     */
    public void xCastiga(int a, int b,int c){
         buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X castiga");
        xScore++;
        JOptionPane pane = new JOptionPane();
        int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over. "+  "X wins. Would you like to play again?","Game over."+"X score is: "+xScore+" "+"0 score is: "+oScore,
                JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION){textfield.setText("X-si-0 again");
            reseteaza();

        }
        else { xScore=0; oScore=0;
            System.exit(0);
        }
    }

    /**
     * Metoda oCastiga este echivalenta cu xCastiga cu diferenta ca in momentul in care aceasta metoda este apelata stim sigur ca 0 este castigator
     * @param a este indexul primului buton in care s a gasit 0
     * @param b este indexul celui de al doilea buton in care s a gasit 0
     * @param c este indexul celui de al treilea buton in care s a gasit 0
     */
    public void oCastiga(int a, int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("0 castiga");
      oScore++;
        JOptionPane pane = new JOptionPane();
        int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over. "+  " 0 wins. Would you like to play again?","Game over."+"X score is: "+xScore+" "+"0 score is: "+oScore,
                JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION) {textfield.setText("X-si-0 again");
            reseteaza();
        }
        else { oScore=0; xScore=0;
            System.exit(0);
        }
    }

    /**
     * Metoda niciuncastigator este similare cu metodele xCastiga, oCastiga insa fara a mai seta butoanele pe verde
     * deoarece nnu este nicun castigator
     */
    public void niciuncastigator(){
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("niciun castigator");

        JOptionPane pane = new JOptionPane();
        int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over. "+  " no one wins. Would you like to play again?","Game over."+"X score is: "+xScore+" "+"O score is: "+oScore,
                JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION) {textfield.setText("X-si-0 again");
            reseteaza();
        }
        else { xScore=0; oScore=0;
            System.exit(0);
        }
    }

    /**
     * Metoda reseteaza o folosim pentru a reseta jocul.
     * Singurele modificari se vor face la butoane:
     * resetam textul pe "" si le redam jucatorilor posibiliatea de apasa pe butoane
     * de asemena resetam si culoarea pentru a nu se vedea castigurile celor dinainte
     * si reapelam functia primulJucator() pentru a relua jocul de la capat
     */
    public void reseteaza(){

        textfield.setText("X-si-0 again");
         for(int i=0;i<9;i++){
             buttons[i].setText("");
             buttons[i].setBackground(new Color(200,200,200));
             buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
             buttons[i].setFocusable(false);
             buttons[i].setEnabled(true);
         }

        primulJucator();
    }


}
