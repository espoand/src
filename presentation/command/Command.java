package presentation.command;

import java.util.ArrayList;

public interface Command {
public Object execute(ArrayList<String> parameters);
public Object execute(String parameter);
}
