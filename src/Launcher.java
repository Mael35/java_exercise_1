public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");
        System.out.println("Nouvelle saisie :");

        java.util.Scanner entree =   new java.util.Scanner(System.in);
        String phrase = entree.nextLine();

        while(!phrase.equals("quit"))
        {
            if (phrase.equals("fibo"))
            {
                System.out.println("Veuillez entrer l'index du nombre de Fibonacci : ");

                String s = entree.nextLine();

                int n;

                try {
                    n = Integer.parseInt(s);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Ce n'est pas un nombre !");
                    break;
                }

                if (n == 0) System.out.println(0);
                if (n == 1) System.out.println(1);

                int prevPrev = 0;
                int prev = 1;
                int result = 0;

                for (int i = 2; i <= n; i++)
                {
                    result = prev + prevPrev;
                    prevPrev = prev;
                    prev = result;
                }

                System.out.println(result);
            }

            else
            {
                System.out.println("Unknown command");
            }

            System.out.println("Nouvelle saisie :");

            phrase = entree.nextLine();
        }
    }
}
