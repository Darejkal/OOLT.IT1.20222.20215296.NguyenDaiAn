package hust.soict.it1.lab02;
import java.util.ArrayList;

import javax.swing.JOptionPane;

// Exercise 6
public class OperatingOnArray {
    public static void main(String[] args){
        ArrayList<Float> arr=new ArrayList<Float>();
        int n=-1;
        boolean flag=false;
        while(n<0){
            try{
                String temp=JOptionPane.showInputDialog(null, (flag?"Input error, please try again.\n":"")+"Please input the number of parameters:");
                if(temp==null){
                    System.exit(0);
                }
                n=Integer.parseInt(temp);
            }catch(NumberFormatException  e){
                flag=true;
                continue;
            } 
        }
        for(int i=0;i<n;i++){
            flag =false;
            float holder;
            while(true){
                try{
                    String temp=JOptionPane.showInputDialog(null, (flag?"Input error, please try again.\n":"")+String.format("Please input the element No.%d of the array:", i+1));
                    if(temp==null){
                        System.exit(0);
                    }
                    holder=Float.parseFloat(temp);
                    break;
                } catch(NumberFormatException  e){
                    flag=true;
                    continue;
                }
            }
            arr.add(holder);
        }
        StringBuilder result= new StringBuilder("Sorted Array:\n");
        arr.sort(null);
        float sum=0;
        for(float x: arr){
            result.append(String.valueOf(x));
            result.append(", ");
            sum+=x;
        }
        result.delete(result.length()-2,result.length()); //remove the last ", "
        result.append(String.format("\nSum = %f\nAverage = %f", sum,sum/arr.size()));
        JOptionPane.showMessageDialog(null, result, "Result",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
