/**Implement the API using Binary Search Tree: Implement the following API using Binary Search Tree.
void put(Key key, Value val)	 
Value get(Key k)		
Key min()
Key max()
Key floor(Key key)
Key ceiling(Key key)
Key select(int k)
Iterable<Key> keys(Key lo, Key hi)


Key Type:
Key will be an object of type book containing following attributes
Name
Author
price
Note:
Object comparisons should be done based on Name of the book.*/
//import java.util.scanner;
class Book implements Comparable<Book> {
	public String name;
	public String author;
	public float price;

	Book(final String n, String a,float p) {
		this.name = n;
		this.author = a;
		this.price = p;
	}
	public String getName(){
		return this.name;
	}
	public String getAuthor(){
		return this.author;
	}
	public float getPrice(){
		return this.price;
	}
	public int compareTo(final Book that) {
		return this.name.compareTo(that.name);
	}
}