package hackerrank;

public class Tool_List {
	public int toolChanger(String[] tools, int startIndex, String target) {
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
}
