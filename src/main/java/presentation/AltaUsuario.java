package presentation;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IControladorAltaUsuario;


import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import exceptions.UsuarioRepetidoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AltaUsuario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IControladorAltaUsuario iconAU;
	
	private JTextField textFieldNick;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldSitioWeb;
	private JRadioButton rdbtnSocio;
	private JRadioButton rdbtnProfesor;
	private JDateChooser dateChooser;
	private JTextField textFieldDescripcion;
	private JTextField textFieldBiografia;
	private JComboBox<String> comboBoxInstitucion;
	
	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario frame = new AltaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AltaUsuario(IControladorAltaUsuario iconAU) {
		
		this.iconAU = iconAU;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Usuario");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(96, 158, 114, 19);
		getContentPane().add(dateChooser);
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnProfesor.setSelected(false);
				rdbtnSocio.setSelected(true);
				comboBoxInstitucion.setEnabled(false);
				textFieldSitioWeb.setEnabled(false);
			    textFieldBiografia.setEnabled(false);
			    textFieldDescripcion.setEnabled(false);
				textFieldSitioWeb.setText("");
			    textFieldBiografia.setText("");
			    textFieldDescripcion.setText("");
			}
		});
		rdbtnSocio.setBounds(147, 0, 63, 23);
		getContentPane().add(rdbtnSocio);
		
		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnProfesor.setSelected(true);
				rdbtnSocio.setSelected(false);
				comboBoxInstitucion.setEnabled(true);
				textFieldSitioWeb.setEnabled(true);
			    textFieldBiografia.setEnabled(true);
			    textFieldDescripcion.setEnabled(true);
			}
		});
		rdbtnProfesor.setSelected(true);
		rdbtnProfesor.setBounds(52, 0, 91, 23);
		getContentPane().add(rdbtnProfesor);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setBounds(12, 54, 83, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 81, 70, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(12, 108, 70, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 135, 70, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.:");
		lblFechaNac.setBounds(12, 162, 83, 15);
		getContentPane().add(lblFechaNac);
		
		JLabel lblDatosBasicos = new JLabel("Datos Basicos:");
		lblDatosBasicos.setBounds(12, 27, 112, 15);
		getContentPane().add(lblDatosBasicos);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(12, 4, 42, 15);
		getContentPane().add(lblTipo);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(96, 52, 114, 19);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(96, 79, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(96, 106, 114, 19);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(96, 133, 114, 19);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblInstitucion = new JLabel("Institucion:");
		lblInstitucion.setBounds(12, 189, 83, 15);
		getContentPane().add(lblInstitucion);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(96, 184, 114, 24);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblOpcionales = new JLabel("Opcionales:");
		lblOpcionales.setBounds(222, 86, 104, 15);
		getContentPane().add(lblOpcionales);
		
		JLabel lblBiografia = new JLabel("Biografia:");
		lblBiografia.setBounds(222, 140, 70, 15);
		getContentPane().add(lblBiografia);
		
		JLabel lblSitioWeb = new JLabel("Sitio Web:");
		lblSitioWeb.setBounds(222, 113, 83, 15);
		getContentPane().add(lblSitioWeb);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(297, 111, 131, 19);
		getContentPane().add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(222, 27, 104, 15);
		getContentPane().add(lblDescripcion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(68, 231, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(253, 231, 117, 25);
		getContentPane().add(btnCancelar);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(222, 52, 206, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setBounds(222, 158, 206, 19);
		getContentPane().add(textFieldBiografia);
		textFieldBiografia.setColumns(10);
	}

	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconAU.listarInstituciones());
		comboBoxInstitucion.setModel(modelinstituciones);
	}
	
	protected void altaUsuarioCancelarActionPerformed(ActionEvent e) {
		limpiarFormulario();
        setVisible(false);
	}
	
	protected void altaUsuarioAceptarActionPerformed(ActionEvent e) {
		if(checkFormulario()) {
		String nombre = this.textFieldNombre.getText();
		String nickname = this.textFieldNick.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		Calendar fecha = this.dateChooser.getCalendar();
		DtUsuario nuevoUsuario = null;
		if(rdbtnSocio.isSelected()) {
			nuevoUsuario = new DtSocio(nickname, nombre, apellido, email, fecha);
		}
		else if(rdbtnProfesor.isSelected()) {
			if(checkFormularioProfesor()) {
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			String sitioWeb = this.textFieldSitioWeb.getText();
			String biografia = this.textFieldBiografia.getText();
			String descripcion = this.textFieldDescripcion.getText();
			nuevoUsuario = new DtProfesor(nickname, nombre, apellido, email, fecha, descripcion, biografia, sitioWeb, institucion);
			}
		}
		try {
			this.iconAU.altaUsuario(nuevoUsuario);
			JOptionPane.showMessageDialog(this, "El usuario ha sido dado de alta con éxito", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
        } catch (UsuarioRepetidoException p) {
            JOptionPane.showMessageDialog(this, p.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
        }

        	limpiarFormulario();
        	setVisible(false);
		}
	}
	
	private boolean checkFormulario() {
		String nombre = this.textFieldNombre.getText();
		String nickname = this.textFieldNick.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		Calendar fecha = this.dateChooser.getCalendar();
        if (nombre.isEmpty() || nickname.isEmpty() || apellido.isEmpty() || email.isEmpty() || fecha == null) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	private boolean checkFormularioProfesor() {
		String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
		String descripcion = this.textFieldDescripcion.getText();
		if (institucion.isEmpty() || descripcion.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Usuario",
					JOptionPane.ERROR_MESSAGE);
	        return false;
		}
		return true;
	}
	
	private void limpiarFormulario() {
        textFieldNombre.setText("");
        textFieldNick.setText("");
        textFieldApellido.setText("");
        textFieldEmail.setText("");
        textFieldSitioWeb.setText("");
        textFieldBiografia.setText("");
        textFieldDescripcion.setText("");
 }
}
