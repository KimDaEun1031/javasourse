package Factory1;

import java.awt.Color;
	
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
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

	//버튼 이미지
	private ImageIcon exitButtonenter = new ImageIcon(Main.class.getResource("../images/exitButtonenter.png"));
	private ImageIcon exitButtonbasic = new ImageIcon(Main.class.getResource("../images/exitButtonbasic.png"));
	private ImageIcon startButtonbasic = new ImageIcon(Main.class.getResource("../images/startButtonbasic.png"));
	private ImageIcon startButtonenter = new ImageIcon(Main.class.getResource("../images/startButtonenter.png"));
	private ImageIcon quitButtonbasic = new ImageIcon(Main.class.getResource("../images/quitButtonbasic.png"));
	private ImageIcon quitButtonenter = new ImageIcon(Main.class.getResource("../images/quitButtonenter.png"));
	private ImageIcon leftButtonbasic = new ImageIcon(Main.class.getResource("../images/leftButtonbasic.png"));
	private ImageIcon leftButtonenter = new ImageIcon(Main.class.getResource("../images/leftButtonenter.png"));
	private ImageIcon rightButtonbasic = new ImageIcon(Main.class.getResource("../images/rightButtonbasic.png"));
	private ImageIcon rightButtonenter = new ImageIcon(Main.class.getResource("../images/rightButtonenter.png"));
	private ImageIcon easyButtonbasic = new ImageIcon(Main.class.getResource("../images/easyButtonbasic.png"));
	private ImageIcon easyButtonenter = new ImageIcon(Main.class.getResource("../images/easyButtonenter.png"));
	private ImageIcon hardButtonbasic = new ImageIcon(Main.class.getResource("../images/hardButtonbasic.png"));
	private ImageIcon hardButtonenter = new ImageIcon(Main.class.getResource("../images/hardButtonenter.png"));
	private ImageIcon backButtonbasic = new ImageIcon(Main.class.getResource("../images/backButtonbasic.png"));
	private ImageIcon backButtonenter = new ImageIcon(Main.class.getResource("../images/backButtonenter.png"));
	
	
	
	private Image background = new ImageIcon(Main.class.getResource("../images/background.png")).getImage();
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar.png")));
	
	//버튼 변수
	private JButton exitButton = new JButton(exitButtonbasic);
	private JButton startButton = new JButton(startButtonbasic);
	private JButton quitButton = new JButton(quitButtonbasic);
	private JButton leftButton = new JButton(leftButtonbasic);
	private JButton rightButton = new JButton(rightButtonbasic);
	private JButton	 easyButton = new JButton(easyButtonbasic);
	private JButton hardButton = new JButton(hardButtonbasic);
	private JButton backButton = new JButton(backButtonbasic);
	
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image titleImage;
	private Image selectedImage;	
	private Music selectedMusic;
	private Music IntroCalimba = new Music("IntroCalimba.mp3", true);
	private int nowSelected = 0;
	
	public Factory() {
		setUndecorated(true);
		setTitle("Wood Factory");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HIGHT);
		setResizable(false); //사이즈를 마음대로 줄이거나 늘릴 수 있게 할거냐
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		//배경음악
				IntroCalimba.start();
				
		//게임음악 아래로 내릴 수록 곡이 뒤에 나옴 왼쪽버튼이면 반대
				//첫번째 곡
				trackList.add(new Track("weddingtitle.png","wedding.png","gamestart.png",
						"Wedding Invitation - Jason Farnham.mp3","Wedding Invitation - Jason Farnham.mp3"));
				//두번째 곡
				trackList.add(new Track("rivertitle.png","river.png","gamestart.png",
						"White River - Aakash Gandhi.mp3","White River - Aakash Gandhi.mp3"));
				//세번째 곡
				trackList.add(new Track("harptitle.png","harp.png","gmaestart.png",
						"Wistful Harp - Andrew Huang.mp3","Wistful Harp - Andrew Huang.mp3"));
				
	
		
		//오른쪽 위 종료 버튼
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
		
		//스타트 버튼
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
				IntroCalimba.close();//스타트 버튼 누르면 메인 배경음악 종료
				enterMain();				
			}
		});
		add(startButton);
		
		//종료 버튼
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
		
		//왼쪽 버튼
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
		
		//오른쪽 버튼
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
		
		//easy 버튼
				easyButton.setVisible(false);
				easyButton.setBounds(450, 560, 200, 80);
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
						gameStart(nowSelected, "easy");
					}
				});
				add(easyButton);	
			
			//hard 버튼
				hardButton.setVisible(false);
				hardButton.setBounds(95, 560, 200, 80);
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
						gameStart(nowSelected, "hard");
					}
				});
				add(hardButton);	
				
			//back 버튼
				backButton.setVisible(false);
				backButton.setBounds(15, 695, 100, 32);
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
				
				
				
		//맨 위 회색 메뉴바
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
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage,170,120,null);
			g.drawImage(titleImage, 170, 50, null);
		}
		paintComponents(g); //메인에서 추가된 이미지들을 보여주는 add부분
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
		
	}
	
	public void selectLeft() {
		if(nowSelected ==0) 
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() - 1) 
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic!=null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainbackground.png")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
	}
	
	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainbackground.png")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		IntroCalimba.close();
		selectTrack(0);
	}

}
