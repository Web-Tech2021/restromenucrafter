INSERT INTO `user` VALUES 
	(1,now(),null,now(),null,true,'nirmalakumarsahu7@gmail.com','Nirmala','Sahu',NULL,'$2a$10$n/ACAbYelLw4Mt3Id2LrZ.QzyaXsb3Ywt0Q9NrnvFajKFAGnZKvQO',NULL,NULL, NULL, 'active','b77d9d79-a16c-4582-9b51-500ba8378205'),
	(2,now(),null,now(),null,true,'support.restromenucrafters@gmail.com','Support','Restro Menu Crafters',NULL,'$2a$10$N1LVoZFgZER54eprPMnN2.ayMiYnHxn.c8x8522t7OYyO9dvJdPqS',NULL,NULL, NULL, 'active','94d81b2b-20f6-4561-9249-06f03acf7fc4');

INSERT INTO `role` VALUES 
	(1, now(),1,now(),1,true,'GLOBAL ADMIN'),
    (2, now(),1,now(),1,true,'RESTRO ADMIN'),
    (3,now(),1,now(),1,true,'USER');

INSERT INTO `role_user` VALUES (1,1);

INSERT INTO `permission` VALUES 
	(1,now(),1,now(),1,true,NULL,'GLOBAL_ADMINISTRATION'),
    (2,now(),1,now(),1,true,NULL,'VIEW_RESTRO'),
    (3,now(),1,now(),1,true,NULL,'ADD_RESTRO'),
	(4,now(),1,now(),1,true,NULL,'EDIT_RESTRO'),
	(5,now(),1,now(),1,true,NULL,'DELETE_RESTRO'),
	(6,now(),1,now(),1,true,NULL,'VIEW_MENU'),
	(7,now(),1,now(),1,true,NULL,'ADD_MENU'),
	(8,now(),1,now(),1,true,NULL,'EDIT_MENU'),
	(9,now(),1,now(),1,true,NULL,'DELETE_MENU');

INSERT INTO `role_permission` VALUES (1,1);