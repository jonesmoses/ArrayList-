
public class Driver {
	public static void main (String [] args) {
		//Create an arrylist here, and test
		ArrayList<Integer> myList = new ArrayList<>(2);
		myList.add(10);
		myList.add(20);
		myList.display();
		myList.add(30);
		myList.add(40);
		myList.display();
		myList.add(50);
		myList.display();
		myList.add(99, 1);
		myList.display();
		myList.add(200, -5);
		myList.remove(0);
		myList.display();
		System.out.println("The index of value 30:" + myList.indexOF(30));
		
	}
}
