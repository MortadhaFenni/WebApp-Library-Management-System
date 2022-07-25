<%@include file="/WEB-INF/Views/jspf/header.jspf" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Auteur details for id ${param.id}</h3>
<hr>

<c:choose>

    <c:when test="${requestScope.auteur==null}">
        <h5 class="text-danger">Sorry, we didn't find any contact with id ${param.id}</h5>
    </c:when>

    <c:otherwise>

        <div class="row">

            <div class="col-md-5">
                <img class="img-thumbnail" src="${auteur.avatar==null ?'./assets/images/default-profile.jpeg': auteur.avatar}" >
            </div>
            <div class="col-md-7">

                <table class="table">

                    <tr>
                        <td>Firstname</td>
                        <td>${auteur.nom}</td>
                    </tr>

                    <tr>
                        <td>Lastname</td>
                        <td>${auteur.prenom}</td>
                    </tr>

                    <tr>
                        <td>Date_naissance</td>
                        <td>${auteur.date_naissance}</td>
                    </tr>
                </table>

                <a href="./edit-and-update-auteur?id=${auteur.id}" class="btn btn-primary">Edit details</a>
                <a href="./delete-auteur?id=${auteur.id}" class="btn btn-outline-danger">Delete this</a>
            </div>
        </div>

    </c:otherwise>

</c:choose>

<%@include file="/WEB-INF/Views/jspf/footer.jspf" %>