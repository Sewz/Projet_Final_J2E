<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="addStudent" value="/addStudent.do" />
<c:url var="updateStudent" value="/updateStudent.do" />

<section class="section">
    <div class="container">
        
        <div class="columns">
            <div class="column">
                <h5 class="subtitle is-5">${message}</h5> 
            </div>
            <div class="column"></div>
            <div class="column"></div>
        </div>
        
        <c:choose>
        <c:when test="${stages == null}">
            <p>Aucun stagiaire ne vous a été affecté!
            Contactez le service des stages.</p>
            </c:when>    
            <c:otherwise>   
            <form method="POST" action="${updateStudent}"> 
                <table class="table custom-table">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th><abbr title="Groupe">Gr</abbr></th>
                            <th>Nom</th>
                            <th>CdC</th>
                            <th>FICHE VISITE</th>
                            <th><abbr title="Fiche évaluation">FICHE EVAL ENTR</abbr></th>
                            <th>SONDAGE WEB</th>
                            <th>RAPPORT RENDU</th>
                            <th><abbr title="Soutenance">SOUT.</abbr></th>
                            <th>PLANIF</th>
                            <th>FAITE</th>
                            <th>DEBUT</th>
                            <th>FIN</th>
                            <!--<th><abbr title="Entr">ENTR.</abbr></th>-->
                            <th>MdS</th>
                            <th>ADRESSE</th>
                            <th><abbr title="Note technique">NOTE TECH</abbr></th>
                            <th><abbr title="Note communication">NOTE COM</abbr></th>
                        </tr>    
                    </thead>
                    <tbody>
                        <c:forEach var="stage"  items="${stages}" >
                        <tr>
                                <td>
                                    <input type="radio" name="choixStage" value="${stage.id}">
                                </td>
                                <td>
                                    <input name="groupe_${stage.id}" value="${stage.groupe}" class="input is-rounded" type="text">
                                </td>
                                <td>
                                    <p>${stage.nomEtudiant}</p>
                                </td>
                                <td>
                                    <input type="checkbox" name="cdc_${stage.id}" value="cdc"<c:if test = "${stage.cdc == true}">checked</c:if>>                  
                                </td>
                                <td>
                                    <input type="checkbox" name="fichevisite_${stage.id}" value="fichevisite"<c:if test = "${stage.ficheVisite == true}">checked</c:if>>
                                </td>
                                <td>
                                    <input type="checkbox" name="ficheeval_${stage.id}" value="ficheeval"<c:if test = "${stage.ficheEval == true}">checked</c:if>>
                                </td>
                                <td>
                                    <input type="checkbox" name="sondageweb_${stage.id}" value="sondageweb"<c:if test = "${stage.sondageWeb == true}">checked</c:if>>
                                </td>
                                <td>
                                    <input type="checkbox" name="rapportrendu_${stage.id}" value="rapportrendu"<c:if test = "${stage.rapportRendu == true}">checked</c:if>>
                                </td>
                                <td>
                                    <input type="checkbox" name="soutenance_${stage.id}" value="soutenance"<c:if test = "${stage.soutenance == true}">checked</c:if>>
                                </td>
                                <td>
                                    <input type="checkbox" name="visiteplanif_${stage.id}" value="visiteplanif"<c:if test = "${stage.visitePlanif == true}">checked</c:if>>
                                </td>
                                <td>
                                    <input type="checkbox" name="visitefaite_${stage.id}" value="visitefaite"<c:if test = "${stage.visiteFaite == true}">checked</c:if>>
                                </td>
                                <td>
                                    <input name="datedebut_${stage.id}" value="${stage.dateDebut}" class="input is-rounded" type="text">
                                </td>
                                <td>
                                    <input name="datefin_${stage.id}" value="${stage.dateFin}" class="input is-rounded" type="text">
                                </td>
                                <td>
                                    <input name="maitrestage_${stage.id}" value="${stage.maitreStage}" class="input is-rounded" type="text">
                                </td>
                                <td>
                                    <input name="adresse_${stage.id}" value="${stage.adresse}" class="input is-rounded" type="text">
                                </td>
                                <td>
                                    <input name="notetech_${stage.id}" value="${stage.noteTech}" class="input is-rounded" type="text">
                                </td>
                                <td>
                                    <input name="notecom_${stage.id}" value="${stage.noteCom}" class="input is-rounded" type="text">
                                </td>
                                 <input name="stageid" value="${stage.id}" class="input is-rounded" type="hidden">
                                 <input name="etudiantid" value="${stage.etudiantId}" class="input is-rounded" type="hidden">

                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                
                <div class="columns">
                    <div class="column">
                        <input class="button is-info" type="submit" name="action" value="Details">
                        <input class="button is-primary" type="submit" name="action" value="Valider">
                    </div>
                    <div class="column">
                        <a href="${addStudent}" class="button is-link">Ajouter</a>
                    </div>
                    <div class="column"></div>
                    <div class="column"></div>
                </div>

            </form>
            </c:otherwise>
        </c:choose>
        
        
        
        
        
        
        
        
        
    </div>
</section>




