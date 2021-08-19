<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
 	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>

 <div class="container col-md-6" style="padding-right: 0px;padding-left: 0px;">

        <form action="/result" method="POST" class="bg-light p-5"  style="border: 2px solid #900C3F;
        border-radius: 38px;color:#900C3F; opacity: 0.89;">

            <div class="row">
                <div class="form-group col-md-9">
                    <label>Nombre</label>
                    <input type="text" name="nombre" placeholder="Nombre">
                </div>
              
                <div class="form-group col-md-9">
                    <label>Ubicación del Dojo</label>
                    <select class="form-select" aria-label="Default select example" name="ubicacion" onchange="selecPerfil()" required>
                    <option selected></option>
                    <option value="Concepcion">Concepción</option>
                    <option value="Santiago">Santiago</option>
                    <option value="Temuco">Temuco</option></select>
                    </select>
                </div>
                  <div class="form-group col-md-9">
                    <label>Lenguaje Favorito</label>
                    <select class="form-select" aria-label="Default select example"name="lenguaje" onchange="selecPerfil()" required>
                    <option selected></option>
                    <option value="Java">Java</option>
                    <option value="Python">Python</option>
                    <option value="C++">C++</option></select>
                    </select>
                </div>
                <p>Comentarios(adicional)</p>
<textarea name="comentario" id="w3review" name="w3review" rows="4" cols="50">
 
  </textarea>

              

                
                <br><button style="background-color: #900C3F; margin-top: 20px;text-align: center;" type="submit " class="btn btn-primary ">Ingresar</button>
        </form>
        </div>

</body>

</html>



 