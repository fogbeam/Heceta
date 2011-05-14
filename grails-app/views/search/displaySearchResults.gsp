<html>
    <head>
        <title>Welcome to Heceta</title>
          <meta name="layout" content="main" />
    </head>
    <body>
          <div class="searchResults" id="searchResults" style="margin-left:35px;padding-top:20px;">
               <g:each in="${searchResults}" var="entry">
               		<div style="padding-top:3px;padding-bottom:3px;">
               			<a href="/heceta1/render/renderEmail?path=${entry}">${entry}</a>
               		</div>     
               </g:each>
          </div> 
    </body>
</html>