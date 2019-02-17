<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">

function submitHeader(formAction, sectionNm) {			
	
	document.headerForm.action = "${pageContext.request.contextPath}/" + formAction;
	document.headerForm.submit();				
}
</script>

<body>
<form name="headerForm" method="post" action="">
		<input type="hidden" name="method" id="headerMethod" value=""/>				
</form>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">${userSession.gymNm}</a>
    </div>
    <c:set var="secLst" value="0" />
    <ul class="nav navbar-nav">
	    <c:forEach items="${userSession.accessGroupList}" var="module" varStatus="grpLst">
	        <c:if test="${not((tempId eq module.sectionCode) || (module.sectionCode eq null) || (module.sectionCode eq 'N/A') )}">
	            <li class="dropdown"  title="${module.secToolTipDesc}" id='${module.sectionCode}'>
	                <a class="dropdown-toggle" data-toggle="dropdown" href="#">${module.sectionNm} <span class="caret"></span></a>
                    <c:set var="tempId" value="" />
                      <ul class="dropdown-menu" role="menu"><c:set var="tempModId" value="" />
                          <c:forEach items="${userSession.accessGroupList}" var="modnew" varStatus="d">
                              <c:if test="${modnew.sectionCode eq module.sectionCode}">
                                  <c:if test="${not(modnew.mstModuleCode eq tempModId)}">
                                         <c:choose>
                                             <c:when test="${modnew.searchPath == null}">
                                                 <li title="${modnew.toolTipDesc}">
                                                     <a href="#" >${modnew.mstModuleNm}</a>
                                                 </li>
                                             </c:when>
                                             <c:otherwise>
                                                 <li title="${modnew.toolTipDesc}"><a href="javascript:void(0);" onclick="javascript:submitHeader('${modnew.searchPath}','${module.sectionCode}');">${modnew.mstModuleNm}</a>
                                                 </li>
                                             </c:otherwise>
                                         </c:choose>
                                  </c:if>
                              </c:if>
                              <c:set var="tempModId" value="${modnew.mstModuleCode}" />
                          </c:forEach>
                      </ul>
	            </li>
	        </c:if>
	        <c:set var="tempId" value="${module.sectionCode}" />
	    </c:forEach>
    </ul>	
    <ul class="nav navbar-nav navbar-right">
      <li><a href="gymInfo.do"><span class="glyphicon glyphicon-user"></span> About</a></li>
      <li><a href="/"><span class="glyphicon glyphicon-off"></span> Sign Out</a></li>
    </ul>
  </div>
</nav>

<table>

  
</table>

</body>
</html>
