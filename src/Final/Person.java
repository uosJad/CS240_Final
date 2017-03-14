package Final;
import Ds.StackInterface;
import Ds.StackVector;

/*************************************************************************
Winter 2017 CS 240 Programming Exam : Person

Author: Jason Wu     

Dependencies: Stack, Queue, Dictionary

Description:  Models a person, a list of messages that they can
             read, and a list of their friends, so that when you
             post a message, all your friends can read it too.

**************************************************************************/

public class Person { 
	private String nameOfPerson;
	private StackInterface<Person> friendList;
	private StackInterface<String> msgList;
	
	  // Create a new Person with this name.
	  public Person(String name) {
	      this.nameOfPerson = name;
	      this.friendList = new StackVector<Person>();
	      this.msgList = new StackVector<String>();
	  }
	
	  // Make these two people become friends with each other.
	  // Throw an exception if you try to meet yourself.
	  // We are allowed to assume we didn't meet this person yet.
	  public void meet(Person otherPerson) throws ReferSelfException{
		  
		  if (otherPerson != this){
		      if (!this.knows(otherPerson)){
		    	  friendList.push(otherPerson);
		      }
			  if (!otherPerson.knows(this)){
				  otherPerson.friendList.push(this);
			  }
		  }
		  else{
			  throw new ReferSelfException(this.nameOfPerson+" tried to meet self");
		  }
		  
	  }
	
	  // Are these two people friends?
	  // Throw an exception if you ask about knowing yourself.
	  public boolean knows(Person otherPerson) throws ReferSelfException{
	      boolean r = false;
	      if (otherPerson != this){
		      if (this.friendList.contains(otherPerson)){
		    	  r = true;
		      }
	      }
	      else{
	    	  throw new ReferSelfException(this.nameOfPerson+ " asked about knowing self");
	      }
		  return r;
	  }
	
	  // Post a message to my list and the lists of all my friends
	  public void post(String message) {
	      this.msgList.push(message);
	      Iterator<Person> it = new IteratorStack<Person>(this.friendList);
	      while (it.hasNext()){
	    	  it.next().msgList.push(message);
	      }
	  }
	
	  // Print a header, then all messages this Person can read, newest first
	  public void listMessages() {
		 System.out.println("--- Messages of " + nameOfPerson +" ---"); 
		 
	     StackInterface<String> temp = new StackVector<String>();
	     
	     //extracts stack and stores to temp stack
	     while (!this.msgList.isEmpty()){
	    	 String msg = msgList.pop();
	    	 System.out.println(msg);
	    	 temp.push(msg);
	     }
	     
	     //extracts temp and stores to stack
		 while(!temp.isEmpty()){
			 this.msgList.push(temp.pop());
		 }
		  
	  }
}