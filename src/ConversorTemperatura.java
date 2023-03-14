
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConversorTemperatura extends JFrame {
		
	private static final long serialVersionUID = 1L;
	private JComboBox<String> unidadOrigen;
    private JComboBox<String> unidadDestino;
    private JTextField txtTemperatura;
    private JLabel lblResultado;   
    
   
    public void Temperatura() {
   
        // Crear los componentes
    	JLabel OrigenTemp = new JLabel("Temperatura de origen:");
    	OrigenTemp.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
    	unidadOrigen = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
    	
    	JLabel DestinoTemp = new JLabel("Temperatura de destino:");
    	DestinoTemp.setForeground(Color.WHITE);
    	unidadDestino = new JComboBox<>(new String[]{"Fahrenheit", "Celsius", "Kelvin"});

    	
       
        JLabel lblCantidad = new JLabel("Ingrese cantidad:");
        lblCantidad.setForeground(Color.WHITE);
        txtTemperatura = new JTextField(10);
        
        lblResultado = new JLabel();

        // Crear el botón de conversión
        JButton btnConvertirTemp = new JButton("Convertir");
        
        JButton btnSalir = new JButton("Salir");

        // Crear el panel de selección de monedas y cantidad
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(OrigenTemp);
        panel.add(unidadOrigen);
        panel.add(DestinoTemp);
        panel.add(unidadDestino);
        panel.add(lblCantidad);
        panel.add(txtTemperatura);
        panel.add(new JLabel());
        panel.add(btnConvertirTemp);
        panel.add(new JLabel());   
        panel.add(new JLabel());  
        panel.add(new JLabel());  
        panel.add(btnSalir);
        panel.add(new JLabel()); 

    

        // Crear el panel de resultado
        JPanel pnlResultado = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlResultado.add(lblResultado);


        // Agregar los paneles a la ventana
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(pnlResultado, BorderLayout.SOUTH);


        // Cambiar el color de fondo de la ventana
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

        // Agregar la acción al botón de conversión
        btnConvertirTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar que el campo txtTemperatura no esté vacío
                if (txtTemperatura.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ConversorTemperatura.this, "Debe ingresar una temperatura", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Obtener las unidades de temperatura seleccionadas
                String unidadOrigenSeleccionada = (String) unidadOrigen.getSelectedItem();
                String unidadDestinoSeleccionada = (String) unidadDestino.getSelectedItem();

                // Obtener la temperatura a convertir
                double temperatura = Double.parseDouble(txtTemperatura.getText());

                // Realizar la conversión adecuada
                double temperaturaEnDestino = 0.0;
                switch (unidadOrigenSeleccionada) {
                    case "Celsius":
                        switch (unidadDestinoSeleccionada) {
                            case "Fahrenheit":
                                temperaturaEnDestino = (temperatura * 1.8) + 32;
                                break;
                            case "Kelvin":
                                temperaturaEnDestino = temperatura + 273.15;
                                break;
                        }
                        break;
                    case "Fahrenheit":
                        switch (unidadDestinoSeleccionada) {
                            case "Celsius":
                                temperaturaEnDestino = (temperatura - 32) / 1.8;
                                break;
                            case "Kelvin":
                                temperaturaEnDestino = (temperatura + 459.67) * 5/9;
                                break;
                        }
                        break;
                    case "Kelvin":
                        switch (unidadDestinoSeleccionada) {
                            case "Celsius":
                                temperaturaEnDestino = temperatura - 273.15;
                                break;
                            case "Fahrenheit":
                                temperaturaEnDestino = (temperatura * 1.8) - 459.67;
                                break;
                        }
                        break;
                }

            // Actualizar el label con el resultado
            lblResultado.setText(String.format("%.2f %s son %.2f %s", temperatura, unidadOrigenSeleccionada, temperaturaEnDestino, unidadDestinoSeleccionada));
        }

                
        });

        setTitle("Conversor de Temperatura");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
    	new ConversorTemperatura();
    }
}