import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Canvas;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.BoxLayout;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

	private boolean existenCambios=false;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JTextPane textPane = new JTextPane();
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(existenCambios==true) {
					int vRes=JOptionPane.showConfirmDialog(null, "Existen cambios. ¿Desea Guardarlos?");
					if(vRes==JOptionPane.CANCEL_OPTION) {
						
					}
					if(vRes==JOptionPane.NO_OPTION) {
						frame.dispose();//cerrar ventana
					}
					if(vRes==JOptionPane.YES_OPTION){
						
						JFileChooser fileChooser = new JFileChooser();
						int seleccion = fileChooser.showSaveDialog(textPane);
						if (seleccion == JFileChooser.APPROVE_OPTION)
						{
							//
							File directorios = fileChooser.getSelectedFile();//new File("D:\\2o Ciclo Superior\\Desarrollo de Interfaces\\EditTexto");
					        
					        
					        try {
					            String ruta =directorios.getAbsolutePath();// "D:\\2o Ciclo Superior\\Desarrollo de Interfaces\\EditTexto\\fichero.txt";
					            String contenido = textPane.getText();
					            File file = new File(ruta);
					            // Si el archivo no existe es creado
					            if (!file.exists()) 
					            {
					                file.createNewFile();
					            }
					            
					            FileWriter fw = new FileWriter(file);
					            BufferedWriter bw = new BufferedWriter(fw);
					            
					            bw.write(contenido);
					            bw.close();
					            
					        } catch (Exception ex) {
					            ex.printStackTrace();
					        }
						}
					}
				}
				else 
				{
					frame.dispose();//cerrar ventana
				}
			}
		});
		frame.setBounds(100, 100, 706, 477);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		
		
		textPane.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				existenCambios=true;
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				existenCambios=true;
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		frame.getContentPane().add(textPane, BorderLayout.CENTER);
		
		JPanel Menu = new JPanel();
		frame.getContentPane().add(Menu, BorderLayout.NORTH);
		Menu.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar_1 = new JMenuBar();
		Menu.add(menuBar_1,BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("Fichero");
		menuBar_1.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Nuevo");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Abrir");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				int seleccion = fileChooser.showOpenDialog(textPane);
				if (seleccion == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = fileChooser.getSelectedFile();
					try {
						FileReader reader = new FileReader(selectedFile);
						FileWriter fw = new FileWriter(selectedFile);
						int ch;
				        while ((ch = reader.read()) != -1)
						{
							
				        	 System.out.print((char)ch);
				           fw.write(ch);
							
						}
				        reader.close();
				        fw.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Guardar");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Guardar como");
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				int seleccion = fileChooser.showSaveDialog(textPane);
				if (seleccion == JFileChooser.APPROVE_OPTION)
				{
					//
					File directorios = fileChooser.getSelectedFile();//new File("D:\\2o Ciclo Superior\\Desarrollo de Interfaces\\EditTexto");
			        
			        
			        try {
			            String ruta =directorios.getAbsolutePath();// "D:\\2o Ciclo Superior\\Desarrollo de Interfaces\\EditTexto\\fichero.txt";
			            String contenido = textPane.getText();
			            File file = new File(ruta);
			            // Si el archivo no existe es creado
			            if (!file.exists()) 
			            {
			                file.createNewFile();
			            }
			            
			            FileWriter fw = new FileWriter(file);
			            BufferedWriter bw = new BufferedWriter(fw);
			            
			            bw.write(contenido);
			            bw.close();
			            
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
				}
				
				
			}
		});
		
		
		
		JMenu mnNewMenu_1 = new JMenu("Editor");
		menuBar_1.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Seleccionar Fuente");
		mnNewMenu_1.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("CC Wild Words");
		mnNewMenu_2.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Font miEstilo = new Font("CC Wild Words", 0, 22);
				textPane.setFont(miEstilo);
				
			}
		});
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Arial");
		mnNewMenu_2.add(mntmNewMenuItem_8);
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
				Font miEstilo2 = new Font("Arial", 0, 16);
				textPane.setFont(miEstilo2);
				
			}
		});
		
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Cortar");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.cut();
			}
		});
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Copiar");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.copy();
			}
		});
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Pegar");
		mnNewMenu_1.add(mntmNewMenuItem_7);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.paste();
			}
		});
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		Menu.add(toolBar);
		
		JButton BotonNuevo = new JButton("");
		BotonNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(existenCambios==true) {
					int vRes=JOptionPane.showConfirmDialog(null, "Existen cambios. ¿Desea Guardarlos?");
					if(vRes==JOptionPane.CANCEL_OPTION) {
						
					}
					if(vRes==JOptionPane.NO_OPTION) {
						textPane.setText(null); //pone el editor en blanco
					}
					if(vRes==JOptionPane.YES_OPTION){
						
						JFileChooser fileChooser = new JFileChooser();
						int seleccion = fileChooser.showSaveDialog(textPane);
						if (seleccion == JFileChooser.APPROVE_OPTION)
						{
							//
							File directorios = fileChooser.getSelectedFile();//new File("D:\\2o Ciclo Superior\\Desarrollo de Interfaces\\EditTexto");
					        
					        
					        try {
					            String ruta =directorios.getAbsolutePath();// "D:\\2o Ciclo Superior\\Desarrollo de Interfaces\\EditTexto\\fichero.txt";
					            String contenido = textPane.getText();
					            File file = new File(ruta);
					            // Si el archivo no existe es creado
					            if (!file.exists()) 
					            {
					                file.createNewFile();
					            }
					            
					            FileWriter fw = new FileWriter(file);
					            BufferedWriter bw = new BufferedWriter(fw);
					            
					            bw.write(contenido);
					            bw.close();
					            
					        } catch (Exception ex) {
					            ex.printStackTrace();
					        }
						}
					}
				}
				else 
				{
					//frame.dispose();//cerrar ventana
				}
			}
		});
		BotonNuevo.setIcon(new ImageIcon("C:\\Users\\FP\\Desktop\\create-black-18dp\\1x\\baseline_create_black_18dp.png"));
		toolBar.add(BotonNuevo);
		
		
		JButton BotonGuardar = new JButton("");
		BotonGuardar.setIcon(new ImageIcon("C:\\Users\\FP\\Desktop\\save-black-18dp\\1x\\baseline_save_black_18dp.png"));
		toolBar.add(BotonGuardar);
		BotonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				int seleccion = fileChooser.showSaveDialog(textPane);
				if (seleccion == JFileChooser.APPROVE_OPTION)
				{
					//
					File directorios = fileChooser.getSelectedFile();//new File("D:\\2o Ciclo Superior\\Desarrollo de Interfaces\\EditTexto");
			        
			        
			        try {
			            String ruta =directorios.getAbsolutePath();// "D:\\2o Ciclo Superior\\Desarrollo de Interfaces\\EditTexto\\fichero.txt";
			            String contenido = textPane.getText();
			            File file = new File(ruta);
			            // Si el archivo no existe es creado
			            if (!file.exists()) 
			            {
			                file.createNewFile();
			            }
			            
			            FileWriter fw = new FileWriter(file);
			            BufferedWriter bw = new BufferedWriter(fw);
			            
			            bw.write(contenido);
			            bw.close();
			            
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
				}
				
				
			}
		});
		
		
		
		JButton BotonCortar = new JButton("");
		BotonCortar.setIcon(new ImageIcon("C:\\Users\\FP\\Desktop\\content_cut-black-18dp\\1x\\baseline_content_cut_black_18dp.png"));
		toolBar.add(BotonCortar);
		BotonCortar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.cut();
			}
		});
		
		
		JButton BotonCopiar = new JButton("");
		BotonCopiar.setIcon(new ImageIcon("C:\\Users\\FP\\Desktop\\content_copy-black-18dp\\1x\\baseline_content_copy_black_18dp.png"));
		toolBar.add(BotonCopiar);
		BotonCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.copy();
			}
		});
		
		JButton BotonPegar = new JButton("");
		BotonPegar.setIcon(new ImageIcon("C:\\Users\\FP\\Desktop\\content_paste-black-18dp\\1x\\baseline_content_paste_black_18dp.png"));
		toolBar.add(BotonPegar);
		BotonPegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.paste();
			}
		});
		
	}

}
