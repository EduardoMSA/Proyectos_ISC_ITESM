import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TablaHash<K,V> {
	private LinkedList<NodoHT<K,V>>[] tabla;
	private int size;
	private final static double LOAD_FACTOR=0.8;
	public TablaHash() {
		this(17);
	}
	
	public TablaHash(int size) {
		this.tabla= (LinkedList<NodoHT<K, V>>[]) new LinkedList[size];
		for(int i = 0;i<this.tabla.length;i++) {
			this.tabla[i]=new LinkedList<>();
		}
		this.size=0;
	}
	
	public void put(K llave, V valor) {
		if(((double)this.size)/this.tabla.length>=TablaHash.LOAD_FACTOR) {
			this.rehashing();
		}
		int hash = Math.abs(llave.hashCode()%tabla.length);
		LinkedList<NodoHT<K,V>> bucket =this.tabla[hash];
		bucket.addLast(new NodoHT<K,V>(llave,valor));
		this.size++;
	}
	
	public void rehashing() {
		TablaHash<K,V> tablahashTmp =new TablaHash<K,V>(this.tabla.length*2+1);
		NodoHT<K,V> current;
		LinkedList<NodoHT<K,V>> bucket;
		for(int i =0; i<this.tabla.length;i++) {
			bucket =this.tabla[i];
			for(int j=0; j<bucket.size();j++) {
				current=bucket.get(j);
				tablahashTmp.put(current.getLlave(), current.getValor());
			}
		}
		
		this.tabla=tablahashTmp.tabla;
		
	}
	
	public V get(K llave) throws NoSuchElementException{
		int hash=Math.abs(llave.hashCode()%tabla.length);
		LinkedList<NodoHT<K,V>> bucket = this.tabla[hash];
		NodoHT<K,V> current;
		for(int i=0; i<bucket.size();i++) {
			current = bucket.get(i);
			if(bucket.get(i).getLlave().equals(llave)) {
				return bucket.get(i).getValor();
			}
		}
		throw new NoSuchElementException("No se encontró la llave: " + llave);
	}
	
	public V delete(K llave) {
		int hash=Math.abs(llave.hashCode()%tabla.length);
		LinkedList<NodoHT<K,V>> bucket = this.tabla[hash];
		NodoHT<K,V> current;
		for(int i=0; i<bucket.size();i++) {
			current = bucket.get(i);
			if(bucket.get(i).getLlave().equals(llave)) {
				this.size--;
				return bucket.remove(i).getValor();
			}
		}
		throw new NoSuchElementException("No se encontró la llave: " + llave);
	}
	
	//EXTRA
	public LinkedList<K> keys() {
		LinkedList<K> llaves = new LinkedList<>();
		NodoHT<K,V> current;
		LinkedList<NodoHT<K,V>> bucket;
		for(int i =0; i<this.tabla.length;i++) {
			bucket =this.tabla[i];
			for(int j=0; j<bucket.size();j++) {
				current=bucket.get(j);
				llaves.add(current.getLlave());
			}
		}
		return llaves;
	}
	
	//EXTRA
	public LinkedList<V> elements() {
		LinkedList<V> elementos = new LinkedList<>();
		NodoHT<K,V> current;
		LinkedList<NodoHT<K,V>> bucket;
		for(int i =0; i<this.tabla.length;i++) {
			bucket =this.tabla[i];
			for(int j=0; j<bucket.size();j++) {
				current=bucket.get(j);
				elementos.add(current.getValor());
			}
		}
		return elementos;
	}
	
	//EXTRA
	public boolean containsValue(V valor) {
		//return this.elements().contains(valor);
		NodoHT<K,V> current;
		LinkedList<NodoHT<K,V>> bucket;
		for(int i =0; i<this.tabla.length;i++) {
			bucket =this.tabla[i];
			for(int j=0; j<bucket.size();j++) {
				current=bucket.get(j);
				if(current.getValor()==valor) {
					return true;
				}
			}
		}
		return false;
	}
	
	//EXTRA
	public boolean containsKey(K llave) {
		try {
			this.get(llave);
			return true;
		} catch(NoSuchElementException ex) {
			return false;
		}
	}
	
	//EXTRA
	public void clear() {
		this.tabla= (LinkedList<NodoHT<K, V>>[]) new LinkedList[17];
		for(int i = 0;i<this.tabla.length;i++) {
			this.tabla[i]=new LinkedList<>();
		} 
		this.size=0;
	}
	
	public static void main(String[] args) {
		TablaHash<String, Integer> tabla = new TablaHash<>(13);
		tabla.put("uno",1);
		tabla.put("dos",2);
		tabla.put("tres",3);
		tabla.put("cuatro",4);
		tabla.put("cinco",5);
		tabla.put("seis",6);
		tabla.put("siete",7);
		tabla.put("ocho",8);
		tabla.put("nueve",9);
		tabla.put("diez",10);
		tabla.put("once",11);
		tabla.put("doce",12);
		tabla.put("trece",13);
		tabla.put("catorce",14);
		/*System.out.println(tabla.get("uno"));
		System.out.println(tabla.get("dos"));
		System.out.println(tabla.get("tres"));
		System.out.println(tabla.get("cuatro"));
		System.out.println(tabla.get("cinco"));
		System.out.println(tabla.get("seis"));
		System.out.println(tabla.get("siete"));
		System.out.println(tabla.get("ocho"));
		System.out.println(tabla.get("nueve"));
		System.out.println(tabla.get("diez"));
		System.out.println(tabla.get("once"));
		System.out.println(tabla.get("doce"));
		System.out.println(tabla.get("trece"));
		System.out.println(tabla.get("catorce"));*/
		
		/*LinkedList<String> llaves = tabla.keys();
		for(int i = 0; i<llaves.size();i++) {
			System.out.println(llaves.get(i));
		}
		
		LinkedList<Integer> elements = tabla.elements();
		for(int i = 0; i<elements.size();i++) {
			System.out.println(elements.get(i));
		}*/
		
		System.out.println(tabla.containsValue(7));
		tabla.clear();
		System.out.println(tabla.containsValue(7));
	
	}
	
	
	
}

class NodoHT<K,V>{
	private K llave;
	private V valor;
	
	public NodoHT(K llave, V valor) {
		this.llave=llave;
		this.valor=valor;
	}
	
	
	public K getLlave() {
		return this.llave;
	}
	public void setLlave(K llave) {
		this.llave=llave;
	}
	public V getValor() {
		return this.valor;
	}
	public void setValor(V valor) {
		this.valor=valor;
	}
	
}