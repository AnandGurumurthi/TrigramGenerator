<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<title>Trigram Generator</title>
	</head>
	<body>
		<h1>Trigram Generator</h1>
		What is a Trigram? - Check the wiki	<a href="http://en.wikipedia.org/wiki/Trigram" target="_new">link</a>. <br/><br/> 
		Idea from <a href="http://codekata.pragprog.com/2007/01/kata_fourteen_t.html" target="_new">CodeKata</a>. <br/><br/>
		<a href="trigramgenerator">Try generating a Trigram!</a><br/><br/><br/><br/>
		
		The code can be found <a href="https://github.com/AnandGurumurthi/TrigramGenerator" target="_new">here</a> 
		
		
		<form action="trigramgenerator" method="get">
			<input type="text" name="inputText">
			<input type="submit" value="Submit">
		</form>
		
	</body>
</html>


