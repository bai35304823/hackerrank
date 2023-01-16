package hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Tool_List {

	public static int toolChange(String[] tools, int startIndex, String target) {
		if (tools[startIndex].equals(target)) {
			return 0;
		}
		int left = startIndex - 1, right = startIndex + 1, steps = 1;
		if (left < 0) {
			left = tools.length - 1;
		}
		if (right > tools.length - 1) {
			right = 0;
		}
		while (left >= 0 && left < tools.length && right >= 0 && right < tools.length) {
			if (tools[left].equals(target) || tools[right].equals(target)) {
				break;
			}
			left--;
			if (left < 0) {
				left = tools.length - 1;
			}
			right++;
			if (right > tools.length - 1) {
				right = 0;
			}
			steps++;
		}
		return steps;
	}

	public static void main(String[] args) {

		// Sample case in question
		// output : 1
		List<String> s = List.of("ballendmill", "keywaycutter", "slotdrill", "facemill");
		System.out.println(toolChanger(s, 1, "ballendmill"));

		// Sample case 0
		// output : 2
		System.out
				.println(toolChanger(List.of("ballendmill", "facemill", "keywaycutter", "slotdrill"), 1, "slotdrill"));
		// Sample case 1
		// output : 1
		System.out
				.println(toolChanger(List.of("facemill", "slotdrill", "ballendmill", "ballendmill"), 0, "ballendmill"));

	}

	public static int toolChanger(List<String> tools, int startIndex, String target) {
		return toolChange(Optional.ofNullable(tools).orElseGet(Collections::emptyList).stream().toArray(String[]::new),
				startIndex, target);
	}

}
