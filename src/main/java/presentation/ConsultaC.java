package presentation;

import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;

import interfaces.IControladorConsultaClase;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import datatypes.DtClase;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ConsultaC extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorConsultaClase iconCC;
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
	private JLabel lblClase;
	private JLabel lblNombre;
	private JLabel lblFecha;
	private JLabel lblHoraDeInicio;
	private JLabel lblUrl;
	private JLabel lblFechareg;
	private JLabel lblImagenClase;
	private JTextField textFieldImagenURL;

	/**
	 * Create the frame.
	 */
	public ConsultaC(IControladorConsultaClase iconCC) {
		this.iconCC=iconCC;
		
		setBounds(100, 100, 601, 399);
		getContentPane().setLayout(null);
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta Clase");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setBounds(44, 17, 76, 15);
		getContentPane().add(lblInstitucion);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(122, 12, 117, 24);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblActividad = new JLabel("Actividad");
		lblActividad.setBounds(50, 49, 70, 15);
		getContentPane().add(lblActividad);
		
		comboBoxActividad = new JComboBox<String>();
		comboBoxActividad.setBounds(122, 44, 117, 24);
		getContentPane().add(comboBoxActividad);
		
		JButton btnElegirInsti = new JButton("Elegir Insti");
		btnElegirInsti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarComboBoxActividad(e);
			}
		});
		btnElegirInsti.setBounds(251, 12, 117, 25);
		getContentPane().add(btnElegirInsti);
		
		btnElegirAct = new JButton("Elegir Act");
		btnElegirAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarComboBoxClase(e);
			}
		});
		btnElegirAct.setBounds(251, 44, 117, 25);
		getContentPane().add(btnElegirAct);
		
		lblClase = new JLabel("Clase");
		lblClase.setBounds(75, 81, 45, 15);
		getContentPane().add(lblClase);
		
		comboBoxClase = new JComboBox<String>();
		comboBoxClase.setBounds(122, 76, 117, 24);
		getContentPane().add(comboBoxClase);
		
		btnElegirClase = new JButton("Elegir Clase");
		btnElegirClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirClaseActionPerformed(e);
				textFieldNombre.setEnabled(false);
				textFieldFecha.setEnabled(false);
				textFieldHoraInicio.setEnabled(false);
				textFieldURL.setEnabled(false);
				textFieldFechaReg.setEnabled(false);
				textFieldImagenURL.setEnabled(false);
				
				textFieldNombre.setVisible(true);
				textFieldFecha.setVisible(true);
				textFieldHoraInicio.setVisible(true);
				textFieldURL.setVisible(true);
				textFieldFechaReg.setVisible(true);
				textFieldImagenURL.setVisible(true);

				lblNombre.setVisible(true);
				lblFecha.setVisible(true);
				lblHoraDeInicio.setVisible(true);
				lblUrl.setVisible(true);
				lblFechareg.setVisible(true);
				lblImagenClase.setVisible(true);
			}
		});
		btnElegirClase.setBounds(251, 76, 117, 25);
		getContentPane().add(btnElegirClase);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(55, 133, 61, 15);
		getContentPane().add(lblNombre);
		
		lblFecha = new JLabel("Fecha Inicio");
		lblFecha.setBounds(181, 133, 76, 15);
		getContentPane().add(lblFecha);
		
		lblHoraDeInicio = new JLabel("Hora de Inicio");
		lblHoraDeInicio.setBounds(317, 133, 83, 15);
		getContentPane().add(lblHoraDeInicio);
		
		lblUrl = new JLabel("URL");
		lblUrl.setBounds(66, 190, 36, 15);
		getContentPane().add(lblUrl);
		
		lblFechareg = new JLabel("Fecha Registro");
		lblFechareg.setBounds(174, 190, 90, 15);
		getContentPane().add(lblFechareg);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(24, 159, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(162, 159, 114, 19);
		getContentPane().add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setBounds(301, 159, 114, 19);
		getContentPane().add(textFieldHoraInicio);
		textFieldHoraInicio.setColumns(10);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(24, 217, 114, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setBounds(162, 217, 114, 19);
		getContentPane().add(textFieldFechaReg);
		textFieldFechaReg.setColumns(10);
		
		comboBoxActividad.setEnabled(false);
		btnElegirAct.setEnabled(false);
		comboBoxClase.setEnabled(false);
		btnElegirClase.setEnabled(false);
		
		lblImagenClase = new JLabel("Imagen URL");
		lblImagenClase.setBounds(317, 190, 83, 14);
		getContentPane().add(lblImagenClase);
		
		textFieldImagenURL = new JTextField();
		textFieldImagenURL.setBounds(301, 216, 114, 20);
		getContentPane().add(textFieldImagenURL);
		textFieldImagenURL.setColumns(10);
		
		textFieldNombre.setVisible(false);
		textFieldFecha.setVisible(false);
		textFieldHoraInicio.setVisible(false);
		textFieldURL.setVisible(false);
		textFieldFechaReg.setVisible(false);
		textFieldImagenURL.setVisible(false);
		
		lblNombre.setVisible(false);
		lblFecha.setVisible(false);
		lblHoraDeInicio.setVisible(false);
		lblUrl.setVisible(false);
		lblFechareg.setVisible(false);
		lblImagenClase.setVisible(false);

	}
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconCC.listarInstituciones());
		comboBoxInstitucion.setModel(modelinstituciones);
    }
	
	public void inicializarComboBoxActividad(ActionEvent e) {
		comboBoxActividad.setEnabled(true);
		btnElegirAct.setEnabled(true);
		
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
			
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconCC.listarActividadesDeportivas(nombreInsti));
		comboBoxActividad.setModel(modelactividades);
		
	}
	public void inicializarComboBoxClase(ActionEvent e) {
		comboBoxClase.setEnabled(true);
		btnElegirClase.setEnabled(true);
		
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreActividad = this.comboBoxActividad.getSelectedItem().toString();
			
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconCC.listarClases(nombreInsti, nombreActividad));
		comboBoxClase.setModel(modelactividades);
		
	}

	public void elegirClaseActionPerformed(ActionEvent e){
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreActividad = this.comboBoxActividad.getSelectedItem().toString();
		String nombreClase = this.comboBoxClase.getSelectedItem().toString();
		DtClase dtClase = iconCC.obtenerDtClase(nombreInsti, nombreActividad, nombreClase);
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
		this.textFieldImagenURL.setText(dtClase.getImagenClaseURL());
	}
}
