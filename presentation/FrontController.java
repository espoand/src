package presentation;

import java.util.ArrayList;

public class FrontController implements FrontControllerInterface{
ApplicationControllerInterface controller;
	@Override
	public Object handleRequest(String request) {
		// TODO Auto-generated method stub
		controller = new ApplicationController();
		return controller.handleRequest(request);
	}

	@Override
	public Object handleRequest(String request, ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		controller = new ApplicationController();
		return controller.handleRequest(request);
	}

}
