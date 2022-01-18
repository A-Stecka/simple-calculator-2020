import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JTextField TEXT = new JTextField(20);
    private JButton bERASE = new JButton("WYCZYŚĆ");
    private JButton bONE = new JButton("1");
    private JButton bTWO = new JButton("2");
    private JButton bTHREE = new JButton("3");
    private JButton bFOUR = new JButton("4");
    private JButton bFIVE = new JButton("5");
    private JButton bSIX = new JButton("6");
    private JButton bSEVEN = new JButton("7");
    private JButton bEIGHT = new JButton("8");
    private JButton bNINE = new JButton("9");
    private JButton bZERO = new JButton("0");
    private JButton bDOT = new JButton(".");
    private JButton bEQUAL = new JButton("=");
    private JButton bDIVISION = new JButton("%");
    private JButton bMULTIPLICATION = new JButton("x");
    private JButton bMINUS = new JButton("-");
    private JButton bPLUS = new JButton("+");
    private JPanel pTEXT = new JPanel();
    private JPanel pBUTTONS = new JPanel();
    private JOptionPane pERROR = new JOptionPane();
    private Model model;

    public GUI(Model model){
        this.model = model;

        this.setTitle("Kalkulator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);

        TEXT.setEditable(false);
        TEXT.setText(model.getIVALUE());
        TEXT.setHorizontalAlignment(SwingConstants.RIGHT);
        pTEXT.setLayout(new GridLayout(1, 2));
        pTEXT.add(bERASE);
        pTEXT.add(TEXT);

        pBUTTONS.setLayout(new GridLayout(4, 4));
        pBUTTONS.add(bONE);
        pBUTTONS.add(bTWO);
        pBUTTONS.add(bTHREE);
        pBUTTONS.add(bDIVISION);
        pBUTTONS.add(bFOUR);
        pBUTTONS.add(bFIVE);
        pBUTTONS.add(bSIX);
        pBUTTONS.add(bMULTIPLICATION);
        pBUTTONS.add(bSEVEN);
        pBUTTONS.add(bEIGHT);
        pBUTTONS.add(bNINE);
        pBUTTONS.add(bMINUS);
        pBUTTONS.add(bZERO);
        pBUTTONS.add(bDOT);
        pBUTTONS.add(bEQUAL);
        pBUTTONS.add(bPLUS);

        this.getContentPane().add(BorderLayout.NORTH, pTEXT);
        this.getContentPane().add(BorderLayout.CENTER, pBUTTONS);
        this.setVisible(true);
    }

    public void reset(){
        TEXT.setText(model.getIVALUE());
    }

    public void setTEXT(String text){
        TEXT.setText(text);
    }

    public void addTEXT(String text){
        StringBuilder s = new StringBuilder(TEXT.getText());
        s.append(text);
        TEXT.setText(s.toString());
    }

    public String getTEXT(){
        return TEXT.getText();
    }

    public void addListener(String name, ActionListener A){
        if(name.equals("bERASE")) bERASE.addActionListener(A);
        if(name.equals("bONE")) bONE.addActionListener(A);
        if(name.equals("bTWO")) bTWO.addActionListener(A);
        if(name.equals("bTHREE")) bTHREE.addActionListener(A);
        if(name.equals("bFOUR")) bFOUR.addActionListener(A);
        if(name.equals("bFIVE")) bFIVE.addActionListener(A);
        if(name.equals("bSIX")) bSIX.addActionListener(A);
        if(name.equals("bSEVEN")) bSEVEN.addActionListener(A);
        if(name.equals("bEIGHT")) bEIGHT.addActionListener(A);
        if(name.equals("bNINE")) bNINE.addActionListener(A);
        if(name.equals("bZERO")) bZERO.addActionListener(A);
        if(name.equals("bDOT")) bDOT.addActionListener(A);
        if(name.equals("bEQUAL")) bEQUAL.addActionListener(A);
        if(name.equals("bDIVISION")) bDIVISION.addActionListener(A);
        if(name.equals("bMULTIPLICATION")) bMULTIPLICATION.addActionListener(A);
        if(name.equals("bMINUS")) bMINUS.addActionListener(A);
        if(name.equals("bPLUS")) bPLUS.addActionListener(A);
    }

    public void showError(String text) {
        pERROR.showMessageDialog(this, text, "Błąd", JOptionPane.ERROR_MESSAGE);
    }
}
