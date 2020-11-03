package Factory;

import java.awt.Graphics2D;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/notebasic_1.png")).getImage();
	private int x;
	private int y = 580 - 
			(1000 / Main.SLEEP_TIME * Main.NOTE_SPEED); // 노트가 생성되고 1초 뒤에 판정바에 다다르면 인식해서 노트바를 바꿈
	private String noteType;
	
	public Note(int x, String noteType) {
//		if(noteType.equals("S")) {
//			x = 241;
//		}
//		else if(noteType.equals("D")) {
//			x = 379;
//		}
//		else if(noteType.equals("A")) {
//			x = 103;
//		}
//		else if(noteType.equals("W")) {
//			x = 517;
//		}
		this.x =x;
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("short")) {
			g.drawImage(noteBasicImage, x ,y, null);
		} else if (noteType.equals("long")) {
			g.drawImage(noteBasicImage, x ,y, null);
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
