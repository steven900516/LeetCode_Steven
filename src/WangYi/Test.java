
import java.util.*;


public class test {
	static class Slot {
		int x, y, v;

		public Slot() {
		}

		public Slot(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}

	static class Group {
		Slot[] slots;
		int empty;

		public Group(int n) {
			this.empty = n;
			this.slots = new Slot[n];
		}
	}

	static int[][] matrix;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		matrix = new int[3][3];
		int n = sc.nextInt();
		while (n-- > 0) {
			Queue<Group> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.empty));
			for (int i = 0; i < 3; i++) {
				Group group = new Group(3);
				String s = sc.next();
				for (int j = 0; j < 3; j++) {
					char c = s.charAt(j);
					if (c == '*')
						matrix[i][j] = -1;
					else
						matrix[i][j] = c - '0';
					group.slots[j] = new Slot(i, j, matrix[i][j]);
					if (matrix[i][j] != -1)
						group.empty--;
				}
				queue.offer(group);
			}

			for (int i = 0; i < 3; i++) {
				Group group = new Group(3);
				for (int j = 0; j < 3; j++) {
					group.slots[j] = new Slot(j, i, matrix[j][i]);
					if (matrix[j][i] != -1)
						group.empty--;
				}
				queue.offer(group);
			}

			for (int i = 0; i < 3; i++) {
				Group group = new Group(3);
				for (int j = 0; j < 3; j++) {
					int x = sc.nextInt(), y = sc.nextInt();
					group.slots[j] = new Slot(x, y, matrix[x][y]);
					if (matrix[x][y] != -1)
						group.empty--;
				}
				queue.offer(group);
			}

			while (!queue.isEmpty()) {
				Group group = queue.poll();
				if (checkGroup(group)) {
					if (group.empty >= 2) {
						System.out.println("Multiple");
						break;
					} else if (group.empty == 1) {
						int x = -1, y = -1, v = 6;
						for (Slot slot : group.slots) {
							if (slot.v == -1) {
								x = slot.x;
								y = slot.y;
							} else v -= slot.v;
						}
						matrix[x][y] = v;
					}
				} else {
					System.out.println("No");
					break;
				}
			}
			System.out.println("Unique");
			for (int i = 0; i < 3; i++) {
				System.out.print(matrix[i][0]);
				System.out.print(matrix[i][1]);
				System.out.println(matrix[i][2]);
			}
		}
	}

	private static boolean checkGroup(Group group) {
		boolean[] flag = new boolean[3];
		int empty = 3;
		for (Slot slot : group.slots) {
			if (matrix[slot.x][slot.y] == -1)
				continue;
			slot.v = matrix[slot.x][slot.y];
			if (flag[slot.v - 1])
				return false;
			flag[slot.v - 1] = true;
			empty--;
		}
		group.empty = empty;
		return true;
	}
}
