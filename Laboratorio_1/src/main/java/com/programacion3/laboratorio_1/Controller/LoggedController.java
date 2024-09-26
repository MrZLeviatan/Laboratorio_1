package com.programacion3.laboratorio_1.Controller;

public class LoggedController {

// -------------------- ModelFactory --------------------

    ModelFactory modelFactoryController;

    // ModelFactory Instance.
    public LoggedController(){ modelFactoryController = ModelFactory.getInstance();
    }


    /**
     * Method that connects to the method to authenticate the Login.
     * @param username
     * @param correo
     * @return int
     */
    public int autentificador(String username, String correo){
        return modelFactoryController.auntentificador(username,correo);
    }

}
