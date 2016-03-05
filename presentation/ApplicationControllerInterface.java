package presentation;

import java.util.ArrayList;

public interface ApplicationControllerInterface {
public Object handleRequest(String request,ArrayList<String> parameters);
public Object handleRequest(String request);
}
