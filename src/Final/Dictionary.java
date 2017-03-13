package Final;
import Ds.ListInterface;
import Ds.ListNode;

public class Dictionary<K, V> implements DictionaryInterface<K, V>{

	private ListNode<NodeKV<K, V>> nodeKVList;
	private ListNode<NodeKV<V, K>> valueList; // key becomes the value, value becomes keys referencing it
	
	
	private class NodeKV<Key, Value>{ // node that points to a List of Values
		private Key key;
		private ListInterface<Value> vals;
		
		public NodeKV(Key k){
			key = k;
			vals = new ListNode<Value>();
		}
		
		public void addValue(Value v){ // v should be from the valueList
			vals.add(v);
		}
		
		public void removeValue(Value v){
			vals.remove(vals.indexOf(v));
		}
		
	}
	
	public Dictionary(){
		this.nodeKVList = new ListNode<NodeKV<K, V>>();
		this.valueList = new ListNode<NodeKV<V, K>>();
	}
	
	//get NodeKV that has key, else null
	private NodeKV<K, V> getNodeKV(K key){
		NodeKV<K, V> temp = null;
		for (int i = 0; i < nodeKVList.getLength(); i++){ 
			if (nodeKVList.getEntry(i).key == key){
				temp = nodeKVList.getEntry(i);
				break;
			}
		}
		return temp;
	}
	
	private NodeKV<V, K> getValueNodeKV(V value){
		NodeKV<V, K> temp = null;
		for (int i = 0; i < valueList.getLength(); i++){ 
			if (valueList.getEntry(i).key == value){
				temp = valueList.getEntry(i);
				break;
			}
		}
		return temp;
	}
	
	@Override
	public void add(K key, V value) {
		NodeKV<K, V> temp = getNodeKV(key);
		
		if(temp != null){ // if already existing, add to NodeKV's list
			temp.addValue(value);
		}
		else{ //if not existing, make new NodeKV and add to NodeKV's list
			temp = new NodeKV<K, V>(key);
			temp.addValue(value);
			nodeKVList.add(temp);
		}
		
		NodeKV<V, K> tempVal = getValueNodeKV(value);
		if (tempVal != null){ // if value does not exist, add it to value list
			tempVal.addValue(temp.key);
		}
		else{ 
			tempVal = new NodeKV<V, K>(value);
			tempVal.addValue(key);
			valueList.add(tempVal);
		}
		
	}

	public V[] remove(K key) {
		V[] vTemp = null;
		
		NodeKV<K, V> temp = getNodeKV(key);
		if (temp != null){
			
			// remove key from val nodes
			Iterator<NodeKV<V, K>> it = new IteratorList<NodeKV<V, K>>(valueList);
			while (it.hasNext()){
				NodeKV<V, K> tempValNode = it.next();
				if (tempValNode.vals.contains(key)){
					tempValNode.removeValue(key);
				}
				//if no key pointing to value, remove
				if (tempValNode.vals.isEmpty()){
					this.valueList.remove(this.valueList.indexOf(tempValNode));
				}
			}
			
			// makes array of vals
			vTemp = temp.vals.toArray();
			//removes from list
			nodeKVList.remove(nodeKVList.indexOf(temp));
			
		}
		return vTemp;
	}

	@Override
	public V[] getValues(K key) {
		V[] vTemp = null;
		
		NodeKV<K, V> temp = getNodeKV(key);
		if (temp != null){
			vTemp = temp.vals.toArray();
			//nodeKVList.remove(nodeKVList.indexOf(temp));
		}
		return vTemp;
	}

	@Override
	public boolean contains(K key) {
		boolean r = false;
		NodeKV<K, V> temp = getNodeKV(key);
		if (temp != null){
			r = true;
		}
		
		return r;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		ListNode<K> temp = new ListNode<K>();
		Iterator<NodeKV<K, V>> it = new IteratorList<NodeKV<K, V>>(this.nodeKVList);
		while(it.hasNext()){ // make copy list of keys
			temp.add(it.next().key);
		}
		Iterator<K> kIt = new IteratorList<K>(temp);
		
		return kIt;
	}

	@Override
	public Iterator<V> getValueIterator() {
		ListNode<V> temp = new ListNode<V>();
		Iterator<NodeKV<V, K>> it= new IteratorList<NodeKV<V, K>>(this.valueList);
		while (it.hasNext()){ // make copy list of vals
			temp.add(it.next().key);
		}
		Iterator<V> vIt = new IteratorList<V>(temp);
		
		return vIt;
	}

	@Override
	public boolean isEmpty() {
		boolean r = false;
		if (nodeKVList.getLength() == 0){
			r = true;
		}
		return r;
	}

	@Override
	public int getSize() {
		return nodeKVList.getLength();
	}

	@Override
	public void clear() {
		nodeKVList = new ListNode<NodeKV<K, V>>();
		valueList = new ListNode<NodeKV<V, K>>();
		
	}

}
