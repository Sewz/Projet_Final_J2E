<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="index" value="/index.jsp" />

<div class="section">
    <div class="container">
        <h1 class="title"><c:out value="${message}"/></h1>
        <p class="control">
            <a href="${index}" class="button">
              <span class="icon is-small">
                <i class="fa fa-chevron-left"></i>
              </span>
              <span>Retour</span>
            </a>
        </p>
    </div>
</div>