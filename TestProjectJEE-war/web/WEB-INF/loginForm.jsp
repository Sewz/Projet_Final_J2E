<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="login" value="/login.do" />

<section class="section">
    <div class="container">
        <h1>Connexion</h1>
        <p><c:out value="${message}" default="Identifiez-vous :"/></p>
        <form method="POST" action="${login}"> 
            <div class="columns">
                <div class="column">
                    
                    <div class="field">
                        <p class="control is-expanded has-icons-left">
                          <input name="name" class="input" type="text" placeholder="Name">
                          <span class="icon is-small is-left">
                            <i class="fa fa-user"></i>
                          </span>
                        </p>
                    </div>
                    <div class="field">
                      <p class="control has-icons-left">
                        <input class="input" name="password" type="password" placeholder="Password">
                        <span class="icon is-small is-left">
                          <i class="fa fa-lock"></i>
                        </span>
                      </p>
                    </div>
                    <div class="field">
                      <p class="control">
                          <input class="button is-primary" name="Valider" type="submit" value="Login"/>
                      </p>
                    </div>
                </div>
                
                <div class="column">
                </div>
                
                <div class="column">
                </div>
            </div>
        </form>
    </div>
</section>

    