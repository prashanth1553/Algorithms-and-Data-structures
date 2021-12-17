package com.systemdesign.elevator;

public class TestElevator {

	public static void main(String args[]) {

		Elevator elevator = new Elevator();

		/**
		 * Thread for starting the elevator
		 */
		ProcessJobWorker processJobWorker = new ProcessJobWorker(elevator);
		Thread t2 = new Thread(processJobWorker);
		t2.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ExternalRequest er = new ExternalRequest(Direction.UP, 1);

		InternalRequest ir = new InternalRequest(5);

		Request request1 = new Request(ir, er);

		/**
		 * Pass job to the elevator
		 */
		new Thread(new AddJobWorker(elevator, request1)).start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("current floor" + elevator.getCurrentFloor());
		System.out.println("current state" + elevator.getState());
		
		
		System.out.println("Adding new job");
		new Thread(new AddJobWorker(elevator, buildNewRequest(2, Direction.UP, 4))).start();

	}

	public static Request buildNewRequest(int currentFloor, Direction dir, int destination) {
		ExternalRequest er = new ExternalRequest(dir, currentFloor);

		InternalRequest ir = new InternalRequest(destination);

		Request request1 = new Request(ir, er);

		return request1;
	}
}
