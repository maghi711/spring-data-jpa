package com.maghi711.springbootjpa.product;

import com.maghi711.springbootjpa.product.entities.Product;
import com.maghi711.springbootjpa.product.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringBootJpaApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
		String name = null;
		assertThat(name).isNull();
	}

	@Test
	void testCreate() {
		Product product = new Product();
		product.setId(2L);
		product.setName("Vivo z1Pro");
		product.setDesc("Online only release phone");
		product.setPrice(16000.000);

		final Product save = productRepository.save(product);
		assertThat(save).isNotNull();
		/**
		 * 2022-01-27 22:04:56.103  INFO 13035 --- [    Test worker] c.m.b.SpringBootJpaApplicationTests      : Started SpringBootJpaApplicationTests in 3.981 seconds (JVM running for 5.375)
		 * Hibernate: select product0_.id as id1_0_0_, product0_.description as descript2_0_0_, product0_.name as name3_0_0_, product0_.price as price4_0_0_ from product product0_ where product0_.id=?
		 * Hibernate: insert into product (description, name, price, id) values (?, ?, ?, ?)
		 * 2022-01-27 22:04:56.336  INFO 13035 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
		 */
	}

	@Test
	void testRead() {
		final Optional<Product> byId = productRepository.findById(1L);
		assertThat(byId).isNotNull();
		final Product actual = byId.get();
		assertThat(actual.getName()).isEqualTo("Mi A1");
	}

	@Test
	void testUpdate() {
		final Optional<Product> byId = productRepository.findById(1L);
		final Product actual = byId.get();
		actual.setPrice(16500.000);
		final Product save = productRepository.save(actual);
		assertThat(save).isNotNull();
	}

	@Test
	void testDelete() {
		productRepository.deleteById(2L);

		String name = null;
		assertThat(name).isNull();
	}

	@Test
	void testExistsById() {
		final boolean b = productRepository.existsById(1L);
		assertThat(b).isTrue();
	}

	@Test
	void testRecordCount() {
		final long count = productRepository.count();
		assertThat(count).isGreaterThanOrEqualTo(0);
	}
}
