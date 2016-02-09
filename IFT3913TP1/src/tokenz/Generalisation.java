package tokenz;

import java.util.ArrayList;

public class Generalisation extends Token{
	
	public Generalisation(Classes c){
		super("GENERALISATION");
		this.name=c.getName();	
	}
	private String name;
	
	private ArrayList<Classes> Subclass;
	
	public String getGName(){
		return this.name;
	}
	
	public void addSubclass(Classes c){
		this.Subclass.add(c);
	}
	
}
