/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constants;

/**
 *
 * @author kongh
 */
public class sessionFunction {
    public static final String GET_ALL_SESSIONS = "TABLE(SYS.GetAllSessions)";
    public static final String GET_NOT_BACKGROUND = "TABLE(SYS.GetNotBackgroundSessions)";
    public static final String GET_BLOCKING_SESSION = "TABLE(SYS.GetBlockingSessions)";
    public static final String GET_SESSIONS_BY_USER = "SYS.GetSessionsByUsename";
    public static final String GET_TOTAL_SESSION = "SYS.GetTotalSession";
    public static final String GET_PROCESS_OF_SESSION = "TABLE(SYS.GetProcessesOfSession)";
}
