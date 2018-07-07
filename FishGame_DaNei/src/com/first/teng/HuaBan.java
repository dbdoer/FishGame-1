package com.first.teng;

import javax.swing.JFrame;



public class HuaBan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame huaBan = new JFrame();
		huaBan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		huaBan.setSize(829,544);//����Ĵ�С
		huaBan.setLocationRelativeTo(null);
		huaBan.setUndecorated(true);//ȥ���������� ȥ����߿�
		BackGrounda bg = new BackGrounda(huaBan);//����һ������
		
		HuaBu huaBu = new HuaBu();
		huaBan.add(huaBu);
		
//		HuaBu1 huaBu1 = new HuaBu1();
//		huaBan.add(huaBu1);
		
		huaBan.add(bg);
//		bg.add(huaBu);
		new LocationUtil(huaBan);
		huaBan.setVisible(true);//ʹ�û������

	}

}
