package com.first.teng;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BackGrounda extends JLabel implements ActionListener{
	public ImageIcon bg;//ͼƬ�ؼ�

	public JButton min;//������С����ť
	public JButton close;//����һ���رհ�ť
	public JFrame h;
	
	
	public BackGrounda(JFrame huaBan){
		this.h = huaBan;
		min = new JButton(new ImageIcon("image/min.png"));
		min.setBorderPainted(false);
		min.setContentAreaFilled(false);
		min.setBounds(745,15,24,24);//���ð�ťλ�� ��С
		this.add(min);
		//��ʾ��min�ϰ���Ϊ�����¼�
		min.addActionListener(this);
		//�������Ӽ����¼�
		min.addMouseListener(new MouseAdapter(){
			@Override
			//�������
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				min.setIcon(new ImageIcon("image/min1.png"));
			}
			
			@Override
			//����Ƴ�
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				min.setIcon(new ImageIcon("image/min.png"));
			}
			
		});
		
		close = new JButton(new ImageIcon("image/close.png"));
		close.setBorderPainted(false);
		close.setContentAreaFilled(false);
		close.setBounds(780,15,24,24);//���ð�ťλ�� ��С��x,y,width,height��
		this.add(close);
		//Ϊclose ����Ϊ����
		close.addActionListener(this);
		close.addMouseListener(new MouseAdapter(){
			@Override
			//������� MouseE alt+/
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				close.setIcon(new ImageIcon("image/close1.png"));//��������ǲ���  close1 ����ͼƬ
			}
			
			
			@Override
			//����Ƴ�
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				close.setIcon(new ImageIcon("image/close.png"));//����Ƴ�ʱ���� close ͼƬ
			}
			
		});
		
		bg = new ImageIcon("image/bg.png");
		this.setIcon(bg);
		this.setLocation(0,0);
		this.setSize(829,544);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==min){
			//��С
			h.setState(JFrame.ICONIFIED);
		}else if(e.getSource()==close){
			//�˳�
			System.exit(0);		
		}
		
	}

}
