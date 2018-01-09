<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="update" value="/updateStudentsInfo" />
<c:url var="pdf" value="/showPdfPage" />
<c:url var="index" value="/index.jsp" />

<div class="section">
    <div class = "container">     
        <h2 class="title is-2">Détails du stagiaire ${etudiant.nom}</h2>
        <div class="columns">
            <div class="column">
                <h5 class="subtitle is-5">${message}</h5> 
            </div>
            <div class="column"></div>
            <div class="column"></div>
        </div>
        <form method="POST" action="${update}"> 
            <input class="button is-primary" name="stageid" type="hidden" value="${stage.id}"/>
            <div class="columns">
                <div class="column">
                    <h2 class="title is-4">Description de la mission</h2>
                    <textarea name="description" class="textarea" placeholder="Votre description ici..." rows="10">${stage.descriptionMission}</textarea>
                </div>
                <div class="column">
                    <h2 class="title is-4">Commentaire</h2>
                    <textarea name="commentaire" class="textarea" placeholder="Votre commentaire ici..." rows="10">${stage.commentaire}</textarea>
                </div>           
            </div>
            <div class="columns">
                <div class="column">
                    <p class="control">
                        <a href="${index}" class="button">
                            <span class="icon is-small">
                                <i class="fa fa-chevron-left"></i>
                            </span>
                        <span>Retour</span>
                        </a>
                        <input class="button is-primary" name="updateStudent" type="submit" value="Valider"/>
                        <input class="button is-primary" name="stageid" type="hidden" value="${stage.id}"/>
                        <input class="button is-primary" name="etudiantid" type="hidden" value="${etudiant.id}"/>
                    </p>    
                </div>
                </form>  
                <div class="column">
                    <form method="POST" action="${pdf}"> 
                        <input class="button is-primary" name="showpdf" type="submit" value="Renseigner la fiche de visite"/>
                        <input class="button is-primary" name="stageid" type="hidden" value="${stage.id}"/>
                        <input class="button is-primary" name="etudiantid" type="hidden" value="${etudiant.id}"/>
                    </form>
                </div>
            </div>
            
    </div>
</div>

