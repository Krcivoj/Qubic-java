/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qubic;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nela
 */
public class gui extends javax.swing.JFrame {
    static String oznaka = "X";
    /**
     * Creates new form gui
     */
    public gui() {
        initComponents();
        nivo1.setVisible(false);
        nivo2.setVisible(false);
        nivo3.setVisible(false);
        nivo4.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lijevo = new javax.swing.JPanel();
        naslovni = new javax.swing.JPanel();
        naslov = new javax.swing.JLabel();
        uputa = new javax.swing.JLabel();
        formaPanel = new javax.swing.JPanel();
        forma = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        prvoIme = new javax.swing.JTextField();
        drugoIme = new javax.swing.JTextField();
        kreni = new javax.swing.JButton();
        vrsta = new javax.swing.JComboBox<>();
        znak = new javax.swing.JComboBox<>();
        napomena = new javax.swing.JLabel();
        desno = new javax.swing.JPanel();
        nivo1 = new javax.swing.JPanel();
        nivo2 = new javax.swing.JPanel();
        nivo3 = new javax.swing.JPanel();
        nivo4 = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        nova = new javax.swing.JMenu();
        statistika = new javax.swing.JMenu();
        ljestvica = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Igra QUBIC");
        setBackground(new java.awt.Color(239, 227, 191));
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        lijevo.setLayout(new javax.swing.BoxLayout(lijevo, javax.swing.BoxLayout.Y_AXIS));

        naslov.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        naslov.setForeground(new java.awt.Color(0, 153, 102));
        naslov.setText("Dobrodošli u igru Qubic!");

        uputa.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        uputa.setText("Odaberite podatke za početak igre. ");

        javax.swing.GroupLayout naslovniLayout = new javax.swing.GroupLayout(naslovni);
        naslovni.setLayout(naslovniLayout);
        naslovniLayout.setHorizontalGroup(
            naslovniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(naslovniLayout.createSequentialGroup()
                .addGap(10, 43, Short.MAX_VALUE)
                .addGroup(naslovniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(naslov, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uputa, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        naslovniLayout.setVerticalGroup(
            naslovniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(naslovniLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(naslov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uputa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        lijevo.add(naslovni);

        forma.setBackground(new java.awt.Color(186, 235, 206));
        forma.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel3.setText("Vaše ime:");

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel4.setText("Vrsta igre(ploče):");

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel5.setText("Ime drugog igrača:");

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel6.setText("Znak prvog igrača:");

        kreni.setBackground(new java.awt.Color(0, 153, 102));
        kreni.setForeground(new java.awt.Color(255, 255, 255));
        kreni.setText("Pokreni!");
        kreni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kreni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kreniMouseClicked(evt);
            }
        });

        vrsta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3x3x3", "4x4x4" }));

        znak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X", "O" }));

        javax.swing.GroupLayout formaLayout = new javax.swing.GroupLayout(forma);
        forma.setLayout(formaLayout);
        formaLayout.setHorizontalGroup(
            formaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(formaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(formaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(drugoIme)
                    .addComponent(prvoIme)
                    .addComponent(vrsta, 0, 136, Short.MAX_VALUE)
                    .addComponent(znak, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kreni, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        formaLayout.setVerticalGroup(
            formaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(formaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formaLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(prvoIme, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(formaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vrsta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(formaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drugoIme, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(formaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(znak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(kreni)
                .addGap(19, 19, 19))
        );

        napomena.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        napomena.setText("Napomena: za računalo kao protivnika u formu upišite računalo.");

        javax.swing.GroupLayout formaPanelLayout = new javax.swing.GroupLayout(formaPanel);
        formaPanel.setLayout(formaPanelLayout);
        formaPanelLayout.setHorizontalGroup(
            formaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formaPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(formaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(forma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(napomena, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        formaPanelLayout.setVerticalGroup(
            formaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formaPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(forma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(napomena)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        lijevo.add(formaPanel);

        getContentPane().add(lijevo);

        nivo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nivo1.setFocusable(false);
        nivo1.setMinimumSize(new java.awt.Dimension(180, 180));
        nivo1.setPreferredSize(new java.awt.Dimension(180, 180));

        javax.swing.GroupLayout nivo1Layout = new javax.swing.GroupLayout(nivo1);
        nivo1.setLayout(nivo1Layout);
        nivo1Layout.setHorizontalGroup(
            nivo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        nivo1Layout.setVerticalGroup(
            nivo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        nivo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nivo2.setMinimumSize(new java.awt.Dimension(180, 180));
        nivo2.setPreferredSize(new java.awt.Dimension(180, 180));

        javax.swing.GroupLayout nivo2Layout = new javax.swing.GroupLayout(nivo2);
        nivo2.setLayout(nivo2Layout);
        nivo2Layout.setHorizontalGroup(
            nivo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        nivo2Layout.setVerticalGroup(
            nivo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        nivo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nivo3.setMinimumSize(new java.awt.Dimension(180, 180));
        nivo3.setPreferredSize(new java.awt.Dimension(180, 180));

        javax.swing.GroupLayout nivo3Layout = new javax.swing.GroupLayout(nivo3);
        nivo3.setLayout(nivo3Layout);
        nivo3Layout.setHorizontalGroup(
            nivo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        nivo3Layout.setVerticalGroup(
            nivo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        nivo4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nivo4.setMinimumSize(new java.awt.Dimension(180, 180));
        nivo4.setPreferredSize(new java.awt.Dimension(180, 180));

        javax.swing.GroupLayout nivo4Layout = new javax.swing.GroupLayout(nivo4);
        nivo4.setLayout(nivo4Layout);
        nivo4Layout.setHorizontalGroup(
            nivo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        nivo4Layout.setVerticalGroup(
            nivo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout desnoLayout = new javax.swing.GroupLayout(desno);
        desno.setLayout(desnoLayout);
        desnoLayout.setHorizontalGroup(
            desnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desnoLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(desnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nivo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nivo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nivo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nivo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        desnoLayout.setVerticalGroup(
            desnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nivo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nivo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nivo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nivo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        getContentPane().add(desno);

        menu.setBackground(new java.awt.Color(0, 153, 102));
        menu.setForeground(new java.awt.Color(255, 255, 255));

        nova.setBackground(new java.awt.Color(0, 153, 102));
        nova.setForeground(new java.awt.Color(255, 255, 255));
        nova.setText("Nova igra");
        nova.setBorderPainted(true);
        menu.add(nova);

        statistika.setBackground(new java.awt.Color(0, 153, 102));
        statistika.setForeground(new java.awt.Color(255, 255, 255));
        statistika.setText("Statistika");
        statistika.setBorderPainted(true);
        menu.add(statistika);

        ljestvica.setBackground(new java.awt.Color(0, 153, 102));
        ljestvica.setForeground(new java.awt.Color(255, 255, 255));
        ljestvica.setText("Ljestvica");
        ljestvica.setBorderPainted(true);
        menu.add(ljestvica);

        jMenu1.setBackground(new java.awt.Color(0, 153, 102));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Upute");
        menu.add(jMenu1);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kreniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kreniMouseClicked
        naslov.setText("Igra " + prvoIme.getText() + " vs " + drugoIme.getText() + " je započela!");
        String tip = vrsta.getSelectedItem().toString();
        uputa.setText(tip);
        
        //postavljanje igrača u par, prvi je X drugi O
        Pair<String, String> igraci = new Pair<>();
        if(znak.getSelectedItem().toString() == "X"){
            igraci.first = prvoIme.getText();
            igraci.second = drugoIme.getText();
        }
        else{
            igraci.second = prvoIme.getText();
            igraci.first = drugoIme.getText();
        }
        
        //igra na 3x3x3
        if(tip == "3x3x3"){
            nivo1.setVisible(true);
            nivo2.setVisible(true);
            nivo3.setVisible(true);
            //dodavanje gumbova
            nivo1.setLayout(new GridLayout(3,3));
            nivo2.setLayout(new GridLayout(3,3));
            nivo3.setLayout(new GridLayout(3,3));
            JButton[] buttons1 = new JButton[9];
            JButton[] buttons2 = new JButton[9];
            JButton[] buttons3 = new JButton[9];
            for(int i = 0; i < 9; i++){
                final int index = i;
                buttons1[i] = new JButton(" ");
                buttons1[i].putClientProperty("id", i+1+10);
                buttons1[i].setFocusable(false);
                buttons1[i].addActionListener(new ActionListener(){  
                    @Override
                    public void actionPerformed(ActionEvent e){  
                        buttons1[index].setText(oznaka);
                        buttons1[index].setEnabled(false);
                        if( "X".equals(oznaka)) oznaka = "O";
                        else oznaka = "X";
                    }  
                });
                buttons2[i] = new JButton(" ");
                buttons2[i].putClientProperty("id", i+1+20);
                buttons2[i].setFocusable(false);
                buttons2[i].addActionListener(new ActionListener(){  
                    @Override
                    public void actionPerformed(ActionEvent e){  
                        buttons2[index].setText(oznaka); 
                        buttons2[index].setEnabled(false);
                        if( "X".equals(oznaka)) oznaka = "O";
                        else oznaka = "X";
                    }  
                });
                buttons3[i] = new JButton(" ");
                buttons3[i].putClientProperty("id", i+1+30);
                buttons3[i].setFocusable(false);
                buttons3[i].addActionListener(new ActionListener(){  
                    @Override
                    public void actionPerformed(ActionEvent e){  
                        buttons3[index].setText(oznaka);
                        buttons3[index].setEnabled(false);
                        if( "X".equals(oznaka)) oznaka = "O";
                        else oznaka = "X";
                    }  
                });
                nivo1.add(buttons1[i]);
                nivo2.add(buttons2[i]);
                nivo3.add(buttons3[i]);
                
                //pocetak igre 
                Qubic igra = new Qubic(3);
                Player pobjednik = igra.play();
                //ispis s winner.id() ako je null je remi
                
                
            }
        }
        else{  //igra na 4x4x4
            nivo1.setVisible(true);
            nivo2.setVisible(true);
            nivo3.setVisible(true);
            nivo4.setVisible(true);
            //dodavanje gumbova
            nivo1.setLayout(new GridLayout(4,4));
            nivo2.setLayout(new GridLayout(4,4));
            nivo3.setLayout(new GridLayout(4,4));
            nivo4.setLayout(new GridLayout(4,4));
            JButton[] buttons1 = new JButton[16];
            JButton[] buttons2 = new JButton[16];
            JButton[] buttons3 = new JButton[16];
            JButton[] buttons4 = new JButton[16];
            for(int i = 0; i < 16; i++){
                final int index = i;
                buttons1[i] = new JButton(" ");
                buttons1[i].putClientProperty("id", i+1+10);
                buttons1[i].setFocusable(false);
                buttons1[i].addActionListener(new ActionListener(){  
                    @Override
                    public void actionPerformed(ActionEvent e){  
                        buttons1[index].setText(oznaka);
                        buttons1[index].setEnabled(false);
                        if( "X".equals(oznaka)) oznaka = "O";
                        else oznaka = "X";
                    }  
                });
                buttons2[i] = new JButton(" ");
                buttons2[i].putClientProperty("id", i+1+20);
                buttons2[i].setFocusable(false);
                buttons2[i].addActionListener(new ActionListener(){  
                    @Override
                    public void actionPerformed(ActionEvent e){  
                        buttons2[index].setText(oznaka);  
                        buttons2[index].setEnabled(false);
                        if( "X".equals(oznaka)) oznaka = "O";
                        else oznaka = "X";
                    }  
                });
                buttons3[i] = new JButton(" ");
                buttons3[i].putClientProperty("id", i+1+30);
                buttons3[i].setFocusable(false);
                buttons3[i].addActionListener(new ActionListener(){  
                    @Override
                    public void actionPerformed(ActionEvent e){  
                        buttons3[index].setText(oznaka);
                        buttons3[index].setEnabled(false);
                        if( "X".equals(oznaka)) oznaka = "O";
                        else oznaka = "X";
                    }  
                });
                buttons4[i] = new JButton(" ");
                buttons4[i].putClientProperty("id", i+1+40);
                buttons4[i].setFocusable(false);
                buttons4[i].addActionListener(new ActionListener(){  
                    @Override
                    public void actionPerformed(ActionEvent e){  
                        buttons4[index].setText(oznaka);
                        buttons4[index].setEnabled(false);
                        if( "X".equals(oznaka)) oznaka = "O";
                        else oznaka = "X";
                    }  
                });
                nivo1.add(buttons1[i]);
                nivo2.add(buttons2[i]);
                nivo3.add(buttons3[i]);
                nivo4.add(buttons4[i]);
            }
            //pocetak igre
            Qubic igra = new Qubic(4);
        }
        
    }//GEN-LAST:event_kreniMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void pozovi() {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel desno;
    private javax.swing.JTextField drugoIme;
    private javax.swing.JPanel forma;
    private javax.swing.JPanel formaPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JButton kreni;
    private javax.swing.JPanel lijevo;
    private javax.swing.JMenu ljestvica;
    private javax.swing.JMenuBar menu;
    private javax.swing.JLabel napomena;
    private javax.swing.JLabel naslov;
    private javax.swing.JPanel naslovni;
    private javax.swing.JPanel nivo1;
    private javax.swing.JPanel nivo2;
    private javax.swing.JPanel nivo3;
    private javax.swing.JPanel nivo4;
    private javax.swing.JMenu nova;
    private javax.swing.JTextField prvoIme;
    private javax.swing.JMenu statistika;
    public javax.swing.JLabel uputa;
    private javax.swing.JComboBox<String> vrsta;
    private javax.swing.JComboBox<String> znak;
    // End of variables declaration//GEN-END:variables
}
