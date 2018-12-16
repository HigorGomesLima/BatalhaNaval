package interfaces;

import batalhanaval.Tabuleiro;
import javax.swing.JOptionPane;
import batalhanaval.Conexao;
import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Tela extends javax.swing.JFrame {

    private String nome;
    private int altura;
    private int largura;
    private IconNaval fabricaImagem;

    public Tela() {
        initComponents();
        Conexao cc;
        Object[] a = {"Criar um Novo Jogo", "Conectar em um ja existente"};
        boolean controle0 = false;
        do {
            controle0 = false;
            Object opcao = JOptionPane.showInputDialog(null,
                    "Escolha uma das opções",
                    "Entrar",
                    JOptionPane.PLAIN_MESSAGE,
                    null, a,
                    a[0]);
            if (opcao == a[0]) {
                boolean controle = true;
                do {
                    String nome = null;
                    String tamanhoH = JOptionPane.showInputDialog("Digite a altura do oceano");
                    String tamanhoL = JOptionPane.showInputDialog("Digite a largura do oceano");
                    nome = JOptionPane.showInputDialog("Digite o nome");
                    Tabuleiro.newGame(Integer.parseInt(tamanhoH), Integer.parseInt(tamanhoL), nome);
                    if (Tabuleiro.getGame() == null || "".equals(nome)) {
                        JOptionPane.showMessageDialog(null, "Erro na criação");
                    } else {
                        this.nome = nome;
                        this.altura = Integer.parseInt(tamanhoH);
                        this.largura = Integer.parseInt(tamanhoL);
                        controle = false;
                    }
                } while (controle);
                try {
                    cc = new Conexao(7777);
                    JOptionPane.showMessageDialog(null, "Servidor criado" + cc.getIp());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro na conexao " + ex.getMessage());
                    controle0 = true;
                }
            } else {
                String ip = JOptionPane.showInputDialog("Digite o IP");
                try {
                    cc = new Conexao(ip, 7777);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro na conexao " + ex.getMessage());
                    controle0 = true;
                }
            }
        } while (controle0);
        this.setPreferredSize(new Dimension(altura*30*3,largura*30*3));
        fabricaImagem = new IconNaval();
        this.lnome.setName(nome);
        //CRIAR TABELA
        tabela.setPreferredSize(new Dimension(altura*30,largura*30));
        DefaultTableModel modelo = (DefaultTableModel) this.tabela.getModel();
        for (int i = 0; i < largura; i++) {
            modelo.addColumn("");
            //  tabela.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
        }
        for (int i = 0; i < largura; i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
            tabela.getColumnModel().getColumn(i).setWidth(30);
        }
        for (int i = 0; i < altura; i++) {
            Object[] linha = new Object[largura];
            for (int j = 0; j < largura; j++) {
                linha[j] = fabricaImagem.getImagem("agua");
            }
            modelo.addRow(linha);
        }
            tabela.setRowHeight(30);
        

    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            lbl.setIcon((ImageIcon) value);
            lbl.setSize(30, 30);
            return lbl;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lnome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Informacao");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabela);

        lnome.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lnome, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lnome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lnome;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
