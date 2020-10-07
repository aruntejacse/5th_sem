package ada2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkipList<E extends Comparable<E>> {
	private final int max_lvl = 3;
	
	private SLNode<E> head;
	private int currMaxLevel;
	
	Random rand = new Random();
	
	public SkipList(){
		this.head =  new SLNode<>(null,max_lvl);
		this.currMaxLevel = 1;
	}
	
	public void insert(E value) {
		int level = tossing();
		
		SLNode<E> newnode = new SLNode<>(value, level);
		
		SLNode currp = head;
		
		for(int i = currMaxLevel ; i >=0 ; i--) {
			while(currp.next[i] != null) {
				if(greaterThan((E) currp.next[i].getValue(), value)){
					break;
				}
				
				currp = currp.next[i];
			}
			
			if(i <= level) {
				newnode.next[i] = currp.next[i];
				currp.next[i] = newnode;
			}
		}
		
	}
	
	public boolean contains(E value) {
		SLNode currp = head;
		
		for(int i = currMaxLevel - 1; i>= 0; i--) {
			while(currp.next[i] != null) {
				if(greaterThan((E)currp.next[i].getValue(), value)) {
					break;
				}
				if(equalTo((E)currp.next[i].getValue(), value)) {
					return true;
				}
				
				currp = currp.next[i];
			}
		}
		
		return false;
	}
	
	public boolean delete(E value) {
		SLNode currp = head;
		boolean result = false;
		for(int i = currMaxLevel - 1; i>=0 ; i--) {
			while(currp.next[i] != null) {
				if(greaterThan((E)currp.next[i].getValue(), value)) {
					break;
				}
				if(equalTo((E)currp.next[i].getValue(), value)) {
					currp.next[i] = currp.next[i].next[i];
					result = true;
					break;
				}
				currp = currp.next[i];
			}
		}
		return result;
	}
	public void levelPrint() {
		// find the start level
		SLNode cur_walker = head;
		int start = max_lvl - 1;
		while (null == cur_walker.next[start]) {
			start--;
		}

		// collect all node
		cur_walker = head;
		List<SLNode> ref = new ArrayList<>();
		while (null != cur_walker) {
			ref.add(cur_walker);
			cur_walker = cur_walker.next[0];
		}

		for (int i = 0; i <= start; i++) {

			cur_walker = head;
			cur_walker = cur_walker.next[i];
			System.out.print( "Layer "+ i + " | level " + max_lvl + " | head |");

			int levelIndex = 1;
			while (null != cur_walker) {


				if (i > 0) {
					while (ref.get(levelIndex).getValue() != cur_walker.getValue()) {
						levelIndex++;
						System.out.print( "--------------------------");
					}
					levelIndex++;
				}

				System.out.print( "---> " + cur_walker.getValue());
				cur_walker = cur_walker.next[i];
			}

			System.out.println();
		}
	}
	
	private int tossing() {
		boolean head = true;
		int level = 0;

		for (int i = 0; i < max_lvl; i++) {
			head &= rand.nextBoolean();

			if (head) {
				level++;
				if (level == this.currMaxLevel) {
					currMaxLevel++;
					break;
				}
			} else {
				break;
			}
		}

		return level;
	}
	
	private boolean equalTo(E a, E b) {
		return a.compareTo(b) == 0;
	}

	private boolean greaterThan(E a, E b) {
		return a.compareTo(b) > 0;
	}
	
	public static void main(String[] args) {
		SkipList<Integer> sl = new SkipList<>();
		sl.insert(5);
		sl.insert(7);
		sl.insert(10);
		sl.insert(14);
		sl.insert(17);
		
	//sl.delete(14);
		sl.levelPrint();
	}
	
}
