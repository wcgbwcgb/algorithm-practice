package data_structure;

import java.io.File;

public class SimpleBloomFilter <T>{
	private final BitSet bitSet;
	private final int bitSetSize;
	// number of hash functions
	private final int k;
	
	public SimpleBloomFilter(int size, int hashNum) {
		bitSetSize = size;
		k = hashNum;
		bitSet = new BitSet(bitSetSize);
	}
	
	public void add(T element) {
		for(int i = 0;i<k;i++) {
			bitSet.set(hash(element, i));
		}
	}
	
	public boolean contains(T element) {
		for(int i = 0;i<k;i++) {
			int hash = hash(element, i);
			if(!bitSet.contains(hash)) {
				return false;
			}
		}
		
		return true;
	}
	
	private int hash(T element, int seed) {
		return Math.floorMod(element.hashCode() + seed, bitSetSize);
	}
	
	
	
	public static void main(String[] args) {
		SimpleBloomFilter<Integer> filter = new SimpleBloomFilter<Integer>(1000, 4);
		filter.add(1);
		filter.add(2);
		filter.add(30);
		filter.add(1000);
		System.out.println(filter.contains(1));
		System.out.println(filter.contains(21));
		System.out.println(filter.contains(900));
		System.out.println(filter.contains(1000));
	}
}
