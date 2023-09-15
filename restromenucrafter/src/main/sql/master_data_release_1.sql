INSERT INTO `user` VALUES 
	(1,now(),null,now(),null,true,'nirmalakumarsahu7@gmail.com','Nirmala','Sahu',NULL,'$2a$10$n/ACAbYelLw4Mt3Id2LrZ.QzyaXsb3Ywt0Q9NrnvFajKFAGnZKvQO',NULL,NULL, NULL, 'ACTIVE','b77d9d79-a16c-4582-9b51-500ba8378205'),
	(2,now(),null,now(),null,true,'support.restromenucrafters@gmail.com','Support','Restro Menu Crafters',NULL,'$2a$10$N1LVoZFgZER54eprPMnN2.ayMiYnHxn.c8x8522t7OYyO9dvJdPqS',NULL,NULL, NULL, 'ACTIVE','94d81b2b-20f6-4561-9249-06f03acf7fc4');

INSERT INTO `role` VALUES 
	(1, now(),1,now(),1,true,'GLOBAL ADMIN'),
    (2, now(),1,now(),1,true,'RESTRO ADMIN'),
    (3,now(),1,now(),1,true,'USER');

INSERT INTO `user_role` VALUES (1,1);

INSERT INTO `permission` VALUES 
	(1,now(),1,now(),1,true,NULL,'GLOBAL_ADMINISTRATION'),
    (2,now(),1,now(),1,true,NULL,'VIEW_RESTRO'),
    (3,now(),1,now(),1,true,NULL,'ADD_RESTRO'),
	(4,now(),1,now(),1,true,NULL,'EDIT_RESTRO'),
	(5,now(),1,now(),1,true,NULL,'DELETE_RESTRO'),
	(6,now(),1,now(),1,true,NULL,'VIEW_MENU'),
	(7,now(),1,now(),1,true,NULL,'ADD_MENU'),
	(8,now(),1,now(),1,true,NULL,'EDIT_MENU'),
	(9,now(),1,now(),1,true,NULL,'DELETE_MENU'),
	(10,now(),1,now(),1,true,NULL,'VIEW_RESTRO_DASHBOARD');

INSERT INTO `role_permission` VALUES (1,1), (2,2), (2,3), (2,4), (2,5), (2,6), (2,7), (2,8), (2,9), (2,10);

INSERT INTO app_param_group VALUES 
	(1, true, 'Type of restaurants like, veg or non veg', 'RESTRO_TYPES'),
    (2, true, 'Type of food groups', 'FOOD_TYPES'),
    (3, true, 'Different Menu Categories', 'MENU_CATEGORIES');

INSERT INTO app_param_value VALUES
	(1, true, 'Diner', 'DINER', 1),
	(2, true, 'Cafe', 'CAFE', 1),
	(3, true, 'Fine dining', 'FINE_DINING', 1),
	(4, true, 'Pop-up restaurant', 'POP_UP_RESTAURANT', 1),
	(5, true, 'Fast casual restaurant', 'FAST_CASUAL_RESTAURANT', 1),
	(6, true, 'Bistro', 'BISTRO', 1),
	(7, true, 'Food truck, Cart, Or Stand', 'FOOD_TRUCK', 1),
	(8, true, 'Casual dining', 'CASUAL_DINING', 1),
	(9, true, 'Buffet', 'BUFFET', 1),
	(10, true, 'Virtual restaurant', 'VIRTUAL_RESTAURANT', 1),
	(11, true, 'Fast-food restaurant', 'FAST_FOOD_RESTAURANT', 1),
	(12, true, 'Cafeteria', 'CAFETERIA', 1),
	(13, true, 'Steakhouse', 'STEAKHOUSE', 1),
	(14, true, 'Trattoria', 'TRATTORIA', 1),
	(15, true, 'Brasserie', 'BRASSERIE', 1),
	(16, true, 'Gastropub', 'GASTROPUB', 1),
	(17, true, 'Snack bar', 'SNACK_BAR', 1),
	(18, true, 'Taverna', 'TAVERNA', 1),
	(19, true, 'Seafood restaurant', 'SEAFOOD_RESTAURANT', 1),
	(20, true, 'Automated restaurant', 'AUTOMATED_RESTAURANT', 1),
	(21, true, 'Italian cuisine', 'ITALIAN_CUISINE', 1),
	(22, true, 'Barbecue restaurant', 'BARBECUE_RESTAURANT', 1),
	(23, true, 'Teahouse', 'TEAHOUSE', 1),
	(24, true, 'Tavern', 'TAVERN', 1),
	(25, true, 'Pub', 'PUB', 1),
	(26, true, 'Coffee House', 'COFFEE_HOUSE', 1),
	(27, true, 'Contemporary Casual', 'CONTEMPORARY_CASUAL', 1),
	(28, true, 'Destination Restaurant', 'DESTINATION_RESTAURANT', 1),
	(29, true, 'Teppanyaki Grill', 'TEPPANYAKI_GRILL', 1),
	(30, true, 'Mongolian Barbecue', 'MONGOLIAN_BARBECUE', 1),
	(31, true, 'Family Style', 'FAMILY_STYLE', 1),
	(32, true, 'Dhaba', 'DHABA', 1),
	(33, true, 'Vegetables', 'VEGETABLES', 2),
	(34, true, 'Grains, Beans and Nuts', 'GRAINS_BEANS_NUTS', 2),
	(35, true, 'Meat and Poultry', 'MEAT_POULTRY', 2),
	(36, true, 'Fish and Seafood', 'FISH_SEAFOOD', 2),
	(37, true, 'Dairy Food', 'DAIRY_FOOD', 2),
	(38, true, 'Starchy food', 'STARCHY_FOOD', 2),
	(39, true, 'Appetizers or Starters', 'APPETIZERS_STARTERS', 3),
	(40, true, 'Entrees or Main Course', 'ENTREES_MAIN_COURSE', 3),
	(41, true, 'Side Dishes', 'SIDE_DISHES', 3),
	(42, true, 'Salads', 'SALADS', 3),
	(43, true, 'Soups', 'SOUPS', 3),
	(44, true, 'Sandwiches and Wraps', 'SANDWICHES_WRAPS', 3),
	(45, true, 'Desserts', 'DESSERTS', 3),
	(46, true, 'Beverages', 'BEVERAGES', 3),
	(47, true, 'Specials', 'SPECIALS', 3);
