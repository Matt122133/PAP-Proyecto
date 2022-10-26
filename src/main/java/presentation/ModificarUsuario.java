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
import javax.swing.SwingConstants;


public class ModificarUsuario extends JInternalFrame {

	private IControladorModificarUsuario iconMU;
	
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxInstitucion;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldBiografia;
	private JTextField textFieldDescripcion;
	private JComboBox<String> comboBoxUsuarios;
	private JDateChooser dateChooser;
	private JLabel lblInstitucion;
	private JLabel lblBiografia;
	private JLabel lblDescripcion;
	private JLabel lblSitioWeb;
	private JTextField textFieldSitioWeb;
	private JLabel lblContrasenia;
	private JTextField textFieldContrasenia;
	private JTextField textFieldImagenURL;

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
		setBounds(100, 100, 552, 340);
		getContentPane().setLayout(null);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(100, 173, 120, 24);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(12, 12, 70, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 52, 56, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(245, 52, 56, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(26, 83, 56, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac");
		lblFechaNac.setBounds(245, 85, 62, 15);
		getContentPane().add(lblFechaNac);
		
		lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setBounds(12, 178, 70, 15);
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
		textFieldNombre.setBounds(100, 50, 120, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(318, 49, 120, 20);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(100, 81, 120, 19);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(318, 83, 120, 19);
		getContentPane().add(dateChooser);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setBounds(318, 173, 193, 24);
		getContentPane().add(textFieldBiografia);
		textFieldBiografia.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(318, 114, 193, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		lblBiografia = new JLabel("Biografia");
		lblBiografia.setBounds(245, 173, 62, 24);
		getContentPane().add(lblBiografia);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(245, 116, 70, 15);
		getContentPane().add(lblDescripcion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarButtonActionPerformed(e);
			}
		});
		btnAceptar.setBounds(131, 274, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarUsuarioCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(269, 274, 117, 25);
		getContentPane().add(btnCancelar);
		
		comboBoxUsuarios = new JComboBox<String>();
		comboBoxUsuarios.setBounds(102, 7, 115, 24);
		getContentPane().add(comboBoxUsuarios);
		
		lblSitioWeb = new JLabel("Sitio Web");
		lblSitioWeb.setBounds(245, 145, 70, 15);
		getContentPane().add(lblSitioWeb);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(318, 143, 193, 19);
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
		
		lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasenia.setBounds(12, 113, 70, 14);
		getContentPane().add(lblContrasenia);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(100, 111, 120, 19);
		getContentPane().add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		JLabel lblEtiquetaFoto = new JLabel("Imagen URL");
		lblEtiquetaFoto.setBounds(12, 145, 70, 14);
		getContentPane().add(lblEtiquetaFoto);
		
		textFieldImagenURL = new JTextField();
		textFieldImagenURL.setBounds(100, 142, 120, 20);
		getContentPane().add(textFieldImagenURL);
		textFieldImagenURL.setColumns(10);

	}
	
	public void confirmarNicknameActionButtonPerformed(ActionEvent e) {
		String user = this.comboBoxUsuarios.getSelectedItem().toString();
		DtUsuario userDt = iconMU.obtenerUserDt(user);
		this.textFieldNombre.setText(userDt.getNombre());
		this.textFieldApellido.setText(userDt.getApellido());
		this.textFieldEmail.setText(userDt.getEmail());
		this.textFieldContrasenia.setText(userDt.getPassword());
		this.textFieldImagenURL.setText(userDt.getImagenURL());
		
		
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

		DtUsuario actualizado = null;
		if(this.lblDescripcion.isVisible() == false) {
			if(checkFormularioSocio()) {
				String nick = this.comboBoxUsuarios.getSelectedItem().toString();
				String nombre = this.textFieldNombre.getText();
				String apellido = this.textFieldApellido.getText();
				String email = this.textFieldEmail.getText();
				Calendar fechaNac = this.dateChooser.getCalendar();
				String contrasenia = this.textFieldContrasenia.getText();
				String imagenURL = this.textFieldImagenURL.getText();
				if(fechaNac==null) {
					String user = this.comboBoxUsuarios.getSelectedItem().toString();
					DtUsuario userDt = iconMU.obtenerUserDt(user);
					fechaNac = userDt.getFechaNac();
				}
			
			actualizado = new DtSocio(nick, nombre, apellido, email, fechaNac, contrasenia, imagenURL);
			this.iconMU.modificarSocio((DtSocio) actualizado);
			JOptionPane.showMessageDialog(this, "El usuario ha sido modificado con éxito", "Modificar Usuario", JOptionPane.INFORMATION_MESSAGE);
			limpiarFormulario();
			setVisible(false);
		
		}
		}else if(this.lblDescripcion.isVisible() == true) {
			if(checkFormularioProfesor()) {
				String nick = this.comboBoxUsuarios.getSelectedItem().toString();
				String nombre = this.textFieldNombre.getText();
				String apellido = this.textFieldApellido.getText();
				String email = this.textFieldEmail.getText();
				Calendar fechaNac = this.dateChooser.getCalendar();
				String contrasenia = this.textFieldContrasenia.getText();
				String imagenURL = this.textFieldImagenURL.getText();
				
				if(fechaNac==null) {
					String user = this.comboBoxUsuarios.getSelectedItem().toString();
					DtUsuario userDt = iconMU.obtenerUserDt(user);
					fechaNac = userDt.getFechaNac();
				}
				String descripcion = this.textFieldDescripcion.getText();
				String biografia =  this.textFieldBiografia.getText();
				String sitioWeb = this.textFieldSitioWeb.getText();
				String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
				actualizado = new DtProfesor(nick, nombre, apellido, email, fechaNac, contrasenia, imagenURL, descripcion, biografia, sitioWeb, institucion);
				
				this.iconMU.modificarProfesor((DtProfesor) actualizado);
				JOptionPane.showMessageDialog(this, "El usuario ha sido modificado con éxito", "Modificar Usuario", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
		}
		
		
	}
		
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
	
	private boolean checkFormularioProfesor() {
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String contrasenia = this.textFieldContrasenia.getText();
		String descripcion = this.textFieldDescripcion.getText();
		String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
        if (nombre.isEmpty() || apellido.isEmpty() || contrasenia.isEmpty() || descripcion.isEmpty() || institucion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	private boolean checkFormularioSocio() {
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String contrasenia = this.textFieldContrasenia.getText();
        if (nombre.isEmpty() || apellido.isEmpty() || contrasenia.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	private void limpiarFormulario() {
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldEmail.setText("");
        textFieldSitioWeb.setText("");
        textFieldBiografia.setText("");
        textFieldDescripcion.setText("");
        textFieldContrasenia.setText("");
        this.textFieldImagenURL.setText("");
        
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
