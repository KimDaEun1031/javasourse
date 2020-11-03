package Factory;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	
	
	private Image judgementImage = new ImageIcon(Main.class.getResource("../images/judgementbar.png")).getImage();
	private Image notebarImage = new ImageIcon(Main.class.getResource("../images/notebar.png")).getImage();
	private Image musicbarImage = new ImageIcon(Main.class.getResource("../images/musicbar.png")).getImage();
	private Image noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteWImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		gameMusic.start();
		dropNotes(titleName);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteAImage,103,0,null);//노트바 
		g.drawImage(noteRouteSImage,241,0,null); 
		g.drawImage(noteRouteDImage,379,0,null); 
		g.drawImage(noteRouteWImage,517,0,null); 
		g.drawImage(notebarImage,95,-50,null); //회색세로줄바	
		g.drawImage(notebarImage,233 ,-50,null);		
		g.drawImage(notebarImage,371,-50,null);		
		g.drawImage(notebarImage,509,-50,null);
		g.drawImage(notebarImage,647,-50,null);
		g.drawImage(musicbarImage, 0, 700, null);//맨 아래
		g.drawImage(judgementImage, 0, 580, null);//판정바
		for(int i=0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			note.screenDraw(g);
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString(titleName, 10 , 735);
		g.drawString(difficulty, 680, 735);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.setColor(Color.white);
		g.drawString("A", 155, 615);
		g.drawString("S", 295, 615);
		g.drawString("D", 431, 615);
		g.drawString("W", 569, 615);
		g.setFont(new Font("Consolas", Font.BOLD, 50));
		g.setColor(Color.black);
		g.drawString("000000", 294, 100);	
		
		
	}	
	
	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRouteenter.png")).getImage();
		new Music("drum.mp3", false).start();
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();		
	}
	
	public void pressA() {
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRouteenter.png")).getImage();	
		new Music("drum.mp3", false).start();
	}
	
	public void releaseA() {
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();		
	}
	
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRouteenter.png")).getImage();		
		new Music("drum.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();		
	}
	
	public void pressW() {
		noteRouteWImage = new ImageIcon(Main.class.getResource("../images/noteRouteenter.png")).getImage();	
		new Music("drum.mp3", false).start();
	}
	
	public void releaseW() {
		noteRouteWImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();		
	}
	
	
	@Override
	public void run() {	
//		dropNotes();
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		Note note = new Note(103, "short");
		note.start();
		noteList.add(note);
		
//		Beat[] beats = {
//				new Beat(1000, "A"),
//				new Beat(2000, "S"),
//				new Beat(3000, "D"),
//				new Beat(4000, "W"),
//		};
//		int i = 0;
//		while(true) {
//			if(beats[i].getTime() <= gameMusic.getTime()) {
//				Note note = new Note(beats[i].getNoteName());
//				note.start();
//				noteList.add(note);
//				i++;
//			}
//		}

	}
	
}
