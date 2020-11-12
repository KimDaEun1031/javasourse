package controller;

import java.util.Scanner;
import action.Action;

public class UserController {
	public void processRequset(Action action, Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
