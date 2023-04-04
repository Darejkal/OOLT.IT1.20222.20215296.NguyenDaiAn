// Exercise 5
import javax.swing.JOptionPane;

public class Calculate {
    public static void main(String[] args){
        Double a=Double.parseDouble(JOptionPane.showInputDialog(null, "Please input the first number: ","Input the first number",JOptionPane.INFORMATION_MESSAGE));
        Double b=Double.parseDouble(JOptionPane.showInputDialog(null, "Please input the second number: ","Input the second number",JOptionPane.INFORMATION_MESSAGE));
        String result= String.format("Sum: %f\nDifference: %f\nProduct: %f\nQuotient: %f",a+b,a-b,a*b,a/b);
        JOptionPane.showMessageDialog(null, result, "Calculation Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
