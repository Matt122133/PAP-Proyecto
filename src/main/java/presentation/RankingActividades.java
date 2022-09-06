package presentation;



import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorRankingActividadDeportiva;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class RankingActividades extends JInternalFrame {

	private IControladorRankingActividadDeportiva iconRA;
	
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxAD;
	

	/**
	 * Create the frame.
	 */
	public RankingActividades(IControladorRankingActividadDeportiva iconRA) {
		

		this.iconRA = iconRA;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Ranking Actividades");
		setBounds(100, 100, 417, 139);
		getContentPane().setLayout(null);
		
		comboBoxAD = new JComboBox<String>();
		comboBoxAD.setBounds(94, 53, 215, 24);
		getContentPane().add(comboBoxAD);
		
		JLabel lblRankingActividadesDeportivas = new JLabel("Ranking Actividades Deportivas");
		lblRankingActividadesDeportivas.setBounds(84, 12, 234, 15);
		getContentPane().add(lblRankingActividadesDeportivas);

	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> rankingAD = new DefaultComboBoxModel<String>(iconRA.listarActividades());
		comboBoxAD.setModel(rankingAD);
	}

}
