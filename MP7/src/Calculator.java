import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Calculator extends JFrame{
	
	private JTextField displayField;
	
	private CalculatorFunctions functions = new CalculatorFunctions();
	
	private boolean startNumber = true;
	private String prevOperation = "=";
	
	
	public Calculator() {
		
		//sets attributes for the calculator top panel
		displayField = new JTextField("0", 12);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        
		//creates new panel to hold number buttons
		JPanel numberPanel = new JPanel();
		//adds buttons in a grid layout with 5 rows, 3 columns
		numberPanel.setLayout(new GridLayout(5, 3));
		
		ActionListener numberListener = new NumberListener();
		
		MyKeyListener typedListener = new MyKeyListener();
		
		//creates new panel to hold operator buttons
		JPanel operatorPanel = new JPanel();
		//sets layout for the operator panel with 5 rows and 1 column
        operatorPanel.setLayout(new GridLayout(5,1));
        
        ActionListener operatorListener = new OperatorListener();
		
		//creates new panel to hold clear button
		JPanel clearPanel = new JPanel();
		//sets layout so that the button stretches horizontally across the screen
		clearPanel.setLayout(new FlowLayout());
		
		ActionListener clearListener = new ClearListener();
		
		//creates new panel to hold all the other panels and the text field component
		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new BorderLayout(5, 5));
		//adds display field on top
		bigPanel.add(displayField, BorderLayout.NORTH);
	    //adds all the other panels
		bigPanel.add(numberPanel, BorderLayout.CENTER);
		bigPanel.add(operatorPanel, BorderLayout.EAST);
		bigPanel.add(clearPanel, BorderLayout.SOUTH);
		
//		JPanel bigPanel = new JPanel();
//		GridBagLayout gridbag = new GridBagLayout();
//		GridBagConstraints c = new GridBagConstraints();
//		c.fill = GridBagConstraints.CENTER;
//		bigPanel.setLayout(gridbag);
//		
//		bigPanel.add(displayField);
//		bigPanel.add(numberPanel);
//		bigPanel.add(operatorPanel);
//		bigPanel.add(clearPanel);
		
		
		
		//creates all the buttons with specified numbers and adds them to the number panel
		JButton butt1 = new JButton("1");
		butt1.setForeground(Color.WHITE);
		butt1.setBackground(new Color(59, 89, 182));
		numberPanel.add(butt1);
		//butt1.addKeyListener(typedListener);
		butt1.addActionListener(numberListener);
		
		
		JButton butt2 = new JButton("2");
		butt2.setForeground(Color.WHITE);
		butt2.setBackground(new Color(59, 89, 182));
		numberPanel.add(butt2);
		butt2.addActionListener(numberListener);
		
		JButton butt3 = new JButton("3");
		butt3.setForeground(Color.WHITE);
		butt3.setBackground(new Color(59, 89, 182));
		numberPanel.add(butt3);
		butt3.addActionListener(numberListener);
		
		JButton butt4 = new JButton("4");
		butt4.setForeground(Color.WHITE);
		butt4.setBackground(new Color(59, 89, 182));
		numberPanel.add(butt4);
		butt4.addActionListener(numberListener);
		
		JButton butt5 = new JButton("5");
		butt5.setForeground(Color.WHITE);
		butt5.setBackground(new Color(59, 89, 182));
		numberPanel.add(butt5);
		butt5.addActionListener(numberListener);
		
		JButton butt6 = new JButton("6");
		butt6.setForeground(Color.WHITE);
		butt6.setBackground(new Color(59, 89, 182));
		numberPanel.add(butt6);
		butt6.addActionListener(numberListener);
		
		JButton butt7 = new JButton("7");
		butt7.setForeground(Color.WHITE);
		butt7.setBackground(new Color(59, 89, 182));
		numberPanel.add(butt7);
		butt7.addActionListener(numberListener);
		
		JButton butt8 = new JButton("8");
		butt8.setForeground(Color.WHITE);
		butt8.setBackground(new Color(59, 89, 182));
		numberPanel.add(butt8);
		butt8.addActionListener(numberListener);
		
		JButton butt9 = new JButton("9");
		butt9.setForeground(Color.WHITE);
		butt9.setBackground(new Color(59, 89, 182));
		numberPanel.add(butt9);
		butt9.addActionListener(numberListener);
		
		//fake button for nicer format
		JButton buttonEmpty = new JButton();
		buttonEmpty.setEnabled(false);
		numberPanel.add(buttonEmpty);
		
		JButton butt0 = new JButton("0");
		butt0.setForeground(Color.WHITE);
		butt0.setBackground(new Color(59, 89, 182));
		numberPanel.add(butt0);
		butt0.addActionListener(numberListener);
		
		//second fake button
		JButton buttonEmpty2 = new JButton();
		buttonEmpty2.setEnabled(false);
		numberPanel.add(buttonEmpty2);
		
		
		//create operator buttons and adds operator listener to them
		JButton divbutt = new JButton("/");
		divbutt.setForeground(Color.WHITE);
		divbutt.setBackground(new Color(255, 128, 0));
		operatorPanel.add(divbutt);
		divbutt.addActionListener(operatorListener);
		
		JButton multbutt = new JButton("x");
		multbutt.setForeground(Color.WHITE);
		multbutt.setBackground(new Color(255, 128, 0));
		operatorPanel.add(multbutt);
		multbutt.addActionListener(operatorListener);
		
		JButton subbutt = new JButton("-");
		subbutt.setForeground(Color.WHITE);
		subbutt.setBackground(new Color(255, 128, 0));
		operatorPanel.add(subbutt);
		subbutt.addActionListener(operatorListener);
		
		JButton addbutt = new JButton("+");
		addbutt.setForeground(Color.WHITE);
		addbutt.setBackground(new Color(255, 128, 0));
		operatorPanel.add(addbutt);
		addbutt.addActionListener(operatorListener);
		
		JButton equalbutt = new JButton("=");
		equalbutt.setForeground(Color.WHITE);
		equalbutt.setBackground(new Color(255, 128, 0));
		operatorPanel.add(equalbutt);
		equalbutt.addActionListener(operatorListener);
		
		//makes clear button
		JButton clearbutt = new JButton("AC");  
	    clearPanel.add(clearbutt);
	    clearbutt.addActionListener(clearListener);
	    
	    //displays window
	    this.setContentPane(bigPanel);
        this.pack();
        this.setTitle("Simple Calc");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
		
	}
	
	private void clear() {
		startNumber = true;
		displayField.setText("0");
		prevOperation = "=";
		functions.setTotal("0");
	}
	
	class MyKeyListener implements KeyListener {
		
		private int getInfo(KeyEvent e) {
			//char c = e.getKeyChar();
			int keyCode = e.getKeyCode();
			return keyCode;
		}
		public void keyTyped(KeyEvent e) {
			String number = getInfo(e) + "";
			 //String number = e.getActionCommand();
	            if (startNumber) {
	                //if this is the first number, sets the displayField to that number
	                displayField.setText(number);
	                startNumber = false;
	            } else {
	                //adds this number onto the string of numbers
	                displayField.setText(displayField.getText() + number);
	            }
		}
		
		public void keyPressed(KeyEvent e) {
			//displayInfo(e, "key pressed: ");
			
		}
		
		public void keyReleased(KeyEvent e) {
			//displayInfo(e, "key released: ");
		}
		
	}
	class NumberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String number = e.getActionCommand();
            if (startNumber) {
                //if this is the first number, sets the displayField to that number
                displayField.setText(number);
                startNumber = false;
            } else {
                //adds this number onto the string of numbers
                displayField.setText(displayField.getText() + number);
            }
        }
	}
	
	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clear();		
		}
	}
        
        class OperatorListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
//                // The calculator is always in one of two states.
//                // 1. A number must be entered -- an operator is wrong.
//                // 2. An operator must be entered.
               // if no number has been added yet, you can't use an operator
            	if (startNumber) {
                    clear();
                    displayField.setText("ERROR - Enter a number.");
                } else {
                    startNumber = true;
//                        // Get value from display field, convert, do prev op
//                        // If this is the first op, _previousOp will be =.
                    String currNumber = displayField.getText();
                    
                    if (prevOperation.equals("=")) {
                        functions.setTotal(currNumber);
                    } else if (prevOperation.equals("+")) {
                        functions.add(currNumber);
                    } else if (prevOperation.equals("-")) {
                        functions.subtract(currNumber);
                    } else if (prevOperation.equals("x")) {
                        functions.multiply(currNumber);
                    } else if (prevOperation.equals("/")) {
                        functions.divide(currNumber);
                    } 
                    
                    
                    displayField.setText("" + functions.getTotalString());

                    prevOperation = e.getActionCommand();
                }
            }
       }
        
        
        public static void main(String[] args) {
        	Calculator window = new Calculator();
        	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	window.setVisible(true);
        }
	

}
