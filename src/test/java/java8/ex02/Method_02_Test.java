package java8.ex02;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {package java8.ex02;

import java8.data.Data;
import java8.data.Person;
import java8.ex02.Method_02_Test.IDao;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

/**
 * Exercice 02 - RedÃ©finition
 */
public class Method_02_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        // TODO crÃ©er une mÃ©thode String format()
        // TODO la mÃ©thode retourne une chaÃ®ne de la forme [<nb_personnes> persons]
        // TODO exemple de rÃ©sultat : "[14 persons]", "[30 persons]"
        
        public default String format(){
        	
        		return "["+this.findAll().size()+ "persons]" ;
        	}
        }
    
    // end::IDao[]

    // tag::DaoA[]
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        // TODO redÃ©finir la mÃ©thode String format()
        // TODO la mÃ©thode retourne une chaÃ®ne de la forme DaoA[<nb_personnes> persons]
        // TODO exemple de rÃ©sultat : "DaoA[14 persons]", "DaoA[30 persons]"
        // TODO l'implÃ©mentation rÃ©utilise la mÃ©thode format() de l'interface
       
        public  String format() {
        	
    		return "DaoA["+this.findAll().size()+" "+"persons]" ;
    	}
    }
    
    // end::DaoA[]

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la mÃ©thode format() pour que le test soit passant
        String result = daoA.format();

        assertThat(result, is("DaoA[20 persons]"));
    }
}


    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        // TODO créer une méthode String format()
        // TODO la méthode retourne une chaîne de la forme [<nb_personnes> persons]
        // TODO exemple de résultat : "[14 persons]", "[30 persons]"
    }
    // end::IDao[]

    // tag::DaoA[]
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        // TODO redéfinir la méthode String format()
        // TODO la méthode retourne une chaîne de la forme DaoA[<nb_personnes> persons]
        // TODO exemple de résultat : "DaoA[14 persons]", "DaoA[30 persons]"
        // TODO l'implémentation réutilise la méthode format() de l'interface

    }
    // end::DaoA[]

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la méthode format() pour que le test soit passant
        String result = null;

        assertThat(result, is("DaoA[20 persons]"));
    }
}
