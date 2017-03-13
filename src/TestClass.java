import Final.*;

public class TestClass {
	public static void main(String[] args){
		
		DictionaryInterface<String, Integer> d = new Dictionary<String, Integer>();
		d.add("First", 1);
		d.add("First", 2);
		d.add("First", 3);
		d.add("Second", 4);
		d.add("Second", 5);
		d.add("Second", 2);
		d.remove("First");
		d.add("Third", 2);
		d.add("Fourth", 2);
		d.add("Fourth", 6);
		d.add("Fourth", 7);
		
		Iterator<String> it = d.getKeyIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		Iterator<Integer> Vit = d.getValueIterator();
		while(Vit.hasNext()){
			System.out.println(Vit.next());
		}

	}
}
