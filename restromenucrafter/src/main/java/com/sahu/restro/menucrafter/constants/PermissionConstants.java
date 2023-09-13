package com.sahu.restro.menucrafter.constants;

import java.util.ArrayList;
import java.util.List;

public interface PermissionConstants {

	public static final String GLOBAL_ADMINISTRATION = "GLOBAL_ADMINISTRATION";

	public static final String VIEW_RESTRO = "VIEW_RESTRO";

	public static final String ADD_RESTRO = "ADD_RESTRO";

	public static final String EDIT_RESTRO = "EDIT_RESTRO";

	public static final String DELETE_RESTRO = "DELETE_RESTRO";

	public static final String VIEW_MENU = "VIEW_MENU";

	public static final String ADD_MENU = "ADD_MENU";

	public static final String EDIT_MENU = "EDIT_MENU";

	public static final String DELETE_MENU = "DELETE_MENU";

	public static List<String> getRestroAdminDefaultPermissions() {
		List<String> permissions = new ArrayList<>();
		permissions.addAll(getRestroDfaultPermissions());
		permissions.addAll(getMenuDfaultPermissions());

		return permissions;
	}

	public static List<String> getRestroDfaultPermissions() {
		List<String> permissions = new ArrayList<>();
		permissions.add(VIEW_RESTRO);
		permissions.add(ADD_RESTRO);
		permissions.add(EDIT_RESTRO);
		permissions.add(DELETE_RESTRO);

		return permissions;
	}

	public static List<String> getMenuDfaultPermissions() {
		List<String> permissions = new ArrayList<>();
		permissions.add(VIEW_MENU);
		permissions.add(ADD_MENU);
		permissions.add(EDIT_MENU);
		permissions.add(DELETE_MENU);

		return permissions;
	}

}
