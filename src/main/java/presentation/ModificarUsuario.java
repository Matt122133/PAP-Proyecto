package presentation;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

import interfaces.IControladorImagenes;
import interfaces.IControladorModificarUsuario;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class ModificarUsuario extends JInternalFrame {

	private IControladorModificarUsuario iconMU;
	private IControladorImagenes iconIM;
	
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
	private JLabel lblImagen;
	private JButton btnModifImagen;

	/**
	 * Create the frame.
	 */
	public ModificarUsuario(IControladorModificarUsuario iconMU, IControladorImagenes iconIM) {
		this.iconMU = iconMU;
		this.iconIM = iconIM;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Modificar Usuario");
		setBounds(100, 100, 788, 340);
		getContentPane().setLayout(null);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(100, 140, 120, 24);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(12, 12, 70, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(34, 52, 56, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(245, 52, 56, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(34, 83, 56, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac");
		lblFechaNac.setBounds(245, 85, 62, 15);
		getContentPane().add(lblFechaNac);
		
		lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setBounds(33, 145, 78, 15);
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
		textFieldBiografia.setBounds(166, 171, 193, 42);
		getContentPane().add(textFieldBiografia);
		textFieldBiografia.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(318, 114, 193, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		lblBiografia = new JLabel("Biografia");
		lblBiografia.setBounds(110, 180, 62, 24);
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
		lblContrasenia.setBounds(20, 113, 70, 14);
		getContentPane().add(lblContrasenia);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(100, 111, 120, 19);
		getContentPane().add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		JLabel lblEtiquetaFoto = new JLabel("Imagen");
		lblEtiquetaFoto.setBounds(608, 8, 48, 14);
		getContentPane().add(lblEtiquetaFoto);
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setFont(new Font("Arial", lblImagen.getFont().getStyle(), lblImagen.getFont().getSize()));
		lblImagen.setBounds(521, 24, 222, 227);
		lblImagen.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(lblImagen);
		
		btnModifImagen = new JButton("Modificar Imagen");
		btnModifImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AbrirImagen(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnModifImagen.setBounds(553, 276, 158, 23);
		getContentPane().add(btnModifImagen);

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
	
	public void confirmarNicknameActionButtonPerformed(ActionEvent e) {
		String user = this.comboBoxUsuarios.getSelectedItem().toString();
		DtUsuario userDt = iconMU.obtenerUserDt(user);
		this.textFieldNombre.setText(userDt.getNombre());
		this.textFieldApellido.setText(userDt.getApellido());
		this.textFieldEmail.setText(userDt.getEmail());
		this.textFieldContrasenia.setText(userDt.getPassword());
		
		if(userDt.getImagen() != null) {
			if(!userDt.getImagen().equals(null)) {
				this.lblImagen.setText("");
				this.lblImagen.setIcon(new ImageIcon(new ImageIcon(userDt.getImagen()).getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT )));
			}
		}else{
			lblImagen.setIcon(null);
		}
		
		
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
				byte[] fotoByte = null;
				byte[] fotoUsuarioModificado = this.resultImagen(fotoByte);
				if(fechaNac==null) {
					String user = this.comboBoxUsuarios.getSelectedItem().toString();
					DtUsuario userDt = iconMU.obtenerUserDt(user);
					fechaNac = userDt.getFechaNac();
				}
			
			actualizado = new DtSocio(nick, nombre, apellido, email, fechaNac, contrasenia, fotoUsuarioModificado);
			this.iconMU.modificarUsuario(actualizado);
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
				byte[] fotoByte = null;
				byte[] fotoUsuarioModificado = this.resultImagen(fotoByte);
				
				if(fechaNac==null) {
					String user = this.comboBoxUsuarios.getSelectedItem().toString();
					DtUsuario userDt = iconMU.obtenerUserDt(user);
					fechaNac = userDt.getFechaNac();
				}
				String descripcion = this.textFieldDescripcion.getText();
				String biografia =  this.textFieldBiografia.getText();
				String sitioWeb = this.textFieldSitioWeb.getText();
				String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
				actualizado = new DtProfesor(nick, nombre, apellido, email, fechaNac, contrasenia, fotoUsuarioModificado, descripcion, biografia, sitioWeb, institucion);
				
				this.iconMU.modificarUsuario(actualizado);
				JOptionPane.showMessageDialog(this, "El usuario ha sido modificado con éxito", "Modificar Usuario", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
		}
		
		
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
        
        this.comboBoxInstitucion.setVisible(false);
		this.textFieldBiografia.setVisible(false);
		this.textFieldDescripcion.setVisible(false);
		this.lblInstitucion.setVisible(false);
		this.lblBiografia.setVisible(false);
		this.lblDescripcion.setVisible(false);
		this.lblSitioWeb.setVisible(false);
		this.textFieldSitioWeb.setVisible(false);
		
		lblImagen.setIcon(null);
 }
}
