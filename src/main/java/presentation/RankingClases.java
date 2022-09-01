package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorRankingClases;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class RankingClases extends JInternalFrame {
	
	private IControladorRankingClases iconRankingC;
	private JComboBox<String> comboBoxRankingC;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingClases frame = new RankingClases();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public RankingClases(IControladorRankingClases iconRankingC) {
		
		this.iconRankingC = iconRankingC;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Ranking Clases");
		setBounds(100, 100, 417, 139);
		getContentPane().setLayout(null);
		
		comboBoxRankingC = new JComboBox<String>();
		comboBoxRankingC.setBounds(48, 53, 291, 24);
		getContentPane().add(comboBoxRankingC);
		
		JLabel lblRankingClases = new JLabel("Ranking Clases");
		lblRankingClases.setBounds(127, 12, 132, 15);
		getContentPane().add(lblRankingClases);
		

	}
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> rankingC = new DefaultComboBoxModel<String>(iconRankingC.listarClases());
		comboBoxRankingC.setModel(rankingC);
	}
}
