package FReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import tokenz.*;

public class Ucdreader{

	public Ucdreader(String filename){
		this.file=filename;
	}
	public ArrayList<Classes> ucdclass;
	public ArrayList<Aggregation> ucdagg;
	public ArrayList<Relation> ucdrela;
	public ArrayList<Generalisation> ucdgene;
	
	
	public String file;
	

	public void readUcdFile() throws IOException{
		
		FileReader fr = new FileReader(this.file);
		BufferedReader  br = new BufferedReader(fr);
		
		String s ="";
		String[] tokens;
		String delims =" //t,";
		
		while((s=br.readLine())!=null){
		tokens = s.split(delims);
		switch(tokens[0]){
		case "CLASS":
			Classes c;
			ucdclass.add(c= new Classes(tokens[1]));
			s=br.readLine();
			tokens = s.split(delims);
			if(tokens[0].equals("ATTRIBUTES")){
				s=br.readLine();
				tokens = s.split(delims);
				while(!tokens[0].equals("OPERATIONS")){
				c.addAtt(s);
				s=br.readLine();
				tokens = s.split(delims);
				}
				s=br.readLine();
				tokens = s.split(delims);
				while(!tokens[0].equals(";")){
					c.addOps(s);
				}
			}
			break;
			
			
		case "GENERALISATION":
			Generalisation gls;
			ucdgene.add(gls = new Generalisation(new Classes(tokens[1])));
				s=br.readLine();
				tokens = s.split(delims);
				for(int i=0;i<tokens.length-1;i++){
					gls.addSubclass(new Classes(tokens[i+1]));
				}
			break;
			
		case "RELATION":
			Relation rlt;
			ucdrela.add(rlt = new Relation(tokens[1]));
			br.readLine();
			s=br.readLine();
			tokens = s.split(delims);
			rlt.setFRole(new Role(tokens[1],tokens[2]));
			s=br.readLine();
			tokens = s.split(delims);
			rlt.setSRole(new Role(tokens[1],tokens[2]));
			break;
			
			
		case "AGGREGATION":
			Aggregation agr;
			ucdagg.add(agr = new Aggregation());
			if((s=br.readLine()).equals("CONTAINER")){
				while(!(s=br.readLine()).equals("PARTS")){
					tokens = s.split(delims);
					agr.setContain(new Role(tokens[1],tokens[2]));
				}
				while(!(s=br.readLine()).equals(";")){
					tokens = s.split(delims);
					agr.addPart(new Role(tokens[1],tokens[2]));
				}
			}
			break;	
		}
		}
		
	}
	
	
}
