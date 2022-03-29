
public class DatasetGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fN = {"John", "Joe", "Jason", "Jeremy", "Jane", "Joanne"};
		String[] lN = {"A.", "B."};
		
		for(int i = 0; i < fN.length; i++) {
			for(int j = 0; j < lN.length; j++) {
				System.out.println(fN[i]+ " " + lN[j]);
			}
		}
	}

}
