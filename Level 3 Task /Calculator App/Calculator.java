import java.util.*;

public class Calculator {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		while(true){
        try {
        	
        	System.out.println("Enter the first Number : ");
        	double num1 = sc.nextDouble();
        	
        	System.out.println("Enter the second Number : ");
        	double num2 = sc.nextDouble();
        	
        	System.out.println("Enter any Operator (+, -, *, /)");
        	char oper=sc.next().charAt(0);
        	
        	double output = 0;
        	switch(oper) {
        	
        	case '+':
        		output = num1 + num2;
        		break;
        		
        	case '-':
        		output = num1 - num2;
        		break;
        		
        	case '*':
        		output = num1 * num2;
        		break;
        		
        	case '/':
        		if(num2==0) {
        			throw new ArithmeticException("Cannot divide by zero");
        		}
        		output = num1 / num2;
        		break;
        		
        	default : 
        		System.out.println("Invalid Operator ");
        		return;
        	}
        	
        	System.out.println("Result: " + output);
        }
        
        catch(Exception e) {
        	System.out.println("ERROR : "+ e.getMessage());
        }

		System.out.println("Do you wanna continue with any other operations ? [Y(1)/N(-1)]");
		int yesOrNo=sc.nextInt();
		if(yesOrNo==-1){
			break;
		}
	}

	
    }
}
