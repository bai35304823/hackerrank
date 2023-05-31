package hackerrank;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
//https://github.com/NataliaGatti/Equalize-Team-Size-Challenge
public class hackerton_Equalize_Team_Size_Challenge {

	public static void main(String[] args) {
		// Sample case in question
		// output : 4
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(1, 2, 2, 3, 4)), 2));

		// Sample case 0
		// output : 2
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(1, 7, 3, 8)), 1));
		
		// Sample case 1
		// output : 7
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7)), 10));
		
		// Sample case x
		// output : 5
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(1, 3, 4, 4, 4, 5, 7)), 2));

		// Sample case x
		// output : 4
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(1, 3, 4, 4, 4, 5)), 2));
		
		// Sample case x
		// output : 3
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(1, 3, 4, 4, 4)), 2));
		
		System.out.println("-----------------------------------------------------------------");
		// sample exercise 
		// output : 6
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(1, 2, 3, 3, 4, 6, 7)), 5));
		
		// sample exercise 
		// output : 5
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(1, 2, 3, 4, 7, 7, 7)), 4));
		
		// sample exercise 
		// output : 3
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(4, 7, 7, 7, 2, 1)), 2));
		
		// sample exercise 
		// output : 7
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(4, 7, 7, 7, 2, 1, 1)), 6));
		
			
		// sample exercise 
		// output : 4
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(4, 7, 7, 7, 7, 2, 1)), 2));
		
		// sample exercise 
		// output : 8
		System.out.println(equalizeTeamSize(new ArrayList<>(List.of(4, 7, 7, 7, 2, 1, 1, 3)), 6));
	}
	
	
	public static int equalizeTeamSize(List<Integer> teams, int maxReduce) {
	    int n = teams.size();
	    if (maxReduce >= n) {
	        return n;
	    }

	    List<Integer> equalSizeTeams = getEqualSizeTeams(teams);
	    int teamsCanReduce = getTeamsCanReduce(teams);
	    int count = equalSizeTeams.size() + 1;
	    if (maxReduce + 1 == n) {
	        return n;
	    } else if (equalSizeTeams.size() == 0 || maxReduce == (count + teamsCanReduce)) {
	        return maxReduce + 1;
	    } else if (maxReduce > teamsCanReduce && (count + teamsCanReduce < maxReduce)) {
	        return maxReduce + 1;
	    } else if (teamsCanReduce <= maxReduce) {
	        return count + teamsCanReduce;
	    } else if (maxReduce < n && maxReduce > teamsCanReduce) {
	        return count + maxReduce;
	    }
	    return 0;
	}

	public static List<Integer> getEqualSizeTeams(List<Integer> teams) {
	    Collections.sort(teams);
	    List<Integer> equalSizeTeams = new ArrayList<>();
	    for (int i = 0; i < teams.size() - 1; i++) {
	        if (teams.get(i).equals(teams.get(i + 1))) {
	            equalSizeTeams.add(teams.get(i));
	        }
	    }
	    return equalSizeTeams;
	}

	public static int getTeamsCanReduce(List<Integer> teams) {
	    Collections.sort(teams);
	    List<Integer> teamsCanReduce = new ArrayList<>();
	    for (int i = 0; i < teams.size() - 1; i++) {
	        if (!teams.get(i).equals(teams.get(i + 1))) {
	            teamsCanReduce.add(teams.get(i));
	        }
	    }
	    teamsCanReduce.add(teams.get(teams.size() - 1));
	    List<Integer> equalSizeTeams = getEqualSizeTeams(teams);
	    if (equalSizeTeams.size() > 0) {
	        teamsCanReduce.removeIf(team -> team.equals(equalSizeTeams.get(0)) || (team < equalSizeTeams.get(0)));
	    }
	    return teamsCanReduce.size();
	}
}
