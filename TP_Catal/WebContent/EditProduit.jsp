<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "content-Type" content = "text/html; charset=ISO-8859-1">
<title>Produits</title>
<link rel = "stylesheet" type = "text/css" href = "css/bootstrap.min.css"/>
</head>
<body>
<%@include  file = "Header.jsp"%>
<div class = "container col-md-8 col-md-offset-2">
	<div class = "panel panel-primary">
		<div class = "panel-heading">Edit d'un produit</div>
		<div class = "panel-body">
			<form action = "updateProduit.php", method = "post">
			<div class="form-group">
					<label class = "control-label">ID</label>
					<input type = "hidden" name = "id" value = "${produit.id}" class="form-control" required="required"/>
					<label>${produit.id}</label>
					<span></span>
				</div>
				
				<div class="form-group">
					<label class = "control-label">Désignation</label>
					<input type = "text" name = "designation" value = "${produit.designation}" class="form-control" required="required"/>
					<span></span>
				</div>
				
				<div class="form-group">
					<label class = "control-label">Prix</label>
					<input type = "text" name = "prix" value = "${produit.prix}" class="form-control" required="required"/>
					<span></span>
				</div>
				
				<div class="form-group">
					<label class = "control-label">Quantité</label>
					<input type = "text" name = "quantite" value = "${produit.quantite}" class="form-control" required="required"/>
					<span></span>
				</div>
				
				<div class="form-group">
					<button type = "submit" class = "btn btn-primary">Update</button>
				</div>
				
			</form>
		</div>
	</div>
</div>
</body>
</html>