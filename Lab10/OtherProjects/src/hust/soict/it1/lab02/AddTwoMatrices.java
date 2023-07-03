package hust.soict.it1.lab02;
//Exercise 7
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Exercise 6
public class AddTwoMatrices {
    public static void main(String[] args){
        int a=getPositiveInt("Assuming the matrices have a size of axb.\nPlease input (a>0):");
        int b=getPositiveInt("Assuming the matrices have a size of axb.\nPlease input (b>0):");
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel inquiry=new JLabel();
        mainPanel.add(inquiry);

        
        ArrayList<JPanel>panels=new ArrayList<JPanel>();
        ArrayList<ArrayList<JTextField>>texts=new ArrayList<ArrayList<JTextField>>();
        for(int i=0;i<a;i++){
            panels.add(new JPanel());
            texts.add(new ArrayList<JTextField>());
            for(int j=0;j<b;j++){
                texts.get(i).add(new JTextField(5));
                panels.get(i).add(texts.get(i).get(j));
            }
            mainPanel.add(panels.get(i));
        }
        boolean flag=false;
        ArrayList<ArrayList<Float>> m1;
        Repeat1:
        while(true){
            inquiry.setText((flag?"Input Error, please try again.\n":"")+"<Input the first matrix>");
            int n=JOptionPane.showConfirmDialog(null,mainPanel, "Input",JOptionPane.OK_CANCEL_OPTION);
            if(n==JOptionPane.CANCEL_OPTION){
                System.exit(0);
            }
            m1=new ArrayList<ArrayList<Float>>();
            for(int i=0;i<a;i++){
                m1.add(new ArrayList<Float>());
                for(int j=0;j<b;j++){
                    try{
                        m1.get(i).add(Float.parseFloat(texts.get(i).get(j).getText()));
                    }catch(Exception e){
                        flag=true;
                        continue Repeat1;
                    }
                }
            }
            break;
        }
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                texts.get(i).get(j).setText(null);
            }
        }
        ArrayList<ArrayList<Float>> m2;
        Repeat2:
        while(true){
            inquiry.setText((flag?"Input Error, please try again. \n":"")+"<Input the second matrix>");
            int n=JOptionPane.showConfirmDialog(null,mainPanel, "Input",JOptionPane.OK_CANCEL_OPTION);
            if(n==JOptionPane.CANCEL_OPTION){
                System.exit(0);
            }
            m2=new ArrayList<ArrayList<Float>>();
            for(int i=0;i<a;i++){
                m2.add(new ArrayList<Float>());
                for(int j=0;j<b;j++){
                    try{
                        m2.get(i).add(Float.parseFloat(texts.get(i).get(j).getText()));
                    }catch(Exception e){
                        flag=true;
                        continue Repeat2;
                    }
                }
            }
            break;
        }
        StringBuilder result=new StringBuilder("The sum of the two inputed matrix is the matrix:\n");
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                // m1.get(i).add(j,m2.get(i).get(j));
                result.append(m1.get(i).get(j)+m2.get(i).get(j));
                result.append(" ");                
            }
            result.append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString(), "Result", JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
    private static int getPositiveInt(String inquiry){
        int n=-1;
        boolean flag=false;
        while(n<1){
            try{
                String temp=JOptionPane.showInputDialog(null, (flag?"Input error, please try again.\n":"")+inquiry);
                if(temp==null){
                    System.exit(0);
                }
                n=Integer.parseInt(temp);
            }catch(NumberFormatException  e){
                continue;
            } 
            finally{
                flag=true;
            }
        }
        return n;
    }
}
