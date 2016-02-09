package tokenz;

public class Role extends Token{
	
	public Role(String classname, String multiplcity){
		super("ROLE");
		this.classname=classname;
		this.multiplcity=multiplcity;
	}
	private String classname;
	private String multiplcity;
	
	public String getClassname(){
		return this.classname;
	}
	
	public String getMultiplcity(){
		return this.multiplcity;
	}
	
	public String toString(){
		String s = "";
		return s + "CLASS "+this.classname+" "+this.multiplcity;
	}
	
}
