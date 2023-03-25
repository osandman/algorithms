package structures.graph.friends;

import java.util.*;
import java.util.stream.Collectors;

public class Friends {
    private boolean[][] humanRelationships;

    public Friends(boolean[][] humanRelationships) {
        this.humanRelationships = humanRelationships;
    }

    public void setHumanRelationships(boolean[][] humanRelationships) {
        this.humanRelationships = humanRelationships;
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        return recursiveGetFriends(new HashSet<>(Arrays.asList(index)), deep).stream()
                .filter(el -> el != index).collect(Collectors.toSet());
    }

    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        return addOrRemoveFromSet(set, index, false);
    }

    private Set<Integer> recursiveGetFriends(Set<Integer> friends, int count) {
        if (count == 0) {
            return friends;
        }
        ListIterator<Integer> iterator = new ArrayList<>(friends).listIterator();
        while (iterator.hasNext()) {
            int index = iterator.next();
            addOrRemoveFromSet(friends, index, true);
        }
        count--;
        return recursiveGetFriends(friends, count);
    }

    private Set<Integer> addOrRemoveFromSet(Set<Integer> set, int index, boolean addTrueOrRemoveFalse) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                if (addTrueOrRemoveFalse) {
                    set.add(i);
                } else set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                if (addTrueOrRemoveFalse) {
                    set.add(i);
                } else set.remove(i);
            }
        }
        return set;
    }


}
