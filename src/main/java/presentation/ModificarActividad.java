package presentation;

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
	
	private static final long serialVersionUID = 1L;
	
	private IControladorModificarActividad iconMA;
	
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JTextField textFieldFechaReg;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JComboBox<String> comboBoxAD;
	private JLabel lblImagenURL;
	private JTextField textFieldImagenURL;

	public ModificarActividad(IControladorModificarActividad iconMA) {
		
		this.iconMA = iconMA;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Modificar Actividad");
		setBounds(100, 100, 443, 231);
		getContentPane().setLayout(null);
		
		JLabel lblActividades = new JLabel("Actividades Deportivas");
		lblActividades.setBounds(10, 15, 135, 29);
		getContentPane().add(lblActividades);
		
		JLabel lblNombreAct = new JLabel("Nombre");
		lblNombreAct.setBounds(10, 63, 58, 14);
		getContentPane().add(lblNombreAct);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(68, 57, 106, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(194, 94, 79, 14);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(286, 91, 106, 20);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(10, 94, 58, 14);
		getContentPane().add(lblDuracion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(68, 88, 106, 20);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(20, 125, 38, 14);
		getContentPane().add(lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(68, 119, 106, 20);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblFechaRegistro = new JLabel("Fecha Registro");
		lblFechaRegistro.setBounds(194, 63, 95, 14);
		getContentPane().add(lblFechaRegistro);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setEnabled(false);
		textFieldFechaReg.setEditable(false);
		textFieldFechaReg.setBounds(286, 60, 106, 20);
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
		btnCancelar.setBounds(215, 166, 89, 23);
		getContentPane().add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarActividadActionButton(e);
			}
		});
		btnModificar.setBounds(89, 166, 89, 23);
		getContentPane().add(btnModificar);
		
		comboBoxAD = new JComboBox<String>();
		comboBoxAD.setBounds(152, 17, 121, 24);
		getContentPane().add(comboBoxAD);
		
		lblImagenURL = new JLabel("Imagen URL");
		lblImagenURL.setBounds(194, 125, 79, 14);
		getContentPane().add(lblImagenURL);
		
		textFieldImagenURL = new JTextField();
		textFieldImagenURL.setBounds(286, 122, 106, 20);
		getContentPane().add(textFieldImagenURL);
		textFieldImagenURL.setColumns(10);

	}
	
	
	public void llenarActividad(ActionEvent e) {
		String nombre = this.comboBoxAD.getSelectedItem().toString();
		DtActividadDeportiva dtAct = this.iconMA.obtenerDtActividad(nombre);
		textFieldNombre.setText(dtAct.getNombre());
		textFieldDescripcion.setText(dtAct.getDescripcion());
		textFieldDuracion.setText(dtAct.getDuracion().toString());
		textFieldCosto.setText(dtAct.getCosto().toString());
		Integer day = dtAct.getFechaReg().get(Calendar.DAY_OF_MONTH);
		Integer month = dtAct.getFechaReg().get(Calendar.MONTH)+1;
		Integer year = dtAct.getFechaReg().get(Calendar.YEAR);
		this.textFieldFechaReg.setText(day.toString()+ "/"+ month.toString()+"/"+ year.toString());
		this.textFieldImagenURL.setText(dtAct.getImagenActURL());
	}
	
	public void modificarActividadActionButton(ActionEvent e){
		
		if(checkFormulario()){
			
			String nombre = this.comboBoxAD.getSelectedItem().toString();
			String desc = this.textFieldDescripcion.getText();
			String duracionString = this.textFieldDuracion.getText();
			int duracion = Integer.parseInt(duracionString);
			String costoString = this.textFieldCosto.getText();
			float costo = Float.parseFloat(costoString);
			Calendar fechaReg = Calendar.getInstance();
			String imagenURL = this.textFieldImagenURL.getText();
			
			DtActividadDeportiva actualizada = new DtActividadDeportiva(nombre,desc,duracion,costo,fechaReg, imagenURL);
		
			this.iconMA.modificarActDep(actualizada);
			JOptionPane.showMessageDialog(this, "La actividad ha sido modificada con éxito", "Modificar Actividad", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
			limpiarFormulario();
		}
		
	}
	

	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> rankingAD = new DefaultComboBoxModel<String>(iconMA.listarActividades());
		comboBoxAD.setModel(rankingAD);
	}
	
	private void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldFechaReg.setText("");
		textFieldDescripcion.setText("");
		textFieldDuracion.setText("");
		textFieldCosto.setText("");
		textFieldImagenURL.setText("");
	}
	
	private boolean checkFormulario() {
        String descripcion = this.textFieldDescripcion.getText();
        String duracion = this.textFieldDuracion.getText();
        String costo = this.textFieldCosto.getText();
        if (descripcion.isEmpty() || duracion.isEmpty() || costo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(duracion);
			Float.parseFloat(costo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Duracion y costo deben ser un numero", "Alta Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
