/**
 * 
 */
package io.github.plindzek;

import java.util.List;
import java.util.Optional;

/**
 * ensure CRUD operations for langs
 * 
 * @author Adam
 */
class LangRepository {

    LangRepository() {
    }

    List<Lang> findAll(){
	var session = HibernateUtil.getSessionFactory().openSession();
	var transaction = session.beginTransaction();

	var result = session.createQuery("from Lang", Lang.class).list();

	transaction.commit();
	session.close();
	return (result);
	
    }

    Optional<Lang> findById(Integer id) {

	var session = HibernateUtil.getSessionFactory().openSession();
	var transaction = session.beginTransaction();

	var result = session.get(Lang.class, id);

	transaction.commit();
	session.close();
	return Optional.ofNullable(result);
    }
}
