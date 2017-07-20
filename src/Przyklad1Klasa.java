
public class Przyklad1Klasa {
	
	
	@Override
	public String toString() {
		return "Przyklad1Klasa [model=" + model + ", speed=" + speed + ", color=" + color + "]";
	}


	public Przyklad1Klasa(String model, int speed, String color) {
		super();
		this.model = model;
		this.speed = speed;
		this.color = color;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	private String model;
	private int speed;
	private String color;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
