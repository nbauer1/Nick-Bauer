/**
 * 
 * @author Nick Bauer
 * @version Model
 * ITEC 220
 * Project 2
 * 
 */
import java.util.Stack;

/*
 * TO-DO
 * methods < 30 lines
 * rewrite setFinal methods to be shorter and add JavaDoc
 * 
 * EMAIL CHASE AND ASK:
 * 		do we have to be able to account for negative results?
 * 		do we have to allow negative inputs?
 * 
 * BUGS
 
stack1: [5, 6]
stack2: [6, 7]
stackResult: [13, 11]
stackResultADDFinal: [3, 2]
stackToString: 23

supposed to be 123 so if statement added to setAdditionStackResultFinal

stack1: [8, 8, 8, 8]
stack2: [8, 8, 8, 9]
stackResult: [-1, 0, 0, 0]
stackResultSUBFinal: [9, 9, 9, 9]
stack1: [9, 8, 8, 8]
stack2: [8, 8, 8, 9]
stackResult: [-1, 0, 0, 1]
stackResultSUBFinal: [8, 9, 9, 0]
stack1: [9, 8, 8, 8]
stack2: [8, 8, 8, 9]
stackResult: [-1, 0, 0, 1]
stackResultSUBFinal: [9, 9, 9, 0]

leftover borrow from getting negative number? 
 */

public class Model 
{
	private int addResult;
	private int subResult;
	
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	private Stack<Integer> stackResult = new Stack<Integer>();
	private Stack<Integer> stackResultFinal = new Stack<Integer>();
	
	private int carry = 0;
	private int borrow = 0;
	
	/**
	 * stackToString
	 * 
	 *  pops stackResultFinal to add to String to be displayed on calculator
	 * @return String of final stack
	 */
	public String stackToString()
	{
		String result = "";
		while (!stackResultFinal.empty())
		{
			result += stackResultFinal.pop();
		}
		result = deleteZeros(result);
		
		return result;
	}
	/**
	 * deleteZeros
	 * 
	 * deletes any excess 0's from stackResultSUBFinal
	 * @param result
	 * @return revised String if any extra 0's precede the solution
	 */
	public String deleteZeros(String result)
	{
		while(result.charAt(0) == '0')
		{
			String str = result;
			StringBuilder buildStr = new StringBuilder(str);
			buildStr.deleteCharAt(0);
			result = buildStr.toString();
		}
		return result;
	}
	
	/**
	 * reverseStackResult
	 * 
	 * resets stackResult to be in reverse order
	 */
	public void reverseStackResult()
	{
		Stack<Integer> stackResultRev = new Stack<Integer>();
		while(!stackResult.empty())
		{
			int num = stackResult.pop();
			stackResultRev.push(num);
		}
		stackResult = stackResultRev;
	}
	
	/**
	 * 
	 * NOT NEEDED FOR ACTRUAL PROJECT
	 * 
	 */
	public void add(int addNum1, int addNum2)
	{
		addResult = addNum1 + addNum2;
	}
	
	/**
	 * 
	 * NOT NEEDED FOR ACTRUAL PROJECT
	 * 
	 */
	public void sub(int subNum1, int subNum2)
	{
		subResult = subNum1 - subNum2;
	}
	
	/**
	 * setStack1
	 * 
	 * sets first stack using usser's input integer from JTextField
	 * @param num1
	 */
	public void setStack1(int num1)
	{
		String str = Integer.toString(num1);
		for(int i = 0; i < str.length(); i++)
		{
			int pushNum = Character.getNumericValue(str.charAt(i));
			stack1.push(pushNum);
		}
		System.out.println("stack1: " + stack1);
	}
	
	/**
	 * setStack2
	 * 
	 * sets second stack using usser's input integer from JTextField
	 * @param num2
	 */
	public void setStack2(int num2)
	{
		String str = Integer.toString(num2);
		for(int i = 0; i < str.length(); i++)
		{
			int pushNum = Character.getNumericValue(str.charAt(i));
			stack2.push(pushNum);
		}
		System.out.println("stack2: " + stack2);
	}
	
	public void setAdditionStackResultFinal()
	{
		while(!stackResult.empty())
		{
			int num = stackResult.pop();
			if(num + carry < 10)
			{
				if(carry == 0)
				{
					stackResultFinal.push(num);
				}
				else
				{
					stackResultFinal.push(num + carry);
					carry = 0;
				}
			}
			else
			{
				if(carry == 0)
				{
					num = num - 10;
					stackResultFinal.push(num);
				}
				else
				{
					num = (num + carry) - 10;
					stackResultFinal.push(num);
					carry = 0;
				}
				carry = 1;
			}
			if(stackResult.empty() && carry == 1)
			{
				stackResultFinal.push(carry);
				carry = 0;
			}
		}
		System.out.println("stackResultADDFinal: " + stackResultFinal);
	}
	
	// if 0 in ones place then 10 is pushed
	public void setSubtractionStackResultFinal()
	{
		while(!stackResult.empty())
		{
			int num = stackResult.pop();
			if(num - borrow >= 0)
			{
				if(borrow == 0)
				{
					stackResultFinal.push(num);
				}
				else
				{
					stackResultFinal.push(num - borrow);
					borrow = 0;
				}
			}
			else
			{
				if(borrow == 0)
				{
					num = num + 10;
					stackResultFinal.push(num);
				}
				else
				{
					num = (num - borrow) + 10;
					stackResultFinal.push(num);
					borrow = 0;
				}
				borrow = 1;
			}
			if(stackResult.empty() && borrow == 1)
			{
				borrow = 0;
			}
		}
		System.out.println("stackResultSUBFinal: " + stackResultFinal);
	}
	
	/**
	 * setAdditionStackResult
	 * 
	 * sets addition solutions in stackResult 
	 */
	public void setAdditionStackResult()
	{
		while(!stack1.empty() || !stack2.empty())
		{
			int resultNum = getAddResultNum();
			stackResult.push(resultNum);
		}
		System.out.println("stackResult: " + stackResult);
	}
	
	/**
	 * setSubtractionStackResult
	 * 
	 * sets subtraction solutions in stackResult 
	 */
	public void setSubtractionStackResult()
	{
		while(!stack1.empty() || !stack2.empty())
		{
			int resultNum = getSubResultNum();
			stackResult.push(resultNum);
		}
		System.out.println("stackResult: " + stackResult);
	}
	
	/**
	 * getAddResultNum
	 * 
	 * finds int to be pushed in setAdditionStackResult()
	 * @return int from addition solution
	 */
	public int getAddResultNum()
	{
		int resultNum = 0;
		if(!stack1.empty() && !stack2.empty())
		{
			resultNum = stack1.pop() + stack2.pop();
		}
		else if(!stack1.empty())
		{
			resultNum = stack1.pop();
		}
		else if(!stack2.empty())
		{
			resultNum = stack2.pop();
		}
		return resultNum;
	}
	
	/**
	 * getSubResultNum
	 * 
	 * finds int to be pushed in setSubtractionStackResult()
	 * @return int from subtraction solution
	 */
	public int getSubResultNum()
	{
		int resultNum = 0;
		if(!stack1.empty() && !stack2.empty())
		{
			resultNum = stack1.pop() - stack2.pop();
		}
		else if(!stack1.empty())
		{
			resultNum = stack1.pop();
		}
		else if(!stack2.empty())
		{
			resultNum = stack2.pop();
		}
		return resultNum;
	}
	
	/**
	 * 
	 * NOT NEEDED FOR ACTRUAL PROJECT
	 * 
	 */
	public int getAddResult()
	{
		return addResult;
	}
	
	/**
	 * 
	 * NOT NEEDED FOR ACTRUAL PROJECT
	 * 
	 */
	public int getSubResult()
	{
		return subResult;
	}
	
	/**
	 * clearStacks
	 * 
	 * clears all stacks for reuse of calculator
	 */
	public void clearStacks()
	{
		stack1.clear();
		stack2.clear();
		stackResult.clear();
		stackResultFinal.clear();
	}
}
