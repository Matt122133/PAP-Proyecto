package presentation;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaDictadoDeClase;
import interfaces.IControladorImagenes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

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
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;

import exceptions.ClaseRepetidaException;

public class AltaClase extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorAltaDictadoDeClase iconAC;
	private IControladorImagenes iconIM;
	
	private JTextField textFieldNombre;
	private JTextField textFieldURL;
	private JTextField textFieldHoraInicio;
	private JComboBox<String> comboBoxInstitucion;
	private JComboBox<String> comboBoxActividad;
	private JComboBox<String> comboBoxProfesor;
	private JDateChooser dateChooser;
	private JButton btnBuscarImagen;
	private JLabel lblImagen;
	
	/**
	 * Create the frame.
	 */
	public AltaClase(IControladorAltaDictadoDeClase iconAC, IControladorImagenes iconIM) {
		
		this.iconAC = iconAC;
		this.iconIM = iconIM;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Clase");
		setBounds(100, 100, 738, 344);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Institucion:");
		lblInstitucion.setBounds(10, 30, 80, 15);
		getContentPane().add(lblInstitucion);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(100, 25, 104, 24);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblActividad = new JLabel("Actividad:");
		lblActividad.setBounds(10, 65, 70, 15);
		getContentPane().add(lblActividad);
		
		comboBoxActividad = new JComboBox<String>();
		comboBoxActividad.setBounds(101, 60, 104, 24);
		getContentPane().add(comboBoxActividad);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 170, 60, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(101, 170, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha Inicio:");
		lblFechaDeInicio.setBounds(10, 201, 94, 15);
		getContentPane().add(lblFechaDeInicio);
		
		JLabel lblHoraDeInicio = new JLabel("Hora Inicio: ");
		lblHoraDeInicio.setBounds(224, 201, 84, 15);
		getContentPane().add(lblHoraDeInicio);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		lblProfesor.setBounds(10, 104, 70, 15);
		getContentPane().add(lblProfesor);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(273, 170, 32, 15);
		getContentPane().add(lblUrl);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(137, 279, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(322, 279, 117, 25);
		getContentPane().add(btnCancelar);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(308, 170, 114, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		comboBoxProfesor = new JComboBox<String>();
		comboBoxProfesor.setBounds(101, 96, 104, 24);
		getContentPane().add(comboBoxProfesor);
		
		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setBounds(308, 199, 114, 19);
		getContentPane().add(textFieldHoraInicio);
		textFieldHoraInicio.setColumns(10);
		
		JButton btnElegirInsti = new JButton("Elegir Insti");
		btnElegirInsti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarComboBoxActionPerformed(e);
			}
		});
		btnElegirInsti.setBounds(230, 25, 114, 25);
		getContentPane().add(btnElegirInsti);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(101, 199, 114, 19);
		getContentPane().add(dateChooser);
		
		comboBoxActividad.setEnabled(false);
		comboBoxProfesor.setEnabled(false);
		
		textFieldNombre.setEnabled(false);
		textFieldURL.setEnabled(false);
		textFieldHoraInicio.setEnabled(false);
		dateChooser.setEnabled(false);
		
		JLabel lblEtiquetaClase = new JLabel("Datos de la clase:");
		lblEtiquetaClase.setBounds(10, 142, 128, 14);
		getContentPane().add(lblEtiquetaClase);
		
		JLabel lblEtiquetaImagen = new JLabel("Imagen:");
		lblEtiquetaImagen.setBounds(548, 11, 70, 15);
		getContentPane().add(lblEtiquetaImagen);
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setFont(new Font("Arial", lblImagen.getFont().getStyle(), lblImagen.getFont().getSize()));
		lblImagen.setBounds(472, 30, 222, 227);
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
		btnBuscarImagen.setBounds(516, 280, 135, 23);
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
	
	public void altaClaseCancelarActionPerformed(ActionEvent e){
		limpiarFormulario();
		setVisible(false);
	}
	
	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldURL.setText("");
		textFieldHoraInicio.setText("");
		lblImagen.setIcon(null);
	}
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconAC.listarInstituciones());
		comboBoxInstitucion.setModel(modelinstituciones);
    }
	
	public void llenarComboBoxActionPerformed(ActionEvent arg0) {
		comboBoxActividad.setEnabled(true);
		comboBoxProfesor.setEnabled(true);
		
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconAC.obtenerActividadesDeportivas(nombreInsti));
		comboBoxActividad.setModel(modelactividades);
		
		DefaultComboBoxModel<String> modelprofesores = new DefaultComboBoxModel<String>(iconAC.obtenerProfesor(nombreInsti));
		comboBoxProfesor.setModel(modelprofesores);	
		
		
		textFieldNombre.setEnabled(true);
		textFieldURL.setEnabled(true);
		textFieldHoraInicio.setEnabled(true);
		dateChooser.setEnabled(true);
	}
	
	public void altaClaseAceptarActionPerformed(ActionEvent e) {
		if(checkFormulario()) {
			
			String nombre = this.textFieldNombre.getText();
			String url = this.textFieldURL.getText();
			String horaInicio = this.textFieldHoraInicio.getText();
			String nombreInst = this.comboBoxInstitucion.getSelectedItem().toString();
			String nombreAct = this.comboBoxActividad.getSelectedItem().toString();
			String nombreProf = this.comboBoxProfesor.getSelectedItem().toString();
			Calendar fecha = this.dateChooser.getCalendar();
			Calendar fechaReg = Calendar.getInstance();
			int horaIni = Integer.parseInt(horaInicio);
			byte[] fotoByte = null;
			byte[] fotoByte1 = this.resultImagen(fotoByte);
			
			try {
				this.iconAC.altaDictadoClase(nombreInst, nombreAct, nombreProf, nombre, fecha, horaIni, url, fechaReg, fotoByte1);
				JOptionPane.showMessageDialog(this, "La clase ha sido dado de alta con éxito", "Alta Clase", JOptionPane.INFORMATION_MESSAGE);
			}catch (ClaseRepetidaException p) {
				JOptionPane.showMessageDialog(this, p.getMessage(), "Alta Clase", JOptionPane.ERROR_MESSAGE);
			}
			
			limpiarFormulario();
			setVisible(false);
		}
		
		
	}
	
	private boolean checkFormulario() {
        String nombre = this.textFieldNombre.getText();
        String URL = this.textFieldURL.getText();
        String horaInicio = this.textFieldHoraInicio.getText();
        String fechaInicio = this.dateChooser.toString();
        if (nombre.isEmpty() || URL.isEmpty() || fechaInicio.isEmpty() || horaInicio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Clase",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(horaInicio);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La hora de inicio debe ser un numero", "Alta Clase",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
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
}
