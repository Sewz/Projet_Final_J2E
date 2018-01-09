<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:url var="index" value="/index.jsp" />
<c:url var="addStudent" value="/addStudent.do" />

<div class="section">
    <div class="container">
        
        
        <h1 class="title">Choisisez un élève parmi la liste</h1>  
        
        <div class="columns">
            <div class="column">
                <h5 class="subtitle is-5">${message}</h5> 
            </div>
            <div class="column"></div>
            <div class="column"></div>
        </div>
        
        <form method="POST" action="${addStudent}">
            <div class="field">
                <div class="select is-multiple">
                    <select name="choixEtu" multiple size="${fn:length(etudiants)}">
                      <c:forEach var="etudiant"  items="${etudiants}" >
                        <option name="${etudiant.id}" value="${etudiant.id}">
                            ${etudiant.nom}
                        </option>             
                      </c:forEach>
                    </select>
                </div>
            </div>
            <div class="field is-grouped">        
                <p class="control">
                    <a href="${index}" class="button">
                        <span class="icon is-small">
                            <i class="fa fa-chevron-left"></i>
                        </span>
                    <span>Retour</span>
                    </a>
                    <input class="button is-primary" name="action" type="submit" value="Valider"/>
                </p>        
            </div>
            
        </form>

        
</div>  