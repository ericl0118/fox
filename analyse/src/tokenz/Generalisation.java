package tokenz;

import java.util.ArrayList;

public class Generalisation extends Token{
	
	public Generalisation(Classes c){
		super("GENERALISATION");
		this.name=c.getName();	
		this.Subclass = new ArrayList<Classes>();
	}
	private String name;
	
	private ArrayList<Classes> Subclass;
	
	public String getGName(){
		return this.name;
	}
	
	public void addSubclass(Classes c){
		this.Subclass.add(c);
	}
	
	public ArrayList<Classes> getSubclass(){
		return this.Subclass;
	}
	
}
