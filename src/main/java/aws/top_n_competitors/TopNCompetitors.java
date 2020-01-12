package aws.top_n_competitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class TopNCompetitors {
  public static void main(String[] args) {
    String[] reviews = {"newshop is providing; should ise newshop;", "best services by newshop", "fasionbeats has great services", "I am proud to have fashionbeats", "mymarket has awesome", "Thanks Newshop for", "Mymarket is awesome"};
    String[] competetiors = {"newshop", "fashionbeats", "shopnow", "afashion", "mymarket", "tcellular"};
    System.out.println(topNCompetitors(6, 2, Arrays.asList(competetiors), 6, Arrays.asList(reviews)));

  }

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  private static List<String> topNCompetitors(int numCompetitors,
                                              int topNCompetitors,
                                              List<String> competitors,
                                              int numReviews,
                                              List<String> reviews) {
    HashMap<String, Integer> competitorsByReviews = new HashMap<>();
    for (int i = 0; i < numCompetitors; i++) {
      competitorsByReviews.put(competitors.get(i).toLowerCase(), 0);
    }

    final Set<String> uniqueLowercaseCompetitors = competitorsByReviews.keySet();

    for (int i = 0; i < numReviews; i++) {
      for (final String competitorToCompare : uniqueLowercaseCompetitors) {
        if (reviews.get(i).toLowerCase().contains(competitorToCompare)) {
          competitorsByReviews.put(competitorToCompare, competitorsByReviews.get(competitorToCompare) + 1);
        }
      }
    }

    // return the actual list in case the topN is > or equals the actual list size
    if (uniqueLowercaseCompetitors.size() <= topNCompetitors) {
      return new ArrayList<>(uniqueLowercaseCompetitors);
    }

    // Else find the topN sorted first by value, then alphabetically
    Map<Integer, TreeSet<String>> countWithCompetitors = sortedMap(competitorsByReviews);
    List<String> result = new ArrayList<>();
    countWithCompetitors.values().forEach(result::addAll);
    return result.subList(0, topNCompetitors);
  }

  private static TreeMap<Integer, TreeSet<String>> sortedMap(HashMap<String, Integer> uniqueLowercaseCompetitors) {
    TreeMap<Integer, TreeSet<String>> countWithCompetitors = new TreeMap<>(Comparator.reverseOrder());
    for (String competitor : uniqueLowercaseCompetitors.keySet()) {
      int value = uniqueLowercaseCompetitors.get(competitor);
      if (countWithCompetitors.containsKey(value)) {
        countWithCompetitors.get(value).add(competitor);
      } else {
        countWithCompetitors.put(value, new TreeSet<String>() {{
          add(competitor);
        }});
      }
    }
    return countWithCompetitors;
  }
}