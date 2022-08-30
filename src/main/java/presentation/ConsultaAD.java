package presentation;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import interfaces.IControladorConsultaAct;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class ConsultaAD extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private IControladorConsultaAct iconCA;
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JTextField textFieldFechaReg;
	private JComboBox<String> comboBoxInstitucion;
	private JComboBox<String> comboBoxActividad;
	private JComboBox<String> comboBoxClase;
	private JButton btnElegirAct;
	private JButton btnElegirClase;
	private JTextField textFieldNombreClase;
	private JTextField textFieldFechaClase;
	private JTextField textFieldFechaRegClase;
	private JTextField textFieldHoraInicioClase;
	private JTextField textFieldURLClase;
	private JLabel lblInstitucion;
	private JLabel lblActividad;
	private JLabel lblNombre;
	private JLabel lblDescripcion;
	private JLabel lblDuracion;
	private JLabel lblCosto;
	private JLabel lblFechaReg;
	private JLabel lblNombreClase;
	private JLabel lblFechaCLase;
	private JLabel lblFechaRegClase;
	private JLabel lblHoraDeInicioClase;
	private JLabel lblURLClase;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaAD frame = new ConsultaAD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaAD(IControladorConsultaAct iconCA) {
		this.iconCA=iconCA;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta Actividad");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setBounds(12, 12, 76, 15);
		getContentPane().add(lblInstitucion);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(90, 7, 114, 24);
		getContentPane().add(comboBoxInstitucion);
		
		lblActividad = new JLabel("Actividad");
		lblActividad.setBounds(12, 60, 70, 15);
		getContentPane().add(lblActividad);
		
		comboBoxActividad = new JComboBox<String>();
		comboBoxActividad.setBounds(90, 60, 114, 24);
		getContentPane().add(comboBoxActividad);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 102, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(24, 129, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(34, 160, 93, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(24, 175, 114, 42);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(175, 101, 70, 15);
		getContentPane().add(lblDuracion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(162, 129, 114, 19);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		lblCosto = new JLabel("Costo");
		lblCosto.setBounds(231, 188, 51, 15);
		getContentPane().add(lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(300, 186, 114, 19);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		lblFechaReg = new JLabel("FechaReg");
		lblFechaReg.setBounds(312, 101, 70, 15);
		getContentPane().add(lblFechaReg);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setBounds(300, 129, 114, 19);
		getContentPane().add(textFieldFechaReg);
		textFieldFechaReg.setColumns(10);
		
		JLabel lblClase_1 = new JLabel("Clase");
		lblClase_1.setBounds(75, 237, 51, 15);
		getContentPane().add(lblClase_1);
		
		comboBoxClase = new JComboBox<String>();
		comboBoxClase.setBounds(144, 232, 135, 24);
		getContentPane().add(comboBoxClase);
		
		JButton btnElegirInsti = new JButton("Elegir Insti");
		btnElegirInsti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarComboBoxActividad(e);
			}
		});
		btnElegirInsti.setBounds(244, 7, 117, 25);
		getContentPane().add(btnElegirInsti);
		
		btnElegirAct = new JButton("Elegir Act");
		btnElegirAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirActActionPerformed(e);
			}
		});
		btnElegirAct.setBounds(244, 55, 117, 25);
		getContentPane().add(btnElegirAct);
		
		btnElegirClase = new JButton("Elegir Clase");
		btnElegirClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirClaseActionPerformed(e);
			}
		});
		btnElegirClase.setBounds(295, 232, 117, 25);	
		getContentPane().add(btnElegirClase);
			
			
		lblNombreClase = new JLabel("Nombre");
		lblNombreClase.setBounds(43, 102, 70, 15);
		getContentPane().add(lblNombreClase);
		
		textFieldNombreClase = new JTextField();
		textFieldNombreClase.setBounds(24, 129, 114, 19);
		getContentPane().add(textFieldNombreClase);
		textFieldNombreClase.setColumns(10);
		
		lblFechaCLase = new JLabel("Fecha");
		lblFechaCLase.setBounds(199, 102, 51, 15);
		getContentPane().add(lblFechaCLase);
		
		textFieldFechaClase = new JTextField();
		textFieldFechaClase.setColumns(10);
		textFieldFechaClase.setBounds(162, 129, 114, 19);
		getContentPane().add(textFieldFechaClase);
		
		lblFechaRegClase = new JLabel("FechaReg");
		lblFechaRegClase.setBounds(312, 102, 70, 15);
		getContentPane().add(lblFechaRegClase);
		
		textFieldFechaRegClase = new JTextField();
		textFieldFechaRegClase.setColumns(10);
		textFieldFechaRegClase.setBounds(300, 129, 114, 19);
		getContentPane().add(textFieldFechaRegClase);
		
		lblHoraDeInicioClase = new JLabel("Hora de Inicio");
		lblHoraDeInicioClase.setBounds(29, 160, 107, 15);
		getContentPane().add(lblHoraDeInicioClase);
		
		textFieldHoraInicioClase = new JTextField();
		textFieldHoraInicioClase.setColumns(10);
		textFieldHoraInicioClase.setBounds(24, 187, 114, 19);
		getContentPane().add(textFieldHoraInicioClase);
		
		lblURLClase = new JLabel("URL");
		lblURLClase.setBounds(240, 188, 36, 15);
		getContentPane().add(lblURLClase);
		
		textFieldURLClase = new JTextField();
		textFieldURLClase.setColumns(10);
		textFieldURLClase.setBounds(300, 187, 114, 19);
		getContentPane().add(textFieldURLClase);
		
		comboBoxActividad.setEnabled(false);
		btnElegirAct.setEnabled(false);
		comboBoxClase.setEnabled(false);
		btnElegirClase.setEnabled(false);
			
		visibleActividad(false);
		visibleClase(false);
	}
	
	
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconCA.listarInstituciones());
		comboBoxInstitucion.setModel(modelinstituciones);
    }
	
	public void inicializarComboBoxActividad(ActionEvent e) {
		comboBoxActividad.setEnabled(true);
		btnElegirAct.setEnabled(true);
		
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
			
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconCA.obtenerActividadesDeportivas(nombreInsti));
		comboBoxActividad.setModel(modelactividades);
		
	}
	
	public void elegirActActionPerformed(ActionEvent e){
		btnElegirClase.setEnabled(true);
		comboBoxClase.setEnabled(true);
		visibleActividad(true);
		visibleClase(false);
		
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreAct = this.comboBoxActividad.getSelectedItem().toString();
		DtActividadDeportiva dtActDep = iconCA.obtenerDtActividadDeportivaInst(nombreInsti, nombreAct);
		this.textFieldNombre.setText(dtActDep.getNombre());
		this.textFieldCosto.setText(dtActDep.getCosto().toString());
		this.textFieldDescripcion.setText(dtActDep.getDescripcion());
		this.textFieldDuracion.setText(dtActDep.getDuracion().toString());
		Integer day = dtActDep.getFechaReg().get(Calendar.DAY_OF_MONTH);
		Integer month = dtActDep.getFechaReg().get(Calendar.MONTH)+1;
		Integer year = dtActDep.getFechaReg().get(Calendar.YEAR);
		this.textFieldFechaReg.setText(day.toString()+ "/"+ month.toString()+"/"+ year.toString());
		
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconCA.listarClases(nombreInsti, nombreAct));
		comboBoxClase.setModel(modelactividades);
	}
	
	public void elegirClaseActionPerformed(ActionEvent e) {
		visibleActividad(false);
		visibleClase(true);
		
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreActividad = this.comboBoxActividad.getSelectedItem().toString();
		String nombreClase = this.comboBoxClase.getSelectedItem().toString();
		DtClase dtClase = iconCA.obtenerDtClase(nombreInsti, nombreActividad, nombreClase);
		this.textFieldNombreClase.setText(dtClase.getNombre());
		Integer dayFecha = dtClase.getFecha().get(Calendar.DAY_OF_MONTH);
		Integer monthFecha = dtClase.getFecha().get(Calendar.MONTH)+1;
		Integer yearFecha = dtClase.getFecha().get(Calendar.YEAR);
		this.textFieldFechaClase.setText(dayFecha.toString()+ "/"+ monthFecha.toString()+"/"+ yearFecha.toString());	
		this.textFieldHoraInicioClase.setText(dtClase.getHoraInicio().toString());
		this.textFieldURLClase.setText(dtClase.getUrl());
		Integer day = dtClase.getFechaReg().get(Calendar.DAY_OF_MONTH);
		Integer month = dtClase.getFechaReg().get(Calendar.MONTH)+1;
		Integer year = dtClase.getFechaReg().get(Calendar.YEAR);
		this.textFieldFechaRegClase.setText(day.toString()+ "/"+ month.toString()+"/"+ year.toString());
		
	}
	
	public void visibleActividad(boolean visible) {
		lblNombre.setVisible(visible);
		lblDescripcion.setVisible(visible);
		lblDuracion.setVisible(visible);
		lblCosto.setVisible(visible);
		lblFechaReg.setVisible(visible);
		textFieldNombre.setVisible(visible);
		textFieldDescripcion.setVisible(visible);
		textFieldDuracion.setVisible(visible);
		textFieldCosto.setVisible(visible);
		textFieldFechaReg.setVisible(visible);
	}
	
	public void visibleClase(boolean visible) {
		lblNombreClase.setVisible(visible);
		lblFechaCLase.setVisible(visible);
		lblFechaRegClase.setVisible(visible);
		lblHoraDeInicioClase.setVisible(visible);
		lblURLClase.setVisible(visible);
		textFieldNombreClase.setVisible(visible);
		textFieldFechaClase.setVisible(visible);
		textFieldFechaRegClase.setVisible(visible);
		textFieldHoraInicioClase.setVisible(visible);
		textFieldURLClase.setVisible(visible);
	}
}
