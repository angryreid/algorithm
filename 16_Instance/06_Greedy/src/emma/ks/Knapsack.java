package emma.ks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        // Value pillar
        select("Value Pillar", (Article a1, Article a2) ->  {
            return a2.value - a1.value;
        });
        // Weight Pillar
        select("Weight Pillar", (Article a1, Article a2) ->  {
            return a1.weight - a2.weight;
        });
        // Density Pillar
        select("Density Pillar", (Article a1, Article a2) ->  {
            return Double.compare(a2.valueDensity, a1.valueDensity);
        });
    }

    public static void select(String title, Comparator<Article> cmp) {
        Article[] articles = new Article[] {
                new Article(35, 10), new Article(30, 40),
                new Article(60, 30), new Article(50, 50),
                new Article(40, 35), new Article(10, 40),
                new Article(25, 30)
        };
        Arrays.sort(articles, cmp);
        int capacity = 150, weight = 0, value = 0;
        List<Article> selectedArticles = new LinkedList<>();
        for (int i = 0; i < articles.length; i++) {
            int newWeight = weight + articles[i].weight;
            if (newWeight <= capacity) {
                weight = newWeight;
                value += articles[i].value;
                selectedArticles.add(articles[i]);
            }
        }
        System.out.println(title + ": " + value);
        for (int i = 0; i < selectedArticles.size(); i++) {
            System.out.println(selectedArticles.get(i));
        }
        System.out.println("---------------------------------");
    }
}
