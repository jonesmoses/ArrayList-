
public class ArrayList <E> implements List <E> {
	
	private int size; //How many elements in the ArrayList
	private int capacity; //What is the total size of the ArrayList
	private E[] myArray; //Array Reference to store the actual data
	private static final int INITIAL_CAPACITY = 10; //Default size of the list
	
	// Constructor
	public ArrayList() {
		this.capacity = INITIAL_CAPACITY;
		this.size = 0; //When the list is created there are no elements
		myArray = (E[])new Object[this.capacity];
	}
	//Overloaded Constructor, to create an arraylist of variable size
	public ArrayList(int capacity){
		this.capacity = capacity;
		this.size = 0;
		myArray = (E[])new Object[this.capacity];
	}
	@Override
	public void add(E a) {
		// TODO Auto-generated method stub
		if (this.size < capacity) //This means there is space at the end to add data
		{
			myArray[size] = a; //size value gives the index of the first free location
			size++; //Update the size
		}
		else
		{
			System.out.println("There isnt enough space in the list, calling reallocation");
			this.reallocate();
			this.add(a);
		}
		
	}

	private void reallocate() {
		// TODO Auto-generated method stub
		this.capacity *= 2; //Update the capacity to twice its value
		E[] temp= (E[])new Object[this.capacity]; //Create new array of twice size
		//Need to copy the old elements of array into the new one
		for (int i = 0; i < myArray.length; i++)
		{
			temp[i] = myArray[i];
		}
		//After the copying is done, update the reference
		this.myArray = temp;
	}
	@Override
	public void add(E a, int index) {
		// This method adds an element to a specific position of the list
		// Check the index for validity
		if (index < 0 || index > size){
			System.out.println("Invalid Index");
			return;
		}
		else if (index == this.size) { //Special case, where you are inserting at the end 
			this.add(a);
		//Call the other add method to do the job
		}
		else {
				//Make sure there is space
				//Then move the elements over and insert
				this.reallocate();
				// Move the data
				if (this.capacity == this.size) {
					this.reallocate();
				}
				for (int i = size; i > index; i--) {
					this.myArray[index] = a;
					this.size++;
				}
			}
			
		}
	@Override
	public E remove(int index) {
		// Check for valid index to remove
		if (index < 0 || index >= size){
			System.out.println("Invalid Index");
			return null;
		}
		//Now we have to shift elements
		//Store the data to be deleted, so that it can be returned
		E temp = myArray[index];
		//Use a loop to shift the elements, one place left from the index
		for (int i = index; i < size; i++)
		{
			this.myArray[i] = this.myArray[i+1];
		}
		size--;
		return temp;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index >= this.size) { //Check if index is valid
			System.out.println("Invalid index, returning null");
			return null;
		}
		return this.myArray[index];
	}

	@Override
	public boolean set(E a, int index) {
		// TODO Auto-generated method stub
		if(index < 0 || index >= this.size) { //Check if index is valid
			System.out.println("Invalid index, returning null");
			return false;
		}
		
			this.myArray[index] = a;
			return true;
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public int indexOF(E a) {
		for (int i = 0; i < size; i++){
			if(this.myArray[i].equals(a)){
				return i;
			}
		}
		return -1;
	}
	//Method is used to display the contents of an ArrayList
	public void display(){
		System.out.println("The contents of the list:");
		for (int i = 0; i < size; i++){
			System.out.print(myArray[i] + ", ");
		}
		System.out.println();
	}

}
