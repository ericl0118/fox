package jeu2048;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<Integer> number = new ArrayList<>();
		number.add(0);
		number.add(0);
		number.add(0);
		number.add(0);
		System.out.println(number.toString());
		System.out.println(checkArray(number));
	}
	static public boolean checkArray(ArrayList<Integer> a){
		int temp=-1;
		int sum =0;
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
}