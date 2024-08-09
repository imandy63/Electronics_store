package constants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kongh
 */
public class rolePrivsFunction {
    public static final String GET_ROLES = "TABLE(SYS.GetRoles)";
    public static final String GET_AVAILABLE_PRIVS_BY_ROLE = "SYS.GetAvailablePrivs";
    public static final String GET_UNAVAILABLE_PRIVS_BY_ROLE = "SYS.GetUnavailablePrivs";
    public static final String GET_AVAILABLE_SYS_PRIVS_BY_ROLE = "SYS.GetAvailableSysPrivs";
    public static final String GET_UNAVAILABLE_SYS_PRIVS_BY_ROLE = "SYS.GetUnavailableSysPrivs";
    public static final String GET_ROLE_BY_USER = "SYS.GetUserRoles";
}
