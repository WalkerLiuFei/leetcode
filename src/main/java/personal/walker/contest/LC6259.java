package personal.walker.contest;

import personal.walker.Solution;

import java.util.*;

public class LC6259 implements Solution {
    @Override
    public void runTestCases() {

    }

    class Allocator {
        // Memory array
        int[] mem;
        Map<Integer, Integer> map;

        class FreeMem {
            int idx;
            int cap;
            FreeMem last;
            FreeMem next;

            public FreeMem(int idx, int cap, FreeMem last, FreeMem next) {
                this.idx = idx;
                this.cap = cap;
                this.last = last;
                this.next = next;
            }
        }


        FreeMem tail;
        FreeMem head;
        public Allocator(int n) {
            mem = new int[n];
            map = new HashMap<>();
            // Initialize linked list with a single node representing the entire memory array
            head = new FreeMem(-1,0,null,null);
            tail = new FreeMem(n,0,null,null);

            FreeMem freeMem = new FreeMem(0, n, null, new FreeMem(n,0,null,null));
            head.next = freeMem;
            tail.last = freeMem;
        }

        public int allocate(int size, int mID) {
            FreeMem freeMem = head;
            while (head != null && freeMem.cap < size) {
                freeMem = freeMem.next;
            }
            if (freeMem == null) return -1;

            for (int i = 0; i < size; i++) {
                mem[i + freeMem.idx] = mID;
            }
            if (size + freeMem.idx < freeMem.next.idx){
                FreeMem newFreeMem = new FreeMem(freeMem.idx + size ,freeMem.cap - size,freeMem.last,freeMem.next);
                freeMem.last.next = newFreeMem;
                freeMem.next.last = newFreeMem;
            }
            map.put(mID, map.getOrDefault(mID, 0) + size);
            return freeMem.idx;
        }
    }
}
/**
 * oak labor machine extra path soon nut zoo round gift meat nothing
 */