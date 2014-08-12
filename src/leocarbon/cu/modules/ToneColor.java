package leocarbon.cu.modules;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import static leocarbon.cu.ColorUtility.CU;
import static leocarbon.cu.ColorUtility.RB;
import static leocarbon.cu.ColorUtility.cc;
import leocarbon.cu.GUI;
import org.apache.log4j.Logger;

public class ToneColor extends AbstractColorChooserPanel implements ActionListener{
    JButton Darken;
    JButton Lighten;
    JPanel TonePanel;
    
    @Override
    public void updateChooser() {
        
    }

    @Override
    protected void buildChooser() {
        GridBagConstraints c = GUI.initGridBagConstraints();
        
        TonePanel = new JPanel(new GridBagLayout());
        //TonePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Tone Color"));
        
        Lighten = new JButton(RB.getString("TC.brighten"));
        Lighten.setActionCommand("lighten");
        Lighten.addActionListener(this);
        c.gridy = 1;
        TonePanel.add(Lighten,c);
        
        Darken = new JButton(RB.getString("TC.darken"));
        Darken.setActionCommand("darken");
        Darken.addActionListener(this);
        c.gridy = 0;
        TonePanel.add(Darken,c);
        
        add(TonePanel);
    }

    @Override
    public String getDisplayName() {
        return RB.getString("TC");
    }

    @Override
    public Icon getSmallDisplayIcon() {
        return null;
    }

    @Override
    public Icon getLargeDisplayIcon() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent AE) {
        if("lighten".equals(AE.getActionCommand())){
            cc.setColor(cc.getColor().brighter());
            Logger.getLogger(ToneColor.class.getName()).trace("Brightened color");
        } else if("darken".equals(AE.getActionCommand())){
            cc.setColor(cc.getColor().darker());
            Logger.getLogger(ToneColor.class.getName()).trace("Darkened color");
        }
    }
}
