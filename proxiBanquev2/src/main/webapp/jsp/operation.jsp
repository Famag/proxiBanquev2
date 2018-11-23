<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<%@ include file="head.jsp"%>

<jq:head />
<script type="text/javascript">
	function getSubForm(typeOperation) {
		var getSubForm;
		getSubForm = typeOperation;
		if (typeOperation == "Virement") {
			//alert(getSubForm);
			//alert("Fama"); 
			$.get("getSubForm?typeOperation=" + getSubForm, function(data) {
				$("#subForm").html(data);
			});
		}
	}
</script>
</head>
<body>
	<div>
		<s:if test="#session.user">
			<i class="glyphicon glyphicon-user"></i>
			<s:property value="#session.user.prenomEmployer" />
			<s:property value="#session.user.nomEmployer" />
			<div style="text-align: right">
				<i class="glyphicon glyphicon-log-out"></i>
				<s:a action="logout">Déconnexion</s:a>
			</div>
		</s:if>
		<s:else>
			<s:a action="login">Connexion</s:a>
		</s:else>
	</div>

	<div class="table-wrapper">
		<div class="table-title">
			<div class="row">
				
				<div class="col-sm-1">
					<s:a href="client.action" class="btn btn-success">Liste des clients</s:a>
					</div>	
				  
				</div>
					</div>
					
				
		<div class="panel panel-default">
			<div class="panel-heading"
				style="background-color: #ccc; padding: 6px; color: #000; align: center;">Opération
				sur le compte</div>
			<div class="panel-body">
				<s:form action="saveoperation">
					<s:label>Compte : </s:label>
					<s:property value="numeroCompte" />
					<s:radio label="Operation sur le compte" name="typeOperation"
						list="typeOp" value="defaultGenderValue"
						onchange="getSubForm(this.value)" />
					<tbody id="subForm"></tbody>
					<s:textfield name="montant" label="Montant" />
					<s:submit value="OK" />
				</s:form>

			</div>

		</div>

		</div>





	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>Num</th>
				<th>Type</th>
				<th>Date</th>
				<th>Montant</th>
				<th>Solde</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="listeop">
				<tr>
					<td><s:property value="numeroOperation" /></td>
					<td><s:property value="class.simpleName" /></td>
					<td><s:property value="dateOperation" /></td>
					<td><s:property value="montant" /></td>
					<td><s:property value="compte.solde" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>


</body>
</html>