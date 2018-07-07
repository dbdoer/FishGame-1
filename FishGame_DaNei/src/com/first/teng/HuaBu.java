package com.first.teng;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HuaBu extends JPanel implements MouseListener,MouseMotionListener{
	
	public int mouseX = 0;
	public int mouseY = 0;
	
	public Vector<Fish> fishes = new Vector<Fish>();
	
	public HuaBu(){
		this.setBounds(15, 50, 799, 479);
		addFish();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	private void addFish() {
		// TODO Auto-generated method stub
		//Thread t = new Thread(){};
		new Thread(){
			public void run(){
				while(true){
				Fish fish = new Fish(HuaBu.this);
				int kind = (int)(Math.random()*11)+1;
				if(kind == 1){
					fish.timeThread = 40;
				}else if(kind == 2){
					fish.timeThread = 60;
				}else if(kind==3){
					fish.timeThread = 60;
				}else if(kind==4){
					fish.timeThread = 60;
				}else if(kind==5){
					fish.timeThread = 60;
				}else if(kind==6){
					fish.timeThread = 60;
				}else if(kind ==7){
					fish.timeThread = 60;
				}else if(kind == 8){
					fish.timeThread = 60;
				}else if(kind== 9){
					fish.timeThread = 70;
				}else if(kind==10){
					fish.timeThread = 60;
				}else if(kind==11){
					fish.timeThread = 60;
					}
				String path = "";
				if(fish.road == 0){
					path = "image/up_to_buttom/fish"+((kind<10)?"0"+kind:kind)+"_";
					fish.x = (int)(Math.random()*544);
					fish.y = -310;
					}
				if(fish.road == 1){
					path = "image/left_to_right/fish"+((kind<10)?"0"+kind:kind)+"_";
					fish.x = -310;
					fish.y = (int)(Math.random()*544);
				}
				if(fish.road == 2){
					path = "image/right_to_left/fish"+((kind<10)?"0"+kind:kind)+"_";
					fish.x = 829+310;
					fish.y = (int)(Math.random()*544);
				}
				for(int i = 1;i<=fish.imgs.length;i++){
					String path1 = path +((i<10)?"0"+i:i)+".png";
					ImageIcon img = new ImageIcon(path1);
					fish.imgs[i-1]=img;
				}
				for(int i = 1;i<fish.imgsCatch.length;i++){
					String path1 = path +"catch_0"+i+".png";
					ImageIcon img = new ImageIcon(path1);
					fish.imgsCatch[i-1]=img;
				}
				fishes.add(fish);
				
				FishThread fishThread = new FishThread(fish);
				fishThread.start();
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		Image bgImg = new ImageIcon("image/bg_03.png").getImage();
		g.drawImage(bgImg, 0, 0, 814, 529, this);
		
		for(int i = 0;i<fishes.size();i++){
			Fish fish = fishes.get(i);
			fish.drawFish(g);
		}

		Image bgImg2 = new ImageIcon("image/bg1.jpg").getImage();
		//g.drawImage(bgImg2, 0, 400, 800, 80, this);
		g.drawImage(bgImg2, 15,410, this);
		
		Image bgImg1 = new ImageIcon("image/solider.png").getImage();
		//g.drawImage(bgImg1,570,450,220,20,this);
		g.drawImage(bgImg1, 560,455, this);
		
		Image rightAdd = new ImageIcon("image/ui_button_63_hv.png").getImage();
		Image leftEduce  = new ImageIcon("image/ui_button_65_hv.png").getImage();
		g.drawImage(leftEduce, 450, 451, 80, 30,this);
		g.drawImage(rightAdd, 351, 451, 80, 30, this);
		
		Image barrel = new ImageIcon("image/level.png").getImage();
		//g.drawImage(bgImg3,415, 390, 50, 90,this);
		int x = 420+21;
		int y = 415+39;
		double x1 = (double)mouseX-x;
		double y1 = (double)mouseY-y;
		double f = -Math.atan(x1/y1);
		
		
		Graphics2D gp = (Graphics2D)g;
		gp.rotate(f,x,y);
		gp.drawImage(barrel,420,415,this);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
		repaint();
	}

}
