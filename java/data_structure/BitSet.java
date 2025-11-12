package data_structure;

public class BitSet {
	private final long[] bitSet;
	private final int size;
	
	public BitSet(int size) {
		this.size = size;
		// 1 long = 64 bits
		this.bitSet = new long[size/64+1];
	}
	
	public boolean contains(int bitIndex) {
		int longIndex = bitIndex / 64;
		int bitOffset  = bitIndex % 64;
		// 例：查看01001100和01000000有没有相同位，有就返回1，没有返回0
		return (bitSet[longIndex] & (1L << bitOffset)) != 0;
	}
	
	public void set(int bitIndex) {
		int longIndex = bitIndex / 64;
		int bitOffset  = bitIndex % 64;
		
		bitSet[longIndex] = bitSet[longIndex] | (1L << bitOffset);
	}
	
	public void clear(int bitIndex) {
		int longIndex = bitIndex / 64;
		int bitOffset  = bitIndex % 64;
		
		// ~是not操作，&是两个都是1的时候返回1
		bitSet[longIndex] = bitSet[longIndex] & ~(1L << bitOffset);
	}
	
	public static void main(String[] args) {
		BitSet set = new BitSet(1000);
		set.set(1);
		set.set(6);
		set.set(10);
		set.set(1000);
		System.out.println(set.contains(1));
		System.out.println(set.contains(6));
		System.out.println(set.contains(200));
		System.out.println(set.contains(1000));
		set.clear(1);
		System.out.println(set.contains(1));
		
	}
}
