// Exercise 1
import javax.swing.JOptionPane;
// If users choose Cancel in the first version, the result is No

class ChoosingOption{
    public static void main(String[] args){
        int option=JOptionPane.showConfirmDialog(null, "Do you want to change your first class ticket?");
        // int option=JOptionPane.showConfirmDialog(null, "Do you want to change your first class ticket?","Inquiry",JOptionPane.YES_NO_OPTION);
        // int option=JOptionPane.showOptionDialog(null, "Do you want to change your first class ticket?","Inquiry",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[]{"I do","I don't"},"");
        JOptionPane.showMessageDialog(null, "You have chosen: "+ (option==JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}