/**
 * 
 */
package io.github.plindzek;

import java.util.Optional;

/**
 * ensure CRUD operations for langs
 * 
 * @author Adam
 */
class LangRepository {

    LangRepository() {
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
