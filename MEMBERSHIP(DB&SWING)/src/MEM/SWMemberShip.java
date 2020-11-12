package MEM;

import java.awt.Color;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SWMemberShip extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	// ctr+shift+O = 전체 import
	// ctr+alt+down/up = 한줄 복사
	// ctr+shift+f = 자동 정렬

	// 메인 창 버튼 이미지
	private ImageIcon exitButtonBasic = new ImageIcon(Launcher.class.getResource("../image/exitButtonBasic.png"));
	private ImageIcon exitButtonEnter = new ImageIcon(Launcher.class.getResource("../image/exitButtonEnter.png"));
	private ImageIcon shipButtonBasic = new ImageIcon(Launcher.class.getResource("../image/shipButtonbasic.png"));
	private ImageIcon shipButtonEnter = new ImageIcon(Launcher.class.getResource("../image/shipButtonenter_1.png"));

	// 메인 기본 이미지
	private Image background = new ImageIcon(Launcher.class.getResource("../image/LoginBackground.png")).getImage();
	private JLabel menubar = new JLabel(new ImageIcon(Launcher.class.getResource("../image/menubar.png"))); //투명

	// 메인 창 버튼
	private JButton exitButton = new JButton(exitButtonBasic);
	private JButton shipButton = new JButton(shipButtonBasic);

	// 마우스 좌표
	private int mouseX, mouseY;

	public SWMemberShip() { // 전체 화면 설정
		setUndecorated(true); // 프레임 테두리 없애기 - 메뉴바 설정 시
		setTitle("MemberShip"); // 제목 설정
		setSize(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HIGHT); // 사이즈 설정
		setResizable(false); // 사이즈를 마음대로 줄이거나 늘릴 수 있게
		setLocationRelativeTo(null); // 프로그램을 켰을 때 중간에 오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 멈춤 시 종료
		setVisible(true); // 투명성 설정
		setBackground(new Color(0, 0, 0, 0)); // 메뉴바 설정시
		setLayout(null); // 메뉴바 설정 시
		
		// 전체 종료 버튼
		exitButton.setBounds(1105, 3, 27, 27);
		exitButton.setBorderPainted(false); // 버튼 테두리 설정
		exitButton.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		exitButton.setFocusPainted(false); // 포커스(선택) 표시 설정
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnter);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasic);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));				
			}
			@Override
			public void mousePressed(MouseEvent e) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException ex) {
//					ex.printStackTrace();
//				}	
				System.exit(0);
			}
			
		});
		add(exitButton);
		
		// 회원가입 버튼
		shipButton.setBounds(510, 470, 200, 60);
		shipButton.setBorderPainted(false); 
		shipButton.setContentAreaFilled(false); 
		shipButton.setFocusPainted(false); 
		shipButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				shipButton.setIcon(shipButtonEnter);
				shipButton.setCursor(new Cursor(Cursor.HAND_CURSOR));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				shipButton.setIcon(shipButtonBasic);
				shipButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				MembershipMain();
			}
			
		});
		add(shipButton);
		

		menubar.setBounds(0, 0, 1136, 32);// 위치 배치 (x, y, w, h)
		menubar.addMouseListener(new MouseAdapter() { // mouseListener : 마우스의 입력을 감지함
			@Override
			public void mousePressed(MouseEvent e) { // mousePressed : 마우스를 누를 때 발생
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		// 마우스 리스너 추가 설명
		// Listener 인터페이스 -> Adapter 클래스 -> Methods
		// 위를 예로 MouseAdapter() 클래스는 addMouseListener 인터페이스를 상속받음
		// MouseAdapter() 클래스는 CLICKED,ENTERED,EXITED,PRESSED,RELEASED 메소드가 있음
		menubar.addMouseMotionListener(new MouseMotionAdapter() {// mouseMotionListener : 마우스의 움직임을 감지함
			@Override
			public void mouseDragged(MouseEvent e) { // mouseDragged : 해당 컴포넌트 위에서 마우스가 움직일 때 발생
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		// 모션도 마찬가지로 드래그 외에 MOVED 메소드가 하나 더 있음
		add(menubar);

	}

	// paint() 메소드 : JFrame 객체에 그림을 그리는 메소드
	// GUI 프로그램이 실행되거나 복구 될 경우 JVM에 의해 자동으로 호출
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
	
	public void MembershipMain() {
		shipButton.setVisible(false);
		background = new ImageIcon(Launcher.class.getResource("../image/ShipBackground.png")).getImage();
	}

}
