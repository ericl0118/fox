package tokenz;

import java.util.ArrayList;

public class Classes extends Token{
	
	public Classes(String name){
		super("CLASS");
		this.name=name;
		this.operations = new ArrayList<String>();
		this.attributes = new ArrayList<String>();
	}
	private String name;
	private ArrayList<String> operations;
	private ArrayList<String> attributes;
	
	public ArrayList<String> getOps(){
		return this.operations;
	}
	public ArrayList<String> getAtt(){
		return this.attributes;
	}
	public void addOps(String op){
		this.operations.add(op);
	}
	public void addAtt(String at){
		this.attributes.add(at);
	}
	public String getName(){
		return this.name;
	}
	
}
