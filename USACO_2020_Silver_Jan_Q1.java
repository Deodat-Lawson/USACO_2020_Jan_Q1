import java.io.*;
import java.util.*;
public  class USACO_2020_Silver_Jan_Q1 {

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("berries.in"));
        String line1 = f.readLine();
        StringTokenizer tok = new StringTokenizer(line1);
        int tree = Integer.parseInt(tok.nextToken());
        int basket = Integer.parseInt(tok.nextToken());
        int halfOfBaskets = basket / 2;
        ArrayList<Integer> eachBasket = new ArrayList<>();
        String line2 = f.readLine();
        StringTokenizer tok2 = new StringTokenizer(line2);

        int maxCandieInEachBasket = 0;

        for (int i = 0;i < tree; i++)
        {
            eachBasket.add(Integer.parseInt(tok2.nextToken())) ;
            maxCandieInEachBasket = Math.max(maxCandieInEachBasket,eachBasket.get(i));
        }
        f.close();


        ArrayList<Integer> RemaindersInEachBasket = new ArrayList<>();
        int MaxNumber = 0;

        for (int i = 1;i <= maxCandieInEachBasket;i++)
        {
            int allEqualBaskets = 0;

            for (int j = 0;j < tree;j++) {
                RemaindersInEachBasket.add(eachBasket.get(j) % i);
                allEqualBaskets += eachBasket.get(j) / i;
            }

            Collections.sort(RemaindersInEachBasket);
            Collections.reverse(RemaindersInEachBasket);


            if (halfOfBaskets <= allEqualBaskets) {
                allEqualBaskets -= halfOfBaskets;
            }
            else {
                break;
            }

            if (halfOfBaskets <= allEqualBaskets) {
                MaxNumber = Math.max(halfOfBaskets * i,MaxNumber);
            }
            else {
                int NumOfReminders = halfOfBaskets - allEqualBaskets;
                int maxWithRemainder = 0;

                for (int k = 0;k < NumOfReminders ;k++)
                {
                    maxWithRemainder += RemaindersInEachBasket.get(k);
                }
                maxWithRemainder += allEqualBaskets * i;
                MaxNumber = Math.max(maxWithRemainder,MaxNumber);
            }
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        out.println(MaxNumber);
        out.close();
    }

}
