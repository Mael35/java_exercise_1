public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");

        java.util.Scanner entree =   new java.util.Scanner(System.in);
        String phrase = entree.nextLine();

        while(!phrase.equals("quit"))
        {
            System.out.println("Unknown command");

            phrase = entree.nextLine();
        }
    }
}
