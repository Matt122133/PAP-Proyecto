package presentation;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import datatypes.DtClase;
import exceptions.SocioNoRegistrado;
import interfaces.IControladorEliminarRegistro;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class EliminarRegistro extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorEliminarRegistro iconER;
	
	private JTextField textFieldNomClase;
	private JTextField textFieldFechaIniClase;
	private JTextField textFieldHoraInicio;
	private JTextField textFieldURL;
	private JTextField textFieldFechaReg;
	
	private JComboBox<String> comboBoxSocio;
	private JComboBox<String> comboBoxInstitucion;
	private JComboBox<String> comboBoxActividad;
	private JComboBox<String> comboBoxClase;
	
	private JLabel lblNomClase;
	private JLabel lblFechaInicioClase;
	private JLabel lblHoraInicio;
	private JLabel lblURL;
	private JLabel lblFechaReg;
	private JLabel lblSocio;
	
	
	private JButton btnElegirAct;
	private JButton btnElegirClase;
	private JButton btnElegirInsti;
	private JButton btnEliminar;
	private JButton btnCancelar;

	
	public EliminarRegistro(IControladorEliminarRegistro iconER) {
		
		this.iconER = iconER;
		
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Eliminar Registro");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Institucion");
		lblInstitucion.setBounds(54, 17, 76, 15);
		getContentPane().add(lblInstitucion);
		
		JLabel lblActividad = new JLabel("Actividad");
		lblActividad.setBounds(60, 49, 70, 15);
		getContentPane().add(lblActividad);
		
		JLabel lblClase = new JLabel("Clase");
		lblClase.setBounds(85, 81, 45, 15);
		getContentPane().add(lblClase);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(132, 12, 86, 24);
		getContentPane().add(comboBoxInstitucion);
		
		comboBoxActividad = new JComboBox<String>();
		comboBoxActividad.setEnabled(false);
		comboBoxActividad.setBounds(132, 44, 86, 24);
		getContentPane().add(comboBoxActividad);
		
		comboBoxClase = new JComboBox<String>();
		comboBoxClase.setEnabled(false);
		comboBoxClase.setBounds(132, 76, 86, 24);
		getContentPane().add(comboBoxClase);
		
		btnElegirInsti = new JButton("Elegir Insti");
		btnElegirInsti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarComboBoxActividad(e);
			}
		});
		btnElegirInsti.setBounds(235, 11, 117, 25);
		getContentPane().add(btnElegirInsti);
		
		btnElegirAct = new JButton("Elegir Act");
		btnElegirAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarComboBoxClase(e);
			}
		});
		btnElegirAct.setEnabled(false);
		btnElegirAct.setBounds(235, 43, 117, 25);
		getContentPane().add(btnElegirAct);
		
		btnElegirClase = new JButton("Elegir Clase");
		btnElegirClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elegirClaseActionPerformed(e);
				
				textFieldNomClase.setVisible(true);
				textFieldFechaIniClase.setVisible(true);
				textFieldHoraInicio.setVisible(true);
				textFieldURL.setVisible(true);
				textFieldFechaReg.setVisible(true);
				
				textFieldNomClase.setEnabled(false);
				textFieldFechaIniClase.setEnabled(false);
				textFieldHoraInicio.setEnabled(false);
				textFieldURL.setEnabled(false);
				textFieldFechaReg.setEnabled(false);
				
				lblNomClase.setVisible(true);
				lblFechaInicioClase.setVisible(true);
				lblHoraInicio.setVisible(true);
				lblURL.setVisible(true);
				lblFechaReg.setVisible(true);
				lblSocio.setVisible(true);
				
				comboBoxSocio.setVisible(true);
				btnCancelar.setVisible(true);
				btnEliminar.setVisible(true);
			}
		});
		btnElegirClase.setEnabled(false);
		btnElegirClase.setBounds(235, 75, 117, 25);
		getContentPane().add(btnElegirClase);
		
		lblNomClase = new JLabel("Nombre");
		lblNomClase.setBounds(54, 111, 48, 14);
		getContentPane().add(lblNomClase);
		
		textFieldNomClase = new JTextField();
		textFieldNomClase.setBounds(30, 129, 96, 20);
		getContentPane().add(textFieldNomClase);
		textFieldNomClase.setColumns(10);
		
		lblFechaInicioClase = new JLabel("Fecha Inicio");
		lblFechaInicioClase.setBounds(162, 111, 70, 14);
		getContentPane().add(lblFechaInicioClase);
		
		textFieldFechaIniClase = new JTextField();
		textFieldFechaIniClase.setBounds(149, 129, 96, 20);
		getContentPane().add(textFieldFechaIniClase);
		textFieldFechaIniClase.setColumns(10);
		
		lblHoraInicio = new JLabel("Hora Inicio");
		lblHoraInicio.setBounds(285, 111, 67, 14);
		getContentPane().add(lblHoraInicio);
		
		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setBounds(270, 129, 96, 20);
		getContentPane().add(textFieldHoraInicio);
		textFieldHoraInicio.setColumns(10);
		
		lblURL = new JLabel("URL");
		lblURL.setBounds(63, 170, 31, 14);
		getContentPane().add(lblURL);
		
		textFieldURL = new JTextField();
		textFieldURL.setBounds(30, 188, 96, 20);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		lblFechaReg = new JLabel("Fecha Registro");
		lblFechaReg.setBounds(278, 170, 81, 14);
		getContentPane().add(lblFechaReg);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setBounds(270, 188, 96, 20);
		getContentPane().add(textFieldFechaReg);
		textFieldFechaReg.setColumns(10);
		
		lblSocio = new JLabel("Socio");
		lblSocio.setBounds(173, 169, 48, 14);
		getContentPane().add(lblSocio);
		
		comboBoxSocio = new JComboBox<String>();
		comboBoxSocio.setBounds(149, 186, 96, 22);
		getContentPane().add(comboBoxSocio);
		
		btnEliminar = new JButton("Eliminar ");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarRegistroActionPerformed(e);
			}
		});
		btnEliminar.setBounds(92, 236, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroSCCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(235, 236, 89, 23);
		getContentPane().add(btnCancelar);
		
		textFieldNomClase.setVisible(false);
		textFieldFechaIniClase.setVisible(false);
		textFieldHoraInicio.setVisible(false);
		textFieldURL.setVisible(false);
		textFieldFechaReg.setVisible(false);
		
		lblNomClase.setVisible(false);
		lblFechaInicioClase.setVisible(false);
		lblHoraInicio.setVisible(false);
		lblURL.setVisible(false);
		lblFechaReg.setVisible(false);
		lblSocio.setVisible(false);
		
		comboBoxSocio.setVisible(false);
		btnCancelar.setVisible(false);
		btnEliminar.setVisible(false);
	}
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconER.listarInstituciones());
		comboBoxInstitucion.setModel(modelinstituciones);
    }
	
	public void inicializarComboBoxActividad(ActionEvent e) {
		comboBoxActividad.setEnabled(true);
		btnElegirAct.setEnabled(true);
		
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
			
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconER.listarActividades(nombreInsti));
		comboBoxActividad.setModel(modelactividades);
		
	}
	
	public void inicializarComboBoxClase(ActionEvent e) {
		comboBoxClase.setEnabled(true);
		btnElegirClase.setEnabled(true);
		
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreActividad = this.comboBoxActividad.getSelectedItem().toString();
			
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconER.listarClases(nombreInsti, nombreActividad));
		comboBoxClase.setModel(modelactividades);
		
		textFieldNomClase.setEnabled(true);
		textFieldFechaIniClase.setEnabled(true);
		textFieldHoraInicio.setEnabled(true);
		textFieldURL.setEnabled(true);
		textFieldFechaReg.setEnabled(true);
	}
	
	public void elegirClaseActionPerformed(ActionEvent e){
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreActividad = this.comboBoxActividad.getSelectedItem().toString();
		String nombreClase = this.comboBoxClase.getSelectedItem().toString();
		DtClase dtClase = iconER.obtenerDtClase(nombreInsti, nombreActividad, nombreClase);
		this.textFieldNomClase.setText(dtClase.getNombre());
		Integer dayFecha = dtClase.getFecha().get(Calendar.DAY_OF_MONTH);
		Integer monthFecha = dtClase.getFecha().get(Calendar.MONTH)+1;
		Integer yearFecha = dtClase.getFecha().get(Calendar.YEAR);
		this.textFieldFechaIniClase.setText(dayFecha.toString()+ "/"+ monthFecha.toString()+"/"+ yearFecha.toString());	
		this.textFieldHoraInicio.setText(dtClase.getHoraInicio().toString());
		this.textFieldURL.setText(dtClase.getUrl());
		Integer day = dtClase.getFechaReg().get(Calendar.DAY_OF_MONTH);
		Integer month = dtClase.getFechaReg().get(Calendar.MONTH)+1;
		Integer year = dtClase.getFechaReg().get(Calendar.YEAR);
		this.textFieldFechaReg.setText(day.toString()+ "/"+ month.toString()+"/"+ year.toString());
		
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconER.listarSocios());
		comboBoxSocio.setModel(modelactividades);
		
	}
	
	public void eliminarRegistroActionPerformed(ActionEvent e){
		String nombreInsti = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreActividad = this.comboBoxActividad.getSelectedItem().toString();
		String nombreSocio = this.comboBoxSocio.getSelectedItem().toString();
		String nombreClase = this.comboBoxClase.getSelectedItem().toString();
		
		try {
			this.iconER.eliminarRegistro(nombreSocio, nombreClase, nombreInsti, nombreActividad);
			JOptionPane.showMessageDialog(this, "El " + nombreSocio + " ha sido eliminado con éxito de la clase " + nombreClase , "Eliminar Registro"  , JOptionPane.INFORMATION_MESSAGE);
			limpiarFormulario();
			setVisible(false);
		}catch (SocioNoRegistrado p) {
			JOptionPane.showMessageDialog(this, p.getMessage(), "Eliminar Registro\"", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void registroSCCancelarActionPerformed(ActionEvent e) {
		limpiarFormulario();
		setVisible(false);
	}
	
	public void limpiarFormulario() {
		textFieldNomClase.setText("");
		textFieldFechaIniClase.setText("");
		textFieldHoraInicio.setText("");
		textFieldURL.setText("");
		textFieldFechaReg.setText("");
		
		textFieldNomClase.setVisible(false);
		textFieldFechaIniClase.setVisible(false);
		textFieldHoraInicio.setVisible(false);
		textFieldURL.setVisible(false);
		textFieldFechaReg.setVisible(false);
		
		lblNomClase.setVisible(false);
		lblFechaInicioClase.setVisible(false);
		lblHoraInicio.setVisible(false);
		lblURL.setVisible(false);
		lblFechaReg.setVisible(false);
		lblSocio.setVisible(false);
		
		comboBoxSocio.setVisible(false);
		
		btnCancelar.setVisible(false);
		btnEliminar.setVisible(false);
		
		btnElegirClase.setEnabled(false);
		btnElegirAct.setEnabled(false);
		
		comboBoxClase.setEnabled(false);
		comboBoxActividad.setEnabled(false);
	}
	
	
}
