package com.first.teng;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class LocationUtil {
	public int xx;
	public int yy;
	public JFrame huaBan;
	public LocationUtil(JFrame h){
		this.huaBan=h;
		huaBan.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				super.mousePressed(e);
				xx = e.getX();
				yy = e.getY();
			}	
		});
		huaBan.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e){
				super.mouseDragged(e);
				int x = huaBan.getLocation().x;
				int y = huaBan.getLocation().y;
				huaBan.setLocation(e.getX()-xx+x,e.getY()-yy+y);
			}
		});
	}

}
