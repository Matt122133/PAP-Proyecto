package presentation;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;

import interfaces.IControladorModificarUsuario;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class ModificarUsuario extends JInternalFrame {
	private JComboBox<String> comboBoxInstitucion;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldBiografia;
	private JTextField textFieldDescripcion;
	private IControladorModificarUsuario iconMU;
	private JComboBox<String> comboBoxUsuarios;
	private JDateChooser dateChooser;
	private JLabel lblInstitucion;
	private JLabel lblBiografia;
	private JLabel lblDescripcion;
	private JLabel lblSitioWeb;
	private JTextField textFieldSitioWeb;

	/**
	 * Create the frame.
	 */
	public ModificarUsuario(IControladorModificarUsuario iconMU) {
		this.iconMU = iconMU;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Modificar Usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(103, 152, 120, 24);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(12, 12, 70, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 44, 70, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(12, 71, 70, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 99, 70, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac");
		lblFechaNac.setBounds(12, 126, 78, 15);
		getContentPane().add(lblFechaNac);
		
		lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setBounds(12, 153, 78, 15);
		getContentPane().add(lblInstitucion);
		
		JButton btnConfirmarNickname = new JButton("Confirmar Nickname");
		btnConfirmarNickname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarNicknameActionButtonPerformed(e);
			}
		});
		btnConfirmarNickname.setBounds(235, 7, 193, 25);
		getContentPane().add(btnConfirmarNickname);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(103, 44, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(103, 71, 114, 19);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(103, 99, 114, 19);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(103, 126, 120, 19);
		getContentPane().add(dateChooser);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setBounds(235, 69, 193, 19);
		getContentPane().add(textFieldBiografia);
		textFieldBiografia.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(235, 124, 193, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		lblBiografia = new JLabel("Biografia");
		lblBiografia.setBounds(235, 35, 70, 32);
		getContentPane().add(lblBiografia);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(235, 99, 89, 15);
		getContentPane().add(lblDescripcion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarButtonActionPerformed(e);
			}
		});
		btnAceptar.setBounds(87, 215, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarUsuarioCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(245, 215, 117, 25);
		getContentPane().add(btnCancelar);
		
		comboBoxUsuarios = new JComboBox<String>();
		comboBoxUsuarios.setBounds(102, 7, 115, 24);
		getContentPane().add(comboBoxUsuarios);
		
		lblSitioWeb = new JLabel("Sitio Web");
		lblSitioWeb.setBounds(235, 157, 70, 15);
		getContentPane().add(lblSitioWeb);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(235, 184, 193, 19);
		getContentPane().add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		
		this.comboBoxInstitucion.setVisible(false);
		this.textFieldBiografia.setVisible(false);
		this.textFieldDescripcion.setVisible(false);
		this.lblInstitucion.setVisible(false);
		this.lblBiografia.setVisible(false);
		this.lblDescripcion.setVisible(false);
		this.lblSitioWeb.setVisible(false);
		this.textFieldSitioWeb.setVisible(false);
		this.textFieldEmail.setEnabled(false);

	}
	
	public void confirmarNicknameActionButtonPerformed(ActionEvent e) {
		String user = this.comboBoxUsuarios.getSelectedItem().toString();
		DtUsuario userDt = iconMU.obtenerUserDt(user);
		this.textFieldNombre.setText(userDt.getNombre());
		this.textFieldApellido.setText(userDt.getApellido());
		this.textFieldEmail.setText(userDt.getEmail());
		if (userDt instanceof DtSocio) {
			this.comboBoxInstitucion.setVisible(false);
			this.textFieldBiografia.setVisible(false);
			this.textFieldDescripcion.setVisible(false);
			this.lblInstitucion.setVisible(false);
			this.lblBiografia.setVisible(false);
			this.lblDescripcion.setVisible(false);
			this.lblSitioWeb.setVisible(false);
			this.textFieldSitioWeb.setVisible(false);
		}
		else if (userDt instanceof DtProfesor) {
			this.comboBoxInstitucion.setVisible(true);
			this.textFieldBiografia.setVisible(true);
			this.textFieldDescripcion.setVisible(true);
			this.lblInstitucion.setVisible(true);
			this.lblBiografia.setVisible(true);
			this.lblDescripcion.setVisible(true);
			this.lblSitioWeb.setVisible(true);
			this.textFieldSitioWeb.setVisible(true);
			this.comboBoxInstitucion.setSelectedItem(((DtProfesor) userDt).getInstDep());
			this.textFieldBiografia.setText(((DtProfesor) userDt).getBiografia());
			this.textFieldDescripcion.setText(((DtProfesor) userDt).getDescripcion());
			this.textFieldSitioWeb.setText(((DtProfesor) userDt).getSitioWeb());
		}
	}
	
	public void aceptarButtonActionPerformed(ActionEvent e){
		String nick = this.comboBoxUsuarios.getSelectedItem().toString();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		Calendar fechaNac = this.dateChooser.getCalendar();
		if(fechaNac==null) {
			String user = this.comboBoxUsuarios.getSelectedItem().toString();
			DtUsuario userDt = iconMU.obtenerUserDt(user);
			fechaNac = userDt.getFechaNac();
		}
		DtUsuario actualizado;
		if(this.lblDescripcion.isVisible() == true) {
			String descripcion = this.textFieldDescripcion.getText();
			String biografia =  this.textFieldBiografia.getText();
			String sitioWeb = this.textFieldSitioWeb.getText();
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			actualizado = new DtProfesor(nick, nombre, apellido, email, fechaNac, descripcion, biografia, sitioWeb, institucion);
		}
		else {
			actualizado = new DtSocio(nick, nombre, apellido, email, fechaNac);
		}
		this.iconMU.ModificarUsuario(actualizado);
		JOptionPane.showMessageDialog(this, "El usuario ha sido modificado con éxito", "Modificar Usuario", JOptionPane.INFORMATION_MESSAGE);
		limpiarFormulario();
		setVisible(false);
	}
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconMU.listarInstituciones());
		comboBoxInstitucion.setModel(modelinstituciones);
		DefaultComboBoxModel<String> modelusuarios = new DefaultComboBoxModel<String>(iconMU.listarUsuarios());
		comboBoxUsuarios.setModel(modelusuarios);	
    }
	
	protected void modificarUsuarioCancelarActionPerformed(ActionEvent e) {
		limpiarFormulario();
        setVisible(false);
	}
	
	private void limpiarFormulario() {
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldEmail.setText("");
        textFieldSitioWeb.setText("");
        textFieldBiografia.setText("");
        textFieldDescripcion.setText("");
        this.comboBoxInstitucion.setVisible(false);
		this.textFieldBiografia.setVisible(false);
		this.textFieldDescripcion.setVisible(false);
		this.lblInstitucion.setVisible(false);
		this.lblBiografia.setVisible(false);
		this.lblDescripcion.setVisible(false);
		this.lblSitioWeb.setVisible(false);
		this.textFieldSitioWeb.setVisible(false);
 }
}
