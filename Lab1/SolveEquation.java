// Exercise 6

import javax.swing.JOptionPane;

public class SolveEquation {
    public static void main(String[] args){
        String strStart="Select the type of equation:\nPress 1 for the first degree equation (linear equation) with one variable\nPress 2 for the first degree equation (linear equation) with two variables\nPress 3 for the second degree equation with one variable\n Press any other keys for termination.";
        
        int eq=-1;
        try{
            eq= Integer.parseInt(JOptionPane.showInputDialog(null, strStart,"Start",JOptionPane.INFORMATION_MESSAGE));
        } catch(Exception e){
            System.exit(0);
        }
        switch(eq){
            case 1:
                firstDegree("x");
                break;
            case 2:
                firstDegreeTwoParameters();
                break;
            case 3:
                secondDegree();
                break;
            default:
        }
        System.exit(0);

    }
    private static void firstDegree(String x){
        Double a=Double.parseDouble(JOptionPane.showInputDialog(null, "a"+x+"+b=0\nPlease input (a): ","Input",JOptionPane.INFORMATION_MESSAGE));
        Double c=Double.parseDouble(JOptionPane.showInputDialog(null, "a"+x+"+b=0\nPlease input (b): ","Input",JOptionPane.INFORMATION_MESSAGE));
        firstDegree_inner(x, a, c);
    }
    private static void firstDegree_inner(String x, Double a, Double c){
        String result="";
        if(a!=0){
            result = String.format("Found %s=%f!",x,-c/a);
        } else if(c==0) {
            result = "There is an infinite number of solutions for this problem!";
        } else {
            result = "There is no solution for this problem!";
        }
        JOptionPane.showMessageDialog(null, result, "Solution", JOptionPane.INFORMATION_MESSAGE);
    }
    private static void firstDegreeTwoParameters(){
        Double a=Double.parseDouble(JOptionPane.showInputDialog(null, "ax+by+c=0\nPlease input (a): ","Input",JOptionPane.INFORMATION_MESSAGE));
        Double b=Double.parseDouble(JOptionPane.showInputDialog(null, "ax+by+c=0\nPlease input (b): ","Input",JOptionPane.INFORMATION_MESSAGE));
        Double c=Double.parseDouble(JOptionPane.showInputDialog(null, "ax+by+c=0\nPlease input (c): ","Input",JOptionPane.INFORMATION_MESSAGE));
        if(a==0){
            firstDegree_inner("y", b, c);
        } else if(b==0) {
            firstDegree_inner("x", a, c);
        } else {
            JOptionPane.showMessageDialog(null, String.format("Found x=%fy%s%f!",-b/a,-c/a>0?"-":"",-c/a), "Solution", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static void secondDegree(){
        Double a=Double.parseDouble(JOptionPane.showInputDialog(null, "ax^2+bx+c=0\nPlease input (a): ","Input",JOptionPane.INFORMATION_MESSAGE));
        Double b=Double.parseDouble(JOptionPane.showInputDialog(null, "ax^2+bx+c=0\nPlease input (b): ","Input",JOptionPane.INFORMATION_MESSAGE));
        Double c=Double.parseDouble(JOptionPane.showInputDialog(null, "ax^2+bx+c=0\nPlease input (c): ","Input",JOptionPane.INFORMATION_MESSAGE));
        if(a==0){
            firstDegree_inner("x", b, c);
        } else {
            Double delta = b*b-4*a*c;
            String result="";
            if(delta<0){
                result = "There is an infinite number of solutions for this problem!";
            } else if(delta==0){
                result = String.format("Found x=%f", -b/(2*a));
            } else {
                result = String.format("Found x1=%f, x2=%f", (-b+Math.sqrt(delta))/(2*a),(-b-Math.sqrt(delta))/(2*a));
            }
            JOptionPane.showMessageDialog(null, result, "Solution", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
