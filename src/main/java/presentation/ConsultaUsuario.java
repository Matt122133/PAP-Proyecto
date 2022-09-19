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

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
	private JLabel lblNombreAct;
	private JLabel lblDuracionAct;
	private JLabel lblCosto;
	private JLabel lblDescActiv;
	private JLabel lblFechaRegisAct;
	private JTextField textFieldDescAct;
	private JTextField textFieldNomAct;
	private JTextField textFieldDurAct;
	private JTextField textFieldCostoAct;
	private JTextField textFieldFechaRegAct;
	private JButton btnVerInfoClases;
	private JLabel lblClases;

	/**
	 * Create the frame.
	 */
	public ConsultaUsuario(IControladorConsultaUsuario iconCU) {
		this.iconCU=iconCU;
		
		setBounds(100, 100, 551, 378);
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
		internalFrameClase.setBounds(0, 0, 440, 244);
		getContentPane().add(internalFrameClase);
		internalFrameClase.getContentPane().setLayout(null);
		
		textFieldActDep = new JTextField();
		textFieldActDep.setBounds(106, 105, 114, 19);
		internalFrameClase.getContentPane().add(textFieldActDep);
		textFieldActDep.setColumns(10);
		
		JLabel lblActividadDep = new JLabel("Actividad Deportiva");
		lblActividadDep.setBounds(10, 108, 127, 15);
		internalFrameClase.getContentPane().add(lblActividadDep);
		
		textFieldNombreClase = new JTextField();
		textFieldNombreClase.setBounds(10, 30, 114, 19);
		internalFrameClase.getContentPane().add(textFieldNombreClase);
		textFieldNombreClase.setColumns(10);
		
		JLabel lblNombreClase = new JLabel("Nombre");
		lblNombreClase.setBounds(10, 14, 55, 15);
		internalFrameClase.getContentPane().add(lblNombreClase);
		
		textFieldFechaAltaClase = new JTextField();
		textFieldFechaAltaClase.setBounds(144, 30, 114, 19);
		internalFrameClase.getContentPane().add(textFieldFechaAltaClase);
		textFieldFechaAltaClase.setColumns(10);
		
		JLabel lblFechaReg = new JLabel("Fecha Registro");
		lblFechaReg.setBounds(144, 14, 114, 15);
		internalFrameClase.getContentPane().add(lblFechaReg);
		
		textFieldFechaClase = new JTextField();
		textFieldFechaClase.setBounds(279, 30, 114, 19);
		internalFrameClase.getContentPane().add(textFieldFechaClase);
		textFieldFechaClase.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("FechaInicio");
		lblFechaInicio.setBounds(279, 14, 114, 15);
		internalFrameClase.getContentPane().add(lblFechaInicio);
		
		JLabel lblHorainicio = new JLabel("HoraInicio");
		lblHorainicio.setBounds(76, 56, 85, 15);
		internalFrameClase.getContentPane().add(lblHorainicio);
		
		textFieldHoraInicioClase = new JTextField();
		textFieldHoraInicioClase.setBounds(76, 72, 114, 19);
		internalFrameClase.getContentPane().add(textFieldHoraInicioClase);
		textFieldHoraInicioClase.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(266, 56, 28, 15);
		internalFrameClase.getContentPane().add(lblUrl);
		
		textFieldURLClase = new JTextField();
		textFieldURLClase.setBounds(223, 72, 114, 19);
		internalFrameClase.getContentPane().add(textFieldURLClase);
		textFieldURLClase.setColumns(10);
		
		btnVerInfoActividad = new JButton("Ver Info Actividad");
		btnVerInfoActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarInfoActividad(e);
				lblNombreAct.setVisible(true);
				lblDuracionAct.setVisible(true);
				lblCosto.setVisible(true);
				lblDescActiv.setVisible(true);
				lblFechaRegisAct.setVisible(true);
				
				textFieldNomAct.setVisible(true);
				textFieldCostoAct.setVisible(true);
				textFieldDescAct.setVisible(true);
				textFieldDurAct.setVisible(true);
				textFieldFechaRegAct.setVisible(true);
				
				textFieldNomAct.setEnabled(false);
				textFieldCostoAct.setEnabled(false);
				textFieldDescAct.setEnabled(false);
				textFieldDurAct.setEnabled(false);
				textFieldFechaRegAct.setEnabled(false);
			}
		});
		btnVerInfoActividad.setBounds(233, 103, 157, 25);
		internalFrameClase.getContentPane().add(btnVerInfoActividad);
		
		lblNombreAct = new JLabel("Nombre");
		lblNombreAct.setBounds(10, 137, 79, 15);
		internalFrameClase.getContentPane().add(lblNombreAct);
		
		lblDuracionAct = new JLabel("Duracion");
		lblDuracionAct.setBounds(10, 186, 79, 15);
		internalFrameClase.getContentPane().add(lblDuracionAct);
		
		lblCosto = new JLabel("Costo");
		lblCosto.setBounds(257, 142, 41, 15);
		internalFrameClase.getContentPane().add(lblCosto);
		
		lblDescActiv = new JLabel("Descripcion");
		lblDescActiv.setBounds(10, 161, 114, 15);
		internalFrameClase.getContentPane().add(lblDescActiv);
		
		textFieldDescAct = new JTextField();
		textFieldDescAct.setBounds(94, 159, 96, 20);
		internalFrameClase.getContentPane().add(textFieldDescAct);
		textFieldDescAct.setColumns(10);
		
		textFieldNomAct = new JTextField();
		textFieldNomAct.setBounds(94, 136, 96, 20);
		internalFrameClase.getContentPane().add(textFieldNomAct);
		textFieldNomAct.setColumns(10);
		
		textFieldDurAct = new JTextField();
		textFieldDurAct.setBounds(94, 184, 96, 20);
		internalFrameClase.getContentPane().add(textFieldDurAct);
		textFieldDurAct.setColumns(10);
		
		textFieldCostoAct = new JTextField();
		textFieldCostoAct.setBounds(316, 140, 96, 20);
		internalFrameClase.getContentPane().add(textFieldCostoAct);
		textFieldCostoAct.setColumns(10);
		
		lblFechaRegisAct = new JLabel("Fecha Registro ");
		lblFechaRegisAct.setBounds(193, 168, 120, 14);
		internalFrameClase.getContentPane().add(lblFechaRegisAct);
		
		textFieldFechaRegAct = new JTextField();
		textFieldFechaRegAct.setBounds(316, 166, 96, 20);
		internalFrameClase.getContentPane().add(textFieldFechaRegAct);
		textFieldFechaRegAct.setColumns(10);
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
				textFieldNombre.setEnabled(false);;
				textFieldNickname.setEnabled(false);
				textFieldApellido.setEnabled(false);
				textFieldEmail.setEnabled(false);
				textFieldFechaNac.setEnabled(false);
				
				comboBoxClases.setVisible(true);
				btnVerInfoClases.setVisible(true);
				lblClases.setVisible(true);
				
			}
		});
		btnVerInfoUsuario.setBounds(238, 12, 117, 25);
		getContentPane().add(btnVerInfoUsuario);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(147, 64, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(23, 64, 114, 19);
		getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(23, 49, 93, 15);
		getContentPane().add(lblNickname);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(146, 49, 78, 15);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(271, 48, 77, 15);
		getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(271, 64, 114, 19);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(93, 94, 71, 15);
		getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(93, 109, 114, 19);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(216, 109, 114, 19);
		getContentPane().add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		lblFechanac = new JLabel("Fecha Nacimiento");
		lblFechanac.setBounds(216, 94, 139, 15);
		getContentPane().add(lblFechanac);
		
		lblClases = new JLabel("Clases");
		lblClases.setBounds(39, 225, 59, 15);
		getContentPane().add(lblClases);
		
		comboBoxClases = new JComboBox<String>();
		comboBoxClases.setBounds(102, 220, 137, 24);
		getContentPane().add(comboBoxClases);
		
		btnVerInfoClases = new JButton("Ver Info");
		btnVerInfoClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirInternalFrame(e);
				lblNombreAct.setVisible(false);
				lblDuracionAct.setVisible(false);
				lblCosto.setVisible(false);
				lblDescActiv.setVisible(false);
				lblFechaRegisAct.setVisible(false);
				
				
				textFieldNomAct.setVisible(false);
				textFieldCostoAct.setVisible(false);
				textFieldDescAct.setVisible(false);
				textFieldDurAct.setVisible(false);
				textFieldFechaRegAct.setVisible(false);
				
				textFieldActDep.setEnabled(false);
				textFieldNombreClase.setEnabled(false);
				textFieldFechaAltaClase.setEnabled(false);
				textFieldFechaClase.setEnabled(false);
				textFieldHoraInicioClase.setEnabled(false);
				textFieldURLClase.setEnabled(false);
				
			}
		});
		btnVerInfoClases.setBounds(247, 220, 117, 25);
		getContentPane().add(btnVerInfoClases);
		
		lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(10, 139, 91, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(10, 154, 117, 45);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		lblBiografia = new JLabel("Biografía");
		lblBiografia.setBounds(147, 139, 88, 15);
		getContentPane().add(lblBiografia);
		
		lblSitioWeb = new JLabel("Sitio Web");
		lblSitioWeb.setBounds(289, 139, 78, 15);
		getContentPane().add(lblSitioWeb);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setBounds(147, 153, 117, 45);
		getContentPane().add(textFieldBiografia);
		textFieldBiografia.setColumns(10);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(285, 153, 117, 45);
		getContentPane().add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		
		btnVerInfoClases.setVisible(false);
		
		comboBoxClases.setVisible(false);
		
		lblDescripcion.setVisible(false);
		lblBiografia.setVisible(false);
		lblSitioWeb.setVisible(false);
		lblClases.setVisible(false);
		
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
			textFieldDescripcion.setEnabled(false);
			textFieldBiografia.setEnabled(false);
			textFieldSitioWeb.setEnabled(false);
			
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
	
	public void llenarInfoActividad(ActionEvent e){
		String nomClase = this.textFieldNombreClase.getText();
		String nomAct = this.textFieldActDep.getText();
		DtActividadDeportiva actDep = iconCU.obtenerDtAct(nomClase, nomAct);
		this.textFieldNomAct.setText(actDep.getNombre());
		this.textFieldCostoAct.setText(actDep.getCosto().toString());
		this.textFieldDescAct.setText(actDep.getDescripcion());
		this.textFieldDurAct.setText(actDep.getDuracion().toString());
		Integer day = actDep.getFechaReg().get(Calendar.DAY_OF_MONTH);
		Integer month = actDep.getFechaReg().get(Calendar.MONTH)+1;
		Integer year = actDep.getFechaReg().get(Calendar.YEAR);
		this.textFieldFechaRegAct.setText(day.toString()+ "/"+ month.toString()+"/"+ year.toString());
		
		
	}
	public Font getTextFieldNomActFont() {
		return textFieldNomAct.getFont();
	}
	public void setTextFieldNomActFont(Font font) {
		textFieldNomAct.setFont(font);
	}
}
