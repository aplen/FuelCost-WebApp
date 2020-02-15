/**
 *
 */
package io.github.plindzek.lang;

import io.github.plindzek.HibernateUtil;

import java.util.List;
import java.util.Optional;

/**
 * ensure CRUD operations for langs
 *
 * @author Adam
 */
public class LangRepository {

    public LangRepository() {
    }

    List<Lang> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        /*
         *does not contain pure SQL query, but Hibernate Query language/JPAQL
         * it uses entity names than table names. if entity is not named in @Entity annotation,
         * it uses class name
         */
        var result = session.createQuery("from Lang", Lang.class).list();

        transaction.commit();
        session.close();
        return (result);

    }

   public Optional<Lang> findById(Integer id) {

        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.get(Lang.class, id);

        transaction.commit();
        session.close();
        return Optional.ofNullable(result);
    }
}
