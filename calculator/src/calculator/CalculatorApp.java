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

	private JFrame frame;
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
	private boolean go = true; // For calculate with operator != (=)
	private boolean write = true; // Connect numbers in display
	private double value = 0; // Save the value typed for calculation
	
	private Color  red  = new Color(255, 0, 0);
	private Color btnColor = UIManager.getColor("Button.background");
	
	
	private Double x1;
	private Double x2;
	// private boolean first = true;
	private boolean opActive = false;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApp window = new CalculatorApp();
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
	public CalculatorApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		calText = new JTextField();
		calText.setHorizontalAlignment(SwingConstants.RIGHT);
		calText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		calText.setBounds(10, 11, 364, 65);
		frame.getContentPane().add(calText);
		calText.setColumns(10);

		btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//redoFont();
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
		});
		btnC.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnC.setBounds(10, 87, 83, 50);
		frame.getContentPane().add(btnC);
		
		
		
		// <-
		btnBack = new JButton("<-");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(103, 87, 83, 50);
		frame.getContentPane().add(btnBack);
		
		// +
		btnPlus = new JButton("+");
		buttonGroup.add(btnPlus);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(opActive==false && !calText.getText().isEmpty()) {
					x1 = Double.parseDouble(calText.getText());
					calText.setText("");
					btnPlus.setBackground(red);
					opActive = true;
					operator='+';
				}
				
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPlus.setBounds(291, 270, 83, 50);
		frame.getContentPane().add(btnPlus);
		
		// -
		btnMin = new JButton("-");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(opActive==false && !calText.getText().isEmpty()) {
					x1 = Double.valueOf(calText.getText());
					calText.setText("");
					btnMin.setBackground(red);
					opActive = true;
					operator='-';
				}
			}
		});
		buttonGroup.add(btnMin);
		btnMin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMin.setBounds(291, 209, 83, 50);
		frame.getContentPane().add(btnMin);
		
		// X
		btnX = new JButton("X");
		buttonGroup.add(btnX);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(opActive==false && !calText.getText().isEmpty()) {
					x1 = Double.valueOf(calText.getText());
					calText.setText("");
					btnX.setBackground(red);
					opActive = true;
					operator='*';
				}
			}
		});
		btnX.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnX.setBounds(291, 148, 83, 50);
		frame.getContentPane().add(btnX);
		
		// /
		btnDiv = new JButton("/");
		buttonGroup.add(btnDiv);
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(opActive==false && !calText.getText().isEmpty()) {
					x1= Double.valueOf(calText.getText());
					calText.setText("");
					btnDiv.setBackground(red);
					opActive=true;
					operator='/';
				}
			}
		});
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDiv.setBounds(291, 87, 83, 50);
		frame.getContentPane().add(btnDiv);
		
		// %
		btnPerc = new JButton("%");
		btnPerc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPerc.setBounds(196, 87, 83, 50);
		frame.getContentPane().add(btnPerc);
		
		// .
		btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(!calText.getText().contains(".")) {
						calText.setText(calText.getText()+".");
					}
					go = true;
				}
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDot.setBounds(196, 331, 83, 50);
		frame.getContentPane().add(btnDot);
		
		// =
		btnSum = new JButton("=");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		btnSum.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSum.setBounds(291, 331, 83, 50);
		frame.getContentPane().add(btnSum);
		
		// 0
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(Pattern.matches("[0]*", calText.getText())) {
						calText.setText("0");
					} else {
						calText.setText(calText.getText() + "0");
						write = true;
					}
					go = true;
				}
				
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn0.setBounds(10, 331, 176, 50);
		frame.getContentPane().add(btn0);
		
		// 1
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(Pattern.matches("[0]*", calText.getText())) {
						calText.setText("1");
					} else {
						calText.setText(calText.getText() + "1");
						write = true;
					}
					go = true;
				}
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn1.setBounds(10, 270, 83, 50);
		frame.getContentPane().add(btn1);
		
		// 2
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(Pattern.matches("[0]*", calText.getText())) {
						calText.setText("2");
					} else {
						calText.setText(calText.getText() + "2");
					}
				}
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn2.setBounds(103, 270, 83, 50);
		frame.getContentPane().add(btn2);
		
		
		// 3
		btn3 = new JButton("3");
		btn3.setBackground(btnColor);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(Pattern.matches("[0]*", calText.getText())) {
						calText.setText("3");
					} else {
						calText.setText(calText.getText()+"3");
						write = true;
					}
					go = true;
				}
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn3.setBounds(196, 270, 83, 50);
		frame.getContentPane().add(btn3);
		
		// 4
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(Pattern.matches("[0]*", calText.getText())) {
						calText.setText("4");
					} else {
						calText.setText(calText.getText() + "4");
						write = true;
					}
					go = true;
				}
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn4.setBounds(10, 209, 83, 50);
		frame.getContentPane().add(btn4);
		
		
		// 5
		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(Pattern.matches("[0]*", calText.getText())) {
						calText.setText("5");
					} else {
						calText.setText(calText.getText() + "5");
						write = true;
					}
					go = true;
				}
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn5.setBounds(103, 209, 83, 50);
		frame.getContentPane().add(btn5);
		
		// 6
		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(Pattern.matches("[0]*", calText.getText())) {
						calText.setText("6");
					} else {
						calText.setText(calText.getText() + "6");
						write = true;
					}
					go = true;
				}
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn6.setBounds(196, 209, 83, 50);
		frame.getContentPane().add(btn6);
		
		// 7
		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(Pattern.matches("[0]*", calText.getText())) {
						calText.setText("7");
					} else {
						calText.setText(calText.getText() + "7");
						write = true;
					}
					go = true;
				}
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn7.setBounds(10, 148, 83, 50);
		frame.getContentPane().add(btn7);
		
		// 8
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(Pattern.matches("[0]*", calText.getText())) {
						calText.setText("8");
					} else {
						calText.setText(calText.getText() + "8");
						write = true;
					}
					go = true;
				}
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn8.setBounds(103, 148, 83, 50);
		frame.getContentPane().add(btn8);
		
		// 9
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(write) {
					if(Pattern.matches("[0]*", calText.getText())) {
						calText.setText("9");
					} else {
						calText.setText(calText.getText() + "9");
						write = true;
					}
					go = true;
				}
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn9.setBounds(196, 148, 83, 50);
		frame.getContentPane().add(btn9);
	}
	
	
}
