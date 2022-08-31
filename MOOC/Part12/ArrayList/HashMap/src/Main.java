public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        long hashMapAddStart = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashMap.add("" + i, "" + i);
        }
        long hashMapAddEnd = System.nanoTime();

        long hashMapSearch = hashMapAddEnd - hashMapAddStart;
        System.out.println("Hash map: adding took about " + hashMapSearch / 1000000 +
                " milliseconds (" + hashMapSearch + " nanoseconds.)");
    }
}