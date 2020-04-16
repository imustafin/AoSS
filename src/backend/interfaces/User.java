/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.interfaces;

import backend.direct.Departments;

/**
 *
 * @author ilgiz
 */
public interface User {

    /**
     * @return login of the user or null if no access
     */
    public String getLogin();

    /**
     * @return password of the user or null if no access
     */
    public String getPassword();

    /**
     * @return department of the user
     */
    public Departments getDepartmentCode();
}
