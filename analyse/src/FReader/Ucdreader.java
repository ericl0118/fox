package FReader;//generation line 89

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
		this.ucdclass = new ArrayList<Classes>();
		this.ucdagg = new ArrayList<Aggregation>();
		this.ucdrela = new ArrayList<Relation>();
		this.ucdgene = new ArrayList<Generalisation>();
		
	}
	public ArrayList<Classes> ucdclass;
	public ArrayList<Aggregation> ucdagg;
	public ArrayList<Relation> ucdrela;
	public ArrayList<Generalisation> ucdgene;
	
	
	public String file;
	

	public void readUcdFile() throws IOException{
		
		FileReader fr = new FileReader(this.file);
		BufferedReader  br = new BufferedReader(fr);
		int flag=0;
		
		String s ="";
		String[] tokens;
		String delims ="\\s+|,|\\t";
		loops:
		while((s=br.readLine())!=null){// yao gai bu yan jing
			while(s.isEmpty() || s.trim().equals("") || s.trim().equals("\n")||s.trim().equals(";")){
				s=br.readLine();
				if(s==null){break loops;}
				}
		flag++;
		int tokennumber=0;
		tokens = s.split(delims);
		System.out.print("String:"+flag+" "+s+" \n");
		for(String part : tokens){
			
			tokennumber++;
			System.out.print("Token"+tokennumber+":"+part+" \n");
		}
		
		switch(tokens[0]){
		
		case "CLASS":
			Classes c = new Classes(tokens[1]);
			ucdclass.add(c);
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
					s=br.readLine();
					tokens = s.split(delims);
				}
			}
			break;
			
			
		case "GENERALIZATION":
			System.out.print("in generalisation loop! \n");
			System.out.print("class name in gene is :"+tokens[1]+"\n");
			Classes g = new Classes(tokens[1]);
			Generalisation gls = new Generalisation(g);
			ucdgene.add(gls);
				s=br.readLine();
				tokens = s.split(delims);
				System.out.print("testing generalisation token[0]:"+s+"\n");
				for(int i=0;i<tokens.length;i++){ 
					if(!tokens[i].isEmpty()&&!tokens[i].equals("SUBCLASSES")){
						System.out.print("find token:"+tokens[i]+"@"+i+"\n");
						gls.addSubclass(new Classes(tokens[i]));
					}
				}
			break;
			
		case "RELATION":
			Relation rlt;
			ucdrela.add(rlt = new Relation(tokens[1]));
			br.readLine();
			s=br.readLine();
			tokens = s.split(delims);
			System.out.print("relation testing :"+tokens[2]+tokens[3]+"\n");
			rlt.setFRole(new Role(tokens[2],tokens[3]));
			s=br.readLine();
			tokens = s.split(delims);
			rlt.setSRole(new Role(tokens[2],tokens[3]));
			break;
			
			
		case "AGGREGATION":
			Aggregation agr = new Aggregation();
			System.out.print("now in aggregation loop ! \n");
			ucdagg.add(agr);
			s=br.readLine();
			tokens =s.split(delims);
			System.out.print("aggregation testing !!!"+s+"\n");
			if(tokens[0].equals("CONTAINER")){
				
				while(!(s=br.readLine()).equals("PARTS")){
					
					tokens = s.split(delims);
					agr.setContain(new Role(tokens[2],tokens[3]));
				}
				while(!(s=br.readLine()).equals(";")){
					tokens = s.split(delims);
					agr.addPart(new Role(tokens[2],tokens[3]));
					}
				}
			break;
			
			}  //end of switch loop
		
		
		}br.close(); //end of while loop
		
		
		
	}
	
	
}
