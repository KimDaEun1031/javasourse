package MEM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SWLogin extends JFrame{
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Launcher.class.getResource("../image/ShipBackground.png")).getImage();

	public SWLogin() {

		
		setUndecorated(true); // 프레임 테두리 없애기 - 메뉴바 설정 시
		setSize(200,400); // 사이즈 설정
		setResizable(false); // 사이즈를 마음대로 줄이거나 늘릴 수 있게
		setLocationRelativeTo(null); // 프로그램을 켰을 때 중간에 오게
		setLayout(null); // 메뉴바 설정 시	
	
		JPanel panelLogin = new JPanel();
		panelLogin.add(new JLabel("아이디 : ")); 
		panelLogin.add(new JTextField(18));
		
		JPanel panelPW = new JPanel();
		panelPW.add(new JLabel("비밀번호 : ")); 
		panelPW.add(new JTextField(18));
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(254,204,190));
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		panel4.add(panelLogin);
		panel4.add(panelPW);
		
		membership.add(panel4,BorderLayout.CENTER);
		membership.pack();
		membership.setVisible(true); // 투명성 설정	
		
		
	}
	
	public void paint(Graphics g) { // Graphics 객체 : 그림을 그리는 객체
		screenImage = createImage(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HIGHT); // 설정한 메인 화면에 맞게 이면 제작
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null); 
		// 화면에 출력 = 화면에 그림들이 출력되지 않을 경우 screenImage가 맞는지 확인
		
	}

	private void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g); // 메인에서 추가된 이미지들을 보여주는 add 부분(background 이후 부터 추가된 이미지들)
		this.repaint(); 
		// repaint() 메소드 : update() 메소드를 호출하기 위한 메소드
		// update() 메소드 : paint() 메소드를 호출하기 위한 메소드
	}
	

}
