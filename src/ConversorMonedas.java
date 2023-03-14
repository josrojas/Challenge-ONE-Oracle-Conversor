
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConversorMonedas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JComboBox<String> MonedaOrigen;
    private JComboBox<String> MonedaDestino;
    private JTextField txtCantidad;
    private JLabel lblResultado;   
    
   
    public void Monedas() {
   
        // Crear los componentes
    	JLabel OrigenMon = new JLabel("Moneda de origen:");
    	OrigenMon.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
    	MonedaOrigen = new JComboBox<>(new String[]{"Dólares", "Euros", "Libras esterlinas", "Yenes japoneses", "Peso mexicano"});
    	
    	JLabel DestinoMon = new JLabel("Moneda de destino:");
    	DestinoMon.setForeground(Color.WHITE);
    	MonedaDestino = new JComboBox<>(new String[]{"Euros", "Dólares", "Libras esterlinas", "Yenes japoneses", "Peso mexicano"});

        JLabel lblCantidad = new JLabel("Ingrese cantidad:");
        lblCantidad.setForeground(Color.WHITE);
        txtCantidad = new JTextField(10);
        
        lblResultado = new JLabel();

        // Crear el botón de conversión
        JButton btnConvertir = new JButton("Convertir");
        
        JButton btnSalir = new JButton("Salir");

        // Crear el panel de selección de monedas y cantidad
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(OrigenMon);
        panel.add(MonedaOrigen);
        panel.add(DestinoMon);
        panel.add(MonedaDestino);
        panel.add(lblCantidad);
        panel.add(txtCantidad);
        panel.add(new JLabel());
        panel.add(btnConvertir);
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
        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar que el campo txtCantidad no esté vacío
                if (txtCantidad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ConversorMonedas.this, "Debe ingresar una cantidad", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Obtener la moneda de origen y destino seleccionadas
                String monedaOrigenSeleccionada = (String) MonedaOrigen.getSelectedItem();
                String monedaDestinoSeleccionada = (String) MonedaDestino.getSelectedItem();

                // Obtener la cantidad a convertir
                double cantidad = Double.parseDouble(txtCantidad.getText());

                // Realizar la conversión adecuada
                double cantidadEnDestino = 0.0;
                switch (monedaOrigenSeleccionada) {
                    case "Dólares":
                        switch (monedaDestinoSeleccionada) {
                            case "Euros":
                                cantidadEnDestino = cantidad * 0.84; // Tasa de cambio a marzo de 2023
                                break;
                            case "Libras esterlinas":
                                cantidadEnDestino = cantidad * 0.72; // Tasa de cambio a marzo de 2023
                                break;
                            case "Yenes japoneses":
                                cantidadEnDestino = cantidad * 109.35; // Tasa de cambio a marzo de 2023
                                break;
                            case "Peso mexicano":
                                cantidadEnDestino = cantidad * 18; // Tasa de cambio a marzo de 2023
                                break;
                        }
                        break;
                    case "Euros":
                        switch (monedaDestinoSeleccionada) {
                            case "Dólares":
                                cantidadEnDestino = cantidad * 1.19; // Tasa de cambio a marzo de 2023
                                break;
                            case "Libras esterlinas":
                                cantidadEnDestino = cantidad * 0.86; // Tasa de cambio a marzo de 2023
                                break;
                            case "Yenes japoneses":
                                cantidadEnDestino = cantidad * 129.58; // Tasa de cambio a marzo de 2023
                                break;
                            case "Peso mexicano":
                                cantidadEnDestino = cantidad * 19.22; // Tasa de cambio a marzo de 2023
                                break;
                        }
                        break;
                    case "Libras esterlinas":
                        switch (monedaDestinoSeleccionada) {
                            case "Dólares":
                                cantidadEnDestino = cantidad * 1.39; // Tasa de cambio a marzo de 2023
                                break;
                            case "Euros":
                                cantidadEnDestino = cantidad * 1.16; // Tasa de cambio a marzo de 2023
                                break;
                            case "Yenes japoneses":
                                cantidadEnDestino = cantidad * 150.25; // Tasa de cambio a marzo de 2023
                                break;
                            case "Peso mexicano":
                                cantidadEnDestino = cantidad * 21.64; // Tasa de cambio a marzo de 2023
                                break;
                        }
                        break;
                    case "Yenes japoneses":
                        switch (monedaDestinoSeleccionada) {
                            case "Dólares":
                                cantidadEnDestino = cantidad * 0.0092; // Tasa de cambio a marzo de 2023
                                break;
                            case "Euros":
                                cantidadEnDestino = cantidad * 0.0077; // Tasa de cambio a marzo de 2023
                                break;
                            case "Libras esterlinas":
                                cantidadEnDestino = cantidad * 0.0067; // Tasa de cambio a marzo de 2023
                                break;
                            case "Peso mexicano":
                                cantidadEnDestino = cantidad * 0.13; // Tasa de cambio a marzo de 2023
                                break;
                        }
                        break;
                    case "Peso mexicano":
                        switch (monedaDestinoSeleccionada) {
                            case "Dólares":
                                cantidadEnDestino = cantidad * 0.056; // Tasa de cambio a marzo de 2023
                                break;
                            case "Euros":
                                cantidadEnDestino = cantidad * 0.052; // Tasa de cambio a marzo de 2023
                                break;
                            case "Libras esterlinas":
                                cantidadEnDestino = cantidad * 0.046; // Tasa de cambio a marzo de 2023
                                break;
                            case "Yenes japoneses":
                                cantidadEnDestino = cantidad * 7.56; // Tasa de cambio a marzo de 2023
                                break;
                        }
                        break;
                }

                // Mostrar el resultado de la conversión
                lblResultado.setText(" El valor es: " + cantidadEnDestino + " " + monedaDestinoSeleccionada);
            }
        });
        
       
        setTitle("Conversor de Monedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
    	new ConversorMonedas();
    }
}