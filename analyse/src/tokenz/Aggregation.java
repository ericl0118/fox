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
	
	public String allPartsToString(){
		String s = "";
		for(Role pa : this.part){
			s+="\t\t" + pa.toString()+"\n";
		}
		return s;
	}
	
	public String brief(Classes c){
		String s ="";
		if(c.getName().equals(this.container.getClassname())){
			for(int i =0 ; i < this.part.size();i++){
				s = s + "(A)P_"+this.getPart().get(i).getClassname()+"\n";
			}
		}
		else for(Role pa : this.getPart()){
			if(pa.getClassname().equals(c.getName())){
			s = s+ "(A)C_"+this.container.getClassname();}}
		return s;
	}
	
	public String Detail(Classes c){
		String s ="";
		if(!brief(c).equals("")){
		s = s + "AGGREGATION "+"\n"+"\t CONTAINER \n"+"\t\t" +this.container.toString()+",\n\t PART \n"+this.allPartsToString();
		}
		return s;
	}
	
}
