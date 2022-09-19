package presentation;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaActividadDeportiva;
import interfaces.IControladorImagenes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import exceptions.ActividadRepetidaException;
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

public class AltaActividad extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorAltaActividadDeportiva iconAA;
	private IControladorImagenes iconIM;
	
	private JTextField textFieldNombre;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JComboBox<String> comboBoxInstitucion;
	private JTextField textFieldDescripcion;
	private JButton btnBuscarImagen;
	private JLabel lblImagen;
	
	/**
	 * Create the frame.
	 */
	public AltaActividad(IControladorAltaActividadDeportiva iconAA, IControladorImagenes iconIM) {
		
		this.iconAA = iconAA;
		this.iconIM = iconIM;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Actividad");
		setBounds(100, 100, 487, 403);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Institucion: ");
		lblInstitucion.setBounds(12, 12, 84, 15);
		getContentPane().add(lblInstitucion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaActividadAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(97, 337, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaActividadCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(227, 337, 117, 25);
		getContentPane().add(btnCancelar);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(12, 39, 139, 24);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(12, 70, 64, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(12, 92, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(12, 118, 70, 15);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo: ");
		lblCosto.setBounds(12, 166, 50, 15);
		getContentPane().add(lblCosto);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(12, 140, 114, 19);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(12, 188, 114, 19);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(12, 220, 93, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(12, 246, 162, 43);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblEtiquetaFoto = new JLabel("Imagen");
		lblEtiquetaFoto.setBounds(296, 12, 48, 14);
		getContentPane().add(lblEtiquetaFoto);
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setFont(new Font("Arial", lblImagen.getFont().getStyle(), lblImagen.getFont().getSize()));
		lblImagen.setBounds(209, 39, 222, 227);
		lblImagen.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(lblImagen);
		
		btnBuscarImagen = new JButton("Buscar Imagen");
		btnBuscarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AbrirImagen(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscarImagen.setBounds(262, 276, 117, 23);
		getContentPane().add(btnBuscarImagen);

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
	
	public void altaActividadAceptarActionPerformed(ActionEvent e) {
		if (checkFormulario()) {
			String nombre = this.textFieldNombre.getText();
			String descripcion = this.textFieldDescripcion.getText();
			String costoString = this.textFieldCosto.getText();
			float costo = Float.parseFloat(costoString);
			String duracionString = this.textFieldDuracion.getText();
			int duracion = Integer.parseInt(duracionString);
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			Calendar fechaReg = Calendar.getInstance();
			byte[] fotoByte = null;
			byte[] fotoAct = this.resultImagen(fotoByte);
		
			try {
				this.iconAA.altaActividadDeportiva(institucion, nombre, descripcion, duracion, costo, fechaReg, fotoAct);
				JOptionPane.showMessageDialog(this, "La actividad deportiva ha sido dado de alta con éxito", "Alta Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
			}catch (ActividadRepetidaException p) {
				JOptionPane.showMessageDialog(this, p.getMessage(), "Alta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
				}

			limpiarFormulario();
			setVisible(false);
        
		}
	}

	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconAA.listarInstituciones());
		comboBoxInstitucion.setModel(modelinstituciones);
	}
	
	public void altaActividadCancelarActionPerformed(ActionEvent e){
		limpiarFormulario();
		setVisible(false);
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
	
	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldDuracion.setText("");
		textFieldCosto.setText("");
		textFieldDescripcion.setText("");
		lblImagen.setIcon(null);
	}
	
	private boolean checkFormulario() {
        String nombre = this.textFieldNombre.getText();
        String descripcion = this.textFieldDescripcion.getText();
        String duracion = this.textFieldDuracion.getText();
        String costo = this.textFieldCosto.getText();
        if (nombre.isEmpty() || descripcion.isEmpty() || duracion.isEmpty() || costo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(duracion);
			Float.parseFloat(costo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Duracion y costo deben ser un numero", "Alta Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
