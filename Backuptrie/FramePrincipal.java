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
    private Trie trie;                         // a tua trie
    private static final String TRIE_SALVA = "dicionario_lusiadas.trie";
    
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
        
        limparSugestoes();


    
    //   --------------TRIE----------------
        trie = ListaPalavras.carregarTrie(TRIE_SALVA);
    if (trie == null) {
        trie = new Trie();
        ListaPalavras.carregarDeFicheiro("lusiadas.txt", trie);
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
         String textoAtual = txtVisor.getText();
         
         //Escreve no jTextField
         txtVisor.setText(textoAtual + letra);
         
         //Descobrir a ultima palavra escrita
         String[] partes = txtVisor.getText().split(" ");
         if (partes.length>0) {
             String ultimaPalavra = partes[partes.length - 1];
             
             List<String> sugestoes = engine.getSuggetions(ultimaPalavra);
             
             atualizarBotoesSugestao(sugestoes);
         }
    }                                 

    
    private void atualizarBotoesSugestao(List<String> sugestoes) {
        limparSugestoes();
        
        if (sugestoes.size()>0) btnSugestao1.setText(sugestoes.get(0));
        if (sugestoes.size()>1) btnSugestao2.setText(sugestoes.get(1));
        if (sugestoes.size()>2) btnSugestao3.setText(sugestoes.get(2));
    }
    
    private void limparSugestoes() {
        btnSugestao1.setText("");
        btnSugestao2.setText("");
        btnSugestao3.setText("");
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

    if (palavraDigitada.isEmpty()) {
        JLabel vazio = new JLabel("Toca numa letra...");
        vazio.setForeground(Color.LIGHT_GRAY);
        panelSugestoes.add(vazio);
    } else {
        List<String> sugestoes = PreditorInteligente.obterSugestoes(palavraDigitada, trie, 5);

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
        panelArray = new javax.swing.JPanel();
        panelKeyboardArray = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        backSpaceButton = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        txtVisor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSugestao1 = new javax.swing.JButton();
        btnSugestao2 = new javax.swing.JButton();
        btnSugestao3 = new javax.swing.JButton();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnMenuTrie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuArrays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuAVL, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(btnMenuSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuTestes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            .addComponent(panelSugestoes, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
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

        panelKeyboardArray.setBackground(new java.awt.Color(102, 102, 102));

        jButton1.setText("A");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1teclaPressionada(evt);
            }
        });

        jButton2.setText("S");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2teclaPressionada(evt);
            }
        });

        jButton3.setText("D");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3teclaPressionada(evt);
            }
        });

        jButton4.setText("F");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4teclaPressionada(evt);
            }
        });

        jButton5.setText("G");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5teclaPressionada(evt);
            }
        });

        jButton6.setText("H");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6teclaPressionada(evt);
            }
        });

        jButton7.setText("J");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7teclaPressionada(evt);
            }
        });

        jButton8.setText("K");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8teclaPressionada(evt);
            }
        });

        jButton9.setText("L");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9teclaPressionada(evt);
            }
        });

        jButton10.setText("Q");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10teclaPressionada(evt);
            }
        });

        jButton11.setText("W");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11teclaPressionada(evt);
            }
        });

        jButton12.setText("E");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12teclaPressionada(evt);
            }
        });

        jButton13.setText("R");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13teclaPressionada(evt);
            }
        });

        jButton14.setText("T");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14teclaPressionada(evt);
            }
        });

        jButton15.setText("Y");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15teclaPressionada(evt);
            }
        });

        jButton16.setText("U");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16teclaPressionada(evt);
            }
        });

        jButton17.setText("I");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17teclaPressionada(evt);
            }
        });

        jButton18.setText("P");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18teclaPressionada(evt);
            }
        });

        jButton19.setText("O");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19teclaPressionada(evt);
            }
        });

        backSpaceButton.setText("DEL");
        backSpaceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backSpaceButtonteclaPressionada(evt);
            }
        });

        jButton24.setText("Caps Lock");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24teclaPressionada(evt);
            }
        });

        jButton25.setText("Z");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25teclaPressionada(evt);
            }
        });

        jButton26.setText("X");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26teclaPressionada(evt);
            }
        });

        jButton27.setText("C");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27teclaPressionada(evt);
            }
        });

        jButton28.setText("V");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28teclaPressionada(evt);
            }
        });

        jButton29.setText("B");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29teclaPressionada(evt);
            }
        });

        jButton30.setText("N");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30teclaPressionada(evt);
            }
        });

        jButton31.setText("M");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31teclaPressionada(evt);
            }
        });

        jButton35.setText("Enter");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35teclaPressionada(evt);
            }
        });

        jButton32.setText("?123");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32teclaPressionada(evt);
            }
        });

        javax.swing.GroupLayout panelKeyboardArrayLayout = new javax.swing.GroupLayout(panelKeyboardArray);
        panelKeyboardArray.setLayout(panelKeyboardArrayLayout);
        panelKeyboardArrayLayout.setHorizontalGroup(
            panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKeyboardArrayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKeyboardArrayLayout.createSequentialGroup()
                        .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelKeyboardArrayLayout.createSequentialGroup()
                        .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelKeyboardArrayLayout.createSequentialGroup()
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backSpaceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelKeyboardArrayLayout.setVerticalGroup(
            panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKeyboardArrayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backSpaceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelKeyboardArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        txtVisor.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtVisor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtVisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVisorActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));

        btnSugestao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSugestao1cliqueSugestao(evt);
            }
        });

        btnSugestao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSugestao2cliqueSugestoes(evt);
            }
        });

        btnSugestao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSugestao3cliqueSugestoes(evt);
            }
        });

        javax.swing.GroupLayout panelArrayLayout = new javax.swing.GroupLayout(panelArray);
        panelArray.setLayout(panelArrayLayout);
        panelArrayLayout.setHorizontalGroup(
            panelArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArrayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVisor)
                    .addGroup(panelArrayLayout.createSequentialGroup()
                        .addGroup(panelArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelArrayLayout.createSequentialGroup()
                                .addComponent(btnSugestao1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(btnSugestao2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSugestao3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelKeyboardArray, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelArrayLayout.setVerticalGroup(
            panelArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArrayLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(txtVisor)
                .addGap(18, 18, 18)
                .addGroup(panelArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelArrayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSugestao1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnSugestao3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSugestao2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelKeyboardArray, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelArray, "card4");

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
        // TODO add your handling code here:
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuAVLActionPerformed

    private void jButton1teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton1teclaPressionada

    private void jButton2teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton2teclaPressionada

    private void jButton3teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton3teclaPressionada

    private void jButton4teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton4teclaPressionada

    private void jButton5teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton5teclaPressionada

    private void jButton6teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton6teclaPressionada

    private void jButton7teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton7teclaPressionada

    private void jButton8teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton8teclaPressionada

    private void jButton9teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton9teclaPressionada

    private void jButton10teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton10teclaPressionada

    private void jButton11teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton11teclaPressionada

    private void jButton12teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton12teclaPressionada

    private void jButton13teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton13teclaPressionada

    private void jButton14teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton14teclaPressionada

    private void jButton15teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton15teclaPressionada

    private void jButton16teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton16teclaPressionada

    private void jButton17teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton17teclaPressionada

    private void jButton18teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton18teclaPressionada

    private void jButton19teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton19teclaPressionada

    private void backSpaceButtonteclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backSpaceButtonteclaPressionada
        // TODO add your handling code here:
        String t = txtVisor.getText();

        if (t.length() >0) {
            txtVisor.setText(t.substring(0, t.length() - 1));
        }
    }//GEN-LAST:event_backSpaceButtonteclaPressionada

    private void jButton24teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24teclaPressionada
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24teclaPressionada

    private void jButton25teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton25teclaPressionada

    private void jButton26teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton26teclaPressionada

    private void jButton27teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton27teclaPressionada

    private void jButton28teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton28teclaPressionada

    private void jButton29teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton29teclaPressionada

    private void jButton30teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton30teclaPressionada

    private void jButton31teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31teclaPressionada
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        String letra = botao.getText();
        String textoAtual = txtVisor.getText();

        //Escreve no jTextField
        txtVisor.setText(textoAtual + letra);

        //Descobrir a ultima palavra escrita
        String[] partes = txtVisor.getText().split(" ");
        if (partes.length>0) {
            String ultimaPalavra = partes[partes.length - 1];

            List<String> sugestoes = engine.getSuggetions(ultimaPalavra);

            atualizarBotoesSugestao(sugestoes);
        }
    }//GEN-LAST:event_jButton31teclaPressionada

    private void jButton35teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35teclaPressionada
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35teclaPressionada

    private void jButton32teclaPressionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32teclaPressionada
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton32teclaPressionada

    private void txtVisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVisorActionPerformed

    private void btnSugestao1cliqueSugestao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSugestao1cliqueSugestao
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSugestao1cliqueSugestao

    private void btnSugestao2cliqueSugestoes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSugestao2cliqueSugestoes
        // TODO add your handling code here:
        javax.swing.JButton botaoClicado = (javax.swing.JButton) evt.getSource();
        String palavraSugerida = botaoClicado.getText();

        if (palavraSugerida.isEmpty()) return;

        String textoCompleto = txtVisor.getText();
        //Logica para substituir a palavra incompleta pela sugerida
        //Encontramos o ultimo espaço para saber onde começa a palavra atual
        int ultimoEspaco = textoCompleto.lastIndexOf(" ");

        if (ultimoEspaco == -1) {
            //Se for a primeira palavra do texto
            txtVisor.setText(palavraSugerida + " ");
        } else {
            //Se for uma palavra no meio do texto, mantemos o que estava antes
            String inicioTexto = textoCompleto.substring(0, ultimoEspaco+1);
            txtVisor.setText(inicioTexto + palavraSugerida + " ");
        }

        //Limpa as sugestoes depois de escolher uma
        limparSugestoes();
    }//GEN-LAST:event_btnSugestao2cliqueSugestoes

    private void btnSugestao3cliqueSugestoes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSugestao3cliqueSugestoes
        // TODO add your handling code here:
        javax.swing.JButton botaoClicado = (javax.swing.JButton) evt.getSource();
        String palavraSugerida = botaoClicado.getText();

        if (palavraSugerida.isEmpty()) return;

        String textoCompleto = txtVisor.getText();
        //Logica para substituir a palavra incompleta pela sugerida
        //Encontramos o ultimo espaço para saber onde começa a palavra atual
        int ultimoEspaco = textoCompleto.lastIndexOf(" ");

        if (ultimoEspaco == -1) {
            //Se for a primeira palavra do texto
            txtVisor.setText(palavraSugerida + " ");
        } else {
            //Se for uma palavra no meio do texto, mantemos o que estava antes
            String inicioTexto = textoCompleto.substring(0, ultimoEspaco+1);
            txtVisor.setText(inicioTexto + palavraSugerida + " ");
        }

        //Limpa as sugestoes depois de escolher uma
        limparSugestoes();
    }//GEN-LAST:event_btnSugestao3cliqueSugestoes

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
    private javax.swing.JButton backSpaceButton;
    private javax.swing.JButton btnMenuAVL;
    private javax.swing.JButton btnMenuArrays;
    private javax.swing.JButton btnMenuSair;
    private javax.swing.JButton btnMenuTestes;
    private javax.swing.JButton btnMenuTrie;
    private javax.swing.JButton btnReturnToMenu;
    private javax.swing.JButton btnSugestao1;
    private javax.swing.JButton btnSugestao2;
    private javax.swing.JButton btnSugestao3;
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
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton kBtn;
    private javax.swing.JButton lBtn;
    private javax.swing.JButton mBtn;
    private javax.swing.JButton nBtn;
    private javax.swing.JButton oBtn;
    private javax.swing.JButton pBtn;
    private javax.swing.JPanel painelSuperior;
    private javax.swing.JPanel panelArray;
    private javax.swing.JPanel panelKeyboardArray;
    private javax.swing.JPanel panelSugestoes;
    private javax.swing.JButton qBtn;
    private javax.swing.JButton rBtn;
    private javax.swing.JButton sBtn;
    private javax.swing.JButton spaceBtn;
    private javax.swing.JButton tBtn;
    private javax.swing.JTextField txtVisor;
    private javax.swing.JButton uBtn;
    private javax.swing.JButton vBtn;
    private javax.swing.JButton wBtn;
    private javax.swing.JButton xBtn;
    private javax.swing.JButton yBtn;
    private javax.swing.JButton zBtn;
    // End of variables declaration//GEN-END:variables
}
