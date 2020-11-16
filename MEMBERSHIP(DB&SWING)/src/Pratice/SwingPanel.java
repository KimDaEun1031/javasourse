package Pratice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingPanel {

	public static void main(String[] args) {
			Dimension dem = new Dimension(400,150);
			//dimension = 공간의 치수
			
			JFrame frame = new JFrame("로그인 화면 연습"); //제목
			
			frame.setLocation(200, 400);
			frame.setPreferredSize(dem);//setsize를 사용하면 사이즈
			
			JPanel panel1 = new JPanel();
			panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
			panel1.add(new JLabel("이름 : "));
			panel1.add(new JTextField());
			
			JPanel panel2 = new JPanel();
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
			panel2.add(new JLabel("나이 : "));
			panel2.add(new JTextField());
			
			JPanel panel3 = new JPanel();			
			panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
			panel3.add(new JLabel("주소 : "));
			panel3.add(new JTextField());
			
			JPanel panel4 = new JPanel();
			panel4.setBackground(new Color(254,204,190));
			panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
			panel4.add(panel1);
			panel4.add(panel2);
			panel4.add(panel3);
			
			frame.add(panel4,BorderLayout.CENTER);
			frame.add(new JButton("입력하기"),BorderLayout.SOUTH);
			frame.pack();
			frame.setVisible(true);
				
	}

}
