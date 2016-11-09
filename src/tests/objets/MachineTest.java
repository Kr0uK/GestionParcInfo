package tests.objets;

import application.DAO.DAOMachine;
import application.objets.Composant;
import application.objets.Machine;
import application.tools.LectureRB;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Boris on 03/11/2016.
 */
public class MachineTest {

    private static Validator validator;
    Machine machine = new Machine(1, 1, "kappa", "420 1337", "2016-11-01", 5, "Tablette", "192.168.45.2", false, 1, new ArrayList<Composant>());
    Set<ConstraintViolation<Machine>> constraintViolations = new Set<ConstraintViolation<Machine>>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<ConstraintViolation<Machine>> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(ConstraintViolation<Machine> machineConstraintViolation) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends ConstraintViolation<Machine>> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };
    DAOMachine daoMachine = new DAOMachine();

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Test
    public void checkMachine() throws Exception {
        constraintViolations = validator.validate(machine);
        for (ConstraintViolation<Machine> contraintes : constraintViolations) {
            System.out.println(contraintes.getMessage());
        }

    }

    @Test
    public void setComposant() throws Exception {

    }

    @Test
    public void addComposant() throws Exception {

    }

    @Test
    public void removeComposant() throws Exception {

    }

    @Test
    public void removeAllComposant() throws Exception {

    }

    @Test
    public void estSousGarantie() throws Exception {

    }

    @Test
    public void ipDispo() throws Exception {

        System.out.println(machine.ipDispo());


    }


}