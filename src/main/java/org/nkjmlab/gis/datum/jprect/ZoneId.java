package org.nkjmlab.gis.datum.jprect;

public enum ZoneId {
	_1(0), _2(1), _3(2), _4(3), _5(4), _6(5), _7(6), _8(7), _9(8), _10(9), _11(10), _12(
			11), _13(12), _14(13), _15(14), _16(15), _17(16), _18(17), _19(18);

	private int index;

	private ZoneId(int index) {
		this.index = index;
	}

	public static ZoneId get(int index) {
		return values()[index];
	}

	public int getIndex() {
		return index;
	}
}