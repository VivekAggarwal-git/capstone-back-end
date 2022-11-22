package com.vivekCapstone;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.vivekCapstone.model.Users;
import com.vivekCapstone.repository.UsersRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UsersRepositoryTest {

	@Autowired
	private UsersRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		Users users = new Users();
		users.setEmail("ravikumar@gmail.com");
		users.setPassword("ravi202120");
		users.setName("Ravi");
		users.setAccountNo("1231231245");
		users.setMobileNo("9868319241");
		
		Users savedUsers = repo.save(users);
		
		Users existUsers = entityManager.find(Users.class, savedUsers.getEmail());
				
		assertThat(existUsers.getMobileNo()).isEqualTo(users.getMobileNo());
	}
	

	@Test
	public void testFindByName() {
		String name = "Vivek";
		
		Users user = repo.findByName(name);
		
		assertThat(user).isNotNull();
	}
	
}
