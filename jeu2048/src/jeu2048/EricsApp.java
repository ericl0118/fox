package jeu2048;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
public class EricsApp {
	 public static void main(String[] args){
		JFrame f = new JFrame("JEU 2048");
        EricsPanel ef = new EricsPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(ef);
        f.setSize(500,600);
        f.setLocation(100,100);
        f.setVisible(true);
       
    }
    static class EricsPanel extends JPanel{
		ProgramDeJeu game;
		private JLabel scoreJL ;
		private JButton newgameJB;
		private JLabel comboJL;
		private GameBord gb;
		private JTextField gamestatusJTF;
		public EricsPanel(){
			creerObjets();
			placeObjets();	
		}
		private void creerObjets(){
			game = new ProgramDeJeu();
			gamestatusJTF = new JTextField(8);
			scoreJL = new JLabel();
			scoreJL.setText("SCORE : "+game.getscore());
			scoreJL.setFont(new Font("Serif",Font.BOLD,16));
			scoreJL.setForeground(new Color(255,255,255));
			
			comboJL= new JLabel();
			comboJL.setText("COMBO : "+game.getcombo());
			comboJL.setFont(new Font("Serif",Font.BOLD,16));
			comboJL.setForeground(new Color(255,255,255));
			
			newgameJB = new JButton("NEW GAME");
			newgameJB.setFont(new Font("Serif",Font.BOLD,13));
			newgameJB.setForeground(new Color(255,255,255));
			newgameJB.setBackground(new Color(163,201,163));
			newgameJB.setOpaque(true);
			newgameJB.setPreferredSize(new Dimension(90,60));
			newgameJB.setBorder(BorderFactory.createEtchedBorder());
			gb = new GameBord();
			
		}
		class MyKeyListener implements KeyListener{
			private String key;
			public void keyPressed(KeyEvent event){	
				key = KeyStroke.getKeyStrokeForEvent(event).toString();
				key=key.replace("pressed","");
				if(key.charAt(1)=='U'){
					game.Up();
					scoreJL.setText("SCORE : "+game.getscore());
					scoreJL.setFont(new Font("Serif",Font.BOLD,16));
					scoreJL.setForeground(new Color(255,255,255));
					comboJL.setText("COMBO : "+game.getcombo());
					comboJL.setFont(new Font("Serif",Font.BOLD,16));
					comboJL.setForeground(new Color(255,255,255));
					if(game.check2048()){gamestatusJTF.setText("YOU WIN!!");}
					else if(game.finishCheck()){gamestatusJTF.setText("GAME OVER");}
					else{
					if(game.getcombo()>2){gamestatusJTF.setText(game.getcombo()+"fois points!");}
					if(game.getcombo()<3){gamestatusJTF.setText("");}}
					gb.repaint();
					}
				if(key.charAt(1)=='D'){
					game.Down();
					scoreJL.setText("SCORE : "+game.getscore());
					scoreJL.setFont(new Font("Serif",Font.BOLD,16));
					scoreJL.setForeground(new Color(255,255,255));
					comboJL.setText("COMBO : "+game.getcombo());
					comboJL.setFont(new Font("Serif",Font.BOLD,16));
					comboJL.setForeground(new Color(255,255,255));
					if(game.check2048()){gamestatusJTF.setText("YOU WIN!!");}
					else if(game.finishCheck()){gamestatusJTF.setText("GAME OVER");}
					else{
					if(game.getcombo()>2){gamestatusJTF.setText(game.getcombo()+"fois points!");}
					if(game.getcombo()<3){gamestatusJTF.setText("");}}
					gb.repaint();
					}
				if(key.charAt(1)=='L'){
					game.Left();
					scoreJL.setText("SCORE : "+game.getscore());
					scoreJL.setFont(new Font("Serif",Font.BOLD,16));
					scoreJL.setForeground(new Color(255,255,255));
					comboJL.setText("COMBO : "+game.getcombo());
					comboJL.setFont(new Font("Serif",Font.BOLD,16));
					comboJL.setForeground(new Color(255,255,255));
					if(game.check2048()){gamestatusJTF.setText("YOU WIN!!");}
					else if(game.finishCheck()){gamestatusJTF.setText("GAME OVER");}
					else{
					if(game.getcombo()>2){gamestatusJTF.setText(game.getcombo()+"fois points!");}
					if(game.getcombo()<3){gamestatusJTF.setText("");}}
					gb.repaint();
					}
				if(key.charAt(1)=='R'){
					game.Right();
					scoreJL.setText("SCORE : "+game.getscore());
					scoreJL.setFont(new Font("Serif",Font.BOLD,16));
					scoreJL.setForeground(new Color(255,255,255));
					comboJL.setText("COMBO : "+game.getcombo());
					comboJL.setFont(new Font("Serif",Font.BOLD,16));
					comboJL.setForeground(new Color(255,255,255));
					if(game.check2048()){gamestatusJTF.setText("YOU WIN!!");}
					else if(game.finishCheck()){gamestatusJTF.setText("GAME OVER");}
					else{
					if(game.getcombo()>2){gamestatusJTF.setText(game.getcombo()+"fois points!");}
					if(game.getcombo()<3){gamestatusJTF.setText("");}}
					gb.repaint();
					}game.display();
			}
		public void keyTyped(KeyEvent e) {
		}
		public void keyReleased(KeyEvent e) {	
		}
	}
		class MyActionListener implements ActionListener{

				public void actionPerformed(ActionEvent e) {
				if(e.getSource()==newgameJB){
					layoutHaut();
					gb.repaint();
					creerObjets();
					placeObjets();		
				}	
			}	
		}
		public void placeObjets(){
			setLayout(new BorderLayout());
			add(layoutHaut(),BorderLayout.NORTH);
			add(gb,BorderLayout.SOUTH);
		}
		private JPanel layoutHaut(){
			JPanel p = new JPanel();
			KeyListener k = new MyKeyListener();
			ActionListener a = new MyActionListener();
			p.setPreferredSize(new Dimension(500,78));
			p.setBackground(new Color(144,168,215));
			p.setLayout(new FlowLayout());
			p.setFocusable(true);
			p.add(scoreJL);
			p.add(comboJL);
			gamestatusJTF.setEditable(false);
			p.add(gamestatusJTF);
			newgameJB.addActionListener(a);
			p.add(newgameJB);
			p.addKeyListener(k);
			return p;
		}
		public Color CellColor(int x){
			switch (x){
			case 2: return new Color(249,225,184);
			case 4:	return new Color(249,208,137);
			case 8: return new Color(249,187,80);
			case 16:return new Color(255,148,40);
			case 32:return new Color(255,128,0);
			case 64:return new Color(255,151,151);
			case 128:return new Color(249,111,111);
			case 256:return new Color(255,78,78);
			case 512:return new Color(249,47,47);
			case 1024:return new Color(215,0,0);
			case 2048:return new Color(161,0,0);
			}return new Color(225,219,216);
		}
		
		class GameBord extends JPanel{
			public Dimension getPreferredSize(){
				return new Dimension(500,500);
			}
			public void paintComponent(Graphics g){
				setLayout(new GridLayout(4,4));
						for(int i =0;i<4;i++){
							for(int j=0;j<4;j++){
					
					for(int k =0;k<10;k++){
					g.setColor(new Color(236,239,188));
					g.fillRect(i*125+k, j*125+k, 125-k/2, 125-k/2);}
					g.setColor(CellColor(game.getGameBorad()[j][i]));
				    g.fillRect(i*125+9, j*125+9, 108, 108);
					g.setColor(new Color(130,133,223));
					Font cellFont = new Font("Verdana",Font.BOLD,(int) 125/4);
					g.setFont(cellFont);
					g.drawString(Integer.toString(game.getGameBorad()[j][i]),125*i+48,125*j+75);
				    }
							}
					}}
		
	}
}
	
