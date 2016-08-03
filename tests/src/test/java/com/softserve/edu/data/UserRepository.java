package com.softserve.edu.data;

public class UserRepository {

	private static final String ADMIN_USER_BY_LOGIN = "iva";

	private UserRepository() {
	}

	public static User getAdminUser() {
		return User.get().setLogin(ADMIN_USER_BY_LOGIN).setPassword("qwerty")
				.setName("ivanka").setEmail("mail@gmail.com")
				.setRole("Administrator").build();
	}

	// public static User getAdminUserDB() {
	// AdminService adminService=new AdminService(ADMIN_USER_BY_LOGIN);
	// return
	// User.Create().setLogin(adminService.getLoginUserDB()).setPassword(adminService.getPasswordUserDB())
	// .setName(adminService.getNameUserDB()).setEmail(adminService.getEmailUserDB()).setRole(adminService.getRoleNameUserDB()).build();
	// }

	public static User getInvalidUser() {
		return User.get().setLogin("unknownName1").setPassword("ytrewq")
				.setName("hahaha").setEmail("haha@gmail.com").setRole("ccc")
				.build();
	}

	public static User getNewUser() {
		return User.get().setLogin("aaaa").setPassword("aaaa").setName("aaaa")
				.setEmail("aaaa@gmail.com").setRole("Customer").build();
	}
	
	public static User getTempUser() {
		return User.get().setLogin("loginaaa").setPassword("aaaa").setName("aaaa")
				.setEmail("aaaa@gmail.com").setRole("Customer").build();
	}


	public static User getCustomerUser() {
		return User.get().setLogin("login1").setPassword("qwerty")
				.setName("firstName1").setEmail("mail@gmail.com")
				.setRole("Customer").build();
	}

	public static User getMerchandiserUser() {
		return User.get().setLogin("login2").setPassword("qwerty")
				.setName("firstName2").setEmail("mail@gmail.com")
				.setRole("Merchandiser").build();
	}

	public static User getSupervisorUser() {
		return User.get().setLogin("login3").setPassword("qwerty")
				.setName("firstName3").setEmail("mail@gmail.com")
				.setRole("Supervisor").build();
	}

	public static User getInvalidLoginUser() {
		return User.get().setLogin("unknown").setPassword("qwerty")
				.setName("firstName3").setEmail("mail@gmail.com")
				.setRole("Supervisor").build();
	}

	public static User getInvalidPasswordUser() {
		return User.get().setLogin("login3").setPassword("unknown")
				.setName("firstName3").setEmail("mail@gmail.com")
				.setRole("Supervisor").build();
	}

	public static User getEmptyLoginUser() {
		return User.get().setLogin("").setPassword("qwerty")
				.setName("firstName3").setEmail("mail@gmail.com")
				.setRole("Supervisor").build();
	}

	public static User getEmptyPasswordUser() {
		return User.get().setLogin("login3").setPassword("")
				.setName("firstName3").setEmail("mail@gmail.com")
				.setRole("Supervisor").build();
	}

	public static Card getCardInfo() {
		return Card.get().setCardType("MasterCard").setCardNumber("4149437712342227").setCvv("037")
				.setexpirymonthv("01").setexpiryyear("2017").build();
	}
	
	public static Card getCardNoSuccInfo() {
		return Card.get().setCardType("MasterCard").setCardNumber("414943771234222").setCvv("037")
				.setexpirymonthv("01").setexpiryyear("2017").build();
	}
	public static Card getCardMaestroInfo() {
		return Card.get().setCardType("Maestro").setCardNumber("4149437712342227").setCvv("037")
				.setexpirymonthv("01").setexpiryyear("2017").build();
	}
	
	
	
}