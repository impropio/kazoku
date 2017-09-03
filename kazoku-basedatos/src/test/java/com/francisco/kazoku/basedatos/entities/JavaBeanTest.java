package com.francisco.kazoku.basedatos.entities;

import org.junit.Test;

/**
 * The Class JavaBeanTest.
 */
public class JavaBeanTest {

    /**
     * Test.
     *
     * @throws Exception the exception
     */
    @Test
    public void test() throws Exception {
        final String[] empty = new String[0];
        JavaBeanTester.test(Alergia.class, empty);
        JavaBeanTester.test(Ciudad.class, empty);
        JavaBeanTester.test(Configuracion.class, empty);
        JavaBeanTester.test(Email.class, empty);
        JavaBeanTester.test(EmailPK.class, empty);
        JavaBeanTester.test(Garantia.class, empty);
        JavaBeanTester.test(GravedadAlergia.class, empty);
        JavaBeanTester.test(Medidas.class, empty);
        JavaBeanTester.test(Pais.class, empty);
        JavaBeanTester.test(Peso.class, empty);
        JavaBeanTester.test(PesoUsuario.class, empty);
        JavaBeanTester.test(Tarea.class, empty);
        JavaBeanTester.test(Telefono.class, empty);
        JavaBeanTester.test(TelefonoPK.class, empty);
        JavaBeanTester.test(TipoAlergia.class, empty);
        JavaBeanTester.test(Usuario.class, empty);
    }

}
