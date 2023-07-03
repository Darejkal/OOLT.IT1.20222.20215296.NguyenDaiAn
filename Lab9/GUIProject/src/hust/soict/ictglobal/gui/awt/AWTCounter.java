package hust.soict.ictglobal.gui.awt;
import java.awt.*;        
import java.awt.event.*;  
public class AWTCounter extends Frame {
    private Label lblCount;    
    private TextField tfCount; 
    private Button btnCount;
    private Thread timeoutThread;
    private int count = 0;
    public void setTimeout(Runnable runnable, int delay){
        timeoutThread=new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                //DO NOTHING
            }
        });
        timeoutThread.start();
    }

    public AWTCounter () {
        setLayout(new FlowLayout());
        lblCount = new Label("Counter");  
        add(lblCount);                    
        tfCount = new TextField(count + "", 10); 
        tfCount.setEditable(false);       
        add(tfCount);                     
        btnCount = new Button("Count");
        btnCount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                var clicks=e.getClickCount();
                if(clicks%2==1){
                    setTimeout(()->{count++;tfCount.setText(count + "");},200);
                } else{
                    if(timeoutThread!=null){
                        timeoutThread.interrupt();
                    }
                    count--;
                    tfCount.setText(count + "");
                }
            }
        });
        add(btnCount);
//        btnCount.addActionListener(this);
        setTitle("AWT Counter");  
        setSize(250, 100);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        AWTCounter app = new AWTCounter();
    }
//    @Override
//    public void windowClosing(WindowEvent e){
//        System.exit(0);
//    }
}
