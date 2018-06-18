
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    private Container cp;
    private JLabel jlb = new JLabel();
    private JLabel jlb2 = new JLabel();
    private Timer t1;
    private ImageIcon img1 = new ImageIcon("2.jpg");
    private ImageIcon img2 = new ImageIcon("3.jpg");
    public MainFrame(){
        init();
    }
    public void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(50,50,700,800);
        cp = this.getContentPane();
        cp.setLayout(null);

        Image img = img1.getImage();
        Image imga = img.getScaledInstance(220,100,Image.SCALE_SMOOTH);
        img1.setImage(imga);
        jlb.setBounds(200,350,220,100);
        jlb.setIcon(img1);
        cp.add(jlb);

        Image imgb = img2.getImage();
        Image imgc = imgb.getScaledInstance(50, 80, Image.SCALE_SMOOTH);
        img2.setImage(imgc);
        jlb2.setBounds(jlb.getX()+30,jlb.getY(),50,80);

        t1 = new Timer(200, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (jlb2.getY()<0){
                    t1.stop();
                }
                jlb2.setLocation(jlb2.getX(),jlb2.getY()-5);
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                switch (e.getKeyCode()){
                    case 37:
                        jlb.setIcon(img1);
                        jlb.setLocation(jlb.getX()-5,jlb.getY());
                        break;
                    case 39:
                        jlb.setIcon(img1);
                        jlb.setLocation(jlb.getX()+5,jlb.getY());
                        break;

                    case 38:
                        jlb2.setIcon(img2);
                        cp.add(jlb2);
                        jlb2.setLocation(jlb.getX()+30,jlb.getY()-5);
                        t1.start();
                        break;

                }
            }
        });

    }
}
