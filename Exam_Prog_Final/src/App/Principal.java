package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	//Copia accesible de la ventana para el cerrado de la misma
	private JFrame vPrincipal;

	/**
	 * Metodo constructor
	 */
	public Principal() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Guardamos una copia de la ventana principal
		vPrincipal=this;
		
		//Accion Consultar impagos
		JButton btnImpag = new JButton("Consultar impagaments");
		btnImpag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accions aFrame = new Accions();
				aFrame.setVisible(true);
				vPrincipal.dispose();
			}
		});
		
		btnImpag.setBounds(82, 62, 260, 23);
		contentPane.add(btnImpag);
		
		//Accion actualizar impagos
		JButton btnActImp = new JButton("Actualitzar impagaments");
		btnActImp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionsAct aFrame = new AccionsAct();
				aFrame.setVisible(true);
				vPrincipal.dispose();
			}
		});
		btnActImp.setBounds(82, 96, 260, 23);
		contentPane.add(btnActImp);
		
		//Accion busqueda de socios
		JButton btnCercaDadesSocis = new JButton("Cerca dades socis");
		btnCercaDadesSocis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccionsSoci aFrame = new AccionsSoci();
				aFrame.setVisible(true);
				vPrincipal.dispose();
			}
		});
		btnCercaDadesSocis.setBounds(82, 130, 260, 23);
		contentPane.add(btnCercaDadesSocis);
	}
}
