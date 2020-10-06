package ie.gmit.sw;

import java.util.*;

// Not suitable as a record class
public class Student implements Cloneable {
	// Getting a new student object & copying the studentID, dob
	// Objects
	private String studentID;
	private Date dob;

	// Instance variable
	private List<Book> books = new ArrayList<>();

	public Student(String studentID, Date dob) {
		super();
		this.studentID = studentID;
		this.dob = dob;
	}

	// Delegate Methods
	public boolean addBook(Book b) {
		return books.add(b);
	}

	public Book[] books() {
		// Converts list to book array
		return books.toArray(Book[]::new);
	}

	public void clear() {
		books.clear();
	}

	public boolean hasBook(Book b) {
		return books.contains(b);
	}

	public int size() {
		return books.size();
	}

	public String getStudentID() {
		return studentID;
	}

	public Date getDob() {
		return dob;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentID == null) ? 0 : studentID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentID == null) {
			if (other.studentID != null)
				return false;
		} else if (!studentID.equals(other.studentID))
			return false;
		return true;
	}
	
	private void addAll (List<Book> list) {
		this.books = list;
	}

	// Deep clone/ copy 
	// Cleaning from its array list but not original list
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student s = (Student) super.clone();
		List<Book> copy = new ArrayList<>(books);
		s.addAll(copy);
		return s;
	}

	
}