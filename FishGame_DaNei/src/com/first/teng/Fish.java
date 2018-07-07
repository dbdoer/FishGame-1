package com.first.teng;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Fish {
	public int x;
	public int y;
	public ImageIcon imgs[];
	public ImageIcon imgsCatch[];
	public int imgNum;//��ͼƬ������±�
	public int step;
	public int timeThread;//�������ζ��̵߳�����ʱ��
	public int road;//���ζ�����
	public int kind;//������
	public boolean isCatch;//���Ƿ񱻲�׽
	public HuaBu huabu;
	public Fish(HuaBu hb){
		isCatch = false;//��ʼ���㶼��û�б���׽��
		imgs = new ImageIcon[10];
		imgsCatch = new ImageIcon[2];
		imgNum = 0;
		step = 2;
		timeThread = 30;
		this.huabu = hb;
		road =(int)(Math.random()*3); //ǿ������ת��
		
	}
	public void drawFish(Graphics g){
		if(isCatch){
			g.drawImage(imgsCatch[imgNum].getImage(),x,y,huabu);
		}else{
			g.drawImage(imgs[imgNum%10].getImage(),x,y,huabu);
		}
	}
	public void move(){
		if(!isCatch){
			switch (road){
			case 0:
				y = y+step;
				if(y>544-15){
					//�Ƴ���Ļ���γ���Ļ����
					huabu.fishes.remove(this);
				}
				break;
			case 1:
				x = x+step;
				if(y>829-15){
					//�Ƴ���Ļ���γ���Ļ����
					huabu.fishes.remove(this);
				}
				break;
			case 2:
				x = x - step;
				if(x<-310){
					huabu.fishes.remove(this);
					
				}
				break;
				default:
					break;
			}
		}
		imgNum++;
		if(imgNum>imgs.length&&!isCatch){
			imgNum = 0;	
		}
		if(imgNum>imgs.length&&isCatch){
			imgNum = 0;	
		}
		huabu.repaint();	
		
	}
	
}
