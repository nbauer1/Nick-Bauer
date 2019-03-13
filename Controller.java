/**
 * 
 * @author Nick Bauer
 * @version Controller
 * ITEC 220
 * Project 2
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller 
{
	private View theView;
	private Model theModel;;
	
	public Controller(View theView, Model theModel)
	{
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addAdditionListener(new addListener());
		this.theView.addSubtractionListener(new subListener());
	}
	
	/**
	 * class addListener
	 * 
	 * Listener added to perform action when "+" button is pushed
	 */
	public class addListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg)
		 {
			int addNum1 = 0;
			int addNum2 = 0;
			try {
				addNum1 = theView.getNum1();
				addNum2 = theView.getNum2();
				
				//not needed
				theModel.add(addNum1, addNum2);
				theModel.clearStacks();
				
				theModel.setStack1(addNum1);
				theModel.setStack2(addNum2);
				theModel.setAdditionStackResult();
				theModel.reverseStackResult();
				theModel.setAdditionStackResultFinal();
				
				//not needed
				theView.setAddResult(theModel.getAddResult());
				theView.setStackString(theModel.stackToString());
			} catch (NumberFormatException e) {
				System.out.println("Two Positive Integers Need to be Entered");
			}
		 }
	}
	
	/**
	 * class subListener
	 * 
	 * Listener added to perform action when "-" button is pushed
	 */
	public class subListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg)
		 {
			int subNum1 = 0;
			int subNum2 = 0;
			try {
				subNum1 = theView.getNum1();
				subNum2 = theView.getNum2();
				
				//not needed
				theModel.sub(subNum1, subNum2);
				theModel.clearStacks();
				
				theModel.setStack1(subNum1);
				theModel.setStack2(subNum2);
				theModel.setSubtractionStackResult();
				theModel.reverseStackResult();
				theModel.setSubtractionStackResultFinal();
				
				//not needed
				theView.setSubResult(theModel.getSubResult());
				theView.setStackString(theModel.stackToString());
			} catch (NumberFormatException e) {
				System.out.println("Two Positive Integers Need to be Entered");
			}
		 }
	}
}
