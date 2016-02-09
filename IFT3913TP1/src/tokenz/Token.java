package tokenz;

public class Token {
	
	public Token(String ID){
		this.id=ID;
	}
	private String id;
	
	protected String getID(){
		return this.id;
	}
}
