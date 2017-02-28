import java.awt.*;
import java.awt.event.*;

//import java.awt.Color;
//import java.awt.Container;
import javax.swing.*;

/**
 * @author Bear
 *
 */

public class Calculator extends JFrame implements ActionListener {
	JTextField textfield = new JTextField("0");

	public Calculator(String title, int w, int h, Color color) {
		super(title);
		setSize(w, h);
		Container c = this.getContentPane();
		// c.setBackground(color);
		// c.setLayout(new GridLayout(2, 1, 10, 10));
		Font FR = new Font("Times New Roman", Font.BOLD, (int) (w / 100) * (h / 100));
		textfield.setFont(FR);
		textfield.setPreferredSize(new Dimension(w, h / 4));
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		c.add(BorderLayout.NORTH, textfield);
		JPanel p = new JPanel();
		String[] s = { "C", "AC", "Ans", "Back", "7", "8", "9", "/", "4", "5", "6", "¡Á", "1", "2", "3", "-", ".", "0",
				"+", "=" };
		p.setBackground(color);
		p.setLayout(new GridLayout(5, 4, 10, 10));
		Font f = new Font("Arial", Font.BOLD, (int) (w / 120) * (h / 120));
		JButton in[] = new JButton[s.length];
		for (int i = 0; i < s.length; i++) {
			in[i] = new JButton(s[i] + "");
			in[i].setFont(f);
			p.add(in[i]);
			in[i].addActionListener(this);
			textfield.addActionListener(this);
		}
		c.add(BorderLayout.CENTER, p);

		// GridBagLayout for fancier layout where some boxes are bigger than
		// others

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		Calculator w1 = new Calculator("Calculater", 600, 800, Color.YELLOW);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object target = e.getSource();
		String label = e.getActionCommand();
		// if (target == reset)
		// Reset();
		// else if ("0123456789.".indexOf(label) > 0)
		Number(label);
		// else
		// Operator(label);

	}

	boolean isFirstDigit = true;

	public void Number(String num) {
		if (isFirstDigit) {
			textfield.setText(num);
		} else if ((num.equals(".")) && (textfield.getText().indexOf(".")) < 0) {
			textfield.setText(textfield.getText() + ".");
		} else if (!num.equals(".")) {
			textfield.setText(textfield.getText() + num);
		}
		isFirstDigit = false;
	}
}
