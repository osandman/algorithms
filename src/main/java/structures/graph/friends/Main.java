package structures.graph.friends;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Friends friends = new Friends(generateRelationships());
        Set<Integer> allFriends = friends.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriends);
        // Input: 4, 3 Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> friendsOfFriends = friends.removeFriendsFromSet(allFriends, 4);
        System.out.println(friendsOfFriends);
        // Input: 4 Expected: [2, 5, 7]
    }
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
//       0       1      2      3       4      5      6     7
/*0*/ {true},                                                  //0
/*1*/ {true,   true},                                          //1
/*2*/ {false,  true,  true},                                   //2
/*3*/ {false,  false, false, true},                            //3
/*4*/ {true,   true,  false, true,  true},                     //4
/*5*/ {true,   false, true,  false, false, true},              //5
/*6*/ {false,  false, false, false, false, true,  true},       //6
/*7*/ {false,  false, false, true,  false, false, false, true} //7
        };
    }
}
