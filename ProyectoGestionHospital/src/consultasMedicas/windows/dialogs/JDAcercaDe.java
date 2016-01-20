package consultasMedicas.windows.dialogs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JDAcercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	//AHORA CREAMOS LOS COMPONENTES QUE NECESITAMOS 
	JLabel programa = new JLabel("Programa de gestión de consultas médicas", JLabel.CENTER); 
	JLabel autor = new JLabel("Desarrollado por Ainhoa Goirigolzarri y Janire Uriarte", JLabel.CENTER); 
	JLabel derechos = new JLabel("Programación III - Universidad Deusto", JLabel.CENTER); 
	JButton aceptar = new JButton("Aceptar"); 
	
	//AHORA HACEMOS LOS PANELES QUE NECESITAMOS PARA ACOMODAR NUESTROS COMPONENTES 
	JPanel principal = new JPanel(new BorderLayout()); 
	JPanel info = new JPanel(new GridLayout(3, 1)); 
	JPanel boton = new JPanel(new FlowLayout());
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDAcercaDe dialog = new JDAcercaDe();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public JDAcercaDe() {
		super(new JFrame(), "Acerca de ConsultasMedicas", true); 
		
		//AGREGAMOS AL PANEL info, LAS TRES ETIQUETAS QUE CREAMOS 
		info.add(programa); 
		info.add(autor); 
		info.add(derechos); 
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//AGREGAMOS AL PANEL boton, EL BOTON QUE CREAMOS 
		boton.add(aceptar); 
		
		//AHORA AGREGAMOS AL PANEL principal, LOS PANELES info, boton 
		//QUE A SU VEZ CONTIENEN A TODOS LOS COMPONENTES 
		principal.add("Center", info); 
		principal.add("South", boton); 
		
		//AGREGAMOS EL PANEL PRINCIPAL AL CUADRO DE DIALOGO 
		getContentPane().add(principal); 
		
		
		//INDICAMOS QUE NO PUEDAN CAMBIAR EL TAMA„O DEL DIALOGO CON EL MOUSE 
		setResizable(false); 
		
		// Indicamos el tama–o
		setBounds(100, 100, 330, 120);

	}

}
