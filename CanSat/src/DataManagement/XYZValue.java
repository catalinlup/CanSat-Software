package DataManagement;

public class XYZValue {
	
	public XYZValue(String X, String Y, String Z) {
		this.X = X;
		this.Y = Y;
		this.Z = Z;
	}
	
	public String X = "";
	public String Y = "";
	public String Z = "";
	
	public int getIntX() {
		return Integer.parseInt(X);
	}
	
	public int getIntY() {
		return Integer.parseInt(Y);
	}
	
	public int getIntZ() {
		return Integer.parseInt(Z);
	}
}
