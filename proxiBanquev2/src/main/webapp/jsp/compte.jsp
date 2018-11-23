<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Liste des comptes</title>
<%@ include file="head.jsp"%>
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
				
				</div>
				
						<div class="panel panel-default">
			<div class="panel-heading"
				style="background-color: #ccc; padding: 6px; color: #000; align: center;">Informations
				sur le client</div>
			<div class="panel-body">
				<div>
					<label>Nom Client :</label>
					<s:property value="client.nomClient" />
				</div>
				<div>
					<label>Email client :</label>
					<s:property value="client.emailClient" />
				</div>
				<div>
					<label>Adresse Client :</label>
					<s:property value="client.adresseClient" />
				</div>
				<div>
					<label>Téléphone Client :</label>
					<s:property value="client.telClient" />
				</div>
				</div>
		</div>
				
				</div>


	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>Numero</th>
				<th>Solde</th>
				<th>Date ouverture</th>
				<th>Type</th>
				<th>taux</th>
				<th>Découvert</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="listcpte">
				<tr>
					<td><s:property value="numeroCompte" /></td>
					<td><s:property value="solde" /></td>
					<td><s:property value="dateCreation" /></td>
					<td><s:property value="class.simpleName" /></td>
					<td><s:property value="taux" /></td>
					<td><s:property value="decouvert" /></td>
					<s:url action="operation" var="url3">
						<s:param name="idcpte">
							<s:property value="numeroCompte" />
						</s:param>
					</s:url>
					<td><s:a href="%{url3}">consulter</s:a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

</body>
</html>