package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import interfaces.IControladorRegistroClase;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import datatypes.DtClase;
import exceptions.RegistroRepetidoException;

public class RegistroSocioClase extends JInternalFrame {
	
	private IControladorRegistroClase iconRC;

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldFecha;
	private JTextField textFieldHoraInicio;
	private JTextField textFieldURL;
	private JTextField textFieldFechaReg;
	private JComboBox<String> comboBoxInstitucion;
	private JComboBox<String> comboBoxActividad;
	private JComboBox<String> comboBoxClase;
	private JButton btnElegirAct;
	private JButton btnElegirClase;
	private JComboBox<String> comboBoxSocio;
	private JLabel lblSocio;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblNombre;
	private JLabel lblFecha;
	private JLabel lblHoraDeInicio;
	private JLabel lblUrl;
	private JLabel lblFechareg;
	
	/**
	 * Create the frame.
	 */
	public RegistroSocioClase(IControladorRegistroClase iconRC) {
		this.iconRC=iconRC;
		
		setBounds(100, 100, 450, 300);
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registro de Socio a Clase");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setBounds(72, 18, 76, 15);
		getContentPane().add(lblInstitucion);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(150, 13, 86, 24);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblActividad = new JLabel("Actividad");
		lblActividad.setBounds(78, 50, 70, 15);
		getContentPane().add(lblActividad);
		
		comboBoxActividad = new JComboBox<String>();
		comboBoxActividad.setBounds(150, 45, 86, 24);
		getContentPane().add(comboBoxActividad);
		
		JButton btnElegirInsti = new JButton("Elegir Insti");
		btnElegirInsti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarComboBoxActividad(e);
			}
		});
		btnElegirInsti.setBounds(253, 12, 117, 25);
		getContentPane().add(btnElegirInsti);
		
		btnElegirAct = new JButton("Elegir Act");
		btnElegirAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarComboBoxClase(e);
			}
		});
		btnElegirAct.setBounds(253, 44, 117, 25);
		getContentPane().add(btnElegirAct);
		
		JLabel lblClase = new JLabel("Clase");
		lblClase.setBounds(103, 82, 45, 15);
		getContentPane().add(lblClase);
		
		comboBoxClase = new JComboBox<String>();
		comboBoxClase.setBounds(150, 77, 86, 24);
		getContentPane().add(comboBoxClase);
		
		btnElegirClase = new JButton("Elegir Clase");
		btnElegirClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirClaseActionPerformed(e);
				
				textFieldNombre.setVisible(true);
				textFieldFecha.setVisible(true);
				textFieldHoraInicio.setVisible(true);
				textFieldURL.setVisible(true);
				textFieldFechaReg.setVisible(true);
				
				textFieldNombre.setEnabled(false);
				textFieldFecha.setEnabled(false);
				textFieldHoraInicio.setEnabled(false);
				textFieldURL.setEnabled(false);
				textFieldFechaReg.setEnabled(false);
				
				lblNombre.setVisible(true);
				lblFecha.setVisible(true);
				lblHoraDeInicio.setVisible(true);
				lblUrl.setVisible(true);
				lblFechareg.setVisible(true);
				lblSocio.setVisible(true);
				
				comboBoxSocio.setVisible(true);
				btnCancelar.setVisible(true);
				btnAceptar.setVisible(true);
			}
		});
		btnElegirClase.setBounds(253, 76, 117, 25);
		getContentPane().add(btnElegirClase);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(53, 108, 61, 15);
		getContentPane().add(lblNombre);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(193, 108, 51, 15);
		getContentPane().add(lblFecha);
		
		lblHoraDeInicio = new JLabel("Hora de Inicio");
		lblHoraDeInicio.setBounds(307, 108, 107, 15);
		getContentPane().add(lblHoraDeInicio);
		
		lblUrl = new JLabel("URL");
		lblUrl.setBounds(54, 166, 36, 15);
		getContentPane().add(lblUrl);
		
		lblFechareg = new JLabel("FechaReg");
		lblFechareg.setBounds(322, 166, 70, 15);
		getContentPane().add(lblFechareg);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(24, 135, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(162, 135, 114, 19);
		getContentPane().add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setBounds(300, 135, 114, 19);
		getContentPane().add(textFieldHoraInicio);
		textFieldHoraInicio.setColumns(10);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(24, 193, 114, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setBounds(300, 193, 114, 19);
		getContentPane().add(textFieldFechaReg);
		textFieldFechaReg.setColumns(10);
		
		comboBoxActividad.setEnabled(false);
		btnElegirAct.setEnabled(false);
		comboBoxClase.setEnabled(false);
		btnElegirClase.setEnabled(false);
		
		textFieldNombre.setEnabled(false);
		textFieldFecha.setEnabled(false);
		textFieldHoraInicio.setEnabled(false);
		textFieldURL.setEnabled(false);
		textFieldFechaReg.setEnabled(false);
		
		comboBoxSocio = new JComboBox<String>();
		comboBoxSocio.setBounds(162, 188, 114, 24);
		getContentPane().add(comboBoxSocio);
		
		lblSocio = new JLabel("Socio");
		lblSocio.setBounds(185, 161, 45, 15);
		getContentPane().add(lblSocio);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroSCAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(68, 224, 117, 25);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroSCCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(253, 224, 117, 25);
		getContentPane().add(btnCancelar);
		
		textFieldNombre.setVisible(false);
		textFieldFecha.setVisible(false);
		textFieldHoraInicio.setVisible(false);
		textFieldURL.setVisible(false);
		textFieldFechaReg.setVisible(false);
		
		lblNombre.setVisible(false);
		lblFecha.setVisible(false);
		lblHoraDeInicio.setVisible(false);
		lblUrl.setVisible(false);
		lblFechareg.setVisible(false);
		lblSocio.setVisible(false);
		
		comboBoxSocio.setVisible(false);
		btnCancelar.setVisible(false);
		btnAceptar.setVisible(false);

	}
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconRC.listarInstituciones());
		comboBoxInstitucion.setModel(modelinstituciones);
    }
	
	public void inicializarComboBoxActividad(ActionEvent e) {
		comboBoxActividad.setEnabled(true);
		btnElegirAct.setEnabled(true);
		
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
			
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconRC.listarActividades(nombreInsti));
		comboBoxActividad.setModel(modelactividades);
		
	}
	public void inicializarComboBoxClase(ActionEvent e) {
		comboBoxClase.setEnabled(true);
		btnElegirClase.setEnabled(true);
		
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreActividad = this.comboBoxActividad.getSelectedItem().toString();
			
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconRC.listarClases(nombreInsti, nombreActividad));
		comboBoxClase.setModel(modelactividades);
		
		textFieldNombre.setEnabled(true);
		textFieldFecha.setEnabled(true);
		textFieldHoraInicio.setEnabled(true);
		textFieldURL.setEnabled(true);
		textFieldFechaReg.setEnabled(true);
	}

	public void elegirClaseActionPerformed(ActionEvent e){
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreActividad = this.comboBoxActividad.getSelectedItem().toString();
		String nombreClase = this.comboBoxClase.getSelectedItem().toString();
		DtClase dtClase = iconRC.obtenerDtClase(nombreInsti, nombreActividad, nombreClase);
		this.textFieldNombre.setText(dtClase.getNombre());
		Integer dayFecha = dtClase.getFecha().get(Calendar.DAY_OF_MONTH);
		Integer monthFecha = dtClase.getFecha().get(Calendar.MONTH)+1;
		Integer yearFecha = dtClase.getFecha().get(Calendar.YEAR);
		this.textFieldFecha.setText(dayFecha.toString()+ "/"+ monthFecha.toString()+"/"+ yearFecha.toString());	
		this.textFieldHoraInicio.setText(dtClase.getHoraInicio().toString());
		this.textFieldURL.setText(dtClase.getUrl());
		Integer day = dtClase.getFechaReg().get(Calendar.DAY_OF_MONTH);
		Integer month = dtClase.getFechaReg().get(Calendar.MONTH)+1;
		Integer year = dtClase.getFechaReg().get(Calendar.YEAR);
		this.textFieldFechaReg.setText(day.toString()+ "/"+ month.toString()+"/"+ year.toString());
		
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconRC.listarSocios());
		comboBoxSocio.setModel(modelactividades);
		
	}
	
	public void registroSCAceptarActionPerformed(ActionEvent e){
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreActividad = this.comboBoxActividad.getSelectedItem().toString();
		String nombreSocio = this.comboBoxSocio.getSelectedItem().toString();
		String nombreClase = this.comboBoxClase.getSelectedItem().toString();
		Calendar fechaRegSC = Calendar.getInstance();
		try {
			this.iconRC.registroSocioClase(nombreInsti, nombreActividad, nombreSocio, nombreClase, fechaRegSC);
			JOptionPane.showMessageDialog(this, "El " + nombreSocio+ " ha sido dado de alta con éxito en la clase "+ nombreClase, "Registro de Socio a Clase", JOptionPane.INFORMATION_MESSAGE);
			limpiarFormulario();
			setVisible(false);
		}catch (RegistroRepetidoException p) {
			JOptionPane.showMessageDialog(this, p.getMessage(), "Registro de Socio a Clase\"", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

	public void registroSCCancelarActionPerformed(ActionEvent e) {
		limpiarFormulario();
		setVisible(false);
	}
	
	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldFecha.setText("");
		textFieldHoraInicio.setText("");
		textFieldURL.setText("");
		textFieldFechaReg.setText("");
	}

}
