import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

            else if (phrase.equals("freq"))
            {
                System.out.println("Veuillez entrer le chemin du fichier a analyser :");

                String chemin = entree.nextLine();

                Path path = Paths.get(chemin);

                try {
                    String text = Files.readString(path);
                    text = text.toLowerCase();
                    text = text.replaceAll("[^a-z]", " ");
                    String[] words = text.split(" ");

                    int wordsLen = words.length;

                    int mini = 3;

                    for (int i = 0; i < wordsLen; i++) {
                        if (words[i].equals(""))
                        {
                            mini = 4;
                            break;
                        }
                    }

                    if (wordsLen == mini)
                    {
                        System.out.println("Il n'y a pas de mots a comparer dans le fichier texte");
                    }

                    else
                    {
                        int[] counts = new int[wordsLen];

                        for (int i = 0; i < wordsLen; i++)
                        {
                            counts[i] = 1;
                            for (int j = (i + 1); j < (wordsLen - 1); j++)
                            {
                                if (words[i].equals(words[j]))
                                {
                                    counts[i]++;

                                    System.arraycopy(words, j + 1, words, j, wordsLen - 1 - j);

                                    wordsLen--;
                                    j--;
                                }
                            }
                        }

                        int firstID = -1;
                        int secondID = -1;
                        int thirdID = -1;

                        for (int i = 1; i < wordsLen; i++) {
                            if (!words[i].equals(""))
                            {
                                if(firstID == -1)
                                {
                                    firstID = i;
                                }

                                else if (counts[firstID] < counts[i])
                                {
                                    secondID = firstID;
                                    firstID = i;
                                }

                                else if(secondID == -1 && !words[i].equals(words[firstID]))
                                {
                                    secondID = i;
                                }

                                else if (counts[secondID] < counts[i] && !words[i].equals(words[firstID]))
                                {
                                    thirdID = secondID;
                                    secondID = i;
                                }

                                else if(thirdID == -1 && (!words[i].equals(words[firstID]) || !words[i].equals(words[secondID])))
                                {
                                    thirdID = i;
                                }

                                else if (counts[thirdID] < counts[i] && (!words[i].equals(words[firstID]) || !words[i].equals(words[secondID])))
                                {
                                    thirdID = i;
                                }
                            }
                        }

                        System.out.println(words[firstID] + " " + words[secondID] + " " + words[thirdID]);

                    }
                }

                catch (IOException e){
                    System.out.println("Unreadable file: ");
                    e.printStackTrace();
                }
            }

            else
            {
                System.out.println("Unknown command");
            }

            phrase = entree.nextLine();
        }
    }
}
