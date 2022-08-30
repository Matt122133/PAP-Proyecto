package presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;

import interfaces.IControladorConsultaClase;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;

import java.awt.event.ActionListener;
import java.util.Calendar;

public class ConsultaC extends JInternalFrame {

	/**
	 * 
	 */
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

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaC frame = new ConsultaC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public ConsultaC(IControladorConsultaClase iconCC) {
		this.iconCC=iconCC;
		
		setBounds(100, 100, 450, 300);
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
		
		JLabel lblClase = new JLabel("Clase");
		lblClase.setBounds(75, 81, 45, 15);
		getContentPane().add(lblClase);
		
		comboBoxClase = new JComboBox<String>();
		comboBoxClase.setBounds(122, 76, 117, 24);
		getContentPane().add(comboBoxClase);
		
		btnElegirClase = new JButton("Elegir Clase");
		btnElegirClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirClaseActionPerformed(e);
			}
		});
		btnElegirClase.setBounds(251, 76, 117, 25);
		getContentPane().add(btnElegirClase);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(55, 133, 61, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(199, 133, 51, 15);
		getContentPane().add(lblFecha);
		
		JLabel lblHoraDeInicio = new JLabel("Hora de Inicio");
		lblHoraDeInicio.setBounds(305, 133, 107, 15);
		getContentPane().add(lblHoraDeInicio);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(112, 207, 36, 15);
		getContentPane().add(lblUrl);
		
		JLabel lblFechareg = new JLabel("FechaReg");
		lblFechareg.setBounds(278, 207, 70, 15);
		getContentPane().add(lblFechareg);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(24, 160, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(162, 160, 114, 19);
		getContentPane().add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setBounds(300, 160, 114, 19);
		getContentPane().add(textFieldHoraInicio);
		textFieldHoraInicio.setColumns(10);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(70, 234, 114, 19);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setBounds(254, 234, 114, 19);
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
	}
}
