<%@include file="/WEB-INF/Views/jspf/header.jspf" %>

<h3>Resultats</h3>
<hr>
<c:choose>

    <c:when test="${requestScope.books==null}">
        <h5 class="text-danger">Sorry, we didn't find any book with titre ${requestScope.titresearch}</h5>
    </c:when>

    <c:otherwise>

        <div class="row">
            <c:forEach items="${requestScope.books}" var="c">
                <div class="card col-md-3">
                    <img src="${c.avatar==''?'./assets/images/icon-book-generic.jpeg': c.avatar}" class="card-img-top"
                         alt="${c.titre} by ">
                    <div class="card-body">
                        <h5 class="card-title">${c.titre} By </h5>
                        <p class="card-text">${c.resume}</p>
                        <a href="./view-book-details?id=${c.issn}" class="btn btn-link">View details</a>
                    </div>
                </div>
            </c:forEach>
        </div>

    </c:otherwise>

</c:choose>
 
<%@include file="/WEB-INF/Views/jspf/footer.jspf" %>