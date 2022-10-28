package presentation;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControladorAltaActividadDeportiva;
import interfaces.IControladorAltaDictadoDeClase;
import interfaces.IControladorAltaInstitucionDeportiva;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaAct;
import interfaces.IControladorConsultaClase;
import interfaces.IControladorConsultaUsuario;
import interfaces.IControladorEliminarRegistro;
import interfaces.IControladorModificarActividad;
import interfaces.IControladorModificarInstitucion;
import interfaces.IControladorModificarUsuario;
import interfaces.IControladorRankingActividadDeportiva;
import interfaces.IControladorRankingClases;
import interfaces.IControladorRegistroClase;
import publicadores.ControladorPublishAltaClase;
import publicadores.ControladorPublishConsultaActividad;
import publicadores.ControladorPublishConsultaClase;
import publicadores.ControladorPublishConsultaUsuario;
import publicadores.ControladorPublishLogin;
import publicadores.ControladorPublishModificarUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	
	private AltaUsuario altaUsuarioInternalFrame;
	private AltaInstitucion altaInstitucionInternalFrame;
	private AltaActividad altaActividadInternalFrame;
	private AltaClase altaClaseInternalFrame;
	private ConsultaAD consultaADInternalFrame;
	private ConsultaC consultaCInternalFrame;
	private RegistroSocioClase registroRCInternalFrame;
	private ConsultaUsuario consultaUsuarioInternalFrame;
	private ModificarUsuario modificarUsuarioInternalFrame;
	private ModificarInstitucion modificarInstitucionInternalFrame;
	private RankingClases rankingClasesInternalFrame;
	private RankingActividades rankingActividadesInternalFrame;
	private ModificarActividad modificarActividadInternalFrame;
	private EliminarRegistro eliminarRegistroInternalFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		ControladorPublishLogin cpl = new ControladorPublishLogin();
		ControladorPublishConsultaClase cpcc = new ControladorPublishConsultaClase();
		ControladorPublishConsultaUsuario cpcu = new ControladorPublishConsultaUsuario();
		ControladorPublishAltaClase cpac = new ControladorPublishAltaClase();
		ControladorPublishModificarUsuario cpmu = new ControladorPublishModificarUsuario();
		ControladorPublishConsultaActividad cpca = new ControladorPublishConsultaActividad();
		cpl.publicar();
		cpcc.publicar();
		cpcu.publicar();
		cpac.publicar();
		cpmu.publicar();
		cpca.publicar();

		initialize();
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaUsuario iconAU = fabrica.getIControladorAU();
		IControladorAltaInstitucionDeportiva iconAI = fabrica.getIControladorAI();
		IControladorAltaActividadDeportiva iconAD = fabrica.getIControladorAD();
		IControladorAltaDictadoDeClase iconAC = fabrica.getIControladorAC();
		IControladorConsultaAct iconCA = fabrica.getIControladorCA();
		IControladorConsultaClase iconCC = fabrica.getIControladorCC();
		IControladorRegistroClase iconRC = fabrica.getIControladorRC();
		IControladorConsultaUsuario iconCU = fabrica.getIControladorCU();
		IControladorModificarUsuario iconMU = fabrica.getIControladorMU();
		IControladorModificarInstitucion iconMI = fabrica.getIControladorMI();
		IControladorRankingClases iconRankingC = fabrica.getIControladorRankingC();
		IControladorRankingActividadDeportiva iconRA = fabrica.getIControladorRA();
		IControladorModificarActividad iconMA = fabrica.getIControladorMA();
		IControladorEliminarRegistro iconER = fabrica.getIControladorER();
		
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		altaUsuarioInternalFrame = new AltaUsuario(iconAU);
		jInternalFrameSize = altaUsuarioInternalFrame.getSize();
		altaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(altaUsuarioInternalFrame);
		altaUsuarioInternalFrame.setVisible(false);
		
		altaInstitucionInternalFrame = new AltaInstitucion(iconAI);
		jInternalFrameSize = altaInstitucionInternalFrame.getSize();
		altaInstitucionInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(altaInstitucionInternalFrame);
		altaInstitucionInternalFrame.setVisible(false);
		
		altaActividadInternalFrame = new AltaActividad(iconAD);
		jInternalFrameSize = altaActividadInternalFrame.getSize();
		altaActividadInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(altaActividadInternalFrame);
		altaActividadInternalFrame.setVisible(false);
		
		altaClaseInternalFrame = new AltaClase(iconAC);
		jInternalFrameSize = altaClaseInternalFrame.getSize();
		altaClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(altaClaseInternalFrame);
		altaClaseInternalFrame.setVisible(false);
		
		consultaADInternalFrame = new ConsultaAD(iconCA);
		jInternalFrameSize = consultaADInternalFrame.getSize();
		consultaADInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(consultaADInternalFrame);
		consultaADInternalFrame.setVisible(false);
		
		consultaCInternalFrame = new ConsultaC(iconCC);
		jInternalFrameSize = consultaCInternalFrame.getSize();
		consultaCInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(consultaCInternalFrame);
		consultaCInternalFrame.setVisible(false);
		
		registroRCInternalFrame = new RegistroSocioClase(iconRC);
		jInternalFrameSize = registroRCInternalFrame.getSize();
		registroRCInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(registroRCInternalFrame);
		registroRCInternalFrame.setVisible(false);
		
		consultaUsuarioInternalFrame = new ConsultaUsuario(iconCU);
		jInternalFrameSize = consultaUsuarioInternalFrame.getSize();
		consultaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(consultaUsuarioInternalFrame);
		consultaUsuarioInternalFrame.setVisible(false);
		
		modificarUsuarioInternalFrame = new ModificarUsuario(iconMU);
		jInternalFrameSize = modificarUsuarioInternalFrame.getSize();
		modificarUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(modificarUsuarioInternalFrame);
		modificarUsuarioInternalFrame.setVisible(false);
		
		modificarInstitucionInternalFrame = new ModificarInstitucion(iconMI);
		jInternalFrameSize = modificarInstitucionInternalFrame.getSize();
		modificarInstitucionInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(modificarInstitucionInternalFrame);
		modificarInstitucionInternalFrame.setVisible(false);
		
		rankingClasesInternalFrame = new RankingClases(iconRankingC);
		jInternalFrameSize = rankingClasesInternalFrame.getSize();
		rankingClasesInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(rankingClasesInternalFrame);
		rankingClasesInternalFrame.setVisible(false);
		
		modificarActividadInternalFrame = new ModificarActividad(iconMA);
		jInternalFrameSize = modificarActividadInternalFrame.getSize();
		modificarActividadInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(modificarActividadInternalFrame);
		modificarActividadInternalFrame.setVisible(false);
		
		rankingClasesInternalFrame = new RankingClases(iconRankingC);
		jInternalFrameSize = rankingClasesInternalFrame.getSize();
		rankingClasesInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(rankingClasesInternalFrame);
		rankingClasesInternalFrame.setVisible(false);
		
		rankingActividadesInternalFrame = new RankingActividades(iconRA);
		jInternalFrameSize = rankingActividadesInternalFrame.getSize();
		rankingActividadesInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(rankingActividadesInternalFrame);
		rankingActividadesInternalFrame.setVisible(false);
		
		eliminarRegistroInternalFrame = new EliminarRegistro(iconER);
		jInternalFrameSize = eliminarRegistroInternalFrame.getSize();
		eliminarRegistroInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		frame.getContentPane().add(eliminarRegistroInternalFrame);
		eliminarRegistroInternalFrame.setVisible(false);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAltas = new JMenu("Altas");
		menuBar.add(mnAltas);
		
		JMenuItem mntmUsuarioAlta = new JMenuItem("Usuario");
		mntmUsuarioAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaUsuarioInternalFrame.inicializarComboBoxes();
				altaUsuarioInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmUsuarioAlta);
		
		JMenuItem mntmInstitucionAlta = new JMenuItem("Institucion");
		mntmInstitucionAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaInstitucionInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmInstitucionAlta);
		
		JMenuItem mntmActividadAlta = new JMenuItem("Actividad");
		mntmActividadAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaActividadInternalFrame.inicializarComboBoxes();
				altaActividadInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmActividadAlta);
		
		JMenuItem mntmClaseAlta = new JMenuItem("Clase");
		mntmClaseAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaClaseInternalFrame.iniciarlizarComboBoxes();
				altaClaseInternalFrame.setVisible(true);
			}
		});
		mnAltas.add(mntmClaseAlta);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmUsuarioConsultas = new JMenuItem("Usuario");
		mntmUsuarioConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaUsuarioInternalFrame.inicializarComboBoxes();
				consultaUsuarioInternalFrame.setVisible(true);
			}
		});
		mnConsultas.add(mntmUsuarioConsultas);
		
		JMenuItem mntmActividadConsultas = new JMenuItem("Actividad");
		mntmActividadConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaADInternalFrame.iniciarlizarComboBoxes();
				consultaADInternalFrame.setVisible(true);
				
			}
		});
		mnConsultas.add(mntmActividadConsultas);
		
		JMenuItem mntmClaseConsultas = new JMenuItem("Clase");
		mntmClaseConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaCInternalFrame.iniciarlizarComboBoxes();
				consultaCInternalFrame.setVisible(true);
			}
		});
		mnConsultas.add(mntmClaseConsultas);
		
		JMenu mnModificar = new JMenu("Modificar");
		menuBar.add(mnModificar);
		
		JMenuItem mntmUsuarioModificar = new JMenuItem("Usuario");
		mntmUsuarioModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarUsuarioInternalFrame.iniciarlizarComboBoxes();
				modificarUsuarioInternalFrame.setVisible(true);
			}
		});
		mnModificar.add(mntmUsuarioModificar);
		
		JMenuItem mntmInstitucionModificar = new JMenuItem("Institucion");
		mntmInstitucionModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarInstitucionInternalFrame.inicializarComboBoxes();
				modificarInstitucionInternalFrame.setVisible(true);
			}
		});
		mnModificar.add(mntmInstitucionModificar);
		
		JMenuItem mntmActividadModificar = new JMenuItem("Actividad");
		mntmActividadModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarActividadInternalFrame.inicializarComboBoxes();
				modificarActividadInternalFrame.setVisible(true);
			}
		});
		mnModificar.add(mntmActividadModificar);
		
		JMenu mnRanking = new JMenu("Ranking");
		menuBar.add(mnRanking);
		
		JMenuItem mntmActividadRanking = new JMenuItem("Actividad");
		mntmActividadRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rankingActividadesInternalFrame.setVisible(true);
				rankingActividadesInternalFrame.inicializarComboBoxes();
			}
		});
		mnRanking.add(mntmActividadRanking);
		
		JMenuItem mntmClaseRanking = new JMenuItem("Clase");
		mntmClaseRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rankingClasesInternalFrame.setVisible(true);
				rankingClasesInternalFrame.inicializarComboBoxes();
			}
		});
		mnRanking.add(mntmClaseRanking);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		JMenuItem mntmRegistro = new JMenuItem("Agregar Registro");
		mnRegistro.add(mntmRegistro);
		
		JMenuItem mntmEliminarRegistro = new JMenuItem("Eliminar Registro");
		mntmEliminarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarRegistroInternalFrame.iniciarlizarComboBoxes();
				eliminarRegistroInternalFrame.setVisible(true);
			}
		});
		mnRegistro.add(mntmEliminarRegistro);
		
		mntmRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroRCInternalFrame.iniciarlizarComboBoxes();
				registroRCInternalFrame.setVisible(true);
				
				
			}
		});
	}
}
