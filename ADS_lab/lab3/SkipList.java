package ada2;

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
	
}
