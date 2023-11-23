package calculator;

import javax.swing.JFrame;

public class Frame {
	JFrame frame = new JFrame("Simple Calculator");
	Frame()
	{
		frame.add(PanelJ.panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500,350);
	    frame.setResizable(true);
	    frame.setLayout(null);
		frame.setVisible(true);
	
	}

}
