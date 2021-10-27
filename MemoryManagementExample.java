public class MemoryManagementExample {
    public static void main(String[] args) {
        int number = 10;
        System.out.println("Int number before multiply method: " + number); // returns 10
        multiply(number);
        System.out.println("Int number after multiply method: " + number); //returns 10

        System.out.println();

        StringBuilder stringBuilder = new StringBuilder("Shrek");
        System.out.println("StringBuilder before add method: " + stringBuilder); // returns Shrek
        modify(stringBuilder);
        System.out.println("StringBuilder after add method: " + stringBuilder); // returns Shrek 2
    }

    private static void multiply(int num) {
        num *= 10;
        System.out.println("Int num in multiply: " + num); // returns 100
    }

    private static void modify(StringBuilder text) {
        StringBuilder newStringBuilder = new StringBuilder(text).append(" 3");
        System.out.println("New stringBuilder in modify: " + newStringBuilder); // returns Shrek 3

        text.append(" 2");
    }
}
