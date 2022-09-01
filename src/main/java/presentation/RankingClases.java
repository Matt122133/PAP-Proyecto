package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorRankingClases;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		comboBoxRankingC = new JComboBox<String>();
		comboBoxRankingC.setBounds(73, 53, 291, 24);
		getContentPane().add(comboBoxRankingC);
		

	}
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> rankingC = new DefaultComboBoxModel<String>(iconRankingC.listarClases());
		comboBoxRankingC.setModel(rankingC);
	}
}
