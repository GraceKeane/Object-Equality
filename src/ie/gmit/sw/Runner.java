package ie.gmit.sw;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

public class Runner {
	
	// Compare student ids
	private Collection<Student> students = new TreeSet<>(Comparator.comparing(Student::getStudentID));
	
	public void go() throws CloneNotSupportedException {
		// Student key = new Student("g7", new Date(System.nanoTime())); // Prototypical search key)
		// Student key = (Student) students.get(6).clone(); // Clone
		// boolean found = students.contains(key);
		// System.out.println(found);
		
		// key.clear(); // Wipes books
		// System.out.println(key.size());
	}
	
	public void init() {		
		for (int i = 0; i< 10; i++) {
			Student s = new Student("g" + i, new Date(System.nanoTime())); 			students.add(s);
			
			for (int j = 0; j < 20; j++) {
				s.addBook(new Book(i + j, "Book" + i));
				
				// Sleep for 10 mili seconds
				try {
					Thread.sleep(10);
					System.out.println("Processing...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Runner r = new Runner();
		r.init();
		r.go();
	}
}

	



/*
// Records
Book s = new Book (123, "Harry Potter...");
Book t = new Book (123, "Harry Potter...");

// RULES
// == -> do both addresses match
// .equals() -> do hard coded values match

System.out.println(s==t);
System.out.println(s.equals(t));
System.out.println(s.hashCode() == t.hashCode());
System.out.println(s.hashCode());
System.out.println(t.hashCode());
System.out.println(System.identityHashCode(s) + " == " + System.identityHashCode(t));
System.out.println(s + "==" + t);
*/
