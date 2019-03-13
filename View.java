/**
 * 
 * @author Nick Bauer
 * @version View
 * ITEC 220
 * Project 2
 * 
 */
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;


public class View extends JFrame
{
	private static final long serialVersionUID = 1L;

	private JFrame f = new JFrame("Stack Calculator");
	private JPanel p = new JPanel();
	
	private JTextField num1 = new JTextField(20);
	private JTextField num2 = new JTextField(20);
	private JTextField result = new JTextField(20);
	private JTextField resultStack = new JTextField(20);
	
	private JButton addJB = new JButton("+");
	private JButton subJB = new JButton("-");
	
	private JLabel label1 = new JLabel("Please Enter First Integer: ");
	private JLabel label2 = new JLabel("Please Enter Second Integer: ");
	private JLabel resultLabel = new JLabel("Actual Arithmatic Answer: ");
	private JLabel resultStackLabel = new JLabel("Answer Using Stack: ");
	
	private final int FRAMESIZEX = 290;
	private final int FRAMESIZEY = 350;
	private final int BUTTONSIZE = 50;
	private final int LABELFONTSIZE = 20;
	private final int BORDERSIZE = 5;
	
	public View()
	{
		f.setPreferredSize(new Dimension(FRAMESIZEX,FRAMESIZEY));
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setResizable(false);
		setFrameStyle();
		
		p.add(label1);
		p.add(num1);
		p.add(label2);
		p.add(num2);
		p.add(addJB);
		p.add(subJB);
		p.add(resultLabel);
		p.add(result);
		p.add(resultStackLabel);
		p.add(resultStack);
		
		f.add(p);
		f.pack();
		f.setVisible(true);
	}
	
	public void setStackString(String str)
	{
		resultStack.setText(str);
	}
	
	/**
	 * getNum1
	 * 
	 * @return first user integer input
	 */
	public int getNum1()
	{
		return Integer.parseInt(num1.getText());
	}
	
	/**
	 * getNum2
	 * 
	 * @return second user integer input
	 */
	public int getNum2()
	{
		return Integer.parseInt(num2.getText());
	}
	
	/**
	 * 
	 * NOT NEEDED FOR PROJECT
	 * 
	 */
	public void setAddResult(int addResult)
	{
		result.setText(Integer.toString(addResult));
	}
	
	/**
	 * 
	 * NOT NEEDED FOR PROJECT
	 * 
	 */
	public void setSubResult(int subResult)
	{
		result.setText(Integer.toString(subResult));
	}
	
	/**
	 * addAdditionListener
	 * 
	 * @param ActionListener passed in from Controller
	 * sets ActionListener for "+" JButton
	 */
	public void addAdditionListener(ActionListener listenAdd)
	{
		addJB.addActionListener(listenAdd);
	}
	
	/**
	 * addSubtractionListener
	 * 
	 * @param ActionListener passed in from Controller
	 * sets ActionListener for "-" JButton
	 */
	public void addSubtractionListener(ActionListener listenSub)
	{
		subJB.addActionListener(listenSub);
	}
	
	/**
	 * setFrameStyle
	 * 
	 * sets sizes & styles of elements on JFrame
	 */
	public void setFrameStyle()
	{
		Font labelFont = new Font("Impact", Font.BOLD, LABELFONTSIZE);
		Dimension buttonSize = new Dimension(BUTTONSIZE,BUTTONSIZE);
		addJB.setPreferredSize(buttonSize);
		subJB.setPreferredSize(buttonSize);
		label1.setFont(labelFont);
		label2.setFont(labelFont);
		resultLabel.setFont(labelFont);
		resultStackLabel.setFont(labelFont);
		p.setBackground(Color.BLUE);
		p.setOpaque(true);
		p.setBorder(BorderFactory.createLineBorder(Color.red, BORDERSIZE));
	}
	
}
