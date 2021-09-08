public class MemoryManagementExample {
    public static void main(String[] args) {
        int kek = 10;
        System.out.println("Int kek before multiply method: " + kek);
        multiply(kek);
        System.out.println("Int kek after multiply method: " + kek);

        System.out.println();

        StringBuilder lel = new StringBuilder("Shrek");
        System.out.println("String lel before add method: " + lel);
        addTwo(lel);
        System.out.println("String lel after add method: " + lel);
    }

    private static void multiply(int num) {
        num *= 10;
    }

    private static void addTwo(StringBuilder text) {
        text.append(" 2");
        text = new StringBuilder("Сat");
    }
}
