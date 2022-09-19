package presentation;


import javax.swing.JInternalFrame;

import interfaces.IControladorAltaUsuario;
import interfaces.IControladorImagenes;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import exceptions.UsuarioRepetidoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;


import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class AltaUsuario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IControladorAltaUsuario iconAU;
	private IControladorImagenes iconIM;
	
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
	private JLabel lblInstitucion;
	private JLabel lblBiografia;
	private JLabel lblSitioWeb;
	private JLabel lblOpcionales;
	private JLabel lblDescripcion;
	private JTextField textFieldContrasenia;
	private JTextField textFieldConfirmContrasenia;
	private JLabel lblImagen;
	private JButton btnInsertImagen;
	
	public AltaUsuario(IControladorAltaUsuario iconAU, IControladorImagenes iconIM) {
		
		this.iconAU = iconAU;
		this.iconIM = iconIM;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Usuario");
		
		setBounds(100, 100, 718, 431);
		getContentPane().setLayout(null);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(96, 158, 114, 19);
		getContentPane().add(dateChooser);
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnProfesor.setSelected(false);
				rdbtnSocio.setSelected(true);
				comboBoxInstitucion.setVisible(false);
				textFieldSitioWeb.setVisible(false);
			    textFieldBiografia.setVisible(false);
			    textFieldDescripcion.setVisible(false);
				textFieldSitioWeb.setText("");
			    textFieldBiografia.setText("");
			    textFieldDescripcion.setText("");
			    lblInstitucion.setVisible(false);
			    lblBiografia.setVisible(false);
			    lblOpcionales.setVisible(false);
			    lblSitioWeb.setVisible(false);
			    lblDescripcion.setVisible(false);
			    
			}
		});
		rdbtnSocio.setBounds(147, 0, 63, 23);
		getContentPane().add(rdbtnSocio);
		
		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnProfesor.setSelected(true);
				rdbtnSocio.setSelected(false);
				comboBoxInstitucion.setVisible(true);
				textFieldSitioWeb.setVisible(true);
			    textFieldBiografia.setVisible(true);
			    textFieldDescripcion.setVisible(true);
			    lblInstitucion.setVisible(true);
			    lblBiografia.setVisible(true);
			    lblOpcionales.setVisible(true);
			    lblSitioWeb.setVisible(true);
			    lblDescripcion.setVisible(true);
			}
		});
		rdbtnProfesor.setSelected(true);
		rdbtnProfesor.setBounds(52, 0, 91, 23);
		getContentPane().add(rdbtnProfesor);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setBounds(16, 53, 63, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(16, 80, 53, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(16, 107, 53, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(16, 134, 42, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.:");
		lblFechaNac.setBounds(16, 161, 70, 15);
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
		
		lblInstitucion = new JLabel("Institucion:");
		lblInstitucion.setBounds(220, 190, 63, 15);
		getContentPane().add(lblInstitucion);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(293, 185, 114, 24);
		getContentPane().add(comboBoxInstitucion);
		
		lblOpcionales = new JLabel("Opcionales:");
		lblOpcionales.setBounds(220, 80, 70, 15);
		getContentPane().add(lblOpcionales);
		
		lblBiografia = new JLabel("Biografia:");
		lblBiografia.setBounds(220, 134, 70, 15);
		getContentPane().add(lblBiografia);
		
		lblSitioWeb = new JLabel("Sitio Web:");
		lblSitioWeb.setBounds(220, 107, 63, 15);
		getContentPane().add(lblSitioWeb);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(280, 104, 136, 19);
		getContentPane().add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(220, 27, 79, 15);
		getContentPane().add(lblDescripcion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(115, 283, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(251, 283, 117, 25);
		getContentPane().add(btnCancelar);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(220, 50, 206, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setBounds(220, 158, 206, 19);
		getContentPane().add(textFieldBiografia);
		textFieldBiografia.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setBounds(16, 190, 79, 14);
		getContentPane().add(lblContrasenia);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(96, 188, 114, 19);
		getContentPane().add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		JLabel lblConfirmContra = new JLabel("Confirmar contraseña:");
		lblConfirmContra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmContra.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmContra.setVerticalAlignment(SwingConstants.TOP);
		lblConfirmContra.setBounds(16, 221, 151, 19);
		getContentPane().add(lblConfirmContra);
		
		textFieldConfirmContrasenia = new JTextField();
		textFieldConfirmContrasenia.setBounds(36, 240, 114, 19);
		getContentPane().add(textFieldConfirmContrasenia);
		textFieldConfirmContrasenia.setColumns(10);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setBackground(SystemColor.activeCaption);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setFont(new Font("Arial", lblImagen.getFont().getStyle(), lblImagen.getFont().getSize()));
		lblImagen.setBounds(457, 27, 222, 227);
		lblImagen.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(lblImagen);
		
		btnInsertImagen = new JButton("Insertar Imagen");
		btnInsertImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AbrirImagen(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnInsertImagen.setBounds(500, 284, 136, 23);
		getContentPane().add(btnInsertImagen);
		
		
	}
	
	private void AbrirImagen(ActionEvent e) throws IOException {
	        JFileChooser j = new JFileChooser();
	        j.setDialogTitle("Buscar Imagen");
	        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
	        int estado = j.showOpenDialog(null);
	        if(estado == 0){
	            try{
	            	String rutArchivo = j.getSelectedFile().getAbsolutePath();
	            	File f = new File(rutArchivo);
	            	BufferedImage src = ImageIO.read(f);
	            	BufferedImage dest = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_RGB);
	            	Graphics2D g = dest.createGraphics();
	            	AffineTransform at = AffineTransform.getScaleInstance(src.getWidth()/src.getWidth(), src.getHeight()/src.getHeight());
	            	g.drawRenderedImage(src, at);
	            	ImageIcon icon = new ImageIcon(rutArchivo);
	            	icon = new ImageIcon(dest);
	            	lblImagen.setText("");
	            	lblImagen.setIcon(new ImageIcon( new ImageIcon(dest).getImage().getScaledInstance(lblImagen.getWidth(),
	            					 lblImagen.getHeight(), Image.SCALE_DEFAULT)));
	            	icon.getIconHeight();
	            	
	                } catch (IOException ex) {
	                    JOptionPane.showMessageDialog(rootPane, " Error de imagen: " + ex.getMessage());
	                }
	           
	        }        
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
		
		if(checkFormulario() && checkCamposContrasenia()) {
		DtUsuario nuevoUsuario = null;
		String nombre = this.textFieldNombre.getText();
		String nickname = this.textFieldNick.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		Calendar fecha = this.dateChooser.getCalendar();
		String contrasenia = this.textFieldContrasenia.getText();
		byte[] fotoByte = null;
		byte[] fotoUsuario = this.resultImagen(fotoByte);
		
		if(rdbtnSocio.isSelected()) {
			nuevoUsuario = new DtSocio(nickname, nombre, apellido, email, fecha, contrasenia, fotoUsuario);
		}
		else if(rdbtnProfesor.isSelected()) {
			if(checkFormularioProfesor()) {
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			String sitioWeb = this.textFieldSitioWeb.getText();
			String biografia = this.textFieldBiografia.getText();
			String descripcion = this.textFieldDescripcion.getText();
			nuevoUsuario = new DtProfesor(nickname, nombre, apellido, email, fecha, contrasenia, fotoByte, descripcion, biografia, sitioWeb, institucion);
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
		String contrasenia = this.textFieldContrasenia.getText();
		String confirmContrasenia = this.textFieldConfirmContrasenia.getText();
	
        if (nombre.isEmpty() || nickname.isEmpty() || apellido.isEmpty() || email.isEmpty() || fecha == null || contrasenia.isEmpty() || confirmContrasenia.isEmpty() ) {
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
	
	private boolean checkCamposContrasenia(){
		String contrasenia = this.textFieldContrasenia.getText();
		String confirmContrasenia = this.textFieldConfirmContrasenia.getText();
		
		if(contrasenia.equals(confirmContrasenia)){
			JOptionPane.showMessageDialog(this, "Contraseñas confirmadas", "Alta Usuario",
					JOptionPane.INFORMATION_MESSAGE);
	        return true;
		}else {
			JOptionPane.showMessageDialog(this, "Contraseñas incorrectas", "Alta Usuario",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
	
	private byte[] resultImagen(byte[] fotoByte) {
		if(lblImagen.getIcon() == null) {
			fotoByte = null;
		}else if(lblImagen.getIcon() != null) {
			Image image = iconIM.iconToImage(lblImagen.getIcon());
			fotoByte = iconIM.imageToByte(image);
			
		}
		return fotoByte;
	}
	
	private void limpiarFormulario() {
        textFieldNombre.setText("");
        textFieldNick.setText("");
        textFieldApellido.setText("");
        textFieldEmail.setText("");
        textFieldSitioWeb.setText("");
        textFieldBiografia.setText("");
        textFieldDescripcion.setText("");
        textFieldContrasenia.setText("");
        textFieldConfirmContrasenia.setText("");
 }
}
