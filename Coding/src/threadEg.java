
public class threadEg extends  Thread {
public void run() {
	System.out.println("My first thread");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threadEg t = new threadEg();
		t.start();
	}

}
