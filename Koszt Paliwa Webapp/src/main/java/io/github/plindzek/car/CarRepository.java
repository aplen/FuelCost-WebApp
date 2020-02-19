/**
 * 
 */
package io.github.plindzek.car;

import io.github.plindzek.util.HibernateUtil;

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
		var result = session.createQuery("from cars", Car.class).list();

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
	public Optional<Car> findByName(String name) {

		var session = HibernateUtil.getSessionFactory().openSession();
		var transaction = session.beginTransaction();

		var result = session.get(Car.class, name);
		transaction.commit();
		session.close();
		return Optional.ofNullable(result);

	}
	 Car updateCar(Integer id, String newName) {
		Car result = null;
		var session = HibernateUtil.getSessionFactory().openSession();
		var transaction = session.beginTransaction();
		try {
			result = session.get(Car.class, id);
			result.setName(newName);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		session.close();
		return result;
	}



	Car addCar(Car newCar) {

		var session = HibernateUtil.getSessionFactory().openSession();
		var transaction = session.beginTransaction();

		try {
			session.persist("cars", newCar);

			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
		}
		session.close();

		return newCar;
	}


	void deleteCar(){}

}
