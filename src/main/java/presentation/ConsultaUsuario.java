package presentation;


import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorConsultaUsuario;
import logic.Profesor;
import logic.Socio;
import logic.Usuario;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class ConsultaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorConsultaUsuario iconCU;
	private JTextField textFieldNombre;
	private JTextField textFieldNickname;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldFechaNac;
	private JTextField textFieldActDep;
	private JTextField textFieldNombreClase;
	private JTextField textFieldFechaAltaClase;
	private JTextField textFieldFechaClase;
	private JTextField textFieldHoraInicioClase;
	private JTextField textFieldURLClase;
	private final JInternalFrame internalFrameClase = new JInternalFrame("Info de Clase");
	private JLabel lblNickname;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblEmail;
	private JLabel lblFechanac;
	private JButton btnVerInfoActividad;
	private JComboBox<String> comboBoxUsuario;
	private JComboBox<String> comboBoxClases;
	private JLabel lblDescripcion;
	private JTextField textFieldDescripcion;
	private JLabel lblBiografia;
	private JLabel lblSitioWeb;
	private JTextField textFieldBiografia;
	private JTextField textFieldSitioWeb;

	/**
	 * Create the frame.
	 */
	public ConsultaUsuario(IControladorConsultaUsuario iconCU) {
		this.iconCU=iconCU;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta Usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		internalFrameClase.setResizable(true);
		internalFrameClase.setIconifiable(true);
        internalFrameClase.setMaximizable(true);
        internalFrameClase.setClosable(true);
		internalFrameClase.setBounds(0, 7, 440, 244);
		getContentPane().add(internalFrameClase);
		internalFrameClase.getContentPane().setLayout(null);
		
		textFieldActDep = new JTextField();
		textFieldActDep.setBounds(129, 143, 114, 19);
		internalFrameClase.getContentPane().add(textFieldActDep);
		textFieldActDep.setColumns(10);
		
		JLabel lblActividadDep = new JLabel("Actividad Dep");
		lblActividadDep.setBounds(14, 145, 101, 15);
		internalFrameClase.getContentPane().add(lblActividadDep);
		
		textFieldNombreClase = new JTextField();
		textFieldNombreClase.setBounds(24, 44, 114, 19);
		internalFrameClase.getContentPane().add(textFieldNombreClase);
		textFieldNombreClase.setColumns(10);
		
		JLabel lblNombreClase = new JLabel("Nombre");
		lblNombreClase.setBounds(53, 30, 55, 15);
		internalFrameClase.getContentPane().add(lblNombreClase);
		
		textFieldFechaAltaClase = new JTextField();
		textFieldFechaAltaClase.setBounds(158, 44, 114, 19);
		internalFrameClase.getContentPane().add(textFieldFechaAltaClase);
		textFieldFechaAltaClase.setColumns(10);
		
		JLabel lblFechaReg = new JLabel("FechaReg");
		lblFechaReg.setBounds(177, 30, 70, 15);
		internalFrameClase.getContentPane().add(lblFechaReg);
		
		textFieldFechaClase = new JTextField();
		textFieldFechaClase.setBounds(292, 44, 114, 19);
		internalFrameClase.getContentPane().add(textFieldFechaClase);
		textFieldFechaClase.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("FechaInicio");
		lblFechaInicio.setBounds(303, 28, 92, 15);
		internalFrameClase.getContentPane().add(lblFechaInicio);
		
		JLabel lblHorainicio = new JLabel("HoraInicio");
		lblHorainicio.setBounds(95, 68, 84, 15);
		internalFrameClase.getContentPane().add(lblHorainicio);
		
		textFieldHoraInicioClase = new JTextField();
		textFieldHoraInicioClase.setBounds(70, 84, 114, 19);
		internalFrameClase.getContentPane().add(textFieldHoraInicioClase);
		textFieldHoraInicioClase.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(293, 68, 47, 15);
		internalFrameClase.getContentPane().add(lblUrl);
		
		textFieldURLClase = new JTextField();
		textFieldURLClase.setBounds(254, 84, 114, 19);
		internalFrameClase.getContentPane().add(textFieldURLClase);
		textFieldURLClase.setColumns(10);
		
		btnVerInfoActividad = new JButton("Ver Info Actividad");
		btnVerInfoActividad.setBounds(257, 140, 157, 25);
		internalFrameClase.getContentPane().add(btnVerInfoActividad);
		internalFrameClase.setVisible(true);
		
		internalFrameClase.setVisible(false);
		
		comboBoxUsuario = new JComboBox<String>();
		comboBoxUsuario.setBounds(111, 12, 110, 24);
		getContentPane().add(comboBoxUsuario);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setBounds(24, 17, 70, 15);
		getContentPane().add(lblUsuarios);
		
		JButton btnVerInfoUsuario = new JButton("Ver info");
		btnVerInfoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarInfoActionPerformed(e);
			}
		});
		btnVerInfoUsuario.setBounds(238, 12, 117, 25);
		getContentPane().add(btnVerInfoUsuario);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(159, 76, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(24, 110, 114, 19);
		getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(46, 89, 70, 15);
		getContentPane().add(lblNickname);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(181, 49, 70, 15);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(181, 107, 70, 15);
		getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(159, 137, 114, 19);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(328, 49, 70, 15);
		getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(306, 76, 114, 19);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(306, 137, 114, 19);
		getContentPane().add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		lblFechanac = new JLabel("FechaNac");
		lblFechanac.setBounds(328, 107, 70, 15);
		getContentPane().add(lblFechanac);
		
		JLabel lblClases = new JLabel("Clases");
		lblClases.setBounds(77, 236, 47, 15);
		getContentPane().add(lblClases);
		
		comboBoxClases = new JComboBox<String>();
		comboBoxClases.setBounds(132, 231, 92, 24);
		getContentPane().add(comboBoxClases);
		
		JButton btnVerInfoClases = new JButton("Ver Info");
		btnVerInfoClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirInternalFrame(e);
			}
		});
		btnVerInfoClases.setBounds(232, 231, 117, 25);
		getContentPane().add(btnVerInfoClases);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(35, 170, 92, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(24, 197, 114, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		lblBiografia = new JLabel("Biografia");
		lblBiografia.setBounds(181, 170, 70, 15);
		getContentPane().add(lblBiografia);
		
		lblSitioWeb = new JLabel("Sitio Web");
		lblSitioWeb.setBounds(328, 170, 70, 15);
		getContentPane().add(lblSitioWeb);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setBounds(159, 197, 114, 19);
		getContentPane().add(textFieldBiografia);
		textFieldBiografia.setColumns(10);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(306, 197, 114, 19);
		getContentPane().add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		
		lblDescripcion.setVisible(false);
		lblBiografia.setVisible(false);
		lblSitioWeb.setVisible(false);
		textFieldDescripcion.setVisible(false);
		textFieldBiografia.setVisible(false);
		textFieldSitioWeb.setVisible(false);
	}
	

	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconCU.listarUsuarios());
		comboBoxUsuario.setModel(modelinstituciones);
	}
	
	public void inicializarComboBoxClase(ActionEvent e, String nickname) {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconCU.buscarClases(nickname));
		comboBoxClases.setModel(modelinstituciones);
	
	}
	
	public void inicializarComboBoxClaseSocio(ActionEvent e,String nickname){
		
	}
	
	public void llenarInfoActionPerformed(ActionEvent e) {
		String nickname = this.comboBoxUsuario.getSelectedItem().toString();
		DtUsuario usuario_ret = iconCU.obtenerUserDt(nickname);
		
		this.textFieldNickname.setText(usuario_ret.getNickname());
		this.textFieldNombre.setText(usuario_ret.getNombre());
		this.textFieldApellido.setText(usuario_ret.getApellido());
		this.textFieldEmail.setText(usuario_ret.getEmail());
		Integer day = usuario_ret.getFechaNac().get(Calendar.DAY_OF_MONTH);
		Integer month = usuario_ret.getFechaNac().get(Calendar.MONTH)+1;
		Integer year = usuario_ret.getFechaNac().get(Calendar.YEAR);
		this.textFieldFechaNac.setText(day.toString()+ "/"+ month.toString()+"/"+ year.toString());
		
		if(usuario_ret instanceof DtProfesor) {
			lblDescripcion.setVisible(true);
			lblBiografia.setVisible(true);
			lblSitioWeb.setVisible(true);
			textFieldDescripcion.setVisible(true);
			textFieldBiografia.setVisible(true);
			textFieldSitioWeb.setVisible(true);
			
			this.textFieldDescripcion.setText(((DtProfesor) usuario_ret).getDescripcion());
			this.textFieldBiografia.setText(((DtProfesor) usuario_ret).getBiografia());
			this.textFieldSitioWeb.setText(((DtProfesor) usuario_ret).getSitioWeb());
			
			inicializarComboBoxClase(e,nickname);
			
		}else if(usuario_ret instanceof DtSocio) {
			lblDescripcion.setVisible(false);
			lblBiografia.setVisible(false);
			lblSitioWeb.setVisible(false);
			textFieldDescripcion.setVisible(false);
			textFieldBiografia.setVisible(false);
			textFieldSitioWeb.setVisible(false);
			
			inicializarComboBoxClase(e,nickname);

		}
	}
	
	public void abrirInternalFrame(ActionEvent e){
		internalFrameClase.setVisible(true);
		String nickname = this.comboBoxUsuario.getSelectedItem().toString();
		Usuario usuario_ret = iconCU.obtenerUsuario(nickname);
		String nombreClase = this.comboBoxClases.getSelectedItem().toString();
		
		if(usuario_ret instanceof Profesor) {
			
			DtClase clase =  iconCU.obtenerDtClasePorUsuario(nickname, nombreClase);	
			this.textFieldNombreClase.setText(clase.getNombre());
			
			Integer day = clase.getFechaReg().get(Calendar.DAY_OF_MONTH);
			Integer month = clase.getFechaReg().get(Calendar.MONTH)+1;
			Integer year = clase.getFechaReg().get(Calendar.YEAR);
			this.textFieldFechaAltaClase.setText(day.toString()+ "/"+ month.toString()+"/"+ year.toString());
			
			Integer day1 = clase.getFecha().get(Calendar.DAY_OF_MONTH);
			Integer month1 = clase.getFecha().get(Calendar.MONTH)+1;
			Integer year1 = clase.getFecha().get(Calendar.YEAR);
			this.textFieldFechaClase.setText(day1.toString()+ "/"+ month1.toString()+"/"+ year1.toString());
			this.textFieldHoraInicioClase.setText(clase.getHoraInicio().toString());
			this.textFieldURLClase.setText(clase.getUrl());
			this.textFieldActDep.setText(iconCU.ActDepDeClase(nombreClase));
			
		}else if(usuario_ret instanceof Socio) {
			
			DtClase clase =  iconCU.obtenerDtClasePorUsuario(nickname, nombreClase);
			this.textFieldNombreClase.setText(clase.getNombre());
			Integer day = clase.getFechaReg().get(Calendar.DAY_OF_MONTH);
			Integer month = clase.getFechaReg().get(Calendar.MONTH)+1;
			Integer year = clase.getFechaReg().get(Calendar.YEAR);
			this.textFieldFechaAltaClase.setText(day.toString()+ "/"+ month.toString()+"/"+ year.toString());
			
			Integer day1 = clase.getFecha().get(Calendar.DAY_OF_MONTH);
			Integer month1 = clase.getFecha().get(Calendar.MONTH)+1;
			Integer year1 = clase.getFecha().get(Calendar.YEAR);
			this.textFieldFechaClase.setText(day1.toString()+ "/"+ month1.toString()+"/"+ year1.toString());
			this.textFieldHoraInicioClase.setText(clase.getHoraInicio().toString());
			this.textFieldURLClase.setText(clase.getUrl());
			this.textFieldActDep.setText(iconCU.ActDepDeClase(nombreClase));
		}
		

				
	}

	
	/*public void limpiarFormulario(){
		textFieldNickname.setText(" ");
		textFieldNombre.setText(" ");
		textFieldApellido.setText(" ");
		textFieldEmail.setText(" ");
		textFieldFechaNac.setText(" ");
		textFieldDescripcion.setText(" ");
		textFieldBiografia.setText(" ");
		textFieldSitioWeb.setText(" ");
	}*/
}
