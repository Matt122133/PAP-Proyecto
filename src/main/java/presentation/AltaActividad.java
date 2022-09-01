package presentation;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaActividadDeportiva;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import exceptions.ActividadRepetidaException;
import exceptions.UsuarioRepetidoException;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AltaActividad extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorAltaActividadDeportiva iconAA;
	private JTextField textFieldNombre;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JComboBox<String> comboBoxInstitucion;
	private JTextField textFieldDescripcion;
	
	/**
	 * Create the frame.
	 */
	public AltaActividad(IControladorAltaActividadDeportiva iconAA) {
		
		this.iconAA=iconAA;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Actividad");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Institucion: ");
		lblInstitucion.setBounds(12, 12, 84, 15);
		getContentPane().add(lblInstitucion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaActividadAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(68, 231, 117, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaActividadCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(253, 231, 117, 25);
		getContentPane().add(btnCancelar);
		
		comboBoxInstitucion = new JComboBox();
		comboBoxInstitucion.setBounds(12, 39, 139, 24);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(12, 70, 64, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(12, 92, 114, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(12, 118, 70, 15);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo: ");
		lblCosto.setBounds(12, 166, 50, 15);
		getContentPane().add(lblCosto);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(12, 140, 114, 19);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(12, 188, 114, 19);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(177, 12, 93, 15);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(175, 39, 253, 19);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);

	}
	
	public void altaActividadAceptarActionPerformed(ActionEvent e) {
		if (checkFormulario()) {
			String nombre = this.textFieldNombre.getText();
			String descripcion = this.textFieldDescripcion.getText();
			String costoString = this.textFieldCosto.getText();
			float costo = Float.parseFloat(costoString);
			String duracionString = this.textFieldDuracion.getText();
			int duracion = Integer.parseInt(duracionString);
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			Calendar fechaReg = Calendar.getInstance();
		
			try {
				this.iconAA.altaActividadDeportiva(institucion, nombre, descripcion, duracion, costo, fechaReg);
				JOptionPane.showMessageDialog(this, "La actividad deportiva ha sido dado de alta con éxito", "Alta Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
			}catch (ActividadRepetidaException p) {
				JOptionPane.showMessageDialog(this, p.getMessage(), "Alta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
				}

			limpiarFormulario();
			setVisible(false);
        
		}
	}

	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(iconAA.listarInstituciones());
		comboBoxInstitucion.setModel(modelinstituciones);
	}
	
	public void altaActividadCancelarActionPerformed(ActionEvent e){
		limpiarFormulario();
		setVisible(false);
	}
	
	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldDuracion.setText("");
		textFieldCosto.setText("");
		textFieldDescripcion.setText("");
	}
	
	private boolean checkFormulario() {
        String nombre = this.textFieldNombre.getText();
        String descripcion = this.textFieldDescripcion.getText();
        String duracion = this.textFieldDuracion.getText();
        String costo = this.textFieldCosto.getText();
        if (nombre.isEmpty() || descripcion.isEmpty() || duracion.isEmpty() || costo.isEmpty()) {
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
