import Final.*;
import Ds.*;

public class TestClass {
	public static void main(String[] args){
		
		try{
			/*
			Person first = new Person("Kim");
			Person second = new Person("Pat");
			   
			System.out.println(first.knows(second));   // should print "false"
			   
			first.meet(second);
			   
			System.out.println(first.knows(second));   // should print "true"
			System.out.println(second.knows(first));   // should print "true"
			   
			first.knows(first);                    // should throw a RuntimeException
			*/
			

		    Person first = new Person("Kim");
		    Person second = new Person("Pat");
		    first.post("Only Kim can read this");

		    first.meet(second);
		    second.post("Friends are awesome");
		    first.post("I agree");

		    first.listMessages();
		    second.listMessages();
		    
		}
		catch (ReferSelfException e){
			System.out.println(e);
		}
		
		StackInterface<Integer> s = new StackVector<Integer>();
		QueueInterface<Integer> q = new QueueNode<Integer>();
		ListInterface<Integer> l = new ListNode<Integer>();
		
		s.push(1);
		s.push(2);
		q.enqueue(3);
		q.enqueue(4);
		l.add(5);
		l.add(6);
		
		Iterator<Integer> S1 = new IteratorStack<Integer>(s);
		Iterator<Integer> Q1 = new IteratorQueue<Integer>(q);
		Iterator<Integer> L1 = new IteratorList<Integer>(l);
		
		Iterator<Integer> S2 = new IteratorStack<Integer>(s);
		Iterator<Integer> Q2 = new IteratorQueue<Integer>(q);
		Iterator<Integer> L2 = new IteratorList<Integer>(l);
		
		Iterator<Integer> S3 = new IteratorStack<Integer>(s);
		Iterator<Integer> Q3 = new IteratorQueue<Integer>(q);
		Iterator<Integer> L3 = new IteratorList<Integer>(l);
		
		IteratorOfIterators itit = new IteratorOfIterators();
		itit.addIterator(S1);
		itit.addIterator(Q1);
		itit.addIterator(L1);
		itit.addIterator(S2);
		itit.addIterator(Q2);
		itit.addIterator(L2);
		itit.addIterator(S3);
		itit.addIterator(Q3);
		itit.addIterator(L3);

		itit.generateIterator();
		itit.iterateThrough();
		
		/*
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
		*/
	}
}
