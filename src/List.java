
public interface List <E> {
	public void add(E a); //This method is used to add to the end of the list
	public void add(E a, int index); //Overload method, adds at specified index
	public E remove(int index); // Removes data at specified index
	public E get(int index); //Returns the object at index
	public boolean set(E a, int index); //Update the value of object at index
	public int getSize(); //Returns total number of elements
	public int indexOF(E a); //Returns the index of the object
}
