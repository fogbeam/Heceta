<!DOCTYPE html>
<html>
    <head>
        <title>
        	<g:layoutTitle default="Heceta" />
        </title>
        <nav:resources />
        <link rel="stylesheet" type="text/css" href="/heceta1/css/main.css">
        <link rel="stylesheet" type="text/css" href="/heceta1/css/reset-min.css">
        <link rel="stylesheet" type="text/css" href="/heceta1/css/fonts-min.css">             
        <link rel="stylesheet" type="text/css" href="/heceta1/css/grids-min.css">
        
        <g:layoutHead />
        <g:javascript library="prototype" /> 
        <g:javascript library="scriptaculous" />
        <g:javascript library="application" />
    
    </head>
    
    <body>
          <div id="doc3" class="yui-t4">
              <div id="hd">
                    
                    <!-- TODO: replace this with a template gsp -->
                    
                    <!-- header -->
                    <div style="background-color:#cfe3ff;height:65px;" >
                         
                         <center>
                              <h1 style="font-size:15pt;">Welcome to Heceta</h1>
                         </center>
                         
                         <!-- nav -->
                         <div style="position:relative;margin-left:150px;">
                              <ul class="navigation" id="navigation_tabs">
                                   
                                   
                                   <li class="navigation_active navigation_first">
                                        
                                   </li>
                                   <li class="navigation_active">
  	                                 <a href="/heceta1/">Home</a> 
                                   </li>
                                   <li class="navigation_active">
                                        <a href="/heceta1/home/advancedSearch">Advanced Search</a> 
                                   </li>
                                   <li class="navigation_active">
                                   	<a href="/heceta1/home/explore">Explore</a> 
                                   </li>
                                   <li class="navigation_active"><a href="/heceta1/admin/index">Admin</a></li>
                                   <li style="float:right;margin-right:100px;">
                                        <g:if test="${session.user}">
                                         <a href="/heceta1/userHome/index/${session.user.userId}">${session.user.userId}</a>
                                        </g:if>
                                   </li>
                              </ul>

                         </div>

                    </div>
               </div> 
  
               <div id="bd">
                     <div id="yui-main">
                         <div class="yui-b">
                              
                              <!-- layout main content area -->
                              <g:layoutBody />             
                                    
                         </div>
                     </div>
                     <div class="yui-b">
                     
                         <!-- layout sidebar -->
                         <g:render template="/sidebar" />
                     
                     </div>
               </div> 
               
               <div id="ft">
                    
                    <!-- TODO: replace this with a template gsp -->
                    
                    <!-- footer -->
                    <div>
                    <!-- scratch this for now
                         <center>Footer for Heceta</center>
					-->
                    </div>
               </div> 
          </div>   
    </body>

</html>