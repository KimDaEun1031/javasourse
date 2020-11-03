package Factory;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Factory extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	//���� â ��ư
	private ImageIcon exitButtonenter = new ImageIcon(Main.class.getResource("../images/exitButtonenter.png"));
	private ImageIcon exitButtonbasic = new ImageIcon(Main.class.getResource("../images/exitButtonbasic.png"));
	private ImageIcon startButtonbasic = new ImageIcon(Main.class.getResource("../images/startButtonbasic.png"));
	private ImageIcon startButtonenter = new ImageIcon(Main.class.getResource("../images/startButtonenter.png"));
	private ImageIcon quitButtonbasic = new ImageIcon(Main.class.getResource("../images/quitButtonbasic.png"));
	private ImageIcon quitButtonenter = new ImageIcon(Main.class.getResource("../images/quitButtonenter.png"));
	//���� ����â ��ư
	private ImageIcon leftButtonbasic = new ImageIcon(Main.class.getResource("../images/leftButtonbasic.png"));
	private ImageIcon leftButtonenter = new ImageIcon(Main.class.getResource("../images/leftButtonenter.png"));
	private ImageIcon rightButtonbasic = new ImageIcon(Main.class.getResource("../images/rightButtonbasic.png"));
	private ImageIcon rightButtonenter = new ImageIcon(Main.class.getResource("../images/rightButtonenter.png"));
	private ImageIcon easyButtonbasic = new ImageIcon(Main.class.getResource("../images/easyButtonbasic.png"));
	private ImageIcon easyButtonenter = new ImageIcon(Main.class.getResource("../images/easyButtonenter.png"));
	private ImageIcon hardButtonbasic = new ImageIcon(Main.class.getResource("../images/hardButtonbasic.png"));
	private ImageIcon hardButtonenter = new ImageIcon(Main.class.getResource("../images/hardButtonenter.png"));
	private ImageIcon homeButtonbasic = new ImageIcon(Main.class.getResource("../images/homeButtonbasic.png"));
	private ImageIcon homeButtonenter = new ImageIcon(Main.class.getResource("../images/homeButtonenter.png"));
	//���� â ��ư 
	private ImageIcon backButtonbasic = new ImageIcon(Main.class.getResource("../images/backButtonbasic.png"));
	private ImageIcon backButtonenter = new ImageIcon(Main.class.getResource("../images/backButtonenter.png"));
	//����â ��ư
	private ImageIcon settingButtonbasic = new ImageIcon(Main.class.getResource("../images/settingbasic.png"));
	private ImageIcon settingButtonenter = new ImageIcon(Main.class.getResource("../images/settingenter.png"));
	private ImageIcon infoButton = new ImageIcon(Main.class.getResource("../images/InfoButton.png"));
	private ImageIcon secondButton = new ImageIcon(Main.class.getResource("../images/gamewayButton.png"));
	private ImageIcon thirdButton = new ImageIcon(Main.class.getResource("../images/itemButton.png"));
	
	//���� �⺻ �̹��� ����
	private Image background = new ImageIcon(Main.class.getResource("../images/background.png")).getImage();
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar_2.png")));
	
	//���� â ��ư ����
	private JButton exitButton = new JButton(exitButtonbasic);
	private JButton startButton = new JButton(startButtonbasic);
	private JButton quitButton = new JButton(quitButtonbasic);
	//���� ����â ��ư ����
	private JButton leftButton = new JButton(leftButtonbasic);
	private JButton rightButton = new JButton(rightButtonbasic);
	private JButton	 easyButton = new JButton(easyButtonbasic);
	private JButton hardButton = new JButton(hardButtonbasic);
	private JButton homeButton = new JButton(homeButtonbasic);
	//����â ��ư ����
	private JButton backButton = new JButton(backButtonbasic);
	//����â ��ư ����
	private JButton settingButton = new JButton(settingButtonbasic);
	private JButton informaitonButton = new JButton(infoButton);
	private JButton gamewayButton = new JButton(secondButton);
	private JButton itemButton = new JButton(thirdButton);
	
	private int mouseX, mouseY;
	
	//ȭ�� ��ȯ�� ���� ��ũ��
	private boolean isMainScreen = false;
	private boolean isSetScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	
	private Image titleImage;
	private Image selectedImage;	
	private Music selectedMusic;
	private Music IntroCalimba = new Music("IntroCalimba.mp3", true);
	private int nowSelected = 0;
	
	private Image setMainImage;
	
	public static Game game;
	
	
	public Factory() {
		setUndecorated(true);
		setTitle("Wood Factory");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HIGHT);
		setResizable(false); //����� ������� ���̰ų� �ø� �� �ְ� �Ұų�
		setLocationRelativeTo(null);//���α׷��� ���� �� �߰��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���α׷��� ����
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyListener());
		
		//�������
			IntroCalimba.start();
				
		//�������� �Ʒ��� ���� ���� ���� �ڿ� ���� ���ʹ�ư�̸� �ݴ�
				//ù��° ��
				trackList.add(new Track("weddingtitle.png","wedding.png","gamestart.png",
						"Wedding Invitation - Jason Farnham.mp3","Wedding Invitation - Jason Farnham.mp3","Wedding Invitation - Jason Farnham"));
				//�ι�° ��
				trackList.add(new Track("rivertitle.png","river.png","gamestart.png",
						"White River - Aakash Gandhi.mp3","White River - Aakash Gandhi.mp3", "White River - Aakash Gandhi"));
				//����° ��
				trackList.add(new Track("harptitle.png","harp.png","gamestart.png",
						"Wistful Harp - Andrew Huang.mp3","Wistful Harp - Andrew Huang.mp3", "Wistful Harp - Andrew Huang"));
		
		//������ �� ���� ��ư
		exitButton.setBounds(720, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonenter);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonbasic);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		//��ŸƮ ��ư
		startButton.setBounds(325, 560, 100, 50);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonenter);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
				buttonEnteredMusic.close();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonbasic);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
				buttonEnteredMusic.start();
				IntroCalimba.close();//��ŸƮ ��ư ������ ���� ������� ����
				enterMain();				
			}
		});
		add(startButton);
		
		//���� ��ư
		quitButton.setBounds(325, 610, 100, 50);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonenter);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonbasic);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		//setting ��ư
		settingButton.setBounds(670,700, 32, 32);
		settingButton.setBorderPainted(false);
		settingButton.setContentAreaFilled(false);
		settingButton.setFocusPainted(false);
		settingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				settingButton.setIcon(settingButtonbasic);
				settingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				settingButton.setIcon(settingButtonbasic);
				settingButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
				buttonEnteredMusic.start();
				enterSetting();
			}
		});
		add(settingButton);	
		
		//setting - info ��ư
				informaitonButton.setVisible(false);
				informaitonButton.setBounds(166,78, 60, 32);
				informaitonButton.setBorderPainted(false);
				informaitonButton.setContentAreaFilled(false);
				informaitonButton.setFocusPainted(false);
				informaitonButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						informaitonButton.setIcon(infoButton);
						informaitonButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
						buttonEnteredMusic.start();
					}
					@Override
					public void mouseExited(MouseEvent e) {
						informaitonButton.setIcon(infoButton);
						informaitonButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
						buttonEnteredMusic.start();
						enterSetting();
					}
				});
				add(informaitonButton);	
				
				//setting - second ��ư
				gamewayButton.setVisible(false);
				gamewayButton.setBounds(266,78, 60, 32);
				gamewayButton.setBorderPainted(false);
				gamewayButton.setContentAreaFilled(false);
				gamewayButton.setFocusPainted(false);
				gamewayButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						gamewayButton.setIcon(secondButton);
						gamewayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
						buttonEnteredMusic.start();
					}
					@Override
					public void mouseExited(MouseEvent e) {
						gamewayButton.setIcon(secondButton);
						gamewayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
						buttonEnteredMusic.start();
						enterSecond();
					}
				});
				add(gamewayButton);	
				
				//setting - third ��ư
				itemButton.setVisible(false);
				itemButton.setBounds(366,78, 60, 32);
				itemButton.setBorderPainted(false);
				itemButton.setContentAreaFilled(false);
				itemButton.setFocusPainted(false);
				itemButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						itemButton.setIcon(thirdButton);
						itemButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
						buttonEnteredMusic.start();
					}
					@Override
					public void mouseExited(MouseEvent e) {
						itemButton.setIcon(thirdButton);
						itemButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
						buttonEnteredMusic.start();
						enterthird();
					}
				});
				add(itemButton);	
				
			//home ��ư
				homeButton.setVisible(false);
				homeButton.setBounds(0,0, 32, 32);
				homeButton.setBorderPainted(false);
				homeButton.setContentAreaFilled(false);
				homeButton.setFocusPainted(false);
				homeButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						homeButton.setIcon(homeButtonenter);
						homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
						buttonEnteredMusic.start();
					}
					@Override
					public void mouseExited(MouseEvent e) {
						homeButton.setIcon(homeButtonbasic);
						homeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
						buttonEnteredMusic.start();
						enterhome();
					}
				});
				add(homeButton);	
		
		//���� ��ư
		leftButton.setVisible(false);
		leftButton.setBounds(90 ,310, 50, 50);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonenter);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonbasic);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
				buttonEnteredMusic.start();
				selectLeft();
			}
		});
		add(leftButton);		
		
		//������ ��ư
		rightButton.setVisible(false);
		rightButton.setBounds(600, 310, 50, 50);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonenter);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonbasic);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
				buttonEnteredMusic.start();
				selectRight();
			}
		});
		add(rightButton);		
		
		//easy ��ư
				easyButton.setVisible(false);
				easyButton.setBounds(325, 540, 100, 50);
				easyButton.setBorderPainted(false);
				easyButton.setContentAreaFilled(false);
				easyButton.setFocusPainted(false);
				easyButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						easyButton.setIcon(easyButtonenter);
						easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
						buttonEnteredMusic.start();
					}
					@Override
					public void mouseExited(MouseEvent e) {
						easyButton.setIcon(easyButtonbasic);
						easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
						buttonEnteredMusic.start();
						gameStart(nowSelected, "Easy");
					}
				});
				add(easyButton);	
			
			//hard ��ư
				hardButton.setVisible(false);
				hardButton.setBounds(325, 590, 100, 50);
				hardButton.setBorderPainted(false);
				hardButton.setContentAreaFilled(false);
				hardButton.setFocusPainted(false);
				hardButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						hardButton.setIcon(hardButtonenter);
						hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
						buttonEnteredMusic.start();
					}
					@Override
					public void mouseExited(MouseEvent e) {
						hardButton.setIcon(hardButtonbasic);
						hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
						buttonEnteredMusic.start();
						gameStart(nowSelected, "Hard");
					}
				});
				add(hardButton);	
				
			//back ��ư
				backButton.setVisible(false);
				backButton.setBounds(0, 0, 32, 32);
				backButton.setBorderPainted(false);
				backButton.setContentAreaFilled(false);
				backButton.setFocusPainted(false);
				backButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						backButton.setIcon(backButtonenter);
						backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						Music buttonEnteredMusic = new Music("exitButtonEffect.mp3",false);
						buttonEnteredMusic.start();
					}
					@Override
					public void mouseExited(MouseEvent e) {
						backButton.setIcon(backButtonbasic);
						backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						Music buttonEnteredMusic = new Music("exitButtonEffectentered.mp3",false);
						buttonEnteredMusic.start();
						backMain();
					}
				});
				add(backButton);	
				
				
				
		//�� �� ȸ�� �޴���
		menubar.setBounds(0, 0, 750, 30);
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menubar);


	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {//���� ȭ��
			g.drawImage(selectedImage,170,120,null);
			g.drawImage(titleImage, 170, 50, null);
		}
		if(isGameScreen) {//����ȭ��
			game.screenDraw(g);
		}
		if(isSetScreen) {//����ȭ��
			g.drawImage(setMainImage, 170, 50, null);
		}
		paintComponents(g); //���ο��� �߰��� �̹������� �����ִ� add�κ�
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) { //���� ����Ʈ ���
		if(selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();		
	}
	
	
	public void selectLeft() {//������ ������
		if(nowSelected ==0) 
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {//�������� ������ 
		if(nowSelected == trackList.size() - 1) 
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	


	//��ư �̺�Ʈ
	public void gameStart(int nowSelected, String difficulty) { //���� �ϵ� ��ư
		if(selectedMusic!=null)
			selectedMusic.close();
		isMainScreen = false;
		isSetScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);	
		homeButton.setVisible(false);
		settingButton.setVisible(false);	
		informaitonButton.setVisible(false);
		gamewayButton.setVisible(false);
		itemButton.setVisible(false);
		isGameScreen = true;
		background = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getGameImage())).getImage();	
		backButton.setVisible(true);
		setFocusable(true);
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
//		game.start();
	}
	
	public void backMain() { //�� ��ư
		isMainScreen = true;
		isSetScreen = false;
		background = new ImageIcon(Main.class.getResource("../images/mainbackground.png")).getImage();
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		homeButton.setVisible(true);
		backButton.setVisible(false);
		settingButton.setVisible(false);	
		informaitonButton.setVisible(false);
		gamewayButton.setVisible(false);
		itemButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
		game.close();
	}
	
	public void enterMain() { //��ŸƮ ��ư
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainbackground.png")).getImage();
		isMainScreen = true;
		isSetScreen = false;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		homeButton.setVisible(true);
		settingButton.setVisible(false);
		IntroCalimba.close();
		selectTrack(0);
	}
	
	public void enterhome() { //home ��ư
		background = new ImageIcon(Main.class.getResource("../images/background.png")).getImage();
		startButton.setVisible(true);
		quitButton.setVisible(true);
		settingButton.setVisible(true);
		isMainScreen = false;
		isSetScreen = false;
		selectedMusic.close();
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		homeButton.setVisible(false);
	}
	
	
	public void enterSetting() { //���� ��ư 
		startButton.setVisible(false);
		quitButton.setVisible(false);;
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		homeButton.setVisible(false);
		isSetScreen = true;
		background = new ImageIcon(Main.class.getResource("../images/setMainscreen.png")).getImage();
		settingButton.setVisible(false);	
		informaitonButton.setVisible(true);
		gamewayButton.setVisible(true);
		itemButton.setVisible(true);
		backButton.setVisible(true);
		IntroCalimba.close();		
	}
	
	public void enterSecond() { //���� �ι�°
		startButton.setVisible(false);
		quitButton.setVisible(false);;
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);	
		homeButton.setVisible(false);
		isSetScreen = true;
		background = new ImageIcon(Main.class.getResource("../images/setSecondscreen.png")).getImage();
		informaitonButton.setVisible(true);
		gamewayButton.setVisible(true);
		itemButton.setVisible(true);
		backButton.setVisible(true);
	}
	
	public void enterthird() { // ���� ����°
		startButton.setVisible(false);
		quitButton.setVisible(false);;
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);	
		homeButton.setVisible(false);
		isSetScreen = true;
		background = new ImageIcon(Main.class.getResource("../images/setThirdscreen.png")).getImage();
		informaitonButton.setVisible(true);
		gamewayButton.setVisible(true);
		itemButton.setVisible(true);
		backButton.setVisible(true);
	}

	
}
