
<g:if test="${session.user}">
     <div style="padding-top:25px;">               
          <a href="/heceta1/login/logout">Logout</a>
     </div>                         
</g:if>
<g:else>
     <div style="padding-top:25px;">               
          <a href="/heceta1/login">Login</a>
     </div>
     <div style="padding-top:25px;">               
          <a href="/heceta1/user/create">Register</a>
     </div>
</g:else>