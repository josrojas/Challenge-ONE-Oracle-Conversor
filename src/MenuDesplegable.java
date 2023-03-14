
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuDesplegable extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	private JComboBox<String> opciones;
    private JLabel etiqueta;

    public MenuDesplegable() {
        super("Menú desplegable");
        
        JLabel menu = new JLabel("Seleccione el tipo de conversor:");
        menu.setForeground(Color.WHITE);

        String[] opcionesMenu = {"Monedas", "Temperaturas"};
        opciones = new JComboBox<>(opcionesMenu);
        opciones.addActionListener(this);
        
        JButton btnSalir = new JButton("Salir");

        etiqueta = new JLabel("", SwingConstants.CENTER);
        etiqueta.setVerticalAlignment(SwingConstants.CENTER);

        // Crear el panel de selección de menu y boton salir
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(menu);
        panel.add(opciones);
        panel.add(new JLabel()); 
        panel.add(new JLabel());  
        panel.add(new JLabel());  
        panel.add(btnSalir);
        
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(etiqueta, BorderLayout.SOUTH);
        
        panel.setBackground(new Color(0x19284c));
        
        // Agregar la acción al botón de Salir
        btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object opcionSeleccionada = btnSalir.getActionCommand();
			        if ((opcionSeleccionada.equals("Salir"))) {
			        	System.exit(0);	
	                }
				}
			});
        
        //Contenido de la ventana del programa        
        setTitle("Conversor de Divisas"); //Nombre del programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Salir del programa al cerrar la ventana
        setSize(500, 200); // Definir tamaño de la ventana
        setLocationRelativeTo(null);  // Centrar la ventana
        setVisible(true); //Mostrar la pantalla al usuario
    }
    
    //Accion para llamar al boton
    public void actionPerformed(ActionEvent e) {
        String opcionSeleccionada = (String) opciones.getSelectedItem();

        if (opcionSeleccionada.equals("Monedas")) {
            // Aquí se llama a ConversorMonedas
        	ConversorMonedas conversor = new ConversorMonedas();
        	
        	conversor.Monedas();
        	//Cerrar la ventana de menu
        	setVisible(false);
        	
            
        } else if (opcionSeleccionada.equals("Temperaturas")) {
            // Aquí se llama a ConversorTemperaturas
        	ConversorTemperatura conversor = new ConversorTemperatura();
        	
        	conversor.Temperatura();
        	//Cerrar la ventana de menu
        	setVisible(false);

        } 
    }

    public static void main(String[] args) {
        new MenuDesplegable();
    }
}