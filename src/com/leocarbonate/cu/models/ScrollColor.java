package com.leocarbonate.cu.models;

import com.leocarbonate.cu.ColorUtility;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.SwingWorker;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ScrollColor extends AbstractColorChooserPanel implements ActionListener, ChangeListener{
    JToggleButton scroll;
    JToggleButton brightnessScroll;
    JToggleButton saturationScroll;
    JSlider scrollSpeed;
    JSlider brightnessScrollSpeed;
    JSlider saturationScrollSpeed;
    JPanel scrollPanel;
    
    scrolljob job;
    bscrolljob bjob;
    sscrolljob sjob;
    
    int hr, hg, hb;
    int sr, sg, sb;
    int br, bg, bb;
    float[] hsb = new float[3];
    float[] shsb = new float[3];
    float[] bhsb = new float[3];
    int hdelay, sdelay, bdelay;
    
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    @Override
    public void updateChooser() {
        
    }

    @Override
    protected void buildChooser() {
        GridBagConstraints c = new GridBagConstraints();
        if (RIGHT_TO_LEFT) {
            scrollPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        if(shouldFill) {
            c.fill = GridBagConstraints.BOTH;
        }
        
        scrollPanel = new JPanel(new GridBagLayout());
        //scrollPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Scroll Color"));
        
        scroll = new JToggleButton("Scroll color");
        scroll.setActionCommand("hscroll");
        scroll.addActionListener(this);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        scrollPanel.add(scroll,c);
        
        brightnessScroll = new JToggleButton("Scroll brightness");
        brightnessScroll.setActionCommand("bscroll");
        brightnessScroll.addActionListener(this);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        scrollPanel.add(brightnessScroll,c);
        
        saturationScroll = new JToggleButton("Scroll saturation");
        saturationScroll.setActionCommand("sscroll");
        saturationScroll.addActionListener(this);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        scrollPanel.add(saturationScroll,c);
        
        scrollSpeed = new JSlider(0,1000,97);
        scrollSpeed.addChangeListener(this);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        scrollPanel.add(scrollSpeed,c);
        
        brightnessScrollSpeed = new JSlider(0,1000,101);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        scrollPanel.add(brightnessScrollSpeed,c);
        
        saturationScrollSpeed = new JSlider(0,1000,103);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        scrollPanel.add(saturationScrollSpeed,c);
        
        add(scrollPanel);
    }

    @Override
    public String getDisplayName() {
        return "Color Fading";
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
    public void actionPerformed(ActionEvent e) {
         if("hscroll".equals(e.getActionCommand())){
            System.out.print("Requested scrolling of color: ");
         
            if(scroll.isSelected()){
                (job = new scrolljob()).execute();
            } else{
                job.cancel(true);
                job = null;
            }
            System.out.println("Done");
        }  else if("bscroll".equals(e.getActionCommand())){
            System.out.print("Requested scrolling of brightness: ");
         
            if(brightnessScroll.isSelected()){
                (bjob = new bscrolljob()).execute();
                saturationScroll.setEnabled(false);
            } else{
                bjob.cancel(true);
                bjob = null;
                saturationScroll.setEnabled(true);
            }
            System.out.println("Done");
        } else if("sscroll".equals(e.getActionCommand())){
            System.out.print("Requested scrolling of saturation: ");
         
            if(saturationScroll.isSelected()){
                (sjob = new sscrolljob()).execute();
                brightnessScroll.setEnabled(false);
            } else{
                sjob.cancel(true);
                sjob = null;
                brightnessScroll.setEnabled(true);
            }
            System.out.println("Done");
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        JSlider source = (JSlider)ce.getSource();
        if (!source.getValueIsAdjusting()) {
            if(source == scrollSpeed){
                hdelay = (int)source.getValue();
            } else if(source == brightnessScrollSpeed){
                bdelay = (int)source.getValue();
            } else if(source == saturationScrollSpeed){
                sdelay = (int)source.getValue();
            }
        }    
    }
    
    
    
    


    public class scrolljob extends SwingWorker<Integer, Integer>{
        
        @Override
        protected Integer doInBackground() throws Exception {
            int i = 0;
            while (!isCancelled()) {
                i = getColor(ColorUtility.cc.getColor());
                publish(i);
                Thread.sleep(hdelay);
            }
            return i;
        }
        protected void process(List<Integer> i) {
            ColorUtility.cc.setColor(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
        }

        public int getColor(Color currentColor) {
            hr = currentColor.getRed();
            hg = currentColor.getGreen();
            hb = currentColor.getBlue();
            Color.RGBtoHSB(hr, hg, hb, hsb);
            hsb[0] += (float)1/360;
            return Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
        }
    }
    
    
    
    public class bscrolljob extends SwingWorker<Integer, Integer>{
        @Override
        protected Integer doInBackground() throws Exception {
            int i = 0;
            while (!isCancelled()) {
                i = getColor(ColorUtility.cc.getColor());
                publish(i);
                Thread.sleep(bdelay);
            }
            return i;
        }
        protected void process(List<Integer> i) {
            ColorUtility.cc.setColor(Color.HSBtoRGB(bhsb[0], bhsb[1], bhsb[2]));
        }

        public int getColor(Color currentColor) {
            br = currentColor.getRed();
            bg = currentColor.getGreen();
            bb = currentColor.getBlue();
            Color.RGBtoHSB(br, bg, bb, bhsb);
            bhsb[2] += (float)1/100;
            return Color.HSBtoRGB(bhsb[0], bhsb[1], bhsb[2]);
        }
    }
    
    
    
    public class sscrolljob extends SwingWorker<Integer, Integer>{
        @Override
        protected Integer doInBackground() throws Exception {
            int i = 0;
            while (!isCancelled()) {
                i = getColor(ColorUtility.cc.getColor());
                publish(i);
                Thread.sleep(sdelay);
            }
            return i;
        }
        protected void process(List<Integer> i) {
            ColorUtility.cc.setColor(Color.HSBtoRGB(shsb[0], shsb[1], shsb[2]));
        }

        public int getColor(Color currentColor) {
            sr = currentColor.getRed();
            sg = currentColor.getGreen();
            sb = currentColor.getBlue();
            Color.RGBtoHSB(sr, sg, sb, shsb);
            shsb[1] += (float)1/100;
            return Color.HSBtoRGB(shsb[0], shsb[1], shsb[2]);
        }
    }
}
