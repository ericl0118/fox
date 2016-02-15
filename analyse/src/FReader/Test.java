package FReader;

import java.io.IOException;

import tokenz.*;

public class Test {
	 public static void main(String args[]) throws IOException{
	
	Ucdreader urd = new Ucdreader("Ligue.ucd.txt");
	urd.readUcdFile();
	int j =1;
	int i =1;
	int k =1;
	int v =1;
	for(Classes u : urd.ucdclass){
	System.out.print("\n\nCLASS N# :"+j+":\n");
	System.out.print("class read :"+u.getName()+"\n");
	System.out.print("attribute read :"+u.getAtt()+"\n");
	System.out.print("operation read :"+u.getOps()+"\n");
	j++;	
	}
	for(Generalisation g : urd.ucdgene){
	System.out.print("\n\nGENERALISATION N# :"+v+":\n");
	System.out.print("class read :"+g.getGName()+"\n");
		for(Classes x :  g.getSubclass()){
			System.out.print("subclass read :"+x.getName()+"\n");
		}
		v++;	
	}
	for(Relation r : urd.ucdrela){
	System.out.print("\n\nRELATION N# :"+i+":\n");
	System.out.print("class read :"+r.getRName()+"\n");
	System.out.print("first role read :"+r.getFRole().toString()+"\n");
	System.out.print("second role read :"+r.getSRole().toString()+"\n");
	System.out.print("test brief :"+r.brief(urd.ucdclass.get(0))+"\n");
	System.out.print("test detail :"+r.Detail(urd.ucdclass.get(0)));
	i++;
	}
	for(Aggregation a : urd.ucdagg){
		System.out.print("\n\nAGGREGATION N# :"+k+":\n");
		System.out.print("container read :"+a.getContain()+"\n");
		System.out.print("parts read :"+a.getPart()+"\n");
		System.out.print("test brief : "+a.brief(urd.ucdclass.get(0))+"\n");
		System.out.print("test detail :"+a.Detail(urd.ucdclass.get(0)));
		k++;
		}
	}
}
