package java8.ex03;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.List;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.*;

/**
 * Exercice 03 - MÃ©thode statique
 */
public class Method_03_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        // TODO crÃ©er une mÃ©thode statique IDao getDefaultInstance()
        // TODO cette mÃ©thode retourne une instance de la classe DaoA
        
      static   IDao getDefaultInstance(){
    	
    	  return  new Method_03_Test().new DaoA() ;
      }
    }
    // end::IDao[]

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

    }

    @Test
    public void test_getDefaultInstance() throws Exception {
        // TODO invoquer la mÃ©thode getDefaultInstance() pour que le test soit passant
        IDao result = IDao.getDefaultInstance();

        assertThat(result.findAll(), hasSize(20));
    }
}
