package stepdefinitions;

public abstract class BaseSteps {


	public void waitForSeconds(int waitSeconds){
		try {
			Thread.sleep(waitSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
