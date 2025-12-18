/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetofinaleda;
import projetofinaleda.Trie.*;
import projetofinaleda.Array.*;
import projetofinaleda.ArvoreAVL.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author duart
 */
public class FramePrincipal extends javax.swing.JFrame {
    private String palavraDigitada = "";
    private Trie trie;                        
    private static final String TRIE_SALVA = "dicionario_textos.trie";
    private int menuFlag=0; // 1 -Trie   2- Arvore Avl  3- Array   
    
    //Array
    private PredictiveEngine engine;
    
    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();
        
        
    //   --------------Array----------------
        engine = new PredictiveEngine();
        engine.carregaFicheiro("Textos.txt");
        
        


    
    //   --------------TRIE----------------
        trie = ListaPalavras.carregarTrie(TRIE_SALVA);
    if (trie == null) {
        trie = new Trie();
        ListaPalavras.carregarDeFicheiro("Textos.txt", trie);
        ListaPalavras.guardarTrie(trie,TRIE_SALVA);
    }
    configurarPainelDeSugestoes();
    ligarTecladoVirtual();
        
    }
 
 //----------------- Array ---------------------------
    
        private void teclaPressionada(java.awt.event.ActionEvent evt) {                                  
         // TODO add your handling code here:
         javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
         String letra = botao.getText();
         String textoAtual = inputKeyboards.getText();
         
         //Escreve no jTextField
         inputKeyboards.setText(textoAtual + letra);
         
         //Descobrir a ultima palavra escrita
         String[] partes = inputKeyboards.getText().split(" ");
         if (partes.length>0) {
             String ultimaPalavra = partes[partes.length - 1];
             
             
             
             atualizarSugestoes();
         }
    }                                 

    
   
    
    
    
    
    
    
 //----------------- TRIE --------------------------   
    
private void configurarPainelDeSugestoes() {
    panelSugestoes.removeAll();
    panelSugestoes.setLayout(new BoxLayout(panelSugestoes, BoxLayout.X_AXIS));
    
}

private void ligarTecladoVirtual() {
    JButton[] botoes = {qBtn, wBtn, eBtn, rBtn, tBtn, yBtn, uBtn, iBtn, oBtn, pBtn,
                        aBtn, sBtn, dBtn, fBtn, gBtn, hBtn, jBtn, kBtn, lBtn, ccBtn,
                        zBtn, xBtn, cBtn, vBtn, bBtn, nBtn, mBtn};

    for (JButton b : botoes) {
        b.addActionListener(e -> {
            palavraDigitada += b.getText().toLowerCase();
            inputKeyboards.setText(palavraDigitada);
            atualizarSugestoes();
        });
    }

    deleteBtn.addActionListener(e -> {
        if (!palavraDigitada.isEmpty()) {
            palavraDigitada = palavraDigitada.substring(0, palavraDigitada.length()-1);
            inputKeyboards.setText(palavraDigitada);
            atualizarSugestoes();
        }
    });

    // ← AQUI É ONDE VÃO OS DOIS CÓDIGOS QUE MANDASTE
    spaceBtn.addActionListener(e -> {
        palavraDigitada += " ";
        inputKeyboards.setText(palavraDigitada);
        atualizarSugestoes();
    });

    enterBtn.addActionListener(e -> {
        JOptionPane.showMessageDialog(this, "Palavra: " + palavraDigitada);
        // ou limpar: palavraDigitada = ""; jTextField1.setText("");
    });
}


private void atualizarSugestoes() {
    configurarPainelDeSugestoes();
     List<String> sugestoes = null;

    if (palavraDigitada.isEmpty()) {
        JLabel vazio = new JLabel("Toca numa letra...");
        vazio.setForeground(Color.LIGHT_GRAY);
        panelSugestoes.add(vazio);
    } else {
        if (menuFlag==1){
            sugestoes = PreditorInteligente.obterSugestoes(palavraDigitada, trie, 5);
            }
        if(menuFlag==2){
            
        }if(menuFlag==3){
            sugestoes = engine.getSuggetions(palavraDigitada);
        
        }
            

        for (int i = 0; i < sugestoes.size() && i < 5; i++) {
            String s = sugestoes.get(i);
            JButton btn = new JButton(s);
            btn.setPreferredSize(new Dimension(100, 30));
            btn.addActionListener(e -> {
                palavraDigitada = s;
                inputKeyboards.setText(palavraDigitada);
            });
            panelSugestoes.add(btn);
            if (i < sugestoes.size() - 1) {
                panelSugestoes.add(Box.createHorizontalStrut(8));
            }
        }
    }

    panelSugestoes.revalidate();
    panelSugestoes.repaint();
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPanel = new javax.swing.JPanel();
        btnMenuAVL = new javax.swing.JButton();
        btnMenuTrie = new javax.swing.JButton();
        btnMenuArrays = new javax.swing.JButton();
        btnMenuTestes = new javax.swing.JButton();
        btnMenuSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ChatPanel = new javax.swing.JPanel();
        KeyBoardPanel = new javax.swing.JPanel();
        lBtn = new javax.swing.JButton();
        bBtn = new javax.swing.JButton();
        cBtn = new javax.swing.JButton();
        mBtn = new javax.swing.JButton();
        xBtn = new javax.swing.JButton();
        zBtn = new javax.swing.JButton();
        vBtn = new javax.swing.JButton();
        spaceBtn = new javax.swing.JButton();
        enterBtn = new javax.swing.JButton();
        oBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        iBtn = new javax.swing.JButton();
        ccBtn = new javax.swing.JButton();
        uBtn = new javax.swing.JButton();
        dBtn = new javax.swing.JButton();
        gBtn = new javax.swing.JButton();
        hBtn = new javax.swing.JButton();
        jBtn = new javax.swing.JButton();
        kBtn = new javax.swing.JButton();
        sBtn = new javax.swing.JButton();
        fBtn = new javax.swing.JButton();
        wBtn = new javax.swing.JButton();
        qBtn = new javax.swing.JButton();
        eBtn = new javax.swing.JButton();
        tBtn = new javax.swing.JButton();
        yBtn = new javax.swing.JButton();
        rBtn = new javax.swing.JButton();
        pBtn = new javax.swing.JButton();
        aBtn = new javax.swing.JButton();
        nBtn = new javax.swing.JButton();
        painelSuperior = new javax.swing.JPanel();
        inputKeyboards = new javax.swing.JTextField();
        panelSugestoes = new javax.swing.JPanel();
        btnReturnToMenu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        MenuPanel.setBackground(new java.awt.Color(0, 51, 51));
        MenuPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnMenuAVL.setBackground(new java.awt.Color(0, 0, 255));
        btnMenuAVL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMenuAVL.setForeground(new java.awt.Color(255, 255, 255));
        btnMenuAVL.setText("Árvore AVL");
        btnMenuAVL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuAVL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuAVLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuAVLMouseExited(evt);
            }
        });
        btnMenuAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAVLActionPerformed(evt);
            }
        });

        btnMenuTrie.setBackground(new java.awt.Color(0, 0, 255));
        btnMenuTrie.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMenuTrie.setForeground(new java.awt.Color(255, 255, 255));
        btnMenuTrie.setText(" Trie");
        btnMenuTrie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuTrie.setMaximumSize(new java.awt.Dimension(127, 32));
        btnMenuTrie.setMinimumSize(new java.awt.Dimension(127, 32));
        btnMenuTrie.setPreferredSize(new java.awt.Dimension(127, 32));
        btnMenuTrie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuTrieMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuTrieMouseExited(evt);
            }
        });
        btnMenuTrie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuTrieActionPerformed(evt);
            }
        });

        btnMenuArrays.setBackground(new java.awt.Color(0, 0, 255));
        btnMenuArrays.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMenuArrays.setForeground(new java.awt.Color(255, 255, 255));
        btnMenuArrays.setText("Arrays");
        btnMenuArrays.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuArrays.setMaximumSize(new java.awt.Dimension(127, 32));
        btnMenuArrays.setMinimumSize(new java.awt.Dimension(127, 32));
        btnMenuArrays.setPreferredSize(new java.awt.Dimension(127, 32));
        btnMenuArrays.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuArraysMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuArraysMouseExited(evt);
            }
        });
        btnMenuArrays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuArraysActionPerformed(evt);
            }
        });

        btnMenuTestes.setBackground(new java.awt.Color(0, 0, 255));
        btnMenuTestes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMenuTestes.setForeground(new java.awt.Color(255, 255, 255));
        btnMenuTestes.setText("Testes");
        btnMenuTestes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuTestes.setMaximumSize(new java.awt.Dimension(127, 32));
        btnMenuTestes.setMinimumSize(new java.awt.Dimension(127, 32));
        btnMenuTestes.setPreferredSize(new java.awt.Dimension(127, 32));
        btnMenuTestes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuTestesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuTestesMouseExited(evt);
            }
        });
        btnMenuTestes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuTestesActionPerformed(evt);
            }
        });

        btnMenuSair.setBackground(new java.awt.Color(0, 0, 255));
        btnMenuSair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMenuSair.setForeground(new java.awt.Color(255, 255, 255));
        btnMenuSair.setText("Sair");
        btnMenuSair.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        btnMenuSair.setMaximumSize(new java.awt.Dimension(127, 32));
        btnMenuSair.setMinimumSize(new java.awt.Dimension(127, 32));
        btnMenuSair.setPreferredSize(new java.awt.Dimension(127, 32));
        btnMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuSairMouseExited(evt);
            }
        });
        btnMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuSairActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU PRINCIPAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMenuAVL, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenuTrie, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenuArrays, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenuTestes, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenuSair, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(186, 186, 186))))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuTrie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMenuAVL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMenuArrays, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMenuTestes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnMenuSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );

        getContentPane().add(MenuPanel, "card2");

        ChatPanel.setBackground(new java.awt.Color(51, 51, 51));

        KeyBoardPanel.setBackground(new java.awt.Color(51, 51, 51));
        KeyBoardPanel.setBorder(new javax.swing.border.MatteBorder(null));
        KeyBoardPanel.setForeground(new java.awt.Color(255, 255, 255));
        KeyBoardPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        KeyBoardPanel.setMaximumSize(new java.awt.Dimension(470, 170));
        KeyBoardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lBtn.setBackground(new java.awt.Color(51, 51, 51));
        lBtn.setText("L");
        lBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(lBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 40, 45));

        bBtn.setBackground(new java.awt.Color(51, 51, 51));
        bBtn.setText("B");
        bBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(bBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 40, 45));

        cBtn.setBackground(new java.awt.Color(51, 51, 51));
        cBtn.setText("C");
        cBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(cBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 40, 45));

        mBtn.setBackground(new java.awt.Color(51, 51, 51));
        mBtn.setText("M");
        mBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(mBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 40, 45));

        xBtn.setBackground(new java.awt.Color(51, 51, 51));
        xBtn.setText("X");
        xBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(xBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 40, 45));

        zBtn.setBackground(new java.awt.Color(51, 51, 51));
        zBtn.setText("Z");
        zBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(zBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 40, 45));

        vBtn.setBackground(new java.awt.Color(51, 51, 51));
        vBtn.setText("V");
        vBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(vBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 40, 45));

        spaceBtn.setBackground(new java.awt.Color(51, 51, 51));
        spaceBtn.setText("space");
        KeyBoardPanel.add(spaceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 231, 40));

        enterBtn.setBackground(new java.awt.Color(51, 51, 51));
        enterBtn.setText("<----\"");
        enterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(enterBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 120, 40));

        oBtn.setBackground(new java.awt.Color(51, 51, 51));
        oBtn.setText("O");
        oBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(oBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 40, 45));

        deleteBtn.setBackground(new java.awt.Color(51, 51, 51));
        deleteBtn.setText("<---");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 88, 40));

        iBtn.setBackground(new java.awt.Color(51, 51, 51));
        iBtn.setText("I");
        KeyBoardPanel.add(iBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 40, 45));

        ccBtn.setBackground(new java.awt.Color(51, 51, 51));
        ccBtn.setText("Ç");
        ccBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(ccBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 40, 45));

        uBtn.setBackground(new java.awt.Color(51, 51, 51));
        uBtn.setText("U");
        KeyBoardPanel.add(uBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 40, 45));

        dBtn.setBackground(new java.awt.Color(51, 51, 51));
        dBtn.setText("D");
        dBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(dBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 40, 45));

        gBtn.setBackground(new java.awt.Color(51, 51, 51));
        gBtn.setText("G");
        gBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(gBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 40, 45));

        hBtn.setBackground(new java.awt.Color(51, 51, 51));
        hBtn.setText("H");
        hBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(hBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 40, 45));

        jBtn.setBackground(new java.awt.Color(51, 51, 51));
        jBtn.setText("J");
        jBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(jBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 40, 45));

        kBtn.setBackground(new java.awt.Color(51, 51, 51));
        kBtn.setText("K");
        kBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(kBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 40, 45));

        sBtn.setBackground(new java.awt.Color(51, 51, 51));
        sBtn.setText("S");
        sBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(sBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 40, 45));

        fBtn.setBackground(new java.awt.Color(51, 51, 51));
        fBtn.setText("F");
        fBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(fBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 40, 45));

        wBtn.setBackground(new java.awt.Color(51, 51, 51));
        wBtn.setText("W");
        wBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(wBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 40, 45));

        qBtn.setBackground(new java.awt.Color(51, 51, 51));
        qBtn.setText("Q");
        qBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                qBtnMousePressed(evt);
            }
        });
        KeyBoardPanel.add(qBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 45));

        eBtn.setBackground(new java.awt.Color(51, 51, 51));
        eBtn.setText("E");
        eBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(eBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 40, 45));

        tBtn.setBackground(new java.awt.Color(51, 51, 51));
        tBtn.setText("T");
        tBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(tBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 40, 45));

        yBtn.setBackground(new java.awt.Color(51, 51, 51));
        yBtn.setText("Y");
        KeyBoardPanel.add(yBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 40, 45));

        rBtn.setBackground(new java.awt.Color(51, 51, 51));
        rBtn.setText("R");
        rBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(rBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 40, 45));

        pBtn.setBackground(new java.awt.Color(51, 51, 51));
        pBtn.setText("P");
        pBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(pBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 40, 45));

        aBtn.setBackground(new java.awt.Color(51, 51, 51));
        aBtn.setText("A");
        aBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(aBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 40, 45));

        nBtn.setBackground(new java.awt.Color(51, 51, 51));
        nBtn.setText("N");
        nBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nBtnActionPerformed(evt);
            }
        });
        KeyBoardPanel.add(nBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 40, 45));

        painelSuperior.setBackground(new java.awt.Color(0, 51, 51));
        painelSuperior.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 30, 10, 30));

        inputKeyboards.setBackground(new java.awt.Color(102, 102, 102));
        inputKeyboards.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        inputKeyboards.setForeground(new java.awt.Color(255, 255, 255));
        inputKeyboards.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputKeyboards.setText("Escreva algo..");
        inputKeyboards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputKeyboardsActionPerformed(evt);
            }
        });

        panelSugestoes.setBackground(new java.awt.Color(0, 51, 51));
        panelSugestoes.setMaximumSize(new java.awt.Dimension(470, 170));
        panelSugestoes.setMinimumSize(new java.awt.Dimension(470, 170));
        panelSugestoes.setPreferredSize(new java.awt.Dimension(470, 170));
        panelSugestoes.setLayout(new javax.swing.BoxLayout(panelSugestoes, javax.swing.BoxLayout.X_AXIS));

        btnReturnToMenu.setText("<<<");
        btnReturnToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnToMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelSuperiorLayout = new javax.swing.GroupLayout(painelSuperior);
        painelSuperior.setLayout(painelSuperiorLayout);
        painelSuperiorLayout.setHorizontalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSugestoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addGroup(painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnReturnToMenu))
                    .addGroup(painelSuperiorLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(inputKeyboards, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelSuperiorLayout.setVerticalGroup(
            painelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperiorLayout.createSequentialGroup()
                .addComponent(btnReturnToMenu)
                .addGap(75, 75, 75)
                .addComponent(inputKeyboards, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(panelSugestoes, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout ChatPanelLayout = new javax.swing.GroupLayout(ChatPanel);
        ChatPanel.setLayout(ChatPanelLayout);
        ChatPanelLayout.setHorizontalGroup(
            ChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ChatPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(KeyBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ChatPanelLayout.setVerticalGroup(
            ChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChatPanelLayout.createSequentialGroup()
                .addComponent(painelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(KeyBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(ChatPanel, "card3");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Testar");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TESTES entre ESTRUTURAS DE DADOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Selecione uma:");

        jLabel4.setText("Selecione outra :");

        jLabel5.setText("Total de testes:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(82, 82, 82)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lBtnActionPerformed

    private void bBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBtnActionPerformed

    private void cBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBtnActionPerformed

    private void mBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mBtnActionPerformed

    private void xBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xBtnActionPerformed

    private void zBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zBtnActionPerformed

    private void vBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vBtnActionPerformed

    private void oBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void ccBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ccBtnActionPerformed

    private void dBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dBtnActionPerformed

    private void gBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gBtnActionPerformed

    private void hBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hBtnActionPerformed

    private void jBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnActionPerformed

    private void kBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kBtnActionPerformed

    private void sBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sBtnActionPerformed

    private void fBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fBtnActionPerformed

    private void wBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wBtnActionPerformed

    private void qBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qBtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_qBtnMousePressed

    private void eBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eBtnActionPerformed

    private void tBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tBtnActionPerformed

    private void rBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBtnActionPerformed

    private void pBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pBtnActionPerformed

    private void aBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aBtnActionPerformed

    private void nBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nBtnActionPerformed

    private void btnMenuTrieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuTrieActionPerformed
        

        new javax.swing.Timer(2000, e -> {  
            
            MenuPanel.setVisible(false);    
            ChatPanel.setVisible(true);
            menuFlag=1;
            ((javax.swing.Timer)e.getSource()).stop();
        }).start();
        
    }//GEN-LAST:event_btnMenuTrieActionPerformed

    private void inputKeyboardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputKeyboardsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputKeyboardsActionPerformed

    private void enterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterBtnActionPerformed

    private void btnReturnToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnToMenuActionPerformed
               
    new javax.swing.Timer(1000, e -> {
         MenuPanel.setVisible(true);    
        ChatPanel.setVisible(false);// TODO add your handling code here:
        
        ((javax.swing.Timer)e.getSource()).stop();
    }).start();
    }//GEN-LAST:event_btnReturnToMenuActionPerformed

    private void btnMenuArraysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuArraysActionPerformed
        MenuPanel.setVisible(false);    
        ChatPanel.setVisible(true);
            
        menuFlag=3;// TODO add your handling code here:
    }//GEN-LAST:event_btnMenuArraysActionPerformed

    private void btnMenuTestesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuTestesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuTestesActionPerformed

    private void btnMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnMenuSairActionPerformed

    private void btnMenuTrieMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuTrieMouseEntered
               btnMenuTrie.setBackground(new Color(9, 89, 234));
    }//GEN-LAST:event_btnMenuTrieMouseEntered

    private void btnMenuTrieMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuTrieMouseExited
        // TODO add your handling code here:
        btnMenuTrie.setBackground(Color.BLUE);
    }//GEN-LAST:event_btnMenuTrieMouseExited

    private void btnMenuAVLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuAVLMouseEntered
       btnMenuAVL.setBackground(new Color(9, 89, 234));
    }//GEN-LAST:event_btnMenuAVLMouseEntered

    private void btnMenuArraysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuArraysMouseEntered
         btnMenuArrays.setBackground(new Color(9, 89, 234));
    }//GEN-LAST:event_btnMenuArraysMouseEntered

    private void btnMenuTestesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuTestesMouseEntered
         btnMenuTestes.setBackground(new Color(9, 89, 234));
    }//GEN-LAST:event_btnMenuTestesMouseEntered

    private void btnMenuSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuSairMouseEntered
         btnMenuSair.setBackground(Color.red);
    }//GEN-LAST:event_btnMenuSairMouseEntered

    private void btnMenuAVLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuAVLMouseExited
        
        btnMenuAVL.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_btnMenuAVLMouseExited

    private void btnMenuArraysMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuArraysMouseExited
        btnMenuArrays.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_btnMenuArraysMouseExited

    private void btnMenuTestesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuTestesMouseExited
        btnMenuTestes.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_btnMenuTestesMouseExited

    private void btnMenuSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuSairMouseExited
        btnMenuSair.setBackground(new Color(0,0,255));
    }//GEN-LAST:event_btnMenuSairMouseExited

    private void btnMenuAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAVLActionPerformed
        menuFlag=2;// TODO add your handling code here:
    }//GEN-LAST:event_btnMenuAVLActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FramePrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChatPanel;
    private javax.swing.JPanel KeyBoardPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JButton aBtn;
    private javax.swing.JButton bBtn;
    private javax.swing.JButton btnMenuAVL;
    private javax.swing.JButton btnMenuArrays;
    private javax.swing.JButton btnMenuSair;
    private javax.swing.JButton btnMenuTestes;
    private javax.swing.JButton btnMenuTrie;
    private javax.swing.JButton btnReturnToMenu;
    private javax.swing.JButton cBtn;
    private javax.swing.JButton ccBtn;
    private javax.swing.JButton dBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton eBtn;
    private javax.swing.JButton enterBtn;
    private javax.swing.JButton fBtn;
    private javax.swing.JButton gBtn;
    private javax.swing.JButton hBtn;
    private javax.swing.JButton iBtn;
    private javax.swing.JTextField inputKeyboards;
    private javax.swing.JButton jBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton kBtn;
    private javax.swing.JButton lBtn;
    private javax.swing.JButton mBtn;
    private javax.swing.JButton nBtn;
    private javax.swing.JButton oBtn;
    private javax.swing.JButton pBtn;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JPanel panelSugestoes;
    private javax.swing.JButton qBtn;
    private javax.swing.JButton rBtn;
    private javax.swing.JButton sBtn;
    private javax.swing.JButton spaceBtn;
    private javax.swing.JButton tBtn;
    private javax.swing.JButton uBtn;
    private javax.swing.JButton vBtn;
    private javax.swing.JButton wBtn;
    private javax.swing.JButton xBtn;
    private javax.swing.JButton yBtn;
    private javax.swing.JButton zBtn;
    // End of variables declaration//GEN-END:variables
}
