package consultasMedicas.windows.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import consultasMedicas.baseDatos.BaseDeDatos;
import consultasMedicas.bussinesLogic.domain.facade.ConsultasMedicasFacade;
import consultasMedicas.bussinesLogic.domain.objects.*;
import consultasMedicas.bussinesLogic.domain.objects.containers.*;
import consultasMedicas.bussinesLogic.domain.objects.io.GestorCitas;
import consultasMedicas.bussinesLogic.domain.objects.io.GestorPacientes;
import consultasMedicas.bussinesLogic.domain.utilities.*;
import consultasMedicas.windows.frames.JMainWindow;
import consultasMedicas.windows.dialogs.JDAcercaDe;

import javax.swing.JTree;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Calendar;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;


public class JMainWindow extends JFrame implements Runnable{

	final JTabbedPane tabbedPane;
	final JTextField jtfMedicoNumero;
	final JTextField jtfMedicoNombre;
	final JTextField jtfMedicoApellido1;
	final JTextField jtfMedicoApellido2;
	final JTextField jtfMedicoDni;
	final JSpinner jspMedicoFechaNac;
	final JComboBox<Sexo> jcbMedicoSexo;
	final JComboBox<Especialidad> jcbEspecialidad;
	final JButton btnNuevoMedico;
	final JButton btnAnyadirMedico;
	final JButton btnEliminarMedico;
	final JButton btnModificarMedico;
	final JList<Medico> jlstMedicos;
	
	final JTextField jtfPacienteNumeroSS;
	final JTextField jtfPacienteNombre;
	final JTextField jtfPacienteApellido1;
	final JTextField jtfPacienteApellido2;
	final JTextField jtfPacienteDni;
	final JSpinner jspPacienteFechaNac;
	final JComboBox<Sexo> jcbPacienteSexo;
	final JButton btnNuevoPaciente;
	final JButton btnAnyadirPaciente;
	final JButton btnEliminarPaciente;
	final JList<Paciente> jlstPacientes;
	
	final JTextField jtfEnfermedadNombre;
	final JCheckBox chckbxContagiosa;
	final JCheckBox chckbxCronica;
	final JCheckBox chckbxHereditaria;
	final JCheckBox chckbxInfecciosa;
	final JCheckBox chckbxDegenerativa;
	final JButton btnNuevaEnfermedad;
	final JButton btnAnyadirEnfermedad;
	final JButton btnEliminarEnfermedad;
	final JButton btnModificarEnfermedad;
	final JList<Enfermedad> jlstEnfermedades;
	
	final JTextField jtfMedicamentoCodigo;
	final JTextField jtfMedicamentoNombre;
	final JCheckBox chckbxGenerico;
	final JTextField jtfLaboratorio;
	final JComboBox<Presentacion> jcbPresentacion;
	final JSpinner jspUnidades;
	final JCheckBox chckbxVentaConReceta;
	final JButton btnNuevoMedicamento;
	final JButton btnAnyadirMedicamento;
	final JButton btnEliminarMedicamento;
	final JButton btnModificarMedicamento;
	final JList<Medicamento> jlstMedicamentos;
	
	final JComboBox<Medico> jcbMedicosCitas;
	final JDateChooser jdcCalendario;
    final JTable jtCitas;
    final JButton btnAnyadirCita;
    final JButton btnEliminarCita;
    final JTextField jtfHoraDeCita;
    final JTextField jtfPacienteCitasNumeroSS;
    final JTextField jtfPacienteCitasNombre;
    final JTextField jtfPacienteCitasDNI;
    final JButton btnBuscarPaciente;		
    
	Consulta consulta = null;
	final JButton btnNuevaConsulta;
	final JComboBox<Medico> jcbMedicos;
	final JComboBox<Paciente> jcbPacientes;
	final JComboBox<Enfermedad> jcbEnfermedades;
	final JComboBox<Medicamento> jcbMedicamentos;
	final JTextArea jtxtDiagnostico;
	final JTextArea jtxtSintomas;
	final JTabbedPane jtabConsulta;
	final JList<Receta> jlstRecetas;
	final JSpinner jspFecha;
	final JSpinner jspFechaInicio;
	final JSpinner jspDiasTratamiento;
	final JSpinner jspDosisDesayuno;
	final JSpinner jspDosisComida;
	final JSpinner jspDosisCena;
	final JButton btnRecetar;
	final JButton btnModificarReceta;
	final JButton btnEliminarReceta;
	final JComboBox<Cuidado> jcbCuidados;
	final JList<Cuidado> jlstCuidados;
	final JButton btnAnyadirCuidado;
	final JButton btnEliminarCuidado;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7912887854396053953L;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMainWindow frame = new JMainWindow();
					frame.setLocationRelativeTo(null);
				    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JMainWindow() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// Inicializamos el sistema
				BaseDeDatos.initBD("ConsultasMedicasBaseDatos");
				
				boolean inicializacion = ConsultasMedicasFacade.inicializar();
				
				// Si ha habido un problema en la inicialización lo indicamos por pantalla
				if(!inicializacion){
					JOptionPane.showMessageDialog(new JFrame("Error de inicialización"),
						    "Error en el proceso de inicialización de ConsultasMedicas.\nNo se puede continuar con el programa.\nSe procederá al cierre.",
						    "ConsultasMedicas - Error",
						    JOptionPane.WARNING_MESSAGE);
					// Una vez se ha visualizado el mensaje cerramos la aplicaci—n.
					System.exit(ERROR);
				}
				
				actualizarListas();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarVentana();
			}
		});
		
		// definimos el titulo y tamaño de la ventana principal
		setTitle("ConsultasMedicas - Gestión de consultas médicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 745);
		 
		consulta = new Consulta();
		
		// MENU
		// creamos el menu vacio
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// añadimos la opcion Archivo
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		// añadimo la opción salir a la opción archivo
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Llamamos a las operaciones de cierre de sistema
				cerrarVentana();
				// Eliminamos la ventana
				dispose();
				// Cerramos la aplicación marcando que no hay errores.
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnCatalogos = new JMenu("Catálogos");
		menuBar.add(mnCatalogos);
		
		JMenuItem mnMedicos = new JMenuItem("Medicos");
		mnMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		mnCatalogos.add(mnMedicos);
				
		JMenuItem mnPacientes = new JMenuItem("Pacientes");
		mnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnCatalogos.add(mnPacientes);
		
		JMenuItem mnEnfermedades = new JMenuItem("Enfermedades");
		mnEnfermedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		mnCatalogos.add(mnEnfermedades);
		
		JMenuItem mnMedicamentos = new JMenuItem("Medicamentos");
		mnMedicamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		mnCatalogos.add(mnMedicamentos);
		
		JMenu mnGestion = new JMenu("Gestión");
		menuBar.add(mnGestion);
		
		JMenuItem mnCitas = new JMenuItem("Citas");
		mnCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		mnGestion.add(mnCitas);
		
		JMenuItem mnConsultas = new JMenuItem("Consultas Médicas");
		mnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		mnGestion.add(mnConsultas);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Creamos la ventana de Acerca de...
				JDAcercaDe acercaDe = new JDAcercaDe();
				acercaDe.setModalityType(ModalityType.APPLICATION_MODAL);
				acercaDe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				acercaDe.setLocationRelativeTo(getContentPane());
				acercaDe.setVisible(true);
			}
		});
		menuBar.add(mntmAcercaDe);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		//// ARBOL
		tree = new JTree();
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				 if (node != null) {
					 if (node.isLeaf()) {
						 switch(node.getUserObject().toString().toUpperCase()){
						 	case "MEDICOS":
						 		tabbedPane.setSelectedIndex(0);
						 		break;
						 	case "PACIENTES":
						 		tabbedPane.setSelectedIndex(1);
						 		break;
						 	case "ENFERMEDADES":
						 		tabbedPane.setSelectedIndex(2);
						 		break;
						 	case "MEDICAMENTOS":
						 		tabbedPane.setSelectedIndex(3);
						 		break;
						 	case "CITAS":
						 		tabbedPane.setSelectedIndex(4);
						 		break;	
						 	case "CONSULTAS":
						 		tabbedPane.setSelectedIndex(5);
						 		break;	
						 }
						 						 
					 }
				 }
			}
		});
		
		DefaultMutableTreeNode node_0 = new DefaultMutableTreeNode("Gestión Consultas M\u00E9dicas");
		DefaultMutableTreeNode node_1 = new DefaultMutableTreeNode("Catálogos");
		node_1.add(new DefaultMutableTreeNode("Medicos"));
		node_1.add(new DefaultMutableTreeNode("Pacientes"));
		node_1.add(new DefaultMutableTreeNode("Enfermedades"));
		node_1.add(new DefaultMutableTreeNode("Medicamentos"));
		node_0.add(node_1);
		DefaultMutableTreeNode node_2 = new DefaultMutableTreeNode("Gesti\u00F3n");
		node_2.add(new DefaultMutableTreeNode("Citas"));
		node_2.add(new DefaultMutableTreeNode("Consultas"));
		node_0.add(node_2);
		DefaultTreeModel dtmRaiz = new DefaultTreeModel(node_0);
		tree.setModel(dtmRaiz);
		//tree.setBounds(0, 0, 300, 745);
		getContentPane().add(tree, BorderLayout.WEST);
		
		// CARPETAS
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
	
		// CARPETA MEDICOS
		JPanel jpMedicos = new JPanel();
		tabbedPane.addTab("M\u00E9dicos", null, jpMedicos, null);
		jpMedicos.setLayout(null);
		
		JLabel lblListaDeMdicos = new JLabel("Lista de m\u00E9dicos");
		lblListaDeMdicos.setBounds(35, 30, 114, 14);
		jpMedicos.add(lblListaDeMdicos);
		
		JScrollPane jspMedicos = new JScrollPane();
		jspMedicos.setBounds(35, 55, 618, 130);
		jpMedicos.add(jspMedicos);
		
		jlstMedicos = new JList<Medico>();
		jlstMedicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (jlstMedicos.getSelectedIndex() != -1) {
				Medico medico = (Medico) jlstMedicos.getSelectedValue();
				jtfMedicoNumero.setText(medico.getcodmedico());
				jtfMedicoNombre.setText(medico.getNombre());
				jtfMedicoApellido1.setText(medico.getApellido1());
				jtfMedicoApellido2.setText(medico.getApellido2());
				jtfMedicoDni.setText(medico.getDni());
				jspMedicoFechaNac.setValue(medico.getFechaNacimiento());
				jcbMedicoSexo.setSelectedItem(medico.getSexo());
				jcbEspecialidad.setSelectedItem(medico.getEspecialidad());
				}
			}
		});
		jlstMedicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlstMedicos.setModel(new DefaultListModel<Medico>());
		jspMedicos.setViewportView(jlstMedicos);
		
		JPanel jpnlMedicoDatos = new JPanel();
		jpnlMedicoDatos.setLayout(null);
		jpnlMedicoDatos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jpnlMedicoDatos.setBounds(35, 211, 617, 111);
		jpMedicos.add(jpnlMedicoDatos);
		
		JLabel lblNmeroColegiado = new JLabel("N\u00FAmero Colegiado:");
		lblNmeroColegiado.setBounds(17, 11, 132, 14);
		jpnlMedicoDatos.add(lblNmeroColegiado);
		
		jtfMedicoNumero = new JTextField();
		jtfMedicoNumero.setColumns(10);
		jtfMedicoNumero.setBounds(17, 25, 132, 20);
		jpnlMedicoDatos.add(jtfMedicoNumero);
		
		JLabel label_12 = new JLabel("Nombre:");
		label_12.setBounds(166, 11, 79, 14);
		jpnlMedicoDatos.add(label_12);
		
		jtfMedicoNombre = new JTextField();
		jtfMedicoNombre.setColumns(10);
		jtfMedicoNombre.setBounds(166, 25, 132, 20);
		jpnlMedicoDatos.add(jtfMedicoNombre);
		
		JLabel label_11 = new JLabel("1\u00BA Apellido:");
		label_11.setBounds(315, 11, 109, 14);
		jpnlMedicoDatos.add(label_11);
		
		jtfMedicoApellido1 = new JTextField();
		jtfMedicoApellido1.setColumns(10);
		jtfMedicoApellido1.setBounds(315, 25, 132, 20);
		jpnlMedicoDatos.add(jtfMedicoApellido1);
		
		JLabel label_10 = new JLabel("2\u00BA Apellido:");
		label_10.setBounds(464, 11, 93, 14);
		jpnlMedicoDatos.add(label_10);
		
		jtfMedicoApellido2 = new JTextField();
		jtfMedicoApellido2.setColumns(10);
		jtfMedicoApellido2.setBounds(464, 25, 132, 20);
		jpnlMedicoDatos.add(jtfMedicoApellido2);
		
		JLabel label_9 = new JLabel("DNI:");
		label_9.setBounds(315, 56, 27, 14);
		jpnlMedicoDatos.add(label_9);
		
		jtfMedicoDni = new JTextField();
		jtfMedicoDni.setColumns(10);
		jtfMedicoDni.setBounds(315, 71, 132, 20);
		jpnlMedicoDatos.add(jtfMedicoDni);
		
		JLabel label_7 = new JLabel("Fecha nacimiento:");
		label_7.setBounds(464, 56, 132, 14);
		jpnlMedicoDatos.add(label_7);
		
		jspMedicoFechaNac = new JSpinner();
		jspMedicoFechaNac.setModel(new SpinnerDateModel(new Date(1399845600000L), null, null, Calendar.DAY_OF_YEAR));
		jspMedicoFechaNac.setBounds(464, 71, 132, 20);
		jpnlMedicoDatos.add(jspMedicoFechaNac);
		
		JLabel label_8 = new JLabel("Sexo:");
		label_8.setBounds(212, 56, 34, 14);
		jpnlMedicoDatos.add(label_8);
		
		jcbMedicoSexo = new JComboBox<Sexo>();
		jcbMedicoSexo.setModel(new DefaultComboBoxModel<Sexo>(Sexo.values()));
		jcbMedicoSexo.setSelectedIndex(-1);
		jcbMedicoSexo.setBounds(212, 71, 86, 20);
		jcbMedicoSexo.setSelectedIndex(-1);
		jpnlMedicoDatos.add(jcbMedicoSexo);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(17, 56, 86, 14);
		jpnlMedicoDatos.add(lblEspecialidad);
		
		jcbEspecialidad = new JComboBox<Especialidad>();
		jcbEspecialidad.setModel(new DefaultComboBoxModel<Especialidad>(Especialidad.values()));
		jcbEspecialidad.setSelectedIndex(-1);
		jcbEspecialidad.setBounds(17, 71, 170, 20);
		jcbEspecialidad.setSelectedIndex(-1);
		jpnlMedicoDatos.add(jcbEspecialidad);
		
		btnNuevoMedico = new JButton("Nuevo");
		btnNuevoMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarDatosMedico();
			}
		});
		btnNuevoMedico.setBounds(69, 351, 89, 32);
		jpMedicos.add(btnNuevoMedico);
		
		btnAnyadirMedico = new JButton("A\u00F1adir");
		btnAnyadirMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico medico = new Medico();
				medico.setCodmedico(jtfMedicoNumero.getText());
				medico.setNombre(jtfMedicoNombre.getText());
				medico.setApellido1(jtfMedicoApellido1.getText());
				medico.setApellido2(jtfMedicoApellido2.getText());
				medico.setDni(jtfMedicoDni.getText());
				medico.setFechaNacimiento((Date) jspMedicoFechaNac.getValue());
				medico.setSexo((Sexo) jcbMedicoSexo.getSelectedItem());
				medico.setEspecialidad((Especialidad) jcbEspecialidad.getSelectedItem());
				DefaultListModel<Medico> modelo = (DefaultListModel<Medico>) jlstMedicos.getModel();
				
				boolean duplicado = false; 
				Medico med;
	              for(int i=0;i<modelo.getSize();i++)
	                {
	            	  med = (Medico) modelo.getElementAt(i);
                      if ( med.getcodmedico().equals(medico.getcodmedico()) || med.getDni().equals(medico.getDni()) ){
	                    	duplicado=true;
                      }
	                }
	            
	              if (!duplicado) {
					modelo.addElement(medico);
					actualizarComboMedicos();
					jlstMedicos.setSelectedIndex(modelo.getSize()-1);
					btnEliminarMedico.setEnabled(true);
					btnModificarMedico.setEnabled(true);
	              }
	              else
	              {
					JOptionPane.showMessageDialog(new JFrame("Error añadiendo"),
						    "Ya existe un médico con el número " + medico.getcodmedico() +" o el DNI " + medico.getDni(),
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
	              }
			}
		});
		btnAnyadirMedico.setBounds(227, 351, 89, 32);
		jpMedicos.add(btnAnyadirMedico);
		
		btnModificarMedico = new JButton("Modificar");
		btnModificarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jlstMedicos.getSelectedIndex() != -1) {
					Medico medico = (Medico) jlstMedicos.getSelectedValue();
					medico.setCodmedico(jtfMedicoNumero.getText());
					medico.setNombre(jtfMedicoNombre.getText());
					medico.setApellido1(jtfMedicoApellido1.getText());
					medico.setApellido2(jtfMedicoApellido2.getText());
					medico.setDni(jtfMedicoDni.getText());
					medico.setFechaNacimiento((Date) jspMedicoFechaNac.getValue());
					medico.setSexo((Sexo) jcbMedicoSexo.getSelectedItem());
					medico.setEspecialidad((Especialidad) jcbEspecialidad.getSelectedItem());
					DefaultListModel<Medico> modelo = (DefaultListModel<Medico>) jlstMedicos.getModel();
					int i = jlstMedicos.getSelectedIndex();
					modelo.removeElementAt(i);
					modelo.add(i, medico);
					actualizarComboMedicos();
					jlstMedicos.setSelectedIndex(i);
				}
			}
		});
		btnModificarMedico.setBounds(385, 351, 89, 32);
		jpMedicos.add(btnModificarMedico);
		
		btnEliminarMedico = new JButton("Eliminar");
		btnEliminarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jlstMedicos.getSelectedIndex() != -1) {
					DefaultListModel<Medico> modelo = (DefaultListModel<Medico>) jlstMedicos.getModel();
					modelo.remove(jlstMedicos.getSelectedIndex());
					actualizarComboMedicos();
					limpiarDatosMedico();
					// Comprobamos si queda algo en la lista
					if(modelo.getSize() == 0){
						// Como no queda nada en la lista procedemos deshabilitar los botones
						btnEliminarMedico.setEnabled(false);
						btnModificarMedico.setEnabled(false);
					}
				}
					else 
						JOptionPane.showMessageDialog(new JFrame("Error de selección"),
							    "No se ha seleccionado el médico a borrar.",
							    "ConsultasMedicas - Error",
							    JOptionPane.ERROR_MESSAGE);
				}
		});
		btnEliminarMedico.setBounds(543, 351, 89, 32);
		jpMedicos.add(btnEliminarMedico);

		////////////////////////////////////////////////////////////////////////////// CARPETA PACIENTES
		JPanel jpPacientes = new JPanel();
		tabbedPane.addTab("Pacientes", null, jpPacientes, null);
		jpPacientes.setLayout(null);
		
		JLabel lblListaDePacientes = new JLabel("Lista de pacientes");
		lblListaDePacientes.setBounds(35, 30, 114, 14);
		jpPacientes.add(lblListaDePacientes);
		
		JScrollPane jspPacientes = new JScrollPane();
		jspPacientes.setBounds(35, 55, 618, 130);
		jpPacientes.add(jspPacientes);
		
		jlstPacientes = new JList<Paciente>();
		jlstPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (jlstPacientes.getSelectedIndex() != -1) {
				Paciente paciente = (Paciente) jlstPacientes.getSelectedValue();
				jtfPacienteNumeroSS.setText(paciente.getNumeroSeguridadSocial());
				jtfPacienteNombre.setText(paciente.getNombre());
				jtfPacienteApellido1.setText(paciente.getApellido1());
				jtfPacienteApellido2.setText(paciente.getApellido2());
				jtfPacienteDni.setText(paciente.getDni());
				//jspPacienteFechaNac.setValue(paciente.getFechaNacimiento());
				//jcbPacienteSexo.setSelectedItem(paciente.getSexo());
				}
			}
		});
		jlstPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlstPacientes.setModel(new DefaultListModel<Paciente>());
		jspPacientes.setViewportView(jlstPacientes);

		JPanel jpnlPacienteDatos = new JPanel();
		jpnlPacienteDatos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jpnlPacienteDatos.setBounds(35, 211, 617, 111);
		jpPacientes.add(jpnlPacienteDatos);
		jpnlPacienteDatos.setLayout(null);
		
		JLabel lblNmeroSegSocial = new JLabel("N\u00FAmero Seg Social:");
		lblNmeroSegSocial.setBounds(17, 11, 132, 14);
		jpnlPacienteDatos.add(lblNmeroSegSocial);
		
		jtfPacienteNumeroSS = new JTextField();
		jtfPacienteNumeroSS.setBounds(17, 25, 132, 20);
		jpnlPacienteDatos.add(jtfPacienteNumeroSS);
		jtfPacienteNumeroSS.setColumns(10);
		
		JLabel label = new JLabel("Nombre:");
		label.setBounds(166, 11, 79, 14);
		jpnlPacienteDatos.add(label);
		
		jtfPacienteNombre = new JTextField();
		jtfPacienteNombre.setBounds(166, 25, 132, 20);
		jpnlPacienteDatos.add(jtfPacienteNombre);
		jtfPacienteNombre.setColumns(10);
		
		JLabel label_1 = new JLabel("1\u00BA Apellido:");
		label_1.setBounds(315, 11, 109, 14);
		jpnlPacienteDatos.add(label_1);
		
		jtfPacienteApellido1 = new JTextField();
		jtfPacienteApellido1.setBounds(315, 25, 132, 20);
		jpnlPacienteDatos.add(jtfPacienteApellido1);
		jtfPacienteApellido1.setColumns(10);
		
		JLabel label_2 = new JLabel("2\u00BA Apellido:");
		label_2.setBounds(464, 11, 93, 14);
		jpnlPacienteDatos.add(label_2);
		
		jtfPacienteApellido2 = new JTextField();
		jtfPacienteApellido2.setBounds(464, 25, 132, 20);
		jpnlPacienteDatos.add(jtfPacienteApellido2);
		jtfPacienteApellido2.setColumns(10);
		
		JLabel label_3 = new JLabel("DNI:");
		label_3.setBounds(166, 52, 27, 14);
		jpnlPacienteDatos.add(label_3);
		
		jtfPacienteDni = new JTextField();
		jtfPacienteDni.setBounds(166, 67, 132, 20);
		jpnlPacienteDatos.add(jtfPacienteDni);
		jtfPacienteDni.setColumns(10);
		
		JLabel label_5 = new JLabel("Fecha nacimiento:");
		label_5.setBounds(315, 52, 93, 14);
		jpnlPacienteDatos.add(label_5);
		
		jspPacienteFechaNac = new JSpinner();
		jspPacienteFechaNac.setModel(new SpinnerDateModel(new Date(1399845600000L), null, null, Calendar.DAY_OF_YEAR));
		jspPacienteFechaNac.setBounds(315, 67, 107, 20);
		jpnlPacienteDatos.add(jspPacienteFechaNac);
		
		JLabel label_4 = new JLabel("Sexo:");
		label_4.setBounds(464, 52, 34, 14);
		jpnlPacienteDatos.add(label_4);
		
		jcbPacienteSexo = new JComboBox<Sexo>();
		jcbPacienteSexo.setModel(new DefaultComboBoxModel<Sexo>(Sexo.values()));
		jcbPacienteSexo.setSelectedIndex(-1);
		jcbPacienteSexo.setBounds(464, 67, 86, 20);
		jcbPacienteSexo.setSelectedIndex(-1);
		jpnlPacienteDatos.add(jcbPacienteSexo);
		
		btnNuevoPaciente = new JButton("Nuevo");
		btnNuevoPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarDatosPaciente();
			}
		});
		
		btnNuevoPaciente.setBounds (69, 351, 89, 32);
		jpPacientes.add(btnNuevoPaciente);
		
		btnAnyadirPaciente = new JButton("Grabar en Base Datos");
		btnAnyadirPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Paciente paciente = new Paciente();
				paciente.setNumeroSeguridadSocial(jtfPacienteNumeroSS.getText());
				paciente.setNombre(jtfPacienteNombre.getText());
				paciente.setApellido1(jtfPacienteApellido1.getText());
				paciente.setApellido2(jtfPacienteApellido2.getText());
				paciente.setDni(jtfPacienteDni.getText());
				paciente.setFechaNacimiento((Date) jspPacienteFechaNac.getValue());
				paciente.setSexo((Sexo) jcbPacienteSexo.getSelectedItem());
				
				GestorPacientes.grabarPacienteBaseDatos(paciente);
				actualizarListaPacientes();

			}
		});
		btnAnyadirPaciente.setBounds(227, 351, 180, 32);
		jpPacientes.add(btnAnyadirPaciente);

		
		btnEliminarPaciente = new JButton("Eliminar");
		btnEliminarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jlstPacientes.getSelectedIndex() != -1) {
					GestorPacientes.borrarPacienteBaseDatos(jtfPacienteNumeroSS.getText());
					actualizarListaPacientes();
					/*
					DefaultListModel<Paciente> modelo = (DefaultListModel<Paciente>) jlstPacientes.getModel();
					modelo.remove(jlstPacientes.getSelectedIndex());
					actualizarComboPacientes();
					limpiarDatosPaciente();
					// Comprobamos si queda algo en la lista
					if(modelo.getSize() == 0){
						// Como no queda nada en la lista procedemos deshabilitar los botones
						btnEliminarPaciente.setEnabled(false);
					}
									*/
				}
					else 
						JOptionPane.showMessageDialog(new JFrame("Error de selección"),
							    "No se ha seleccionado el paciente a borrar.",
							    "ConsultasMedicas - Error",
							    JOptionPane.ERROR_MESSAGE);

				}
		});
		btnEliminarPaciente.setBounds(543, 351, 89, 32);
		jpPacientes.add(btnEliminarPaciente);

		//////////////////////////////////////////////////////// Tab de Enfermedades 
		JPanel jpEnfermedades = new JPanel();
		tabbedPane.addTab("Enfermedades", null, jpEnfermedades, null);
		jpEnfermedades.setLayout(null);
		
		JLabel lblListaEnfermedades = new JLabel("Lista de enfermedades");
		lblListaEnfermedades.setBounds(35, 30, 162, 14);
		jpEnfermedades.add(lblListaEnfermedades);
		
		JScrollPane jspEnfermedades = new JScrollPane();
		jspEnfermedades.setBounds(35, 55, 618, 130);
		jpEnfermedades.add(jspEnfermedades);
		
		jlstEnfermedades = new JList<Enfermedad>();
		jlstEnfermedades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (jlstEnfermedades.getSelectedIndex() != -1) {
				Enfermedad enfermedad = (Enfermedad) jlstEnfermedades.getSelectedValue();
				jtfEnfermedadNombre.setText(enfermedad.getNombre());
				chckbxContagiosa.setSelected(enfermedad.isContagiosa());
				chckbxCronica.setSelected(enfermedad.isCronica());
				chckbxHereditaria.setSelected(enfermedad.isHereditaria());
				chckbxInfecciosa.setSelected(enfermedad.isInfecciosa());
				chckbxDegenerativa.setSelected(enfermedad.isDegenerativa());
				}
			}
		});
		jlstEnfermedades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlstEnfermedades.setModel(new DefaultListModel<Enfermedad>());
		jspEnfermedades.setViewportView(jlstEnfermedades);
		
		JPanel jpnlEnfermedadDatos = new JPanel();
		jpnlEnfermedadDatos.setLayout(null);
		jpnlEnfermedadDatos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jpnlEnfermedadDatos.setBounds(35, 211, 617, 111);
		jpEnfermedades.add(jpnlEnfermedadDatos);
		
		JLabel lblEnfermedadNombre = new JLabel("Nombre enfermedad:");
		lblEnfermedadNombre.setBounds(162, 11, 132, 14);
		jpnlEnfermedadDatos.add(lblEnfermedadNombre);
		
		jtfEnfermedadNombre = new JTextField();
		jtfEnfermedadNombre.setColumns(10);
		jtfEnfermedadNombre.setBounds(162, 25, 294, 20);;
		jpnlEnfermedadDatos.add(jtfEnfermedadNombre);
		
		chckbxContagiosa = new JCheckBox("Contagiosa");
		chckbxContagiosa.setBounds(22, 70, 97, 23);
		jpnlEnfermedadDatos.add(chckbxContagiosa);
		
		chckbxCronica = new JCheckBox("Cr\u00F3nica");
		chckbxCronica.setBounds(141, 70, 97, 23);
		jpnlEnfermedadDatos.add(chckbxCronica);
		
		chckbxHereditaria = new JCheckBox("Hereditaria");
		chckbxHereditaria.setBounds(498, 70, 97, 23);
		jpnlEnfermedadDatos.add(chckbxHereditaria);
		
		chckbxInfecciosa = new JCheckBox("Infecciosa");
		chckbxInfecciosa.setBounds(260, 70, 97, 23);
		jpnlEnfermedadDatos.add(chckbxInfecciosa);
		
		chckbxDegenerativa = new JCheckBox("Degenerativa");
		chckbxDegenerativa.setBounds(379, 70, 117, 23);
		jpnlEnfermedadDatos.add(chckbxDegenerativa);
		
		btnNuevaEnfermedad = new JButton("Nueva");
		btnNuevaEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarDatosEnfermedad();
			}
		});
		btnNuevaEnfermedad.setBounds(69, 351, 89, 32);
		jpEnfermedades.add(btnNuevaEnfermedad);
		
		btnAnyadirEnfermedad = new JButton("A\u00F1adir");
		btnAnyadirEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Enfermedad enfermedad = new Enfermedad();
				enfermedad.setNombre(jtfEnfermedadNombre.getText());
				enfermedad.setContagiosa(chckbxContagiosa.isSelected());
				enfermedad.setCronica(chckbxCronica.isSelected());
				enfermedad.setHereditaria(chckbxHereditaria.isSelected());
				enfermedad.setInfecciosa(chckbxInfecciosa.isSelected());
				enfermedad.setDegenerativa(chckbxDegenerativa.isSelected());
				
				DefaultListModel<Enfermedad> modelo = (DefaultListModel<Enfermedad>) jlstEnfermedades.getModel();
				
				boolean duplicado = false; 
				Enfermedad enfer;
	              for(int i=0;i<modelo.getSize();i++)
	                {
	            	  enfer = (Enfermedad) modelo.getElementAt(i);
                      if ( enfer.getNombre().toUpperCase().equals(enfermedad.getNombre().toUpperCase()) ){
	                    	duplicado=true;
                      }
	                }
	            
	              if (!duplicado) {
					modelo.addElement(enfermedad);
					actualizarComboEnfermedades();
					jlstEnfermedades.setSelectedIndex(modelo.getSize()-1);
					btnEliminarEnfermedad.setEnabled(true);
					btnModificarEnfermedad.setEnabled(true);
	              }
	              else
	              {
					JOptionPane.showMessageDialog(new JFrame("Error añadiendo enfermedad"),
						    "Ya existe una enfermedad con el nombre " + enfermedad.getNombre(),
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
	              }
			}
		});
		btnAnyadirEnfermedad.setBounds(227, 351, 89, 32);
		jpEnfermedades.add(btnAnyadirEnfermedad);
		
		btnModificarEnfermedad = new JButton("Modificar");
		btnModificarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jlstEnfermedades.getSelectedIndex() != -1) {
					Enfermedad enfermedad = (Enfermedad) jlstEnfermedades.getSelectedValue();
					enfermedad.setNombre(jtfEnfermedadNombre.getText());
					enfermedad.setContagiosa(chckbxContagiosa.isSelected());
					enfermedad.setCronica(chckbxCronica.isSelected());
					enfermedad.setHereditaria(chckbxHereditaria.isSelected());
					enfermedad.setInfecciosa(chckbxInfecciosa.isSelected());
					enfermedad.setDegenerativa(chckbxDegenerativa.isSelected());
					
					DefaultListModel<Enfermedad> modelo = (DefaultListModel<Enfermedad>) jlstEnfermedades.getModel();
					int i = jlstEnfermedades.getSelectedIndex();
					modelo.removeElementAt(i);
					modelo.add(i, enfermedad);
					actualizarComboEnfermedades();
					jlstEnfermedades.setSelectedIndex(i);
				}
			}
		});
		btnModificarEnfermedad.setBounds(385, 351, 89, 32);
		jpEnfermedades.add(btnModificarEnfermedad);
		
		btnEliminarEnfermedad = new JButton("Eliminar");
		btnEliminarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jlstEnfermedades.getSelectedIndex() != -1) {
					DefaultListModel<Enfermedad> modelo = (DefaultListModel<Enfermedad>) jlstEnfermedades.getModel();
					modelo.remove(jlstEnfermedades.getSelectedIndex());
					actualizarComboEnfermedades();
					limpiarDatosEnfermedad();
					// Comprobamos si queda algo en la lista
					if(modelo.getSize() == 0){
						// Como no queda nada en la lista procedemos deshabilitar los botones
						btnEliminarEnfermedad.setEnabled(false);
						btnModificarEnfermedad.setEnabled(false);
					}
				}
					else 
						JOptionPane.showMessageDialog(new JFrame("Error de selección"),
							    "No se ha seleccionado la enfermedad a borrar.",
							    "ConsultasMedicas - Error",
							    JOptionPane.ERROR_MESSAGE);
				}
		});
		btnEliminarEnfermedad.setBounds(543, 351, 89, 32);
		jpEnfermedades.add(btnEliminarEnfermedad);
		
		////////////////////////////////////////////////////////Tab de Medicamentos
		JPanel jpMedicamentos = new JPanel();
		tabbedPane.addTab("Medicamentos", null, jpMedicamentos, null);
		jpMedicamentos.setLayout(null);
		
		JLabel lblListaMedicamentos = new JLabel("Lista de medicamentos");
		lblListaMedicamentos.setBounds(35, 30, 162, 14);
		jpMedicamentos.add(lblListaMedicamentos);
		
		JScrollPane jspMedicamentos = new JScrollPane();
		jspMedicamentos.setBounds(35, 55, 618, 130);
		jpMedicamentos.add(jspMedicamentos);
		
		jlstMedicamentos = new JList<Medicamento>();
		jlstMedicamentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (jlstMedicamentos.getSelectedIndex() != -1) {
					Medicamento medicamento = (Medicamento) jlstMedicamentos.getSelectedValue();
					jtfMedicamentoCodigo.setText(medicamento.getCodigo());
					jtfMedicamentoNombre.setText(medicamento.getNombre());
					chckbxGenerico.setSelected(medicamento.isGenerico());
					jtfLaboratorio.setText(medicamento.getLaboratorio());
					jcbPresentacion.setSelectedItem(medicamento.getPresentacion());
					jspUnidades.setValue(medicamento.getUnidades());
					chckbxVentaConReceta.setSelected(medicamento.isVentaConReceta());
					/*DefaultListModel<PrincipioActivo> principiosActivos = (DefaultListModel<PrincipioActivo>) jtbPrincipiosActivos.getModel();
					principiosActivos.clear();
					for(PrincipioActivo prinact : medicamento.getListaPrincipiosActivos())
						principiosActivos.addElement(prinact);
						*/
				}
			}
		});
		jlstMedicamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlstMedicamentos.setModel(new DefaultListModel<Medicamento>());
		jspMedicamentos.setViewportView(jlstMedicamentos);
		
		JPanel jpnlMedicamentoDatos = new JPanel();
		jpnlMedicamentoDatos.setLayout(null);
		jpnlMedicamentoDatos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jpnlMedicamentoDatos.setBounds(35, 211, 617, 111);
		jpMedicamentos.add(jpnlMedicamentoDatos);

		JLabel lblMedicamentoCodigo = new JLabel("C\u00F3digo:");
		lblMedicamentoCodigo.setBounds(24, 11, 132, 14);
		jpnlMedicamentoDatos.add(lblMedicamentoCodigo);
		
		jtfMedicamentoCodigo = new JTextField();
		jtfMedicamentoCodigo.setColumns(10);
		jtfMedicamentoCodigo.setBounds(24, 25, 109, 20);
		jpnlMedicamentoDatos.add(jtfMedicamentoCodigo);
		
		JLabel lblMedicamentoNombre = new JLabel("Nombre:");
		lblMedicamentoNombre.setBounds(159, 11, 79, 14);
		jpnlMedicamentoDatos.add(lblMedicamentoNombre);
		
		jtfMedicamentoNombre = new JTextField();
		jtfMedicamentoNombre.setColumns(10);
		jtfMedicamentoNombre.setBounds(157, 25, 235, 20);
		jpnlMedicamentoDatos.add(jtfMedicamentoNombre);
		
		JLabel lblLaboratorio = new JLabel("Laboratorio:");
		lblLaboratorio.setBounds(421, 11, 109, 14);
		jpnlMedicamentoDatos.add(lblLaboratorio);
		
		jtfLaboratorio = new JTextField();
		jtfLaboratorio.setColumns(10);
		jtfLaboratorio.setBounds(416, 25, 175, 20);
		jpnlMedicamentoDatos.add(jtfLaboratorio);
		
		JLabel lblPresentacion = new JLabel("Presentacion");
		lblPresentacion.setBounds(157, 56, 86, 14);
		jpnlMedicamentoDatos.add(lblPresentacion);
		
		jcbPresentacion = new JComboBox<Presentacion>();
		jcbPresentacion.setModel(new DefaultComboBoxModel<Presentacion>(Presentacion.values()));
		jcbPresentacion.setSelectedIndex(-1);
		jcbPresentacion.setBounds(157, 71, 235, 20);
		jcbPresentacion.setSelectedIndex(-1);
		jpnlMedicamentoDatos.add(jcbPresentacion);
		
		JLabel lblUnidades = new JLabel("Unidades:");
		lblUnidades.setBounds(24, 56, 72, 14);
		jpnlMedicamentoDatos.add(lblUnidades);
		
		jspUnidades = new JSpinner();
		jspUnidades.setModel(new SpinnerNumberModel(0, 0, null, 1));
		jspUnidades.setBounds(24, 71, 109, 20);
		jpnlMedicamentoDatos.add(jspUnidades);
		
		chckbxVentaConReceta = new JCheckBox("Con receta");
		chckbxVentaConReceta.setBounds(508, 70, 103, 23);
		jpnlMedicamentoDatos.add(chckbxVentaConReceta);
		
		chckbxGenerico = new JCheckBox("Gen\u00E9rico");
		chckbxGenerico.setBounds(418, 70, 97, 23);
		jpnlMedicamentoDatos.add(chckbxGenerico);
		
		
		btnNuevoMedicamento = new JButton("Nuevo");
		btnNuevoMedicamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarDatosMedicamento();
			}
		});
		btnNuevoMedicamento.setBounds(69, 351, 89, 32);
		jpMedicamentos.add(btnNuevoMedicamento);
		
		btnAnyadirMedicamento = new JButton("Añadir");
		btnAnyadirMedicamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Medicamento	medicamento = new Medicamento();
				medicamento.setCodigo(jtfMedicamentoCodigo.getText());
				medicamento.setNombre(jtfMedicamentoNombre.getText());
				medicamento.setGenerico(chckbxGenerico.isSelected());
				medicamento.setLaboratorio(jtfLaboratorio.getText());
				medicamento.setPresentacion((Presentacion) jcbPresentacion.getSelectedItem());
				medicamento.setUnidades((int)jspUnidades.getValue());
				medicamento.setVentaConReceta(chckbxVentaConReceta.isSelected());
				
				DefaultListModel<Medicamento> modelo = (DefaultListModel<Medicamento>) jlstMedicamentos.getModel();
				
				boolean duplicado = false; 
				Medicamento medica;
	              for(int i=0;i<modelo.getSize();i++)
	                {
	            	  medica = (Medicamento) modelo.getElementAt(i);
                      if ( medica.getCodigo().equals(medicamento.getCodigo()) || medica.getNombre().toUpperCase().equals(medicamento.getNombre().toUpperCase()) ){
	                    	duplicado=true;
                      }
	                }
	            
	              if (!duplicado) {
					modelo.addElement(medicamento);
					actualizarComboMedicamentos();
					jlstMedicamentos.setSelectedIndex(modelo.getSize()-1);
					btnEliminarMedicamento.setEnabled(true);
					btnModificarMedicamento.setEnabled(true);
	              }
	              else
	              {
					JOptionPane.showMessageDialog(new JFrame("Error añadiendo medicamento"),
						    "Ya existe un medicamento con el código " + medicamento.getCodigo() +" o el nombre " + medicamento.getNombre(),
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
	              }
			}
		});
		btnAnyadirMedicamento.setBounds(227, 351, 89, 32);
		jpMedicamentos.add(btnAnyadirMedicamento);
		
		btnModificarMedicamento = new JButton("Modificar");
		btnModificarMedicamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jlstMedicamentos.getSelectedIndex() != -1) {
					Medicamento medicamento = (Medicamento) jlstMedicamentos.getSelectedValue();
					medicamento.setCodigo(jtfMedicamentoCodigo.getText());
					medicamento.setNombre(jtfMedicamentoNombre.getText());
					medicamento.setGenerico(chckbxGenerico.isSelected());
					medicamento.setLaboratorio(jtfLaboratorio.getText());
					medicamento.setPresentacion((Presentacion) jcbPresentacion.getSelectedItem());
					medicamento.setUnidades((int) jspUnidades.getValue());
					medicamento.setVentaConReceta(chckbxVentaConReceta.isSelected());
					
					DefaultListModel<Medicamento> modelo = (DefaultListModel<Medicamento>) jlstMedicamentos.getModel();
					int i = jlstMedicamentos.getSelectedIndex();
					modelo.removeElementAt(i);
					modelo.add(i, medicamento);
					actualizarComboMedicamentos();
					jlstMedicamentos.setSelectedIndex(i);
				}
			}
		});
		btnModificarMedicamento.setBounds(385, 351, 89, 32);
		jpMedicamentos.add(btnModificarMedicamento);
		
		btnEliminarMedicamento = new JButton("Eliminar");
		btnEliminarMedicamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jlstMedicamentos.getSelectedIndex() != -1) {
					DefaultListModel<Medicamento> modelo = (DefaultListModel<Medicamento>) jlstMedicamentos.getModel();
					modelo.remove(jlstMedicamentos.getSelectedIndex());
					actualizarComboMedicamentos();
					limpiarDatosMedicamento();
					// Comprobamos si queda algo en la lista
					if(modelo.getSize() == 0){
						// Como no queda nada en la lista procedemos deshabilitar los botones
						btnEliminarMedicamento.setEnabled(false);
						btnModificarMedicamento.setEnabled(false);
					}
				}
					else 
						JOptionPane.showMessageDialog(new JFrame("Error de selección"),
							    "No se ha seleccionado el medicamento a borrar.",
							    "ConsultasMedicas - Error",
							    JOptionPane.ERROR_MESSAGE);
				}
		});
		btnEliminarMedicamento.setBounds(543, 351, 89, 32);
		jpMedicamentos.add(btnEliminarMedicamento);

		////////////////////////////////////////////////////////Tab de Citas
		JPanel jpCitas = new JPanel();
		tabbedPane.addTab("Citas", null, jpCitas, null);
		jpCitas.setLayout(null);
		

		JLabel lblMedico = new JLabel("M\u00E9dico:");
		lblMedico.setBounds(30, 10, 110, 14);
		jpCitas.add(lblMedico);
		
		jcbMedicosCitas = new JComboBox<Medico>();
		jcbMedicosCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//leerAgendamedico();
			}
		});
		jcbMedicosCitas.setBounds(30, 27, 419, 25);
		jpCitas.add(jcbMedicosCitas);
		
		JLabel lblPacienteCitas = new JLabel("Paciente:");
		lblPacienteCitas.setBounds(30, 65, 110, 14);
		jpCitas.add(lblPacienteCitas);
		
		JPanel jpnlPacienteCitasDatos = new JPanel();
		jpnlPacienteCitasDatos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jpnlPacienteCitasDatos.setBounds(30, 80, 419, 111);
		jpCitas.add(jpnlPacienteCitasDatos);
		jpnlPacienteCitasDatos.setLayout(null);
		
		JLabel lblCitasNmeroSegSocial = new JLabel("N\u00FAmero Seg Social:");
		lblCitasNmeroSegSocial.setBounds(17, 11, 132, 14);
		jpnlPacienteCitasDatos.add(lblCitasNmeroSegSocial);
		
		jtfPacienteCitasNumeroSS = new JTextField();
		jtfPacienteCitasNumeroSS.setBounds(17, 25, 132, 25);
		jpnlPacienteCitasDatos.add(jtfPacienteCitasNumeroSS);
		jtfPacienteCitasNumeroSS.setColumns(10);
		
		btnBuscarPaciente = new JButton("Buscar en BD");
		btnBuscarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (jtfPacienteCitasNumeroSS.getText() != "") {
					
					Paciente paciente = GestorPacientes.leerPacienteBaseDatos(jtfPacienteCitasNumeroSS.getText());
					if (paciente.getNumeroSeguridadSocial() != "") {
						
					jtfPacienteCitasNombre.setText(paciente.getApellido1() + " " + paciente.getApellido2() + " " + paciente.getNombre());
					jtfPacienteCitasDNI.setText(paciente.getDni());
					
					} else {
						jtfPacienteCitasNombre.setText("");
						jtfPacienteCitasDNI.setText("");
						JOptionPane.showMessageDialog(new JFrame("Error en número SS"),
							    "El paciente con el número de SS " + jtfPacienteCitasNumeroSS.getText() + " no existe.",
							    "ConsultasMedicas - Error",
							    JOptionPane.ERROR_MESSAGE);
					}
				
				} else {
					JOptionPane.showMessageDialog(new JFrame("Error en número SS"),
						    "No se ha introducido el número de SS del paciente a buscar.",
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnBuscarPaciente.setBounds(160, 24, 120, 25);
		jpnlPacienteCitasDatos.add(btnBuscarPaciente);
				
		
		JLabel lblCitasDNIPaciente = new JLabel("DNI:");
		lblCitasDNIPaciente.setBounds(300, 11, 27, 14);
		jpnlPacienteCitasDatos.add(lblCitasDNIPaciente);
		
		jtfPacienteCitasDNI = new JTextField();
		jtfPacienteCitasDNI.setBounds(300, 25, 100, 25);
		jpnlPacienteCitasDatos.add(jtfPacienteCitasDNI);
		jtfPacienteCitasDNI.setColumns(10);
		
		JLabel lblCitasNombrePaciente = new JLabel("Nombre:");
		lblCitasNombrePaciente.setBounds(17, 52, 79, 14);
		jpnlPacienteCitasDatos.add(lblCitasNombrePaciente);
		
		jtfPacienteCitasNombre = new JTextField();
		jtfPacienteCitasNombre.setBounds(17, 67, 380, 25);
		jpnlPacienteCitasDatos.add(jtfPacienteCitasNombre);
		jtfPacienteCitasNombre.setColumns(10);
		
		JLabel lblDiaDeCita = new JLabel("Día de cita:");
		lblDiaDeCita.setBounds(470, 10, 200, 14);
		jpCitas.add(lblDiaDeCita);
		
		jdcCalendario = new JDateChooser();
		jdcCalendario.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			            if ("date".equals(e.getPropertyName())) {
			                System.out.println(e.getPropertyName()
			                    + ": " + (Date) e.getNewValue());
			              //leerAgendamedico();
			            }
			        }
			    });
		jdcCalendario.setBounds(470, 27, 200, 25);
	    jpCitas.add(jdcCalendario);
	    
		JLabel lblHoraDeCita = new JLabel("Hora de cita:");
		lblHoraDeCita.setBounds(470, 65, 200, 14);
		jpCitas.add(lblHoraDeCita);
	    
		jtfHoraDeCita = new JTextField();
		jtfHoraDeCita.setColumns(10);
		jtfHoraDeCita.setBounds(470, 80, 100, 25);
		jpCitas.add(jtfHoraDeCita);
		
		
		JScrollPane jspCitas = new JScrollPane();
		jspCitas.setBounds(30, 210, 419, 440);
		jpCitas.add(jspCitas);
		
	    String coljtCitas[] = { "Hora", "Paciente" };
	    String horasjtCitas[][];
	    horasjtCitas= new String[20][2];
	    
	    int h = 0;
		for( int i = 9; i < 14; i++ )
		{
			horasjtCitas[h][0] = "" + i + ":00";
			h++;
			horasjtCitas[h][0] = "" + i + ":15";
			h++;
			horasjtCitas[h][0] = "" + i + ":30";
			h++;
			horasjtCitas[h][0] = "" + i + ":45";
			h++;
		}
 
	    jtCitas = new JTable(horasjtCitas, coljtCitas);
	    //Ajustamos ancho columna hora de cita 
	    jtCitas.getColumnModel().getColumn(0).setMaxWidth(50);
	    jtCitas.setRowHeight(20);
	    jtCitas.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	    //Centramos texto en columna hora de cita 
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    jtCitas.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
	    jtCitas.setColumnSelectionAllowed( false );
	    jtCitas.setRowSelectionAllowed( true );
	    jtCitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    jtCitas.setSelectionForeground( Color.white );
	    jtCitas.setSelectionBackground( Color.red );
	    
	    jspCitas.setViewportView(jtCitas);
	    
		// listener de la selección de la tabla de citas
		ListSelectionModel selectionModel = jtCitas.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
	 	public void valueChanged( ListSelectionEvent event )
	 	{
	 		// comprueba si es una selección válida
			if( event.getSource() == jtCitas.getSelectionModel()
							&& event.getFirstIndex() >= 0 )
			{
				// Obtiene el modelo de datos
				TableModel model = (TableModel)jtCitas.getModel();

				// Determina la celda seleccionada
				String horaCita = (String)model.getValueAt(
						jtCitas.getSelectedRow(), 0);
				//siempre selecionamos la columna 0 que es donde está la hora de la cita		
				//jtCitas.getSelectedColumn() );

				// Visualizamos la hora de la cita
				System.out.println( "Hora de la cita = " + horaCita );
				jtfHoraDeCita.setText(horaCita);
			}
	 	}
		});
	    
		btnAnyadirCita = new JButton("Grabar en BD");
		btnAnyadirCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jcbMedicosCitas.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(new JFrame("Error en médico"),
						    "Antes debe seleccionar un médico.",
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (jtfPacienteCitasNombre.getText().isEmpty() == true) {
					JOptionPane.showMessageDialog(new JFrame("Error en paciente"),
						    "Antes debe seleccionar un paciente.",
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (jdcCalendario.getDate() == null) {
					JOptionPane.showMessageDialog(new JFrame("Error en día"),
						    "Antes debe seleccionar un día.",
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (jtCitas.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(new JFrame("Error en hora"),
						    "Antes debe seleccionar una hora.",
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				TableModel model = (TableModel)jtCitas.getModel();
				
				if (model.getValueAt(jtCitas.getSelectedRow(), 1) != null) {
					JOptionPane.showMessageDialog(new JFrame("Error en hora"),
						    "Esa hora ya está ocupada.",
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				model.setValueAt(jtfPacienteCitasNombre.getText(), jtCitas.getSelectedRow(), 1);
				//Cita cita = new Cita();
				//cita.setMedico(medico);
				//cita.setPaciente(GestorPacientes.leerPacienteBaseDatos(jtfPacienteCitasNumeroSS.getText()));
				//cita.setFecha(jdcCalendario.getDate());
				//GestorCitas.grabarCitaBaseDatos(cita);
			}
		});
		btnAnyadirCita.setBounds(500, 240, 150, 32);
		jpCitas.add(btnAnyadirCita);
		
		btnEliminarCita = new JButton("Eliminar de BD");
		btnEliminarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableModel model = (TableModel)jtCitas.getModel();
				
				if (model.getValueAt(jtCitas.getSelectedRow(), 1) == null) {
					JOptionPane.showMessageDialog(new JFrame("Error en hora"),
						    "No hay ninguna cita a esa hora.",
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				model.setValueAt("", jtCitas.getSelectedRow(), 1);
			}
		});
		btnEliminarCita.setBounds(500, 300, 150, 32);
		jpCitas.add(btnEliminarCita);
		
		////////////////////////////////////////////////////////Tab de Consultas
		JPanel jpConsultas = new JPanel();
		tabbedPane.addTab("Consultas médicas", null, jpConsultas, null);
		jpConsultas.setLayout(null);
		
		btnNuevaConsulta = new JButton("Nueva");
		btnNuevaConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta = new Consulta();
				limpiarDatosConsulta();
			}
		});
		btnNuevaConsulta.setBounds(573, 26, 89, 23);
		jpConsultas.add(btnNuevaConsulta);
		
		
		
		JLabel lblMdico = new JLabel("M\u00E9dico:");
		lblMdico.setBounds(30, 10, 110, 14);
		jpConsultas.add(lblMdico);
		
		jcbMedicos = new JComboBox<Medico>();
		jcbMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarInformeDiagnostico();
			}
		});
		jcbMedicos.setBounds(30, 27, 419, 20);
		jpConsultas.add(jcbMedicos);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setBounds(30, 57, 110, 14);
		jpConsultas.add(lblPaciente);
		
		jcbPacientes = new JComboBox<Paciente>();
		jcbPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarInformeDiagnostico();
			}
		});
		jcbPacientes.setBounds(30, 73, 419, 20);
		jpConsultas.add(jcbPacientes);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(502, 57, 61, 14);
		jpConsultas.add(lblFecha);
		
		jspFecha = new JSpinner();
		jspFecha.setModel(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_YEAR));
		jspFecha.setBounds(530, 73, 132, 20);
		jpConsultas.add(jspFecha);
		
		JLabel lblSintomas = new JLabel("S\u00EDntomas:");
		lblSintomas.setBounds(30, 104, 124, 14);
		jpConsultas.add(lblSintomas);
		
		JScrollPane jspSintomas = new JScrollPane();
		jspSintomas.setBounds(30, 120, 632, 55);
		jpConsultas.add(jspSintomas);
		
		jtxtSintomas = new JTextArea();
		jspSintomas.setViewportView(jtxtSintomas);
		
		JLabel lblEnfermedadDiagnosticada = new JLabel("Enfermedad diagnosticada:");
		lblEnfermedadDiagnosticada.setBounds(30, 187, 156, 14);
		jpConsultas.add(lblEnfermedadDiagnosticada);
		
		jcbEnfermedades = new JComboBox<Enfermedad>();
		jcbEnfermedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarInformeDiagnostico();
			}
		});
		jcbEnfermedades.setBounds(30, 207, 419, 20);
		jpConsultas.add(jcbEnfermedades);
		
		JLabel lblDiagnostico = new JLabel("Informe diagn\u00F3stico:");
		lblDiagnostico.setBounds(30, 238, 198, 14);
		jpConsultas.add(lblDiagnostico);
		
		JScrollPane jspDiagnostico = new JScrollPane();
		jspDiagnostico.setBounds(30, 254, 632, 107);
		jpConsultas.add(jspDiagnostico);
		
		jtxtDiagnostico = new JTextArea();
		jspDiagnostico.setViewportView(jtxtDiagnostico);

		jtabConsulta = new JTabbedPane(JTabbedPane.TOP);
		jtabConsulta.setBounds(30, 370, 632, 265);
		jpConsultas.add(jtabConsulta);
		
		JPanel jpRecetarMedicamento = new JPanel();
		jtabConsulta.addTab("Recetar medicamento", null, jpRecetarMedicamento, null);
		jpRecetarMedicamento.setLayout(null);
		
		
		
		JPanel jpnlRecetas = new JPanel();
		jpnlRecetas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jpnlRecetas.setBounds(21, 122, 585, 104);
		jpRecetarMedicamento.add(jpnlRecetas);
		jpnlRecetas.setLayout(null);
		
		JScrollPane jspRecetas = new JScrollPane();
		jspRecetas.setBounds(21, 24, 450, 87);
		jpRecetarMedicamento.add(jspRecetas);
		
		jlstRecetas = new JList<Receta>();
		jlstRecetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (jlstRecetas.getSelectedIndex() != -1) {
					Receta receta = (Receta) jlstRecetas.getSelectedValue();
					jcbMedicamentos.setSelectedItem(receta.getMedicamento());
					jspFechaInicio.setValue(receta.getFechaInicioTratamiento());
					jspDiasTratamiento.setValue(receta.getDiasDeTratamiento());
					jspDosisDesayuno.setValue(receta.getDosisDesayuno());
					jspDosisComida.setValue(receta.getDosisComida());
					jspDosisCena.setValue(receta.getDosisCena());
				}
			}
		});
		jlstRecetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlstRecetas.setModel(new DefaultListModel<Receta>());
		jspRecetas.setViewportView(jlstRecetas);
		
		JLabel label_6 = new JLabel("Medicamento:");
		label_6.setBounds(21, 11, 109, 14);
		jpnlRecetas.add(label_6);
		
		jcbMedicamentos = new JComboBox<Medicamento>();
		jcbMedicamentos.setBounds(21, 26, 372, 20);
		jpnlRecetas.add(jcbMedicamentos);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio:");
		lblFechaInicio.setBounds(420, 11, 132, 14);
		jpnlRecetas.add(lblFechaInicio);
		
		jspFechaInicio = new JSpinner();
		jspFechaInicio.setModel(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_YEAR));
		jspFechaInicio.setBounds(420, 26, 132, 20);
		jpnlRecetas.add(jspFechaInicio);
		
		JLabel lblDasTratamiento = new JLabel("D\u00EDas tratamiento:");
		lblDasTratamiento.setBounds(21, 57, 109, 14);
		jpnlRecetas.add(lblDasTratamiento);
		
		jspDiasTratamiento = new JSpinner();
		jspDiasTratamiento.setModel(new SpinnerNumberModel(0, 0, null, 1));
		jspDiasTratamiento.setBounds(21, 72, 97, 20);
		jpnlRecetas.add(jspDiasTratamiento);
		
		JLabel lblDosisDesayuno = new JLabel("Dosis desayuno:");
		lblDosisDesayuno.setBounds(167, 57, 109, 14);
		jpnlRecetas.add(lblDosisDesayuno);
		
		jspDosisDesayuno = new JSpinner();
		jspDiasTratamiento.setModel(new SpinnerNumberModel(0, 0, null, 1));
		jspDosisDesayuno.setBounds(167, 72, 97, 20);
		jpnlRecetas.add(jspDosisDesayuno);
		
		JLabel lblDosisComida = new JLabel("Dosis comida:");
		lblDosisComida.setBounds(315, 57, 109, 14);
		jpnlRecetas.add(lblDosisComida);
				
		jspDosisComida = new JSpinner();
		jspDosisComida.setModel(new SpinnerNumberModel(0, 0, null, 1));
		jspDosisComida.setBounds(315, 72, 97, 20);
		jpnlRecetas.add(jspDosisComida);
		
		JLabel lblDosisCena = new JLabel("Dosis cena:");
		lblDosisCena.setBounds(455, 57, 109, 14);
		jpnlRecetas.add(lblDosisCena);
		
		jspDosisCena = new JSpinner();
		jspDosisCena.setModel(new SpinnerNumberModel(0, 0, null, 1));
		jspDosisCena.setBounds(455, 72, 97, 20);
		jpnlRecetas.add(jspDosisCena);
		
		JLabel label_13 = new JLabel("Lista de recetas");
		label_13.setBounds(21, 10, 162, 14);
		jpRecetarMedicamento.add(label_13);
		
		btnRecetar = new JButton("Recetar");
		btnRecetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if (jcbMedicamentos.getSelectedIndex() != -1) {
				if ((int)jspDiasTratamiento.getValue()!=0 && ((int)jspDosisDesayuno.getValue()!=0 || (int)jspDosisComida.getValue()!=0 || (int)jspDosisCena.getValue()!=0)) {
					Receta receta = new Receta();
					receta.setMedicamento((Medicamento)jcbMedicamentos.getSelectedItem());
					receta.setFechaInicioTratamiento((Date) jspFechaInicio.getValue());
					receta.setDiasDeTratamiento((int) jspDiasTratamiento.getValue());
					receta.setDosisDesayuno((int) jspDosisDesayuno.getValue());
					receta.setDosisComida((int) jspDosisComida.getValue());
					receta.setDosisCena((int) jspDosisCena.getValue());
					
					DefaultListModel<Receta> modelo = (DefaultListModel<Receta>) jlstRecetas.getModel();
					
					boolean duplicado = false; 
					Receta rece;
		              for(int i=0;i<modelo.getSize();i++)
		                {
		            	  rece = (Receta) modelo.getElementAt(i);
	                      if ( rece.getMedicamento().getCodigo().equals(receta.getMedicamento().getCodigo()) || rece.getMedicamento().getNombre().toUpperCase().equals(receta.getMedicamento().getNombre().toUpperCase()) ){
		                    	duplicado=true;
	                      }
		                }
		            
		              if (!duplicado) {
						modelo.addElement(receta);
						generarInformeDiagnostico();
						jlstRecetas.setSelectedIndex(modelo.getSize()-1);
						btnEliminarReceta.setEnabled(true);
						btnModificarReceta.setEnabled(true);
		              }
		              else 
						JOptionPane.showMessageDialog(new JFrame("Error añadiendo receta"),
							    "Ya existe una receta con el medicamento " + receta.getMedicamento().getNombre(),
							    "ConsultasMedicas - Error",
							    JOptionPane.ERROR_MESSAGE);
		              }
				 else 
					 JOptionPane.showMessageDialog(new JFrame("Error añadiendo receta"),
					    "No se ha seleccionado los dias de tratamiento o las dosis adecuadas",
					    "ConsultasMedicas - Error",
					    JOptionPane.ERROR_MESSAGE);
	
			}
					
			else 
				 JOptionPane.showMessageDialog(new JFrame("Error añadiendo receta"),
						    "No se ha seleccionado un medicamento",
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
			}
		});
		btnRecetar.setBounds(517, 22, 89, 23);
		jpRecetarMedicamento.add(btnRecetar);
		
		btnModificarReceta = new JButton("Modificar");
		btnModificarReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jlstRecetas.getSelectedIndex() != -1) {
					if ((int)jspDiasTratamiento.getValue()!=0 && ((int)jspDosisDesayuno.getValue()!=0 || (int)jspDosisComida.getValue()!=0 || (int)jspDosisCena.getValue()!=0)) {
					Receta receta = new Receta();
					receta.setMedicamento((Medicamento)jcbMedicamentos.getSelectedItem());
					receta.setFechaInicioTratamiento((Date) jspFechaInicio.getValue());
					receta.setDiasDeTratamiento((int) jspDiasTratamiento.getValue());
					receta.setDosisDesayuno((int) jspDosisDesayuno.getValue());
					receta.setDosisComida((int) jspDosisComida.getValue());
					receta.setDosisCena((int) jspDosisCena.getValue());
					
					DefaultListModel<Receta> modelo = (DefaultListModel<Receta>) jlstRecetas.getModel();
					int i = jlstRecetas.getSelectedIndex();
					modelo.removeElementAt(i);
					modelo.add(i, receta);
					jlstRecetas.setSelectedIndex(i);
					generarInformeDiagnostico();
					}
					else
						 JOptionPane.showMessageDialog(new JFrame("Error añadiendo receta"),
								    "No se ha seleccionado los dias de tratamiento o las dosis adecuadas",
								    "ConsultasMedicas - Error",
								    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModificarReceta.setBounds(517, 54, 89, 23);
		jpRecetarMedicamento.add(btnModificarReceta);
		
		btnEliminarReceta = new JButton("Eliminar");
		btnEliminarReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jlstRecetas.getSelectedIndex() != -1) {
					DefaultListModel<Receta> modelo = (DefaultListModel<Receta>) jlstRecetas.getModel();
					modelo.remove(jlstRecetas.getSelectedIndex());
					limpiarDatosReceta();
					generarInformeDiagnostico();
					if(modelo.getSize() == 0){
						// Como no queda nada en la lista procedemos deshabilitar los botones
						btnEliminarReceta.setEnabled(false);
						btnEliminarReceta.setEnabled(false);
					}
				}
				else 
					JOptionPane.showMessageDialog(new JFrame("Error de selección"),
						    "No se ha seleccionado la receta a borrar.",
						    "ConsultasMedicas - Error",
						    JOptionPane.ERROR_MESSAGE);
			}
		});
		btnEliminarReceta.setBounds(517, 88, 89, 23);
		jpRecetarMedicamento.add(btnEliminarReceta);
	

		JPanel jpRecomendarCuidados = new JPanel();
		jtabConsulta.addTab("Recomendar cuidados", null, jpRecomendarCuidados, null);
		jpRecomendarCuidados.setLayout(null);
		
		JLabel lblCuidados = new JLabel("Cuidados:");
		lblCuidados.setBounds(38, 18, 78, 14);
		jpRecomendarCuidados.add(lblCuidados);
		
		jcbCuidados = new JComboBox<Cuidado>();
		jcbCuidados.setModel(new DefaultComboBoxModel<Cuidado>(Cuidado.values()));
		jcbCuidados.setBounds(39, 34, 200, 20);
		jcbCuidados.setSelectedIndex(-1);
		jpRecomendarCuidados.add(jcbCuidados);
		
		JLabel lblListaDeCuidados = new JLabel("Lista de cuidados recomendados:");
		lblListaDeCuidados.setBounds(377, 18, 199, 14);
		jpRecomendarCuidados.add(lblListaDeCuidados);
		
		JScrollPane jspCuidados = new JScrollPane();
		jspCuidados.setBounds(376, 34, 200, 169);
		jpRecomendarCuidados.add(jspCuidados);
		
		jlstCuidados = new JList<Cuidado>();
		jlstCuidados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlstCuidados.setModel(new DefaultListModel<Cuidado>());
		jspCuidados.setViewportView(jlstCuidados);
		
		btnAnyadirCuidado = new JButton("A\u00F1adir  >");
		btnAnyadirCuidado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbCuidados.getSelectedIndex() != -1) {
					Cuidado cuidado = (Cuidado) jcbCuidados.getSelectedItem();
					DefaultListModel<Cuidado> modelo = (DefaultListModel<Cuidado>) jlstCuidados.getModel();
					
					boolean duplicado = false; 
					Cuidado cuida;
		              for(int i=0;i<modelo.getSize();i++)
		                {
		            	  cuida = (Cuidado) modelo.getElementAt(i);
	                      if ( cuida.toString().toUpperCase().equals(cuidado.toString().toUpperCase()) ){
		                    	duplicado=true;
	                      }
		                }
		            
		              if (!duplicado) {
						modelo.addElement(cuidado);
						generarInformeDiagnostico();
						jlstCuidados.setSelectedIndex(modelo.getSize()-1);
						btnEliminarCuidado.setEnabled(true);
						if (modelo.getSize() == jcbCuidados.getItemCount())
							btnAnyadirCuidado.setEnabled(false);
		              }
		              else 
						JOptionPane.showMessageDialog(new JFrame("Error añadiendo el cuidado"),
							    "Ya se ha seleccionado el cuidado " + cuidado,
							    "ConsultasMedicas - Error",
							    JOptionPane.ERROR_MESSAGE);
				}
		              else
		            	  JOptionPane.showMessageDialog(new JFrame("Error añadiendo el cuidado"),
								    "No se ha seleccionado ningún cuidado" ,
								    "ConsultasMedicas - Error",
								    JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAnyadirCuidado.setToolTipText("A\u00F1ade un cuidado a la lista.");
		btnAnyadirCuidado.setBounds(257, 34, 100, 23);
		jpRecomendarCuidados.add(btnAnyadirCuidado);
		
		btnEliminarCuidado = new JButton("<  Eliminar");
		btnEliminarCuidado.setEnabled(false);
		btnEliminarCuidado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jlstCuidados.getSelectedIndex() != -1) {
					DefaultListModel<Cuidado> modelo = (DefaultListModel<Cuidado>) jlstCuidados.getModel();
					modelo.remove(jlstCuidados.getSelectedIndex());
					generarInformeDiagnostico();
					btnAnyadirCuidado.setEnabled(true);
					if(modelo.getSize() == 0){
						// Como no queda nada en la lista procedemos deshabilitar los botones
						btnEliminarCuidado.setEnabled(false);
					}
				}
	              else
	            	  JOptionPane.showMessageDialog(new JFrame("Error eliminando el cuidado"),
							    "No se ha seleccionado ningún cuidado" ,
							    "ConsultasMedicas - Error",
							    JOptionPane.ERROR_MESSAGE);
			}
		});
		btnEliminarCuidado.setToolTipText("Elimina el cuidado seleccionado de la lista.");
		btnEliminarCuidado.setBounds(257, 68, 100, 23);
		jpRecomendarCuidados.add(btnEliminarCuidado);
	}
	
	/**
	 * MŽtodo que permite actualiazar el contenido de las listas
	 */
	private void actualizarListas(){
		DefaultListModel<Medico> medicos = (DefaultListModel<Medico>)jlstMedicos.getModel();
		medicos.clear();
		jcbMedicos.removeAllItems();
		jcbMedicosCitas.removeAllItems();
		for(Medico med : ConsultasMedicasFacade.getListaMedicos()) {
			medicos.addElement(med);
			jcbMedicos.addItem(med);
			jcbMedicosCitas.addItem(med);
			jcbMedicos.setSelectedIndex(-1);
			jcbMedicosCitas.setSelectedIndex(-1);
		}
		// Comprobamos si hay algun medico
		if(medicos.getSize() == 0){
			btnEliminarMedico.setEnabled(false);
			btnModificarMedico.setEnabled(false);
		}
		
		DefaultListModel<Paciente> pacientes = (DefaultListModel<Paciente>) jlstPacientes.getModel();
		pacientes.clear();
		jcbPacientes.removeAllItems();
		for(Paciente paci : ConsultasMedicasFacade.getListaPacientes()) {
			pacientes.addElement(paci);
			jcbPacientes.addItem(paci);
			jcbPacientes.setSelectedIndex(-1);
		}
		// Comprobamos si hay algun paciente
		if(pacientes.getSize() == 0){
			btnEliminarPaciente.setEnabled(false);
		}
		
		DefaultListModel<Enfermedad> enfermedades = (DefaultListModel<Enfermedad>) jlstEnfermedades.getModel();
		enfermedades.clear();
		jcbEnfermedades.removeAllItems();
		for(Enfermedad enfer : ConsultasMedicasFacade.getListaEnfermedades()) {
			enfermedades.addElement(enfer);
			jcbEnfermedades.addItem(enfer);
			jcbEnfermedades.setSelectedIndex(-1);
		}
		// Comprobamos si hay algun paciente
		if(enfermedades.getSize() == 0){
			btnEliminarEnfermedad.setEnabled(false);
			btnModificarEnfermedad.setEnabled(false);
		}
		
		DefaultListModel<Medicamento> medicamentos = (DefaultListModel<Medicamento>) jlstMedicamentos.getModel();
		medicamentos.clear();
		jcbMedicamentos.removeAllItems();
		for(Medicamento medicam : ConsultasMedicasFacade.getListaMedicamentos()) {
			medicamentos.addElement(medicam);
			jcbMedicamentos.addItem(medicam);
			jcbMedicamentos.setSelectedIndex(-1);
		}
		// Comprobamos si hay algun paciente
		if(medicamentos.getSize() == 0){
			btnEliminarMedicamento.setEnabled(false);
			btnModificarMedicamento.setEnabled(false);
		}
		
	}
	
	private void actualizarListaPacientes(){
		
		DefaultListModel<Paciente> pacientes = (DefaultListModel<Paciente>) jlstPacientes.getModel();
		pacientes.clear();
		jcbPacientes.removeAllItems();
		for(Paciente paci : GestorPacientes.leerListaPacientesBaseDatos()) {
			pacientes.addElement(paci);
			jcbPacientes.addItem(paci);
			jcbPacientes.setSelectedIndex(-1);
		}
		// Comprobamos si hay algun paciente
		if(pacientes.getSize() == 0){
			btnEliminarPaciente.setEnabled(false);
		}
	}
	
	/**
	 * MŽtodo que permite refrescar el contenido del combo de medicos
	 */
	private void actualizarComboMedicos(){
	
		DefaultListModel<Medico> modeloMedicos = (DefaultListModel<Medico>) jlstMedicos.getModel();
		Medico medico;
		jcbMedicos.removeAllItems();
          for(int i=0;i<modeloMedicos.getSize();i++)
            {
        	  medico = (Medico) modeloMedicos.getElementAt(i);
        	  jcbMedicos.addItem(medico);
            }
	}
	
	/**
	 * MŽtodo que permite refrescar el contenido del combo de Pacientes
	 */
	private void actualizarComboPacientes(){
	
 		DefaultListModel<Paciente> modeloPacientes = (DefaultListModel<Paciente>) jlstPacientes.getModel();
  		Paciente paciente;
  		jcbPacientes.removeAllItems();
		for(int i=0;i<modeloPacientes.getSize();i++)
          {
        	paciente = (Paciente) modeloPacientes.getElementAt(i);
        	jcbPacientes.addItem(paciente);
          }
	}
	
	/**
	 * MŽtodo que permite refrescar el contenido del combo de Enfermedades
	 */
	private void actualizarComboEnfermedades(){
	
 		DefaultListModel<Enfermedad> modeloEnfermedades = (DefaultListModel<Enfermedad>) jlstEnfermedades.getModel();
 		Enfermedad enfermedad;
  		jcbEnfermedades.removeAllItems();
		for(int i=0;i<modeloEnfermedades.getSize();i++)
          {
			enfermedad = (Enfermedad) modeloEnfermedades.getElementAt(i);
			jcbEnfermedades.addItem(enfermedad);
          }
	}
	
	/**
	 * MŽtodo que permite refrescar el contenido del combo de Medicamentos
	 */
	private void actualizarComboMedicamentos(){
	
 		DefaultListModel<Medicamento> modeloMedicamentos = (DefaultListModel<Medicamento>) jlstMedicamentos.getModel();
 		Medicamento medicamento;
  		jcbMedicamentos.removeAllItems();
		for(int i=0;i<modeloMedicamentos.getSize();i++)
          {
			medicamento = (Medicamento) modeloMedicamentos.getElementAt(i);
			jcbMedicamentos.addItem(medicamento);
          }
	}
	
	private void generarInformeDiagnostico() {
			String informe ="";
			Medico medico = (Medico) jcbMedicos.getSelectedItem();
			
			if (jcbPacientes.getSelectedIndex()  != -1) {
				Paciente paciente =  (Paciente) jcbPacientes.getSelectedItem();
				informe +=  "Paciente " + paciente;
			}
			
			if (jtxtSintomas.getText().length() != 0)  {
				informe +=  "Presenta los síntomas " +  jtxtSintomas.getText() + "\n";
			}
			else
				if (informe.length()>0) 
					informe += "No presenta sintomas.\n";
				
			if (jcbEnfermedades.getSelectedIndex()  != -1) {
				Enfermedad enfermedad  =  (Enfermedad) jcbEnfermedades.getSelectedItem();
				informe += "Padece " + enfermedad + "\n";
			}
			
			DefaultListModel<Receta> modeloRecetas = (DefaultListModel<Receta>) jlstRecetas.getModel();
			if(modeloRecetas.getSize() > 0){
				Receta receta;
				informe += "Para curarse se le receta los siguientes medicamentos: \n";
				for(int i=0;i<modeloRecetas.getSize();i++)
				{
					receta = (Receta) modeloRecetas.getElementAt(i);
					informe += receta + "\n";
				}
			}
			else
				if (informe.length()>0) 
					informe += "No se le recetan medicamentos.\n";
			
			DefaultListModel<Cuidado> modeloCuidados = (DefaultListModel<Cuidado>) jlstCuidados.getModel();
			if(modeloCuidados.getSize() > 0){
				Cuidado cuidado;
				informe += "Se recomiendan cuidados con ";
				for(int i=0;i<modeloCuidados.getSize();i++)
				{
					cuidado = (Cuidado) modeloCuidados.getElementAt(i);
					informe += cuidado + ", ";
				}
				// para quitar la última coma y añadir el salto de línea
				informe=informe.substring(0, informe.length()-1) + "\n";
			}
			else
				if (informe.length()>0) 
					informe += "No se le recomiendan cuidados adicionales.\n";
			
			
			if (jcbMedicos.getSelectedIndex()  != -1) {
				SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MMM-yyyy");
				SimpleDateFormat sdft=new java.text.SimpleDateFormat("HH:mm");
				Date fecha = (Date) jspFecha.getValue();
				informe += "Firmado el " + sdf.format(fecha) + " a las " + sdft.format(fecha)  + " por "+ medico;
			}
			jtxtDiagnostico.setText(informe);
	}
	
	private void limpiarDatosMedico() {
		jtfMedicoNumero.setText("");
		jtfMedicoNombre.setText("");
		jtfMedicoApellido1.setText("");
		jtfMedicoApellido2.setText("");
		jtfMedicoDni.setText("");
		jcbEspecialidad.setSelectedIndex(-1);
		jcbMedicoSexo.setSelectedIndex(-1);
		jspMedicoFechaNac.setModel(new SpinnerDateModel(new Date(1399845600000L), null, null, Calendar.DAY_OF_YEAR));
		jlstMedicos.setSelectedIndex(-1);
	}

	private void limpiarDatosPaciente() {
		jtfPacienteNumeroSS.setText("");
		jtfPacienteNombre.setText("");
		jtfPacienteApellido1.setText("");
		jtfPacienteApellido2.setText("");
		jtfPacienteDni.setText("");
		jcbPacienteSexo.setSelectedIndex(-1);
		jspPacienteFechaNac.setModel(new SpinnerDateModel(new Date(1399845600000L), null, null, Calendar.DAY_OF_YEAR));
		jlstPacientes.setSelectedIndex(-1);
	}
	
	private void  limpiarDatosEnfermedad() {
		jtfEnfermedadNombre.setText("");
		chckbxContagiosa.setSelected(false);
		chckbxCronica.setSelected(false);
		chckbxHereditaria.setSelected(false);
		chckbxInfecciosa.setSelected(false);
		chckbxDegenerativa.setSelected(false);
	}
	
	private void limpiarDatosMedicamento() {
		jtfMedicamentoCodigo.setText("");
		jtfMedicamentoNombre.setText("");
		chckbxGenerico.setSelected(false);
		jtfLaboratorio.setText("");
		jcbPresentacion.setSelectedIndex(-1);
		jspUnidades.setModel(new SpinnerNumberModel(0, 0, null, 1));
		chckbxVentaConReceta.setSelected(false);
	}
	
	private void limpiarDatosConsulta() {
		
		jcbMedicos.setSelectedIndex(-1);
		jcbPacientes.setSelectedIndex(-1);
		jcbEnfermedades.setSelectedIndex(-1);
		jtxtDiagnostico.setText("");
		jtxtSintomas.setText("");
		jspFecha.setModel(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_YEAR));
		jspFechaInicio.setModel(new SpinnerDateModel(new Date(), null, new Date(), Calendar.DAY_OF_YEAR));
		limpiarDatosReceta();
		DefaultListModel<Receta> modeloRecetas = (DefaultListModel<Receta>) jlstRecetas.getModel();
		modeloRecetas.removeAllElements();
		jcbCuidados.setSelectedIndex(-1);
		DefaultListModel<Cuidado> modeloCuidados = (DefaultListModel<Cuidado>) jlstCuidados.getModel();
		modeloCuidados.removeAllElements();
		jtabConsulta.setSelectedIndex(0);
	}
	
	private void limpiarDatosReceta() {
		jcbMedicamentos.setSelectedIndex(-1);
		jspDiasTratamiento.setModel(new SpinnerNumberModel(0, 0, null, 1));
		jspDosisDesayuno.setModel(new SpinnerNumberModel(0, 0, null, 1));
		jspDosisComida.setModel(new SpinnerNumberModel(0, 0, null, 1));
		jspDosisCena.setModel(new SpinnerNumberModel(0, 0, null, 1));
	}
	
	/**
	 * Método privado que une las operaciones de cierre de la ventana.
	 */
	private void cerrarVentana(){
		
		DefaultListModel<Medico> modeloMedicos = (DefaultListModel<Medico>) jlstMedicos.getModel();
		Medico medico;
		List<Medico> listaMedicos = new  ArrayList<Medico>();
          for(int i=0;i<modeloMedicos.getSize();i++)
            {
        	  medico = (Medico) modeloMedicos.getElementAt(i);
        	  listaMedicos.add(medico);
            }
          ConsultasMedicasFacade.setListaMedicos(listaMedicos);
		
  		DefaultListModel<Paciente> modeloPacientes = (DefaultListModel<Paciente>) jlstPacientes.getModel();
  		Paciente paciente;
  		List<Paciente> listaPacientes = new  ArrayList<Paciente>();
		for(int i=0;i<modeloPacientes.getSize();i++)
          {
        	paciente = (Paciente) modeloPacientes.getElementAt(i);
        	listaPacientes.add(paciente);
          }
        ConsultasMedicasFacade.setListaPacientes(listaPacientes);
          
 		DefaultListModel<Enfermedad> modeloEnfermedades = (DefaultListModel<Enfermedad>) jlstEnfermedades.getModel();
 		Enfermedad enfermedad;
  		List<Enfermedad> listaEnfermedades = new  ArrayList<Enfermedad>();
        for(int i=0;i<modeloEnfermedades.getSize();i++)
          {
        	enfermedad = (Enfermedad) modeloEnfermedades.getElementAt(i);
        	listaEnfermedades.add(enfermedad);
          }
        ConsultasMedicasFacade.setListaEnfermedades(listaEnfermedades);
                
		DefaultListModel<Medicamento> modeloMedicamentos = (DefaultListModel<Medicamento>) jlstMedicamentos.getModel();
		Medicamento medicamento;
  		List<Medicamento> listaMedicamentos = new  ArrayList<Medicamento>();
        for(int i=0;i<modeloMedicamentos.getSize();i++)
          {
        	medicamento = (Medicamento) modeloMedicamentos.getElementAt(i);
        	listaMedicamentos.add(medicamento);
          }
        ConsultasMedicasFacade.setListaMedicamentos(listaMedicamentos);
                
          
		// Llamamos a la finalización del sistema
		boolean finalizacion = ConsultasMedicasFacade.finalizar();
		
		// Si ha habido un problema en la finalizaci—n lo indicamos por pantalla
		if(!finalizacion){
			JOptionPane.showMessageDialog(new JFrame("Error de finalización"),
				    "Error en el proceso de finalización de ConsultasMedicas.\nNo se ha almacenado la información con la que se ha trabajado.",
				    "ConsultasMedicas - Error",
				    JOptionPane.WARNING_MESSAGE);
			// Una vez se ha visualizado el mensaje cerramos la aplicaci—n.
			System.exit(ERROR);
		}
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
