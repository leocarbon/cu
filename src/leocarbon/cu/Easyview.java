package leocarbon.cu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static leocarbon.cu.ColorUtility.A;
import static leocarbon.cu.ColorUtility.evpanel;
import static leocarbon.cu.GUI.Monaco18;
import static leocarbon.cu.GUI.initGridBagConstraints;
import leocarbon.cu.handlers.ActionHandler;

public class Easyview extends JPanel {
    public static JLabel evr = new JLabel("Loading...",JLabel.CENTER);
    public static JLabel evg = new JLabel("Loading...",JLabel.CENTER);
    public static JLabel evb = new JLabel("Loading...",JLabel.CENTER);
    public static JLabel evh = new JLabel("Loading...",JLabel.CENTER);
    public static JLabel evha = new JLabel("Loading...",JLabel.CENTER);
    
    public static int r, g, b;
    public static String hex, ahex;
    public static String rgb, rgba;
    
    public static void updateEv(Color input) {
        r = input.getRed();
        g = input.getGreen();
        b = input.getBlue();
        
        hex = Integer.toHexString(input.getRGB());
        hex = hex.substring(2, hex.length()).toUpperCase();
        ahex = Integer.toHexString(input.getRGB()).toUpperCase();
        
        rgba = Integer.toString(input.getRGB());
        
        if(ActionHandler.isEasyViewTextVisible == true){
            evr.setText("<html>Red<br>" + r + "</html>");
            evb.setText("<html>Green<br>" + g + "</html>");
            evg.setText("<html>Blue<br>" + b + "</html>");
            evh.setText("<html>Hexadecimal [RGB] <br>#" + hex + "</html>");
            evha.setText("<html>Hexadecimal [aRGB] <br>0x" + ahex + "</html>");
        } else {
            evr.setText(null);
            evb.setText(null);
            evg.setText(null);
            evh.setText(null);
            evha.setText(null);
        }
        
        evr.setBackground(input);
        evg.setBackground(input);
        evb.setBackground(input);
        evh.setBackground(input);
        evha.setBackground(input);
            
        if(r >= 192 || g >= 192 || b >= 192 ){
            evr.setForeground(input.darker().darker().darker());
            evg.setForeground(input.darker().darker().darker());
            evb.setForeground(input.darker().darker().darker());
            evh.setForeground(input.darker().darker().darker());
            evha.setForeground(input.darker().darker().darker());
            
        } else if((r == 0 && g == 0 && b == 0)
                ||(r <= 64 && g == 0 && b == 0)
                ||(g <= 64 && b == 0 && r == 0)
                ||(b <= 64 && r == 0 && g == 0)
                ||(r <= 64 && g <= 64 && b == 0)
                ||(g <= 64 && b <= 64 && r == 0)
                ||(b <= 64 && r <= 64 && g == 0)
                ||(r <= 32 && b <=32 && g <= 32)){
            evr.setForeground(Color.WHITE);
            evg.setForeground(Color.WHITE);
            evb.setForeground(Color.WHITE);
            evh.setForeground(Color.WHITE);
            evha.setForeground(Color.WHITE);
        } else {
            evr.setForeground(input.brighter().brighter().brighter());
            evg.setForeground(input.brighter().brighter().brighter());
            evb.setForeground(input.brighter().brighter().brighter());
            evh.setForeground(input.brighter().brighter().brighter());
            evha.setForeground(input.brighter().brighter().brighter());
        }
        if(A != null && A.isVisible()){
            SwingUtilities.invokeLater(new Runnable() { @Override public void run() {
                A.setColors();
            }});
        }
    }
    
    public static void createEasyview() {
        GridBagConstraints c = initGridBagConstraints();
        
        evr.setFont(Monaco18);
        evr.setOpaque(true);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        evpanel.add(evr,c);
        
        evg.setFont(Monaco18);
        evg.setOpaque(true);
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        evpanel.add(evg,c);
        
        evb.setFont(Monaco18);
        evb.setOpaque(true);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        evpanel.add(evb,c);
        
        evh.setFont(Monaco18);
        evh.setOpaque(true);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.weightx = 0.75;
        c.weighty = 0.75;
        evpanel.add(evh,c);
        
        evha.setFont(Monaco18);
        evha.setOpaque(true);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.weightx = 0.8;
        c.weighty = 0.8;
        evpanel.add(evha,c);
    }
}