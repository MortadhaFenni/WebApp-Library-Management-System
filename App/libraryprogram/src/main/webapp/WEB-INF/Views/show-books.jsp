<%@ include file="/WEB-INF/Views/jspf/header.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>List of all Books</h3>
<hr>

<div class="row">
    <c:forEach items="${requestScope.books}" var="c">
        <div class="card col-md-3">
            <img src="${c.avatar==''?'./assets/images/default-profile.jpeg': c.avatar}" class="card-img-top"
                 alt="${c.titre} by ">
            <div class="card-body">
                <h5 class="card-title">${c.titre} By </h5>
                <p class="card-text">${c.resume}</p>
                <a href="./view-book-details?id=${c.issn}" class="btn btn-link">View details</a>
            </div>
        </div>
    </c:forEach>
</div>

<%@ include file="/WEB-INF/Views/jspf/footer.jspf" %>