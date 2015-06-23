package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AccionsAct extends JFrame {

	private JPanel contentPane;
	//Copia accesible de la ventana para el cerrado de la misma
	private JFrame vAccions;
	private JTextField nomField;
	private JTextField cgnField;
	
	ModelSoci mSoci=new ModelSoci();
	Soci s;

	/**
	 * Metodo constructor
	 */
	public AccionsAct() {
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
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 32, 46, 14);
		contentPane.add(lblNewLabel);
		
		nomField = new JTextField();
		nomField.setEditable(false);
		nomField.setBounds(84, 29, 188, 20);
		contentPane.add(nomField);
		nomField.setColumns(10);
		
		JLabel lblCognom = new JLabel("CogNom");
		lblCognom.setBounds(10, 82, 46, 14);
		contentPane.add(lblCognom);
		
		cgnField = new JTextField();
		cgnField.setEditable(false);
		cgnField.setColumns(10);
		cgnField.setBounds(84, 79, 188, 20);
		contentPane.add(cgnField);
		
		JLabel lblTipus = new JLabel("tipus");
		lblTipus.setBounds(10, 136, 46, 14);
		contentPane.add(lblTipus);
		
		JComboBox tipusCombo = new JComboBox(Soci.TIPUS);
		tipusCombo.setBounds(84, 133, 76, 20);
		contentPane.add(tipusCombo);
		
		// Seleccion del socio
		String numSocio = JOptionPane.showInputDialog(
		   vAccions,
		   "Actualizador",
		   "Introducir el numero de socio");  // el icono sera un iterrogante
		
		s=mSoci.consultaSoci(numSocio);
		
		//Colocamos los datos devueltos
		nomField.setText(s.getNom());
		cgnField.setText(s.getCognom());
		tipusCombo.setSelectedItem(s.getTipusSoci());
		
		JButton btnActualitzar = new JButton("Actualitzar");
		btnActualitzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Guardamos el nuevo dato del socio
				s.setTipusSoci((String)tipusCombo.getSelectedItem());
				mSoci.actualitzaSoci(s);
			}
		});
		btnActualitzar.setBounds(200, 228, 121, 23);
		contentPane.add(btnActualitzar);
	}
}
