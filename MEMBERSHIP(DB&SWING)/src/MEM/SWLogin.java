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

		
		setUndecorated(true); // ������ �׵θ� ���ֱ� - �޴��� ���� ��
		setSize(200,400); // ������ ����
		setResizable(false); // ����� ������� ���̰ų� �ø� �� �ְ�
		setLocationRelativeTo(null); // ���α׷��� ���� �� �߰��� ����
		setLayout(null); // �޴��� ���� ��	
	
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
	

}
