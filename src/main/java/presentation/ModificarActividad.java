package presentation;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import interfaces.IControladorModificarActividad;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import datatypes.DtActividadDeportiva;

import javax.swing.JButton;

public class ModificarActividad extends JInternalFrame {
	
	private JComboBox<String> comboBoxActividades;
	private IControladorModificarActividad iconMA;
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JTextField textFieldFechaReg;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JButton btnModificar;

	public ModificarActividad(IControladorModificarActividad iconMA) {
		this.iconMA = iconMA;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Modificar Actividad");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		comboBoxActividades = new JComboBox<String>();
		comboBoxActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarComboBoxes();
			}
		});
		comboBoxActividades.setBounds(138, 18, 135, 22);
		getContentPane().add(comboBoxActividades);
		
		JLabel lblActividades = new JLabel("Actividades Deportivas");
		lblActividades.setBounds(10, 15, 135, 29);
		getContentPane().add(lblActividades);
		
		JLabel lblNombreAct = new JLabel("Nombre");
		lblNombreAct.setBounds(10, 54, 48, 14);
		getContentPane().add(lblNombreAct);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(56, 51, 106, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(194, 79, 79, 14);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(271, 76, 106, 20);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(10, 79, 48, 14);
		getContentPane().add(lblDuracion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(56, 76, 106, 20);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(20, 110, 38, 14);
		getContentPane().add(lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(56, 107, 106, 20);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fecha Registro");
		lblNewLabel.setBounds(194, 54, 79, 14);
		getContentPane().add(lblNewLabel);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setEnabled(false);
		textFieldFechaReg.setEditable(false);
		textFieldFechaReg.setBounds(271, 51, 106, 20);
		getContentPane().add(textFieldFechaReg);
		textFieldFechaReg.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarActividad(e);
			}
		});
		btnConfirmar.setBounds(288, 18, 89, 23);
		getContentPane().add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(194, 199, 89, 23);
		getContentPane().add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarActividadActionButton(e);
			}
		});
		btnModificar.setBounds(95, 199, 89, 23);
		getContentPane().add(btnModificar);

	}
	
	public void inicializarComboBoxes(){
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(iconMA.listarActividades());
		comboBoxActividades.setModel(modelactividades);
	}
	
	public void llenarActividad(ActionEvent e) {
		String nombre = this.comboBoxActividades.getSelectedItem().toString();
		DtActividadDeportiva dtAct = this.iconMA.obtenerDtActividad(nombre);
		textFieldNombre.setText(dtAct.getNombre());
		textFieldDescripcion.setText(dtAct.getDescripcion());
		textFieldDuracion.setText(dtAct.getDuracion().toString());
		textFieldCosto.setText(dtAct.getCosto().toString());
		Integer day = dtAct.getFechaReg().get(Calendar.DAY_OF_MONTH);
		Integer month = dtAct.getFechaReg().get(Calendar.MONTH)+1;
		Integer year = dtAct.getFechaReg().get(Calendar.YEAR);
		this.textFieldFechaReg.setText(day.toString()+ "/"+ month.toString()+"/"+ year.toString());
	}
	
	public void modificarActividadActionButton(ActionEvent e){
		String nombre = this.comboBoxActividades.getSelectedItem().toString();
		String desc = this.textFieldDescripcion.getText();
		String duracionString = this.textFieldDuracion.getText();
		int duracion = Integer.parseInt(duracionString);
		String costoString = this.textFieldCosto.getText();
		float costo = Float.parseFloat(costoString);
		Calendar fechaReg = Calendar.getInstance();
		DtActividadDeportiva actualizada = new DtActividadDeportiva(nombre,desc,duracion,costo,fechaReg);
		this.iconMA.modificarActDep(actualizada);
		JOptionPane.showMessageDialog(this, "La actividad ha sido modificada con éxito", "Modificar Actividad", JOptionPane.INFORMATION_MESSAGE);
		this.setVisible(false);
		limpiarFormulario();
		
		
	}
	
	private void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldFechaReg.setText("");
		textFieldDescripcion.setText("");
		textFieldDuracion.setText("");
		textFieldCosto.setText("");
	}
}
