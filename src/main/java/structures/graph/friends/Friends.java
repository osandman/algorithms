package structures.graph.friends;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализовать метод Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep), который возвращает индексы людей,
 * которые у тебя в друзьях уже есть и которых ты можешь знать. После этого отработает метод removeFriendsFromSet
 * и результат этого метода - это все потенциальные друзья человека с индексом index и глубиной поиска deep.
 * Для упрощения будем рассматривать связи всех людей как двумерный массив humanRelationships. По главной диагонали все
 * элементы true, так как это один и тот же человек. Пересечение строки и столбца указывает, добавлены ли люди
 * друг у друга в друзья (если true - то люди есть друг у друга в друзьях). Если человек с индексом k добавлен в
 * друзья к человеку с индексом p, это означает, что у человека с индексом p в друзьях есть человек с индексом k.
 * <p>
 * В метод передается два аргумента:
 * int index - это индекс человека в массиве (начиная с нуля);
 * int deep - глубина поиска друзей. Если Маша в друзьях у Наташи и у Маши в друзьях есть Оля, при глубине поиска = 1,
 * для Наташи нужно добавить в результирующее множество Машу. Если глубина поиска = 2, для Наташи нужно добавить в
 * результирующее множество Машу и как потенциального друга Олю. Если глубина поиска = 3, в это же множество нужно
 * добавить еще и всех, с кем дружит Оля.
 * <p>
 * В множестве, которое возвращает метод getAllFriendsAndPotentialFriends не должно быть индекса index.
 */

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
