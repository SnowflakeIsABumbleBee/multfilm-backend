package de.htw_berlin.multfilm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"tmdb.api.key=",
		"tmdb.api.read-access-token=",
		"spring.autoconfigure.exclude=org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration,"
				+ "org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration,"
				+ "org.springframework.boot.data.jpa.autoconfigure.DataJpaRepositoriesAutoConfiguration"
})
class MultfilmApplicationTests {

	@Test
	void contextLoads() {
	}

}
