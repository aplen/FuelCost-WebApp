/**
 * 
 */
package io.github.plindzek;

import java.util.Optional;

/**
 * @author Adam
 *
 */
public class CarRepository {

    Optional<Car> findById(Integer id) {

	var session = HibernateUtil.getSessionFactory().openSession();
	var transaction = session.beginTransaction();

	var result = session.get(Car.class, id);
	transaction.commit();
	session.close();
	return Optional.ofNullable(result);

    }
}
