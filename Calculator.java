import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends Frame implements ActionListener {
	Label lb1, lb2, lb3; // only reference.
	TextField txt1, txt2, txt3; // variables are created.
	Button btn1, btn2, btn3, btn4, btnPower, btnReset; // buttons are created.

	public Calculator() // constructor
	{
		lb1 = new Label("num1");
		lb2 = new Label("num2");
		lb3 = new Label("Result");

		txt1 = new TextField(10);
		txt2 = new TextField(10);
		txt3 = new TextField(10);

		btn1 = new Button("Addition");
		btn2 = new Button("Subtraction");
		btn3 = new Button("Multiply");
		btn4 = new Button("Divide");
		btnPower = new Button("Power");
		btnReset = new Button("Reset");

		// added into frame and it is inherited from Frame class
		add(lb1);
		add(lb2);
		add(lb3);

		add(txt1);
		add(txt2);
		add(txt3);

		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btnPower);
		add(btnReset);

		setSize(200, 200); // frame size
		setTitle("My Calculator"); // frame title
		setLayout(new FlowLayout()); // things will be added into frame in the sequence they are coming.
		btn1.addActionListener(this);
		btn2.addActionListener(this); // performs this action
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btnPower.addActionListener(this);
		btnReset.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double a = 0f, b = 0f, c = 0f;
		try {
			a = Double.parseDouble(txt1.getText());
			b = Double.parseDouble(txt2.getText());
		} catch (NumberFormatException exp) {
			txt3.setText("Invalid input");
		}
		if (e.getSource() == btn1) {
			c = a + b;
		} else if (e.getSource() == btn2) // getSource will link to the button we used
		{
			c = a - b;
		} else if (e.getSource() == btn3) {
			c = a * b;
		} else if (e.getSource() == btn4) {
			if (b == 0) {
				try {
					c = a / b;
				} catch (ArithmeticException obj1) {
					txt3.setText("Divide By zero");
				}
			}
			c = a / b;
		} else if (e.getSource() == btnPower) {
			c = Math.pow(a, b);
		} else if (e.getSource() == btnReset) {
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
		}
		txt3.setText(Double.toString(c));
	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.setVisible(true); // it is important
		cal.setLocation(300,300);
	}

}