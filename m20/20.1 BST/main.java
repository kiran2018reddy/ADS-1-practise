public static void main(final String[] args) {
        final int three = 3;
        final int four = 4;
        Scanner input = new Scanner(System.in);
        BinarySearchTree<Book, Integer>
        binarySearch = new
        BinarySearchTree<Book, Integer>();
        while (input.hasNext()) {
            String[] tokens = input.nextLine().split(",");
            switch (tokens[0]) {
                case "put":
                Book key = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                Integer value = Integer.parseInt(tokens[four]);
                binarySearch.put(key, value);
                break;
                case "get":
                Book key1 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                System.out.println(binarySearch.get(key1));
                break;
                case "max":
                Book key2 = binarySearch.max();
                binarySearch.toString(key2);
                break;
                case "min":
                Book key3 = binarySearch.min();
                binarySearch.toString(key3);
                break;
                case "floor":
                Book key4 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                binarySearch.toString(binarySearch.floor(key4));
                break;
                case "ceiling":
                Book key5 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                binarySearch.toString(binarySearch.ceiling(key5));
                break;
                case "select":
                binarySearch.toString(binarySearch.select(
                    Integer.parseInt(tokens[1])));
                break;
                case "deleteMin":
                binarySearch.deleteMin();
                break;
                case "deleteMax":
                binarySearch.deleteMax();
                break;
                case "delete":
                Book key6 = new Book(tokens[1],
                    tokens[2], Float.parseFloat(tokens[three]));
                binarySearch.delete(key6);

                default:
                break;

            }
        }
    }
}