package view;

import dao.AlumnoDAO;
import entity.Alumno;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email  gcoronelc@gmail.com
 */
public class PrincipalView extends javax.swing.JFrame {

	// Dialogo para Editar un alumno
	private EditFormView editForm = new EditFormView(this, true);
	// Modelo de Tabla
	private DefaultTableModel tableModel = null;

	/** Creates new form Principal */
	public PrincipalView() {
		initComponents();
		InitTable();
		this.setLocationRelativeTo(null);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    txtDato = new javax.swing.JTextField();
    btnConsultar = new javax.swing.JButton();
    btnCerrar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblData = new javax.swing.JTable();
    btnNuevo = new javax.swing.JButton();
    btnEditar = new javax.swing.JButton();
    btnEliminar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("MANTENIMIENTO DE ALUMNOS");

    jLabel1.setText("Apellido o nombre del alumno");

    btnConsultar.setText("Consultar");
    btnConsultar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnConsultarActionPerformed(evt);
      }
    });

    btnCerrar.setText("Cerrar");
    btnCerrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCerrarActionPerformed(evt);
      }
    });

    tblData.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, true
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    tblData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tblData.setShowVerticalLines(false);
    tblData.getTableHeader().setResizingAllowed(false);
    jScrollPane1.setViewportView(tblData);

    btnNuevo.setText("Nuevo");
    btnNuevo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnNuevoActionPerformed(evt);
      }
    });

    btnEditar.setText("Editar");
    btnEditar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEditarActionPerformed(evt);
      }
    });

    btnEliminar.setText("Eliminar");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(txtDato, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
            .addGap(14, 14, 14)
            .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(130, 130, 130))
          .addGroup(layout.createSequentialGroup()
            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

	 private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
		 System.exit(0);
	 }//GEN-LAST:event_btnCerrarActionPerformed

	 private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
		try {
			this.editForm.setId(null);
			this.editForm.setVisible(true);
		} catch (Exception ex) {
			util.Util.showError(this, ex.getMessage());
		}
	 }//GEN-LAST:event_btnNuevoActionPerformed

	 private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
		try {
			// Obtenemos acceso a la tabla
			DefaultTableModel dtm = (DefaultTableModel) this.tblData.getModel();
			// Limpiamos la tabla
			dtm.setRowCount(0);
			// LLenar la tabla
			List<Alumno> lista = new AlumnoDAO().readForName(txtDato.getText());
			for (Alumno a : lista) {
				dtm.addRow(a.toRowData());
			}
		} catch (Exception ex) {
			util.Util.showError(this, ex.getMessage());
		}
	 }//GEN-LAST:event_btnConsultarActionPerformed

  private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
   	try {
      int fila = tblData.getSelectedRow();
      if(fila == -1){
        throw new Exception("Debe seleccionar una fila.");
      }
      int id = (Integer) tblData.getValueAt(fila, 0);
			this.editForm.setId(id);
			this.editForm.setVisible(true);
		} catch (Exception ex) {
			util.Util.showError(this, ex.getMessage());
		}
  }//GEN-LAST:event_btnEditarActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PrincipalView().setVisible(true);
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCerrar;
  private javax.swing.JButton btnConsultar;
  private javax.swing.JButton btnEditar;
  private javax.swing.JButton btnEliminar;
  private javax.swing.JButton btnNuevo;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblData;
  private javax.swing.JTextField txtDato;
  // End of variables declaration//GEN-END:variables

	private void InitTable() {
		tableModel = new DefaultTableModel(new String[]{"ID", "APELLIDO", "NOMBRE", "NOTA"}, 0);
		tblData.setModel(tableModel);
		tblData.getColumnModel().getColumn(0).setMinWidth(50);
		tblData.getColumnModel().getColumn(0).setMaxWidth(50);
		tblData.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblData.getColumnModel().getColumn(1).setPreferredWidth(320);
		tblData.getColumnModel().getColumn(2).setPreferredWidth(320);
		tblData.getColumnModel().getColumn(3).setMinWidth(100);
		tblData.getColumnModel().getColumn(3).setMaxWidth(100);
		tblData.getColumnModel().getColumn(3).setPreferredWidth(100);
	}
}
