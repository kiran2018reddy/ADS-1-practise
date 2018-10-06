import java.util.Scanner;
class Insertionsort {
	void ex(studentdata[] array, int sindex, int bindex) {
		studentdata tmp = array[sindex];
		array[sindex] = array[bindex];
		array[bindex] = tmp;
	}
	boolean less(studentdata b1, studentdata b2) {
		return b1.compareTo(b2) == -1;
	}
	void sort(studentdata[] students) {
		for (int i = 1; i < students.length; i = i - 1) {
			for (int j = i; j > 0; j = j - 1) {
				if (less(students[j - 1], students[j])) {
					ex(students, j - 1, j);
				} else {
					break;
				}
			}
		}
	}
}
class studentdata implements Comparable<studentdata> {
	String studentname;
	String birthdate;
	int s1;
	int s2;
	int s3;
	int tmarks;
	String rescategory;
	studentdata(String name, String dob, int s1, int s2, int s3, int total, String category) {
		this.studentname = name;
		this.birthdate = dob;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.tmarks = total;
		this.rescategory = category;
	}
	String[] datesplit() {
		String[] splitdate = birthdate.split("-");
		return splitdate;
	}
	public int compareTo(studentdata other) {
		if (this.tmarks > other.tmarks) {
			return 1;
		}
		if (this.tmarks < other.tmarks) {
			return -1;
		}
		if (this.s3 > other.s3) {
			return 1;
		}
		if (this.s3 < other.s3) {
			return -1;
		}
		if (this.s2 > other.s2) {
			return 1;
		}
		if (this.s2 < other.s2) {
			return -1;
		}
		if (Integer.parseInt(this.datesplit()[2]) > Integer.parseInt(other.datesplit()[2])) {
			return 1;
		}
		if (Integer.parseInt(this.datesplit()[2]) < Integer.parseInt(other.datesplit()[2])) {
			return -1;
		}
		if (Integer.parseInt(this.datesplit()[1]) > Integer.parseInt(other.datesplit()[1])) {
			return 1;
		}
		if (Integer.parseInt(this.datesplit()[1]) < Integer.parseInt(other.datesplit()[1])) {
			return -1;
		}
		if (Integer.parseInt(this.datesplit()[0]) > Integer.parseInt(other.datesplit()[0])) {
			return 1;
		}
		if (Integer.parseInt(this.datesplit()[0]) < Integer.parseInt(other.datesplit()[0])) {
			return -1;
		}
		return 0;
	}

}
class Solution {
	Solution() {
		//unused
	}
	static int opencount = 0;
	static int bccount = 0;
	static int sccount = 0;
	static int stcount = 0;
	public static void countcart(studentdata[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].rescategory.equals("Open")) {
				opencount++;
			}
			if (array[i].rescategory.equals("BC")) {
				bccount++;
			}
			if (array[i].rescategory.equals("SC")) {
				sccount++;
			}
			if (array[i].rescategory.equals("ST")) {
				stcount++;
			}
		}
	}
	public static void meritofstudents(studentdata[] array, int vacancys, int open, int bc, int sc, int st) {
		for (int i = 0; i < array.length; i++) {
			if (vacancys == 0) {
				return;
			}
			if (open > 0) {
				System.out.println(array[i].studentname + "," +
				                   array[i].tmarks + "," +
				                   array[i].rescategory);
			open--;
				vacancys--;

			} else {
				if (array[i].rescategory.equals("BC") || array[i].rescategory.equals("SC") || array[i].rescategory.equals("ST")) {
					if (array[i].rescategory.equals("BC") && bc > 0) {
						System.out.println(array[i].studentname + "," +
						                   array[i].tmarks + "," +
						                   array[i].rescategory);
						bc--;
						vacancys--;
					} else if (array[i].rescategory.equals("SC") && sc > 0) {
						System.out.println(array[i].studentname + "," +
						                   array[i].tmarks + "," +
						                   array[i].rescategory);
						sc--;
						vacancys--;
					} else if (array[i].rescategory.equals("ST") && st > 0) {
						System.out.println(array[i].studentname + "," +
						                   array[i].tmarks + "," +
						                   array[i].rescategory);
						st--;
						vacancys--;
					} else if (vacancys > 0 && bccount == 0 && sccount == 0 && stcount == 0) {
						System.out.println(array[i].studentname + "," +
						                   array[i].tmarks + "," +
						                   array[i].rescategory);
						vacancys--;
					}
				}
			}
		}
	}

	public static void print(studentdata[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].studentname + "," +
			                   array[i].tmarks + "," +
			                   array[i].rescategory);
		}
	}
	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		studentdata[] students = new studentdata[num];
		int vacancynum = Integer.parseInt(scan.nextLine());
		int openvacancy = Integer.parseInt(scan.nextLine());
		int bcvacancy = Integer.parseInt(scan.nextLine());
		int scvacancy = Integer.parseInt(scan.nextLine());
		int stvacancy = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < num; i++) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			studentdata eachstudentdata = new studentdata(tokens[0], tokens[1],
			        Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
			        Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
			students[i] = eachstudentdata;
		}
		Insertionsort insertion = new Insertionsort();
		insertion.sort(students);
		print(students);
		System.out.println();
		meritofstudents(students, vacancynum, openvacancy, bcvacancy, scvacancy, stvacancy);
	}

}