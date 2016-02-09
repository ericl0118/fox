package jeu2048;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ProgramDeJeu  extends JComponent implements Move{
	private int[][] gameborad;
	private int score;
	private int scoreperstep;
	private boolean moved;
	private int moves;
	private int indiceX;
	private int indiceY;
	private Serie[] command = new Serie[4];
	private int combo=0;
		
	public int random()
	{
		return (int) (Math.random()*4);
	}
	
	public ProgramDeJeu()
	{
		gameborad = new int[4][4];
		int i =0;
		while(i<2){
			this.addACase();
			i++;}
	}
	public int getcombo(){
		return combo;
	}
	public int getscore(){
	return score;
	}
	
	//find a free case before add a case after every move
	public boolean checkStatus(int a ,int b )
	{
		if(gameborad[a][b]==0)return true;
		return false;
	}
	public int[][] getGameBorad(){
		return gameborad;
	}
	
	public boolean checkArray(ArrayList<Integer> a){
		int temp=-1;int sum =0;
		for( int i=0;i<a.size();i++){
			sum+=a.get(i);
		}
		if(sum==0)return false;
		while(a.size()>0){
			if(a.size()==1&&a.get(0)==temp){System.out.println("me");return true;}
			else if(a.size()==1)return false;
			else if(a.get(0)!=0){
			if(a.get(0)==temp)return true;
		    temp = a.get(0);a.remove(0);
			if(a.get(0)==0)a.remove(0);
			else if(a.get(0)==temp)return true;
		}else a.remove(0);
			}
		return false;
}
	
	//check if we can move to "up" direction
	public boolean checkUp()
	{
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(gameborad[j][i]==0){
					while(j<3){j++;
					if(gameborad[j][i]!=0){
					return true;
					}
					}
					}
			}
		}
		
		for(int i =0;i<4;i++){ArrayList<Integer> temp = new ArrayList<>();
			for(int j=0;j<4;j++){
				temp.add(gameborad[j][i]);
				
			}if(checkArray(temp))return true;
			
		}	return false;
	}
	
	//chech if we can move the case to "down" direction
	public boolean checkDown()
	{
		for(int i=0;i<4;i++){
			for(int j=3;j>=0;j--){
				if(gameborad[j][i]==0){
					while(j>=1){j--;
					if(gameborad[j][i]!=0){
						return true;
					}
				}
			}
			}}
		for(int i =0;i<4;i++){ArrayList<Integer> temp = new ArrayList<>();
		for(int j=0;j<4;j++){
			temp.add(gameborad[j][i]);
			
		}if(checkArray(temp))return true;
	}
		
		return false;
	}
	
	//check if we can move to the "right" direction
	public boolean checkRight(){
			for(int i=0;i<4;i++){
				for(int j=3;j>=0;j--){
					if(gameborad[i][j]==0){
						while(j>=1){j--;
						if(gameborad[i][j]!=0){
							return true;
						}
					}
				
					}}}
			for(int i =0;i<4;i++){ArrayList<Integer> temp = new ArrayList<>();
			for(int j=0;j<4;j++){
				temp.add(gameborad[i][j]);
				
			}if(checkArray(temp))return true;
		}
			
			return false;	
	}
	
	//check if we can move to the "left" direction
	public boolean checkLeft(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(gameborad[i][j]==0){
					while(j<3){j++;
					if(gameborad[i][j]!=0){
						return true;
					}
				}
			}}
	}
		for(int i =0;i<4;i++){ArrayList<Integer> temp = new ArrayList<>();
		for(int j=0;j<4;j++){
			temp.add(gameborad[i][j]);
			
		}if(checkArray(temp))return true;
	}
		return false;
	}
	
	//display the object programdejeu
	public void display(){
		System.out.println("Score : "+score);
		System.out.println("Score per step :"+ scoreperstep);
		System.out.println("combo : "+ combo);
		for(int i=0;i<4;i++){
			System.out.println(Arrays.toString(gameborad[i]));
		}
		if(finishCheck()){
			System.out.println("Game Over !");
			System.out.println(checkUp());
		}
		
	}
	
	// add randomly a case to a free case
	public void addACase()
	{
		indiceX=random(); indiceY=random();
		while(!checkStatus(indiceX,indiceY))
		{
		indiceX=random(); indiceY=random();
		}
		if(random()<2)
			gameborad[indiceX][indiceY]=2;
		else 
			gameborad[indiceX][indiceY]=4;
	}
	
	public void moveUp()
	{	scoreperstep=0;
		for(int i =0;i<4;i++){
			command[i]=new Serie();
		}
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
		command[i].ajouter(gameborad[j][i]);
			}
		}
		for(int i=0;i<4;i++){
			scoreperstep+=command[i].shift();
			
		}
		if(scoreperstep!=0){
			combo+=1;
		}
		else {combo=0;}
		scoreperstep=scoreperstep*(combo);
		score+=scoreperstep;
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(command[i].longeur()!=0){
				gameborad[j][i] = command[i].element(0);
				command[i].enlever();
				}
				else gameborad[j][i]=0;
				}
		}
	}
	
	public void moveDown()
	{
		scoreperstep=0;
		command =new Serie[4];
		for(int i=0;i<4;i++){command[i] = new Serie();
			for(int j=3;j>=0;j--){
		command[i].ajouter(gameborad[j][i]);
			}
		}
		for(int i=0;i<4;i++){
			scoreperstep+=command[i].shift();
		}
		if(scoreperstep!=0){
			combo+=1;
		}
		else {combo=0;}
		scoreperstep=scoreperstep*(combo);
			score+=scoreperstep;
		for(int i=0;i<4;i++){
			for(int j=3;j>=0;j--){
				if(command[i].longeur()!=0){
				gameborad[j][i] = command[i].element(0);
				command[i].enlever();
				}
				else gameborad[j][i]=0;
				}
		}
	}
	
	public void moveRight()
	{	scoreperstep =0;
		command =new Serie[4];
		for(int i=0;i<4;i++){command[i] = new Serie();
			for(int j=3;j>=0;j--){
		command[i].ajouter(gameborad[i][j]);
			}
		}
		for(int i=0;i<4;i++){
			scoreperstep+=command[i].shift();
		}
		if(scoreperstep!=0){
			combo+=1;
		}
		else {combo=0;}
		scoreperstep=scoreperstep*(combo);
			score+=scoreperstep;
		for(int i=0;i<4;i++){
			for(int j=3;j>=0;j--){
				if(command[i].longeur()!=0){
				gameborad[i][j] = command[i].element(0);
				command[i].enlever();
				}
				else gameborad[i][j]=0;
				}
		}
		
	}
	
	public void moveLeft()
	{	
		scoreperstep=0;
		command =new Serie[4];
		for(int i=0;i<4;i++){command[i] = new Serie();
			for(int j=0;j<4;j++){
		command[i].ajouter(gameborad[i][j]);
			}
		}
		for(int i=0;i<4;i++){
			scoreperstep+=command[i].shift();
		}
		if(scoreperstep!=0){
			combo+=1;
		}
		else {combo=0;}
		scoreperstep=scoreperstep*(combo);
			score+=scoreperstep;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(command[i].longeur()!=0){
				gameborad[i][j] = command[i].element(0);
				command[i].enlever();
				}
				else gameborad[i][j]=0;
				}
		}
		
	}
	
	//check the game status
	public boolean finishCheck()
	{
		for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			if(check2048())
				{ System.out.println("Congratulations!!");return true;}
			else if(gameborad[i][j]==0)
					return false;
		}
	}
		if(checkUp()||checkDown()||checkLeft()||checkRight())return false;
	else return true;
}
	
	public boolean check2048()
	{
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(gameborad[i][j]==2048){
					return true;
				}
			}
		}return false;
	}
	
	public void Up(){
		if(checkUp()==true){
			moveUp(); addACase();}
	}
	
	public void Down(){
		if(checkDown()==true){
			moveDown();addACase();}
	}
	
	public void Left(){
		if(checkLeft()){
			moveLeft();addACase();}
		
	}
	
	public void Right(){
		if(checkRight()){	
			moveRight();addACase();}
	}	
		
}

	

