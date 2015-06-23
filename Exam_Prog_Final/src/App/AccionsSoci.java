package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import Modelo.Soci;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccionsSoci extends JFrame {

	private JPanel contentPane;
	private JTextField nomField;
	private JLabel lblCognom;
	private JTextField cogField;
	private JTextField txtLocalitat;
	private JTextField txtCogNom;
	private JTextField txtLocalitat_1;
	private JButton button;
	
	//Copia accesible de la ventana para el cerrado de la misma
	private JFrame vAccionsSoci;

	/*
	 * Metodo constructor
	 */
	public AccionsSoci() {
		setTitle("Busqueda Socio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 10, 58, 14);
		contentPane.add(lblNom);
		
		nomField = new JTextField();
		nomField.setBounds(10, 30, 178, 20);
		contentPane.add(nomField);
		nomField.setColumns(10);
		
		lblCognom = new JLabel("CogNom");
		lblCognom.setBounds(242, 10, 58, 14);
		contentPane.add(lblCognom);
		
		cogField = new JTextField();
		cogField.setColumns(10);
		cogField.setBounds(242, 30, 178, 20);
		contentPane.add(cogField);
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.setBounds(10, 61, 89, 23);
		contentPane.add(btnNewButton);
		
		txtLocalitat = new JTextField();
		txtLocalitat.setText("Nom");
		txtLocalitat.setEditable(false);
		txtLocalitat.setColumns(10);
		txtLocalitat.setBounds(10, 108, 178, 20);
		contentPane.add(txtLocalitat);
		
		txtCogNom = new JTextField();
		txtCogNom.setText("CogNom");
		txtCogNom.setEditable(false);
		txtCogNom.setColumns(10);
		txtCogNom.setBounds(242, 108, 178, 20);
		contentPane.add(txtCogNom);
		
		txtLocalitat_1 = new JTextField();
		txtLocalitat_1.setText("Localitat");
		txtLocalitat_1.setEditable(false);
		txtLocalitat_1.setColumns(10);
		txtLocalitat_1.setBounds(10, 150, 178, 20);
		contentPane.add(txtLocalitat_1);
		
		JComboBox comboTipus = new JComboBox(Soci.TIPUS);
		comboTipus.setBounds(10, 193, 76, 20);
		contentPane.add(comboTipus);
		
		button = new JButton("Tornar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal aFrame = new Principal();
				aFrame.setVisible(true);
				vAccionsSoci.dispose();
			}
		});
		button.setBounds(331, 228, 89, 23);
		contentPane.add(button);
		
		vAccionsSoci=this;
	}
}
