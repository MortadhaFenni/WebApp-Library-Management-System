<%@ include file="jspf/header.jspf" %>

<h3>Add new auteur details </h3>
<hr>

<form method="POST">


    <div class="form-group row">
        <label for="firstname" class="col-md-4">Firstname</label>
        <div class="col-md-4">
            <input type="text" class="form-control" name="firstname" id="firstname" value="${auteur.firstname}">
            <div class="text-danger">${errors.firstname}</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="lastname" class="col-md-4">Lastname</label>
        <div class="col-md-4">
            <input type="text" class="form-control" name="lastname" id="lastname" value="${auteur.lastname}">
            <div class="text-danger">${errors.lastname}</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="datebirth" class="col-md-4">date-naissance</label>
        <div class="col-md-8">
            <input type="date" value="${auteur.datebirth}" class="form-control" name="datebirth" id="datebirth" >
            <div class="text-danger">${errors.address}</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="avatar" class="col-md-4">Avatar</label>
        <div class="col-md-8">
            <input type="text" class="form-control" name="avatar" id="avatar" value="${auteur.avatar}">
            <div class="text-danger">${errors.avatar}</div>
        </div>
    </div>

     

    <div class="form-group row">
        <label class="col-md-4"></label>
        <div class="col-md-8">
            <button class="btn btn-primary">Save details</button>
            <input type="reset" class="btn btn-link" value="Reset">
        </div>
    </div>

</form>

<%@ include file="jspf/footer.jspf" %>