package fastcampus.javaSpring.chapter05.ch07genericType_extends_class;
public class GenericPrinter<T extends Material> {
	//T에 extends를 걸어 제한
	private T material;

	public T getMaterial() {
		return material;
	}
	public void setMaterial(T material) {
		this.material = material;
	}

	public String toString() {
		return material.toString();
	}
}
