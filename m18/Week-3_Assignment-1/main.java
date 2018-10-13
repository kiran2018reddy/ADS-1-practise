public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		while(n > 0) {
			int numofhours = 6;
			while(numofhours > 0) {
				String[] line = scan.nextLine().split(",");
				System.out.println(line[1]);
				numofhours--;
			}
			System.out.println();
			n--;
		}
	}
}