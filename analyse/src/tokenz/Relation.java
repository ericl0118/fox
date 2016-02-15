package tokenz;

import java.util.ArrayList;



public class Relation extends Token{

	public Relation(String name){
		super("RELATION");
		this.name=name;
		
	}
	
	private String name;
	
	private Role firstrole;
	
	private Role secondrole;
	
	public Role getFRole(){
		return this.firstrole;
	}
	public Role getSRole(){
		return this.secondrole;
	}
	public void setFRole(Role r){
		this.firstrole=r;
	}
	public void setSRole(Role r){
		this.secondrole=r;
	}
	
	public String getRName(){
		return this.name;
	}
	
	public String brief(Classes c){
		String s ="";
		if(c.getName().equals(this.firstrole.getClassname())){
			return s+"(R)"+this.getRName(); 
		}
		else if(c.getName().equals(this.secondrole.getClassname())){
			return s+"(R)inv_"+this.getRName();
		}
		else return s;
	}
	public String Detail(Classes c){
		String s ="";
		if(!brief(c).equals("")){
		s = s + "RELATION "+this.getRName()+"\n"+"\t ROLES \n\t\t"+ this.firstrole.toString()+",\n\t\t"+this.secondrole.toString();
		}
		return s;
	}
}
