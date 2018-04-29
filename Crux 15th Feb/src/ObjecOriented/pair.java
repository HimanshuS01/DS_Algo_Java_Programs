package ObjecOriented;

public class pair<T extends VehicleInterface,V> {
	T first;
	V second;
	
	T getFirst() {
		first.getModel();
		return first;
	}
	
	V getSecond() {
		return second;
	}
	
	void setFirst(T first) {
		this.first = first;
	}
}

