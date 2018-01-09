<c:url var="logout" value="/logout.do" />

<nav class="navbar is-transparent">

  <div id="navbarExampleTransparentExample" class="navbar-menu">
    

    <div class="navbar-end">
        <div class="navbar-item has-dropdown is-hoverable">
            <div class="navbar-item" href="/documentation/overview/start/">
              <span class="icon">
                <i class="fa fa-user"></i>
              </span>
              <span><c:out value="${user.firstname} ${user.lastname}"/></span>  
            </div>
        </div>
      <div class="navbar-item">
        <div class="field">
          <p class="control">
            <a class="button is-danger" href="${logout}">
              <span class="icon">
                <i class="fa fa-sign-out"></i>
              </span>
              <span>Déconnexion</span>
            </a>
          </p>
        </div>
      </div>
    </div>
  </div>
</nav>
