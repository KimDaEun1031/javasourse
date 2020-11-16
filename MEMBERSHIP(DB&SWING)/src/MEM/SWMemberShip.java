package MEM;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SWMemberShip extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	// ctr+shift+O = ��ü import
	// ctr+alt+down/up = ���� ����
	// ctr+shift+f = �ڵ� ����

	// ���� â ��ư �̹���
	private ImageIcon exitButtonBasic = new ImageIcon(Launcher.class.getResource("../image/exitButtonBasic.png"));
	private ImageIcon exitButtonEnter = new ImageIcon(Launcher.class.getResource("../image/exitButtonEnter.png"));
	private ImageIcon shipButtonBasic = new ImageIcon(Launcher.class.getResource("../image/shipButtonbasic.png"));
	private ImageIcon shipButtonEnter = new ImageIcon(Launcher.class.getResource("../image/shipButtonenter_1.png"));

	// ���� �⺻ �̹���
	private Image background = new ImageIcon(Launcher.class.getResource("../image/LoginBackground.png")).getImage();
	private JLabel menubar = new JLabel(new ImageIcon(Launcher.class.getResource("../image/menubar.png"))); //����

	// ���� â ��ư
	private JButton exitButton = new JButton(exitButtonBasic);
	private JButton shipButton = new JButton(shipButtonBasic);

	// ���콺 ��ǥ
	private int mouseX, mouseY;

	public SWMemberShip() { // ��ü ȭ�� ����
		setUndecorated(true); // ������ �׵θ� ���ֱ� - �޴��� ���� ��
		setTitle("MemberShip"); // ���� ����
		setSize(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HIGHT); // ������ ����
		setResizable(false); // ����� ������� ���̰ų� �ø� �� �ְ�
		setLocationRelativeTo(null); // ���α׷��� ���� �� �߰��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���α׷� ���� �� ����
		setVisible(true); // ���� ����
		setBackground(new Color(0, 0, 0, 0)); // �޴��� ������
		setLayout(null); // �޴��� ���� ��
		
		// ��ü ���� ��ư
		exitButton.setBounds(1105, 3, 27, 27);
		exitButton.setBorderPainted(false); // ��ư �׵θ� ����
		exitButton.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		exitButton.setFocusPainted(false); // ��Ŀ��(����) ǥ�� ����
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
		
		// ȸ������ ��ư
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
		

		menubar.setBounds(0, 0, 1136, 32);// ��ġ ��ġ (x, y, w, h)
		menubar.addMouseListener(new MouseAdapter() { // mouseListener : ���콺�� �Է��� ������
			@Override
			public void mousePressed(MouseEvent e) { // mousePressed : ���콺�� ���� �� �߻�
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		// ���콺 ������ �߰� ����
		// Listener �������̽� -> Adapter Ŭ���� -> Methods
		// ���� ���� MouseAdapter() Ŭ������ addMouseListener �������̽��� ��ӹ���
		// MouseAdapter() Ŭ������ CLICKED,ENTERED,EXITED,PRESSED,RELEASED �޼ҵ尡 ����
		menubar.addMouseMotionListener(new MouseMotionAdapter() {// mouseMotionListener : ���콺�� �������� ������
			@Override
			public void mouseDragged(MouseEvent e) { // mouseDragged : �ش� ������Ʈ ������ ���콺�� ������ �� �߻�
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		// ��ǵ� ���������� �巡�� �ܿ� MOVED �޼ҵ尡 �ϳ� �� ����
		add(menubar);

	}

	// paint() �޼ҵ� : JFrame ��ü�� �׸��� �׸��� �޼ҵ�
	// GUI ���α׷��� ����ǰų� ���� �� ��� JVM�� ���� �ڵ����� ȣ��
	public void paint(Graphics g) { // Graphics ��ü : �׸��� �׸��� ��ü
		screenImage = createImage(Launcher.SCREEN_WIDTH, Launcher.SCREEN_HIGHT); // ������ ���� ȭ�鿡 �°� �̸� ����
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null); 
		// ȭ�鿡 ��� = ȭ�鿡 �׸����� ��µ��� ���� ��� screenImage�� �´��� Ȯ��
		
	}

	private void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g); // ���ο��� �߰��� �̹������� �����ִ� add �κ�(background ���� ���� �߰��� �̹�����)
		this.repaint(); 
		// repaint() �޼ҵ� : update() �޼ҵ带 ȣ���ϱ� ���� �޼ҵ�
		// update() �޼ҵ� : paint() �޼ҵ带 ȣ���ϱ� ���� �޼ҵ�
	}
	
	public void MembershipMain() {
		shipButton.setVisible(false);
		
		JPanel panelLogin = new JPanel();
		panelLogin.add(new JLabel("���̵� : ")); 
		panelLogin.add(new JTextField(18));

	}
	
	public void SWLogin() {	
		JFrame membership = new JFrame();
		
		membership.setUndecorated(true); // ������ �׵θ� ���ֱ� - �޴��� ���� ��
		membership.setSize(200,400); // ������ ����
		membership.setResizable(false); // ����� ������� ���̰ų� �ø� �� �ְ�
		membership.setLocationRelativeTo(null); // ���α׷��� ���� �� �߰��� ����
		membership.setLayout(null); // �޴��� ���� ��	
	
		JPanel panelLogin = new JPanel();
		panelLogin.add(new JLabel("���̵� : ")); 
		panelLogin.add(new JTextField(18));
		
		JPanel panelPW = new JPanel();
		panelPW.add(new JLabel("��й�ȣ : ")); 
		panelPW.add(new JTextField(18));
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(254,204,190));
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		panel4.add(panelLogin);
		panel4.add(panelPW);
		
		membership.add(panel4,BorderLayout.CENTER);
		membership.pack();
		membership.setVisible(true); // ���� ����	
		
	}

}
