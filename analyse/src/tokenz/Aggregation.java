package tokenz;

import java.util.ArrayList;

public class Aggregation extends Token {
	
	public Aggregation(){
		super("AGGREGATION");
		this.part = new ArrayList<Role>();
	}
	
	
	private Role container;
	
	private ArrayList<Role> part;
	
	public void setContain(Role r){
		this.container=r;
	}
	
	public void addPart(Role r){
		this.part.add(r);
	}
	
	public Role getContain(){
		return this.container;
	}
	
	public ArrayList<Role> getPart(){
		return this.part;
	}
	
	
	public String brief(Classes c){
		String s ="";
		String cp = "";
		if(c.getName().equals(this.container.getClassname())){cp="C_";
		}
		else {cp = "P_";}
		if(c.getName().equals("")){
			return s;
			}
		else {
			return s + cp + c.getName();
			}
	}
	
	public String Detail(Classes c){
		String s ="";
		if(!brief(c).equals("")){
		s = s + "AGGREGATION "+"\n"+"\t CONTAINER \n"+"\t CLASS" +this.container.toString()+",\n\t PART"+this.part.toString();
		}
		return s;
	}
	
}
