<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
   <%@ include file="head.jsp"%>

</head>
<body>

	<div>
		<s:if test="#session.user">
         <i class="glyphicon glyphicon-user"></i>
            <s:property value="#session.user.prenomEmployer" />
			<s:property value="#session.user.nomEmployer" />
			<div style="text-align: right"><i class="glyphicon glyphicon-log-out"></i><s:a action="logout">Déconnexion</s:a></div>		
		</s:if>
		<s:else>
			<s:a action="login">Connexion</s:a>
		</s:else>
	</div>

         <s:actionerror theme="bootstrap"/>
            <s:actionmessage theme="bootstrap"/>
            <s:fielderror theme="bootstrap"/>

		<div class="table-wrapper">		
			<div class="table-title">			
				<div class="row">	
				  <div class="col-sm-1">
					<s:a href="client.action" class="btn btn-success">Liste des clients</s:a>
					</div>	
				  
				</div>
				
				</div>
				
			
			<div>
		<s:if test="!idclient">
			<div style="border: 1px solid #205421">
				<div class="panel-heading"
					style="background-color: #ccc; padding: 6px; color: #000;">Ajouter
					un client / Ouverture d'un compte</div>
					<div class="panel-body spacer">
				     <s:form action="save">                   
					 <s:textfield name="client.nomClient"  label="Nom Prenom" elementCssClass="col-sm-4" />
					 <s:textfield name="client.emailClient" label="Email Client" elementCssClass="col-sm-4"/>
					<s:textfield name="client.adresseClient" label="Adresse Client" elementCssClass="col-sm-4"/>
					<s:textfield name="client.telClient" label="Téléphone" elementCssClass="col-sm-4"/>
				<s:checkbox label="Compte Courant" name="typeCourant"
					value="COURANT" fieldValue="true" elementCssClass="col-sm-4"/>
				<s:checkbox label="Compte Epargne" name="typeEpargne"
					value="EPARGNE" fieldValue="true" />
			
			<s:submit value="save" class="btn btn-success" ></s:submit>
					
			</s:form>
				</div>
		</div>
		</s:if>
	</div>
	
		<div>
		<s:if test="idclient">
		
		<div style="border: 1px solid #205421">
				<div class="panel-heading"
					style="background-color: #ccc; padding: 6px; color: #000;">Modification Client</div>
					<div class="panel-body spacer">
				 <s:form action="update">
				<s:textfield name="client.codeClient" value="%{client.codeClient}"></s:textfield>
				<s:textfield name="client.nomClient" label="Nom Prenom"
					value="%{client.nomClient}" />
					<s:textfield name="client.emailClient" label="Email Client"
					value="%{client.emailClient}" />
				<s:textfield name="client.adresseClient" label="Adresse Client"
					value="%{client.adresseClient}"></s:textfield>
					<s:textfield name="client.telClient" label="Téléphone Client"
					value="%{client.telClient}"></s:textfield>
			      <%-- <s:submit value="save" class="btn btn-success" ></s:submit> --%>
					<s:submit value="update" class="btn btn-success" />
			</s:form>
				</div>
						</div>
		
	</s:if>

	</div>
			
			</div>
			
			
			
			
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Email</th>
						<th>Adress</th>						
						<th>Téléphone</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listclient">
						<tr>
							<td><s:property value="codeClient" /></td>
							<td><s:property value="nomClient" /></td>
							<td><s:property value="emailClient" /></td>
							<td><s:property value="adresseClient" /></td>
							<td><s:property value="telClient" /></td>
							<td>

		                        <s:url action="edit" var="url1">
								<s:param name="idclient">
									<s:property value="codeClient" />
								</s:param>
							     </s:url>
							<td><s:a href="%{url1}" title="Editer"><i class="glyphicon glyphicon-edit"></i></s:a>
						     
							<s:url action="listecpte" var="url2">
								<s:param name="idclient">
									<s:property value="codeClient" />
								</s:param>
							</s:url>
							<s:a href="%{url2}" title="Liste compte"><i class="glyphicon glyphicon-th-list"></i></s:a>
           					</td>
							</tr>
					</s:iterator>
				</tbody>
			</table>
	
</body>
</html>