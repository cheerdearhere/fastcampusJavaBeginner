package fastcampus.javaSpring.chapter05.ch07;
//직접 사용되기보다는 상위 클래스로서 역할을 하므로 abstract class로 사용
public abstract class Material {
	//Plastic과 Powder에 상속표시
	
	//또 하나의 장점은 재료 class에서 공통으로 사용하는 method를 지정할 수 있다. 
	public abstract void doPrinting();//
	//interface와 달리 일반 method도 지정가능
}
