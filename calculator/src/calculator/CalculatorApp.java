package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.OptionalDouble;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class CalculatorApp {

	private JFrame frmCalculator;
	private JTextField calText;
	private JButton btn0;
	private JButton btnBack;
	private JButton btnPerc;
	private JButton btnDiv;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnX;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btnMin;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btnPlus;
	private JButton btnDot;
	private JButton btnSum;
	private JButton btnC;
	
	private char operator = ' '; // Save the operator
	private boolean write = true; // Connect numbers in display
	private double value = 0; // Save the value typed for calculation
	
	private Color  red  = new Color(255, 0, 0);
	private Color btnColor = UIManager.getColor("Button.background");
	
	
	private Double x1;
	private Double x2;
	private boolean opActive = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApp window = new CalculatorApp();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 400, 430);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		calText = new JTextField();
		calText.setHorizontalAlignment(SwingConstants.RIGHT);
		calText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calText.setBounds(10, 11, 364, 65);
		frmCalculator.getContentPane().add(calText);
		calText.setColumns(10);

		btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelAction();
			}
		});
		btnC.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnC.setBounds(10, 87, 83, 50);
		frmCalculator.getContentPane().add(btnC);
		
		// <-
		btnBack = new JButton("<-");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				backAction();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(103, 87, 83, 50);
		frmCalculator.getContentPane().add(btnBack);
		
		// +
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operatorAction('+', btnPlus);		
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPlus.setBounds(291, 270, 83, 50);
		frmCalculator.getContentPane().add(btnPlus);
		
		// -
		btnMin = new JButton("-");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operatorAction('-', btnMin);
			}
		});
		btnMin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMin.setBounds(291, 209, 83, 50);
		frmCalculator.getContentPane().add(btnMin);
		
		// X
		btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operatorAction('*', btnX);
			}
		});
		btnX.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnX.setBounds(291, 148, 83, 50);
		frmCalculator.getContentPane().add(btnX);
		
		// /
		btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operatorAction('/', btnDiv);
			}
		});
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDiv.setBounds(291, 87, 83, 50);
		frmCalculator.getContentPane().add(btnDiv);
		
		// %
		btnPerc = new JButton("%");
		btnPerc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPerc.setBounds(196, 87, 83, 50);
		frmCalculator.getContentPane().add(btnPerc);
		
		// .
		btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dotAction();
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDot.setBounds(196, 331, 83, 50);
		frmCalculator.getContentPane().add(btnDot);
		
		// =
		btnSum = new JButton("=");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sumAction();
			}
		});
		btnSum.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSum.setBounds(291, 331, 83, 50);
		frmCalculator.getContentPane().add(btnSum);
		
		// 0
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numAction(0);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn0.setBounds(10, 331, 176, 50);
		frmCalculator.getContentPane().add(btn0);
		
		// 1
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numAction(1);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn1.setBounds(10, 270, 83, 50);
		frmCalculator.getContentPane().add(btn1);
		
		// 2
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numAction(2);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn2.setBounds(103, 270, 83, 50);
		frmCalculator.getContentPane().add(btn2);
		
		
		// 3
		btn3 = new JButton("3");
		btn3.setBackground(btnColor);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numAction(3);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn3.setBounds(196, 270, 83, 50);
		frmCalculator.getContentPane().add(btn3);
		
		// 4
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numAction(4);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn4.setBounds(10, 209, 83, 50);
		frmCalculator.getContentPane().add(btn4);
		
		// 5
		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numAction(5);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn5.setBounds(103, 209, 83, 50);
		frmCalculator.getContentPane().add(btn5);
		
		// 6
		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numAction(6);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn6.setBounds(196, 209, 83, 50);
		frmCalculator.getContentPane().add(btn6);
		
		// 7
		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numAction(7);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn7.setBounds(10, 148, 83, 50);
		frmCalculator.getContentPane().add(btn7);
		
		// 8
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numAction(8);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn8.setBounds(103, 148, 83, 50);
		frmCalculator.getContentPane().add(btn8);
		
		// 9
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numAction(9);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn9.setBounds(196, 148, 83, 50);
		frmCalculator.getContentPane().add(btn9);
	}
	
	
	private void numAction(int num) {
		String i = Integer.toString(num);
		if(write) {
			if(Pattern.matches("[0]*", calText.getText())) {
				calText.setText(i);
			} else {
				calText.setText(calText.getText() + i);
				write = true;
			}
		}
	}
	
	private void dotAction() {
		if(write) {
			if(!calText.getText().contains(".")) {
				calText.setText(calText.getText()+".");
			}
		}
	}
	
	private void backAction() {
		String str = calText.getText();
		StringBuilder str2 = new StringBuilder();
		for (int i = 0; i < str.length()-1; i++) {
			str2.append(str.charAt(i));
			System.out.println(str.charAt(i));
		}
		if(str2.toString().equals("")) {
			calText.setText("0");
		} else {
			calText.setText(str2.toString());
		}
	}
	
	private void cancelAction() {
		calText.setText("0");
		operator = ' ';
		value = 0;
		x1 = 0.0;
		x2 = 0.0;
		opActive=false;
		btnDiv.setBackground(btnColor);
		btnMin.setBackground(btnColor);
		btnPlus.setBackground(btnColor);
		btnX.setBackground(btnColor);
		btnPerc.setBackground(btnColor);
	}
	
	private void operatorAction(Character op, JButton btn) {
		if(opActive==false && !calText.getText().isEmpty()) {
			x1 = Double.parseDouble(calText.getText());
			calText.setText("");
			btn.setBackground(red);
			opActive = true;
			operator=op;
		}
	}
	
	private void sumAction() {
		if(opActive == true) {
			switch (operator) {
			case '+':
				x2 = Double.valueOf(calText.getText());
				value = x1+x2;
				System.out.println(x1 + "" + operator + "" + x2);
				System.out.println(value);
				x1=null;
				x2=null;
				calText.setText(value+"");
				btnDiv.setBackground(btnColor);
				btnMin.setBackground(btnColor);
				btnPlus.setBackground(btnColor);
				btnX.setBackground(btnColor);
				btnPerc.setBackground(btnColor);
				opActive = false;
				operator=' ';
				break;
				
			case '-':
				x2 = Double.valueOf(calText.getText());
				value = x1-x2;
				System.out.println(x1 + "" + operator + "" + x2);
				System.out.println(value);
				x1=null;
				x2=null;
				calText.setText(value+"");
				btnDiv.setBackground(btnColor);
				btnMin.setBackground(btnColor);
				btnPlus.setBackground(btnColor);
				btnX.setBackground(btnColor);
				btnPerc.setBackground(btnColor);
				opActive = false;
				operator=' ';
				break;
			
			case '/':
				x2 = Double.valueOf(calText.getText());
				value = x1/x2;
				System.out.println(x1 + "" + operator + "" + x2);
				System.out.println(value);
				x1=null;
				x2=null;
				calText.setText(value+"");
				btnDiv.setBackground(btnColor);
				btnMin.setBackground(btnColor);
				btnPlus.setBackground(btnColor);
				btnX.setBackground(btnColor);
				btnPerc.setBackground(btnColor);
				opActive = false;
				operator=' ';
				break;
				
			case '*':
				x2 = Double.valueOf(calText.getText());
				value = x1*x2;
				System.out.println(x1 + "" + operator + "" + x2);
				System.out.println(value);
				x1=null;
				x2=null;
				calText.setText(value+"");
				btnDiv.setBackground(btnColor);
				btnMin.setBackground(btnColor);
				btnPlus.setBackground(btnColor);
				btnX.setBackground(btnColor);
				btnPerc.setBackground(btnColor);
				opActive = false;
				operator=' ';
				break;
			
			default:
				JOptionPane.showMessageDialog(null, "Choose an operator!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
