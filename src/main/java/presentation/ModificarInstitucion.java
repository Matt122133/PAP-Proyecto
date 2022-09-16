package presentation;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import datatypes.DtInstitucion;
import interfaces.IControladorModificarInstitucion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarInstitucion extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IControladorModificarInstitucion iconMI;
	
	private JTextField textFieldURL;
	private JTextField textFieldDescripcion;
	private JComboBox<String> comboBoxInstitucion;
	
	public ModificarInstitucion(IControladorModificarInstitucion iconMI) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		this.iconMI = iconMI;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Modificar Institucion");
        
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(96, 12, 126, 24);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setBounds(12, 17, 82, 15);
		getContentPane().add(lblInstitucion);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarInstitucionSeleccionarButtonActionPerformed(e);
			}
		});
		btnSeleccionar.setBounds(243, 12, 117, 25);
		getContentPane().add(btnSeleccionar);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(12, 59, 70, 15);
		getContentPane().add(lblUrl);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(96, 57, 114, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(12, 100, 82, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(96, 98, 114, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarInstitucionAceptarButtonActionPerformed(e);
			}
		});
		btnAceptar.setBounds(93, 218, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarInstitucionCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(243, 218, 117, 25);
		getContentPane().add(btnCancelar);

	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconMI.listarInstituciones());
		comboBoxInstitucion.setModel(modelinstituciones);
	}
	
	public void modificarInstitucionAceptarButtonActionPerformed(ActionEvent e){
		if(checkFormulario()) {
			String nombre = this.comboBoxInstitucion.getSelectedItem().toString();
			String url = this.textFieldURL.getText();
			String descripcion = this.textFieldDescripcion.getText();
			DtInstitucion actualizada = new DtInstitucion(nombre,url,descripcion);
			this.iconMI.modificarInstDep(actualizada);
			JOptionPane.showMessageDialog(this, "La institucion ha sido modificada con éxito", "Modificar Institucion", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
			limpiarFormulario();
		}
		
	}
	
	private void modificarInstitucionSeleccionarButtonActionPerformed(ActionEvent e) {
		String nombre = this.comboBoxInstitucion.getSelectedItem().toString();
		DtInstitucion dtInst = this.iconMI.obtenerDtInst(nombre);
		textFieldURL.setText(dtInst.getUrl());
		textFieldDescripcion.setText(dtInst.getDescripcion());
	}

	public void modificarInstitucionCancelarActionPerformed(ActionEvent e){
		limpiarFormulario();
		setVisible(false);
	}
	
	private void limpiarFormulario() {
        textFieldURL.setText("");
        textFieldDescripcion.setText("");
	}
	
	private boolean checkFormulario() {
        String descripcion = this.textFieldDescripcion.getText();
        String url = this.textFieldURL.getText();
        if (descripcion.isEmpty() || url.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Actividad", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
