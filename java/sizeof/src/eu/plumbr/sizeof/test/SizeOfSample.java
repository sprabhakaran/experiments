package eu.plumbr.sizeof.test;

import eu.plumbr.sizeof.MemoryCounterAgent;

/**
 * @author <a href="mailto:nikita@plumbr.eu">Nikita Salnikov-Tarnovski</a>
 */
class X {
	int a;
	byte b;
	java.lang.Integer c = new Integer(1);
}

class Y extends X {
	java.util.List d;
	java.util.Date e;
}

public class SizeOfSample {

	public static void main(String[] args) {
		measure(new Object());
		measure(new X());
		measure(new Y());
	}

	public static void measure(Object obj) {
		System.out.println(obj.getClass().getName() + ": shallow size="
				+ MemoryCounterAgent.sizeOf(obj) + " bytes, retained="
				+ MemoryCounterAgent.deepSizeOf(obj) + " bytes");
	}

}
