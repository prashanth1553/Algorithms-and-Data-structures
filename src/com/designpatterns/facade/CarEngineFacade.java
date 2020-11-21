package com.designpatterns.facade;

public class CarEngineFacade {
	private static final Integer DEFAULT_COOLING_TEMP = 90;
	private static final Integer MAX_ALLOWED_TEMP = 50;
	private AirFlowController airFlowController = new AirFlowController();
	private CoolingController coolingController = new CoolingController();
	private CatalyticConverter catalyticConverter = new CatalyticConverter();

	public void startEngine() {

		// entire staring process is included here
		airFlowController.takeAir();
		coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
		coolingController.run();
		catalyticConverter.on();
	}

	public void stopEngine() {
		catalyticConverter.off();
		coolingController.cool(MAX_ALLOWED_TEMP);
		coolingController.stop();
		airFlowController.off();
	}
}
