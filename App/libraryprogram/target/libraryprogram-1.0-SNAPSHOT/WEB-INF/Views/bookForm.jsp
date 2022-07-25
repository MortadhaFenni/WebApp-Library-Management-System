<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/Views/jspf/header.jspf" %>

<h3>Add new Book details </h3>
<hr>

<form method="POST">


    <div class="form-group row">
        <label for="issn" class="col-md-4">ISSN</label>
        <div class="col-md-4">
            <input type="number" class="form-control" name="issn" id="issn" value="${book.issn}">
            <div class="text-danger">${errors.issn}</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="titre" class="col-md-4">Titre</label>
        <div class="col-md-4">
            <input type="text" class="form-control" name="titre" id="titre" value="${book.titre}">
            <div class="text-danger">${errors.titre}</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="resume" class="col-md-4">Resumé</label>
        <div class="col-md-4">
            <textarea  class="form-control" name="resume" id="resume" value="${book.resume}" rows="8" cols="50"></textarea>
            <div class="text-danger">${errors.resume}</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="nbpages" class="col-md-4">nb Pages</label>
        <div class="col-md-4">
            <input type="number" class="form-control" name="nbpages" id="nbpages" value="${book.nbpages}">
            <div class="text-danger">${errors.nbpages}</div>
        </div>
    </div>
    <div class="form-group row">
        <label for="domaine" class="col-md-4">Genre</label>
        <div class="col-md-4">

            <select class="form-control" name="domaine" id="domaine" >
                <option value="-1">Set domaine</option>
                <optgroup label="Arts">
                    <option value="1">Architecture</option>
                    <option value="2">Histoire de lart</option>
                    <option value="3">Histoire de lart</option>
                    <option value="4">Danse</option>
                    <option value="5">Design</option>
                    <option value="6">Mode</option>
                    <option value="7">Film</option>
                    <option value="8">Design graphique</option>
                    <option value="9">Musique</option>
                    <option value="10">Solfège</option>
                    <option value="11">Peinture</option>
                    <option value="12">Photographie</option>
                </optgroup>
                <optgroup label="Manuel">
                    <option>Science</option>
                    <option>Chimie</option>
                    <option value="77">Informatique</option>
                    <option>Physique</option>
                    <option>Langue anglaise</option>
                </optgroup>
            </select>
            <div class="text-danger">${errors.genre}</div>
        </div>
    </div>


    <div class="form-group row">
        <label for="auteurID" class="col-md-4">auteurs</label>
        <div class="col-md-4">
            <select name="auteurID" id="auteurID">
                <option value="-1">Select Auteur</option>
                <c:forEach items="${auteurs}" var="auteur">
                    <option value="${auteur.id}">${auteur.nom} ${auteur.prenom}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="form-group row">
        <label for="avatar" class="col-md-4">Avatar</label>
        <div class="col-md-8">
            <input type="file"  accept="image/jpg, image/jpeg" class="form-control" name="avatar" id="avatar" value="${book.avatar}">
            <div class="text-danger">${errors.avatar}</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="file" class="col-md-4">File</label>
        <div class="col-md-4">
            <input type="file" class="form-control" name="file" id="file" value="${book.file}" accept="application/pdf">
            <div class="text-danger">${errors.file}</div>
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

<%@ include file="/WEB-INF/Views/jspf/footer.jspf" %>