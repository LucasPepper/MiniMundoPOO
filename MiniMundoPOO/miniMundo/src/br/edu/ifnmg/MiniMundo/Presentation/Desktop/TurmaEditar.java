/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.MiniMundo.Presentation.Desktop;

import br.edu.ifnmg.MiniMundo.DomainModel.Operador;
import br.edu.ifnmg.MiniMundo.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.MiniMundo.Persistence.OperadorRepositorio;

import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author petronio
 */
public class TurmaEditar extends javax.swing.JInternalFrame {

    private Turma turma;
    
    private TurmaRepositorio repositorio;
    
    private ProfessorRepositorio prof_repo;
    
    private OperadorRepositorio Operador_repo;
    
    /**
     * Creates new form TurmaEditar
     */
    public TurmaEditar(Turma turma, TurmaRepositorio repo) {
        initComponents();
        
        this.turma = turma;
        this.repositorio = repo;
        
        prof_repo = new ProfessorRepositorio();
        
        Operador_repo = new OperadorRepositorio();
        
        List<Professor> professores = prof_repo.Buscar(null);
        
        ComboBoxModel<Professor> model_professores 
                = new DefaultComboBoxModel<>(new Vector(professores));
        
        cbxProfessores.setModel(model_professores);
        
        List<Operador> Operadors = Operador_repo.Buscar(null);
        
        ComboBoxModel<Operador> model_Operadors 
                = new DefaultComboBoxModel<>(new Vector(Operadors));
        
        cbxOperadors.setModel(model_Operadors);
        
        setTurma(turma);
        
    }

    public Turma getTurma() throws ErroValidacaoException {
        
        turma.setSemestre(txtSemestre.getText());
        turma.setProfessor((Professor)cbxProfessores.getSelectedItem());
        
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
        
        txtSemestre.setText( turma.getSemestre() );
        cbxProfessores.setSelectedItem(turma.getProfessor());
        
        carregaTabelaOperadors(turma.getOperadors());
        
    }
    
    private void carregaTabelaOperadors(List<Operador> Operadors){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Sexo");
        
        for(Operador a : Operadors){
            Vector linha = new Vector();
            linha.add(a.getId());
            linha.add(a.getNome());
            linha.add(a.getCpf());
            linha.add(a.getSexo());
            
            modelo.addRow(linha);
        }
       
        tabOperadors.setModel(modelo);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSemestre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxProfessores = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbxAlunos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabAlunos = new javax.swing.JTable();
        btnAdicionarAluno = new javax.swing.JButton();
        btnRemoverAluno = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Edição de Turmas");

        jLabel1.setText("Semestre:");

        jLabel2.setText("Professor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados Gerais", jPanel1);

        jLabel3.setText("Aluno:");

        tabAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabAlunos);

        btnAdicionarAluno.setText("Adicionar");
        btnAdicionarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAlunoActionPerformed(evt);
            }
        });

        btnRemoverAluno.setText("Remover");
        btnRemoverAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxAlunos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdicionarAluno)
                        .addGap(41, 41, 41)
                        .addComponent(btnRemoverAluno)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarAluno)
                    .addComponent(btnRemoverAluno))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Alunos", jPanel2);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnApagar.setText("Apagar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(132, 132, 132)
                        .addComponent(btnCancelar)
                        .addGap(107, 107, 107)
                        .addComponent(btnApagar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnApagar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAlunoActionPerformed
        
        Operador Operador = (Operador)cbxOperadors.getSelectedItem();
        
        this.turma.addOperador(Operador);
        
        carregaTabelaOperadors(this.turma.getOperadors());
    }//GEN-LAST:event_btnAdicionarAlunoActionPerformed

    private void btnRemoverAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverAlunoActionPerformed
        int linha = this.tabOperadors.getSelectedRow();
        
        int id = Integer.parseInt( this.tabOperadors.getValueAt(linha, 0).toString() );
        
        Operador Operador = Operador_repo.Abrir(id);
        
        this.turma.removeOperador(Operador);
        
        carregaTabelaOperadors(this.turma.getOperadors());
        
    }//GEN-LAST:event_btnRemoverAlunoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        try {
            Turma turma;
            turma = getTurma();

            // Mostra mensagem de confirmação
            if( JOptionPane.showConfirmDialog(null, "Deseja realmente salvar as alterações?", 
                    "Confirmar", JOptionPane.YES_NO_OPTION) == 0) {

                // Clicou no botão Sim na mensagem de confirmação
                if(this.repositorio.Salvar(turma))
                    JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
                else
                    JOptionPane.showMessageDialog(null, "Falha ao salvar os dados! Consulte o administrador do sistema.");

            } else {
                // Clicou no botão Não na mensagem de confirmação
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        } catch (ErroValidacaoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAluno;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemoverAluno;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Aluno> cbxAlunos;
    private javax.swing.JComboBox<Professor> cbxProfessores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tabAlunos;
    private javax.swing.JTextField txtSemestre;
    // End of variables declaration//GEN-END:variables
}