package UD21.junit09.KarimTA21;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Calculadora extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel MuestraResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel numeros = new JPanel();
		numeros.setBounds(10, 115, 212, 117);
		getContentPane().add(numeros);
		JButton[] arrayNums = new JButton[11];
		for (int i = 0; i < arrayNums.length-1; i++) {//añado los numeros del teclado con un for
			arrayNums[i] = new JButton(String.valueOf(i));
			numeros.add(arrayNums[i]);
			arrayNums[i].addActionListener(this);
		}
		JButton teclaComa = new JButton(".");//y la tecla de la coma
		numeros.add(teclaComa);
		teclaComa.addActionListener(this);
		
		JPanel operadores = new JPanel();
		operadores.setBounds(232, 115, 128, 117);
		getContentPane().add(operadores);
		
		JButton suma = new JButton("+");
		operadores.add(suma);
		suma.addActionListener(this);
		JButton resta = new JButton("-");
		operadores.add(resta);
		resta.addActionListener(this);
		JButton producto = new JButton("X");
		operadores.add(producto);
		producto.addActionListener(this);
		JButton division = new JButton("/");
		operadores.add(division);
		division.addActionListener(this);
		JButton borrar = new JButton("C");
		operadores.add(borrar);
		borrar.addActionListener(this);
		JButton igual = new JButton("=");
		operadores.add(igual);
		igual.addActionListener(this);
		
		JPanel resultado = new JPanel();
		resultado.setBounds(61, 10, 268, 51);
		getContentPane().add(resultado);
		
		JLabel mostrar = new JLabel(" ");
		resultado.add(mostrar);
		MuestraResultado = mostrar;
	}
	
	public void actionPerformed(ActionEvent e) {
	      String command = e.getActionCommand();
	      if (command.charAt(0) == 'C') {                      
	    	  MuestraResultado.setText("");
	      }else if (command.charAt(0) == '=') {                    
	    	  MuestraResultado.setText(calcular(MuestraResultado.getText()));
	      }else {                                
	    	  MuestraResultado.setText(MuestraResultado.getText() + command);
	      }
	   }
	public static String calcular(String operacion) {
	      char[] arr = operacion.toCharArray();
	      String operand1 = "";String operand2 = "";String operator = "";
	      double result = 0;

	      for (int i = 0; i < arr.length; i++) {
	         if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
	            if(operator.isEmpty()){
	               operand1 += arr[i];
	            }else{
	               operand2 += arr[i];
	            }
	         }  

	         if(arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == 'X') {
	            operator += arr[i];
	         }
	      }

	      if (operator.equals("+"))
	         result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
	      else if (operator.equals("-"))
	         result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
	      else if (operator.equals("/"))
	         result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
	      else
	         result = (Double.parseDouble(operand1) * Double.parseDouble(operand2));          
	      return operand1 + operator + operand2 + "=" +result;
	   }    
}
