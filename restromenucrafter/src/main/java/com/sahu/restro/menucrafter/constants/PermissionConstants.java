package com.sahu.restro.menucrafter.constants;

import java.util.ArrayList;
import java.util.List;

public interface PermissionConstants {

	public static final String GLOBAL_ADMINISTRATION = "GLOBAL_ADMINISTRATION";

	public static final String VIEW_RESTURANT = "VIEW_RESTURANT";

	public static final String ADD_RESTURANT = "ADD_RESTURANT";

	public static final String EDIT_RESTURANT = "EDIT_RESTURANT";

	public static final String DELETE_RESTURANT = "DELETE_RESTURANT";

	public static final String VIEW_MENU = "VIEW_MENU";

	public static final String ADD_MENU = "ADD_MENU";

	public static final String EDIT_MENU = "EDIT_MENU";

	public static final String DELETE_MENU = "DELETE_MENU";

	public static final String VIEW_RESTURANT_DASHBOARD = "VIEW_RESTURANT_DASHBOARD";

	public static List<String> getResturantAdminDefaultPermissions() {
		List<String> permissions = new ArrayList<>();
		permissions.addAll(getResturantDfaultPermissions());
		permissions.addAll(getMenuDfaultPermissions());
		permissions.add(VIEW_RESTURANT_DASHBOARD);

		return permissions;
	}

	public static List<String> getResturantDfaultPermissions() {
		List<String> permissions = new ArrayList<>();
		permissions.add(VIEW_RESTURANT);
		permissions.add(ADD_RESTURANT);
		permissions.add(EDIT_RESTURANT);
		permissions.add(DELETE_RESTURANT);

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
