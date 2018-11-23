<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="%{typeOperation=='Virement'}">
 <s:textfield name="idcpte2"  value="numeroCompte2" label="Vers le Compte"></s:textfield>
</s:if>