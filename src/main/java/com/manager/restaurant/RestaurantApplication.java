package com.manager.restaurant;

import com.manager.restaurant.model.Role;
import com.manager.restaurant.model.User;
import com.manager.restaurant.model.menu.Menu;
import com.manager.restaurant.model.menu.MenuGroup;
import com.manager.restaurant.model.menu.MenuItem;
import com.manager.restaurant.repository.MenuGroupRepository;
import com.manager.restaurant.repository.MenuItemRepository;
import com.manager.restaurant.repository.MenuRepository;
import com.manager.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

@SpringBootApplication
//public class RestaurantApplication {
public class RestaurantApplication implements CommandLineRunner {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Autowired
	private MenuGroupRepository menuGroupRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		MenuItem menuItem1 = MenuItem.builder()
				.name("Lasagne")
				.description("Delicious Lasagne").price(300.0).build();

		MenuItem menuItem2 = MenuItem.builder()
				.name("Pasta")
				.description("Delicious Pasta").price(250.0).build();

		MenuItem menuItem3 = MenuItem.builder()
				.name("Chicken Pizza")
				.description("Delicious Chicken Pizza").price(450.0).build();

		MenuItem menuItem4 = MenuItem.builder()
				.name("Vegetable Pizza")
				.description("Delicious Vegetable Pizza").price(350.0).build();

		menuItemRepository.saveAll(List.of(menuItem1, menuItem2, menuItem3, menuItem4));

		MenuGroup continental = MenuGroup.builder().name("Continental").description("Exquisite Continental").menuItems(new HashSet<>(List.of(menuItem1, menuItem2))).build();
		MenuGroup pizza = MenuGroup.builder().name("Pizza").description("Yummilicious Pizza").menuItems(new HashSet<>(List.of(menuItem3, menuItem4))).build();
		menuGroupRepository.saveAll(List.of(continental, pizza));

		Menu menu = Menu.builder().description("Yummy menu").menuGroups(new HashSet<>(List.of(continental, pizza))).build();
		menuRepository.save(menu);


		userRepository.save(new User("Siddhant", "Shaw", "siddhantshaw97@gmail.com", passwordEncoder.encode("S@1"), new HashSet<>(List.of(Role.ADMIN, Role.CUSTOMER))));
		userRepository.save(new User("Ritesh", "Jain", "sid97jin@gmail.com",  passwordEncoder.encode("S@2"), new HashSet<>(List.of(Role.CUSTOMER))));
	}
}
