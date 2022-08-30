package presentation;

import javax.swing.JInternalFrame;

import interfaces.IControladorAltaInstitucionDeportiva;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exceptions.InstitucionRepetidaException;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaInstitucion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorAltaInstitucionDeportiva iconAI;
	private JTextField textFieldNombre;
	private JTextField textFieldURL;
	private JTextField textFieldDescripcion;

	/**
	 * Create the frame.
	 */
	public AltaInstitucion(IControladorAltaInstitucionDeportiva iconAI) {
		
		this.iconAI = iconAI;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Institucion");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(175, 27, 64, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(188, 77, 40, 15);
		getContentPane().add(lblUrl);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(160, 133, 87, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(150, 46, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(150, 105, 114, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaInstitucionAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(68, 205, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaInstitucionCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(253, 205, 117, 25);
		getContentPane().add(btnCancelar);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(150, 160, 114, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);

	}
	
	protected void altaInstitucionAceptarActionPerformed(ActionEvent e) {
		if(checkFormulario()) {
		String nombre = this.textFieldNombre.getText();
		String URL = this.textFieldURL.getText();
		String descripcion = this.textFieldDescripcion.getText();
		try {
			this.iconAI.altaInstitucionDeportiva(nombre, descripcion, URL);
			JOptionPane.showMessageDialog(this, "La institucion ha sido dada de alta con éxito", "Alta Institucion", JOptionPane.INFORMATION_MESSAGE);
        } catch (InstitucionRepetidaException p) {
            JOptionPane.showMessageDialog(this, p.getMessage(), "Alta Institucion", JOptionPane.ERROR_MESSAGE);
        }
			limpiarFormulario();
			setVisible(false);
		}
	}
	
	protected void altaInstitucionCancelarActionPerformed(ActionEvent e) {
		limpiarFormulario();
        setVisible(false);
	}
	
	private boolean checkFormulario() {
		String nombre = this.textFieldNombre.getText();
		String URL = this.textFieldURL.getText();
		String descripcion = this.textFieldDescripcion.getText();
		if (nombre.isEmpty() || URL.isEmpty() || descripcion.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Usuario",
					JOptionPane.ERROR_MESSAGE);
	        return false;
		}
		return true;
	}
	
	private void limpiarFormulario() {
        textFieldNombre.setText("");
        textFieldURL.setText("");
        textFieldDescripcion.setText("");
    }
}
