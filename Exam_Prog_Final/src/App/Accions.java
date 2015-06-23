package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Modelo.BD;
import Modelo.ModelSoci;
import Modelo.Soci;

public class Accions extends JFrame {

	private JPanel contentPane;
	//Copia accesible de la ventana para el cerrado de la misma
	private JFrame vAccions;

	/**
	 * Metodo constructor
	 */
	public Accions() {
		setTitle("Accions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Guardamos una copia de la ventaPrincipalna principal
		vAccions=this;
		
		JButton btnNewButton = new JButton("Tornar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal aFrame = new Principal();
				aFrame.setVisible(true);
				vAccions.dispose();
			}
		});
		btnNewButton.setBounds(335, 228, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Consultar impagaments");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 21, 176, 14);
		contentPane.add(lblNewLabel);
		

		//REllenamos la consulta de impagos
		ModelSoci mSoci=new ModelSoci();
		ArrayList<Soci> socis = mSoci.consultaImpagaments();// guardamos el resultado de la consulta
		int desplazamiento=0;
		for (Soci s: socis) {
			JLabel lblEjem = new JLabel(s.getNom()+" "+s.getCognom()+" "+s.getImportQuota());
			lblEjem.setBounds(26, 60+desplazamiento, 176, 14);
			desplazamiento+=15;
			contentPane.add(lblEjem);
		}
		//Plantilla del primer label
		//JLabel lblEjem = new JLabel("New label");
		//lblEjem.setBounds(26, 60, 46, 14);
		//contentPane.add(lblEjem);
	}
}
