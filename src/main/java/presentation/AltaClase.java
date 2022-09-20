package presentation;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaDictadoDeClase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

import exceptions.ClaseRepetidaException;

public class AltaClase extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorAltaDictadoDeClase iconAC;
	
	private JTextField textFieldNombre;
	private JTextField textFieldURL;
	private JTextField textFieldHoraInicio;
	private JComboBox<String> comboBoxInstitucion;
	private JComboBox<String> comboBoxActividad;
	private JComboBox<String> comboBoxProfesor;
	private JDateChooser dateChooser;
	private JTextField textFieldImagenURL;
	
	/**
	 * Create the frame.
	 */
	public AltaClase(IControladorAltaDictadoDeClase iconAC) {
		
		this.iconAC = iconAC;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Clase");
		setBounds(100, 100, 479, 344);
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
		lblNombre.setBounds(10, 170, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(102, 167, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha Inicio:");
		lblFechaDeInicio.setBounds(10, 201, 80, 15);
		getContentPane().add(lblFechaDeInicio);
		
		JLabel lblHoraDeInicio = new JLabel("Hora Inicio: ");
		lblHoraDeInicio.setBounds(242, 201, 70, 15);
		getContentPane().add(lblHoraDeInicio);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		lblProfesor.setBounds(10, 104, 70, 15);
		getContentPane().add(lblProfesor);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(280, 170, 32, 15);
		getContentPane().add(lblUrl);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(83, 278, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaClaseCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(268, 278, 117, 25);
		getContentPane().add(btnCancelar);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(326, 170, 114, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		comboBoxProfesor = new JComboBox<String>();
		comboBoxProfesor.setBounds(101, 96, 104, 24);
		getContentPane().add(comboBoxProfesor);
		
		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setBounds(326, 199, 114, 19);
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
		dateChooser.setBounds(102, 196, 114, 19);
		getContentPane().add(dateChooser);
		
		comboBoxActividad.setEnabled(false);
		comboBoxProfesor.setEnabled(false);
		
		textFieldNombre.setEnabled(false);
		textFieldURL.setEnabled(false);
		textFieldHoraInicio.setEnabled(false);
		//textFieldImagenURL.setEnabled(false);
		dateChooser.setEnabled(false);
		
		JLabel lblEtiquetaClase = new JLabel("Datos de la clase:");
		lblEtiquetaClase.setBounds(10, 142, 128, 14);
		getContentPane().add(lblEtiquetaClase);
		
		JLabel lblEtiquetaImagen = new JLabel("Imagen URL:");
		lblEtiquetaImagen.setBounds(10, 230, 80, 15);
		getContentPane().add(lblEtiquetaImagen);
		
		textFieldImagenURL = new JTextField();
		textFieldImagenURL.setBounds(101, 224, 115, 20);
		getContentPane().add(textFieldImagenURL);
		textFieldImagenURL.setColumns(10);

	}
	
	public void altaClaseCancelarActionPerformed(ActionEvent e){
		limpiarFormulario();
		setVisible(false);
	}
	
	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldURL.setText("");
		textFieldHoraInicio.setText("");
		textFieldImagenURL.setText("");
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
		//textFieldImagenURL.setEnabled(true);
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
			String imagenURL = this.textFieldImagenURL.getText();
			
			try {
				this.iconAC.altaDictadoClase(nombreInst, nombreAct, nombreProf, nombre, fecha, horaIni, url, fechaReg, imagenURL);
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
	
}
