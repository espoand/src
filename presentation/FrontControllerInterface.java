package presentation;

import java.util.ArrayList;

public interface FrontControllerInterface {
public Object handleRequest(String request);
public Object handleRequest(String request,ArrayList<String> parameters);
}
