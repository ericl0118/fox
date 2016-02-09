package jeu2048;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe qui implante une sÃ©quence d'entiers positifs ou nuls initialement vide.
 * Les elements y sont ajoutes un par un jusqu'Ã  un appel a  shift
 * qui "compresse" ces elements qui peuvent ensuite etre enleves un
 * par un, lorsqu'il ne reste plus de valeur dans la serie, enlever retourne 0
 * 
 * @author Guy Lapalme, UniversitÃ© de MontrÃ©al, 2014
 *
 */
public class Serie {
	
	private List <Integer> serie;
	private boolean shifted;
	/**
	 * crÃ©ation de la sÃ©rie initialement vide 
	 */
	Serie(){
		serie=new ArrayList<Integer>();
		shifted=false;
	}
	public int longeur(){
		return serie.size();
	}
	public int element(int a){
		return serie.get(a);
	}
	public boolean shiftstate(){
		return shifted;
	}

	public String toString(){
		return serie+":"+shifted;
	}
	
	/**
	 * Ajoute un entier i positif ou nul Ã  la sÃ©rie
	 * LÃ¨ve une <code>IllegalArgumentException</code> si <code>shift</code> a dÃ©jÃ  Ã©tÃ© appelÃ©
	 * LÃ¨ve une <code>IllegalArgumentException</code> si <code>i</code> est nÃ©gatif
	 * @param i entier ajoutÃ©
	 */
	public void ajouter(int i){
		if(shifted)
			throw new IllegalArgumentException("ajouter apres shift:"+this);
		if(i<0)
			throw new IllegalArgumentException("ajouter("+i+") argument negatif:"+this);
		serie.add(i);
	}
	
	/**
	 * Enleve l'element du debut de la serie et le retourne.
	 * Retourne 0 s'il ne reste plus d'element dans la serie.
	 * LÃ¨ve une <code>IllegalArgumentException</code> si <code>shift</code> n'a pas Ã©tÃ© appelÃ© 
	 * 
	 * @return valeur de l'Ã©lÃ©ment enlevÃ©
	 */
	public int enlever(){
		if(!shifted)
			throw new IllegalArgumentException("enlever avant shift:"+this);
		if(serie.size()==0) return 0;
		return serie.remove(0);
	}
	
	/**
	 * Compresse une sÃ©quence en enlevant d'abord toutes les valeurs Ã©gales Ã  0.
	 * Parcourt ensuite la sÃ©quence rÃ©sultante en comprimant deux valeurs Ã©gales.
	 * 
	 * @return le total des valeurs comprimÃ©es.
	 */
	public int shift(){
		int pts=0;
		// enlever tous les 0
		for(Iterator<Integer> it=serie.iterator();it.hasNext();)
			if(it.next()==0){it.remove();}
		// eliminer les deux identiques
		for(int i=1;i<serie.size();i++){
			int v=serie.get(i-1);
			if(serie.get(i)==v){
				serie.set(i-1,v*2);
				pts+=v*2;
				serie.remove(i);
			}
		}
		shifted=true;
		return pts;
	}
	
}