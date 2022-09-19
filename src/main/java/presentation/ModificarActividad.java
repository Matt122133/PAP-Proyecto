package presentation;

import javax.swing.JInternalFrame;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import interfaces.IControladorImagenes;
import interfaces.IControladorModificarActividad;

import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import datatypes.DtActividadDeportiva;

import javax.swing.JButton;

public class ModificarActividad extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControladorModificarActividad iconMA;
	private IControladorImagenes iconIM;
	
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JTextField textFieldFechaReg;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JComboBox<String> comboBoxAD;
	private JLabel lblEtiquetaFoto;
	private JLabel lblImagen;
	private JButton btnModifImagen;

	public ModificarActividad(IControladorModificarActividad iconMA, IControladorImagenes iconIM) {
		
		this.iconMA = iconMA;
		this.iconIM = iconIM;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Modificar Actividad");
		setBounds(100, 100, 676, 365);
		getContentPane().setLayout(null);
		
		JLabel lblActividades = new JLabel("Actividades Deportivas");
		lblActividades.setBounds(10, 15, 135, 29);
		getContentPane().add(lblActividades);
		
		JLabel lblNombreAct = new JLabel("Nombre");
		lblNombreAct.setBounds(10, 63, 48, 14);
		getContentPane().add(lblNombreAct);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(56, 60, 106, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(194, 94, 79, 14);
		getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(271, 91, 106, 20);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(10, 94, 48, 14);
		getContentPane().add(lblDuracion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(56, 91, 106, 20);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(20, 125, 38, 14);
		getContentPane().add(lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(56, 122, 106, 20);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblFechaRegistro = new JLabel("Fecha Registro");
		lblFechaRegistro.setBounds(194, 63, 79, 14);
		getContentPane().add(lblFechaRegistro);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setEnabled(false);
		textFieldFechaReg.setEditable(false);
		textFieldFechaReg.setBounds(271, 60, 106, 20);
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
		btnCancelar.setBounds(215, 278, 89, 23);
		getContentPane().add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarActividadActionButton(e);
			}
		});
		btnModificar.setBounds(99, 278, 89, 23);
		getContentPane().add(btnModificar);
		
		comboBoxAD = new JComboBox<String>();
		comboBoxAD.setBounds(152, 17, 121, 24);
		getContentPane().add(comboBoxAD);
		
		lblEtiquetaFoto = new JLabel("Imagen");
		lblEtiquetaFoto.setBounds(496, 15, 48, 14);
		getContentPane().add(lblEtiquetaFoto);
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setFont(new Font("Arial", lblImagen.getFont().getStyle(), lblImagen.getFont().getSize()));
		lblImagen.setBounds(409, 40, 222, 227);
		lblImagen.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(lblImagen);
		
		btnModifImagen = new JButton("Modificar Imagen");
		btnModifImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AbrirImagen(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnModifImagen.setBounds(449, 278, 143, 23);
		getContentPane().add(btnModifImagen);

	}
	
	private void AbrirImagen(ActionEvent e) throws IOException {
        JFileChooser j = new JFileChooser();
        j.setDialogTitle("Buscar Imagen");
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if(estado == 0){
            try{
            	String rutArchivo = j.getSelectedFile().getAbsolutePath();
            	File f = new File(rutArchivo);
            	BufferedImage src = ImageIO.read(f);
            	BufferedImage dest = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_RGB);
            	Graphics2D g = dest.createGraphics();
            	AffineTransform at = AffineTransform.getScaleInstance(src.getWidth()/src.getWidth(), src.getHeight()/src.getHeight());
            	g.drawRenderedImage(src, at);
            	ImageIcon icon = new ImageIcon(rutArchivo);
            	icon = new ImageIcon(dest);
            	lblImagen.setText("");
            	lblImagen.setIcon(new ImageIcon( new ImageIcon(dest).getImage().getScaledInstance(lblImagen.getWidth(),
            					 lblImagen.getHeight(), Image.SCALE_DEFAULT)));
            	icon.getIconHeight();
            	
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, " Error de imagen: " + ex.getMessage());
                }
           
        }        
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
		
		if(dtAct.getImagenAct() != null) {
			if(!dtAct.getImagenAct().equals(null)) {
				this.lblImagen.setText("");
				this.lblImagen.setIcon(new ImageIcon(new ImageIcon(dtAct.getImagenAct()).getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT )));
			}
		}else{
			lblImagen.setIcon(null);
		}
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
			byte[] fotoByte = null;
			byte[] fotoActivModificada = this.resultImagen(fotoByte);
			
			DtActividadDeportiva actualizada = new DtActividadDeportiva(nombre,desc,duracion,costo,fechaReg, fotoActivModificada);
		
			this.iconMA.modificarActDep(actualizada);
			JOptionPane.showMessageDialog(this, "La actividad ha sido modificada con éxito", "Modificar Actividad", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
			limpiarFormulario();
		}
		
	}
	
	private byte[] resultImagen(byte[] fotoByte) {
		if(lblImagen.getIcon() == null) {
			fotoByte = null;
		}else if(lblImagen.getIcon() != null) {
			Image image = iconIM.iconToImage(lblImagen.getIcon());
			fotoByte = iconIM.imageToByte(image);
			
		}
		return fotoByte;
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
		lblImagen.setIcon(null);
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
