/**
 * 
 */
package io.github.plindzek.car;

import io.github.plindzek.HibernateUtil;
import io.github.plindzek.car.Car;
import io.github.plindzek.lang.Lang;

import java.util.List;
import java.util.Optional;

/**
 * @author Adam
 * contain methods to execute CRUD operations on car table
 *
 */
public class CarRepository {

	List<Car> findAll() {
		var session = HibernateUtil.getSessionFactory().openSession();
		var transaction = session.beginTransaction();
		var result = session.createQuery("from Car", Car.class).list();

		transaction.commit();
		session.close();
		return (result);

	}


    Optional<Car> findById(Integer id) {

	var session = HibernateUtil.getSessionFactory().openSession();
	var transaction = session.beginTransaction();

	var result = session.get(Car.class, id);
	transaction.commit();
	session.close();
	return Optional.ofNullable(result);

    }
}
