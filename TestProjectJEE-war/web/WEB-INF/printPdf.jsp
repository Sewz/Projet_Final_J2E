<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="updateStudent" value="/updateStudent.do" />
<c:url var="printPdf" value="/printPdf.do" />

<div class="section">
    <div class="container">
        <h1 class="title">Téléchargement du PDF récapitulatif</h1>
        
        
        
            
            <form method="POST" action="${printPdf}"> 
                
                <div class="field">
                    <label class="label">Titre</label>
                    <div class="control">
                        <input name="titre" class="input" type="text">
                    </div>
                </div>
                
                <div class="field">
                    <textarea name="bilan" class="textarea" placeholder="Votre bilan ici..." rows="5"></textarea>
                </div>
                
                <div class="field">
                    <textarea name="positif" class="textarea" placeholder="Points positifs" rows="5"></textarea>
                </div>
                
                <div class="field">
                    <textarea name="axe" class="textarea" placeholder="Axes positifs" rows="5"></textarea>
                </div>
                
                <div class="field">
                    <label class="label">Voix entreprise</label>
                    <div class="control">
                        <input name="voixEntreprise" class="input" type="text">
                    </div>
                </div>
                
                <div class="field">
                    <label class="label">Date</label>
                    <div class="control">
                        <input name="date" class="input" type="text">
                    </div>
                </div>
                
                <div class="field">
                    <label class="label">Durée</label>
                    <div class="control">
                        <input name="duree" class="input" type="text">
                    </div>
                </div>
                
                <div class="field">
                    <label class="label">Entrez votre url pour le pdf</label>
                    <div class="control">
                        <input name="pdf" class="input" type="text">
                    </div>
                </div>
                
                
                
                <div class="field">
                    <input class="button is-danger" type="submit" name="action" value="Valider">
                    <input type="hidden" name="stageid" value="${stage.id}">
                    <input type="hidden" name="etudiantid" value="${stage.etudiantId}">
                </div>
            </form>
                
            <div class="field">
                <form method="POST" action="${updateStudent}"> 
                    <input class="button is-info" type="submit" name="action" value="Details">
                    <input type="hidden" name="stageid" value="${stage.id}">
                    <input type="hidden" name="etudiantid" value="${stage.etudiantId}">
                </form>
            </div>
        </p>
    </div>
</div>
