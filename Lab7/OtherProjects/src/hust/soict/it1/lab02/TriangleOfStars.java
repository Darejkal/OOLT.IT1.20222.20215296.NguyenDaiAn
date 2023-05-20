package hust.soict.it1.lab02;
// Exercise 4
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TriangleOfStars {
    public static void main(String args[]){
        int n=Integer.parseInt(JOptionPane.showInputDialog(null, "Input the height n:","0"));
        List<String> result=new ArrayList<String>();
        if(n>=1){
            String temp="*";
            result.add(temp);
            for(int i=1;i<n;i++){
                for(int j=0;j<result.size();j++){
                    result.set(j, "&nbsp"+result.get(j)+"&nbsp");
                }
                temp="*"+temp+"*";
                result.add(temp);
            }
        }
        String prt="<html>";
        for(String x:result){
            prt+=x+"<br/>";
        }
        prt+="</html>";
        JLabel label=new JLabel(prt);
        label.setFont(new Font("Courier", Font.PLAIN, 18));
        JOptionPane.showMessageDialog(null,label, "Result",JOptionPane.INFORMATION_MESSAGE);
    }
}
