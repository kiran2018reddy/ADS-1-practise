public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		STable<String, Integer> symbolMax = new STable<String, Integer>(30);
		STable<String, Integer> symbolMin = new STable<String, Integer>(30);

		for(int i = 0; i<6; i++) {
			MinPQ<Stockexc> stMinPQ = new MinPQ<Stockexc>();
			MaxPQ<Stockexc> stMaxPQ = new MaxPQ<Stockexc>();
			for(int j = 0; j<n; j++) {
				String[] tokens = input.nextLine().split(",");
				stMinPQ.insert(new Stockexc(tokens[0], Float.parseFloat(tokens[1])));
				stMaxPQ.insert(new Stockexc(tokens[0], Float.parseFloat(tokens[1])));
			}
			for(int k = 0; k<5; k++) {
				Stockexc a = stMaxPQ.deleteMax();
				System.out.println(a);
				symbolMax.put(a.name, 1);
			}
			System.out.println();
			for(int k = 0; k<5; k++) {
				Stockexc b = stMinPQ.deleteMin();
				System.out.println(b);
				symbolMin.put(b.name, 1);
			}
			System.out.println();
		}

		int k = Integer.parseInt(input.nextLine());
		for(int i = 0; i<k; i++) {
			String[] tokens = input.nextLine().split(",");
			switch(tokens[0]) {
				case "get":
				if(tokens[1].equals("maxST")) {
					System.out.println(symbolMax.get(tokens[2]));
				}
				if(tokens[1].equals("minST")) {
					System.out.println(symbolMin.get(tokens[2]));
				}
			}
		}
}
