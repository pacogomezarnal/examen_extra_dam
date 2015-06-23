package App;

import java.awt.EventQueue;

import Modelo.BD;

public class AppExamen {

	public static void main(String[] args) {
		
		//Conexion a la BD
		BD bd=BD.getInstance();
		bd.connectDB();
		
		/**
		 * Ventana Principal
		 */
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Principal frame = new Principal();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
	}
