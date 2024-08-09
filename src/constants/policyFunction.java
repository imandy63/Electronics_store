/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constants;

/**
 *
 * @author kongh
 */
public class policyFunction {
    public static final String AUDIT_LOG = "TABLE(SYS.GetAuditLog)";
    public static final String POLICIES = "TABLE(SYS.GetUnifiedAuditLogs)";
    public static final String ENABLED_POLICIES = "TABLE(SYS.GetUnifiedEnabledAuditLogs)";
    public static final String POLICY_BY_NAME = "GetUnifiedAuditPolicyByName";
}
